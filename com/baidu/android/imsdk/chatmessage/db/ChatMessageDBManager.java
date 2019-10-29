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
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.chatuser.request.IMGetMemberListRequest;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChatMessageDBManager extends DBBase {
    private static final long CAST_RELIABLE_MSG_EXPIRED_TIME = 172800;
    private static final String TAG = ChatMessageDBManager.class.getSimpleName();
    private static ChatMessageDBManager mInstance = null;
    private List<ChatMessageDbOberser> mObservers = null;

    /* loaded from: classes6.dex */
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
            ArrayList<ChatMsg> fetchMsg = fetchMsg(entry.getKey(), 0L, 1L);
            if (fetchMsg.size() > 0) {
                ChatMsg chatMsg = fetchMsg.get(0);
                String localUrl = chatMsg instanceof HtmlMsg ? chatMsg.getLocalUrl() : chatMsg.getRecommendDescription();
                long newMsgNum = getNewMsgNum(key);
                int i = newMsgNum >= 0 ? (int) (newMsgNum + intValue) : intValue;
                int clickState = Utility.getClickState(chatMsg);
                String str = "";
                if (key.getCategory() == 0 && (key.getContacter() & Constants.PAFLAG) != 0) {
                    if (!chatMsg.isSelf(this.mContext)) {
                        str = chatMsg.getExtLog();
                    } else {
                        ArrayList<ChatMsg> fetchMsg2 = fetchMsg(key, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                        if (fetchMsg2 != null && fetchMsg2.size() > 0) {
                            str = fetchMsg2.get(0).getExtLog();
                        }
                    }
                }
                recordLastMsg(key, localUrl, chatMsg.getMsgTime(), i, 0, clickState, chatMsg.isStarMessage(), str);
            }
        }
    }

    public void recordLastMsg(ChatObject chatObject, String str, long j, int i, int i2, int i3, boolean z, String str2) {
        LogUtils.d(TAG, "recordSendLastMsg " + chatObject.toString());
        ChatSession chatRecord = getInstance(this.mContext).getChatRecord(chatObject);
        if (chatRecord == null) {
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

    public long createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j) {
        ChatMsg chatMsg;
        int unReadMsgCount;
        ArrayList<ChatMsg> fetchMsg;
        if (getChatSession(chatObject) != null) {
            return 0L;
        }
        int category = chatObject.getCategory();
        long contacter = chatObject.getContacter();
        String str5 = "";
        synchronized (mSyncLock) {
            if (category == 0 && i == 0) {
                contacter = IMUserManager.getInstance(this.mContext).getBuidByUK(contacter);
                if (IMGetMemberListRequest.buid2NickMap.keySet().contains(contacter + "")) {
                    str5 = IMGetMemberListRequest.buid2NickMap.get(contacter + "");
                    IMGetMemberListRequest.buid2NickMap.remove(contacter + "");
                }
            }
            String str6 = str5;
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
                    fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 1L);
                }
                if (fetchMsg == null) {
                    LogUtils.e(TAG, "updateChatRecordName fetchmsg error! ");
                    return -1L;
                } else if (fetchMsg.size() == 0) {
                    LogUtils.e(TAG, "updateChatRecordName  msgs.size() = 0! ");
                    return 0L;
                } else {
                    chatMsg = fetchMsg.get(0);
                }
            } else {
                chatMsg = draftMsg;
            }
            String str7 = "";
            if (chatObject.getCategory() == 0 && (chatObject.getContacter() & Constants.PAFLAG) != 0) {
                if (!chatMsg.isSelf(this.mContext)) {
                    str7 = chatMsg.getExtLog();
                } else {
                    ArrayList<ChatMsg> fetchMsg2 = fetchMsg(chatObject, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                    if (fetchMsg2 != null && fetchMsg2.size() > 0) {
                        str7 = fetchMsg2.get(0).getExtLog();
                    }
                }
                chatSession.addExt(LogConfig.LOG_EXT_LOG, str7);
            }
            if (1 == chatObject.getCategory()) {
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
            if (chatMsg.isStarMessage()) {
                chatSession.setChatType(4);
            }
            if (!TextUtils.isEmpty(str6)) {
                chatSession.setNickName(str6);
            }
            return getInstance(this.mContext).updateChatSession(1, chatSession);
        }
    }

    public void updateSessionClass(PaInfo paInfo) {
        ChatSession chatRecord = getChatRecord(new ChatObject(this.mContext, 0, paInfo.getPaId(), -1L, -1));
        if (chatRecord != null) {
            LogUtils.d(TAG, "syncpa session " + paInfo.getPaId());
            chatRecord.setClassType(paInfo.getClassType());
            chatRecord.setClassTitle(paInfo.getClassTitle());
            chatRecord.setClassAvatar(paInfo.getClassavatar());
            chatRecord.setClassShow(paInfo.getClassshow());
            chatRecord.setMarkTop(paInfo.getMarkTop());
            chatRecord.setMarkTopTime(paInfo.getMarkTopTime());
            updateChatSession(1, chatRecord);
        }
    }

    public int updateChatSessionNickName(ChatSession chatSession) {
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
                contentValues.put("nickname", chatSession.getNickName());
                int update = openDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, addPaidCondition("category =? AND contacter = ?", "paid", chatSession.getPaid()), new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())});
                if (update > 0) {
                    notifyDbChange(1, getChatRecordInternal(openDatabase, new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter())));
                }
                if (openDatabase != null) {
                    closeDatabase();
                }
                return update;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "updateChatSessionNickName:", e);
                if (openDatabase != null) {
                    closeDatabase();
                }
                return -1;
            }
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
                if (openDatabase != null) {
                    closeDatabase();
                }
                return update;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "updateChatSessionName:", e);
                if (openDatabase != null) {
                    closeDatabase();
                }
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
                if (openDatabase != null) {
                    closeDatabase();
                }
                return update;
            } catch (Exception e) {
                LogUtils.e(TAG, "updateChatRecord:", e);
                if (openDatabase != null) {
                    closeDatabase();
                }
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
            contentValues.put(TableDefine.SessionColumns.COLUMN_WEIGHT, Integer.valueOf(chatSession.getWeight()));
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
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [505=5, 506=4] */
    public boolean isRecordExist(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            try {
                if (sQLiteDatabase == null) {
                    return false;
                }
                try {
                    cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "category = ? AND contacter = ? AND paid =?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getPaid())}, null, null, null);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [561=5, 562=4, 564=4, 565=4] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0107 A[Catch: all -> 0x0110, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000f, B:27:0x00e9, B:29:0x00ee, B:30:0x00f1, B:33:0x00f7, B:35:0x00fc, B:36:0x00ff, B:21:0x00db, B:23:0x00e0, B:24:0x00e3, B:41:0x0107, B:43:0x010c, B:44:0x010f), top: B:54:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c A[Catch: all -> 0x0110, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000f, B:27:0x00e9, B:29:0x00ee, B:30:0x00f1, B:33:0x00f7, B:35:0x00fc, B:36:0x00ff, B:21:0x00db, B:23:0x00e0, B:24:0x00e3, B:41:0x0107, B:43:0x010c, B:44:0x010f), top: B:54:0x0004 }] */
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
                        if (openDatabase != null) {
                            closeDatabase();
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
                    if (openDatabase != null) {
                        closeDatabase();
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    if (openDatabase != null) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [640=4, 641=4, 637=5, 638=4] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0173 A[Catch: all -> 0x017c, TryCatch #2 {, blocks: (B:11:0x001e, B:14:0x002b, B:49:0x0155, B:51:0x015a, B:52:0x015d, B:56:0x0164, B:58:0x0169, B:59:0x016c, B:42:0x0144, B:44:0x0149, B:45:0x014c, B:63:0x0173, B:65:0x0178, B:66:0x017b), top: B:76:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0178 A[Catch: all -> 0x017c, TryCatch #2 {, blocks: (B:11:0x001e, B:14:0x002b, B:49:0x0155, B:51:0x015a, B:52:0x015d, B:56:0x0164, B:58:0x0169, B:59:0x016c, B:42:0x0144, B:44:0x0149, B:45:0x014c, B:63:0x0173, B:65:0x0178, B:66:0x017b), top: B:76:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatSession> getChatRecords(long j, long j2, long j3, List<Integer> list) {
        Cursor cursor;
        if (list == null || (list != null && list.size() > 0 && list.contains(19))) {
            updateInteractiveMsgChatSession();
        }
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
                            if (openDatabase != null) {
                                closeDatabase();
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        return arrayList;
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "getChatRecords:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
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
                if (openDatabase != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [704=4, 705=4, 701=5, 702=4] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016c A[Catch: all -> 0x0175, TryCatch #2 {, blocks: (B:4:0x0003, B:7:0x0010, B:42:0x014e, B:44:0x0153, B:45:0x0156, B:49:0x015d, B:51:0x0162, B:52:0x0165, B:35:0x013d, B:37:0x0142, B:38:0x0145, B:56:0x016c, B:58:0x0171, B:59:0x0174), top: B:69:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0171 A[Catch: all -> 0x0175, TryCatch #2 {, blocks: (B:4:0x0003, B:7:0x0010, B:42:0x014e, B:44:0x0153, B:45:0x0156, B:49:0x015d, B:51:0x0162, B:52:0x0165, B:35:0x013d, B:37:0x0142, B:38:0x0145, B:56:0x016c, B:58:0x0171, B:59:0x0174), top: B:69:0x0003 }] */
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
                            if (openDatabase != null) {
                                closeDatabase();
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        return arrayList;
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatRecords:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
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
                if (openDatabase != null) {
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
        int i2 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_WEIGHT));
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
            if (!TextUtils.isEmpty(string2)) {
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
                if (openDatabase != null) {
                    closeDatabase();
                }
                return delete;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "delChatRecord:", e);
                if (openDatabase != null) {
                    closeDatabase();
                }
                return -1L;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [876=4] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed A[Catch: all -> 0x00f6, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x0015, B:7:0x001d, B:10:0x0020, B:21:0x0087, B:23:0x008c, B:24:0x008f, B:43:0x00ed, B:45:0x00f2, B:46:0x00f5, B:35:0x00dd, B:37:0x00e2, B:38:0x00e5), top: B:56:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f2 A[Catch: all -> 0x00f6, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x0015, B:7:0x001d, B:10:0x0020, B:21:0x0087, B:23:0x008c, B:24:0x008f, B:43:0x00ed, B:45:0x00f2, B:46:0x00f5, B:35:0x00dd, B:37:0x00e2, B:38:0x00e5), top: B:56:0x0007 }] */
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
                                if (openDatabase != null) {
                                    closeDatabase();
                                }
                                return -1L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (openDatabase != null) {
                                    closeDatabase();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            if (openDatabase != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    j = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, "classtype = ? AND chat_type = ?", strArr);
                    for (int i = 0; i < arrayList.size(); i++) {
                        openDatabase.delete("message", "from_user = ?", new String[]{String.valueOf(arrayList.get(i))});
                    }
                } else {
                    j = -1;
                }
                LogUtils.d(TAG, "HBBH delChatRecordForClassTypeOne num = " + j);
                if (cursor != null) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    closeDatabase();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [909=5, 910=4] */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [939=5, 940=4, 942=4, 943=4] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080 A[Catch: all -> 0x0089, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000a, B:15:0x004e, B:17:0x0053, B:18:0x0056, B:21:0x005b, B:23:0x0060, B:24:0x0063, B:37:0x0080, B:39:0x0085, B:40:0x0088, B:30:0x0072, B:32:0x0077, B:33:0x007a), top: B:50:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085 A[Catch: all -> 0x0089, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000a, B:15:0x004e, B:17:0x0053, B:18:0x0056, B:21:0x005b, B:23:0x0060, B:24:0x0063, B:37:0x0080, B:39:0x0085, B:40:0x0088, B:30:0x0072, B:32:0x0077, B:33:0x007a), top: B:50:0x0004 }] */
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
                                if (openDatabase != null) {
                                    closeDatabase();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return constructChatRecord;
                            }
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getChatRecord:", e);
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                if (openDatabase != null) {
                    closeDatabase();
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
                if (openDatabase != null) {
                }
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [973=5, 974=4, 976=4, 977=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x000c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.baidu.android.imsdk.chatmessage.ChatSession] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public ChatSession getChatRecord(int i, long j, long j2) {
        ?? openDatabase;
        Cursor cursor;
        synchronized (mSyncLock) {
            openDatabase = openDatabase();
            Cursor cursor2 = null;
            try {
                if (openDatabase == 0) {
                    openDatabase = 0;
                } else {
                    try {
                        cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", j2), new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        if (openDatabase != 0) {
                            closeDatabase();
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e2) {
                            e = e2;
                            LogUtils.e(TAG, "getChatRecord:", e);
                            if (openDatabase != 0) {
                                closeDatabase();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            openDatabase = 0;
                            return openDatabase;
                        }
                        if (cursor.moveToNext()) {
                            ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                            if (openDatabase != 0) {
                                closeDatabase();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            openDatabase = constructChatRecord;
                        }
                    }
                    if (openDatabase != 0) {
                        closeDatabase();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    openDatabase = 0;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
            }
        }
        return openDatabase;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1006=5, 1007=4, 1009=4, 1010=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0072 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.android.imsdk.chatmessage.ChatSession] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager] */
    public ChatSession getChatRecordByContacter(ChatObject chatObject) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            ?? openDatabase = openDatabase();
            try {
                if (openDatabase == 0) {
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, "category = ? AND contacter=?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null, null);
                } catch (Exception e) {
                    e = e;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (openDatabase != 0) {
                        closeDatabase();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                if (cursor != null) {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        LogUtils.e(TAG, "getChatRecord:", e);
                        if (openDatabase != 0) {
                            closeDatabase();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        openDatabase = 0;
                        return openDatabase;
                    }
                    if (cursor.moveToNext()) {
                        ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                        if (openDatabase != 0) {
                            closeDatabase();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        openDatabase = constructChatRecord;
                        return openDatabase;
                    }
                }
                if (openDatabase != 0) {
                    closeDatabase();
                }
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase = 0;
                return openDatabase;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
            }
        }
    }

    public int getNewMsgNum(ChatObject chatObject) {
        if (1 == chatObject.getCategory()) {
            return GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
        }
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            try {
                int newMsgNum = getNewMsgNum(openDatabase, chatObject);
                LogUtils.d(TAG, "getNewMsgNum: " + newMsgNum);
                if (openDatabase != null) {
                    closeDatabase();
                }
                return newMsgNum;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "getNewMsgNum:", e);
                if (openDatabase != null) {
                    closeDatabase();
                }
                return 0;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1070=5, 1071=4] */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1158=6, 1159=6] */
    private long addMsg(ChatMsg chatMsg) {
        long j = -1;
        if (chatMsg != null && (chatMsg.getCategory() == 0 || 1 == chatMsg.getCategory() || 2 == chatMsg.getCategory())) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                try {
                    if (openDatabase == null) {
                        LogUtils.d(TAG, "getWritableDb fail!");
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                    } else {
                        int status = chatMsg.getStatus();
                        if (status == 1 && chatMsg.getRowId() != -1) {
                            LogUtils.d(TAG, "tiaoshi not insert for: status=sending rowid != -1");
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                        } else if (status == 1 || status == 3 || isMsgExist(openDatabase, chatMsg) <= 0) {
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
                            j = openDatabase.insert("message", null, contentValues);
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                        } else {
                            LogUtils.d(TAG, "tiaoshi not exception path!");
                            j = -2;
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                        }
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "addMsg:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            } catch (Throwable th) {
                if (openDatabase != null) {
                    closeDatabase();
                }
                throw th;
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1198=4] */
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1251=5, 1252=5] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00d0 -> B:31:0x0004). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d2 -> B:31:0x0004). Please submit an issue!!! */
    private long dupMsgAddHandler(ChatMsg chatMsg) {
        long j = -1;
        if (chatMsg != null && (chatMsg.getChatType() == 24 || chatMsg.getMsgType() != 20)) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                try {
                    if (openDatabase == null) {
                        LogUtils.d(TAG, "dupMsgAddHandler getWritableDb fail!");
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                    } else if (isDuplicateMsg(openDatabase, chatMsg) > 0) {
                        LogUtils.d(TAG, "dupMsgAddHandler isDuplicateMsg = true");
                        j = -2;
                        if (openDatabase != null) {
                            closeDatabase();
                        }
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "dupMsgAddHandler:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            } catch (Throwable th) {
                if (openDatabase != null) {
                    closeDatabase();
                }
                throw th;
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1295=4] */
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
        String senderUid;
        if (arrayList != null) {
            synchronized (mSyncLock) {
                String uid = AccountManagerImpl.getInstance(this.mContext).getUid();
                arrayList2 = new ArrayList<>();
                ArrayList<ChatMsg> arrayList3 = new ArrayList<>();
                HashMap<ChatObject, Integer> hashMap = new HashMap<>();
                HashMap hashMap2 = new HashMap();
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
                                } else if (chatMsg.getCategory() == 0 && (Constants.PAFLAG & contacter) == 0) {
                                    if (uid.equals(chatMsg.getSenderUid())) {
                                        senderUid = getMsgtoBduid(chatMsg);
                                    } else {
                                        senderUid = chatMsg.getSenderUid();
                                    }
                                    if (!TextUtils.isEmpty(senderUid) && !hashMap2.keySet().contains(senderUid)) {
                                        hashMap2.put(senderUid, Long.valueOf(contacter));
                                    }
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
                if (hashMap2 != null && hashMap2.size() > 0) {
                    IMGetMemberListRequest iMGetMemberListRequest = new IMGetMemberListRequest(this.mContext, hashMap2, false);
                    HttpHelper.executor(this.mContext, iMGetMemberListRequest, iMGetMemberListRequest);
                }
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1571=5, 1572=4, 1574=4] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082 A[Catch: all -> 0x0048, TryCatch #1 {, blocks: (B:4:0x0006, B:6:0x000c, B:15:0x0040, B:16:0x0043, B:17:0x0046, B:24:0x004f, B:25:0x0052, B:26:0x0055, B:39:0x0082, B:40:0x0085, B:41:0x0088, B:32:0x0075, B:33:0x0078, B:34:0x007b), top: B:48:0x0006 }] */
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
                            closeDatabase();
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
                            closeDatabase();
                            return -1L;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            closeDatabase();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                        }
                        closeDatabase();
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                closeDatabase();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1695=4, 1696=4] */
    public int delMsgsOfCertainContacter(ChatObject chatObject, long j) {
        int i = 1;
        if (1 == chatObject.getCategory()) {
            int delMsgsOfCertainContacter = GroupMessageDAOImpl.delMsgsOfCertainContacter(this.mContext, String.valueOf(chatObject.getContacter()), j);
            if (delMsgsOfCertainContacter < 0) {
                return delMsgsOfCertainContacter;
            }
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        return -1;
                    }
                    if (delMsgsOfCertainContacter < 0 || i < 0) {
                        delMsgsOfCertainContacter = -1;
                    }
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                    return delMsgsOfCertainContacter;
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "delMsg:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                    return -1;
                }
            }
        }
        return delMsgsOfCertainContacterForSingle(chatObject, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1777=5, 1778=5, 1779=5] */
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
                if (i < 0) {
                    if (openDatabase != null) {
                        openDatabase.endTransaction();
                        closeDatabase();
                    }
                    return -1;
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
                        closeDatabase();
                    }
                    return -1;
                }
                if (i < 0 || delete < 0) {
                    i = -1;
                } else {
                    openDatabase.setTransactionSuccessful();
                    if (z && chatSession != null) {
                        notifyDbChange(2, chatSession);
                    }
                }
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                    closeDatabase();
                }
                return i;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "delMsg:", e);
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                    closeDatabase();
                }
                return -1;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1861=4, 1862=4, 1863=4] */
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
                            closeDatabase();
                        }
                    } else if (openDatabase != null) {
                        openDatabase.endTransaction();
                        closeDatabase();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "delMsgsOfPaByPaId:", e);
                    if (openDatabase != null) {
                        openDatabase.endTransaction();
                        closeDatabase();
                    }
                }
            }
        }
        return i5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1896=4, 1897=4] */
    private int delMsgs(long[] jArr) {
        Exception e;
        int i = -1;
        int i2 = 0;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
            } else {
                if (jArr != null) {
                    try {
                    } catch (Exception e2) {
                        i2 = i;
                        e = e2;
                    }
                    if (jArr.length > 0) {
                        try {
                            String[] strArr = new String[2];
                            strArr[1] = String.valueOf(0);
                            int length = jArr.length;
                            i = 0;
                            while (i2 < length) {
                                strArr[0] = String.valueOf(jArr[i2]);
                                if ("msgid = ? AND status=?" != 0 && strArr != null) {
                                    i = (int) (openDatabase.delete("message", "msgid = ? AND status=?", strArr) + i);
                                }
                                i2++;
                            }
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "delMsg:", e);
                            if (openDatabase != null) {
                                closeDatabase();
                                i = i2;
                            } else {
                                i = i2;
                            }
                            return i;
                        }
                    }
                }
                if (openDatabase != null) {
                    closeDatabase();
                }
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
        synchronized (mSyncLock) {
            ChatSession chatSession = getChatSession(chatObject);
            if (chatSession != null && chatSession.getState() != 3) {
                if (i != 0) {
                    if (1 == chatObject.getCategory()) {
                        fetchMsg = GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    } else {
                        fetchMsg = fetchMsg(chatObject, 0L, 1L);
                    }
                    updateSession(true, chatSession, (fetchMsg == null || fetchMsg.size() <= 0) ? null : fetchMsg.get(0));
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1998=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[Catch: all -> 0x00b5, TryCatch #2 {, blocks: (B:4:0x0006, B:6:0x000c, B:15:0x00ac, B:16:0x00af, B:17:0x00b2, B:33:0x00e4, B:34:0x00e7, B:35:0x00ea, B:26:0x00d6, B:27:0x00d9, B:28:0x00dc), top: B:42:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnReadMsgCount(ChatObject chatObject) {
        Cursor cursor;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            try {
                cursor = openDatabase.query("message", new String[]{IMConstants.MSG_ROW_ID}, addPaidCondition(1 == chatObject.getCategory() ? "category=? AND contacter=? AND is_read=? AND type != 101" : "category=? AND contacter=? AND is_read=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(0)}, null, null, null);
                try {
                    try {
                        LogUtils.d(TAG, "getUnReadMsgCount> COLUMN_CATEGORY=" + chatObject.getCategory() + ", COLUMN_CONTACTER=" + chatObject.getContacter() + ", count = " + cursor.getCount());
                        int count = cursor.getCount();
                        if (cursor != null) {
                            cursor.close();
                        }
                        closeDatabase();
                        return count;
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, " getUnReadMsgCount:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        closeDatabase();
                        return -1;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                closeDatabase();
                throw th;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2130=4, 2131=4, 2133=4, 2134=4] */
    public void delExpiresMsgByChatType(int i) {
        List<PaInfo> queryPaInfoByChatType = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByChatType(i);
        if (queryPaInfoByChatType == null || queryPaInfoByChatType.size() <= 0) {
            return;
        }
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            if (openDatabase == null) {
                return;
            }
            openDatabase.beginTransaction();
            try {
                for (PaInfo paInfo : queryPaInfoByChatType) {
                    cursor = openDatabase.rawQuery("select expires_time from message where category=0 AND contacter=" + paInfo.getPaId() + " order by expires_time DESC limit 101,1000", null);
                    long j = 0;
                    long j2 = 0;
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getLong(cursor.getColumnIndex("expires_time"));
                        if (cursor.moveToLast()) {
                            j2 = cursor.getLong(cursor.getColumnIndex("expires_time"));
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                        cursor = null;
                    }
                    if (j == j2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        openDatabase.endTransaction();
                        closeDatabase();
                        return;
                    }
                    LogUtils.d(TAG, "get should delete msg expires tiem from " + j2 + " to " + j);
                    LogUtils.d(TAG, "delete expires & unusful msg count  = " + openDatabase.delete("message", addPaidCondition("expires_time<? AND expires_time>=? AND category=? AND contacter=?", "paid", paInfo.getPaId()), new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(0), String.valueOf(paInfo.getPaId())}));
                }
                openDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase.endTransaction();
                closeDatabase();
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "getMaxMsgid:", e);
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase.endTransaction();
                closeDatabase();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2185=4] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122 A[Catch: all -> 0x0021, TryCatch #0 {, blocks: (B:9:0x0019, B:11:0x001f, B:28:0x00f0, B:29:0x00f3, B:30:0x00f6, B:41:0x0122, B:42:0x0125, B:43:0x0128, B:36:0x0117, B:37:0x011a), top: B:49:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateInteractiveMsgChatSession() {
        Cursor cursor;
        Cursor cursor2;
        List<PaInfo> queryPaInfoByChatType = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByChatType(19);
        if (queryPaInfoByChatType == null || queryPaInfoByChatType.size() <= 0) {
            return;
        }
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return;
            }
            try {
                cursor = null;
                for (PaInfo paInfo : queryPaInfoByChatType) {
                    try {
                        try {
                            Cursor rawQuery = openDatabase.rawQuery("select msgid from message where is_read=0 AND category=0 AND contacter=" + paInfo.getPaId() + " AND expires_time>" + ((System.currentTimeMillis() / 1000) + "") + " limit 100", null);
                            if (rawQuery != null) {
                                int count = rawQuery.getCount();
                                LogUtils.d(TAG, "update chatsession unread msg count = " + count);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM, Integer.valueOf(count));
                                openDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, addPaidCondition("category =? AND contacter = ?", "paid", paInfo.getPaId()), new String[]{String.valueOf(0), String.valueOf(paInfo.getPaId())});
                            }
                            if (rawQuery != null) {
                                rawQuery.close();
                                cursor2 = null;
                            } else {
                                cursor2 = rawQuery;
                            }
                            cursor = cursor2;
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, " updateInteractiveMsgChatSession:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            closeDatabase();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        closeDatabase();
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                closeDatabase();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                closeDatabase();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[Catch: Exception -> 0x00da, all -> 0x00fe, TryCatch #0 {Exception -> 0x00da, blocks: (B:22:0x002e, B:24:0x0034, B:25:0x004e, B:27:0x0054, B:28:0x0073, B:29:0x009c, B:31:0x00a5, B:32:0x00bd, B:34:0x00c4, B:36:0x00ca), top: B:53:0x002e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x0026, TRY_ENTER, TryCatch #3 {, blocks: (B:13:0x001e, B:15:0x0024, B:38:0x00d1, B:39:0x00d4, B:40:0x00d7, B:45:0x00f7, B:46:0x00fa, B:22:0x002e, B:24:0x0034, B:25:0x004e, B:27:0x0054, B:28:0x0073, B:29:0x009c, B:31:0x00a5, B:32:0x00bd, B:34:0x00c4, B:36:0x00ca, B:43:0x00db), top: B:55:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCount(List<Integer> list) {
        String str;
        Cursor cursor = null;
        int i = 0;
        if (list != null && list.size() > 0) {
            if (list.contains(19)) {
                updateInteractiveMsgChatSession();
            }
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
                            closeDatabase();
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
                            closeDatabase();
                        }
                    }
                    str = "";
                    cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
                    if (cursor != null) {
                        i = cursor.getInt(0);
                    }
                    if (cursor != null) {
                    }
                    closeDatabase();
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
                    closeDatabase();
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, " getNewMsgCount:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
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
                        closeDatabase();
                    }
                }
                cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
                if (cursor != null && cursor.moveToNext()) {
                    i = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                closeDatabase();
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
            ArrayList<ChatMsg> fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 1L);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2406=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085 A[Catch: all -> 0x0056, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x004b, B:18:0x0050, B:19:0x0054, B:34:0x0085, B:36:0x008a, B:37:0x008d, B:28:0x0077, B:30:0x007c), top: B:46:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a A[Catch: all -> 0x0056, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x004b, B:18:0x0050, B:19:0x0054, B:34:0x0085, B:36:0x008a, B:37:0x008d, B:28:0x0077, B:30:0x007c), top: B:46:0x0004 }] */
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
                            if (openDatabase != null) {
                                closeDatabase();
                            }
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (openDatabase != null) {
                    closeDatabase();
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
                if (openDatabase != null) {
                }
                if (cursor != null) {
                }
                throw th;
            }
            return chatMsg;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2438=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007e A[Catch: all -> 0x004f, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x0044, B:18:0x0049, B:19:0x004d, B:34:0x007e, B:36:0x0083, B:37:0x0086, B:28:0x0070, B:30:0x0075), top: B:47:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083 A[Catch: all -> 0x004f, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x0044, B:18:0x0049, B:19:0x004d, B:34:0x007e, B:36:0x0083, B:37:0x0086, B:28:0x0070, B:30:0x0075), top: B:47:0x0004 }] */
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
                            if (openDatabase != null) {
                                closeDatabase();
                            }
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (openDatabase != null) {
                    closeDatabase();
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
                if (openDatabase != null) {
                }
                if (cursor != null) {
                }
                throw th;
            }
            return chatMsg;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01b7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0315  */
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
                                for (int i9 = 0; i9 < length; i9++) {
                                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i9);
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
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                i = -1;
            } else {
                try {
                    i = openDatabase.delete("message", "_id = ? ", new String[]{String.valueOf(j)});
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "deleteChatMsg:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                        i = 0;
                    } else {
                        i = 0;
                    }
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
                fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 1L);
            }
            if (fetchMsg == null || fetchMsg.size() <= 0) {
                z = true;
            } else {
                chatMsg = fetchMsg.get(0);
                z = true;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2736=5, 2737=4, 2739=4, 2740=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0081 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    public ArrayList<ChatMsg> fetchMsg(String str, String str2) {
        ?? r2;
        Cursor cursor = null;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        SQLiteDatabase openDatabase = openDatabase();
        try {
            if (openDatabase == null) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                String[] strArr = {str2, str};
                r2 = "select * from message where " + ("contacter = ? AND _id = ?  AND status = 2");
                try {
                    try {
                        synchronized (mSyncLock) {
                            try {
                                Cursor rawQuery = openDatabase.rawQuery(r2, strArr);
                                if (rawQuery == null || rawQuery.getCount() == 0) {
                                    LogUtils.d(TAG, "resend fetchmsg cursor is null " + str);
                                    if (openDatabase != 0) {
                                        closeDatabase();
                                    }
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
                                if (openDatabase != 0) {
                                    closeDatabase();
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
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e) {
                    e = e;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "fetchMsg:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                    if (r2 != 0) {
                        r2.close();
                        return null;
                    }
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                r2 = 0;
            } catch (Throwable th3) {
                th = th3;
                if (openDatabase != null) {
                    closeDatabase();
                }
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2883=7, 2884=6, 2886=6, 2887=6] */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x029d, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "construChatMsg msg is null ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02a6, code lost:
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02a7, code lost:
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02ae, code lost:
        if (r9.moveToPrevious() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b0, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "cursor is moveToPrevious failed!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02b9, code lost:
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02ba, code lost:
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02bb, code lost:
        if (r10 != null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02bd, code lost:
        closeDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02c0, code lost:
        if (r3 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c2, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02c5, code lost:
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:?, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:?, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:?, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0143, code lost:
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0146, code lost:
        if (r10 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0148, code lost:
        closeDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x014b, code lost:
        if (r9 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x014d, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x022e, code lost:
        r2 = getCursorMoveDirection(r22, r16, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0232, code lost:
        if (r2 != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0238, code lost:
        if (r9.moveToLast() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x023a, code lost:
        if (r10 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x023c, code lost:
        closeDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x023f, code lost:
        if (r9 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0241, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x024b, code lost:
        if (r9.moveToFirst() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x024d, code lost:
        if (r10 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x024f, code lost:
        closeDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0252, code lost:
        if (r9 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0254, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x025a, code lost:
        r3 = construChatMsg(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x025e, code lost:
        if (r3 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0260, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "msgid : " + r3.getMsgId());
        r8.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0280, code lost:
        if (r2 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0286, code lost:
        if (r9.moveToNext() != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0288, code lost:
        com.baidu.android.imsdk.utils.LogUtils.d(com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG, "cursor is moveToNext failed!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0290, code lost:
        if (r10 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0292, code lost:
        closeDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0295, code lost:
        if (r9 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0297, code lost:
        r9.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0223  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01fe -> B:63:0x01ff). Please submit an issue!!! */
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
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
            if (chatObject.getContacter() == 17) {
                strArr = new String[]{String.valueOf(21), String.valueOf(j), String.valueOf(0)};
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
            String addPaidCondition = chatObject.getCategory() != 17 ? addPaidCondition(str6, "paid", chatObject.getPaid()) : str6;
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
                        if (construChatMsg != null && !construChatMsg.isExpires()) {
                            arrayList.add(construChatMsg);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    closeDatabase();
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e);
                if (cursor != null) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    closeDatabase();
                }
            }
            return arrayList;
        }
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

    private String getMsgtoBduid(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return "";
        }
        String jsonContent = chatMsg.getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return "";
        }
        try {
            return new JSONObject(jsonContent).optString("tobuid", "");
        } catch (Exception e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            return "";
        }
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3095=5, 3096=4, 3098=4, 3099=4] */
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
                        if (openDatabase != null) {
                            closeDatabase();
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
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3157=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[Catch: all -> 0x0054, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x0049, B:18:0x004e, B:19:0x0052, B:34:0x0083, B:36:0x0088, B:37:0x008b, B:28:0x0075, B:30:0x007a), top: B:46:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088 A[Catch: all -> 0x0054, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0012, B:16:0x0049, B:18:0x004e, B:19:0x0052, B:34:0x0083, B:36:0x0088, B:37:0x008b, B:28:0x0075, B:30:0x007a), top: B:46:0x0004 }] */
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
                            if (openDatabase != null) {
                                closeDatabase();
                            }
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
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (openDatabase != null) {
                    closeDatabase();
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
                if (openDatabase != null) {
                }
                if (cursor != null) {
                }
                throw th;
            }
            return chatMsg;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3213=4] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec A[Catch: all -> 0x00f5, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x0026, B:7:0x002e, B:10:0x0031, B:21:0x007d, B:23:0x0082, B:24:0x0085, B:43:0x00ec, B:45:0x00f1, B:46:0x00f4, B:35:0x00dc, B:37:0x00e1, B:38:0x00e4), top: B:56:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1 A[Catch: all -> 0x00f5, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x0026, B:7:0x002e, B:10:0x0031, B:21:0x007d, B:23:0x0082, B:24:0x0085, B:43:0x00ec, B:45:0x00f1, B:46:0x00f4, B:35:0x00dc, B:37:0x00e1, B:38:0x00e4), top: B:56:0x0007 }] */
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
                                if (openDatabase != null) {
                                    closeDatabase();
                                }
                                return -1L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (openDatabase != null) {
                                    closeDatabase();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            if (openDatabase != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    j = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, "chat_type = ?", strArr);
                    openDatabase.delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "pasubtype = ?", strArr);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        openDatabase.delete("message", "from_user = ?", new String[]{String.valueOf(arrayList.get(i2))});
                    }
                } else {
                    j = -1;
                }
                LogUtils.d(TAG, "delChatRecordForChatType num = " + j);
                if (cursor != null) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    closeDatabase();
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3267=5, 3268=5] */
    private long addReliableMsg(@NonNull TextMsg textMsg) {
        long j = -1;
        SQLiteDatabase openDatabase = openDatabase();
        try {
            try {
                if (openDatabase == null) {
                    LogUtils.e(TAG, "addReliableMsg db is null!");
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } else if (isReliableMsgExist(openDatabase, textMsg)) {
                    LogUtils.d(TAG, "addReliableMsg exist msgId = " + textMsg.getMsgId() + ", or msgKey :" + textMsg.getMsgKey());
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(textMsg.getMsgId()));
                    contentValues.put("category", Integer.valueOf(textMsg.getCategory()));
                    contentValues.put("content", textMsg.getMsgContent());
                    contentValues.put("type", Integer.valueOf(textMsg.getRealMsgType()));
                    contentValues.put("from_user", Long.valueOf(textMsg.getFromUser()));
                    contentValues.put("create_time", Long.valueOf(textMsg.getMsgTime()));
                    contentValues.put("mcast_id", Long.valueOf(textMsg.getCastId()));
                    contentValues.put("msg_key", textMsg.getMsgKey());
                    contentValues.put("is_read", Boolean.valueOf(textMsg.isMsgRead()));
                    contentValues.put("priority", Long.valueOf(textMsg.getPriority()));
                    contentValues.put("contacter", Long.valueOf(textMsg.getContacter()));
                    j = openDatabase.insert(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, contentValues);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            } catch (Exception e) {
                LogUtils.d(TAG, "addReliableMsg:" + e);
                if (openDatabase != null) {
                    closeDatabase();
                }
            }
            return j;
        } catch (Throwable th) {
            if (openDatabase != null) {
                closeDatabase();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3296=4, 3293=5, 3294=4] */
    public long getMaxReliableMsgId(long j) {
        long j2;
        Cursor cursor = null;
        boolean z = false;
        Cursor cursor2 = null;
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
                                boolean moveToNext = rawQuery.moveToNext();
                                z = moveToNext;
                                if (moveToNext) {
                                    j2 = rawQuery.getLong(rawQuery.getColumnIndex("max_msg_id"));
                                    if (rawQuery != null) {
                                        rawQuery.close();
                                    }
                                    closeDatabase();
                                }
                            } catch (Exception e) {
                                e = e;
                                cursor2 = rawQuery;
                                LogUtils.e(TAG, "getMaxReliableMsgId:", e);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                closeDatabase();
                                cursor = cursor2;
                                j2 = 0;
                                return j2;
                            } catch (Throwable th) {
                                th = th;
                                cursor = rawQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                closeDatabase();
                                throw th;
                            }
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        closeDatabase();
                        cursor = z;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                j2 = 0;
            }
        }
        return j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3324=4] */
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
                    closeDatabase();
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e);
                    closeDatabase();
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
                    closeDatabase();
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredDupMsgs :", e);
                    closeDatabase();
                }
            }
        }
        return j;
    }
}
