package com.baidu.android.imsdk.chatmessage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
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
import com.baidu.android.imsdk.retrieve.util.RetrieveUtil;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatMessageDBManager extends DBBase {
    public static final long CAST_RELIABLE_MSG_EXPIRED_TIME = 172800;
    public static final String TAG = "ChatMessageDBManager";
    public static ChatMessageDBManager mInstance;
    public List<ChatMessageDbOberser> mObservers = null;

    /* loaded from: classes.dex */
    public interface ChatMessageDbOberser {
        void notifyDbChange(int i, ChatSession chatSession);
    }

    public ChatMessageDBManager(Context context) {
        setContext(context);
    }

    private String addPaidCondition(String str, String str2, long j) {
        return IMConfigInternal.getInstance().getIMConfig(this.mContext).getPaidCondition(str, str2, j);
    }

    private long addReliableMsg(@NonNull TextMsg textMsg) {
        SQLiteDatabase openDatabase = openDatabase();
        try {
            if (openDatabase == null) {
                LogUtils.e(TAG, "addReliableMsg db is null!");
                return -1L;
            } else if (isReliableMsgExist(openDatabase, textMsg)) {
                String str = TAG;
                LogUtils.d(str, "addReliableMsg exist msgId = " + textMsg.getMsgId() + ", or msgKey :" + textMsg.getMsgKey());
                return -1L;
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
                return openDatabase.insert(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, contentValues);
            }
        } catch (Exception e2) {
            String str2 = TAG;
            LogUtils.d(str2, "addReliableMsg:" + e2);
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x02c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatMsg construChatMsg(Cursor cursor) {
        int i;
        long j;
        String str;
        int i2;
        String str2;
        int i3;
        JSONObject optJSONObject;
        JSONObject jSONObject;
        String jSONObject2;
        ChatMsg newChatMsg;
        int i4 = cursor.getInt(cursor.getColumnIndex("_id"));
        int i5 = cursor.getInt(cursor.getColumnIndex("type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("from_user"));
        long j3 = cursor.getLong(cursor.getColumnIndex("msgid"));
        long j4 = cursor.getLong(cursor.getColumnIndex("time"));
        int i6 = cursor.getInt(cursor.getColumnIndex("is_read"));
        int i7 = cursor.getInt(cursor.getColumnIndex("status"));
        String string = cursor.getString(cursor.getColumnIndex("content"));
        int i8 = cursor.getInt(cursor.getColumnIndex("category"));
        long j5 = cursor.getLong(cursor.getColumnIndex("contacter"));
        int i9 = cursor.getInt(cursor.getColumnIndex("cmd"));
        String string2 = cursor.getString(cursor.getColumnIndex("local_url"));
        boolean z = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUMN_ISZHIDA)) == 1;
        boolean z2 = cursor.getInt(cursor.getColumnIndex("isclicked")) == 1;
        long j6 = cursor.getLong(cursor.getColumnIndex("paid"));
        int i10 = cursor.getInt(cursor.getColumnIndex("device_flag"));
        String string3 = cursor.getString(cursor.getColumnIndex("sendid"));
        String string4 = cursor.getString(cursor.getColumnIndex("buid"));
        String string5 = cursor.getString(cursor.getColumnIndex("msg_key"));
        long j7 = cursor.getLong(cursor.getColumnIndex("expires_time"));
        String string6 = cursor.getString(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_SERVICE_TYPE));
        int i11 = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TIPS_CODE));
        String string7 = cursor.getString(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TIPS));
        int i12 = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TEMPLATE));
        if (i5 == 80) {
            try {
                int i13 = i5;
                try {
                    try {
                        JSONObject jSONObject3 = new JSONObject(new JSONObject(new JSONObject(new JSONObject(string).optString("text")).optString("msg")).optString("ext"));
                        int optInt = jSONObject3.optInt("type", -1);
                        try {
                            if (optInt == 1) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("text", jSONObject3.optString("body"));
                                jSONObject2 = jSONObject4.toString();
                            } else if (optInt == 0) {
                                if (jSONObject3.has("content") && !jSONObject3.has("body")) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put("text", new JSONObject(jSONObject3.optString("content")).optString("text"));
                                    jSONObject2 = jSONObject5.toString();
                                } else {
                                    JSONArray jSONArray = new JSONArray(jSONObject3.optString("body"));
                                    int length = jSONArray.length();
                                    i2 = i12;
                                    str = string6;
                                    if (length == 1) {
                                        i = i4;
                                        try {
                                            optJSONObject = jSONArray.optJSONObject(0);
                                            jSONObject = new JSONObject();
                                            j = j2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            j = j2;
                                        }
                                        try {
                                            jSONObject.put("title", optJSONObject.optString("title"));
                                            jSONObject.put("article_url", optJSONObject.optString("url"));
                                            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject.optString("headImage"));
                                            str2 = jSONObject.toString();
                                            i3 = 1;
                                            i13 = 8;
                                        } catch (Exception e3) {
                                            e = e3;
                                            string = string;
                                            i5 = 8;
                                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                            LogUtils.e(TAG, "du construChatMsg:", e);
                                            newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i8, i5, i9);
                                            if (newChatMsg != null) {
                                            }
                                        }
                                    } else {
                                        i = i4;
                                        j = j2;
                                        str2 = string;
                                        i3 = 1;
                                    }
                                    if (length > i3) {
                                        i13 = 9;
                                        try {
                                            JSONArray jSONArray2 = new JSONArray();
                                            int i14 = 0;
                                            while (i14 < length) {
                                                JSONObject optJSONObject2 = jSONArray.optJSONObject(i14);
                                                int i15 = length;
                                                JSONObject jSONObject6 = new JSONObject();
                                                jSONObject6.put("title", optJSONObject2.optString("title"));
                                                jSONObject6.put("article_url", optJSONObject2.optString("url"));
                                                jSONObject6.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject2.optString("headImage"));
                                                jSONArray2.put(jSONObject6);
                                                i14++;
                                                length = i15;
                                                jSONArray = jSONArray;
                                            }
                                            JSONObject jSONObject7 = new JSONObject();
                                            jSONObject7.put("articles", jSONArray2);
                                            str2 = jSONObject7.toString();
                                        } catch (Exception e4) {
                                            e = e4;
                                            string = str2;
                                            i5 = 9;
                                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                            LogUtils.e(TAG, "du construChatMsg:", e);
                                            newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i8, i5, i9);
                                            if (newChatMsg != null) {
                                            }
                                        }
                                    }
                                    string = str2;
                                    i5 = i13;
                                }
                            } else {
                                i = i4;
                                j = j2;
                                str = string6;
                                i2 = i12;
                                try {
                                    string = jSONObject3.optString("content");
                                    i5 = optInt;
                                } catch (Exception e5) {
                                    e = e5;
                                    i5 = optInt;
                                    string = string;
                                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                    LogUtils.e(TAG, "du construChatMsg:", e);
                                    newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i8, i5, i9);
                                    if (newChatMsg != null) {
                                    }
                                }
                            }
                            string = jSONObject2;
                            i = i4;
                            j = j2;
                            str = string6;
                            i2 = i12;
                            i5 = 0;
                        } catch (Exception e6) {
                            e = e6;
                            i = i4;
                            j = j2;
                            str = string6;
                            i2 = i12;
                            string = string;
                            i5 = 0;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        i = i4;
                        j = j2;
                        str = string6;
                        i2 = i12;
                        i5 = i13;
                    }
                } catch (Exception e8) {
                    e = e8;
                    i = i4;
                    j = j2;
                    str = string6;
                    i2 = i12;
                    i5 = i13;
                }
            } catch (Exception e9) {
                e = e9;
                i = i4;
                j = j2;
                str = string6;
                i2 = i12;
            }
        } else {
            i = i4;
            j = j2;
            str = string6;
            i2 = i12;
        }
        newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i8, i5, i9);
        if (newChatMsg != null) {
            return null;
        }
        newChatMsg.setCategory(i8);
        newChatMsg.setContacter(j5);
        newChatMsg.setFromUser(j);
        newChatMsg.setMsgContent(string);
        newChatMsg.setRowId(i);
        newChatMsg.setMsgId(j3);
        newChatMsg.setMsgTime(j4);
        newChatMsg.setMsgReaded(i6);
        newChatMsg.setStatus(i7);
        newChatMsg.setCategory(i8);
        newChatMsg.setContacter(j5);
        newChatMsg.setNotifyCmd(i9);
        newChatMsg.setLocalUrl(string2);
        newChatMsg.setIsZhida(z);
        newChatMsg.setIsClicked(z2);
        newChatMsg.setPaid(j6);
        newChatMsg.setMsgType(i5);
        newChatMsg.setDeviceFlag(i10);
        newChatMsg.setSendMsgId(string3);
        newChatMsg.setSenderUid(string4);
        newChatMsg.setMsgKey(string5);
        newChatMsg.setExpiresTime(j7);
        newChatMsg.setServiceType(str);
        newChatMsg.setTipsCode(i11);
        newChatMsg.setTips(string7);
        newChatMsg.setTemplateType(i2);
        return newChatMsg;
    }

    private ChatSession constructChatRecord(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        int i;
        long j;
        long j2;
        int i2;
        String str;
        int i3;
        int i4;
        long j3;
        int i5;
        int i6;
        String str2;
        String str3;
        int i7;
        long j4;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i8;
        long j5;
        long j6;
        String senderUid;
        int i9 = cursor.getInt(cursor.getColumnIndex("category"));
        long j7 = cursor.getLong(cursor.getColumnIndex("contacter"));
        String string = cursor.getString(cursor.getColumnIndex("name"));
        String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG));
        long j8 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG_TIME));
        long j9 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME));
        long j10 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
        int i10 = cursor.getInt(cursor.getColumnIndex("weight"));
        int i11 = cursor.getInt(cursor.getColumnIndex("show"));
        int i12 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE));
        int i13 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CHAT_TYPE));
        String string3 = cursor.getString(cursor.getColumnIndex("icon_url"));
        int i14 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_STATE));
        int i15 = cursor.getInt(cursor.getColumnIndex("isclicked"));
        long j11 = cursor.getLong(cursor.getColumnIndex("paid"));
        int i16 = cursor.getInt(cursor.getColumnIndex("classtype"));
        int i17 = cursor.getInt(cursor.getColumnIndex("classshow"));
        String string4 = cursor.getString(cursor.getColumnIndex("classtitle"));
        String string5 = cursor.getString(cursor.getColumnIndex("classavatar"));
        int i18 = cursor.getInt(cursor.getColumnIndex("marktop"));
        long j12 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
        String string6 = cursor.getString(cursor.getColumnIndex("nickname"));
        String string7 = cursor.getString(cursor.getColumnIndex("extra"));
        String string8 = cursor.getString(cursor.getColumnIndex("v_portrait"));
        String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CERTIFICATION));
        String string10 = cursor.getString(cursor.getColumnIndex("vip_id"));
        int i19 = cursor.getInt(cursor.getColumnIndex("shield"));
        long j13 = cursor.getLong(cursor.getColumnIndex("shield_time"));
        if (i9 == 0 && i13 == 0) {
            long buidByUK = IMUserManager.getInstance(this.mContext).getBuidByUK(j7);
            if (buidByUK >= 0 || TextUtils.isEmpty(string2)) {
                i = i11;
                j = j10;
                j2 = j13;
                i2 = i12;
                str = string3;
                i3 = i14;
                i4 = i15;
                j3 = j9;
                i5 = i16;
                i6 = i17;
                str2 = string4;
                str3 = string5;
                i7 = i18;
                j4 = j11;
                str4 = string6;
                str5 = string7;
                str6 = string8;
                str7 = string9;
                str8 = string10;
                i8 = i19;
                j5 = j12;
            } else {
                i2 = i12;
                str = string3;
                i3 = i14;
                i4 = i15;
                i5 = i16;
                i6 = i17;
                str2 = string4;
                str3 = string5;
                i7 = i18;
                str4 = string6;
                str5 = string7;
                str6 = string8;
                str7 = string9;
                str8 = string10;
                i8 = i19;
                i = i11;
                j = j10;
                j2 = j13;
                j3 = j9;
                j4 = j11;
                j5 = j12;
                ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(0, j7, 1, (ChatMsg) null);
                if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
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
                                j6 = Long.valueOf(senderUid).longValue();
                                break;
                            } catch (NumberFormatException e2) {
                                LogUtils.e(TAG, "", e2);
                            }
                        }
                    }
                }
            }
            j6 = buidByUK;
        } else {
            i = i11;
            j = j10;
            j2 = j13;
            i2 = i12;
            str = string3;
            i3 = i14;
            i4 = i15;
            j3 = j9;
            i5 = i16;
            i6 = i17;
            str2 = string4;
            str3 = string5;
            i7 = i18;
            j4 = j11;
            str4 = string6;
            str5 = string7;
            str6 = string8;
            str7 = string9;
            str8 = string10;
            i8 = i19;
            j5 = j12;
            j6 = j7;
        }
        if (0 != j7) {
            if (!TextUtils.isEmpty(string2) || i13 == 27 || i13 == 17) {
                ChatSession chatSession = new ChatSession(i9, j7, j6, string);
                chatSession.setLastMsg(string2);
                chatSession.setLastMsgTime(j8);
                chatSession.setLastOpenTime(j3);
                chatSession.setNewMsgSum(j);
                chatSession.setWeight(i10);
                chatSession.setShow(i);
                chatSession.setCollectionType(i2);
                chatSession.setChatType(i13);
                chatSession.setIconUrl(str);
                chatSession.setState(i3);
                chatSession.setIsClicked(i4);
                chatSession.setPaid(j4);
                chatSession.setClassType(i5);
                chatSession.setClassTitle(str2);
                chatSession.setClassAvatar(str3);
                chatSession.setClassShow(i6);
                chatSession.setMarkTop(i7);
                chatSession.setMarkTopTime(j5);
                chatSession.setNickName(str4);
                chatSession.setExt(str5);
                chatSession.setVPortrait(str6);
                chatSession.setCertification(str7);
                chatSession.setVipId(str8);
                chatSession.setShield(i8);
                chatSession.setShieldTime(j2);
                return chatSession;
            }
            return null;
        }
        return new ChatSession(i9, j7, j6, string);
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

    private int delMsgs(long[] jArr) {
        int i;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            int i2 = -1;
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            if (jArr != null) {
                try {
                } catch (Exception e2) {
                    e = e2;
                }
                if (jArr.length > 0) {
                    try {
                        String[] strArr = new String[2];
                        strArr[1] = String.valueOf(0);
                        i = 0;
                        for (long j : jArr) {
                            try {
                                strArr[0] = String.valueOf(j);
                                i = (int) (i + openDatabase.delete("message", "msgid = ? AND status=?", strArr));
                            } catch (Exception e3) {
                                e = e3;
                                i2 = i;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, "delMsg:", e);
                                i = i2;
                                return i;
                            }
                        }
                        for (long j2 : jArr) {
                            long j3 = j2 + 1;
                            openDatabase.execSQL("delete from message where msgid=? and type in (?, ?, ?)", new Object[]{Long.valueOf(j3), Integer.valueOf((int) IMConstants.IM_MSG_TYPE_SHIELD_ME), 2001, Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL)});
                            LogUtils.e(TAG, "delete notSendButShowTipMsg :delete from message where msgid=? and type in (?, ?, ?), msgId :" + j3);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i2 = 0;
                    }
                    return i;
                }
            }
            return -1;
        }
    }

    private int delMsgsOfCertainContacterForSingle(ChatObject chatObject, long j) {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            int i = -1;
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            try {
                openDatabase.beginTransaction();
                String str = "contacter = ?  AND category = ?";
                boolean z = false;
                int i2 = 1;
                String[] strArr = {String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getCategory())};
                int i3 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
                if (i3 != 0) {
                    str = "contacter = ?  AND category = ? AND msgid <= " + j;
                }
                String addPaidCondition = addPaidCondition(str, "paid", chatObject.getPaid());
                int delete = addPaidCondition != null ? openDatabase.delete("message", addPaidCondition, strArr) : -1;
                long maxMsgid = getMaxMsgid(chatObject);
                ChatSession chatSession = null;
                if (i3 == 0 || maxMsgid <= j) {
                    String[] strArr2 = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
                    String addPaidCondition2 = addPaidCondition("category = ? AND contacter = ?", "paid", chatObject.getPaid());
                    chatSession = getChatRecordInternal(openDatabase, chatObject);
                    int delete2 = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, addPaidCondition2, strArr2);
                    i2 = delete2;
                    if (delete2 > 0) {
                        z = true;
                    }
                }
                if (i2 < 0) {
                    if (openDatabase != null) {
                        openDatabase.endTransaction();
                    }
                    return -1;
                }
                if (i2 >= 0) {
                    openDatabase.setTransactionSuccessful();
                    if (z && chatSession != null) {
                        notifyDbChange(2, chatSession);
                    }
                    i = delete;
                }
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return i;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "delMsg:", e2);
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return -1;
            }
        }
    }

    private int delMsgsOfPaByPaId(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            int i5 = -1;
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            try {
                openDatabase.beginTransaction();
                String[] strArr = {String.valueOf(j)};
                if (TextUtils.isEmpty("from_user = ? ")) {
                    i = -1;
                } else {
                    i = openDatabase.delete("message", "from_user = ? ", strArr);
                    String str = TAG;
                    LogUtils.d(str, "--delMsgsOfPaByPaId--delMsgs = " + i);
                }
                if (TextUtils.isEmpty("contacter = ? ")) {
                    i2 = -1;
                } else {
                    i2 = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "contacter = ? ", strArr);
                    String str2 = TAG;
                    LogUtils.d(str2, "--delMsgsOfPaByPaId--delChatRecord = " + i2);
                }
                if (TextUtils.isEmpty("paid = ? ")) {
                    i3 = -1;
                } else {
                    i3 = delete(openDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid = ? ", strArr);
                    String str3 = TAG;
                    LogUtils.d(str3, "--delMsgsOfPaByPaId--delPaInfoRecord = " + i3);
                }
                if (TextUtils.isEmpty("paid = ? ")) {
                    i4 = -1;
                } else {
                    i4 = delete(openDatabase, TableDefine.DB_TABLE_ZHIDAINFO, "paid = ? ", strArr);
                    String str4 = TAG;
                    LogUtils.d(str4, "--delMsgsOfPaByPaId--delZhiDaPaInfoRecord = " + i4);
                }
                if (i >= 0 || i2 >= 0 || i3 >= 0 || i4 >= 0) {
                    openDatabase.setTransactionSuccessful();
                    i5 = i;
                }
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return i5;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "delMsgsOfPaByPaId:", e2);
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return -1;
            }
        }
    }

    private int deleteDraftMsgForSingle(ChatObject chatObject) {
        synchronized (DBBase.mSyncLock) {
            int delete = delete("message", addPaidCondition("category=? AND contacter=? AND status=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(3)});
            if (delete <= 0) {
                return delete;
            }
            ArrayList<ChatMsg> fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
            ChatMsg chatMsg = null;
            if (fetchMsg != null && fetchMsg.size() > 0) {
                chatMsg = fetchMsg.get(0);
            } else if (fetchMsg != null) {
                fetchMsg.size();
            }
            updateSession(true, getChatSession(chatObject), chatMsg);
            return delete;
        }
    }

    private long dupMsgAddHandler(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1L;
        }
        if (chatMsg.getChatType() == 24 || chatMsg.getMsgType() != 20) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.d(TAG, "dupMsgAddHandler getWritableDb fail!");
                    return -1L;
                } else if (isDuplicateMsg(openDatabase, chatMsg) > 0) {
                    LogUtils.d(TAG, "dupMsgAddHandler isDuplicateMsg = true");
                    return -2L;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
                    contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                    contentValues.put("input_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                    contentValues.put("msg_key", chatMsg.getMsgKey());
                    return openDatabase.insert(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, null, contentValues);
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "dupMsgAddHandler:", e2);
                return -1L;
            }
        }
        return -1L;
    }

    private long existStudioMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        String[] strArr;
        synchronized (DBBase.mSyncLock) {
            long msgId = chatMsg.getMsgId();
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append("msgid");
            sb.append(" = ?)");
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getContacter())};
            } else {
                sb.append(" OR ");
                sb.append("msg_key");
                sb.append(" = ?");
                strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
            }
            StringBuilder insert = sb.insert(0, "((");
            insert.append(") AND ");
            insert.append("contacter");
            insert.append(" = ?)");
            String str = TAG;
            LogUtils.d(str, "existStudioMsg query sql = " + sb.toString());
            Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
            if (query == null || !query.moveToNext()) {
                if (query != null) {
                    query.close();
                }
                return -1L;
            }
            long j = query.getLong(query.getColumnIndex("_id"));
            if (query != null) {
                query.close();
            }
            return j;
        }
    }

    private ChatMsg generateStudioUsePaMsg(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("msgid"));
        int i = cursor.getInt(cursor.getColumnIndex("type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("from_user"));
        long j3 = cursor.getLong(cursor.getColumnIndex("input_time"));
        int i2 = cursor.getInt(cursor.getColumnIndex("category"));
        long j4 = cursor.getLong(cursor.getColumnIndex("contacter"));
        String string = cursor.getString(cursor.getColumnIndex("msg_key"));
        String string2 = cursor.getString(cursor.getColumnIndex("content"));
        int i3 = cursor.getInt(cursor.getColumnIndex("is_read"));
        ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i2, i, -1);
        if (newChatMsg == null) {
            return null;
        }
        newChatMsg.setCategory(i2);
        newChatMsg.setContacter(j4);
        newChatMsg.setFromUser(j2);
        newChatMsg.setMsgContent(string2);
        newChatMsg.setMsgId(j);
        newChatMsg.setMsgKey(string);
        newChatMsg.setMsgTime(j3);
        newChatMsg.setMsgReaded(i3);
        return newChatMsg;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x004f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    private ChatSession getChatRecordInternal(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        Cursor cursor;
        ?? r0 = 0;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            ChatSession constructChatRecord = constructChatRecord(sQLiteDatabase, cursor);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return constructChatRecord;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        LogUtils.e(TAG, "getChatRecord:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = chatObject;
        }
    }

    private ChatSession getChatSession(ChatObject chatObject) {
        return getInstance(this.mContext).getChatRecord(chatObject);
    }

    private long getContacter(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1L;
        }
        return chatMsg.getContacter();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private List<Long> getContacterByChatTypes(SQLiteDatabase sQLiteDatabase, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(list.get(i));
        }
        String str = "chat_type in (" + sb.toString() + ") ";
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select contacter from chatrecord where " + str, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("contacter"))));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getContacterByChatTypes:", e2);
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

    private boolean getCursorMoveDirection(boolean z, long j, long j2) {
        return (j <= 0 || j2 <= 0) ? !z : z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: int */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r12 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
        if (r12 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        return r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatMsg getDraftMsgForSingle(int i, long j) {
        Cursor cursor;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            r10 = null;
            r10 = null;
            r10 = null;
            ChatMsg chatMsg = null;
            try {
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getReadableDb fail!");
                    return null;
                }
                try {
                    cursor = openDatabase.query("message", null, "category=? AND contacter=? AND status=?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(3)}, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                chatMsg = construChatMsg(cursor);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getDraftMsg:", e);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = i;
            }
        }
    }

    public static ChatMessageDBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatMessageDBManager.class) {
                if (mInstance == null) {
                    mInstance = new ChatMessageDBManager(context);
                }
            }
        }
        return mInstance;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private List<Long> getUnreadContacterByChatTypes(SQLiteDatabase sQLiteDatabase, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(list.get(i));
        }
        String str = "chat_type in (" + sb.toString() + ")  AND " + TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM + ">0";
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select contacter from chatrecord where " + str, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("contacter"))));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getUnreadSessionByChatTypes:", e2);
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

    private boolean isDraftMsg(ChatMsg chatMsg) {
        return chatMsg != null && (chatMsg instanceof TextMsg) && chatMsg.getStatus() == 3;
    }

    private long isDuplicateMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        String[] strArr;
        synchronized (DBBase.mSyncLock) {
            long msgId = chatMsg.getMsgId();
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append("msgid");
            sb.append(" = ?)");
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getContacter())};
            } else {
                sb.append(" OR ");
                sb.append("msg_key");
                sb.append(" = ?");
                strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
            }
            StringBuilder insert = sb.insert(0, "((");
            insert.append(") AND ");
            insert.append("contacter");
            insert.append(" = ?)");
            String str = TAG;
            LogUtils.d(str, "isDuplicateMsg query sql = " + sb.toString());
            Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
            if (query == null || !query.moveToNext()) {
                if (query != null) {
                    query.close();
                }
                return -1L;
            }
            long j = query.getLong(query.getColumnIndex("_id"));
            if (query != null) {
                query.close();
            }
            return j;
        }
    }

    private long isMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        String[] strArr;
        synchronized (DBBase.mSyncLock) {
            long msgId = chatMsg.getMsgId();
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append("msgid");
            sb.append(" = ? AND ");
            sb.append("status");
            sb.append(" = ?)");
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getContacter())};
            } else {
                sb.append(" OR ");
                sb.append("msg_key");
                sb.append(" = ?");
                strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
            }
            StringBuilder insert = sb.insert(0, "((");
            insert.append(") AND ");
            insert.append("contacter");
            insert.append(" = ?)");
            Cursor query = sQLiteDatabase.query("message", null, sb.toString(), strArr, null, null, null, String.valueOf(1));
            if (query == null || !query.moveToNext()) {
                if (query != null) {
                    query.close();
                }
                return -1L;
            }
            long j = query.getLong(query.getColumnIndex("_id"));
            if (query != null) {
                query.close();
            }
            return j;
        }
    }

    private boolean isNeedInsertToDB(ChatMsg chatMsg) {
        if (2 == chatMsg.getCategory()) {
            int notifyCmd = chatMsg.getNotifyCmd();
            if (notifyCmd == 0) {
                delSysMsg(chatMsg.getCategory(), chatMsg.getFromUser(), 0);
            } else if (notifyCmd != 1) {
                if (notifyCmd != 60 && notifyCmd != 62) {
                    switch (notifyCmd) {
                    }
                }
                return false;
            } else {
                delSysMsg(chatMsg.getCategory(), chatMsg.getFromUser(), 1);
            }
        }
        return chatMsg.getMsgType() != 27;
    }

    private boolean isReliableMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        boolean z;
        String[] strArr;
        synchronized (DBBase.mSyncLock) {
            z = false;
            Cursor cursor = null;
            try {
                long msgId = chatMsg.getMsgId();
                String msgKey = chatMsg.getMsgKey();
                StringBuilder sb = new StringBuilder();
                sb.append("msgid");
                sb.append(" = ?");
                if (TextUtils.isEmpty(msgKey)) {
                    strArr = new String[]{String.valueOf(msgId)};
                } else {
                    sb.append(" OR ");
                    sb.append("msg_key");
                    sb.append(" = ?");
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(msgKey)};
                }
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        z = true;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "isReliableMsgExist e :" + e2);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        }
        return z;
    }

    private int markChatMsgClicked(ChatMsg chatMsg) {
        synchronized (DBBase.mSyncLock) {
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
            if (fetchMsg != null && fetchMsg.size() != 0) {
                if (chatMsg.getRowId() == fetchMsg.get(0).getRowId()) {
                    updateChatSession(chatMsg);
                }
                return update;
            }
            return 1009;
        }
    }

    private boolean notSendButShowTipMsg(ChatMsg chatMsg) {
        return chatMsg.getMsgType() == 2012 || chatMsg.getMsgType() == 2014 || chatMsg.getMsgType() == 2001;
    }

    private int setAllMsgRead(ChatObject chatObject, long j) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        String str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?)";
        if (j > 0) {
            str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?) AND msgid<=" + j;
        }
        String addPaidCondition = addPaidCondition(str, "paid", chatObject.getPaid());
        String[] strArr = {String.valueOf(0), String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getContacter())};
        synchronized (DBBase.mSyncLock) {
            update = update("message", addPaidCondition, strArr, contentValues);
        }
        return update;
    }

    private int setMsgReadByContacterIds(SQLiteDatabase sQLiteDatabase, List<Long> list, long j) {
        if (list == null || list.size() <= 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        if (sQLiteDatabase == null) {
            return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(list.get(i));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            String str = "is_read=? AND category = ? AND contacter in (" + sb.toString() + ") ";
            if (j > 0) {
                str = str + " AND msgid<=" + j;
            }
            return sQLiteDatabase.update("message", contentValues, str, new String[]{String.valueOf(0), "0"});
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, "setMsgReadByContacterIds:", e2);
            return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
        }
    }

    private long studioMsgAddHandler(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1L;
        }
        if (chatMsg.getChatType() == 20 || chatMsg.getMsgType() != 80) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.d(TAG, "studioMsgAddHandler getWritableDb fail!");
                    return -1L;
                } else if (existStudioMsg(openDatabase, chatMsg) > 0) {
                    LogUtils.d(TAG, "studioMsgAddHandler isDuplicateMsg = true");
                    return -2L;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
                    contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                    contentValues.put("input_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                    contentValues.put("msg_key", chatMsg.getMsgKey());
                    contentValues.put("content", chatMsg.getMsgContent());
                    contentValues.put("is_read", Boolean.valueOf(chatMsg.isMsgRead()));
                    return openDatabase.insert(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, null, contentValues);
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "studioMsgAddHandler :", e2);
                return -1L;
            }
        }
        return -1L;
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
        synchronized (DBBase.mSyncLock) {
            update = update("message", "_id = ?", new String[]{String.valueOf(chatMsg.getRowId())}, contentValues);
            if (update >= 0) {
                updateChatSession(chatMsg);
            }
        }
        return update;
    }

    public ArrayList<ChatMsg> addCastReliableMsgs(@NonNull List<TextMsg> list, List<Long> list2) {
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        synchronized (DBBase.mSyncLock) {
            for (TextMsg textMsg : list) {
                if (addReliableMsg(textMsg) > 0) {
                    arrayList.add(textMsg);
                    list2.add(Long.valueOf(textMsg.getMsgId()));
                }
            }
        }
        return arrayList;
    }

    public long addMsg(ChatMsg chatMsg, boolean z) {
        long addMsg;
        synchronized (DBBase.mSyncLock) {
            if (1 == chatMsg.getCategory()) {
                addMsg = GroupMessageDAOImpl.addSingleChatMsg(this.mContext, chatMsg);
            } else {
                addMsg = addMsg(chatMsg);
            }
            if (addMsg < 0) {
                return addMsg;
            }
            chatMsg.setRowId(addMsg);
            if (z) {
                updateChatSession(chatMsg);
                return addMsg;
            }
            return addMsg;
        }
    }

    public ArrayList<ChatMsg> addMsgs(Context context, ArrayList<ChatMsg> arrayList, boolean z, long j) {
        ArrayList<ChatMsg> arrayList2;
        ArrayList<ChatMsg> arrayList3 = arrayList;
        if (arrayList3 != null) {
            synchronized (DBBase.mSyncLock) {
                AccountManagerImpl.getInstance(this.mContext).getUid();
                arrayList2 = new ArrayList<>();
                ArrayList<ChatMsg> arrayList4 = new ArrayList<>();
                ArrayList<ChatMsg> arrayList5 = new ArrayList<>();
                ArrayList<ChatMsg> arrayList6 = new ArrayList<>();
                HashMap<ChatObject, Integer> hashMap = new HashMap<>();
                int i = 0;
                while (i < arrayList.size()) {
                    ChatMsg chatMsg = arrayList3.get(i);
                    chatMsg.setTriggerReasonn(j);
                    try {
                        JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                        jSONObject.put(Constants.EXTRA_TRIGGER_REASON, j);
                        chatMsg.setMsgContent(jSONObject.toString());
                    } catch (Exception e2) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                        e2.printStackTrace();
                    }
                    if (!isNeedInsertToDB(chatMsg)) {
                        arrayList2.add(chatMsg);
                    } else if (chatMsg.getChatType() == 24 && chatMsg.getMsgType() == 20) {
                        LogUtils.d(TAG, "msg will handle by dupMsgAddHandler");
                        if (dupMsgAddHandler(chatMsg) > 0) {
                            if (RetrieveUtil.isRetrievePaUid(context, chatMsg.getFromUser())) {
                                arrayList6.add(chatMsg);
                            } else {
                                arrayList4.add(chatMsg);
                            }
                        }
                    } else if (chatMsg.getChatType() == 20 && chatMsg.getMsgType() == 80) {
                        LogUtils.d(TAG, "msg will handle by stduioMsgAddHandler");
                        if (studioMsgAddHandler(chatMsg) > 0) {
                            arrayList5.add(chatMsg);
                        }
                    } else {
                        String str = TAG;
                        LogUtils.d(str, "will add msg to db, msg = " + chatMsg.toString());
                        long addMsg = addMsg(chatMsg);
                        String str2 = TAG;
                        LogUtils.e(str2, "addMsg result : " + addMsg);
                        if (-1 != addMsg && -2 != addMsg) {
                            chatMsg.setRowId(addMsg);
                            long contacter = getContacter(chatMsg);
                            if (contacter != -1) {
                                ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), contacter, chatMsg.getPaid(), -1);
                                ChatSession chatSession = getChatSession(chatObject);
                                String str3 = TAG;
                                LogUtils.e(str3, " addMsgs session : " + chatSession);
                                if (chatSession != null) {
                                    chatMsg.setChatType(chatSession.getChatType());
                                    arrayList2.add(chatMsg);
                                }
                                if (hashMap.containsKey(chatObject)) {
                                    if (z && !chatMsg.isMsgRead() && chatMsg.getMsgType() != 101) {
                                        hashMap.put(chatObject, Integer.valueOf(hashMap.get(chatObject).intValue() + 1));
                                    }
                                } else if (z && !chatMsg.isMsgRead() && chatMsg.getMsgType() != 101) {
                                    hashMap.put(chatObject, 1);
                                } else {
                                    hashMap.put(chatObject, 0);
                                    i++;
                                    arrayList3 = arrayList;
                                }
                            }
                        }
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                recordLastMsg(hashMap);
                if (!arrayList4.isEmpty()) {
                    ChatMsgManagerImpl.getInstance(this.mContext).deliverFetchedConfigMessage(arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    String str4 = TAG;
                    LogUtils.d(str4, "retrieve-->delverFetchedRetrieveMessage retrieveMsgs:" + arrayList6.toString());
                    ChatMsgManagerImpl.getInstance(this.mContext).delverFetchedRetrieveMessage(arrayList6);
                }
                if (!arrayList5.isEmpty()) {
                    String str5 = TAG;
                    LogUtils.d(str5, "deliverStudioUsePaMessage studioMsgs ：" + arrayList5.size());
                    ChatMsgManagerImpl.getInstance(this.mContext).deliverStudioUsePaMessage(arrayList5);
                }
            }
            return arrayList2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0133 A[Catch: all -> 0x01d5, TryCatch #0 {, blocks: (B:9:0x001c, B:10:0x0026, B:12:0x0044, B:15:0x004c, B:19:0x0084, B:20:0x008d, B:22:0x008f, B:24:0x0095, B:25:0x009c, B:27:0x009e, B:29:0x00aa, B:31:0x00b0, B:34:0x00ba, B:36:0x00c2, B:38:0x00d0, B:40:0x00d8, B:47:0x0124, B:49:0x012d, B:51:0x0133, B:53:0x0146, B:55:0x014b, B:56:0x014f, B:58:0x0159, B:59:0x015d, B:61:0x01c5, B:62:0x01c9, B:63:0x01d3, B:52:0x0142, B:41:0x00e2, B:43:0x0112, B:45:0x0118, B:16:0x005f, B:17:0x0072), top: B:68:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0142 A[Catch: all -> 0x01d5, TryCatch #0 {, blocks: (B:9:0x001c, B:10:0x0026, B:12:0x0044, B:15:0x004c, B:19:0x0084, B:20:0x008d, B:22:0x008f, B:24:0x0095, B:25:0x009c, B:27:0x009e, B:29:0x00aa, B:31:0x00b0, B:34:0x00ba, B:36:0x00c2, B:38:0x00d0, B:40:0x00d8, B:47:0x0124, B:49:0x012d, B:51:0x0133, B:53:0x0146, B:55:0x014b, B:56:0x014f, B:58:0x0159, B:59:0x015d, B:61:0x01c5, B:62:0x01c9, B:63:0x01d3, B:52:0x0142, B:41:0x00e2, B:43:0x0112, B:45:0x0118, B:16:0x005f, B:17:0x0072), top: B:68:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014b A[Catch: all -> 0x01d5, TryCatch #0 {, blocks: (B:9:0x001c, B:10:0x0026, B:12:0x0044, B:15:0x004c, B:19:0x0084, B:20:0x008d, B:22:0x008f, B:24:0x0095, B:25:0x009c, B:27:0x009e, B:29:0x00aa, B:31:0x00b0, B:34:0x00ba, B:36:0x00c2, B:38:0x00d0, B:40:0x00d8, B:47:0x0124, B:49:0x012d, B:51:0x0133, B:53:0x0146, B:55:0x014b, B:56:0x014f, B:58:0x0159, B:59:0x015d, B:61:0x01c5, B:62:0x01c9, B:63:0x01d3, B:52:0x0142, B:41:0x00e2, B:43:0x0112, B:45:0x0118, B:16:0x005f, B:17:0x0072), top: B:68:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0159 A[Catch: all -> 0x01d5, TryCatch #0 {, blocks: (B:9:0x001c, B:10:0x0026, B:12:0x0044, B:15:0x004c, B:19:0x0084, B:20:0x008d, B:22:0x008f, B:24:0x0095, B:25:0x009c, B:27:0x009e, B:29:0x00aa, B:31:0x00b0, B:34:0x00ba, B:36:0x00c2, B:38:0x00d0, B:40:0x00d8, B:47:0x0124, B:49:0x012d, B:51:0x0133, B:53:0x0146, B:55:0x014b, B:56:0x014f, B:58:0x0159, B:59:0x015d, B:61:0x01c5, B:62:0x01c9, B:63:0x01d3, B:52:0x0142, B:41:0x00e2, B:43:0x0112, B:45:0x0118, B:16:0x005f, B:17:0x0072), top: B:68:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c5 A[Catch: all -> 0x01d5, TryCatch #0 {, blocks: (B:9:0x001c, B:10:0x0026, B:12:0x0044, B:15:0x004c, B:19:0x0084, B:20:0x008d, B:22:0x008f, B:24:0x0095, B:25:0x009c, B:27:0x009e, B:29:0x00aa, B:31:0x00b0, B:34:0x00ba, B:36:0x00c2, B:38:0x00d0, B:40:0x00d8, B:47:0x0124, B:49:0x012d, B:51:0x0133, B:53:0x0146, B:55:0x014b, B:56:0x014f, B:58:0x0159, B:59:0x015d, B:61:0x01c5, B:62:0x01c9, B:63:0x01d3, B:52:0x0142, B:41:0x00e2, B:43:0x0112, B:45:0x0118, B:16:0x005f, B:17:0x0072), top: B:68:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7) {
        ChatMsg chatMsg;
        ChatMsg chatMsg2;
        int i6;
        int unReadMsgCount;
        ChatMsg chatMsg3;
        String str8;
        ArrayList<ChatMsg> fetchMsg;
        if (getChatSession(chatObject) != null) {
            return 0L;
        }
        int category = chatObject.getCategory();
        long contacter = chatObject.getContacter();
        synchronized (DBBase.mSyncLock) {
            if (category == 0 && i == 0) {
                contacter = IMUserManager.getInstance(this.mContext).getBuidByUK(contacter);
            }
            ChatSession chatSession = new ChatSession(category, chatObject.getContacter(), contacter, str);
            ChatMsg draftMsg = getDraftMsg(chatObject.getCategory(), chatObject.getContacter());
            if (draftMsg == null) {
                if (1 != chatObject.getCategory()) {
                    fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
                } else if (i == 4) {
                    fetchMsg = GroupMessageDAOImpl.fetchLastChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                } else {
                    fetchMsg = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                }
                if (fetchMsg == null) {
                    LogUtils.e(TAG, "updateChatRecordName fetchmsg error! ");
                    return -1L;
                } else if (fetchMsg.size() == 0) {
                    LogUtils.e(TAG, "updateChatRecordName  msgs.size() = 0! ");
                    return 0L;
                } else {
                    ChatMsg chatMsg4 = fetchMsg.get(0);
                    if (notSendButShowTipMsg(chatMsg4) && fetchMsg.size() > 1) {
                        draftMsg = fetchMsg.get(1);
                    } else {
                        chatMsg = chatMsg4;
                        String str9 = "";
                        if (chatObject.getCategory() == 0 || (chatObject.getContacter() & Constants.PAFLAG) == 0) {
                            chatMsg2 = chatMsg;
                            i6 = 1;
                        } else {
                            if (!chatMsg.isSelf(this.mContext)) {
                                chatMsg2 = chatMsg;
                                str8 = chatMsg.getExtLog();
                                i6 = 1;
                            } else {
                                chatMsg2 = chatMsg;
                                i6 = 1;
                                ArrayList<ChatMsg> fetchMsg2 = fetchMsg(chatObject, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                                if (fetchMsg2 != null && fetchMsg2.size() > 0) {
                                    str9 = fetchMsg2.get(0).getExtLog();
                                }
                                str8 = str9;
                            }
                            chatSession.addExt("ext_log", str8);
                        }
                        if (i6 != chatObject.getCategory()) {
                            unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                        } else {
                            unReadMsgCount = getUnReadMsgCount(chatObject);
                        }
                        chatSession.setChatType(i);
                        if (unReadMsgCount >= 0) {
                            chatSession.setNewMsgSum(unReadMsgCount);
                        }
                        String recommendDescription = chatMsg2.getRecommendDescription();
                        chatMsg3 = chatMsg2;
                        if (chatMsg3 instanceof HtmlMsg) {
                            recommendDescription = chatMsg3.getLocalUrl();
                        }
                        chatSession.setLastOpenTime(chatMsg3.getMsgTime());
                        chatSession.setLastMsgTime(chatMsg3.getMsgTime());
                        chatSession.setLastMsg(recommendDescription);
                        chatSession.setState(chatMsg3.getStatus());
                        chatSession.setIconUrl(str2);
                        chatSession.setIsClicked(Utility.getClickState(chatMsg3));
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
                        if (chatMsg3.isStarMessage()) {
                            chatSession.setChatType(4);
                        }
                        return getInstance(this.mContext).updateChatSession(i6, chatSession);
                    }
                }
            }
            chatMsg = draftMsg;
            String str92 = "";
            if (chatObject.getCategory() == 0) {
            }
            chatMsg2 = chatMsg;
            i6 = 1;
            if (i6 != chatObject.getCategory()) {
            }
            chatSession.setChatType(i);
            if (unReadMsgCount >= 0) {
            }
            String recommendDescription2 = chatMsg2.getRecommendDescription();
            chatMsg3 = chatMsg2;
            if (chatMsg3 instanceof HtmlMsg) {
            }
            chatSession.setLastOpenTime(chatMsg3.getMsgTime());
            chatSession.setLastMsgTime(chatMsg3.getMsgTime());
            chatSession.setLastMsg(recommendDescription2);
            chatSession.setState(chatMsg3.getStatus());
            chatSession.setIconUrl(str2);
            chatSession.setIsClicked(Utility.getClickState(chatMsg3));
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
            if (chatMsg3.isStarMessage()) {
            }
            return getInstance(this.mContext).updateChatSession(i6, chatSession);
        }
    }

    public long delChatRecord(ChatObject chatObject) {
        synchronized (DBBase.mSyncLock) {
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
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "delChatRecord:", e2);
                return -1L;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9 A[Catch: all -> 0x00dd, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0023, B:7:0x002a, B:9:0x002c, B:42:0x00d9, B:43:0x00dc, B:37:0x00d1, B:38:0x00d4, B:28:0x00be, B:29:0x00c1), top: B:49:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long delChatRecordForChatType(int i) {
        Cursor cursor;
        long j;
        synchronized (DBBase.mSyncLock) {
            LogUtils.d(TAG, "delChatRecordForChatType chatType = " + i);
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            ArrayList arrayList = new ArrayList();
            try {
                String[] strArr = {String.valueOf(i)};
                Cursor query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "chat_type = ?", strArr, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            arrayList.add(Long.valueOf(query.getLong(query.getColumnIndex("contacter"))));
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                            try {
                                LogUtils.e(TAG, "delChatRecordForChatType:", e);
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
                if (query != null) {
                    query.close();
                }
                return j;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e5 A[Catch: all -> 0x00ee, TryCatch #6 {all -> 0x00ee, blocks: (B:48:0x00e5, B:49:0x00e8, B:40:0x00da, B:41:0x00dd, B:52:0x00ec), top: B:59:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long delChatRecordForClassTypeOne() {
        Cursor cursor;
        long j;
        synchronized (DBBase.mSyncLock) {
            try {
                try {
                    LogUtils.d(TAG, "HBBH im in delChatRecordForClassTypeOne!!!");
                    SQLiteDatabase openDatabase = openDatabase();
                    if (openDatabase == null) {
                        LogUtils.d(TAG, "getWritableDb fail!");
                        return -1L;
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        String[] strArr = {String.valueOf(1), String.valueOf(5)};
                        Cursor query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "classtype = ? AND chat_type = ?", strArr, null, null, null);
                        if (query != null) {
                            while (query.moveToNext()) {
                                try {
                                    arrayList.add(Long.valueOf(query.getLong(query.getColumnIndex("contacter"))));
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor = query;
                                    try {
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                    try {
                                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                        LogUtils.e(TAG, "HBBH delChatRecordForClassTypeOne:", e);
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return -1L;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor = query;
                                    if (cursor != null) {
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
                        if (query != null) {
                            query.close();
                        }
                        return j;
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = null;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public int delMsgsOfCertainContacter(ChatObject chatObject, long j) {
        int i = 1;
        if (1 == chatObject.getCategory()) {
            int delMsgsOfCertainContacter = GroupMessageDAOImpl.delMsgsOfCertainContacter(this.mContext, String.valueOf(chatObject.getContacter()), j);
            synchronized (DBBase.mSyncLock) {
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
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, "delMsg:", e2);
                    return -1;
                }
            }
        }
        return delMsgsOfCertainContacterForSingle(chatObject, j);
    }

    public void delPaLocalInfosByPaType(int i) {
        ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(this.mContext).queryPaIdByPaType(i);
        if (queryPaIdByPaType != null && !queryPaIdByPaType.isEmpty()) {
            String str = TAG;
            LogUtils.d(str, "---delPaLocalInfosByPaType---paids.size = " + queryPaIdByPaType.size());
            Iterator<Long> it = queryPaIdByPaType.iterator();
            while (it.hasNext()) {
                delMsgsOfPaByPaId(it.next().longValue());
            }
            return;
        }
        LogUtils.d(TAG, "---delPaLocalInfosByPaType---paids is null ---- ");
    }

    public long delSysMsg(int i, long j, int i2) {
        long delete;
        synchronized (DBBase.mSyncLock) {
            delete = delete("message", "category = ?  AND (contacter = ? OR from_user = ? ) AND cmd = ? ", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(j), String.valueOf(i2)});
        }
        return delete;
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
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
            }
            ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, Long.MAX_VALUE, 2L, -1L);
            if (fetchMsg == null || fetchMsg.size() <= 0) {
                return delMsgsOfCertainContacter;
            }
            return 0;
        }
    }

    public int deleteChatMsg(ChatMsg chatMsg) {
        int deleteChatMsg;
        synchronized (DBBase.mSyncLock) {
            if (1 == chatMsg.getCategory()) {
                deleteChatMsg = GroupMessageDAOImpl.deleteChatMsg(this.mContext, chatMsg);
            } else {
                deleteChatMsg = deleteChatMsg(chatMsg.getRowId());
            }
            if (deleteChatMsg < 0) {
                return deleteChatMsg;
            }
            updateChatSession(chatMsg);
            return deleteChatMsg;
        }
    }

    public int deleteChatSession(long j) {
        String[] strArr;
        int delete;
        synchronized (DBBase.mSyncLock) {
            String str = null;
            if (j != -1) {
                str = "paid = ?";
                strArr = new String[]{String.valueOf(j)};
            } else {
                strArr = null;
            }
            delete = delete(TableDefine.DB_TABLE_CHAT_SESSION, str, strArr);
        }
        return delete;
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

    public long deleteExpiredDupMsgs() {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "deleteExpiredDupMsgs db is null!");
                return -1L;
            }
            try {
                return openDatabase.delete(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, "input_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 259200)});
            } catch (Exception e2) {
                LogUtils.e(TAG, "deleteExpiredDupMsgs :", e2);
                return -1L;
            }
        }
    }

    public long deleteExpiredReliableMsgs() {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "deleteExpiredReliableMsgs db is null!");
                return -1L;
            }
            try {
                return openDatabase.delete(TableDefine.DB_TABLE_RELIABLE_MESSAGE, "create_time < ?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - CAST_RELIABLE_MSG_EXPIRED_TIME)});
            } catch (Exception e2) {
                LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e2);
                return -1L;
            }
        }
    }

    public int deleteMsgBatch(ChatObject chatObject, long[] jArr) {
        int delMsgs;
        synchronized (DBBase.mSyncLock) {
            if (1 == chatObject.getCategory()) {
                delMsgs = GroupMessageDAOImpl.deleteMsgs(this.mContext, String.valueOf(chatObject.getContacter()), jArr);
            } else {
                delMsgs = getInstance(this.mContext).delMsgs(jArr);
            }
            if (delMsgs < 0) {
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
            }
            return updateSession(delMsgs, chatObject);
        }
    }

    public long deleteStudioUsePaMsgs() {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "deleteStudioUsePaMsgs db is null!");
                return -1L;
            }
            try {
                return openDatabase.delete(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, "input_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000)});
            } catch (Exception e2) {
                LogUtils.e(TAG, "deleteStudioUsePaMsgs :", e2);
                return -1L;
            }
        }
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2) {
        ArrayList<ChatMsg> fetchMsg;
        synchronized (DBBase.mSyncLock) {
            fetchMsg = fetchMsg(chatObject, j, j2, j == 0 ? -1L : Long.MAX_VALUE, false);
        }
        return fetchMsg;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        if (r8 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b8, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
        if (r8 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgByContacterIdOrderByMsgid(List<Long> list, long j, int i) {
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(list.get(i2));
        }
        String str = "contacter in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
        if (j > 0) {
            str = str + " AND msgid < " + j;
        }
        String str2 = "select * from message where " + str + " ORDER BY msgid desc limit " + Math.abs(i);
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
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
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgsByMsgTypes(ChatObject chatObject, long j, long j2, List<Integer> list) {
        String str;
        ArrayList<ChatMsg> fetchMsg;
        synchronized (DBBase.mSyncLock) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (Integer num : list) {
                            sb.append(num.intValue());
                            sb.append(",");
                        }
                        str = "type IN (" + sb.substring(0, sb.length() - 1) + ") ";
                        fetchMsg = fetchMsg(chatObject, j, j2, j != 0 ? -1L : Long.MAX_VALUE, false, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            str = null;
            fetchMsg = fetchMsg(chatObject, j, j2, j != 0 ? -1L : Long.MAX_VALUE, false, str);
        }
        return fetchMsg;
    }

    public ArrayList<ChatMsg> fetchMsgsExceptGroupSystemMsgSync(ChatObject chatObject, long j, long j2, long j3, boolean z) {
        return fetchMsg(chatObject, j, j2, j3, z, "type != 101");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c3, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c5, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
        if (r1 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e9, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatMsg> fetchPaMsgByChatType(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        List<PaInfo> queryPaInfoByChatType = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByChatType(i);
        Cursor cursor = null;
        if (queryPaInfoByChatType == null || queryPaInfoByChatType.size() <= 0) {
            return null;
        }
        String str = "" + queryPaInfoByChatType.get(0).getPaId();
        for (int i3 = 1; i3 < queryPaInfoByChatType.size(); i3++) {
            str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + queryPaInfoByChatType.get(i3).getPaId();
        }
        String str2 = "select * from message where " + ("paid in (" + str + ") ") + " ORDER BY time desc limit " + Math.abs(i2);
        synchronized (DBBase.mSyncLock) {
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
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        if (r8 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b8, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
        if (r8 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchPaMsgByPaids(List<Long> list, long j, int i) {
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(list.get(i2));
        }
        String str = "contacter in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
        if (j > 0) {
            str = str + " AND msgid < " + j;
        }
        String str2 = "select * from message where " + str + " ORDER BY msgid desc limit " + Math.abs(i);
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
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
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "fetchPaMsgByChatType:", e2);
            }
        }
    }

    public ArrayList<ChatMsg> fetchSpecifyMsgsSync(ChatObject chatObject, int i, long j, long j2, long j3, boolean z) {
        return fetchMsg(chatObject, j, j2, j3, z, "type = " + i);
    }

    public ArrayList<SessionClass> getAllClassType() {
        Cursor query;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<SessionClass> arrayList = new ArrayList<>();
            Cursor cursor = null;
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"classtype", "classtitle", "classshow", "classavatar"}, "classtype > 1 ", null, "classtype", null, null, null);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String str = TAG;
                    LogUtils.e(str, "cursor " + query);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    String str2 = TAG;
                    LogUtils.e(str2, "cursor count " + query.getCount());
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("classtype"));
                        int i2 = query.getInt(query.getColumnIndex("classshow"));
                        String string = query.getString(query.getColumnIndex("classtitle"));
                        String string2 = query.getString(query.getColumnIndex("classavatar"));
                        SessionClass sessionClass = new SessionClass();
                        sessionClass.setType(i);
                        sessionClass.setTitle(string);
                        sessionClass.setAvatarurl(string2);
                        sessionClass.setShow(i2);
                        arrayList.add(sessionClass);
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Exception e3) {
                    e = e3;
                    cursor = query;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getChatRecords:", e);
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
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r12 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        if (r12 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x0011, B:18:0x0042, B:27:0x0066, B:32:0x006c, B:33:0x006f), top: B:37:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getChatMsgByMsgId(long j) {
        Cursor cursor;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            r10 = null;
            r10 = null;
            r10 = null;
            ChatMsg chatMsg = null;
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
                                chatMsg = construChatMsg(cursor);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "fetchMsg:", e);
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
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006f A[Catch: all -> 0x0073, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000a, B:14:0x004b, B:15:0x004e, B:20:0x0054, B:21:0x0057, B:29:0x0066, B:30:0x0069, B:35:0x006f, B:36:0x0072), top: B:42:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSession getChatRecord(ChatObject chatObject) {
        Cursor cursor;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
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
                        } catch (Exception e2) {
                            e = e2;
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
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x004f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.database.Cursor] */
    public ChatSession getChatRecordByContacter(ChatObject chatObject) {
        Cursor cursor;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ?? r11 = 0;
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, "category = ? AND contacter=?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return constructChatRecord;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            LogUtils.e(TAG, "getChatRecord:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (r11 != 0) {
                        r11.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r11 = chatObject;
            }
        }
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2, long j3) {
        LogUtils.enter();
        return getChatRecords(j, j2, j3, null);
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long j, long j2, long j3, List<Integer> list) {
        String str;
        Cursor query;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            Cursor cursor = null;
            if (openDatabase == null) {
                return null;
            }
            long j4 = j + j2;
            try {
                try {
                    String addPaidCondition = addPaidCondition("show= ?", "paid", j3);
                    LogUtils.e(TAG, addPaidCondition);
                    if (list == null || list.size() <= 0) {
                        str = addPaidCondition;
                    } else {
                        String str2 = "" + list.get(0);
                        for (int i = 1; i < list.size(); i++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i);
                        }
                        str = addPaidCondition + " AND classtype in (" + str2 + ") ";
                    }
                    query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", j4 > 0 ? String.valueOf(j4) : null);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                LogUtils.e(TAG, Constants.EXTRA_CONFIG_CURSOR + query);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                LogUtils.e(TAG, "cursor count" + query.getCount());
                query.moveToPosition(((int) j) - 1);
                while (query.moveToNext()) {
                    ChatSession constructChatRecord = constructChatRecord(openDatabase, query);
                    LogUtils.e(TAG, "record : " + constructChatRecord);
                    if (constructChatRecord != null) {
                        arrayList.add(constructChatRecord);
                    }
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                cursor = query;
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "getChatRecords:", e);
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public ChatMsg getDraftMsg(int i, long j) {
        if (1 == i) {
            return GroupMessageDAOImpl.getDraftMsg(this.mContext, String.valueOf(j));
        }
        return getDraftMsgForSingle(i, j);
    }

    public List<ChatSession> getGroupSession() {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
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
                        } catch (Exception e2) {
                            e = e2;
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
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: int */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r12 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r12 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
        return r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getLatestMsg(int i, long j) {
        Cursor cursor;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            r10 = null;
            r10 = null;
            r10 = null;
            ChatMsg chatMsg = null;
            try {
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getReadableDb fail!");
                    return null;
                }
                try {
                    cursor = openDatabase.query("message", null, "category=? AND contacter=? ", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, "msgid desc ", String.valueOf(1));
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                chatMsg = construChatMsg(cursor);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getLatestMsg:", e);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = i;
            }
        }
    }

    public long getMaxMsgid() {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1L;
            }
            Cursor cursor = null;
            try {
                cursor = openDatabase.query("message", new String[]{"msgid"}, null, null, null, null, "msgid desc ", String.valueOf(1));
                if (cursor == null || !cursor.moveToNext()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0L;
                }
                long j = cursor.getLong(cursor.getColumnIndex("msgid"));
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getMaxMsgid:", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        }
    }

    public ArrayList<ChatMsg> getMaxMsgidByChatTypes(List<Integer> list, long j, int i) {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            return fetchMsgByContacterIdOrderByMsgid(getContacterByChatTypes(openDatabase, list), j, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        if (r2 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxReliableMsgId(long j) {
        String str = "select max(msgid) as max_msg_id from " + TableDefine.DB_TABLE_RELIABLE_MESSAGE + " where mcast_id = " + j;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "getMaxReliableMsgId db is null!");
                return -1L;
            }
            Cursor cursor = null;
            try {
                cursor = openDatabase.rawQuery(str, null);
                if (cursor != null && cursor.moveToNext()) {
                    long j2 = cursor.getLong(cursor.getColumnIndex("max_msg_id"));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return j2;
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "getMaxReliableMsgId:", e2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x004d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0059 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: android.database.Cursor */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r7 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        if (r7 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getMsgByMsgId(long j) {
        Cursor cursor;
        SQLiteDatabase openDatabase = openDatabase();
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        ChatMsg chatMsg = null;
        try {
            if (openDatabase == null) {
                LogUtils.e(TAG, "getMsgByMsgId db is null!");
                return null;
            }
            try {
                String[] strArr = {String.valueOf(j)};
                cursor = "select * from message where msgid = ? limit " + Math.abs(1);
                try {
                    try {
                        synchronized (DBBase.mSyncLock) {
                            try {
                                cursor = openDatabase.rawQuery(cursor, strArr);
                                if (cursor != null && cursor.moveToNext()) {
                                    chatMsg = construChatMsg(cursor);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getMsgByMsgId:", e);
                }
            } catch (Exception e3) {
                e = e3;
                cursor = 0;
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor2 = j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
        if (r4 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c9, code lost:
        if (r4 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCount(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        synchronized (DBBase.mSyncLock) {
            int i = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            Cursor cursor = null;
            String str = "";
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        String str2 = " ( " + list.get(0);
                        for (int i2 = 1; i2 < list.size(); i2++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2);
                        }
                        str = "chat_type in " + (str2 + " ) ");
                    }
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, " getNewMsgCount:", e2);
                }
            }
            cursor = openDatabase.rawQuery(TextUtils.isEmpty(str) ? "select sum(new_msg_sum) from chatrecord" : "select sum(new_msg_sum) from chatrecord where " + str, null);
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r3 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        if (r3 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCountOfClass(int i) {
        synchronized (DBBase.mSyncLock) {
            int i2 = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            Cursor cursor = null;
            try {
                String str = "classtype = " + i;
                String str2 = "select sum(new_msg_sum) from chatrecord";
                if (!TextUtils.isEmpty(str)) {
                    str2 = "select sum(new_msg_sum) from chatrecord where " + str;
                }
                cursor = openDatabase.rawQuery(str2, null);
                if (cursor != null && cursor.moveToNext()) {
                    i2 = cursor.getInt(0);
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, " getNewMsgCount:", e2);
            }
        }
    }

    public int getNewMsgNum(ChatObject chatObject) {
        if (1 == chatObject.getCategory()) {
            return GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            try {
                int newMsgNum = getNewMsgNum(openDatabase, chatObject);
                String str = TAG;
                LogUtils.d(str, "getNewMsgNum: " + newMsgNum);
                return newMsgNum;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getNewMsgNum:", e2);
                return 0;
            }
        }
    }

    public ArrayList<ChatMsg> getNotificationMsgDataList(SparseArray<List<Integer>> sparseArray, long j, int i) {
        return fetchPaMsgByPaids(new ArrayList(PaInfoDBManager.getInstance(this.mContext).getPaidListByPainfos(sparseArray)), j, i);
    }

    public ArrayList<ChatMsg> getPaMsgByChatTypeAndPaidList(List<Integer> list, List<Long> list2, long j, int i) {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            List<Long> contacterByChatTypes = getContacterByChatTypes(openDatabase, list);
            HashSet hashSet = new HashSet();
            if (list2 != null) {
                hashSet.addAll(list2);
            }
            if (contacterByChatTypes != null) {
                hashSet.addAll(contacterByChatTypes);
            }
            return fetchPaMsgByPaids(new ArrayList(hashSet), j, i);
        }
    }

    public ArrayList<ChatMsg> getStudioUsePaUnReadMsg() {
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            if (openDatabase == null) {
                return null;
            }
            try {
                try {
                    Cursor query = openDatabase.query(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, null, "is_read =?", new String[]{String.valueOf(0)}, null, null, null, null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    while (query.moveToNext()) {
                        try {
                            ChatMsg generateStudioUsePaMsg = generateStudioUsePaMsg(query);
                            if (generateStudioUsePaMsg != null) {
                                arrayList.add(generateStudioUsePaMsg);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                            LogUtils.e(TAG, "getStudioUsePaUnReadMsg :", e);
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
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public int getUnReadMsgCount(ChatObject chatObject) {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            if (openDatabase == null) {
                return -1;
            }
            try {
                String str = "category=? AND contacter=? AND is_read=?";
                String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(0)};
                if (1 == chatObject.getCategory()) {
                    str = "category=? AND contacter=? AND is_read=? AND type != 101";
                }
                cursor = openDatabase.query("message", new String[]{"_id"}, addPaidCondition(str, "paid", chatObject.getPaid()), strArr, null, null, null);
                LogUtils.d(TAG, "getUnReadMsgCount> COLUMN_CATEGORY=" + chatObject.getCategory() + ", COLUMN_CONTACTER=" + chatObject.getContacter() + ", count = " + cursor.getCount());
                int count = cursor.getCount();
                if (cursor != null) {
                    cursor.close();
                }
                return count;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, " getUnReadMsgCount:", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (r1 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
        if (0 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isRecordExist(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        synchronized (DBBase.mSyncLock) {
            Cursor cursor = null;
            if (sQLiteDatabase == null) {
                return false;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"contacter"}, "category = ? AND contacter = ?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null);
                if (cursor != null && cursor.moveToNext()) {
                    String str = TAG;
                    LogUtils.d(str, "chat record exist! " + chatObject.toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return true;
                }
                String str2 = TAG;
                LogUtils.d(str2, "chat record not found! category: " + chatObject.toString());
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "isRecordExist:", e2);
            }
        }
    }

    public int markMsgClicked(ChatMsg chatMsg) {
        if (1 == chatMsg.getCategory()) {
            return GroupMessageDAOImpl.markMsgClicked(this.mContext, chatMsg);
        }
        return markChatMsgClicked(chatMsg);
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

    public void recordLastMsg(HashMap<ChatObject, Integer> hashMap) {
        String str;
        LogUtils.d(TAG, "recordReceiveLastMsg");
        for (Map.Entry<ChatObject, Integer> entry : hashMap.entrySet()) {
            ChatObject key = entry.getKey();
            int intValue = entry.getValue().intValue();
            ArrayList<ChatMsg> fetchMsg = fetchMsg(entry.getKey(), 0L, 2L);
            if (fetchMsg.size() > 0) {
                ChatMsg chatMsg = fetchMsg.get(0);
                if (notSendButShowTipMsg(chatMsg) && fetchMsg.size() > 1) {
                    chatMsg = fetchMsg.get(1);
                }
                ChatMsg chatMsg2 = chatMsg;
                String recommendDescription = chatMsg2.getRecommendDescription();
                if (chatMsg2 instanceof HtmlMsg) {
                    recommendDescription = chatMsg2.getLocalUrl();
                }
                String str2 = recommendDescription;
                long newMsgNum = getNewMsgNum(key);
                int i = newMsgNum >= 0 ? (int) (intValue + newMsgNum) : intValue;
                int clickState = Utility.getClickState(chatMsg2);
                if (key.getCategory() == 0 && (key.getContacter() & Constants.PAFLAG) != 0) {
                    if (!chatMsg2.isSelf(this.mContext)) {
                        str = chatMsg2.getExtLog();
                    } else {
                        ArrayList<ChatMsg> fetchMsg2 = fetchMsg(key, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                        if (fetchMsg2 != null && fetchMsg2.size() > 0) {
                            str = fetchMsg2.get(0).getExtLog();
                        }
                    }
                    recordLastMsg(key, str2, chatMsg2.getMsgTime(), i, 0, clickState, chatMsg2.isStarMessage(), str);
                }
                str = "";
                recordLastMsg(key, str2, chatMsg2.getMsgTime(), i, 0, clickState, chatMsg2.isStarMessage(), str);
            }
        }
    }

    public synchronized void registerObserver(ChatMessageDbOberser chatMessageDbOberser) {
        if (chatMessageDbOberser == null) {
            return;
        }
        if (this.mObservers == null) {
            this.mObservers = new LinkedList();
        }
        this.mObservers.add(chatMessageDbOberser);
    }

    public boolean setAllMsgReadWithMsgid(ChatObject chatObject, long j) {
        int allMsgRead;
        int unReadMsgCount;
        if (j == -1) {
            j = getInstance(this.mContext).getMaxMsgid(chatObject);
        }
        synchronized (DBBase.mSyncLock) {
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
            String str = TAG;
            LogUtils.d(str, "delta:" + allMsgRead);
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

    public int setMsgRead(ChatObject chatObject, long j) {
        int msgRead;
        ChatSession chatSession;
        int unReadMsgCount;
        if (chatObject == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        synchronized (DBBase.mSyncLock) {
            if (1 == chatObject.getCategory()) {
                msgRead = GroupMessageDAOImpl.setMsgReaded(this.mContext, String.valueOf(chatObject.getContacter()), j);
            } else {
                msgRead = getInstance(this.mContext).setMsgRead(j);
            }
            if (msgRead < 0) {
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
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

    public List<Long> setMsgReadByChatTypes(List<Integer> list, long j) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                openDatabase.beginTransaction();
                List<Long> unreadContacterByChatTypes = getUnreadContacterByChatTypes(openDatabase, list);
                if (unreadContacterByChatTypes != null && unreadContacterByChatTypes.size() > 0) {
                    String str = TAG;
                    LogUtils.d(str, "getUnreadContacterByChatTypes contacterIds size  = " + unreadContacterByChatTypes.size());
                    if (setMsgReadByContacterIds(openDatabase, unreadContacterByChatTypes, j) > 0) {
                        for (Long l : unreadContacterByChatTypes) {
                            long longValue = l.longValue();
                            int unReadMsgCount = getUnReadMsgCount(new ChatObject(this.mContext, 0, longValue));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM, Integer.valueOf(unReadMsgCount));
                            getInstance(this.mContext).updateChatSession("category=? AND contacter=?", new String[]{String.valueOf(0), String.valueOf(longValue)}, contentValues);
                        }
                    }
                    openDatabase.setTransactionSuccessful();
                    openDatabase.endTransaction();
                    return unreadContacterByChatTypes;
                }
                openDatabase.endTransaction();
                return unreadContacterByChatTypes;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "setPaMsgReadByChatTypes:", e2);
                openDatabase.endTransaction();
                return null;
            }
        }
    }

    public List<Long> setPaMsgReadByChatTypeAndSubType(SparseArray<List<Integer>> sparseArray, long j) {
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                openDatabase.beginTransaction();
                List<Long> paidListByPainfos = PaInfoDBManager.getInstance(this.mContext).getPaidListByPainfos(sparseArray);
                if (paidListByPainfos != null && paidListByPainfos.size() > 0) {
                    int msgReadByContacterIds = setMsgReadByContacterIds(openDatabase, paidListByPainfos, j);
                    String str = TAG;
                    LogUtils.d(str, "setPaMsgReadByChatTypeAndSubType result = " + msgReadByContacterIds);
                    if (msgReadByContacterIds > 0) {
                        for (Long l : paidListByPainfos) {
                            long longValue = l.longValue();
                            int unReadMsgCount = getUnReadMsgCount(new ChatObject(this.mContext, 0, longValue));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM, Integer.valueOf(unReadMsgCount));
                            getInstance(this.mContext).updateChatSession("category=? AND contacter=?", new String[]{String.valueOf(0), String.valueOf(longValue)}, contentValues);
                        }
                    }
                    openDatabase.setTransactionSuccessful();
                    openDatabase.endTransaction();
                    return paidListByPainfos;
                }
                openDatabase.endTransaction();
                return null;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "setPaMsgReadByChatTypes:", e2);
                openDatabase.endTransaction();
                return null;
            }
        }
    }

    public int setStudioMsgRead(long j) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        synchronized (DBBase.mSyncLock) {
            update = update(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, "msgid = ?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    public synchronized void unRegisterObserver(ChatMessageDbOberser chatMessageDbOberser) {
        if (this.mObservers == null) {
            return;
        }
        this.mObservers.remove(chatMessageDbOberser);
    }

    public int updateChatMsgContent(ChatMsg chatMsg) {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "updateChatMsgContent db is null!");
                return -1;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content", chatMsg.getMsgContent());
                return openDatabase.update("message", contentValues, "msgid = ?", new String[]{String.valueOf(chatMsg.getMsgId())});
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "updateChatMsgContent:", e2);
                return -1;
            }
        }
    }

    public void updateChatSession(String str, String[] strArr, ContentValues contentValues) {
        update(TableDefine.DB_TABLE_CHAT_SESSION, str, strArr, contentValues);
    }

    public int updateChatSessionName(ChatSession chatSession) {
        synchronized (DBBase.mSyncLock) {
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
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "updateChatSessionName:", e2);
                return -1;
            }
        }
    }

    public int updateMsgStatus(ChatMsg chatMsg) {
        if (chatMsg != null) {
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
        return -1;
    }

    public int updateSession(int i, ChatObject chatObject) {
        ArrayList<ChatMsg> fetchMsg;
        synchronized (DBBase.mSyncLock) {
            ChatMsg chatMsg = null;
            ChatSession chatSession = getChatSession(chatObject);
            if (chatSession != null && chatSession.getState() != 3) {
                if (i != 0) {
                    if (1 == chatObject.getCategory()) {
                        fetchMsg = GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    } else {
                        fetchMsg = fetchMsg(chatObject, 0L, 2L);
                    }
                    if (fetchMsg != null && fetchMsg.size() > 0) {
                        chatMsg = fetchMsg.get(0);
                        if (notSendButShowTipMsg(chatMsg) && fetchMsg.size() > 1) {
                            chatMsg = fetchMsg.get(1);
                        }
                    }
                    updateSession(true, chatSession, chatMsg);
                }
                return i;
            }
            return i;
        }
    }

    public void updateSessionClass(PaInfo paInfo) {
        ChatSession chatRecord = getChatRecord(new ChatObject(this.mContext, 0, paInfo.getPaId(), -1L, -1));
        if (chatRecord != null) {
            String str = TAG;
            LogUtils.d(str, "syncpa session " + paInfo.toString());
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

    public long updateChatSession(int i, ChatSession chatSession) {
        long update;
        synchronized (DBBase.mSyncLock) {
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
                    String str = TAG;
                    LogUtils.e(str, "create chatsession! " + chatSession.toString());
                    contentValues.put("category", Integer.valueOf(chatSession.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatSession.getContacter()));
                    contentValues.put("paid", Long.valueOf(chatSession.getPaid()));
                    update = openDatabase.insert(TableDefine.DB_TABLE_CHAT_SESSION, null, contentValues);
                } else {
                    String str2 = TAG;
                    LogUtils.d(str2, "update chatsession! " + chatSession.toString());
                    update = (long) openDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, addPaidCondition("category =? AND contacter = ?", "paid", chatSession.getPaid()), new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())});
                }
                if (update > 0) {
                    notifyDbChange(1, chatSession);
                }
                return update;
            } catch (Exception e2) {
                LogUtils.e(TAG, "updateChatRecord:", e2);
                return -1L;
            }
        }
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2, long j3, List<Integer> list) {
        String str;
        Cursor query;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            Cursor cursor = null;
            if (openDatabase == null) {
                return null;
            }
            long j4 = j + j2;
            try {
                try {
                    String addPaidCondition = addPaidCondition("show= ?", "paid", j3);
                    LogUtils.e(TAG, addPaidCondition);
                    if (list == null || list.size() <= 0) {
                        str = addPaidCondition;
                    } else {
                        String str2 = "" + list.get(0);
                        for (int i = 1; i < list.size(); i++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i);
                        }
                        str = addPaidCondition + " AND chat_type in (" + str2 + ") ";
                    }
                    query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", j4 > 0 ? String.valueOf(j4) : null);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                LogUtils.e(TAG, Constants.EXTRA_CONFIG_CURSOR + query);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                LogUtils.e(TAG, "cursor count" + query.getCount());
                query.moveToPosition(((int) j) - 1);
                while (query.moveToNext()) {
                    ChatSession constructChatRecord = constructChatRecord(openDatabase, query);
                    LogUtils.e(TAG, "record : " + constructChatRecord);
                    if (constructChatRecord != null) {
                        arrayList.add(constructChatRecord);
                    }
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                cursor = query;
                LogUtils.e(TAG, "getChatRecords:", e);
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3) {
        ArrayList<ChatMsg> fetchMsg;
        synchronized (DBBase.mSyncLock) {
            fetchMsg = fetchMsg(chatObject, j, j2, j3, false);
        }
        return fetchMsg;
    }

    public int updateMsgStatus(long j, int i) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        synchronized (DBBase.mSyncLock) {
            update = update("message", "_id = ?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00a8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00aa */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.String] */
    public ArrayList<ChatMsg> fetchMsg(String str, String str2) {
        ?? r8;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        SQLiteDatabase openDatabase = openDatabase();
        ?? r2 = 0;
        try {
            if (openDatabase == null) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            try {
                String[] strArr = {str2, str};
                r8 = "select * from message where " + ("contacter = ? AND _id = ?  AND status = 2");
                try {
                    try {
                        synchronized (DBBase.mSyncLock) {
                            try {
                                Cursor rawQuery = openDatabase.rawQuery(r8, strArr);
                                if (rawQuery != null && rawQuery.getCount() != 0) {
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
                                }
                                LogUtils.d(TAG, "resend fetchmsg cursor is null " + str);
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "fetchMsg:", e);
                    if (r8 != 0) {
                        r8.close();
                    }
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                r8 = 0;
            } catch (Throwable th3) {
                th = th3;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r2 = str2;
        }
    }

    private int deleteChatMsg(long j) {
        int i;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            int i2 = 0;
            try {
                i = openDatabase.delete("message", "_id = ? ", new String[]{String.valueOf(j)});
                try {
                    long j2 = j + 1;
                    openDatabase.execSQL("delete from message where _id=? and type in (?, ?, ?)", new Object[]{Long.valueOf(j2), Integer.valueOf((int) IMConstants.IM_MSG_TYPE_SHIELD_ME), 2001, Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL)});
                    String str = TAG;
                    LogUtils.e(str, "deleteChatMsg notSendButShowTipMsg :delete from message where _id=? and type in (?, ?, ?), rowId :" + j2);
                } catch (Exception e2) {
                    e = e2;
                    i2 = i;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "deleteChatMsg:", e);
                    i = i2;
                    return i;
                }
            } catch (Exception e3) {
                e = e3;
            }
            return i;
        }
    }

    private long addMsg(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1L;
        }
        int i = 1;
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
                    if (!chatMsg.isClicked()) {
                        i = 0;
                    }
                    contentValues.put("isclicked", Integer.valueOf(i));
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
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "addMsg:", e2);
                return -1L;
            }
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
        if (0 == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getNewMsgNum(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        synchronized (DBBase.mSyncLock) {
            Cursor cursor = null;
            if (sQLiteDatabase == null) {
                return -1;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM}, addPaidCondition("category =? AND contacter =?", "paid", chatObject.getPaid()), new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())}, null, null, null);
                if (cursor != null && cursor.moveToNext()) {
                    String str = TAG;
                    LogUtils.d(str, "get new msg num for category : " + chatObject.getCategory() + " contacter:" + chatObject.getContacter());
                    int i = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return i;
                }
                String str2 = TAG;
                LogUtils.d(str2, "getNewMsgNum record not found! " + chatObject.toString());
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getNewMsgNum:", e2);
            }
        }
    }

    private int setMsgRead(long j) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        synchronized (DBBase.mSyncLock) {
            update = update("message", "msgid = ?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0063: MOVE  (r12 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:33:0x0063 */
    public ChatSession getChatRecord(int i, long j, long j2) {
        Cursor cursor;
        Cursor cursor2;
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor3 = null;
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    cursor2 = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", j2), new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null, null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToNext()) {
                                ChatSession constructChatRecord = constructChatRecord(openDatabase, cursor2);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                return constructChatRecord;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            LogUtils.e(TAG, "getChatRecord:", e);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            return null;
                        }
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    cursor2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor;
            }
        }
    }

    public long getMaxMsgid(ChatObject chatObject) {
        if (1 == chatObject.getCategory()) {
            return GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
        }
        synchronized (DBBase.mSyncLock) {
            ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, 0L, 1L);
            if (fetchMsg == null || fetchMsg.size() <= 0) {
                return fetchMsg == null ? -1L : 0L;
            }
            return fetchMsg.get(0).getMsgId();
        }
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

    public void updateSessionClass(ChatUser chatUser) {
        ChatSession chatRecord = getChatRecord(new ChatObject(this.mContext, 0, chatUser.getUk(), -1L, -1));
        if (chatRecord != null) {
            String str = TAG;
            LogUtils.d(str, "sync user session " + chatUser.toString());
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r3 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCount(long j) {
        synchronized (DBBase.mSyncLock) {
            int i = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            Cursor cursor = null;
            String str = "";
            if (j != -1) {
                try {
                    str = "paid=" + j;
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, " getNewMsgCount:", e2);
                }
            }
            String str2 = "select sum(new_msg_sum) from chatrecord";
            if (!TextUtils.isEmpty(str)) {
                str2 = "select sum(new_msg_sum) from chatrecord where " + str;
            }
            cursor = openDatabase.rawQuery(str2, null);
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        }
    }

    public void recordLastMsg(ChatObject chatObject, String str, long j, int i, int i2, int i3, boolean z, String str2) {
        String str3 = TAG;
        LogUtils.d(str3, "recordSendLastMsg " + chatObject.toString());
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
            chatRecord.addExt("ext_log", str2);
        }
        updateChatSession(1, chatRecord);
    }

    public void updateChatSession(ChatMsg chatMsg) {
        ArrayList<ChatMsg> fetchMsg;
        ChatMsg chatMsg2;
        ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), chatMsg.getChatType());
        ChatSession chatSession = getChatSession(chatObject);
        boolean z = false;
        if (!isDraftMsg(chatMsg)) {
            if (chatSession == null || chatSession.getState() != 3) {
                if (1 == chatMsg.getCategory()) {
                    fetchMsg = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatMsg.getContacter()), null, 1L, true);
                } else {
                    fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
                }
                if (fetchMsg != null && fetchMsg.size() > 0) {
                    ChatMsg chatMsg3 = fetchMsg.get(0);
                    chatMsg2 = (!notSendButShowTipMsg(chatMsg3) || fetchMsg.size() <= 1) ? chatMsg3 : fetchMsg.get(1);
                    z = true;
                    updateSession(z, chatSession, chatMsg2);
                }
            } else {
                chatMsg2 = chatMsg;
                updateSession(z, chatSession, chatMsg2);
            }
        }
        chatMsg2 = chatMsg;
        z = true;
        updateSession(z, chatSession, chatMsg2);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c A[Catch: all -> 0x022f, Exception -> 0x0232, TryCatch #6 {Exception -> 0x0232, all -> 0x022f, blocks: (B:40:0x0079, B:42:0x008a, B:45:0x0095, B:48:0x010c, B:50:0x011d, B:51:0x0131, B:53:0x014a, B:55:0x0152, B:64:0x016e, B:65:0x01a7, B:46:0x00d2), top: B:123:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011d A[Catch: all -> 0x022f, Exception -> 0x0232, TryCatch #6 {Exception -> 0x0232, all -> 0x022f, blocks: (B:40:0x0079, B:42:0x008a, B:45:0x0095, B:48:0x010c, B:50:0x011d, B:51:0x0131, B:53:0x014a, B:55:0x0152, B:64:0x016e, B:65:0x01a7, B:46:0x00d2), top: B:123:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014a A[Catch: all -> 0x022f, Exception -> 0x0232, TryCatch #6 {Exception -> 0x0232, all -> 0x022f, blocks: (B:40:0x0079, B:42:0x008a, B:45:0x0095, B:48:0x010c, B:50:0x011d, B:51:0x0131, B:53:0x014a, B:55:0x0152, B:64:0x016e, B:65:0x01a7, B:46:0x00d2), top: B:123:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0167 A[ADDED_TO_REGION] */
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
        long j5 = j2;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        SQLiteDatabase openDatabase = openDatabase();
        Cursor cursor = null;
        if (openDatabase == null) {
            LogUtils.d(TAG, "getReadableDb fail!");
            return null;
        }
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i <= 0 && j5 >= 0) {
            j5 = -j5;
        }
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                if (0 == j && j3 == -1) {
                    str2 = " >= ";
                } else {
                    int i2 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
                    if (i2 == 0) {
                        str2 = " = ";
                        j4 = -2;
                    } else if (i2 > 0) {
                        str2 = " > ";
                        j4 = j3 == Long.MAX_VALUE ? 0L : j3;
                    } else {
                        j4 = j3 != -1 ? j3 : Long.MAX_VALUE;
                        str2 = " < ";
                    }
                    if (j4 != -2) {
                        try {
                            str3 = " AND _id" + str2 + j4;
                            if (chatObject.getContacter() != 17 && chatObject.getContacter() != 26) {
                                str4 = "contacter = ? AND msgid" + str2 + "? AND category = ? ";
                                strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(chatObject.getCategory())};
                                if (str3 != null) {
                                    str4 = str4 + str3;
                                }
                                if (str != null) {
                                    str4 = str4 + " AND " + str;
                                }
                                str5 = str4 + " AND status != 3";
                                if (chatObject.getCategory() != 17 && chatObject.getCategory() != 26) {
                                    str5 = addPaidCondition(str5, "paid", chatObject.getPaid());
                                }
                                if (j5 == 0) {
                                    j5 = 1;
                                }
                                long j6 = j5;
                                String str6 = (j6 > 0 || i <= 0) ? " desc " : " asc ";
                                String str7 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j6);
                                synchronized (DBBase.mSyncLock) {
                                    try {
                                        Cursor rawQuery = openDatabase.rawQuery(str7, strArr);
                                        if (rawQuery == null) {
                                            if (rawQuery != null) {
                                                rawQuery.close();
                                                return null;
                                            }
                                            return null;
                                        }
                                        boolean cursorMoveDirection = getCursorMoveDirection(z, j, j6);
                                        if (!cursorMoveDirection) {
                                            if (!rawQuery.moveToLast()) {
                                                if (rawQuery != null) {
                                                    rawQuery.close();
                                                }
                                                return arrayList;
                                            }
                                        } else if (!rawQuery.moveToFirst()) {
                                            if (rawQuery != null) {
                                                rawQuery.close();
                                            }
                                            return arrayList;
                                        }
                                        while (true) {
                                            ChatMsg construChatMsg = construChatMsg(rawQuery);
                                            if (construChatMsg != null) {
                                                LogUtils.d(TAG, "msgid : " + construChatMsg.getMsgId());
                                                arrayList.add(construChatMsg);
                                            } else {
                                                LogUtils.d(TAG, "construChatMsg msg is null ");
                                            }
                                            if (cursorMoveDirection) {
                                                if (!rawQuery.moveToNext()) {
                                                    LogUtils.d(TAG, "cursor is moveToNext failed!");
                                                    break;
                                                }
                                            } else if (!rawQuery.moveToPrevious()) {
                                                LogUtils.d(TAG, "cursor is moveToPrevious failed!");
                                                break;
                                            }
                                        }
                                        if (rawQuery != null) {
                                            rawQuery.close();
                                        }
                                        return arrayList;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                }
                            }
                            str4 = "type = ? AND msgid" + str2 + "? AND category = ? ";
                            strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(0)};
                            if (str3 != null) {
                            }
                            if (str != null) {
                            }
                            str5 = str4 + " AND status != 3";
                            if (chatObject.getCategory() != 17) {
                                str5 = addPaidCondition(str5, "paid", chatObject.getPaid());
                            }
                            if (j5 == 0) {
                            }
                            long j62 = j5;
                            if (j62 > 0) {
                            }
                            String str72 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j62);
                            synchronized (DBBase.mSyncLock) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "fetchMsg:", e);
                            if (cursor == null) {
                                cursor.close();
                                return null;
                            }
                            return null;
                        }
                    }
                }
                if (chatObject.getContacter() != 17) {
                    str4 = "contacter = ? AND msgid" + str2 + "? AND category = ? ";
                    strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(chatObject.getCategory())};
                    if (str3 != null) {
                    }
                    if (str != null) {
                    }
                    str5 = str4 + " AND status != 3";
                    if (chatObject.getCategory() != 17) {
                    }
                    if (j5 == 0) {
                    }
                    long j622 = j5;
                    if (j622 > 0) {
                    }
                    String str722 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j622);
                    synchronized (DBBase.mSyncLock) {
                    }
                }
                synchronized (DBBase.mSyncLock) {
                }
            } catch (Throwable th3) {
                th = th3;
            }
            str4 = "type = ? AND msgid" + str2 + "? AND category = ? ";
            strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(0)};
            if (str3 != null) {
            }
            if (str != null) {
            }
            str5 = str4 + " AND status != 3";
            if (chatObject.getCategory() != 17) {
            }
            if (j5 == 0) {
            }
            long j6222 = j5;
            if (j6222 > 0) {
            }
            String str7222 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j6222);
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(TAG, "fetchMsg:", e);
            if (cursor == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        str3 = null;
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
}
