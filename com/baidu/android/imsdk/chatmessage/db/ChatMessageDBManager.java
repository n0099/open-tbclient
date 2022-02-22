package com.baidu.android.imsdk.chatmessage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ChatMessageDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CAST_RELIABLE_MSG_EXPIRED_TIME = 172800;
    public static final String TAG = "ChatMessageDBManager";
    public static final List<Integer> UNUPDATE_SESSION_MSG_TYPES;
    public static ChatMessageDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ChatMessageDbOberser> mObservers;

    /* loaded from: classes10.dex */
    public interface ChatMessageDbOberser {
        void notifyDbChange(int i2, ChatSession chatSession);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310143505, "Lcom/baidu/android/imsdk/chatmessage/db/ChatMessageDBManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(310143505, "Lcom/baidu/android/imsdk/chatmessage/db/ChatMessageDBManager;");
                return;
            }
        }
        UNUPDATE_SESSION_MSG_TYPES = Arrays.asList(Integer.valueOf((int) IMConstants.IM_MSG_TYPE_SHIELD_ME), Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL), 2001, 36);
    }

    public ChatMessageDBManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mObservers = null;
        setContext(context);
    }

    private String addPaidCondition(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, str2, Long.valueOf(j2)})) == null) ? IMConfigInternal.getInstance().getIMConfig(this.mContext).getPaidCondition(str, str2, j2) : (String) invokeCommon.objValue;
    }

    private long addReliableMsg(@NonNull TextMsg textMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, textMsg)) == null) {
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
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x02c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatMsg construChatMsg(Cursor cursor) {
        InterceptResult invokeL;
        int i2;
        long j2;
        String str;
        int i3;
        String str2;
        int i4;
        JSONObject optJSONObject;
        JSONObject jSONObject;
        String jSONObject2;
        ChatMsg newChatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, cursor)) == null) {
            int i5 = cursor.getInt(cursor.getColumnIndex("_id"));
            int i6 = cursor.getInt(cursor.getColumnIndex("type"));
            long j3 = cursor.getLong(cursor.getColumnIndex("from_user"));
            long j4 = cursor.getLong(cursor.getColumnIndex("msgid"));
            long j5 = cursor.getLong(cursor.getColumnIndex("time"));
            int i7 = cursor.getInt(cursor.getColumnIndex("is_read"));
            int i8 = cursor.getInt(cursor.getColumnIndex("status"));
            String string = cursor.getString(cursor.getColumnIndex("content"));
            int i9 = cursor.getInt(cursor.getColumnIndex("category"));
            long j6 = cursor.getLong(cursor.getColumnIndex("contacter"));
            int i10 = cursor.getInt(cursor.getColumnIndex("cmd"));
            String string2 = cursor.getString(cursor.getColumnIndex("local_url"));
            boolean z = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUMN_ISZHIDA)) == 1;
            boolean z2 = cursor.getInt(cursor.getColumnIndex("isclicked")) == 1;
            long j7 = cursor.getLong(cursor.getColumnIndex("paid"));
            int i11 = cursor.getInt(cursor.getColumnIndex("device_flag"));
            String string3 = cursor.getString(cursor.getColumnIndex("sendid"));
            String string4 = cursor.getString(cursor.getColumnIndex("buid"));
            String string5 = cursor.getString(cursor.getColumnIndex("msg_key"));
            long j8 = cursor.getLong(cursor.getColumnIndex("expires_time"));
            String string6 = cursor.getString(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_SERVICE_TYPE));
            int i12 = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TIPS_CODE));
            String string7 = cursor.getString(cursor.getColumnIndex("tips"));
            int i13 = cursor.getInt(cursor.getColumnIndex(TableDefine.MessageColumns.COLUME_TEMPLATE));
            if (i6 == 80) {
                try {
                    int i14 = i6;
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
                                        i3 = i13;
                                        str = string6;
                                        if (length == 1) {
                                            i2 = i5;
                                            try {
                                                optJSONObject = jSONArray.optJSONObject(0);
                                                jSONObject = new JSONObject();
                                                j2 = j3;
                                            } catch (Exception e2) {
                                                e = e2;
                                                j2 = j3;
                                            }
                                            try {
                                                jSONObject.put("title", optJSONObject.optString("title"));
                                                jSONObject.put("article_url", optJSONObject.optString("url"));
                                                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject.optString("headImage"));
                                                str2 = jSONObject.toString();
                                                i4 = 1;
                                                i14 = 8;
                                            } catch (Exception e3) {
                                                e = e3;
                                                string = string;
                                                i6 = 8;
                                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                                LogUtils.e(TAG, "du construChatMsg:", e);
                                                newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i9, i6, i10);
                                                if (newChatMsg != null) {
                                                }
                                            }
                                        } else {
                                            i2 = i5;
                                            j2 = j3;
                                            str2 = string;
                                            i4 = 1;
                                        }
                                        if (length > i4) {
                                            i14 = 9;
                                            try {
                                                JSONArray jSONArray2 = new JSONArray();
                                                int i15 = 0;
                                                while (i15 < length) {
                                                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i15);
                                                    int i16 = length;
                                                    JSONObject jSONObject6 = new JSONObject();
                                                    jSONObject6.put("title", optJSONObject2.optString("title"));
                                                    jSONObject6.put("article_url", optJSONObject2.optString("url"));
                                                    jSONObject6.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject2.optString("headImage"));
                                                    jSONArray2.put(jSONObject6);
                                                    i15++;
                                                    length = i16;
                                                    jSONArray = jSONArray;
                                                }
                                                JSONObject jSONObject7 = new JSONObject();
                                                jSONObject7.put("articles", jSONArray2);
                                                str2 = jSONObject7.toString();
                                            } catch (Exception e4) {
                                                e = e4;
                                                string = str2;
                                                i6 = 9;
                                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                                LogUtils.e(TAG, "du construChatMsg:", e);
                                                newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i9, i6, i10);
                                                if (newChatMsg != null) {
                                                }
                                            }
                                        }
                                        string = str2;
                                        i6 = i14;
                                    }
                                } else {
                                    i2 = i5;
                                    j2 = j3;
                                    str = string6;
                                    i3 = i13;
                                    try {
                                        string = jSONObject3.optString("content");
                                        i6 = optInt;
                                    } catch (Exception e5) {
                                        e = e5;
                                        i6 = optInt;
                                        string = string;
                                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                        LogUtils.e(TAG, "du construChatMsg:", e);
                                        newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i9, i6, i10);
                                        if (newChatMsg != null) {
                                        }
                                    }
                                }
                                string = jSONObject2;
                                i2 = i5;
                                j2 = j3;
                                str = string6;
                                i3 = i13;
                                i6 = 0;
                            } catch (Exception e6) {
                                e = e6;
                                i2 = i5;
                                j2 = j3;
                                str = string6;
                                i3 = i13;
                                string = string;
                                i6 = 0;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            i2 = i5;
                            j2 = j3;
                            str = string6;
                            i3 = i13;
                            i6 = i14;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i2 = i5;
                        j2 = j3;
                        str = string6;
                        i3 = i13;
                        i6 = i14;
                    }
                } catch (Exception e9) {
                    e = e9;
                    i2 = i5;
                    j2 = j3;
                    str = string6;
                    i3 = i13;
                }
            } else {
                i2 = i5;
                j2 = j3;
                str = string6;
                i3 = i13;
            }
            newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i9, i6, i10);
            if (newChatMsg != null) {
                return null;
            }
            newChatMsg.setCategory(i9);
            newChatMsg.setContacter(j6);
            newChatMsg.setFromUser(j2);
            newChatMsg.setMsgContent(string);
            newChatMsg.setRowId(i2);
            newChatMsg.setMsgId(j4);
            newChatMsg.setMsgTime(j5);
            newChatMsg.setMsgReaded(i7);
            newChatMsg.setStatus(i8);
            newChatMsg.setCategory(i9);
            newChatMsg.setContacter(j6);
            newChatMsg.setNotifyCmd(i10);
            newChatMsg.setLocalUrl(string2);
            newChatMsg.setIsZhida(z);
            newChatMsg.setIsClicked(z2);
            newChatMsg.setPaid(j7);
            newChatMsg.setMsgType(i6);
            newChatMsg.setDeviceFlag(i11);
            newChatMsg.setSendMsgId(string3);
            newChatMsg.setSenderUid(string4);
            newChatMsg.setMsgKey(string5);
            newChatMsg.setExpiresTime(j8);
            newChatMsg.setServiceType(str);
            newChatMsg.setTipsCode(i12);
            newChatMsg.setTips(string7);
            newChatMsg.setTemplateType(i3);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    private ChatSession constructChatRecord(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        InterceptResult invokeLL;
        String str;
        int i2;
        long j2;
        long j3;
        int i3;
        String str2;
        int i4;
        int i5;
        long j4;
        int i6;
        int i7;
        String str3;
        String str4;
        int i8;
        long j5;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i9;
        long j6;
        long j7;
        long j8;
        String senderUid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, sQLiteDatabase, cursor)) == null) {
            int i10 = cursor.getInt(cursor.getColumnIndex("category"));
            long j9 = cursor.getLong(cursor.getColumnIndex("contacter"));
            String string = cursor.getString(cursor.getColumnIndex("name"));
            String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG));
            long j10 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG_TIME));
            long j11 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME));
            long j12 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
            int i11 = cursor.getInt(cursor.getColumnIndex("weight"));
            int i12 = cursor.getInt(cursor.getColumnIndex("show"));
            int i13 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE));
            int i14 = cursor.getInt(cursor.getColumnIndex("chat_type"));
            String string3 = cursor.getString(cursor.getColumnIndex("icon_url"));
            int i15 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_STATE));
            int i16 = cursor.getInt(cursor.getColumnIndex("isclicked"));
            long j13 = cursor.getLong(cursor.getColumnIndex("paid"));
            int i17 = cursor.getInt(cursor.getColumnIndex("classtype"));
            int i18 = cursor.getInt(cursor.getColumnIndex("classshow"));
            String string4 = cursor.getString(cursor.getColumnIndex("classtitle"));
            String string5 = cursor.getString(cursor.getColumnIndex("classavatar"));
            int i19 = cursor.getInt(cursor.getColumnIndex("marktop"));
            long j14 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
            String string6 = cursor.getString(cursor.getColumnIndex("nickname"));
            String string7 = cursor.getString(cursor.getColumnIndex("extra"));
            String string8 = cursor.getString(cursor.getColumnIndex("v_portrait"));
            String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_CERTIFICATION));
            String string10 = cursor.getString(cursor.getColumnIndex("vip_id"));
            int i20 = cursor.getInt(cursor.getColumnIndex("shield"));
            long j15 = cursor.getLong(cursor.getColumnIndex("shield_time"));
            long j16 = cursor.getLong(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG_BDUID));
            String string11 = cursor.getString(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_LAST_MSG_NICKNAME));
            if (i10 == 0 && i14 == 0) {
                long buidByUK = IMUserManager.getInstance(this.mContext).getBuidByUK(j9);
                if (buidByUK >= 0 || TextUtils.isEmpty(string2)) {
                    str = string11;
                    i2 = i12;
                    j2 = j12;
                    j3 = j16;
                    i3 = i13;
                    str2 = string3;
                    i4 = i15;
                    i5 = i16;
                    j4 = j11;
                    i6 = i17;
                    i7 = i18;
                    str3 = string4;
                    str4 = string5;
                    i8 = i19;
                    j5 = j13;
                    str5 = string6;
                    str6 = string7;
                    str7 = string8;
                    str8 = string9;
                    str9 = string10;
                    i9 = i20;
                    j6 = j14;
                    j7 = j15;
                } else {
                    str = string11;
                    i3 = i13;
                    str2 = string3;
                    i4 = i15;
                    i5 = i16;
                    i6 = i17;
                    i7 = i18;
                    str3 = string4;
                    str4 = string5;
                    i8 = i19;
                    str5 = string6;
                    str6 = string7;
                    str7 = string8;
                    str8 = string9;
                    str9 = string10;
                    i9 = i20;
                    i2 = i12;
                    j2 = j12;
                    j3 = j16;
                    j4 = j11;
                    j5 = j13;
                    j6 = j14;
                    j7 = j15;
                    ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(0, j9, 1, (ChatMsg) null);
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
                                    j8 = Long.valueOf(senderUid).longValue();
                                    break;
                                } catch (NumberFormatException e2) {
                                    LogUtils.e(TAG, "", e2);
                                }
                            }
                        }
                    }
                }
                j8 = buidByUK;
            } else {
                str = string11;
                i2 = i12;
                j2 = j12;
                j3 = j16;
                i3 = i13;
                str2 = string3;
                i4 = i15;
                i5 = i16;
                j4 = j11;
                i6 = i17;
                i7 = i18;
                str3 = string4;
                str4 = string5;
                i8 = i19;
                j5 = j13;
                str5 = string6;
                str6 = string7;
                str7 = string8;
                str8 = string9;
                str9 = string10;
                i9 = i20;
                j6 = j14;
                j7 = j15;
                j8 = j9;
            }
            if (0 != j9) {
                if (!TextUtils.isEmpty(string2) || i14 == 27 || i14 == 17) {
                    ChatSession chatSession = new ChatSession(i10, j9, j8, string);
                    chatSession.setLastMsg(string2);
                    chatSession.setLastMsgTime(j10);
                    chatSession.setLastOpenTime(j4);
                    chatSession.setNewMsgSum(j2);
                    chatSession.setWeight(i11);
                    chatSession.setShow(i2);
                    chatSession.setCollectionType(i3);
                    chatSession.setChatType(i14);
                    chatSession.setIconUrl(str2);
                    chatSession.setState(i4);
                    chatSession.setIsClicked(i5);
                    chatSession.setPaid(j5);
                    chatSession.setClassType(i6);
                    chatSession.setClassTitle(str3);
                    chatSession.setClassAvatar(str4);
                    chatSession.setClassShow(i7);
                    chatSession.setMarkTop(i8);
                    chatSession.setMarkTopTime(j6);
                    chatSession.setNickName(str5);
                    chatSession.setExt(str6);
                    chatSession.setVPortrait(str7);
                    chatSession.setCertification(str8);
                    chatSession.setVipId(str9);
                    chatSession.setShield(i9);
                    chatSession.setShieldTime(j7);
                    chatSession.setLastMsgUid(j3);
                    chatSession.setLastMsgName(str);
                    return chatSession;
                }
                return null;
            }
            return new ChatSession(i10, j9, j8, string);
        }
        return (ChatSession) invokeLL.objValue;
    }

    private void contructChatRecordValues(int i2, ChatSession chatSession, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65543, this, i2, chatSession, contentValues) == null) {
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
            if (i2 == 0) {
                contentValues.put("weight", Integer.valueOf(chatSession.getWeight()));
            }
            contentValues.put("chat_type", Integer.valueOf(chatSession.getChatType()));
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
            contentValues.put(TableDefine.SessionColumns.COLUMN_LAST_MSG_BDUID, Long.valueOf(chatSession.getLastMsgUid()));
            contentValues.put(TableDefine.SessionColumns.COLUMN_LAST_MSG_NICKNAME, chatSession.getLastMsgName());
            contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
            contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
        }
    }

    private int delMsgs(long[] jArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, jArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i3 = -1;
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
                            i2 = 0;
                            for (long j2 : jArr) {
                                try {
                                    strArr[0] = String.valueOf(j2);
                                    i2 = (int) (i2 + openDatabase.delete("message", "msgid = ? AND status=?", strArr));
                                } catch (Exception e3) {
                                    e = e3;
                                    i3 = i2;
                                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                    LogUtils.e(TAG, "delMsg:", e);
                                    i2 = i3;
                                    return i2;
                                }
                            }
                            for (long j3 : jArr) {
                                long j4 = j3 + 1;
                                openDatabase.execSQL("delete from message where msgid=? and type in (?, ?, ?)", new Object[]{Long.valueOf(j4), Integer.valueOf((int) IMConstants.IM_MSG_TYPE_SHIELD_ME), 2001, Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL)});
                                LogUtils.e(TAG, "delete notSendButShowTipMsg :delete from message where msgid=? and type in (?, ?, ?), msgId :" + j4);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i3 = 0;
                        }
                        return i2;
                    }
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    private int delMsgsOfCertainContacterForSingle(ChatObject chatObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, this, chatObject, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i2 = -1;
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                try {
                    openDatabase.beginTransaction();
                    String str = "contacter = ?  AND category = ?";
                    boolean z = false;
                    int i3 = 1;
                    String[] strArr = {String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getCategory())};
                    int i4 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                    if (i4 != 0) {
                        str = "contacter = ?  AND category = ? AND msgid <= " + j2;
                    }
                    String addPaidCondition = addPaidCondition(str, "paid", chatObject.getPaid());
                    int delete = addPaidCondition != null ? openDatabase.delete("message", addPaidCondition, strArr) : -1;
                    long maxMsgid = getMaxMsgid(chatObject);
                    ChatSession chatSession = null;
                    if (i4 == 0 || maxMsgid <= j2) {
                        String[] strArr2 = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
                        String addPaidCondition2 = addPaidCondition("category = ? AND contacter = ?", "paid", chatObject.getPaid());
                        chatSession = getChatRecordInternal(openDatabase, chatObject);
                        int delete2 = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, addPaidCondition2, strArr2);
                        i3 = delete2;
                        if (delete2 > 0) {
                            z = true;
                        }
                    }
                    if (i3 < 0) {
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception e2) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                            LogUtils.e(TAG, "delMsgsOfCertainContacterForSingle finally:", e2);
                        }
                        return -1;
                    }
                    if (i3 >= 0) {
                        openDatabase.setTransactionSuccessful();
                        if (z && chatSession != null) {
                            notifyDbChange(2, chatSession);
                        }
                        i2 = delete;
                    }
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e3) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                        LogUtils.e(TAG, "delMsgsOfCertainContacterForSingle finally:", e3);
                    }
                    return i2;
                } catch (Exception e4) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                    LogUtils.e(TAG, "delMsg:", e4);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e5) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e5)).build();
                        LogUtils.e(TAG, "delMsgsOfCertainContacterForSingle finally:", e5);
                    }
                    return -1;
                }
            }
        }
        return invokeLJ.intValue;
    }

    private int delMsgsOfPaByPaId(long j2) {
        InterceptResult invokeJ;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i6 = -1;
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                try {
                    openDatabase.beginTransaction();
                    String[] strArr = {String.valueOf(j2)};
                    if (TextUtils.isEmpty("from_user = ? ")) {
                        i2 = -1;
                    } else {
                        i2 = openDatabase.delete("message", "from_user = ? ", strArr);
                        String str = TAG;
                        LogUtils.d(str, "--delMsgsOfPaByPaId--delMsgs = " + i2);
                    }
                    if (TextUtils.isEmpty("contacter = ? ")) {
                        i3 = -1;
                    } else {
                        i3 = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "contacter = ? ", strArr);
                        String str2 = TAG;
                        LogUtils.d(str2, "--delMsgsOfPaByPaId--delChatRecord = " + i3);
                    }
                    if (TextUtils.isEmpty("paid = ? ")) {
                        i4 = -1;
                    } else {
                        i4 = delete(openDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid = ? ", strArr);
                        String str3 = TAG;
                        LogUtils.d(str3, "--delMsgsOfPaByPaId--delPaInfoRecord = " + i4);
                    }
                    if (TextUtils.isEmpty("paid = ? ")) {
                        i5 = -1;
                    } else {
                        i5 = delete(openDatabase, TableDefine.DB_TABLE_ZHIDAINFO, "paid = ? ", strArr);
                        String str4 = TAG;
                        LogUtils.d(str4, "--delMsgsOfPaByPaId--delZhiDaPaInfoRecord = " + i5);
                    }
                    if (i2 >= 0 || i3 >= 0 || i4 >= 0 || i5 >= 0) {
                        openDatabase.setTransactionSuccessful();
                        i6 = i2;
                    }
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e2) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                        LogUtils.e(TAG, "delMsgsOfPaByPaId finally:", e2);
                    }
                    return i6;
                } catch (Exception e3) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                    LogUtils.e(TAG, "delMsgsOfPaByPaId:", e3);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e4) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                        LogUtils.e(TAG, "delMsgsOfPaByPaId finally:", e4);
                    }
                    return -1;
                }
            }
        }
        return invokeJ.intValue;
    }

    private int deleteDraftMsgForSingle(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, chatObject)) == null) {
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
        return invokeL.intValue;
    }

    private long dupMsgAddHandler(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, chatMsg)) == null) {
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
        return invokeL.longValue;
    }

    private long existStudioMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, sQLiteDatabase, chatMsg)) == null) {
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
                long j2 = query.getLong(query.getColumnIndex("_id"));
                if (query != null) {
                    query.close();
                }
                return j2;
            }
        }
        return invokeLL.longValue;
    }

    private ChatMsg generateStudioUsePaMsg(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, cursor)) == null) {
            long j2 = cursor.getLong(cursor.getColumnIndex("msgid"));
            int i2 = cursor.getInt(cursor.getColumnIndex("type"));
            long j3 = cursor.getLong(cursor.getColumnIndex("from_user"));
            long j4 = cursor.getLong(cursor.getColumnIndex("input_time"));
            int i3 = cursor.getInt(cursor.getColumnIndex("category"));
            long j5 = cursor.getLong(cursor.getColumnIndex("contacter"));
            String string = cursor.getString(cursor.getColumnIndex("msg_key"));
            String string2 = cursor.getString(cursor.getColumnIndex("content"));
            int i4 = cursor.getInt(cursor.getColumnIndex("is_read"));
            ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i3, i2, -1);
            if (newChatMsg == null) {
                return null;
            }
            newChatMsg.setCategory(i3);
            newChatMsg.setContacter(j5);
            newChatMsg.setFromUser(j3);
            newChatMsg.setMsgContent(string2);
            newChatMsg.setMsgId(j2);
            newChatMsg.setMsgKey(string);
            newChatMsg.setMsgTime(j4);
            newChatMsg.setMsgReaded(i4);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    private ChatSession getChatRecordInternal(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65553, this, sQLiteDatabase, chatObject)) != null) {
            return (ChatSession) invokeLL.objValue;
        }
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, this, chatObject)) == null) ? getInstance(this.mContext).getChatRecord(chatObject) : (ChatSession) invokeL.objValue;
    }

    private long getContacter(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1L;
            }
            return chatMsg.getContacter();
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private List<Long> getContacterByChatTypes(SQLiteDatabase sQLiteDatabase, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, this, sQLiteDatabase, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                return arrayList;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for (int i2 = 1; i2 < list.size(); i2++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(list.get(i2));
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
        return (List) invokeLL.objValue;
    }

    private boolean getCursorMoveDirection(boolean z, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j2 <= 0 || j3 <= 0) ? !z : z : invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: int */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r12 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (r12 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
        return r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatMsg getDraftMsgForSingle(int i2, long j2) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65558, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) != null) {
            return (ChatMsg) invokeCommon.objValue;
        }
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
                    cursor = openDatabase.query("message", null, "category=? AND contacter=? AND status=?", new String[]{String.valueOf(i2), String.valueOf(j2), String.valueOf(3)}, null, null, null, null);
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
                cursor2 = i2;
            }
        }
    }

    public static ChatMessageDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ChatMessageDBManager.class) {
                    if (mInstance == null) {
                        mInstance = new ChatMessageDBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (ChatMessageDBManager) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private List<Long> getUnreadContacterByChatTypes(SQLiteDatabase sQLiteDatabase, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, this, sQLiteDatabase, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                return arrayList;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for (int i2 = 1; i2 < list.size(); i2++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(list.get(i2));
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
        return (List) invokeLL.objValue;
    }

    private boolean isDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, this, chatMsg)) == null) ? chatMsg != null && (chatMsg instanceof TextMsg) && chatMsg.getStatus() == 3 : invokeL.booleanValue;
    }

    private long isDuplicateMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, this, sQLiteDatabase, chatMsg)) == null) {
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
                long j2 = query.getLong(query.getColumnIndex("_id"));
                if (query != null) {
                    query.close();
                }
                return j2;
            }
        }
        return invokeLL.longValue;
    }

    private long isMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, sQLiteDatabase, chatMsg)) == null) {
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
                long j2 = query.getLong(query.getColumnIndex("_id"));
                if (query != null) {
                    query.close();
                }
                return j2;
            }
        }
        return invokeLL.longValue;
    }

    private boolean isNeedInsertToDB(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, chatMsg)) == null) {
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
        return invokeL.booleanValue;
    }

    private boolean isReliableMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        boolean z;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, this, sQLiteDatabase, chatMsg)) == null) {
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
        return invokeLL.booleanValue;
    }

    private int markChatMsgClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    private boolean notSendButShowTipMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, this, chatMsg)) == null) ? chatMsg.getMsgType() == 2012 || chatMsg.getMsgType() == 2014 || chatMsg.getMsgType() == 2001 : invokeL.booleanValue;
    }

    private int setAllMsgRead(ChatObject chatObject, long j2) {
        InterceptResult invokeLJ;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65569, this, chatObject, j2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            String str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?)";
            if (j2 > 0) {
                str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?) AND msgid<=" + j2;
            }
            String addPaidCondition = addPaidCondition(str, "paid", chatObject.getPaid());
            String[] strArr = {String.valueOf(0), String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getContacter())};
            synchronized (DBBase.mSyncLock) {
                update = update("message", addPaidCondition, strArr, contentValues);
            }
            return update;
        }
        return invokeLJ.intValue;
    }

    private void setChatSessionLastName(ChatSession chatSession, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, this, chatSession, str) == null) {
            long longByString = Utility.getLongByString(str, 0L);
            if (chatSession.getChatType() != 57 || chatSession.getLastMsgUid() == longByString) {
                return;
            }
            chatSession.setLastMsgUid(longByString);
            if (longByString != 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(this.mContext, String.valueOf(chatSession.getContacter()), arrayList, 1);
                if (groupMember != null && groupMember.size() > 0) {
                    chatSession.setLastMsgName(groupMember.get(0).getShowName());
                    return;
                } else {
                    chatSession.setLastMsgName("");
                    return;
                }
            }
            chatSession.setLastMsgName("");
        }
    }

    private int setMsgReadByContacterIds(SQLiteDatabase sQLiteDatabase, List<Long> list, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, this, new Object[]{sQLiteDatabase, list, Long.valueOf(j2)})) == null) {
            if (list == null || list.size() <= 0) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            if (sQLiteDatabase == null) {
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(0));
                for (int i2 = 1; i2 < list.size(); i2++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(list.get(i2));
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_read", (Integer) 1);
                String str = "is_read=? AND category = ? AND contacter in (" + sb.toString() + ") ";
                if (j2 > 0) {
                    str = str + " AND msgid<=" + j2;
                }
                return sQLiteDatabase.update("message", contentValues, str, new String[]{String.valueOf(0), "0"});
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "setMsgReadByContacterIds:", e2);
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
            }
        }
        return invokeCommon.intValue;
    }

    private long studioMsgAddHandler(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, this, chatMsg)) == null) {
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
        return invokeL.longValue;
    }

    private int updateMsgStatusForSingle(ChatMsg chatMsg) {
        InterceptResult invokeL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, this, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            contentValues.put("content", chatMsg.getJsonContent());
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            contentValues.put(TableDefine.MessageColumns.COLUME_TIPS_CODE, Integer.valueOf(chatMsg.getTipsCode()));
            contentValues.put("tips", chatMsg.getTips());
            synchronized (DBBase.mSyncLock) {
                update = update("message", "_id = ?", new String[]{String.valueOf(chatMsg.getRowId())}, contentValues);
                if (update >= 0) {
                    updateChatSession(chatMsg);
                }
            }
            return update;
        }
        return invokeL.intValue;
    }

    public ArrayList<ChatMsg> addCastReliableMsgs(@NonNull List<TextMsg> list, List<Long> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, list2)) == null) {
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
        return (ArrayList) invokeLL.objValue;
    }

    public long addMsg(ChatMsg chatMsg, boolean z) {
        InterceptResult invokeLZ;
        long addMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg, z)) == null) {
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
        return invokeLZ.longValue;
    }

    public ArrayList<ChatMsg> addMsgs(Context context, ArrayList<ChatMsg> arrayList, boolean z, long j2) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, arrayList, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            ArrayList<ChatMsg> arrayList3 = arrayList;
            if (arrayList3 != null) {
                synchronized (DBBase.mSyncLock) {
                    AccountManagerImpl.getInstance(this.mContext).getUid();
                    arrayList2 = new ArrayList<>();
                    ArrayList<ChatMsg> arrayList4 = new ArrayList<>();
                    ArrayList<ChatMsg> arrayList5 = new ArrayList<>();
                    ArrayList<ChatMsg> arrayList6 = new ArrayList<>();
                    HashMap<ChatObject, Integer> hashMap = new HashMap<>();
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        ChatMsg chatMsg = arrayList3.get(i2);
                        chatMsg.setTriggerReasonn(j2);
                        try {
                            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                            jSONObject.put(Constants.EXTRA_TRIGGER_REASON, j2);
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
                                        i2++;
                                        arrayList3 = arrayList;
                                    }
                                }
                            }
                        }
                        i2++;
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
        return (ArrayList) invokeCommon.objValue;
    }

    public long createChatSession(ChatObject chatObject, String str, int i2, String str2, int i3, String str3, String str4, int i4, int i5, long j2, int i6, long j3, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        ChatMsg chatMsg;
        int i7;
        int unReadMsgCount;
        String str8;
        ArrayList<ChatMsg> fetchMsgExcludeTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{chatObject, str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Integer.valueOf(i6), Long.valueOf(j3), str5, str6, str7})) == null) {
            if (getChatSession(chatObject) != null) {
                return 0L;
            }
            int category = chatObject.getCategory();
            long contacter = chatObject.getContacter();
            synchronized (DBBase.mSyncLock) {
                if (category == 0 && i2 == 0) {
                    contacter = IMUserManager.getInstance(this.mContext).getBuidByUK(contacter);
                }
                ChatSession chatSession = new ChatSession(category, chatObject.getContacter(), contacter, str);
                ChatMsg draftMsg = getDraftMsg(chatObject.getCategory(), chatObject.getContacter());
                if (draftMsg == null) {
                    if (1 != chatObject.getCategory()) {
                        fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                    } else if (i2 == 4) {
                        fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchLastChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    } else {
                        fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    }
                    if (fetchMsgExcludeTypes == null) {
                        LogUtils.e(TAG, "updateChatRecordName fetchmsg error! ");
                        return -1L;
                    } else if (fetchMsgExcludeTypes.size() == 0) {
                        LogUtils.e(TAG, "updateChatRecordName  msgs.size() = 0! ");
                        return 0L;
                    } else {
                        draftMsg = fetchMsgExcludeTypes.get(0);
                    }
                }
                ChatMsg chatMsg2 = draftMsg;
                String str9 = "";
                if (chatObject.getCategory() != 0 || (chatObject.getContacter() & Constants.PAFLAG) == 0) {
                    chatMsg = chatMsg2;
                    i7 = 1;
                } else {
                    if (!chatMsg2.isSelf(this.mContext)) {
                        chatMsg = chatMsg2;
                        str8 = chatMsg2.getExtLog();
                        i7 = 1;
                    } else {
                        chatMsg = chatMsg2;
                        i7 = 1;
                        ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                        if (fetchMsg != null && fetchMsg.size() > 0) {
                            str9 = fetchMsg.get(0).getExtLog();
                        }
                        str8 = str9;
                    }
                    chatSession.addExt("ext_log", str8);
                }
                if (i7 == chatObject.getCategory()) {
                    unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                } else {
                    unReadMsgCount = getUnReadMsgCount(chatObject);
                }
                chatSession.setChatType(i2);
                if (unReadMsgCount >= 0) {
                    chatSession.setNewMsgSum(unReadMsgCount);
                }
                String recommendDescription = chatMsg.getRecommendDescription();
                ChatMsg chatMsg3 = chatMsg;
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
                chatSession.setClassType(i3);
                chatSession.setClassTitle(str3);
                chatSession.setClassAvatar(str4);
                chatSession.setClassShow(i4);
                chatSession.setMarkTop(i5);
                chatSession.setMarkTopTime(j2);
                chatSession.setVipId(str5);
                chatSession.setVPortrait(str6);
                chatSession.setCertification(str7);
                chatSession.setShield(i6);
                chatSession.setShieldTime(j3);
                setChatSessionLastName(chatSession, chatMsg3.getSenderUid());
                if (chatMsg3.isStarMessage()) {
                    chatSession.setChatType(4);
                }
                return getInstance(this.mContext).updateChatSession(i7, chatSession);
            }
        }
        return invokeCommon.longValue;
    }

    public long delChatRecord(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, chatObject)) == null) {
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
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0027, B:9:0x002e, B:11:0x0030, B:44:0x00dd, B:45:0x00e0, B:39:0x00d5, B:40:0x00d8, B:30:0x00c2, B:31:0x00c5), top: B:53:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long delChatRecordForChatType(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048581, this, i2)) != null) {
            return invokeI.longValue;
        }
        synchronized (DBBase.mSyncLock) {
            LogUtils.d(TAG, "delChatRecordForChatType chatType = " + i2);
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            ArrayList arrayList = new ArrayList();
            try {
                String[] strArr = {String.valueOf(i2)};
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
                    j2 = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, "chat_type = ?", strArr);
                    openDatabase.delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "pasubtype = ?", strArr);
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        openDatabase.delete("message", "from_user = ?", new String[]{String.valueOf(arrayList.get(i3))});
                    }
                } else {
                    j2 = -1;
                }
                LogUtils.d(TAG, "delChatRecordForChatType num = " + j2);
                if (query != null) {
                    query.close();
                }
                return j2;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9 A[Catch: all -> 0x00f2, TryCatch #2 {all -> 0x00f2, blocks: (B:50:0x00e9, B:51:0x00ec, B:42:0x00de, B:43:0x00e1, B:54:0x00f0), top: B:62:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long delChatRecordForClassTypeOne() {
        InterceptResult invokeV;
        Cursor cursor;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.longValue;
        }
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
                                        try {
                                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                            LogUtils.e(TAG, "HBBH delChatRecordForClassTypeOne:", e);
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
                            j2 = openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, "classtype = ? AND chat_type = ?", strArr);
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                openDatabase.delete("message", "from_user = ?", new String[]{String.valueOf(arrayList.get(i2))});
                            }
                        } else {
                            j2 = -1;
                        }
                        LogUtils.d(TAG, "HBBH delChatRecordForClassTypeOne num = " + j2);
                        if (query != null) {
                            query.close();
                        }
                        return j2;
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
                throw th;
            }
        }
    }

    public int delMsgsOfCertainContacter(ChatObject chatObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, chatObject, j2)) == null) {
            int i2 = 1;
            if (1 == chatObject.getCategory()) {
                int delMsgsOfCertainContacter = GroupMessageDAOImpl.delMsgsOfCertainContacter(this.mContext, String.valueOf(chatObject.getContacter()), j2);
                synchronized (DBBase.mSyncLock) {
                    SQLiteDatabase openDatabase = openDatabase();
                    if (openDatabase == null) {
                        LogUtils.d(TAG, "getWritableDb fail!");
                        return -1;
                    }
                    try {
                        long maxMsgid = GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
                        if (j2 == -1 || maxMsgid <= j2) {
                            String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
                            String addPaidCondition = addPaidCondition("category = ? AND contacter = ?", "paid", chatObject.getPaid());
                            ChatSession chatRecordInternal = getChatRecordInternal(openDatabase, chatObject);
                            i2 = delete(openDatabase, TableDefine.DB_TABLE_CHAT_SESSION, addPaidCondition, strArr);
                            if (i2 > 0 && chatRecordInternal != null) {
                                notifyDbChange(2, chatRecordInternal);
                            }
                        }
                        if (i2 < 0) {
                            return -1;
                        }
                        if (i2 < 0) {
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
            return delMsgsOfCertainContacterForSingle(chatObject, j2);
        }
        return invokeLJ.intValue;
    }

    public void delPaLocalInfosByPaType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(this.mContext).queryPaIdByPaType(i2);
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
    }

    public long delSysMsg(int i2, long j2, int i3) {
        InterceptResult invokeCommon;
        long delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)})) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete("message", "category = ?  AND (contacter = ? OR from_user = ? ) AND cmd = ? ", new String[]{String.valueOf(i2), String.valueOf(j2), String.valueOf(j2), String.valueOf(i3)});
            }
            return delete;
        }
        return invokeCommon.longValue;
    }

    public long deleteAllMsg(ChatObject chatObject) {
        InterceptResult invokeL;
        long maxMsgid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, chatObject)) == null) {
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
        return invokeL.longValue;
    }

    public int deleteAllMsgWithMsgid(ChatObject chatObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, chatObject, j2)) == null) {
            synchronized (this.mContext) {
                int delMsgsOfCertainContacter = getInstance(this.mContext).delMsgsOfCertainContacter(chatObject, j2);
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
        return invokeLJ.intValue;
    }

    public int deleteChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        int deleteChatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    public int deleteChatSession(long j2) {
        InterceptResult invokeJ;
        String[] strArr;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                String str = null;
                if (j2 != -1) {
                    str = "paid = ?";
                    strArr = new String[]{String.valueOf(j2)};
                } else {
                    strArr = null;
                }
                delete = delete(TableDefine.DB_TABLE_CHAT_SESSION, str, strArr);
            }
            return delete;
        }
        return invokeJ.intValue;
    }

    public int deleteDraftMsg(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, chatObject)) == null) {
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
        return invokeL.intValue;
    }

    public long deleteExpiredDupMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        return invokeV.longValue;
    }

    public long deleteExpiredReliableMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        return invokeV.longValue;
    }

    public int deleteMsgBatch(ChatObject chatObject, long[] jArr) {
        InterceptResult invokeLL;
        int delMsgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, chatObject, jArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (1 == chatObject.getCategory()) {
                    delMsgs = GroupMessageDAOImpl.deleteMsgs(this.mContext, String.valueOf(chatObject.getContacter()), jArr);
                } else {
                    delMsgs = getInstance(this.mContext).delMsgs(jArr);
                }
                return delMsgs < 0 ? DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND : updateSession(delMsgs, chatObject);
            }
        }
        return invokeLL.intValue;
    }

    public long deleteStudioUsePaMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        return invokeV.longValue;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j2, long j3) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            synchronized (DBBase.mSyncLock) {
                fetchMsg = fetchMsg(chatObject, j2, j3, j2 == 0 ? -1L : Long.MAX_VALUE, false);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
        if (r8 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bc, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dc, code lost:
        if (r8 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgByContacterIdOrderByMsgid(List<Long> list, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{list, Long.valueOf(j2), Integer.valueOf(i2)})) != null) {
            return (ArrayList) invokeCommon.objValue;
        }
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i3 = 1; i3 < list.size(); i3++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(list.get(i3));
        }
        String str = "contacter in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
        if (j2 > 0) {
            str = str + " AND msgid < " + j2;
        }
        String str2 = "select * from message where " + str + " ORDER BY msgid desc limit " + Math.abs(i2);
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

    public ArrayList<ChatMsg> fetchMsgExcludeTypes(ChatObject chatObject, long j2, long j3, List<Integer> list) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3), list})) == null) {
            synchronized (DBBase.mSyncLock) {
                String str = null;
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            StringBuilder sb = new StringBuilder("type NOT IN (");
                            for (Integer num : list) {
                                sb.append(num.intValue());
                                sb.append(",");
                            }
                            str = sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                fetchMsg = fetchMsg(chatObject, j2, j3, j2 == 0 ? -1L : Long.MAX_VALUE, false, str);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgsByMsgTypes(ChatObject chatObject, long j2, long j3, List<Integer> list) {
        InterceptResult invokeCommon;
        String str;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3), list})) == null) {
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
                            fetchMsg = fetchMsg(chatObject, j2, j3, j2 != 0 ? -1L : Long.MAX_VALUE, false, str);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                str = null;
                fetchMsg = fetchMsg(chatObject, j2, j3, j2 != 0 ? -1L : Long.MAX_VALUE, false, str);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMsgsExceptGroupSystemMsgSync(ChatObject chatObject, long j2, long j3, long j4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)})) == null) ? fetchMsg(chatObject, j2, j3, j4, z, "type != 101") : (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c7, code lost:
        if (r1 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c9, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
        if (r1 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ed, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatMsg> fetchPaMsgByChatType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048604, this, i2, i3)) != null) {
            return (List) invokeII.objValue;
        }
        ArrayList arrayList = new ArrayList();
        List<PaInfo> queryPaInfoByChatType = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByChatType(i2);
        Cursor cursor = null;
        if (queryPaInfoByChatType == null || queryPaInfoByChatType.size() <= 0) {
            return null;
        }
        String str = "" + queryPaInfoByChatType.get(0).getPaId();
        for (int i4 = 1; i4 < queryPaInfoByChatType.size(); i4++) {
            str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + queryPaInfoByChatType.get(i4).getPaId();
        }
        String str2 = "select * from message where " + ("paid in (" + str + ") ") + " ORDER BY time desc limit " + Math.abs(i3);
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
        if (r8 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bc, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dc, code lost:
        if (r8 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchPaMsgByPaids(List<Long> list, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{list, Long.valueOf(j2), Integer.valueOf(i2)})) != null) {
            return (ArrayList) invokeCommon.objValue;
        }
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (list == null || list.size() <= 0) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i3 = 1; i3 < list.size(); i3++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(list.get(i3));
        }
        String str = "contacter in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
        if (j2 > 0) {
            str = str + " AND msgid < " + j2;
        }
        String str2 = "select * from message where " + str + " ORDER BY msgid desc limit " + Math.abs(i2);
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

    public ArrayList<ChatMsg> fetchSpecifyMsgsSync(ChatObject chatObject, int i2, long j2, long j3, long j4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{chatObject, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)})) == null) {
            return fetchMsg(chatObject, j2, j3, j4, z, "type = " + i2);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<SessionClass> getAllClassType() {
        InterceptResult invokeV;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                ArrayList<SessionClass> arrayList = new ArrayList<>();
                Cursor cursor = null;
                if (openDatabase == null) {
                    return null;
                }
                try {
                    try {
                        query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"classtype", "classtitle", "classshow", "classavatar"}, "classtype > 1 ", null, "classtype", null, null, null);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
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
                        int i2 = query.getInt(query.getColumnIndex("classtype"));
                        int i3 = query.getInt(query.getColumnIndex("classshow"));
                        String string = query.getString(query.getColumnIndex("classtitle"));
                        String string2 = query.getString(query.getColumnIndex("classavatar"));
                        SessionClass sessionClass = new SessionClass();
                        sessionClass.setType(i2);
                        sessionClass.setTitle(string);
                        sessionClass.setAvatarurl(string2);
                        sessionClass.setShow(i3);
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
        return (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r12 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
        if (r12 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
        return r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getChatMsgByMsgId(long j2) {
        InterceptResult invokeJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048608, this, j2)) != null) {
            return (ChatMsg) invokeJ.objValue;
        }
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
                    cursor = openDatabase.query("message", null, "msgid=? AND status=?", new String[]{String.valueOf(j2), String.valueOf(0)}, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                chatMsg = construChatMsg(cursor);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "fetchMsg:", e);
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
                cursor2 = j2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0073 A[Catch: all -> 0x0077, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x000e, B:16:0x004f, B:17:0x0052, B:22:0x0058, B:23:0x005b, B:31:0x006a, B:32:0x006d, B:37:0x0073, B:38:0x0076), top: B:46:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSession getChatRecord(ChatObject chatObject) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048610, this, chatObject)) != null) {
            return (ChatSession) invokeL.objValue;
        }
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.database.Cursor] */
    public ChatSession getChatRecordByContacter(ChatObject chatObject) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048611, this, chatObject)) != null) {
            return (ChatSession) invokeL.objValue;
        }
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

    public ArrayList<ChatSession> getChatRecords(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            LogUtils.enter();
            return getChatRecords(j2, j3, j4, null);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long j2, long j3, long j4, List<Integer> list) {
        InterceptResult invokeCommon;
        String str;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), list})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                ArrayList<ChatSession> arrayList = new ArrayList<>();
                Cursor cursor = null;
                if (openDatabase == null) {
                    return null;
                }
                long j5 = j2 + j3;
                try {
                    try {
                        String addPaidCondition = addPaidCondition("show= ?", "paid", j4);
                        LogUtils.e(TAG, addPaidCondition);
                        if (list == null || list.size() <= 0) {
                            str = addPaidCondition;
                        } else {
                            String str2 = "" + list.get(0);
                            for (int i2 = 1; i2 < list.size(); i2++) {
                                str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2);
                            }
                            str = addPaidCondition + " AND classtype in (" + str2 + ") ";
                        }
                        query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", j5 > 0 ? String.valueOf(j5) : null);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
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
                    query.moveToPosition(((int) j2) - 1);
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
        return (ArrayList) invokeCommon.objValue;
    }

    public ChatMsg getDraftMsg(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (1 == i2) {
                return GroupMessageDAOImpl.getDraftMsg(this.mContext, String.valueOf(j2));
            }
            return getDraftMsgForSingle(i2, j2);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public List<ChatSession> getGroupSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048616, this)) != null) {
            return (List) invokeV.objValue;
        }
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
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r12 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r12 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
        return r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getLatestMsg(int i2, long j2) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) != null) {
            return (ChatMsg) invokeCommon.objValue;
        }
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
                    cursor = openDatabase.query("message", null, "category=? AND contacter=? ", new String[]{String.valueOf(i2), String.valueOf(j2)}, null, null, "msgid desc ", String.valueOf(1));
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
                cursor2 = i2;
            }
        }
    }

    public long getMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
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
                    long j2 = cursor.getLong(cursor.getColumnIndex("msgid"));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return j2;
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
        return invokeV.longValue;
    }

    public ArrayList<ChatMsg> getMaxMsgidByChatTypes(List<Integer> list, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{list, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                return fetchMsgByContacterIdOrderByMsgid(getContacterByChatTypes(openDatabase, list), j2, i2);
            }
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxReliableMsgId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048621, this, j2)) != null) {
            return invokeJ.longValue;
        }
        String str = "select max(msgid) as max_msg_id from " + TableDefine.DB_TABLE_RELIABLE_MESSAGE + " where mcast_id = " + j2;
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
                    long j3 = cursor.getLong(cursor.getColumnIndex("max_msg_id"));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return j3;
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "getMaxReliableMsgId:", e2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0051 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x005d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: android.database.Cursor */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (r7 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        if (r7 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getMsgByMsgId(long j2) {
        InterceptResult invokeJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048622, this, j2)) != null) {
            return (ChatMsg) invokeJ.objValue;
        }
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
                String[] strArr = {String.valueOf(j2)};
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
                    } catch (Exception e2) {
                        e = e2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getMsgByMsgId:", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
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
            cursor2 = j2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
        if (r4 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
        if (r4 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d1, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCount(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048624, this, list)) != null) {
            return invokeL.intValue;
        }
        if (list == null || list.size() <= 0) {
            return 0;
        }
        synchronized (DBBase.mSyncLock) {
            int i2 = -1;
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
                        for (int i3 = 1; i3 < list.size(); i3++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i3);
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
                i2 = cursor.getInt(0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r3 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCountOfClass(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048625, this, i2)) != null) {
            return invokeI.intValue;
        }
        synchronized (DBBase.mSyncLock) {
            int i3 = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            Cursor cursor = null;
            try {
                String str = "classtype = " + i2;
                String str2 = "select sum(new_msg_sum) from chatrecord";
                if (!TextUtils.isEmpty(str)) {
                    str2 = "select sum(new_msg_sum) from chatrecord where " + str;
                }
                cursor = openDatabase.rawQuery(str2, null);
                if (cursor != null && cursor.moveToNext()) {
                    i3 = cursor.getInt(0);
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, " getNewMsgCount:", e2);
            }
        }
    }

    public int getNewMsgNum(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, chatObject)) == null) {
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
        return invokeL.intValue;
    }

    public ArrayList<ChatMsg> getNotificationMsgDataList(SparseArray<List<Integer>> sparseArray, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{sparseArray, Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? fetchPaMsgByPaids(new ArrayList(PaInfoDBManager.getInstance(this.mContext).getPaidListByPainfos(sparseArray)), j2, i2) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getPaMsgByChatTypeAndPaidList(List<Integer> list, List<Long> list2, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{list, list2, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
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
                return fetchPaMsgByPaids(new ArrayList(hashSet), j2, i2);
            }
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getStudioUsePaUnReadMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048629, this)) != null) {
            return (ArrayList) invokeV.objValue;
        }
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            try {
                if (openDatabase == null) {
                    return null;
                }
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, chatObject)) == null) {
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
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
        if (0 == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isRecordExist(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048631, this, sQLiteDatabase, chatObject)) != null) {
            return invokeLL.booleanValue;
        }
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, chatMsg)) == null) {
            if (1 == chatMsg.getCategory()) {
                return GroupMessageDAOImpl.markMsgClicked(this.mContext, chatMsg);
            }
            return markChatMsgClicked(chatMsg);
        }
        return invokeL.intValue;
    }

    public synchronized void notifyDbChange(int i2, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048633, this, i2, chatSession) == null) {
            synchronized (this) {
                if (this.mObservers != null && this.mObservers.size() != 0 && chatSession != null) {
                    for (ChatMessageDbOberser chatMessageDbOberser : this.mObservers) {
                        if (chatMessageDbOberser != null) {
                            chatMessageDbOberser.notifyDbChange(i2, chatSession);
                        }
                    }
                }
            }
        }
    }

    public void recordLastMsg(HashMap<ChatObject, Integer> hashMap) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, hashMap) == null) {
            LogUtils.d(TAG, "recordReceiveLastMsg");
            for (Map.Entry<ChatObject, Integer> entry : hashMap.entrySet()) {
                ChatObject key = entry.getKey();
                int intValue = entry.getValue().intValue();
                ArrayList<ChatMsg> fetchMsgExcludeTypes = fetchMsgExcludeTypes(entry.getKey(), 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                if (fetchMsgExcludeTypes.size() > 0) {
                    ChatMsg chatMsg = fetchMsgExcludeTypes.get(0);
                    String recommendDescription = chatMsg.getRecommendDescription();
                    if (chatMsg instanceof HtmlMsg) {
                        recommendDescription = chatMsg.getLocalUrl();
                    }
                    String str2 = recommendDescription;
                    long newMsgNum = getNewMsgNum(key);
                    int i2 = newMsgNum >= 0 ? (int) (intValue + newMsgNum) : intValue;
                    int clickState = Utility.getClickState(chatMsg);
                    if (key.getCategory() == 0 && (key.getContacter() & Constants.PAFLAG) != 0) {
                        if (!chatMsg.isSelf(this.mContext)) {
                            str = chatMsg.getExtLog();
                        } else {
                            ArrayList<ChatMsg> fetchMsg = fetchMsg(key, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                            if (fetchMsg != null && fetchMsg.size() > 0) {
                                str = fetchMsg.get(0).getExtLog();
                            }
                        }
                        recordLastMsg(key, str2, chatMsg.getMsgTime(), i2, chatMsg.getStatus(), clickState, chatMsg.isStarMessage(), str, chatMsg.getSenderUid());
                    }
                    str = "";
                    recordLastMsg(key, str2, chatMsg.getMsgTime(), i2, chatMsg.getStatus(), clickState, chatMsg.isStarMessage(), str, chatMsg.getSenderUid());
                }
            }
        }
    }

    public synchronized void registerObserver(ChatMessageDbOberser chatMessageDbOberser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, chatMessageDbOberser) == null) {
            synchronized (this) {
                if (chatMessageDbOberser == null) {
                    return;
                }
                if (this.mObservers == null) {
                    this.mObservers = new LinkedList();
                }
                this.mObservers.add(chatMessageDbOberser);
            }
        }
    }

    public boolean setAllMsgReadWithMsgid(ChatObject chatObject, long j2) {
        InterceptResult invokeLJ;
        int allMsgRead;
        int unReadMsgCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048637, this, chatObject, j2)) == null) {
            if (j2 == -1) {
                j2 = getInstance(this.mContext).getMaxMsgid(chatObject);
            }
            synchronized (DBBase.mSyncLock) {
                if (j2 < 0) {
                    return false;
                }
                if (chatObject.getCategory() == 1) {
                    allMsgRead = GroupMessageDAOImpl.setAllMsgRead(this.mContext, String.valueOf(chatObject.getContacter()), j2);
                } else {
                    allMsgRead = getInstance(this.mContext).setAllMsgRead(chatObject, j2);
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
                        if (57 == chatRecord.getChatType()) {
                            if (unReadMsgCount > 0) {
                                ArrayList<ChatMsg> fansGroupAtUnread = GroupMessageDAOImpl.getFansGroupAtUnread(this.mContext, Long.toString(chatRecord.getContacterId()), AccountManager.getUid(this.mContext));
                                if (fansGroupAtUnread != null) {
                                    chatRecord.setNewFansAtMsgSum(fansGroupAtUnread.size());
                                } else {
                                    chatRecord.setNewFansAtMsgSum(0);
                                }
                            } else {
                                chatRecord.setNewFansAtMsgSum(0);
                            }
                        }
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
        return invokeLJ.booleanValue;
    }

    public int setMsgRead(ChatObject chatObject, long j2) {
        InterceptResult invokeLJ;
        int msgRead;
        ChatSession chatSession;
        int unReadMsgCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048638, this, chatObject, j2)) == null) {
            if (chatObject == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            synchronized (DBBase.mSyncLock) {
                if (1 == chatObject.getCategory()) {
                    msgRead = GroupMessageDAOImpl.setMsgReaded(this.mContext, String.valueOf(chatObject.getContacter()), j2);
                } else {
                    msgRead = getInstance(this.mContext).setMsgRead(j2);
                }
                if (msgRead < 0) {
                    return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
                }
                if (msgRead != 0 && (chatSession = getChatSession(chatObject)) != null) {
                    if (1 == chatObject.getCategory()) {
                        unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                        if (57 == chatSession.getChatType()) {
                            if (unReadMsgCount > 0) {
                                ArrayList<ChatMsg> fansGroupAtUnread = GroupMessageDAOImpl.getFansGroupAtUnread(this.mContext, String.valueOf(chatObject.getContacter()), AccountManager.getUid(this.mContext));
                                if (fansGroupAtUnread != null) {
                                    chatSession.setNewFansAtMsgSum(fansGroupAtUnread.size());
                                } else {
                                    chatSession.setNewFansAtMsgSum(0);
                                }
                            } else {
                                chatSession.setNewFansAtMsgSum(0);
                            }
                        }
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
        return invokeLJ.intValue;
    }

    public List<Long> setMsgReadByChatTypes(List<Integer> list, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048639, this, list, j2)) == null) {
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
                        if (setMsgReadByContacterIds(openDatabase, unreadContacterByChatTypes, j2) > 0) {
                            for (Long l : unreadContacterByChatTypes) {
                                long longValue = l.longValue();
                                int unReadMsgCount = getUnReadMsgCount(new ChatObject(this.mContext, 0, longValue));
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM, Integer.valueOf(unReadMsgCount));
                                getInstance(this.mContext).updateChatSession("category=? AND contacter=?", new String[]{String.valueOf(0), String.valueOf(longValue)}, contentValues);
                            }
                        }
                        openDatabase.setTransactionSuccessful();
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception e2) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                            LogUtils.e(TAG, "setPaMsgReadByChatTypes finally:", e2);
                        }
                        return unreadContacterByChatTypes;
                    }
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e3) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                        LogUtils.e(TAG, "setPaMsgReadByChatTypes finally:", e3);
                    }
                    return unreadContacterByChatTypes;
                } catch (Exception e4) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                    LogUtils.e(TAG, "setPaMsgReadByChatTypes:", e4);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e5) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e5)).build();
                        LogUtils.e(TAG, "setPaMsgReadByChatTypes finally:", e5);
                    }
                    return null;
                }
            }
        }
        return (List) invokeLJ.objValue;
    }

    public List<Long> setPaMsgReadByChatTypeAndSubType(SparseArray<List<Integer>> sparseArray, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048640, this, sparseArray, j2)) == null) {
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
                        int msgReadByContacterIds = setMsgReadByContacterIds(openDatabase, paidListByPainfos, j2);
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
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception e2) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                            LogUtils.e(TAG, "setPaMsgReadByChatTypeAndSubType finally:", e2);
                        }
                        return paidListByPainfos;
                    }
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e3) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                        LogUtils.e(TAG, "setPaMsgReadByChatTypeAndSubType finally:", e3);
                    }
                    return null;
                } catch (Exception e4) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                    LogUtils.e(TAG, "setPaMsgReadByChatTypeAndSubType:", e4);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e5) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e5)).build();
                        LogUtils.e(TAG, "setPaMsgReadByChatTypeAndSubType finally:", e5);
                    }
                    return null;
                }
            }
        }
        return (List) invokeLJ.objValue;
    }

    public int setStudioMsgRead(long j2) {
        InterceptResult invokeJ;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048641, this, j2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            synchronized (DBBase.mSyncLock) {
                update = update(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, "msgid = ?", new String[]{String.valueOf(j2)}, contentValues);
            }
            return update;
        }
        return invokeJ.intValue;
    }

    public synchronized void unRegisterObserver(ChatMessageDbOberser chatMessageDbOberser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, chatMessageDbOberser) == null) {
            synchronized (this) {
                if (this.mObservers == null) {
                    return;
                }
                this.mObservers.remove(chatMessageDbOberser);
            }
        }
    }

    public int updateChatMsgContent(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    public void updateChatSession(String str, String[] strArr, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048646, this, str, strArr, contentValues) == null) {
            update(TableDefine.DB_TABLE_CHAT_SESSION, str, strArr, contentValues);
        }
    }

    public int updateChatSessionName(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, chatSession)) == null) {
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
        return invokeL.intValue;
    }

    public int updateMsgStatus(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    public int updateSession(int i2, ChatObject chatObject) {
        InterceptResult invokeIL;
        ArrayList<ChatMsg> fetchMsgExcludeTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048650, this, i2, chatObject)) == null) {
            synchronized (DBBase.mSyncLock) {
                ChatMsg chatMsg = null;
                ChatSession chatSession = getChatSession(chatObject);
                if (chatSession != null && chatSession.getState() != 3) {
                    if (i2 != 0) {
                        if (1 == chatObject.getCategory()) {
                            fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                        } else {
                            fetchMsgExcludeTypes = fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                        }
                        if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                            chatMsg = fetchMsgExcludeTypes.get(0);
                        }
                        updateSession(true, chatSession, chatMsg);
                    }
                    return i2;
                }
                return i2;
            }
        }
        return invokeIL.intValue;
    }

    public void updateSessionClass(PaInfo paInfo) {
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, paInfo) == null) || (chatRecord = getChatRecord(new ChatObject(this.mContext, 0, paInfo.getPaId(), -1L, -1))) == null) {
            return;
        }
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
        chatRecord.setChatType(paInfo.getSubtype());
        updateChatSession(1, chatRecord);
    }

    public long updateChatSession(int i2, ChatSession chatSession) {
        InterceptResult invokeIL;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048644, this, i2, chatSession)) == null) {
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
                    contructChatRecordValues(i2, chatSession, contentValues);
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
        return invokeIL.longValue;
    }

    public ArrayList<ChatSession> getChatRecords(long j2, long j3, long j4, List<Integer> list) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), list})) != null) {
            return (ArrayList) invokeCommon.objValue;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            Cursor cursor = null;
            if (openDatabase == null) {
                return null;
            }
            long j5 = j2 + j3;
            try {
                try {
                    String addPaidCondition = addPaidCondition("show= ?", "paid", j4);
                    LogUtils.e(TAG, addPaidCondition);
                    if (list == null || list.size() <= 0) {
                        str = addPaidCondition;
                    } else {
                        String str2 = "" + list.get(0);
                        for (int i2 = 1; i2 < list.size(); i2++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2);
                        }
                        str = addPaidCondition + " AND chat_type in (" + str2 + ") ";
                    }
                    Cursor query = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", j5 > 0 ? String.valueOf(j5) : null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    try {
                        LogUtils.e(TAG, "cursor count" + query.getCount());
                        query.moveToPosition(((int) j2) - 1);
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
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
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
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            synchronized (DBBase.mSyncLock) {
                fetchMsg = fetchMsg(chatObject, j2, j3, j4, false);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public int updateMsgStatus(long j2, int i2) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(i2));
            synchronized (DBBase.mSyncLock) {
                update = update("message", "_id = ?", new String[]{String.valueOf(j2)}, contentValues);
            }
            return update;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00ac */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00ae */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.String] */
    public ArrayList<ChatMsg> fetchMsg(String str, String str2) {
        InterceptResult invokeLL;
        ?? r8;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) != null) {
            return (ArrayList) invokeLL.objValue;
        }
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
                    } catch (Exception e2) {
                        e = e2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "fetchMsg:", e);
                        if (r8 != 0) {
                            r8.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
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

    private int deleteChatMsg(long j2) {
        InterceptResult invokeJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65547, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                int i3 = 0;
                try {
                    i2 = openDatabase.delete("message", "_id = ? ", new String[]{String.valueOf(j2)});
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    long j3 = j2 + 1;
                    openDatabase.execSQL("delete from message where _id=? and type in (?, ?, ?)", new Object[]{Long.valueOf(j3), Integer.valueOf((int) IMConstants.IM_MSG_TYPE_SHIELD_ME), 2001, Integer.valueOf((int) IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL)});
                    String str = TAG;
                    LogUtils.e(str, "deleteChatMsg notSendButShowTipMsg :delete from message where _id=? and type in (?, ?, ?), rowId :" + j3);
                } catch (Exception e3) {
                    e = e3;
                    i3 = i2;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "deleteChatMsg:", e);
                    i2 = i3;
                    return i2;
                }
                return i2;
            }
        }
        return invokeJ.intValue;
    }

    private long addMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1L;
            }
            int i2 = 1;
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
                            i2 = 0;
                        }
                        contentValues.put("isclicked", Integer.valueOf(i2));
                        contentValues.put("paid", Long.valueOf(chatMsg.getPaid()));
                        contentValues.put("device_flag", Integer.valueOf(chatMsg.getDeviceFlag()));
                        contentValues.put("msg_key", chatMsg.getMsgKey());
                        contentValues.put("sendid", chatMsg.getSendMsgId());
                        contentValues.put("expires_time", Long.valueOf(chatMsg.getExpiresTime()));
                        contentValues.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, chatMsg.getServiceType());
                        contentValues.put(TableDefine.MessageColumns.COLUME_TIPS_CODE, Integer.valueOf(chatMsg.getTipsCode()));
                        contentValues.put("tips", chatMsg.getTips());
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
        return invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
        if (r1 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c0, code lost:
        if (0 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c4, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getNewMsgNum(SQLiteDatabase sQLiteDatabase, ChatObject chatObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65560, this, sQLiteDatabase, chatObject)) != null) {
            return invokeLL.intValue;
        }
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
                    int i2 = cursor.getInt(cursor.getColumnIndex(TableDefine.SessionColumns.COLUMN_NEW_MSG_SUM));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return i2;
                }
                String str2 = TAG;
                LogUtils.d(str2, "getNewMsgNum record not found! " + chatObject.toString());
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getNewMsgNum:", e2);
            }
        }
    }

    private void updateSession(boolean z, ChatSession chatSession, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65575, this, new Object[]{Boolean.valueOf(z), chatSession, chatMsg}) == null) && z) {
            if (chatSession == null) {
                long contacter = getContacter(chatMsg);
                if (contacter != -1) {
                    GetChatObjectInfoForRecordManager.getChatObjectForSession(this.mContext, new ChatObject(this.mContext, chatMsg.getCategory(), contacter, chatMsg.getPaid(), chatMsg.getChatType()));
                }
            } else if (chatMsg == null) {
                if (getInstance(this.mContext).delChatRecord(new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter(), chatSession.getPaid(), -1)) >= 0) {
                    chatSession.setNewMsgSum(0L);
                    chatSession.setNewFansAtMsgSum(0);
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
                setChatSessionLastName(chatSession, chatMsg.getSenderUid());
                getInstance(this.mContext).updateChatSession(1, chatSession);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006a A[Catch: all -> 0x006e, TryCatch #4 {, blocks: (B:6:0x0008, B:8:0x000f, B:16:0x0046, B:17:0x0049, B:22:0x004f, B:23:0x0052, B:31:0x0061, B:32:0x0064, B:37:0x006a, B:38:0x006d), top: B:49:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSession getChatRecord(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) != null) {
            return (ChatSession) invokeCommon.objValue;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_CHAT_SESSION, null, addPaidCondition("category = ? AND contacter=?", "paid", j3), new String[]{String.valueOf(i2), String.valueOf(j2)}, null, null, null, null);
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

    public long getMaxMsgid(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, chatObject)) == null) {
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
        return invokeL.longValue;
    }

    public void updateSessionClass(ChatUser chatUser) {
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048651, this, chatUser) == null) || (chatRecord = getChatRecord(new ChatObject(this.mContext, 0, chatUser.getUk(), -1L, -1))) == null) {
            return;
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r3 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r3 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNewMsgCount(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048623, this, j2)) != null) {
            return invokeJ.intValue;
        }
        synchronized (DBBase.mSyncLock) {
            int i2 = -1;
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return -1;
            }
            Cursor cursor = null;
            String str = "";
            if (j2 != -1) {
                try {
                    str = "paid=" + j2;
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
                i2 = cursor.getInt(0);
            }
        }
    }

    private int setMsgRead(long j2) {
        InterceptResult invokeJ;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65571, this, j2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            synchronized (DBBase.mSyncLock) {
                update = update("message", "msgid = ?", new String[]{String.valueOf(j2)}, contentValues);
            }
            return update;
        }
        return invokeJ.intValue;
    }

    public void recordLastMsg(ChatObject chatObject, String str, long j2, int i2, int i3, int i4, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{chatObject, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), str2, str3}) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "recordSendLastMsg " + chatObject.toString());
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
                chatRecord.setState(i3);
                chatRecord.setIsClicked(i4);
                setChatSessionLastName(chatRecord, str3);
            }
            chatRecord.setLastMsgTime(j2);
            if (i2 >= 0) {
                chatRecord.setNewMsgSum(i2);
                if (chatRecord.getChatType() == 57) {
                    ArrayList<ChatMsg> fansGroupAtUnread = GroupMessageDAOImpl.getFansGroupAtUnread(this.mContext, Long.toString(chatRecord.getContacterId()), AccountManager.getUid(this.mContext));
                    if (fansGroupAtUnread != null) {
                        chatRecord.setNewFansAtMsgSum(fansGroupAtUnread.size());
                    } else {
                        chatRecord.setNewFansAtMsgSum(0);
                    }
                }
            }
            chatRecord.setLastMsgTime(j2);
            chatRecord.setShow(1);
            if (z) {
                chatRecord.setChatType(4);
            }
            if (chatObject.getCategory() == 0 && (chatObject.getContacter() & Constants.PAFLAG) != 0) {
                chatRecord.addExt("ext_log", str2);
            }
            updateChatSession(1, chatRecord);
        }
    }

    public void updateChatSession(ChatMsg chatMsg) {
        ArrayList<ChatMsg> fetchMsgExcludeTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, chatMsg) == null) {
            ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), chatMsg.getChatType());
            ChatSession chatSession = getChatSession(chatObject);
            boolean z = false;
            if (!isDraftMsg(chatMsg)) {
                if (chatSession == null || chatSession.getState() != 3) {
                    if (1 == chatMsg.getCategory()) {
                        fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatMsg.getContacter()), null, 1L, true);
                    } else {
                        fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                    }
                    if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                        int chatType = chatMsg.getChatType();
                        ChatMsg chatMsg2 = fetchMsgExcludeTypes.get(0);
                        chatMsg2.setChatType(chatType);
                        chatMsg = chatMsg2;
                    }
                }
                updateSession(z, chatSession, chatMsg);
            }
            z = true;
            updateSession(z, chatSession, chatMsg);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110 A[Catch: all -> 0x0233, Exception -> 0x0236, TryCatch #6 {Exception -> 0x0236, all -> 0x0233, blocks: (B:42:0x007d, B:44:0x008e, B:47:0x0099, B:50:0x0110, B:52:0x0121, B:53:0x0135, B:55:0x014e, B:57:0x0156, B:66:0x0172, B:67:0x01ab, B:48:0x00d6), top: B:129:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0121 A[Catch: all -> 0x0233, Exception -> 0x0236, TryCatch #6 {Exception -> 0x0236, all -> 0x0233, blocks: (B:42:0x007d, B:44:0x008e, B:47:0x0099, B:50:0x0110, B:52:0x0121, B:53:0x0135, B:55:0x014e, B:57:0x0156, B:66:0x0172, B:67:0x01ab, B:48:0x00d6), top: B:129:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014e A[Catch: all -> 0x0233, Exception -> 0x0236, TryCatch #6 {Exception -> 0x0236, all -> 0x0233, blocks: (B:42:0x007d, B:44:0x008e, B:47:0x0099, B:50:0x0110, B:52:0x0121, B:53:0x0135, B:55:0x014e, B:57:0x0156, B:66:0x0172, B:67:0x01ab, B:48:0x00d6), top: B:129:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j2, long j3, long j4, boolean z, String str) {
        InterceptResult invokeCommon;
        long j5;
        String str2;
        String str3;
        String str4;
        String[] strArr;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), str})) != null) {
            return (ArrayList) invokeCommon.objValue;
        }
        long j6 = j3;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        SQLiteDatabase openDatabase = openDatabase();
        Cursor cursor = null;
        if (openDatabase == null) {
            LogUtils.d(TAG, "getReadableDb fail!");
            return null;
        }
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 <= 0 && j6 >= 0) {
            j6 = -j6;
        }
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                if (0 == j2 && j4 == -1) {
                    str2 = " >= ";
                } else {
                    int i3 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
                    if (i3 == 0) {
                        str2 = " = ";
                        j5 = -2;
                    } else if (i3 > 0) {
                        str2 = " > ";
                        j5 = j4 == Long.MAX_VALUE ? 0L : j4;
                    } else {
                        j5 = j4 != -1 ? j4 : Long.MAX_VALUE;
                        str2 = " < ";
                    }
                    if (j5 != -2) {
                        try {
                            str3 = " AND _id" + str2 + j5;
                            if (chatObject.getContacter() != 17 && chatObject.getContacter() != 26) {
                                str4 = "contacter = ? AND msgid" + str2 + "? AND category = ? ";
                                strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j2), String.valueOf(chatObject.getCategory())};
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
                                if (j6 == 0) {
                                    j6 = 1;
                                }
                                long j7 = j6;
                                String str6 = (j7 > 0 || i2 <= 0) ? " desc " : " asc ";
                                String str7 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j7);
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
                                        boolean cursorMoveDirection = getCursorMoveDirection(z, j2, j7);
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
                            strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j2), String.valueOf(0)};
                            if (str3 != null) {
                            }
                            if (str != null) {
                            }
                            str5 = str4 + " AND status != 3";
                            if (chatObject.getCategory() != 17) {
                                str5 = addPaidCondition(str5, "paid", chatObject.getPaid());
                            }
                            if (j6 == 0) {
                            }
                            long j72 = j6;
                            if (j72 > 0) {
                            }
                            String str72 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j72);
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
                    strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j2), String.valueOf(chatObject.getCategory())};
                    if (str3 != null) {
                    }
                    if (str != null) {
                    }
                    str5 = str4 + " AND status != 3";
                    if (chatObject.getCategory() != 17) {
                    }
                    if (j6 == 0) {
                    }
                    long j722 = j6;
                    if (j722 > 0) {
                    }
                    String str722 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j722);
                    synchronized (DBBase.mSyncLock) {
                    }
                }
                synchronized (DBBase.mSyncLock) {
                }
            } catch (Throwable th3) {
                th = th3;
            }
            str4 = "type = ? AND msgid" + str2 + "? AND category = ? ";
            strArr = new String[]{String.valueOf(chatObject.getContacter()), String.valueOf(j2), String.valueOf(0)};
            if (str3 != null) {
            }
            if (str != null) {
            }
            str5 = str4 + " AND status != 3";
            if (chatObject.getCategory() != 17) {
            }
            if (j6 == 0) {
            }
            long j7222 = j6;
            if (j7222 > 0) {
            }
            String str7222 = "select * from message where " + str5 + " ORDER BY msgid" + str6 + ",_id" + str6 + " limit " + Math.abs(j7222);
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

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j2, long j3, long j4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{chatObject, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)})) == null) ? fetchMsg(chatObject, j2, j3, j4, z, null) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, ChatMsg chatMsg, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{chatObject, chatMsg, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (1 == chatObject.getCategory()) {
                return GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), chatMsg, j2, z);
            }
            return fetchMsg(chatObject, chatMsg == null ? 0L : chatMsg.getMsgId(), j2, chatMsg == null ? -1L : chatMsg.getRowId(), z, null);
        }
        return (ArrayList) invokeCommon.objValue;
    }
}
