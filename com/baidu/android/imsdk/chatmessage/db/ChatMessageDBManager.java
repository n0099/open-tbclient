package com.baidu.android.imsdk.chatmessage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.SessionClass;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ChatMessageDBManager extends DBBase {
    private static final long CAST_RELIABLE_MSG_EXPIRED_TIME = 172800;
    private static final String TAG = ChatMessageDBManager.class.getSimpleName();
    private static ChatMessageDBManager mInstance = null;
    private List<ChatMessageDbOberser> mObservers = null;

    /* loaded from: classes9.dex */
    public interface ChatMessageDbOberser {
        void notifyDbChange(int i, ChatSession chatSession);
    }

    public synchronized void registerObserver(ChatMessageDbOberser chatMessageDbOberser) {
        if (chatMessageDbOberser != null) {
            if (this.mObservers == null) {
                this.mObservers = new LinkedList();
            }
            this.mObservers.add(chatMessageDbOberser);
        }
    }

    public synchronized void unRegisterObserver(ChatMessageDbOberser chatMessageDbOberser) {
        if (this.mObservers != null) {
            this.mObservers.remove(chatMessageDbOberser);
        }
    }

    public synchronized void notifyDbChange(int i, ChatSession chatSession) {
        if (this.mObservers != null && this.mObservers.size() != 0 && chatSession != null) {
            for (ChatMessageDbOberser chatMessageDbOberser : this.mObservers) {
                if (chatMessageDbOberser != null) {
                    chatMessageDbOberser.notifyDbChange(i, chatSession);
                }
            }
        }
    }

    private ChatMessageDBManager(Context context) {
        setContext(context);
    }

    public static ChatMessageDBManager getInstance(Context context) {
        synchronized (mSyncLock) {
            if (mInstance == null) {
                mInstance = new ChatMessageDBManager(context);
            }
        }
        return mInstance;
    }

    public void recordLastMsg(HashMap<ChatObject, Integer> hashMap) {
        LogUtils.d(TAG, "recordReceiveLastMsg");
        for (Map.Entry<ChatObject, Integer> entry : hashMap.entrySet()) {
            ChatObject key = entry.getKey();
            int intValue = entry.getValue().intValue();
            ArrayList<ChatMsg> fetchMsg = fetchMsg(entry.getKey(), 0L, 2L);
            if (fetchMsg.size() > 0) {
                ChatMsg chatMsg = fetchMsg.get(0);
                ChatMsg chatMsg2 = (!notSendButShowTipMsg(chatMsg) || fetchMsg.size() <= 1) ? chatMsg : fetchMsg.get(1);
                String localUrl = chatMsg2 instanceof HtmlMsg ? chatMsg2.getLocalUrl() : chatMsg2.getRecommendDescription();
                long newMsgNum = getNewMsgNum(key);
                int i = newMsgNum >= 0 ? (int) (newMsgNum + intValue) : intValue;
                int clickState = Utility.getClickState(chatMsg2);
                String str = "";
                if (key.getCategory() == 0 && (key.getContacter() & Constants.PAFLAG) != 0) {
                    if (!chatMsg2.isSelf(this.mContext)) {
                        str = chatMsg2.getExtLog();
                    } else {
                        ArrayList<ChatMsg> fetchMsg2 = fetchMsg(key, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                        if (fetchMsg2 != null && fetchMsg2.size() > 0) {
                            str = fetchMsg2.get(0).getExtLog();
                        }
                    }
                }
                recordLastMsg(key, localUrl, chatMsg2.getMsgTime(), i, 0, clickState, chatMsg2.isStarMessage(), str);
            }
        }
    }

    public void recordLastMsg(ChatObject chatObject, String str, long j, int i, int i2, int i3, boolean z, String str2) {
        LogUtils.d(TAG, "recordSendLastMsg " + chatObject.toString());
        ChatSession chatRecord = getInstance(this.mContext).getChatRecord(chatObject);
        if (chatRecord == null) {
            if (chatObject.getCategory() == 0) {
                IMUserManager.getInstance(this.mContext).removeChatObject(chatObject.getContacter());
            }
            LogUtils.d(TAG, "recordLastMsg getChatObjectForSession");
            GetChatObjectInfoForRecordManager.getChatObjectForSession(this.mContext, chatObject);
            return;
        }
        if (chatRecord.getState() != 3) {
            chatRecord.setLastMsg(str);
            chatRecord.setState(i2);
            chatRecord.setIsClicked(i3);
        }
        chatRecord.setLastMsgTime(j);
        if (i >= 0) {
            chatRecord.setNewMsgSum(i);
        }
        chatRecord.setLastMsgTime(j);
        chatRecord.setShow(1);
        if (z) {
            chatRecord.setChatType(4);
        }
        if (chatObject.getCategory() == 0 && (chatObject.getContacter() & Constants.PAFLAG) != 0) {
            chatRecord.addExt(LogConfig.LOG_EXT_LOG, str2);
        }
        updateChatSession(1, chatRecord);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ef A[Catch: all -> 0x006e, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100 A[Catch: all -> 0x006e, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117 A[Catch: all -> 0x006e, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0123 A[Catch: all -> 0x006e, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018f A[Catch: all -> 0x006e, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3 A[Catch: all -> 0x006e, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e3 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #0 {, blocks: (B:10:0x0018, B:11:0x0024, B:13:0x003f, B:17:0x004b, B:19:0x0062, B:20:0x006c, B:27:0x009b, B:29:0x00a1, B:30:0x00ab, B:32:0x00ae, B:34:0x00bd, B:36:0x00c4, B:37:0x00cc, B:39:0x00d5, B:41:0x00e5, B:43:0x00ef, B:44:0x00f3, B:60:0x01a3, B:62:0x01d0, B:64:0x01d6, B:45:0x00f9, B:47:0x0100, B:48:0x0110, B:50:0x0117, B:51:0x011b, B:53:0x0123, B:54:0x0127, B:56:0x018f, B:57:0x0193, B:58:0x01a0, B:65:0x01e3, B:25:0x0071, B:26:0x0087), top: B:68:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7) {
        ChatMsg chatMsg;
        String str8;
        int unReadMsgCount;
        ArrayList<ChatMsg> fetchMsg;
        if (getChatSession(chatObject) != null) {
            return 0L;
        }
        int category = chatObject.getCategory();
        long contacter = chatObject.getContacter();
        synchronized (mSyncLock) {
            if (category == 0 && i == 0) {
                contacter = IMUserManager.getInstance(this.mContext).getBuidByUK(contacter);
            }
            ChatSession chatSession = new ChatSession(category, chatObject.getContacter(), contacter, str);
            ChatMsg draftMsg = getDraftMsg(chatObject.getCategory(), chatObject.getContacter());
            if (draftMsg == null) {
                if (1 == chatObject.getCategory()) {
                    if (i == 4) {
                        fetchMsg = GroupMessageDAOImpl.fetchLastChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    } else {
                        fetchMsg = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    }
                } else {
                    fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
                }
                if (fetchMsg == null) {
                    LogUtils.e(TAG, "updateChatRecordName fetchmsg error! ");
                    return -1L;
                } else if (fetchMsg.size() == 0) {
                    LogUtils.e(TAG, "updateChatRecordName  msgs.size() = 0! ");
                    return 0L;
                } else {
                    draftMsg = fetchMsg.get(0);
                    if (notSendButShowTipMsg(draftMsg) && fetchMsg.size() > 1) {
                        chatMsg = fetchMsg.get(1);
                        str8 = "";
                        if (chatObject.getCategory() == 0 && (chatObject.getContacter() & Constants.PAFLAG) != 0) {
                            if (chatMsg.isSelf(this.mContext)) {
                                str8 = chatMsg.getExtLog();
                            } else {
                                ArrayList<ChatMsg> fetchMsg2 = fetchMsg(chatObject, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                                if (fetchMsg2 != null && fetchMsg2.size() > 0) {
                                    str8 = fetchMsg2.get(0).getExtLog();
                                }
                            }
                            chatSession.addExt(LogConfig.LOG_EXT_LOG, str8);
                        }
                        if (1 != chatObject.getCategory()) {
                            unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                        } else {
                            unReadMsgCount = getUnReadMsgCount(chatObject);
                        }
                        chatSession.setChatType(i);
                        if (unReadMsgCount >= 0) {
                            chatSession.setNewMsgSum(unReadMsgCount);
                        }
                        String recommendDescription = chatMsg.getRecommendDescription();
                        if (chatMsg instanceof HtmlMsg) {
                            recommendDescription = chatMsg.getLocalUrl();
                        }
                        chatSession.setLastOpenTime(chatMsg.getMsgTime());
                        chatSession.setLastMsgTime(chatMsg.getMsgTime());
                        chatSession.setLastMsg(recommendDescription);
                        chatSession.setState(chatMsg.getStatus());
                        chatSession.setIconUrl(str2);
                        chatSession.setIsClicked(Utility.getClickState(chatMsg));
                        chatSession.setPaid(chatObject.getPaid());
                        chatSession.setClassType(i2);
                        chatSession.setClassTitle(str3);
                        chatSession.setClassAvatar(str4);
                        chatSession.setClassShow(i3);
                        chatSession.setMarkTop(i4);
                        chatSession.setMarkTopTime(j);
                        chatSession.setVipId(str5);
                        chatSession.setVPortrait(str6);
                        chatSession.setCertification(str7);
                        chatSession.setShield(i5);
                        chatSession.setShieldTime(j2);
                        if (chatMsg.isStarMessage()) {
                            chatSession.setChatType(4);
                        }
                        return getInstance(this.mContext).updateChatSession(1, chatSession);
                    }
                }
            }
            chatMsg = draftMsg;
            str8 = "";
            if (chatObject.getCategory() == 0) {
                if (chatMsg.isSelf(this.mContext)) {
                }
                chatSession.addExt(LogConfig.LOG_EXT_LOG, str8);
            }
            if (1 != chatObject.getCategory()) {
            }
            chatSession.setChatType(i);
            if (unReadMsgCount >= 0) {
            }
            String recommendDescription2 = chatMsg.getRecommendDescription();
            if (chatMsg instanceof HtmlMsg) {
            }
            chatSession.setLastOpenTime(chatMsg.getMsgTime());
            chatSession.setLastMsgTime(chatMsg.getMsgTime());
            chatSession.setLastMsg(recommendDescription2);
            chatSession.setState(chatMsg.getStatus());
            chatSession.setIconUrl(str2);
            chatSession.setIsClicked(Utility.getClickState(chatMsg));
            chatSession.setPaid(chatObject.getPaid());
            chatSession.setClassType(i2);
            chatSession.setClassTitle(str3);
            chatSession.setClassAvatar(str4);
            chatSession.setClassShow(i3);
            chatSession.setMarkTop(i4);
            chatSession.setMarkTopTime(j);
            chatSession.setVipId(str5);
            chatSession.setVPortrait(str6);
            chatSession.setCertification(str7);
            chatSession.setShield(i5);
            chatSession.setShieldTime(j2);
            if (chatMsg.isStarMessage()) {
            }
            return getInstance(this.mContext).updateChatSession(1, chatSession);
        }
    }

    private boolean notSendButShowTipMsg(ChatMsg chatMsg) {
        return chatMsg.getMsgType() == 2012 || chatMsg.getMsgType() == 2014 || chatMsg.getMsgType() == 2001;
    }

    public void updateSessionClass(PaInfo paInfo) {
        ChatSession chatRecord = getChatRecord(new ChatObject(this.mContext, 0, paInfo.getPaId(), -1L, -1));
        if (chatRecord != null) {
            LogUtils.d(TAG, "syncpa session " + paInfo.toString());
            chatRecord.setName(paInfo.getNickName());
            chatRecord.setNickName(paInfo.getNickName());
            chatRecord.setIconUrl(paInfo.getAvatar());
            chatRecord.setClassType(paInfo.getClassType());
            chatRecord.setClassTitle(paInfo.getClassTitle());
            chatRecord.setClassAvatar(paInfo.getClassavatar());
            chatRecord.setClassShow(paInfo.getClassshow());
            chatRecord.setMarkTop(paInfo.getMarkTop());
            chatRecord.setMarkTopTime(paInfo.getMarkTopTime());
            chatRecord.setVipId(paInfo.getVipId());
            chatRecord.setVPortrait(paInfo.getVPortrait());
            chatRecord.setCertification(paInfo.getIdentity());
            chatRecord.setShield(paInfo.getShield());
            chatRecord.setShieldTime(paInfo.getShieldTime());
            updateChatSession(1, chatRecord);
        }
    }

    public void updateSessionClass(ChatUser chatUser) {
        ChatSession chatRecord = getChatRecord(new ChatObject(this.mContext, 0, chatUser.getUk(), -1L, -1));
        if (chatRecord != null) {
            LogUtils.d(TAG, "sync user session " + chatUser.toString());
            chatRecord.setNickName(chatUser.getUserName());
            chatRecord.setName(chatUser.getUserName());
            chatRecord.setIconUrl(chatUser.getIconUrl());
            chatRecord.setMarkTop(chatUser.getMarkTop());
            chatRecord.setMarkTopTime(chatUser.getMarkTopTime());
            chatRecord.setVipId(chatUser.getVipId());
            chatRecord.setVPortrait(chatUser.getVPortrait());
            chatRecord.setCertification(chatUser.getIdentity());
            chatRecord.setShield(chatUser.getShield());
            chatRecord.setShieldTime(chatUser.getShieldTime());
            updateChatSession(1, chatRecord);
        }
    }

    public int updateChatSessionName(ChatSession chatSession) {
        synchronized (mSyncLock) {
            if (chatSession == null) {
                return -1;
            }
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", chatSession.getName());
                int update = openDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, addPaidCondition("category =? AND contacter = ?", "paid", chatSession.getPaid()), new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())});
                if (update > 0) {
                    notifyDbChange(1, getChatRecordInternal(openDatabase, new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter())));
                }
                return update;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "updateChatSessionName:", e);
                return -1;
            }
        }
    }

    public long updateChatSession(int i, ChatSession chatSession) {
        long update;
        synchronized (mSyncLock) {
            if (chatSession == null) {
                return -1L;
            }
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contructChatRecordValues(i, chatSession, contentValues);
                if (!isRecordExist(openDatabase, new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter(), chatSession.getPaid(), chatSession.getChatType()))) {
                    LogUtils.e(TAG, "create chatsession! " + chatSession.toString());
                    contentValues.put("category", Integer.valueOf(chatSession.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatSession.getContacter()));
                    contentValues.put("paid", Long.valueOf(chatSession.getPaid()));
                    update = openDatabase.insert(TableDefine.DB_TABLE_CHAT_SESSION, null, contentValues);
                } else {
                    LogUtils.d(TAG, "update chatsession! " + chatSession.toString());
                    update = openDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, addPaidCondition("category =? AND contacter = ?", "paid", chatSession.getPaid()), new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())});
                }
                if (update > 0) {
                    notifyDbChange(1, chatSession);
                }
                return update;
            } catch (Exception e) {
                LogUtils.e(TAG, "updateChatRecord:", e);
                return -1L;
            }
        }
    }

    private void contructChatRecordValues(int i, ChatSession chatSession, ContentValues contentValues) {
        if (chatSession.getName() != null) {
            contentValues.put("name", chatSession.getName());
        }
        if (chatSession.getLastMsg() != null) {
            contentValues.put(TableDefine.SessionColumns.COLUMN_LAST_MSG, chatSession.getLastMsg());
        }
        if (-1 != chatSession.getLastMsgTime()) {
            contentValues.put(TableDefine.SessionColumns.COLUMN_LAST_MSG_TIME, Long.valueOf(chatSession.getLastMsgTime()));
        }
        if (-1 != chatSession.getLastOpenTime()) {
            contentValues.put(TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME, Long.valueOf(chatSession.getLastOpenTime()));
        }
        if (-1 != chatSession.getNewMsgSum()) {
            contentValues.put(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM, Long.valueOf(chatSession.getNewMsgSum()));
        }
        contentValues.put("show", Integer.valueOf(chatSession.getShow()));
        contentValues.put(TableDefine.SessionColumns.COLUMN_STATE, Integer.valueOf(chatSession.getState()));
        if (i == 0) {
            contentValues.put("weight", Integer.valueOf(chatSession.getWeight()));
        }
        contentValues.put(TableDefine.SessionColumns.COLUMN_CHAT_TYPE, Integer.valueOf(chatSession.getChatType()));
        contentValues.put(TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE, Integer.valueOf(chatSession.getCollectionType()));
        contentValues.put("icon_url", chatSession.getIconUrl());
        contentValues.put("isclicked", Integer.valueOf(chatSession.getIsClicked()));
        if (chatSession.getClassType() > 0) {
            contentValues.put("classtype", Integer.valueOf(chatSession.getClassType()));
            contentValues.put("classshow", Integer.valueOf(chatSession.getClassShow()));
            contentValues.put("classtitle", chatSession.getClassTitle());
            contentValues.put("classavatar", chatSession.getClassAvatar());
        }
        contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
        contentValues.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
        if (chatSession.getNickName() != null) {
            contentValues.put("nickname", chatSession.getNickName());
        }
        if (!TextUtils.isEmpty(chatSession.getExt())) {
            contentValues.put("extra", chatSession.getExt());
        }
        if (!TextUtils.isEmpty(chatSession.getVPortrait())) {
            contentValues.put("v_portrait", chatSession.getVPortrait());
        }
        if (!TextUtils.isEmpty(chatSession.getCertification())) {
            contentValues.put(TableDefine.SessionColumns.COLUMN_CERTIFICATION, chatSession.getCertification());
        }
        if (!TextUtils.isEmpty(chatSession.getVipId())) {
            contentValues.put("vip_id", chatSession.getVipId());
        }
        contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
        contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [522=5, 523=4] */
    public boolean isRecordExist(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            try {
                if (sQLiteDatabase == null) {
                    return false;
                }
                try {
                    cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "category = ? AND contacter = ?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                LogUtils.d(TAG, "chat record exist! " + chatObject.toString());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return true;
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "isRecordExist:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return false;
                        }
                    }
                    LogUtils.d(TAG, "chat record not found! category: " + chatObject.toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [578=5, 579=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8 A[Catch: all -> 0x00fc, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000f, B:25:0x00e4, B:26:0x00e7, B:29:0x00ed, B:30:0x00f0, B:21:0x00db, B:22:0x00de, B:35:0x00f8, B:36:0x00fb), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<SessionClass> getAllClassType() {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<SessionClass> arrayList = new ArrayList<>();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"classtype", "classtitle", "classshow", "classavatar"}, "classtype > 1 ", null, "classtype", null, null, null);
                try {
                    LogUtils.e(TAG, "cursor " + cursor);
                    if (cursor == null) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                    LogUtils.e(TAG, "cursor count " + cursor.getCount());
                    while (cursor.moveToNext()) {
                        int i = cursor.getInt(cursor.getColumnIndex("classtype"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("classshow"));
                        String string = cursor.getString(cursor.getColumnIndex("classtitle"));
                        String string2 = cursor.getString(cursor.getColumnIndex("classavatar"));
                        SessionClass sessionClass = new SessionClass();
                        sessionClass.setType(i);
                        sessionClass.setTitle(string);
                        sessionClass.setAvatarurl(string2);
                        sessionClass.setShow(i2);
                        arrayList.add(sessionClass);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                    try {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatRecords:", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2, long j3) {
        LogUtils.enter();
        return getChatRecords(j, j2, j3, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [645=5, 646=4] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014b A[Catch: all -> 0x0145, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0010, B:40:0x0135, B:41:0x0138, B:45:0x013f, B:46:0x0142, B:35:0x0129, B:36:0x012c, B:53:0x014b, B:54:0x014e), top: B:61:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatSession> getChatRecords(long j, long j2, long j3, List<Integer> list) {
        Cursor cursor;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            Cursor cursor2 = null;
            if (openDatabase == null) {
                return null;
            }
            long j4 = j + j2;
            try {
                String addPaidCondition = addPaidCondition("show= ?", "paid", j3);
                LogUtils.e(TAG, addPaidCondition);
                if (list != null && list.size() > 0) {
                    String str = "" + list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        str = str + ", " + list.get(i);
                    }
                    addPaidCondition = addPaidCondition + " AND chat_type in (" + str + ") ";
                }
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", j4 > 0 ? String.valueOf(j4) : null);
                try {
                    try {
                        LogUtils.e(TAG, Constants.EXTRA_CONFIG_CURSOR + cursor);
                        if (cursor == null) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                        LogUtils.e(TAG, "cursor count" + cursor.getCount());
                        cursor.moveToPosition(((int) j) - 1);
                        while (cursor.moveToNext()) {
                            ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                            LogUtils.e(TAG, "record : " + constructChatRecord);
                            if (constructChatRecord != null) {
                                arrayList.add(constructChatRecord);
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "getChatRecords:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [706=5, 707=4] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015f A[Catch: all -> 0x0159, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:7:0x0010, B:40:0x0149, B:41:0x014c, B:45:0x0153, B:46:0x0156, B:35:0x013d, B:36:0x0140, B:53:0x015f, B:54:0x0162), top: B:62:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatSession> getChatRecordsByClass(long j, long j2, long j3, List<Integer> list) {
        Cursor cursor;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            Cursor cursor2 = null;
            if (openDatabase == null) {
                return null;
            }
            long j4 = j + j2;
            try {
                String addPaidCondition = addPaidCondition("show= ?", "paid", j3);
                LogUtils.e(TAG, addPaidCondition);
                if (list != null && list.size() > 0) {
                    String str = "" + list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        str = str + ", " + list.get(i);
                    }
                    addPaidCondition = addPaidCondition + " AND classtype in (" + str + ") ";
                }
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", j4 > 0 ? String.valueOf(j4) : null);
                try {
                    try {
                        LogUtils.e(TAG, Constants.EXTRA_CONFIG_CURSOR + cursor);
                        if (cursor == null) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                        LogUtils.e(TAG, "cursor count" + cursor.getCount());
                        cursor.moveToPosition(((int) j) - 1);
                        while (cursor.moveToNext()) {
                            ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                            LogUtils.e(TAG, "record : " + constructChatRecord);
                            if (constructChatRecord != null) {
                                arrayList.add(constructChatRecord);
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatRecords:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    private ChatSession constructChatRecord(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        long j;
        ArrayList<ChatMsg> fetchMessageSync;
        String senderUid;
        int i = cursor.getInt(cursor.getColumnIndex("category"));
        long j2 = cursor.getLong(cursor.getColumnIndex("contacter"));
        String string = cursor.getString(cursor.getColumnIndex("name"));
        String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG));
        long j3 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG_TIME));
        long j4 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME));
        long j5 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
        int i2 = cursor.getInt(cursor.getColumnIndex("weight"));
        int i3 = cursor.getInt(cursor.getColumnIndex("show"));
        int i4 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE));
        int i5 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CHAT_TYPE));
        String string3 = cursor.getString(cursor.getColumnIndex("icon_url"));
        int i6 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_STATE));
        int i7 = cursor.getInt(cursor.getColumnIndex("isclicked"));
        long j6 = cursor.getLong(cursor.getColumnIndex("paid"));
        int i8 = cursor.getInt(cursor.getColumnIndex("classtype"));
        int i9 = cursor.getInt(cursor.getColumnIndex("classshow"));
        String string4 = cursor.getString(cursor.getColumnIndex("classtitle"));
        String string5 = cursor.getString(cursor.getColumnIndex("classavatar"));
        int i10 = cursor.getInt(cursor.getColumnIndex("marktop"));
        long j7 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
        String string6 = cursor.getString(cursor.getColumnIndex("nickname"));
        String string7 = cursor.getString(cursor.getColumnIndex("extra"));
        String string8 = cursor.getString(cursor.getColumnIndex("v_portrait"));
        String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CERTIFICATION));
        String string10 = cursor.getString(cursor.getColumnIndex("vip_id"));
        int i11 = cursor.getInt(cursor.getColumnIndex("shield"));
        long j8 = cursor.getLong(cursor.getColumnIndex("shield_time"));
        if (i == 0 && i5 == 0) {
            long buidByUK = IMUserManager.getInstance(this.mContext).getBuidByUK(j2);
            if (buidByUK < 0 && !TextUtils.isEmpty(string2) && (fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(0, j2, 1, (ChatMsg) null)) != null && fetchMessageSync.size() > 0) {
                Iterator<ChatMsg> it = fetchMessageSync.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (next != null) {
                        if (AccountManager.getUid(this.mContext).equals(next.getSenderUid())) {
                            senderUid = next.getToBduid();
                        } else {
                            senderUid = next.getSenderUid();
                        }
                        try {
                            j = Long.valueOf(senderUid).longValue();
                            break;
                        } catch (NumberFormatException e) {
                            LogUtils.e(TAG, "", e);
                        }
                    }
                }
            }
            j = buidByUK;
        } else {
            j = j2;
        }
        if (0 != j2) {
            if (!TextUtils.isEmpty(string2) || i5 == 27 || i5 == 17) {
                ChatSession chatSession = new ChatSession(i, j2, j, string);
                chatSession.setLastMsg(string2);
                chatSession.setLastMsgTime(j3);
                chatSession.setLastOpenTime(j4);
                chatSession.setNewMsgSum(j5);
                chatSession.setWeight(i2);
                chatSession.setShow(i3);
                chatSession.setCollectionType(i4);
                chatSession.setChatType(i5);
                chatSession.setIconUrl(string3);
                chatSession.setState(i6);
                chatSession.setIsClicked(i7);
                chatSession.setPaid(j6);
                chatSession.setClassType(i8);
                chatSession.setClassTitle(string4);
                chatSession.setClassAvatar(string5);
                chatSession.setClassShow(i9);
                chatSession.setMarkTop(i10);
                chatSession.setMarkTopTime(j7);
                chatSession.setNickName(string6);
                chatSession.setExt(string7);
                chatSession.setVPortrait(string8);
                chatSession.setCertification(string9);
                chatSession.setVipId(string10);
                chatSession.setShield(i11);
                chatSession.setShieldTime(j8);
                return chatSession;
            }
            return null;
        }
        return new ChatSession(i, j2, j, string);
    }

    public long delChatRecord(ChatObject chatObject) {
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            try {
                String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
                String addPaidCondition = addPaidCondition("category = ? AND contacter = ?", "paid", chatObject.getPaid());
                ChatSession chatRecordInternal = getChatRecordInternal(openDatabase, chatObject);
                long delete = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, addPaidCondition, strArr);
                if (delete > 0 && chatRecordInternal != null) {
                    notifyDbChange(2, chatRecordInternal);
                }
                return delete;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "delChatRecord:", e);
                return -1L;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [889=4] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5 A[Catch: all -> 0x00de, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0015, B:7:0x001d, B:10:0x0020, B:21:0x0087, B:22:0x008a, B:42:0x00e5, B:43:0x00e8, B:33:0x00d8, B:34:0x00db), top: B:53:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long delChatRecordForClassTypeOne() {
        Cursor cursor;
        Cursor cursor2;
        long j;
        synchronized (mSyncLock) {
            LogUtils.d(TAG, "HBBH im in delChatRecordForClassTypeOne!!!");
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            ArrayList arrayList = new ArrayList();
            try {
                String[] strArr = {String.valueOf(1), String.valueOf(5)};
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "classtype = ? AND chat_type = ?", strArr, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("contacter"))));
                        } catch (Exception e) {
                            e = e;
                            cursor2 = cursor;
                            try {
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, "HBBH delChatRecordForClassTypeOne:", e);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                return -1L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    long delete = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, "classtype = ? AND chat_type = ?", strArr);
                    for (int i = 0; i < arrayList.size(); i++) {
                        openDatabase.delete("message", "from_user = ?", new String[]{String.valueOf(arrayList.get(i))});
                    }
                    j = delete;
                } else {
                    j = -1;
                }
                LogUtils.d(TAG, "HBBH delChatRecordForClassTypeOne num = " + j);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (Exception e2) {
                e = e2;
                cursor2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [918=5, 919=4] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatSession getChatRecordInternal(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToNext()) {
                            ChatSession constructChatRecord = constructChatRecord(sQLiteDatabase, cursor);
                            if (cursor != null) {
                                cursor.close();
                                return constructChatRecord;
                            }
                            return constructChatRecord;
                        }
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "getChatRecord:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [948=5, 949=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073 A[Catch: all -> 0x0053, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000a, B:15:0x004e, B:16:0x0051, B:22:0x0058, B:23:0x005b, B:34:0x0073, B:35:0x0076, B:29:0x006a, B:30:0x006d), top: B:40:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSession getChatRecord(ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return constructChatRecord;
                            }
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getChatRecord:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [979=5, 980=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069 A[Catch: all -> 0x0049, TryCatch #2 {, blocks: (B:4:0x0003, B:7:0x000b, B:15:0x0044, B:16:0x0047, B:23:0x004f, B:24:0x0052, B:36:0x0069, B:37:0x006c, B:30:0x0060, B:32:0x0064), top: B:44:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSession getChatRecord(int i, long j, long j2) {
        Cursor cursor;
        ChatSession chatSession;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            if (openDatabase == null) {
                chatSession = null;
            } else {
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", j2), new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToNext()) {
                                    chatSession = constructChatRecord(openDatabase, cursor);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                LogUtils.e(TAG, "getChatRecord:", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                chatSession = null;
                                return chatSession;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                    chatSession = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        }
        return chatSession;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1009=5, 1010=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068 A[Catch: all -> 0x0048, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000a, B:15:0x0043, B:16:0x0046, B:22:0x004d, B:23:0x0050, B:34:0x0068, B:35:0x006b, B:29:0x005f, B:30:0x0062), top: B:42:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSession getChatRecordByContacter(ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, "category = ? AND contacter=?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return constructChatRecord;
                            }
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getChatRecord:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    public int getNewMsgNum(ChatObject chatObject) {
        int i;
        if (1 == chatObject.getCategory()) {
            return GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
        }
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                i = -1;
            } else {
                try {
                    i = getNewMsgNum(openDatabase, chatObject);
                    LogUtils.d(TAG, "getNewMsgNum: " + i);
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getNewMsgNum:", e);
                    i = 0;
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1066=5, 1067=4] */
    private int getNewMsgNum(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            try {
                if (sQLiteDatabase == null) {
                    return -1;
                }
                try {
                    cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM}, addPaidCondition("category =? AND contacter =?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                LogUtils.d(TAG, "get new msg num for category : " + chatObject.getCategory() + " contacter:" + chatObject.getContacter());
                                int i = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return i;
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getNewMsgNum:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return 0;
                        }
                    }
                    LogUtils.d(TAG, "getNewMsgNum record not found! " + chatObject.toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public long addMsg(ChatMsg chatMsg, boolean z) {
        long addMsg;
        synchronized (mSyncLock) {
            if (1 == chatMsg.getCategory()) {
                addMsg = GroupMessageDAOImpl.addSingleChatMsg(this.mContext, chatMsg);
            } else {
                addMsg = addMsg(chatMsg);
            }
            if (addMsg >= 0) {
                chatMsg.setRowId(addMsg);
                if (z) {
                    updateChatSession(chatMsg);
                }
            }
        }
        return addMsg;
    }

    private long addMsg(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1L;
        }
        if (chatMsg.getCategory() == 0 || 1 == chatMsg.getCategory() || 2 == chatMsg.getCategory()) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1L;
                }
                int status = chatMsg.getStatus();
                if (status == 1 && chatMsg.getRowId() != -1) {
                    LogUtils.d(TAG, "tiaoshi not insert for: status=sending rowid != -1");
                    return -1L;
                } else if (status != 1 && status != 3 && isMsgExist(openDatabase, chatMsg) > 0) {
                    LogUtils.d(TAG, "tiaoshi not exception path!");
                    return -2L;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("content", chatMsg.getMsgContent());
                    contentValues.put("type", Integer.valueOf(chatMsg.getRealMsgType()));
                    contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                    contentValues.put("buid", chatMsg.getSenderUid());
                    contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
                    contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
                    contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                    contentValues.put("is_read", Integer.valueOf(chatMsg.isMsgRead() ? 1 : 0));
                    contentValues.put("cmd", Integer.valueOf(chatMsg.getNotifyCmd()));
                    if (chatMsg instanceof HtmlMsg) {
                        contentValues.put("local_url", chatMsg.getRecommendDescription());
                    } else {
                        contentValues.put("local_url", chatMsg.getLocalUrl());
                    }
                    contentValues.put(TableDefine.MessageColumns.COLUMN_ISZHIDA, Integer.valueOf(chatMsg.isZhida() ? 1 : 0));
                    contentValues.put("isclicked", Integer.valueOf(chatMsg.isClicked() ? 1 : 0));
                    contentValues.put("paid", Long.valueOf(chatMsg.getPaid()));
                    contentValues.put("device_flag", Integer.valueOf(chatMsg.getDeviceFlag()));
                    contentValues.put("msg_key", chatMsg.getMsgKey());
                    contentValues.put("sendid", chatMsg.getSendMsgId());
                    contentValues.put("expires_time", Long.valueOf(chatMsg.getExpiresTime()));
                    contentValues.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, chatMsg.getServiceType());
                    contentValues.put(TableDefine.MessageColumns.COLUME_TIPS_CODE, Integer.valueOf(chatMsg.getTipsCode()));
                    contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, chatMsg.getTips());
                    contentValues.put(TableDefine.MessageColumns.COLUME_TEMPLATE, Integer.valueOf(chatMsg.getTemplateType()));
                    return openDatabase.insert("message", null, contentValues);
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "addMsg:", e);
                return -1L;
            }
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1194=4] */
    private long isMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        Cursor cursor;
        String[] strArr;
        long j;
        synchronized (mSyncLock) {
            try {
                long msgId = chatMsg.getMsgId();
                StringBuilder sb = new StringBuilder();
                sb.append("(").append("msgid").append(" = ? AND ");
                sb.append("status").append(" = ?)");
                if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getContacter())};
                } else {
                    sb.append(" OR ").append("msg_key").append(" = ?");
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
                }
                sb.insert(0, "((").append(") AND ").append("contacter").append(" = ?)");
                Cursor query = sQLiteDatabase.query("message", null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            j = query.getLong(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                j = -1;
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return j;
    }

    private long dupMsgAddHandler(ChatMsg chatMsg) {
        long j = -1;
        if (chatMsg != null && (chatMsg.getChatType() == 24 || chatMsg.getMsgType() != 20)) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.d(TAG, "dupMsgAddHandler getWritableDb fail!");
                } else if (isDuplicateMsg(openDatabase, chatMsg) > 0) {
                    LogUtils.d(TAG, "dupMsgAddHandler isDuplicateMsg = true");
                    j = -2;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
                    contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                    contentValues.put(TableDefine.NoDuplicateMessageColumns.COLUMN_INPUT_TIME, Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                    contentValues.put("msg_key", chatMsg.getMsgKey());
                    j = openDatabase.insert(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, null, contentValues);
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "dupMsgAddHandler:", e);
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1287=4] */
    private long isDuplicateMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        Cursor cursor;
        String[] strArr;
        long j;
        synchronized (mSyncLock) {
            try {
                long msgId = chatMsg.getMsgId();
                StringBuilder sb = new StringBuilder();
                sb.append("(").append("msgid").append(" = ?)");
                if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getContacter())};
                } else {
                    sb.append(" OR ").append("msg_key").append(" = ?");
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
                }
                sb.insert(0, "((").append(") AND ").append("contacter").append(" = ?)");
                LogUtils.d(TAG, "isDuplicateMsg query sql = " + sb.toString());
                Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            j = query.getLong(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                j = -1;
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return j;
    }

    public int updateMsgStatus(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1;
        }
        if (1 == chatMsg.getCategory()) {
            int updateMsgStatus = GroupMessageDAOImpl.updateMsgStatus(this.mContext, chatMsg);
            if (updateMsgStatus >= 0) {
                updateChatSession(chatMsg);
                return updateMsgStatus;
            }
            return updateMsgStatus;
        }
        return updateMsgStatusForSingle(chatMsg);
    }

    private int updateMsgStatusForSingle(ChatMsg chatMsg) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
        contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
        contentValues.put("content", chatMsg.getJsonContent());
        contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
        contentValues.put(TableDefine.MessageColumns.COLUME_TIPS_CODE, Integer.valueOf(chatMsg.getTipsCode()));
        contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, chatMsg.getTips());
        synchronized (mSyncLock) {
            update = update("message", "_id = ?", new String[]{String.valueOf(chatMsg.getRowId())}, contentValues);
            if (update >= 0) {
                updateChatSession(chatMsg);
            }
        }
        return update;
    }

    public int updateMsgStatus(long j, int i) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        synchronized (mSyncLock) {
            update = update("message", "_id = ?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private List<Long> getPaidsByChatTypes(SQLiteDatabase sQLiteDatabase, List<Integer> list) {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(", ");
            sb.append(list.get(i));
        }
        String str = "chat_type in (" + sb.toString() + ") ";
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select paid from chatrecord where " + str, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("paid"))));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "getUnreadSessionByChatTypes:", e);
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1470=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0277  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<ChatSession> getUnreadSessionByChatTypes(SQLiteDatabase sQLiteDatabase, List<Integer> list) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(", ");
            sb.append(list.get(i));
        }
        String str = "chat_type in (" + sb.toString() + ")  AND " + TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM + ">0";
        Cursor cursor2 = null;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        try {
            cursor = sQLiteDatabase.rawQuery("select * from chatrecord where " + str, null);
            while (cursor != null) {
                try {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    int i2 = cursor.getInt(cursor.getColumnIndex("category"));
                    long j = cursor.getLong(cursor.getColumnIndex("contacter"));
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG));
                    long j2 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG_TIME));
                    long j3 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME));
                    long j4 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
                    int i3 = cursor.getInt(cursor.getColumnIndex("weight"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("show"));
                    int i5 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE));
                    int i6 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CHAT_TYPE));
                    String string3 = cursor.getString(cursor.getColumnIndex("icon_url"));
                    int i7 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_STATE));
                    int i8 = cursor.getInt(cursor.getColumnIndex("isclicked"));
                    long j5 = cursor.getLong(cursor.getColumnIndex("paid"));
                    int i9 = cursor.getInt(cursor.getColumnIndex("classtype"));
                    int i10 = cursor.getInt(cursor.getColumnIndex("classshow"));
                    String string4 = cursor.getString(cursor.getColumnIndex("classtitle"));
                    String string5 = cursor.getString(cursor.getColumnIndex("classavatar"));
                    int i11 = cursor.getInt(cursor.getColumnIndex("marktop"));
                    long j6 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
                    String string6 = cursor.getString(cursor.getColumnIndex("nickname"));
                    String string7 = cursor.getString(cursor.getColumnIndex("extra"));
                    String string8 = cursor.getString(cursor.getColumnIndex("v_portrait"));
                    String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CERTIFICATION));
                    String string10 = cursor.getString(cursor.getColumnIndex("vip_id"));
                    int i12 = cursor.getInt(cursor.getColumnIndex("shield"));
                    long j7 = cursor.getLong(cursor.getColumnIndex("shield_time"));
                    ChatSession chatSession = new ChatSession(i2, j, j, string);
                    chatSession.setLastMsg(string2);
                    chatSession.setLastMsgTime(j2);
                    chatSession.setLastOpenTime(j3);
                    chatSession.setNewMsgSum(j4);
                    chatSession.setWeight(i3);
                    chatSession.setShow(i4);
                    chatSession.setCollectionType(i5);
                    chatSession.setChatType(i6);
                    chatSession.setIconUrl(string3);
                    chatSession.setState(i7);
                    chatSession.setIsClicked(i8);
                    chatSession.setPaid(j5);
                    chatSession.setClassType(i9);
                    chatSession.setClassTitle(string4);
                    chatSession.setClassAvatar(string5);
                    chatSession.setClassShow(i10);
                    chatSession.setMarkTop(i11);
                    chatSession.setMarkTopTime(j6);
                    chatSession.setNickName(string6);
                    chatSession.setExt(string7);
                    chatSession.setVPortrait(string8);
                    chatSession.setCertification(string9);
                    chatSession.setVipId(string10);
                    chatSession.setShield(i12);
                    chatSession.setShieldTime(j7);
                    arrayList.add(chatSession);
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                    try {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getUnreadSessionByChatTypes:", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private int setPaMsgReadByPaids(SQLiteDatabase sQLiteDatabase, List<Long> list, long j) {
        if (list == null || list.size() <= 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(0));
                    for (int i = 1; i < list.size(); i++) {
                        sb.append(", ");
                        sb.append(list.get(i));
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_read", (Integer) 1);
                    String str = "is_read=? AND category = ? AND from_user in (" + sb.toString() + ") ";
                    if (j > 0) {
                        str = str + " AND msgid<=" + j;
                    }
                    int update = sQLiteDatabase.update("message", contentValues, str, new String[]{String.valueOf(0), "0"});
                    if (0 != 0) {
                        cursor.close();
                        return update;
                    }
                    return update;
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "setPaMsgReadByPaids:", e);
                    if (0 != 0) {
                        cursor.close();
                        return -1009;
                    }
                    return -1009;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return -1009;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1574=4] */
    public List<Long> setPaMsgReadByChatTypes(List<Integer> list, long j) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return null;
        }
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                openDatabase.beginTransaction();
                List<ChatSession> unreadSessionByChatTypes = getUnreadSessionByChatTypes(openDatabase, list);
                if (unreadSessionByChatTypes == null || unreadSessionByChatTypes.size() <= 0) {
                    openDatabase.endTransaction();
                    return null;
                }
                LogUtils.d(TAG, "getUnreadChatSessionByChatTypes sessions size  = " + unreadSessionByChatTypes.size());
                for (ChatSession chatSession : unreadSessionByChatTypes) {
                    arrayList.add(Long.valueOf(chatSession.getPaid()));
                }
                int paMsgReadByPaids = setPaMsgReadByPaids(openDatabase, arrayList, j);
                LogUtils.d(TAG, "setPaMsgReadByPaids result = " + paMsgReadByPaids);
                if (paMsgReadByPaids >= 0) {
                    for (ChatSession chatSession2 : unreadSessionByChatTypes) {
                        int unReadMsgCount = getUnReadMsgCount(new ChatObject(this.mContext, chatSession2.getCategory(), chatSession2.getContacter()));
                        if (unReadMsgCount >= 0) {
                            chatSession2.setNewMsgSum(unReadMsgCount);
                        } else {
                            chatSession2.setNewMsgSum(0L);
                        }
                        getInstance(this.mContext).updateChatSession(1, chatSession2);
                    }
                }
                openDatabase.setTransactionSuccessful();
                openDatabase.endTransaction();
                return arrayList;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "setPaMsgReadByChatTypes:", e);
                openDatabase.endTransaction();
                return null;
            }
        }
    }

    public int setMsgRead(ChatObject chatObject, long j) {
        int msgRead;
        ChatSession chatSession;
        int unReadMsgCount;
        if (chatObject == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        synchronized (mSyncLock) {
            if (1 == chatObject.getCategory()) {
                msgRead = GroupMessageDAOImpl.setMsgReaded(this.mContext, String.valueOf(chatObject.getContacter()), j);
            } else {
                msgRead = getInstance(this.mContext).setMsgRead(j);
            }
            if (msgRead < 0) {
                return -1009;
            }
            if (msgRead != 0 && (chatSession = getChatSession(chatObject)) != null) {
                if (1 == chatObject.getCategory()) {
                    unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                } else {
                    unReadMsgCount = getUnReadMsgCount(chatObject);
                }
                if (unReadMsgCount >= 0) {
                    chatSession.setNewMsgSum(unReadMsgCount);
                } else {
                    chatSession.setNewMsgSum(0L);
                }
                getInstance(this.mContext).updateChatSession(1, chatSession);
            }
            return msgRead;
        }
    }

    private int setMsgRead(long j) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        synchronized (mSyncLock) {
            update = update("message", "msgid = ?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    private boolean isNeedInsertToDB(ChatMsg chatMsg) {
        if (2 == chatMsg.getCategory()) {
            switch (chatMsg.getNotifyCmd()) {
                case 0:
                    delSysMsg(chatMsg.getCategory(), chatMsg.getFromUser(), 0);
                    break;
                case 1:
                    delSysMsg(chatMsg.getCategory(), chatMsg.getFromUser(), 1);
                    break;
                case 20:
                case 21:
                case 22:
                case 23:
                case 60:
                case 62:
                    return false;
            }
        }
        return true;
    }

    public ArrayList<ChatMsg> addMsgs(Context context, ArrayList<ChatMsg> arrayList, boolean z, long j) {
        ArrayList<ChatMsg> arrayList2;
        if (arrayList != null) {
            synchronized (mSyncLock) {
                AccountManagerImpl.getInstance(this.mContext).getUid();
                arrayList2 = new ArrayList<>();
                ArrayList<ChatMsg> arrayList3 = new ArrayList<>();
                HashMap<ChatObject, Integer> hashMap = new HashMap<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = arrayList.get(i);
                    chatMsg.setTriggerReasonn(j);
                    try {
                        JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                        jSONObject.put(Constants.EXTRA_TRIGGER_REASON, j);
                        chatMsg.setMsgContent(jSONObject.toString());
                    } catch (Exception e) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        e.printStackTrace();
                    }
                    if (!isNeedInsertToDB(chatMsg)) {
                        arrayList2.add(chatMsg);
                    } else if (chatMsg.getChatType() == 24 && chatMsg.getMsgType() == 20) {
                        LogUtils.d(TAG, "msg will handle by dupMsgAddHandler");
                        if (dupMsgAddHandler(chatMsg) > 0) {
                            arrayList3.add(chatMsg);
                        }
                    } else {
                        LogUtils.d(TAG, "will add msg to db, msg = " + chatMsg.toString());
                        long addMsg = addMsg(chatMsg);
                        LogUtils.e(TAG, "addMsg result : " + addMsg);
                        if (-1 != addMsg && -2 != addMsg) {
                            chatMsg.setRowId(addMsg);
                            long contacter = getContacter(chatMsg);
                            if (contacter != -1) {
                                ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), contacter, chatMsg.getPaid(), -1);
                                ChatSession chatSession = getChatSession(chatObject);
                                LogUtils.e(TAG, " addMsgs session : " + chatSession);
                                if (chatSession != null) {
                                    chatMsg.setChatType(chatSession.getChatType());
                                    arrayList2.add(chatMsg);
                                }
                                if (chatObject != null) {
                                    if (hashMap.containsKey(chatObject)) {
                                        if (z && !chatMsg.isMsgRead() && chatMsg.getMsgType() != 101) {
                                            hashMap.put(chatObject, Integer.valueOf(hashMap.get(chatObject).intValue() + 1));
                                        }
                                    } else if (z && !chatMsg.isMsgRead() && chatMsg.getMsgType() != 101) {
                                        hashMap.put(chatObject, 1);
                                    } else {
                                        hashMap.put(chatObject, 0);
                                    }
                                }
                            }
                        }
                    }
                }
                recordLastMsg(hashMap);
                if (!arrayList3.isEmpty()) {
                    ChatMsgManagerImpl.getInstance(this.mContext).deliverFetchedConfigMessage(arrayList3);
                }
            }
            return arrayList2;
        }
        return null;
    }

    public long delSysMsg(int i, long j, int i2) {
        long delete;
        synchronized (mSyncLock) {
            delete = delete("message", "category = ?  AND (contacter = ? OR from_user = ? ) AND cmd = ? ", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(j), String.valueOf(i2)});
        }
        return delete;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1780=5, 1781=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079 A[Catch: all -> 0x0045, TryCatch #2 {, blocks: (B:4:0x0006, B:6:0x000c, B:15:0x0040, B:16:0x0043, B:23:0x004c, B:24:0x004f, B:36:0x0079, B:37:0x007c, B:30:0x006f, B:31:0x0072), top: B:46:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxMsgid() {
        Cursor cursor;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1L;
            }
            try {
                Cursor query = openDatabase.query("message", new String[]{"msgid"}, null, null, null, null, "msgid desc ", String.valueOf(1));
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            long j = query.getLong(query.getColumnIndex("msgid"));
                            if (query != null) {
                                query.close();
                            }
                            return j;
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = query;
                        try {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getMaxMsgid:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return -1L;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return 0L;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2) {
        ArrayList<ChatMsg> fetchMsg;
        synchronized (mSyncLock) {
            fetchMsg = fetchMsg(chatObject, j, j2, j == 0 ? -1L : Long.MAX_VALUE, false);
        }
        return fetchMsg;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3) {
        ArrayList<ChatMsg> fetchMsg;
        synchronized (mSyncLock) {
            fetchMsg = fetchMsg(chatObject, j, j2, j3, false);
        }
        return fetchMsg;
    }

    private boolean getCursorMoveDirection(boolean z, long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return !z;
        }
        return z;
    }

    public long deleteAllMsg(ChatObject chatObject) {
        long maxMsgid;
        synchronized (this.mContext) {
            if (1 == chatObject.getCategory()) {
                maxMsgid = GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
            } else {
                maxMsgid = getInstance(this.mContext).getMaxMsgid(chatObject);
            }
            if (maxMsgid < 0) {
                return -1009L;
            }
            if (deleteAllMsgWithMsgid(chatObject, maxMsgid) < 0) {
                return -1009L;
            }
            return maxMsgid;
        }
    }

    public int deleteAllMsgWithMsgid(ChatObject chatObject, long j) {
        synchronized (this.mContext) {
            int delMsgsOfCertainContacter = getInstance(this.mContext).delMsgsOfCertainContacter(chatObject, j);
            if (delMsgsOfCertainContacter < 0) {
                return -1009;
            }
            ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, Long.MAX_VALUE, 2L, -1L);
            if (fetchMsg == null || fetchMsg.size() <= 0) {
                return delMsgsOfCertainContacter;
            }
            return 0;
        }
    }

    public int delMsgsOfCertainContacter(ChatObject chatObject, long j) {
        int i = 1;
        if (1 == chatObject.getCategory()) {
            int delMsgsOfCertainContacter = GroupMessageDAOImpl.delMsgsOfCertainContacter(this.mContext, String.valueOf(chatObject.getContacter()), j);
            synchronized (mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                try {
                    long maxMsgid = GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
                    if (j == -1 || maxMsgid <= j) {
                        String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
                        String addPaidCondition = addPaidCondition("category = ? AND contacter = ?", "paid", chatObject.getPaid());
                        ChatSession chatRecordInternal = getChatRecordInternal(openDatabase, chatObject);
                        i = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, addPaidCondition, strArr);
                        if (i > 0 && chatRecordInternal != null) {
                            notifyDbChange(2, chatRecordInternal);
                        }
                    }
                    if (i < 0) {
                        return -1;
                    }
                    if (i < 0) {
                        delMsgsOfCertainContacter = -1;
                    }
                    return delMsgsOfCertainContacter;
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "delMsg:", e);
                    return -1;
                }
            }
        }
        return delMsgsOfCertainContacterForSingle(chatObject, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1976=4, 1977=4] */
    private int delMsgsOfCertainContacterForSingle(ChatObject chatObject, long j) {
        int delete;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            boolean z = false;
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            try {
                openDatabase.beginTransaction();
                int i = -1;
                String[] strArr = {String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getCategory())};
                String addPaidCondition = addPaidCondition(j != -1 ? "contacter = ?  AND category = ? AND msgid <= " + j : "contacter = ?  AND category = ?", "paid", chatObject.getPaid());
                if (addPaidCondition != null && strArr != null) {
                    i = openDatabase.delete("message", addPaidCondition, strArr);
                }
                long maxMsgid = getMaxMsgid(chatObject);
                ChatSession chatSession = null;
                if (j == -1 || maxMsgid <= j) {
                    String[] strArr2 = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
                    String addPaidCondition2 = addPaidCondition("category = ? AND contacter = ?", "paid", chatObject.getPaid());
                    chatSession = getChatRecordInternal(openDatabase, chatObject);
                    delete = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, addPaidCondition2, strArr2);
                    if (delete > 0) {
                        z = true;
                    }
                } else {
                    delete = 1;
                }
                if (delete < 0) {
                    if (openDatabase != null) {
                        openDatabase.endTransaction();
                    }
                    return -1;
                }
                if (delete >= 0) {
                    openDatabase.setTransactionSuccessful();
                    if (z && chatSession != null) {
                        notifyDbChange(2, chatSession);
                    }
                } else {
                    i = -1;
                }
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return i;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "delMsg:", e);
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return -1;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2059=4, 2060=4] */
    private int delMsgsOfPaByPaId(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = -1;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
            } else {
                try {
                    openDatabase.beginTransaction();
                    String[] strArr = {String.valueOf(j)};
                    if (strArr.length > 0) {
                        if (TextUtils.isEmpty("from_user = ? ")) {
                            i = -1;
                        } else {
                            i = openDatabase.delete("message", "from_user = ? ", strArr);
                            LogUtils.d(TAG, "--delMsgsOfPaByPaId--delMsgs = " + i);
                        }
                        if (TextUtils.isEmpty("contacter = ? ")) {
                            i2 = -1;
                        } else {
                            int delete = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "contacter = ? ", strArr);
                            LogUtils.d(TAG, "--delMsgsOfPaByPaId--delChatRecord = " + delete);
                            i2 = delete;
                        }
                        if (TextUtils.isEmpty("paid = ? ")) {
                            i3 = -1;
                        } else {
                            int delete2 = delete(openDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid = ? ", strArr);
                            LogUtils.d(TAG, "--delMsgsOfPaByPaId--delPaInfoRecord = " + delete2);
                            i3 = delete2;
                        }
                        if (TextUtils.isEmpty("paid = ? ")) {
                            i4 = -1;
                        } else {
                            i4 = delete(openDatabase, TableDefine.DB_TABLE_ZHIDAINFO, "paid = ? ", strArr);
                            LogUtils.d(TAG, "--delMsgsOfPaByPaId--delZhiDaPaInfoRecord = " + i4);
                        }
                        if (i >= 0 || i2 >= 0 || i3 >= 0 || i4 >= 0) {
                            openDatabase.setTransactionSuccessful();
                            i5 = i;
                        }
                        if (openDatabase != null) {
                            openDatabase.endTransaction();
                        }
                    } else if (openDatabase != null) {
                        openDatabase.endTransaction();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "delMsgsOfPaByPaId:", e);
                    if (openDatabase != null) {
                        openDatabase.endTransaction();
                    }
                }
            }
        }
        return i5;
    }

    private int delMsgs(long[] jArr) {
        int i;
        synchronized (mSyncLock) {
            int i2 = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                i = -1;
            } else {
                if (jArr != null) {
                    try {
                    } catch (Exception e) {
                        e = e;
                    }
                    if (jArr.length > 0) {
                        i2 = 0;
                        String[] strArr = new String[2];
                        strArr[1] = String.valueOf(0);
                        i = 0;
                        for (long j : jArr) {
                            try {
                                strArr[0] = String.valueOf(j);
                                if ("msgid = ? AND status=?" != 0 && strArr != null) {
                                    i = (int) (openDatabase.delete("message", "msgid = ? AND status=?", strArr) + i);
                                }
                            } catch (Exception e2) {
                                i2 = i;
                                e = e2;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, "delMsg:", e);
                                i = i2;
                                return i;
                            }
                        }
                        for (long j2 : jArr) {
                            openDatabase.execSQL("delete from message where msgid=? and type in (?, ?, ?)", new Object[]{Long.valueOf(1 + j2), 2012, 2001, Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL)});
                            LogUtils.e(TAG, "delete notSendButShowTipMsg :delete from message where msgid=? and type in (?, ?, ?), msgId :" + (j2 + 1));
                        }
                    }
                }
                i = -1;
            }
        }
        return i;
    }

    public int deleteMsgBatch(ChatObject chatObject, long[] jArr) {
        int delMsgs;
        int updateSession;
        synchronized (mSyncLock) {
            if (1 == chatObject.getCategory()) {
                delMsgs = GroupMessageDAOImpl.deleteMsgs(this.mContext, String.valueOf(chatObject.getContacter()), jArr);
            } else {
                delMsgs = getInstance(this.mContext).delMsgs(jArr);
            }
            if (delMsgs < 0) {
                updateSession = -1009;
            } else {
                updateSession = updateSession(delMsgs, chatObject);
            }
        }
        return updateSession;
    }

    public int updateSession(int i, ChatObject chatObject) {
        ArrayList<ChatMsg> fetchMsg;
        ChatMsg chatMsg;
        synchronized (mSyncLock) {
            ChatSession chatSession = getChatSession(chatObject);
            if (chatSession != null && chatSession.getState() != 3) {
                if (i != 0) {
                    if (1 == chatObject.getCategory()) {
                        fetchMsg = GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    } else {
                        fetchMsg = fetchMsg(chatObject, 0L, 2L);
                    }
                    if (fetchMsg == null || fetchMsg.size() <= 0) {
                        chatMsg = null;
                    } else {
                        chatMsg = fetchMsg.get(0);
                        if (notSendButShowTipMsg(chatMsg) && fetchMsg.size() > 1) {
                            chatMsg = fetchMsg.get(1);
                        }
                    }
                    updateSession(true, chatSession, chatMsg);
                }
            }
        }
        return i;
    }

    public long getMaxMsgid(ChatObject chatObject) {
        long j;
        if (1 == chatObject.getCategory()) {
            return GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
        }
        synchronized (mSyncLock) {
            ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, 0L, 1L);
            if (fetchMsg != null && fetchMsg.size() > 0) {
                j = fetchMsg.get(0).getMsgId();
            } else {
                j = fetchMsg == null ? -1L : 0L;
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2203=4] */
    public int getUnReadMsgCount(ChatObject chatObject) {
        Cursor cursor;
        int i;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    cursor = openDatabase.query("message", new String[]{IMConstants.MSG_ROW_ID}, addPaidCondition(1 == chatObject.getCategory() ? "category=? AND contacter=? AND is_read=? AND type != 101" : "category=? AND contacter=? AND is_read=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(0)}, null, null, null);
                    try {
                        LogUtils.d(TAG, "getUnReadMsgCount> COLUMN_CATEGORY=" + chatObject.getCategory() + ", COLUMN_CONTACTER=" + chatObject.getContacter() + ", count = " + cursor.getCount());
                        i = cursor.getCount();
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, " getUnReadMsgCount:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        i = -1;
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public boolean setAllMsgReadWithMsgid(ChatObject chatObject, long j) {
        int allMsgRead;
        int unReadMsgCount;
        if (j == -1) {
            j = getInstance(this.mContext).getMaxMsgid(chatObject);
        }
        synchronized (mSyncLock) {
            if (j < 0) {
                return false;
            }
            if (chatObject.getCategory() == 1) {
                allMsgRead = GroupMessageDAOImpl.setAllMsgRead(this.mContext, String.valueOf(chatObject.getContacter()), j);
            } else {
                allMsgRead = getInstance(this.mContext).setAllMsgRead(chatObject, j);
            }
            if (allMsgRead < 0) {
                return false;
            }
            ChatSession chatRecord = getInstance(this.mContext).getChatRecord(chatObject);
            LogUtils.d(TAG, "delta:" + allMsgRead);
            if (chatRecord != null) {
                if (1 == chatObject.getCategory()) {
                    unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                } else {
                    unReadMsgCount = getUnReadMsgCount(chatObject);
                }
                if (unReadMsgCount >= 0) {
                    chatRecord.setNewMsgSum(unReadMsgCount);
                } else {
                    chatRecord.setNewMsgSum(0L);
                }
                getInstance(this.mContext).updateChatSession(1, chatRecord);
            }
            return true;
        }
    }

    private int setAllMsgRead(ChatObject chatObject, long j) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        String addPaidCondition = addPaidCondition(j > 0 ? "is_read=? AND category = ? AND (contacter = ? OR from_user = ?) AND msgid<=" + j : "is_read=? AND category = ? AND (contacter = ? OR from_user = ?)", "paid", chatObject.getPaid());
        String[] strArr = {String.valueOf(0), String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getContacter())};
        synchronized (mSyncLock) {
            update = update("message", addPaidCondition, strArr, contentValues);
        }
        return update;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0096 A[Catch: Exception -> 0x00c8, all -> 0x00e9, TryCatch #1 {Exception -> 0x00c8, blocks: (B:19:0x001f, B:21:0x0025, B:22:0x003f, B:24:0x0045, B:25:0x0064, B:26:0x008d, B:28:0x0096, B:29:0x00ae, B:31:0x00b5, B:33:0x00bb), top: B:47:0x001f, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: all -> 0x0017, TRY_ENTER, TryCatch #3 {, blocks: (B:10:0x000f, B:12:0x0015, B:35:0x00c2, B:36:0x00c5, B:41:0x00e5, B:19:0x001f, B:21:0x0025, B:22:0x003f, B:24:0x0045, B:25:0x0064, B:26:0x008d, B:28:0x0096, B:29:0x00ae, B:31:0x00b5, B:33:0x00bb, B:39:0x00c9), top: B:49:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCount(List<Integer> list) {
        String str;
        Cursor cursor = null;
        int i = 0;
        if (list != null && list.size() > 0) {
            synchronized (mSyncLock) {
                i = -1;
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase != null) {
                    if (list != null) {
                        try {
                        } catch (Exception e) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, " getNewMsgCount:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                        if (list.size() > 0) {
                            String str2 = " ( " + list.get(0);
                            for (int i2 = 1; i2 < list.size(); i2++) {
                                str2 = str2 + ", " + list.get(i2);
                            }
                            str = "chat_type in " + (str2 + " ) ");
                            cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
                            if (cursor != null && cursor.moveToNext()) {
                                i = cursor.getInt(0);
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                    str = "";
                    cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
                    if (cursor != null) {
                        i = cursor.getInt(0);
                    }
                    if (cursor != null) {
                    }
                }
            }
        }
        return i;
    }

    public int getNewMsgCountOfClass(int i) {
        int i2;
        Cursor cursor = null;
        synchronized (mSyncLock) {
            i2 = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase != null) {
                try {
                    String str = "classtype = " + i;
                    cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
                    if (cursor != null && cursor.moveToNext()) {
                        i2 = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, " getNewMsgCount:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i2;
    }

    public int getNewMsgCount(long j) {
        int i;
        String str;
        Cursor cursor = null;
        synchronized (mSyncLock) {
            i = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase != null) {
                if (j == -1) {
                    str = "";
                } else {
                    try {
                        str = "paid=" + j;
                    } catch (Exception e) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, " getNewMsgCount:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
                cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
                if (cursor != null && cursor.moveToNext()) {
                    i = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public int deleteDraftMsg(ChatObject chatObject) {
        if (1 == chatObject.getCategory()) {
            int deleteDraftMsg = GroupMessageDAOImpl.deleteDraftMsg(this.mContext, String.valueOf(chatObject.getContacter()));
            if (deleteDraftMsg > 0) {
                ChatSession chatSession = getChatSession(chatObject);
                ArrayList<ChatMsg> fetchAllChatMsg = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                if (fetchAllChatMsg != null && fetchAllChatMsg.size() > 0) {
                    updateSession(true, chatSession, fetchAllChatMsg.get(0));
                }
            }
            return deleteDraftMsg;
        }
        return deleteDraftMsgForSingle(chatObject);
    }

    private int deleteDraftMsgForSingle(ChatObject chatObject) {
        ChatMsg chatMsg;
        synchronized (mSyncLock) {
            int delete = delete("message", addPaidCondition("category=? AND contacter=? AND status=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(3)});
            if (delete <= 0) {
                return delete;
            }
            ArrayList<ChatMsg> fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
            if (fetchMsg != null && fetchMsg.size() > 0) {
                chatMsg = fetchMsg.get(0);
            } else {
                chatMsg = (fetchMsg == null || fetchMsg.size() != 0) ? null : null;
            }
            updateSession(true, getChatSession(chatObject), chatMsg);
            return delete;
        }
    }

    public ChatMsg getDraftMsg(int i, long j) {
        return 1 == i ? GroupMessageDAOImpl.getDraftMsg(this.mContext, String.valueOf(j)) : getDraftMsgForSingle(i, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2486=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x004b, B:17:0x004f, B:30:0x007b, B:31:0x007e, B:26:0x0072), top: B:38:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatMsg getDraftMsgForSingle(int i, long j) {
        Cursor cursor;
        ChatMsg chatMsg;
        ChatMsg chatMsg2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                cursor = openDatabase.query("message", null, "category=? AND contacter=? AND status=?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(3)}, null, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                chatMsg2 = construChatMsg(cursor);
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getDraftMsg:", e);
                            if (cursor != null) {
                                cursor.close();
                                chatMsg = null;
                            } else {
                                chatMsg = null;
                            }
                            return chatMsg;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    chatMsg = chatMsg2;
                } else {
                    chatMsg = chatMsg2;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            return chatMsg;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2515=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074 A[Catch: all -> 0x004a, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x0044, B:17:0x0048, B:30:0x0074, B:31:0x0077, B:26:0x006b), top: B:41:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getChatMsgByMsgId(long j) {
        Cursor cursor;
        ChatMsg chatMsg;
        ChatMsg chatMsg2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                cursor = openDatabase.query("message", null, "msgid=? AND status=?", new String[]{String.valueOf(j), String.valueOf(0)}, null, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                chatMsg2 = construChatMsg(cursor);
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "fetchMsg:", e);
                            if (cursor != null) {
                                cursor.close();
                                chatMsg = null;
                            } else {
                                chatMsg = null;
                            }
                            return chatMsg;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    chatMsg = chatMsg2;
                } else {
                    chatMsg = chatMsg2;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            return chatMsg;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01ef A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0345  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatMsg construChatMsg(Cursor cursor) {
        int i;
        Exception e;
        ChatMsg newChatMsg;
        int i2 = cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
        int i3 = cursor.getInt(cursor.getColumnIndex("type"));
        long j = cursor.getLong(cursor.getColumnIndex("from_user"));
        long j2 = cursor.getLong(cursor.getColumnIndex("msgid"));
        long j3 = cursor.getLong(cursor.getColumnIndex("time"));
        int i4 = cursor.getInt(cursor.getColumnIndex("is_read"));
        int i5 = cursor.getInt(cursor.getColumnIndex("status"));
        String string = cursor.getString(cursor.getColumnIndex("content"));
        int i6 = cursor.getInt(cursor.getColumnIndex("category"));
        long j4 = cursor.getLong(cursor.getColumnIndex("contacter"));
        int i7 = cursor.getInt(cursor.getColumnIndex("cmd"));
        String string2 = cursor.getString(cursor.getColumnIndex("local_url"));
        boolean z = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUMN_ISZHIDA)) == 1;
        boolean z2 = cursor.getInt(cursor.getColumnIndex("isclicked")) == 1;
        long j5 = cursor.getLong(cursor.getColumnIndex("paid"));
        int i8 = cursor.getInt(cursor.getColumnIndex("device_flag"));
        String string3 = cursor.getString(cursor.getColumnIndex("sendid"));
        String string4 = cursor.getString(cursor.getColumnIndex("buid"));
        String string5 = cursor.getString(cursor.getColumnIndex("msg_key"));
        long j6 = cursor.getLong(cursor.getColumnIndex("expires_time"));
        String string6 = cursor.getString(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_SERVICE_TYPE));
        int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TIPS_CODE));
        String string7 = cursor.getString(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TIPS));
        int i10 = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TEMPLATE));
        if (i3 == 80) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(new JSONObject(string).optString("text")).optString("msg")).optString("ext"));
                i = jSONObject.optInt("type", -1);
                try {
                    if (i == 1) {
                        i = 0;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("text", jSONObject.optString("body"));
                        string = jSONObject2.toString();
                    } else if (i == 0) {
                        if (jSONObject.has("content") && !jSONObject.has("body")) {
                            i = 0;
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("text", new JSONObject(jSONObject.optString("content")).optString("text"));
                            string = jSONObject3.toString();
                        } else {
                            JSONArray jSONArray = new JSONArray(jSONObject.optString("body"));
                            int length = jSONArray.length();
                            if (length == 1) {
                                i3 = 8;
                                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("title", optJSONObject.optString("title"));
                                jSONObject4.put("article_url", optJSONObject.optString("url"));
                                jSONObject4.put("cover", optJSONObject.optString("headImage"));
                                string = jSONObject4.toString();
                                i = 8;
                            } else {
                                i = i3;
                            }
                            if (length > 1) {
                                i = 9;
                                JSONArray jSONArray2 = new JSONArray();
                                for (int i11 = 0; i11 < length; i11++) {
                                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i11);
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put("title", optJSONObject2.optString("title"));
                                    jSONObject5.put("article_url", optJSONObject2.optString("url"));
                                    jSONObject5.put("cover", optJSONObject2.optString("headImage"));
                                    jSONArray2.put(jSONObject5);
                                }
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("articles", jSONArray2);
                                string = jSONObject6.toString();
                            }
                        }
                    } else {
                        string = jSONObject.optString("content");
                    }
                } catch (Exception e2) {
                    e = e2;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "du construChatMsg:", e);
                    newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i6, i, i7);
                    if (newChatMsg != null) {
                    }
                }
            } catch (Exception e3) {
                i = i3;
                e = e3;
            }
        } else {
            i = i3;
        }
        newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i6, i, i7);
        if (newChatMsg != null) {
            return null;
        }
        newChatMsg.setCategory(i6);
        newChatMsg.setContacter(j4);
        newChatMsg.setFromUser(j);
        newChatMsg.setMsgContent(string);
        newChatMsg.setRowId(i2);
        newChatMsg.setMsgId(j2);
        newChatMsg.setMsgTime(j3);
        newChatMsg.setMsgReaded(i4);
        newChatMsg.setStatus(i5);
        newChatMsg.setCategory(i6);
        newChatMsg.setContacter(j4);
        newChatMsg.setNotifyCmd(i7);
        newChatMsg.setLocalUrl(string2);
        newChatMsg.setIsZhida(z);
        newChatMsg.setIsClicked(z2);
        newChatMsg.setPaid(j5);
        newChatMsg.setMsgType(i);
        newChatMsg.setDeviceFlag(i8);
        newChatMsg.setSendMsgId(string3);
        newChatMsg.setSenderUid(string4);
        newChatMsg.setMsgKey(string5);
        newChatMsg.setExpiresTime(j6);
        newChatMsg.setServiceType(string6);
        newChatMsg.setTipsCode(i9);
        newChatMsg.setTips(string7);
        newChatMsg.setTemplateType(i10);
        return newChatMsg;
    }

    public int deleteChatMsg(ChatMsg chatMsg) {
        int deleteChatMsg;
        synchronized (mSyncLock) {
            if (1 == chatMsg.getCategory()) {
                deleteChatMsg = GroupMessageDAOImpl.deleteChatMsg(this.mContext, chatMsg);
            } else {
                deleteChatMsg = deleteChatMsg(chatMsg.getRowId());
            }
            if (deleteChatMsg >= 0) {
                updateChatSession(chatMsg);
            }
        }
        return deleteChatMsg;
    }

    private int deleteChatMsg(long j) {
        int i;
        int i2 = 0;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                i = -1;
            } else {
                try {
                    i2 = openDatabase.delete("message", "_id = ? ", new String[]{String.valueOf(j)});
                    openDatabase.execSQL("delete from message where _id=? and type in (?, ?, ?)", new Object[]{Long.valueOf(j + 1), 2012, 2001, Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL)});
                    LogUtils.e(TAG, "deleteChatMsg notSendButShowTipMsg :delete from message where _id=? and type in (?, ?, ?), rowId :" + (j + 1));
                    i = i2;
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "deleteChatMsg:", e);
                    i = i2;
                }
            }
        }
        return i;
    }

    public int markMsgClicked(ChatMsg chatMsg) {
        return 1 == chatMsg.getCategory() ? GroupMessageDAOImpl.markMsgClicked(this.mContext, chatMsg) : markChatMsgClicked(chatMsg);
    }

    private int markChatMsgClicked(ChatMsg chatMsg) {
        synchronized (mSyncLock) {
            if (chatMsg.getRowId() == -1) {
                chatMsg.setRowId(addMsg(chatMsg));
            }
            if (chatMsg.getRowId() == -1) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("isclicked", (Integer) 1);
            int update = update("message", "_id=?", new String[]{"" + chatMsg.getRowId()}, contentValues);
            if (update < 0) {
                return update;
            }
            ArrayList<ChatMsg> fetchMsg = fetchMsg(new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), -1), 0L, 1L, -1L);
            if (fetchMsg == null || fetchMsg.size() == 0) {
                return 1009;
            }
            if (chatMsg.getRowId() == fetchMsg.get(0).getRowId()) {
                updateChatSession(chatMsg);
            }
            return update;
        }
    }

    public void updateChatSession(ChatMsg chatMsg) {
        ArrayList<ChatMsg> fetchMsg;
        boolean z;
        ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), chatMsg.getChatType());
        ChatSession chatSession = getChatSession(chatObject);
        if (isDraftMsg(chatMsg)) {
            z = true;
        } else if (chatSession == null || chatSession.getState() != 3) {
            if (1 == chatMsg.getCategory()) {
                fetchMsg = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatMsg.getContacter()), null, 1L, true);
            } else {
                fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
            }
            if (fetchMsg == null || fetchMsg.size() <= 0) {
                z = true;
            } else {
                ChatMsg chatMsg2 = fetchMsg.get(0);
                if (!notSendButShowTipMsg(chatMsg2) || fetchMsg.size() <= 1) {
                    chatMsg = chatMsg2;
                    z = true;
                } else {
                    chatMsg = fetchMsg.get(1);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        updateSession(z, chatSession, chatMsg);
    }

    private boolean isDraftMsg(ChatMsg chatMsg) {
        return chatMsg != null && (chatMsg instanceof TextMsg) && chatMsg.getStatus() == 3;
    }

    private String addPaidCondition(String str, String str2, long j) {
        return IMConfigInternal.getInstance().getIMConfig(this.mContext).getPaidCondition(str, str2, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2825=5, 2826=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x007c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00d8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    public ArrayList<ChatMsg> fetchMsg(String str, String str2) {
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        ?? openDatabase = openDatabase();
        try {
            if (openDatabase == 0) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                String[] strArr = {str2, str};
                String str3 = "select * from message where " + ("contacter = ? AND _id = ?  AND status = 2");
                try {
                    try {
                        synchronized (mSyncLock) {
                            try {
                                Cursor rawQuery = openDatabase.rawQuery(str3, strArr);
                                if (rawQuery == null || rawQuery.getCount() == 0) {
                                    LogUtils.d(TAG, "resend fetchmsg cursor is null " + str);
                                    if (rawQuery != null) {
                                        rawQuery.close();
                                        return null;
                                    }
                                    return null;
                                }
                                rawQuery.moveToFirst();
                                ChatMsg construChatMsg = construChatMsg(rawQuery);
                                if (construChatMsg != null) {
                                    LogUtils.d(TAG, "msgid : " + construChatMsg.getMsgId());
                                    arrayList.add(construChatMsg);
                                } else {
                                    LogUtils.d(TAG, "construChatMsg msg is null ");
                                }
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "fetchMsg:", e);
                        if (openDatabase != 0) {
                            openDatabase.close();
                            return null;
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                openDatabase = 0;
            } catch (Throwable th3) {
                openDatabase = 0;
                th = th3;
                if (openDatabase != 0) {
                    openDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2971=7, 2972=6] */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02ab, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "cursor is moveToPrevious failed!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02b4, code lost:
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02b5, code lost:
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02b6, code lost:
        if (r3 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02b8, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02bb, code lost:
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:?, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:?, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0157, code lost:
        if (r9 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x015a, code lost:
        if (r9 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x015c, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0238, code lost:
        r2 = getCursorMoveDirection(r22, r16, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x023c, code lost:
        if (r2 != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0242, code lost:
        if (r9.moveToLast() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0244, code lost:
        if (r9 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0246, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0250, code lost:
        if (r9.moveToFirst() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0252, code lost:
        if (r9 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0254, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x025a, code lost:
        r3 = construChatMsg(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x025e, code lost:
        if (r3 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0260, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "msgid : " + r3.getMsgId());
        r8.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0280, code lost:
        if (r2 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0286, code lost:
        if (r9.moveToNext() != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0288, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "cursor is moveToNext failed!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0290, code lost:
        if (r9 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0292, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0298, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "construChatMsg msg is null ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02a1, code lost:
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02a2, code lost:
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02a9, code lost:
        if (r9.moveToPrevious() != false) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z, String str) {
        long j4;
        String str2;
        String str3;
        String str4;
        String[] strArr;
        String str5;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        SQLiteDatabase openDatabase = openDatabase();
        Cursor cursor = null;
        if (openDatabase == null) {
            LogUtils.d(TAG, "getReadableDb fail!");
            return null;
        }
        if (j <= 0) {
            if (j2 >= 0) {
                j2 = -j2;
            }
            j4 = j2;
        } else {
            j4 = j2;
        }
        try {
            if (0 == j && j3 == -1) {
                str3 = null;
                str4 = " >= ";
            } else {
                if (j4 == 0) {
                    str2 = " = ";
                    j3 = -2;
                } else if (j4 > 0) {
                    str2 = " > ";
                    if (j3 == Long.MAX_VALUE) {
                        j3 = 0;
                    }
                } else {
                    str2 = " < ";
                    if (j3 == -1) {
                        j3 = Long.MAX_VALUE;
                    }
                }
                if (j3 != -2) {
                    try {
                        str3 = " AND _id" + str2 + j3;
                        str4 = str2;
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "fetchMsg:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } else {
                    str3 = null;
                    str4 = str2;
                }
            }
            if (chatObject.getContacter() == 17 || chatObject.getContacter() == 26) {
                strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(0)};
                str5 = "type = ? AND msgid" + str4 + "? AND category = ? ";
            } else {
                strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(chatObject.getCategory())};
                str5 = "contacter = ? AND msgid" + str4 + "? AND category = ? ";
            }
            if (str3 != null) {
                str5 = str5 + str3;
            }
            if (str != null) {
                str5 = str5 + " AND " + str;
            }
            String str6 = str5 + " AND status != 3";
            String addPaidCondition = (chatObject.getCategory() == 17 || chatObject.getCategory() == 26) ? str6 : addPaidCondition(str6, "paid", chatObject.getPaid());
            if (j4 == 0) {
                j4 = 1;
            }
            String str7 = (j4 <= 0 || j <= 0) ? " desc " : " asc ";
            String str8 = "select * from message where " + addPaidCondition + " ORDER BY msgid" + str7 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + IMConstants.MSG_ROW_ID + str7 + " limit " + Math.abs(j4);
            synchronized (mSyncLock) {
                try {
                    Cursor rawQuery = openDatabase.rawQuery(str8, strArr);
                    try {
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw th;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public ArrayList<ChatMsg> getPaMsgByChatTypeAndPaidList(List<Integer> list, List<Long> list2, long j, int i) {
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            List<Long> paidsByChatTypes = getPaidsByChatTypes(openDatabase, list);
            HashSet hashSet = new HashSet();
            if (list2 != null) {
                hashSet.addAll(list2);
            }
            if (paidsByChatTypes != null) {
                hashSet.addAll(paidsByChatTypes);
            }
            return fetchPaMsgByPaids(new ArrayList(hashSet), j, i);
        }
    }

    public ArrayList<ChatMsg> getMaxMsgidByChatTypes(List<Integer> list, long j, int i) {
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            return fetchPaMsgByPaidsOrderByMsgid(getPaidsByChatTypes(openDatabase, list), j, i);
        }
    }

    public ArrayList<ChatMsg> fetchPaMsgByPaidsOrderByMsgid(List<Long> list, long j, int i) {
        Cursor cursor = null;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(", ");
            sb.append(list.get(i2));
        }
        String str = "paid in (" + sb.toString() + ")";
        if (j > 0) {
            str = str + " AND msgid < " + j;
        }
        String str2 = "select * from message where " + str + " ORDER BY msgid desc limit " + Math.abs(i);
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                cursor = openDatabase.rawQuery(str2, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        ChatMsg construChatMsg = construChatMsg(cursor);
                        if (construChatMsg != null) {
                            arrayList.add(construChatMsg);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        }
    }

    public ArrayList<ChatMsg> fetchPaMsgByPaids(List<Long> list, long j, int i) {
        Cursor cursor = null;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(", ");
            sb.append(list.get(i2));
        }
        String str = "paid in (" + sb.toString() + ")";
        if (j > 0) {
            str = str + " AND msgid < " + j;
        }
        String str2 = "select * from message where " + str + " ORDER BY msgid desc limit " + Math.abs(i);
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                cursor = openDatabase.rawQuery(str2, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        ChatMsg construChatMsg = construChatMsg(cursor);
                        if (construChatMsg != null) {
                            arrayList.add(construChatMsg);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        }
    }

    public List<ChatMsg> fetchPaMsgByChatType(int i, int i2) {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        List<PaInfo> queryPaInfoByChatType = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByChatType(i);
        if (queryPaInfoByChatType == null || queryPaInfoByChatType.size() <= 0) {
            return null;
        }
        String str = "" + queryPaInfoByChatType.get(0).getPaId();
        int i3 = 1;
        while (i3 < queryPaInfoByChatType.size()) {
            String str2 = str + ", " + queryPaInfoByChatType.get(i3).getPaId();
            i3++;
            str = str2;
        }
        String str3 = "select * from message where " + ("paid in (" + str + ") ") + " ORDER BY time desc limit " + Math.abs(i2);
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                cursor = openDatabase.rawQuery(str3, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        ChatMsg construChatMsg = construChatMsg(cursor);
                        if (construChatMsg != null) {
                            arrayList.add(construChatMsg);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        }
    }

    public ArrayList<ChatMsg> fetchMsgsByMsgTypes(ChatObject chatObject, long j, long j2, List<Integer> list) {
        ArrayList<ChatMsg> fetchMsg;
        String str = null;
        synchronized (mSyncLock) {
            if (list != null) {
                if (list.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : list) {
                        sb.append(num.intValue()).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    str = "type IN (" + sb.substring(0, sb.length() - 1) + ") ";
                }
            }
            fetchMsg = fetchMsg(chatObject, j, j2, j == 0 ? -1L : Long.MAX_VALUE, false, str);
        }
        return fetchMsg;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z) {
        return fetchMsg(chatObject, j, j2, j3, z, null);
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, ChatMsg chatMsg, long j, boolean z) {
        if (1 == chatObject.getCategory()) {
            return GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), chatMsg, j, z);
        }
        return fetchMsg(chatObject, chatMsg == null ? 0L : chatMsg.getMsgId(), j, chatMsg == null ? -1L : chatMsg.getRowId(), z, null);
    }

    public ArrayList<ChatMsg> fetchSpecifyMsgsSync(ChatObject chatObject, int i, long j, long j2, long j3, boolean z) {
        return fetchMsg(chatObject, j, j2, j3, z, "type = " + i);
    }

    public ArrayList<ChatMsg> fetchMsgsExceptGroupSystemMsgSync(ChatObject chatObject, long j, long j2, long j3, boolean z) {
        return fetchMsg(chatObject, j, j2, j3, z, "type != 101");
    }

    private long getContacter(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1L;
        }
        return chatMsg.getContacter();
    }

    private ChatSession getChatSession(ChatObject chatObject) {
        return getInstance(this.mContext).getChatRecord(chatObject);
    }

    private void updateSession(boolean z, ChatSession chatSession, ChatMsg chatMsg) {
        if (z) {
            if (chatSession == null) {
                long contacter = getContacter(chatMsg);
                if (contacter != -1) {
                    GetChatObjectInfoForRecordManager.getChatObjectForSession(this.mContext, new ChatObject(this.mContext, chatMsg.getCategory(), contacter, chatMsg.getPaid(), -1));
                }
            } else if (chatMsg == null) {
                if (getInstance(this.mContext).delChatRecord(new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter(), chatSession.getPaid(), -1)) >= 0) {
                    chatSession.setNewMsgSum(0L);
                }
            } else {
                String recommendDescription = chatMsg.getRecommendDescription();
                if (chatMsg instanceof HtmlMsg) {
                    recommendDescription = chatMsg.getLocalUrl();
                }
                chatSession.setState(chatMsg.getStatus());
                chatSession.setLastMsg(recommendDescription);
                chatSession.setLastMsgTime(chatMsg.getMsgTime());
                chatSession.setIsClicked(Utility.getClickState(chatMsg));
                if (chatMsg.isStarMessage()) {
                    chatSession.setChatType(4);
                }
                getInstance(this.mContext).updateChatSession(1, chatSession);
            }
        }
    }

    public int deleteChatSession(long j) {
        String str;
        int delete;
        String[] strArr = null;
        synchronized (mSyncLock) {
            if (j != -1) {
                str = "paid = ?";
                strArr = new String[]{String.valueOf(j)};
            } else {
                str = null;
            }
            delete = delete(TableDefine.DB_TABLE_CHAT_SESSION, str, strArr);
        }
        return delete;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3326=5, 3327=4] */
    public List<ChatSession> getGroupSession() {
        Cursor cursor = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList arrayList = new ArrayList();
            if (openDatabase == null) {
                return null;
            }
            try {
                try {
                    Cursor query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, "category =? AND show= ?", new String[]{String.valueOf(1), String.valueOf(1)}, null, null, "last_msg_time desc ", null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    while (query.moveToNext()) {
                        try {
                            ChatSession constructChatRecord = constructChatRecord(openDatabase, query);
                            if (constructChatRecord != null) {
                                arrayList.add(constructChatRecord);
                            }
                        } catch (Exception e) {
                            e = e;
                            cursor = query;
                            LogUtils.e(TAG, "getGroupSession:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void delPaLocalInfosByPaType(int i) {
        ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(this.mContext).queryPaIdByPaType(i);
        if (queryPaIdByPaType != null && !queryPaIdByPaType.isEmpty()) {
            LogUtils.d(TAG, "---delPaLocalInfosByPaType---paids.size = " + queryPaIdByPaType.size());
            Iterator<Long> it = queryPaIdByPaType.iterator();
            while (it.hasNext()) {
                delMsgsOfPaByPaId(it.next().longValue());
            }
            return;
        }
        LogUtils.d(TAG, "---delPaLocalInfosByPaType---paids is null ---- ");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3385=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079 A[Catch: all -> 0x004f, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x0049, B:17:0x004d, B:30:0x0079, B:31:0x007c, B:26:0x0070), top: B:41:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getLatestMsg(int i, long j) {
        Cursor cursor;
        ChatMsg chatMsg;
        ChatMsg chatMsg2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                cursor = openDatabase.query("message", null, "category=? AND contacter=? ", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, "msgid desc ", String.valueOf(1));
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                chatMsg2 = construChatMsg(cursor);
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getLatestMsg:", e);
                            if (cursor != null) {
                                cursor.close();
                                chatMsg = null;
                            } else {
                                chatMsg = null;
                            }
                            return chatMsg;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    chatMsg = chatMsg2;
                } else {
                    chatMsg = chatMsg2;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            return chatMsg;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3438=4] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e4 A[Catch: all -> 0x00dd, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0007, B:6:0x0026, B:7:0x002e, B:10:0x0031, B:21:0x007d, B:22:0x0080, B:42:0x00e4, B:43:0x00e7, B:33:0x00d7, B:34:0x00da), top: B:53:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long delChatRecordForChatType(int i) {
        Cursor cursor;
        Cursor cursor2;
        long j;
        synchronized (mSyncLock) {
            LogUtils.d(TAG, "delChatRecordForChatType chatType = " + i);
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            ArrayList arrayList = new ArrayList();
            try {
                String[] strArr = {String.valueOf(i)};
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "chat_type = ?", strArr, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("contacter"))));
                        } catch (Exception e) {
                            e = e;
                            cursor2 = cursor;
                            try {
                                LogUtils.e(TAG, "delChatRecordForChatType:", e);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                return -1L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    long delete = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, "chat_type = ?", strArr);
                    openDatabase.delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "pasubtype = ?", strArr);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        openDatabase.delete("message", "from_user = ?", new String[]{String.valueOf(arrayList.get(i2))});
                    }
                    j = delete;
                } else {
                    j = -1;
                }
                LogUtils.d(TAG, "delChatRecordForChatType num = " + j);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (Exception e2) {
                e = e2;
                cursor2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    public ArrayList<ChatMsg> addCastReliableMsgs(@NonNull List<TextMsg> list) {
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        synchronized (mSyncLock) {
            for (TextMsg textMsg : list) {
                if (addReliableMsg(textMsg) > 0) {
                    arrayList.add(textMsg);
                }
            }
        }
        return arrayList;
    }

    private long addReliableMsg(@NonNull TextMsg textMsg) {
        long j = -1;
        SQLiteDatabase openDatabase = openDatabase();
        try {
            if (openDatabase == null) {
                LogUtils.e(TAG, "addReliableMsg db is null!");
            } else if (isReliableMsgExist(openDatabase, textMsg)) {
                LogUtils.d(TAG, "addReliableMsg exist msgId = " + textMsg.getMsgId() + ", or msgKey :" + textMsg.getMsgKey());
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("msgid", Long.valueOf(textMsg.getMsgId()));
                contentValues.put("category", Integer.valueOf(textMsg.getCategory()));
                contentValues.put("type", Integer.valueOf(textMsg.getRealMsgType()));
                contentValues.put("from_user", Long.valueOf(textMsg.getFromUser()));
                contentValues.put("create_time", Long.valueOf(textMsg.getMsgTime()));
                contentValues.put("mcast_id", Long.valueOf(textMsg.getCastId()));
                contentValues.put("msg_key", textMsg.getMsgKey());
                contentValues.put("is_read", Boolean.valueOf(textMsg.isMsgRead()));
                contentValues.put("priority", Long.valueOf(textMsg.getPriority()));
                contentValues.put("contacter", Long.valueOf(textMsg.getContacter()));
                j = openDatabase.insert(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, contentValues);
            }
        } catch (Exception e) {
            LogUtils.d(TAG, "addReliableMsg:" + e);
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3509=5, 3510=4] */
    public long getMaxReliableMsgId(long j) {
        long j2;
        Cursor cursor = null;
        String str = "select max(msgid) as max_msg_id from " + TableDefine.DB_TABLE_RELIABLE_MESSAGE + " where mcast_id = " + j;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "getMaxReliableMsgId db is null!");
                j2 = -1;
            } else {
                try {
                    try {
                        Cursor rawQuery = openDatabase.rawQuery(str, null);
                        if (rawQuery != null) {
                            try {
                                if (rawQuery.moveToNext()) {
                                    j2 = rawQuery.getLong(rawQuery.getColumnIndex("max_msg_id"));
                                    if (rawQuery != null) {
                                        rawQuery.close();
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                cursor = rawQuery;
                                LogUtils.e(TAG, "getMaxReliableMsgId:", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                j2 = 0;
                                return j2;
                            } catch (Throwable th) {
                                th = th;
                                cursor = rawQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    j2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3539=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[Catch: all -> 0x00a7, TRY_ENTER, TryCatch #3 {, blocks: (B:13:0x006b, B:14:0x006e, B:29:0x00a3, B:30:0x00a6, B:23:0x0098, B:24:0x009b), top: B:40:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3 A[Catch: all -> 0x00a7, TryCatch #3 {, blocks: (B:13:0x006b, B:14:0x006e, B:29:0x00a3, B:30:0x00a6, B:23:0x0098, B:24:0x009b), top: B:40:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isReliableMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        Cursor cursor;
        String[] strArr;
        boolean z;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            try {
                long msgId = chatMsg.getMsgId();
                String msgKey = chatMsg.getMsgKey();
                StringBuilder sb = new StringBuilder();
                sb.append("msgid").append(" = ?");
                if (TextUtils.isEmpty(msgKey)) {
                    strArr = new String[]{String.valueOf(msgId)};
                } else {
                    sb.append(" OR ").append("msg_key").append(" = ?");
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(msgKey)};
                }
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                z = true;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return z;
                            }
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "isReliableMsgExist e :" + e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                z = false;
                if (cursor != null) {
                }
                return z;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    public long deleteExpiredReliableMsgs() {
        long j = -1;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "deleteExpiredReliableMsgs db is null!");
            } else {
                try {
                    j = openDatabase.delete(TableDefine.DB_TABLE_RELIABLE_MESSAGE, "create_time < ?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - CAST_RELIABLE_MSG_EXPIRED_TIME)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e);
                }
            }
        }
        return j;
    }

    public long deleteExpiredDupMsgs() {
        long j = -1;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "deleteExpiredDupMsgs db is null!");
            } else {
                try {
                    j = openDatabase.delete(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, "input_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 259200)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredDupMsgs :", e);
                }
            }
        }
        return j;
    }

    public int updateChatMsgContent(ChatMsg chatMsg) {
        int i = -1;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "updateChatMsgContent db is null!");
            } else {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content", chatMsg.getMsgContent());
                    i = openDatabase.update("message", contentValues, "msgid = ?", new String[]{String.valueOf(chatMsg.getMsgId())});
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "updateChatMsgContent:", e);
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3648=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x005f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.android.imsdk.chatmessage.messages.ChatMsg] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    public ChatMsg getMsgByMsgId(long j) {
        ?? r2;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        SQLiteDatabase openDatabase = openDatabase();
        try {
            if (openDatabase == null) {
                LogUtils.e(TAG, "getMsgByMsgId db is null!");
            } else {
                try {
                    String[] strArr = {String.valueOf(j)};
                    r2 = "select * from message where msgid = ? limit " + Math.abs(1);
                    try {
                        try {
                            synchronized (mSyncLock) {
                                try {
                                    Cursor rawQuery = openDatabase.rawQuery(r2, strArr);
                                    if (rawQuery != null && rawQuery.moveToNext()) {
                                        r0 = construChatMsg(rawQuery);
                                    }
                                    if (rawQuery != null) {
                                        rawQuery.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getMsgByMsgId:", e);
                            if (r2 != 0) {
                                r2.close();
                            }
                            return r0;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    r2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                        r0.close();
                    }
                    throw th;
                }
            }
            return r0;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
