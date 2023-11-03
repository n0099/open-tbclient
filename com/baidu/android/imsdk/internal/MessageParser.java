package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.InterActiveMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAckRequest;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.request.AckHandlerThread;
import com.baidu.android.imsdk.request.AckMessage;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.Utils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tieba.j40;
import com.baidu.tieba.n40;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MessageParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MessageParser";
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isDuMsg(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65541, null, i, i2, i3)) == null) ? ((i == 80 && i2 != 11) || (i == 0 && i2 == 10)) && i3 == 0 : invokeIII.booleanValue;
    }

    /* loaded from: classes.dex */
    public static class DuParser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int category;
        public String content;
        public Context context;
        public boolean jsonParseResult;
        public ChatMsg msg;
        public boolean msgIsNull;

        public DuParser(Context context, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
            this.content = str;
            this.category = i;
        }

        public ChatMsg getMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.msg;
            }
            return (ChatMsg) invokeV.objValue;
        }

        public boolean isJsonParseResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.jsonParseResult;
            }
            return invokeV.booleanValue;
        }

        public boolean isMsgNull() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.msgIsNull;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:96:0x0264, code lost:
            if (r8 > (-1)) goto L63;
         */
        /* JADX WARN: Removed duplicated region for block: B:127:0x032d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x017f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DuParser invokeParse() throws Exception {
            InterceptResult invokeV;
            String str;
            int i;
            String optString;
            String str2;
            String str3;
            String str4;
            int i2;
            int i3;
            String str5;
            int i4;
            String str6;
            ChatMsg newChatMsg;
            int i5;
            String optString2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str7 = IMConstants.MSG_CONTENT_EXT_ACTION;
                JSONObject jSONObject = new JSONObject(this.content);
                try {
                    optString2 = jSONObject.optString("ext");
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    str = jSONObject2.optString(IMConstants.MSG_CONTENT_EXT_ACTION, "");
                    try {
                        i = jSONObject2.optInt(IMConstants.MSG_CONTENT_EXT_SOURCE, -1);
                    } catch (Exception unused2) {
                    }
                    optString = jSONObject.optString("text");
                    int optInt = jSONObject.optInt("template_type", 0);
                    String optString3 = jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "");
                    if (TextUtils.isEmpty(optString)) {
                        String optString4 = new JSONObject(optString).optString("msg");
                        if (!TextUtils.isEmpty(optString4)) {
                            JSONObject jSONObject3 = new JSONObject(optString4);
                            String optString5 = jSONObject3.optString("ext");
                            if (!TextUtils.isEmpty(optString5)) {
                                JSONObject jSONObject4 = new JSONObject(optString5);
                                int optInt2 = jSONObject4.optInt("type");
                                String optString6 = jSONObject4.optString("content");
                                if (jSONObject4.has("body")) {
                                    int optInt3 = jSONObject4.optInt("type", 1);
                                    if (optInt3 == 1) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("text", jSONObject4.optString("body"));
                                        String jSONObject6 = jSONObject5.toString();
                                        str2 = IMConstants.MSG_CONTENT_EXT_SOURCE;
                                        str3 = IMConstants.MSG_CONTENT_EXT_ACTION;
                                        str4 = optString3;
                                        i2 = i;
                                        str6 = jSONObject6;
                                        i3 = optInt;
                                        str5 = MessageParser.TAG;
                                        i4 = 0;
                                    } else if (optInt3 == 0) {
                                        JSONArray jSONArray = new JSONArray(jSONObject4.optString("body"));
                                        int length = jSONArray.length();
                                        str5 = MessageParser.TAG;
                                        i3 = optInt;
                                        str4 = optString3;
                                        if (length > 1) {
                                            JSONArray jSONArray2 = new JSONArray();
                                            str2 = IMConstants.MSG_CONTENT_EXT_SOURCE;
                                            int i6 = 0;
                                            while (i6 < jSONArray.length()) {
                                                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                                                String str8 = str7;
                                                JSONObject jSONObject7 = new JSONObject();
                                                jSONObject7.put("title", optJSONObject.optString("title"));
                                                jSONObject7.put("article_url", optJSONObject.optString("url"));
                                                jSONObject7.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject.optString("headImage"));
                                                jSONArray2.put(jSONObject7);
                                                i6++;
                                                str7 = str8;
                                                i = i;
                                            }
                                            str3 = str7;
                                            i2 = i;
                                            JSONObject jSONObject8 = new JSONObject();
                                            jSONObject8.put("articles", jSONArray2);
                                            str6 = jSONObject8.toString();
                                            i4 = 9;
                                        } else {
                                            str2 = IMConstants.MSG_CONTENT_EXT_SOURCE;
                                            str3 = IMConstants.MSG_CONTENT_EXT_ACTION;
                                            i2 = i;
                                            if (jSONArray.length() == 1) {
                                                JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
                                                JSONObject jSONObject9 = new JSONObject();
                                                jSONObject9.put("title", optJSONObject2.optString("title"));
                                                jSONObject9.put("article_url", optJSONObject2.optString("url"));
                                                jSONObject9.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject2.optString("headImage"));
                                                str6 = jSONObject9.toString();
                                                i4 = 8;
                                            }
                                            i4 = optInt2;
                                            str6 = optString6;
                                        }
                                    }
                                    newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.context, this.category, i4, -1);
                                    this.msg = newChatMsg;
                                    if (newChatMsg != null) {
                                        this.msgIsNull = true;
                                        return this;
                                    }
                                    String optString7 = jSONObject.optString("ext");
                                    if (!TextUtils.isEmpty(optString7)) {
                                        JSONObject jSONObject10 = new JSONObject(optString7);
                                        int optInt4 = jSONObject10.optInt("sub_app_identity");
                                        if (optInt4 == 7) {
                                            this.msg.setChatType(7);
                                        } else if (optInt4 == 16) {
                                            this.msgIsNull = true;
                                            return this;
                                        } else if (optInt4 == 17) {
                                            this.msg.setChatType(17);
                                        } else if (optInt4 == 6) {
                                            this.msgIsNull = true;
                                            return this;
                                        } else if (optInt4 == 19) {
                                            this.msg.setChatType(19);
                                        } else if (optInt4 == 23) {
                                            this.msg.setChatType(23);
                                        } else if (optInt4 == 24) {
                                            this.msg.setChatType(24);
                                        } else if (optInt4 == 25) {
                                            this.msg.setChatType(25);
                                        } else if (optInt4 == 26) {
                                            this.msg.setChatType(26);
                                        } else if (optInt4 == 27) {
                                            this.msg.setChatType(27);
                                        } else if (optInt4 == 29) {
                                            this.msg.setChatType(29);
                                        } else if (Utility.availableNotificationPaType(optInt4)) {
                                            this.msg.setChatType(optInt4);
                                        } else if (optInt4 == 20) {
                                            this.msg.setChatType(20);
                                        } else if (optInt4 == 60) {
                                            this.msg.setChatType(60);
                                        } else {
                                            this.msg.setChatType(optInt4);
                                        }
                                        this.msg.setMsgType(i4);
                                        String optString8 = jSONObject3.optString("description");
                                        if (!TextUtils.isEmpty(optString8)) {
                                            if (i4 == 18) {
                                                ((HtmlMsg) this.msg).setDesc(optString8);
                                            } else if (i4 == 24) {
                                                ((InterActiveMsg) this.msg).setLocalUrl(optString8);
                                            }
                                        }
                                        int i7 = i2;
                                        if (TextUtils.isEmpty(str)) {
                                            i5 = -1;
                                        } else {
                                            i5 = -1;
                                        }
                                        JSONObject jSONObject11 = new JSONObject(str6);
                                        if (!TextUtils.isEmpty(str)) {
                                            jSONObject11.put(str3, str);
                                        }
                                        if (i7 > i5) {
                                            jSONObject11.put(str2, i7);
                                        }
                                        str6 = jSONObject11.toString();
                                        if (jSONObject10.has("session_exts")) {
                                            JSONObject jSONObject12 = new JSONObject(str6);
                                            JSONObject optJSONObject3 = jSONObject12.optJSONObject("ext");
                                            if (optJSONObject3 != null) {
                                                optJSONObject3.put("session_exts", jSONObject10.optJSONObject("session_exts"));
                                            } else {
                                                JSONObject jSONObject13 = new JSONObject();
                                                jSONObject13.put("session_exts", jSONObject10.optJSONObject("session_exts"));
                                                jSONObject12.put("ext", jSONObject13);
                                            }
                                            str6 = jSONObject12.toString();
                                        }
                                        JSONObject jSONObject14 = new JSONObject(str6);
                                        int optInt5 = jSONObject3.optInt("template_version", -1);
                                        if (!jSONObject14.has("template_version") && optInt5 > 0) {
                                            jSONObject14.put("template_version", optInt5);
                                            str6 = jSONObject14.toString();
                                        }
                                        if (jSONObject10.has("block_type")) {
                                            JSONObject jSONObject15 = new JSONObject(str6);
                                            JSONObject optJSONObject4 = jSONObject15.optJSONObject("ext");
                                            if (optJSONObject4 != null) {
                                                optJSONObject4.put("block_type", jSONObject10.optInt("block_type"));
                                            } else {
                                                JSONObject jSONObject16 = new JSONObject();
                                                jSONObject16.put("block_type", jSONObject10.optInt("block_type"));
                                                jSONObject15.put("ext", jSONObject16);
                                            }
                                            str6 = jSONObject15.toString();
                                        }
                                        this.jsonParseResult = this.msg.setMsgContentFromServer(str6);
                                        this.msg.setmExtJson(optString7);
                                        this.msg.setServiceType(str4);
                                        this.msg.setTemplateType(i3);
                                    } else {
                                        LogUtils.e(str5, "duzhan msg parse error! ext in content is null!");
                                    }
                                }
                                str2 = IMConstants.MSG_CONTENT_EXT_SOURCE;
                                str3 = IMConstants.MSG_CONTENT_EXT_ACTION;
                                str4 = optString3;
                                i2 = i;
                                i3 = optInt;
                                str5 = MessageParser.TAG;
                                i4 = optInt2;
                                str6 = optString6;
                                newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.context, this.category, i4, -1);
                                this.msg = newChatMsg;
                                if (newChatMsg != null) {
                                }
                            } else {
                                LogUtils.e(MessageParser.TAG, "duzhan msg parse error! ext in text is null!");
                            }
                        } else {
                            LogUtils.e(MessageParser.TAG, "duzhan msg parse error! msg in text is null!");
                        }
                    } else {
                        LogUtils.e(MessageParser.TAG, "duzhan msg parse error! text in content is null!");
                    }
                    this.msgIsNull = false;
                    return this;
                }
                str = "";
                i = -1;
                optString = jSONObject.optString("text");
                int optInt6 = jSONObject.optInt("template_type", 0);
                String optString32 = jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "");
                if (TextUtils.isEmpty(optString)) {
                }
                this.msgIsNull = false;
                return this;
            }
            return (DuParser) invokeV.objValue;
        }
    }

    public MessageParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void ackMsgBody(Context context, ChatMsg chatMsg, NewAckMessage.Tripule tripule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, chatMsg, tripule) == null) {
            if (!TextUtils.isEmpty(chatMsg.getMsgContent())) {
                try {
                    JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("text"));
                    int optInt = jSONObject.optInt("template_type", -1);
                    tripule.setTemplateType(optInt);
                    tripule.setSdkVersion(IMConfigInternal.getInstance().getSDKVersionValue(context));
                    String optString = jSONObject2.optString("msg");
                    if (optInt > 0 && !TextUtils.isEmpty(optString)) {
                        tripule.setTemplateVersion(new JSONObject(optString).optInt("template_version", -1));
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        String optString2 = new JSONObject(optString).optString("ext");
                        if (!TextUtils.isEmpty(optString2)) {
                            JSONObject jSONObject3 = new JSONObject(optString2);
                            tripule.setTopicSource(jSONObject3.optString(IMConstants.MSG_TOPIC_SOURCE, ""));
                            tripule.setTopicId(Utility.getLongByString(jSONObject3.optString("topic_id", ""), 0L));
                        }
                    }
                } catch (JSONException e) {
                    LogUtils.e(TAG, "ackMsgBody :" + e.getMessage());
                }
            }
            try {
                JSONObject jSONObject4 = new JSONObject(chatMsg.getMsgContent());
                if (jSONObject4.has("send_type")) {
                    tripule.setSendType(jSONObject4.optInt("send_type"));
                }
                if (jSONObject4.has("send_scene")) {
                    tripule.setSendScene(jSONObject4.optInt("send_scene"));
                }
                String optString3 = jSONObject4.optString("ext");
                if (!TextUtils.isEmpty(optString3)) {
                    JSONObject jSONObject5 = new JSONObject(optString3);
                    if (jSONObject5.has(IMConstants.MSG_CONTENT_EXT_ACTION)) {
                        tripule.setInterActiveAction(jSONObject5.optString(IMConstants.MSG_CONTENT_EXT_ACTION));
                    }
                    if (jSONObject5.has(IMConstants.MSG_CONTENT_EXT_SOURCE)) {
                        tripule.setInterActiveSource(jSONObject5.optInt(IMConstants.MSG_CONTENT_EXT_SOURCE));
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, "ackMsgBody sendType:" + e2.getMessage());
            }
        }
    }

    public static synchronized List<NewAckMessage.Tripule> handleAck(Context context, ArrayList<ChatMsg> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        long j;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, arrayList, z)) == null) {
            synchronized (MessageParser.class) {
                LinkedList linkedList = new LinkedList();
                long triggerId = Utility.getTriggerId(context);
                if (AccountManagerImpl.getInstance(context).getLoginType() == 6) {
                    str = "cuid";
                } else {
                    str = "uid";
                }
                long uk = AccountManager.getUK(context);
                boolean z2 = false;
                int i2 = 0;
                while (i2 < arrayList.size()) {
                    ChatMsg chatMsg = arrayList.get(i2);
                    if (chatMsg != null) {
                        int category = chatMsg.getCategory();
                        long contacter = chatMsg.getContacter();
                        j = triggerId;
                        boolean z3 = z2;
                        i = i2;
                        NewAckMessage.Tripule tripule = new NewAckMessage.Tripule(chatMsg.getMsgId(), chatMsg.getMsgKey(), chatMsg.getMsgTime(), contacter, chatMsg.getMsgType(), str, chatMsg.getFromUser(), uk, chatMsg.getBusinessType(), category, chatMsg.getNotifyId(), chatMsg.getNotifyId(), chatMsg.getEventList());
                        tripule.setOriginPa(chatMsg.getOriginPa());
                        ackMsgBody(context, chatMsg, tripule);
                        z2 = true;
                        if (category == 1) {
                            tripule.setGroupId(contacter);
                        } else if (category == 4) {
                            tripule.setMcastId(contacter);
                            if (ConversationStudioManImpl.getInstance(context).isReliable(contacter)) {
                                tripule.setStudioIsReliable(true);
                                linkedList.add(tripule);
                            }
                        }
                        z2 = z3;
                        linkedList.add(tripule);
                    } else {
                        j = triggerId;
                        i = i2;
                    }
                    i2 = i + 1;
                    triggerId = j;
                }
                long j2 = triggerId;
                boolean z4 = z2;
                if (!z) {
                    return linkedList;
                }
                sendNewAckToServer(context, j2, linkedList, z4);
                return linkedList;
            }
        }
        return (List) invokeLLZ.objValue;
    }

    public static void handleAckArray(Context context, JSONArray jSONArray, long j, long j2, String str) {
        String str2;
        long j3;
        boolean z;
        int i;
        int i2;
        long j4;
        long j5;
        JSONObject jSONObject;
        NewAckMessage.Tripule tripule;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, jSONArray, Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            LinkedList linkedList = new LinkedList();
            long triggerId = Utility.getTriggerId(context);
            if (AccountManagerImpl.getInstance(context).getLoginType() == 6) {
                str2 = "cuid";
            } else {
                str2 = "uid";
            }
            String str4 = str2;
            long uk = AccountManager.getUK(context);
            long j6 = -1;
            long j7 = -1;
            boolean z2 = false;
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                TextMsg textMsg = new TextMsg();
                try {
                    jSONObject = jSONArray.getJSONObject(i3);
                    j4 = jSONObject.optLong("msgid");
                } catch (Exception e) {
                    e = e;
                    j3 = triggerId;
                    z = z2;
                    i = i3;
                    i2 = 1;
                    j4 = j6;
                }
                try {
                    j5 = jSONObject.optLong("from_user");
                    try {
                        textMsg.setMsgKey(jSONObject.optString("msg_key"));
                        textMsg.setMsgType(jSONObject.optInt("type"));
                        textMsg.setMsgTime(jSONObject.optLong("create_time"));
                        textMsg.setMsgContent(jSONObject.optString("content"));
                        int optInt = jSONObject.optInt("business_type");
                        textMsg.setBusinessType(optInt);
                        int optInt2 = jSONObject.optInt("category");
                        long optLong = jSONObject.optLong("contacter");
                        if (optInt == 1 && optInt2 == 2) {
                            j3 = triggerId;
                            i = i3;
                        } else {
                            j3 = triggerId;
                            LinkedList linkedList2 = linkedList;
                            i2 = 1;
                            z = z2;
                            i = i3;
                            try {
                                tripule = new NewAckMessage.Tripule(j4, textMsg.getMsgKey(), textMsg.getMsgTime(), optLong, textMsg.getMsgType(), str4, j5, uk, textMsg.getBusinessType(), optInt2, j, j2, str);
                                tripule.setOriginPa(jSONObject.optString("origin_pa"));
                                ackMsgBody(context, textMsg, tripule);
                            } catch (Exception e2) {
                                e = e2;
                                linkedList = linkedList2;
                            }
                            try {
                                if (optInt2 == 1) {
                                    tripule.setGroupId(optLong);
                                } else if (optInt2 == 4) {
                                    tripule.setMcastId(optLong);
                                    if (ConversationStudioManImpl.getInstance(context).isReliable(optLong)) {
                                        tripule.setStudioIsReliable(true);
                                        linkedList = linkedList2;
                                        z2 = true;
                                        linkedList.add(tripule);
                                    }
                                } else if (optInt2 == 0 && optInt != 27) {
                                    long optLong2 = jSONObject.optLong("to_user");
                                    String str5 = "";
                                    String str6 = "B";
                                    if (optLong2 == AccountManager.getUK(context)) {
                                        str5 = "N";
                                        if (jSONObject.optLong(Constants.EXTRA_PAUID_TYPE) != 0 && AccountManager.getMediaRole(context)) {
                                            str3 = "B";
                                        } else {
                                            str3 = "C";
                                        }
                                        if ((j5 & 17592186044416L) != 0) {
                                            tripule.setFromSelf(str5);
                                            tripule.setFromType(str6);
                                            tripule.setToType(str3);
                                        }
                                        str6 = "C";
                                        tripule.setFromSelf(str5);
                                        tripule.setFromType(str6);
                                        tripule.setToType(str3);
                                    } else {
                                        if (j5 != AccountManager.getUK(context)) {
                                            str3 = "";
                                            str6 = str3;
                                        } else {
                                            str5 = "Y";
                                            if ((optLong2 & 17592186044416L) != 0) {
                                                str3 = "B";
                                            } else {
                                                str3 = "C";
                                            }
                                            if (AccountManager.getMediaRole(context)) {
                                            }
                                            str6 = "C";
                                        }
                                        tripule.setFromSelf(str5);
                                        tripule.setFromType(str6);
                                        tripule.setToType(str3);
                                    }
                                }
                                linkedList.add(tripule);
                            } catch (Exception e3) {
                                e = e3;
                                z = z2;
                                LogUtils.e(TAG, "handleAckMsg Exception ：" + e.getMessage());
                                NewAckMessage.Tripule tripule2 = new NewAckMessage.Tripule(j4, "", System.currentTimeMillis(), -1L, -1, str4, j5, uk, -1, -1, j, j2, str);
                                tripule2.setIsParseFailed(i2);
                                linkedList.add(tripule2);
                                j6 = j4;
                                j7 = j5;
                                z2 = z;
                                i3 = i + 1;
                                triggerId = j3;
                            }
                            linkedList = linkedList2;
                            z2 = z;
                        }
                        j6 = j4;
                        j7 = j5;
                    } catch (Exception e4) {
                        e = e4;
                        j3 = triggerId;
                        z = z2;
                        i = i3;
                        i2 = 1;
                    }
                } catch (Exception e5) {
                    e = e5;
                    j3 = triggerId;
                    z = z2;
                    i = i3;
                    i2 = 1;
                    j5 = j7;
                    LogUtils.e(TAG, "handleAckMsg Exception ：" + e.getMessage());
                    NewAckMessage.Tripule tripule22 = new NewAckMessage.Tripule(j4, "", System.currentTimeMillis(), -1L, -1, str4, j5, uk, -1, -1, j, j2, str);
                    tripule22.setIsParseFailed(i2);
                    linkedList.add(tripule22);
                    j6 = j4;
                    j7 = j5;
                    z2 = z;
                    i3 = i + 1;
                    triggerId = j3;
                }
                i3 = i + 1;
                triggerId = j3;
            }
            sendNewAckToServer(context, triggerId, linkedList, z2);
        }
    }

    public static ChatMsg handleSysChatMsg(ChatMsg chatMsg) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, chatMsg)) == null) {
            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
            JSONObject jSONObject2 = new JSONObject();
            int notifyCmd = chatMsg.getNotifyCmd();
            if (notifyCmd != 0) {
                if (notifyCmd != 1) {
                    if (notifyCmd == 24 || notifyCmd == 26) {
                        chatMsg.setFromUser(jSONObject.optLong("from_uid"));
                    }
                    chatMsg.setMsgContentFromServer(jSONObject.toString());
                    return chatMsg;
                }
                chatMsg.setFromUser(jSONObject.getLong("from"));
            } else {
                long j = jSONObject.getLong("from");
                jSONObject2.put("text", jSONObject.getString("description"));
                chatMsg.setFromUser(j);
            }
            jSONObject = jSONObject2;
            chatMsg.setMsgContentFromServer(jSONObject.toString());
            return chatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    public static ChatMsg parseChatMsg(Context context, int i, int i2, int i3, int i4, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str})) == null) {
            ChatMsg chatMsg = null;
            try {
                if (isDuMsg(i2, i3, i4)) {
                    DuParser invokeParse = new DuParser(context, str, i).invokeParse();
                    if (!invokeParse.isMsgNull()) {
                        chatMsg = invokeParse.getMsg();
                    }
                } else {
                    chatMsg = ChatMsgFactory.getInstance().newChatMsg(context, i, i2, -1);
                    if (chatMsg != null) {
                        chatMsg.setMsgType(i2);
                        chatMsg.setMsgContentFromServer(str);
                    }
                }
            } catch (Exception unused) {
                LogUtils.e(TAG, "bc parseChatMsg exception");
            }
            return chatMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0161 A[Catch: JSONException -> 0x01b8, Exception -> 0x0293, TRY_LEAVE, TryCatch #2 {JSONException -> 0x01b8, blocks: (B:43:0x0156, B:45:0x0161), top: B:75:0x0156, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c9 A[Catch: JSONException -> 0x021c, Exception -> 0x0293, TRY_LEAVE, TryCatch #4 {JSONException -> 0x021c, blocks: (B:49:0x01be, B:51:0x01c9), top: B:79:0x01be, outer: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<ChatMsg> parseChatRoomMsg(Context context, List<ChatMsg> list) {
        InterceptResult invokeLL;
        String str;
        String str2;
        JSONObject jSONObject;
        boolean has;
        String optString;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, list)) == null) {
            String str3 = "at_data";
            String str4 = "data";
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            for (ChatMsg chatMsg : list) {
                try {
                    jSONObject = new JSONObject(new JSONObject(chatMsg.getJsonContent()).optString("text"));
                    has = jSONObject.has(str4);
                    if (has) {
                        optString = jSONObject.optString("type");
                    } else {
                        optString = jSONObject.optString("content_type");
                    }
                    parseInt = Integer.parseInt(optString);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(context, 4, parseInt, -1);
                    newChatMsg.setMsgType(parseInt);
                    newChatMsg.setContentExtra(chatMsg.getJsonContent());
                    newChatMsg.setChatRoomContentExt(jSONObject.optString("ext"));
                    newChatMsg.setSenderUid(Utility.transBDUK(jSONObject.optString("baidu_uk")));
                    if (has) {
                        newChatMsg.setNotifyCmd(parseInt);
                        newChatMsg.setMsgContent(jSONObject.optString(str4));
                    } else {
                        newChatMsg.setMsgContent(jSONObject.optString("content_body"));
                        newChatMsg.setNickName(jSONObject.optString("name"));
                        newChatMsg.setPortrait(jSONObject.optString("portrait"));
                    }
                    try {
                        if (jSONObject.has(str3)) {
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray optJSONArray = jSONObject.optJSONArray(str3);
                            if (optJSONArray != null) {
                                int i = 0;
                                while (i < optJSONArray.length()) {
                                    IChatRoomEnterListener.AtUserInfo atUserInfo = new IChatRoomEnterListener.AtUserInfo();
                                    str = str3;
                                    try {
                                        str2 = str4;
                                    } catch (Exception e2) {
                                        e = e2;
                                        str2 = str4;
                                        try {
                                            LogUtils.e(TAG, "parse AtUser exception", e);
                                            IChatRoomEnterListener.ReMsgInfo reMsgInfo = new IChatRoomEnterListener.ReMsgInfo();
                                            if (jSONObject.has("re_data")) {
                                            }
                                            IChatRoomEnterListener.TaskInfo taskInfo = new IChatRoomEnterListener.TaskInfo();
                                            if (jSONObject.has("task_info")) {
                                            }
                                            newChatMsg.setHasReaction(jSONObject.optInt("has_reaction", 0));
                                            newChatMsg.setCategory(chatMsg.getCategory());
                                            newChatMsg.setContacter(chatMsg.getContacter());
                                            newChatMsg.setMsgId(chatMsg.getMsgId());
                                            newChatMsg.setMsgKey(chatMsg.getMsgKey());
                                            newChatMsg.setSendMsgId(chatMsg.getSendMsgId());
                                            newChatMsg.setMsgTime(chatMsg.getMsgTime());
                                            newChatMsg.setFromUser(chatMsg.getFromUser());
                                            newChatMsg.setStatus(chatMsg.getStatus());
                                            newChatMsg.setLocalUrl(chatMsg.getLocalUrl());
                                            LogUtils.d(TAG, "ChatRoom newMsg :" + newChatMsg.toString() + ", \n before msg :" + chatMsg.toString());
                                            arrayList.add(newChatMsg);
                                        } catch (Exception e3) {
                                            e = e3;
                                            LogUtils.e(TAG, "ChatRoom parse fail ", e);
                                            str3 = str;
                                            str4 = str2;
                                        }
                                        str3 = str;
                                        str4 = str2;
                                    }
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(optJSONArray.get(i).toString());
                                        atUserInfo.atType = jSONObject2.optString("at_type");
                                        atUserInfo.atBdUk = jSONObject2.optString("at_baidu_uk");
                                        atUserInfo.atName = jSONObject2.optString("at_name");
                                        atUserInfo.atPortrait = jSONObject2.optString("at_portrait");
                                        atUserInfo.atVip = jSONObject2.optString("at_vip");
                                        atUserInfo.atCharacter = jSONObject2.optString("at_character");
                                        atUserInfo.atCharacterName = jSONObject2.optString("at_character_name");
                                        atUserInfo.atPosition = jSONObject2.optString(CriusAttrConstants.POSITION);
                                        arrayList2.add(atUserInfo);
                                        i++;
                                        str3 = str;
                                        str4 = str2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        LogUtils.e(TAG, "parse AtUser exception", e);
                                        IChatRoomEnterListener.ReMsgInfo reMsgInfo2 = new IChatRoomEnterListener.ReMsgInfo();
                                        if (jSONObject.has("re_data")) {
                                        }
                                        IChatRoomEnterListener.TaskInfo taskInfo2 = new IChatRoomEnterListener.TaskInfo();
                                        if (jSONObject.has("task_info")) {
                                        }
                                        newChatMsg.setHasReaction(jSONObject.optInt("has_reaction", 0));
                                        newChatMsg.setCategory(chatMsg.getCategory());
                                        newChatMsg.setContacter(chatMsg.getContacter());
                                        newChatMsg.setMsgId(chatMsg.getMsgId());
                                        newChatMsg.setMsgKey(chatMsg.getMsgKey());
                                        newChatMsg.setSendMsgId(chatMsg.getSendMsgId());
                                        newChatMsg.setMsgTime(chatMsg.getMsgTime());
                                        newChatMsg.setFromUser(chatMsg.getFromUser());
                                        newChatMsg.setStatus(chatMsg.getStatus());
                                        newChatMsg.setLocalUrl(chatMsg.getLocalUrl());
                                        LogUtils.d(TAG, "ChatRoom newMsg :" + newChatMsg.toString() + ", \n before msg :" + chatMsg.toString());
                                        arrayList.add(newChatMsg);
                                        str3 = str;
                                        str4 = str2;
                                    }
                                }
                                str = str3;
                                str2 = str4;
                                newChatMsg.setAtUserList(arrayList2);
                            } else {
                                str = str3;
                                str2 = str4;
                            }
                            LogUtils.d(TAG, "AtUser :" + arrayList2.toString());
                        } else {
                            str = str3;
                            str2 = str4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str = str3;
                    }
                    try {
                        IChatRoomEnterListener.ReMsgInfo reMsgInfo22 = new IChatRoomEnterListener.ReMsgInfo();
                        if (jSONObject.has("re_data")) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject.optString("re_data"));
                            reMsgInfo22.msgType = jSONObject3.optString("re_content_type");
                            reMsgInfo22.bdUk = jSONObject3.optString("re_baidu_uk");
                            reMsgInfo22.nickName = jSONObject3.optString("re_nickname");
                            reMsgInfo22.msgId = jSONObject3.optString("re_msg_id");
                            reMsgInfo22.msgKey = jSONObject3.optString("re_msg_key");
                            reMsgInfo22.ext = jSONObject3.optString("re_ext");
                            JSONObject jSONObject4 = new JSONObject(jSONObject3.optString("re_content_body"));
                            reMsgInfo22.content = jSONObject4.optString("text");
                            reMsgInfo22.url = jSONObject4.optString("url");
                            newChatMsg.setReMsgInfo(reMsgInfo22);
                        }
                    } catch (JSONException e6) {
                        LogUtils.e(TAG, "parse ReMsgInfo exception", e6);
                    }
                    try {
                        IChatRoomEnterListener.TaskInfo taskInfo22 = new IChatRoomEnterListener.TaskInfo();
                        if (jSONObject.has("task_info")) {
                            JSONObject jSONObject5 = new JSONObject(jSONObject.optString("task_info"));
                            taskInfo22.taskId = jSONObject5.optString("task_id");
                            taskInfo22.taskType = jSONObject5.optInt("task_type");
                            taskInfo22.taskState = jSONObject5.optInt("task_state");
                            taskInfo22.taskResult = jSONObject5.optInt("task_result");
                            taskInfo22.taskErrorMsg = jSONObject5.optString("task_error_msg");
                            taskInfo22.originMsgId = jSONObject5.optLong("origin_msg_id");
                            taskInfo22.originMsgKey = jSONObject5.optString("origin_msg_key");
                            taskInfo22.taskProgress = jSONObject5.optInt("task_progress");
                            newChatMsg.setTaskInfo(taskInfo22);
                        }
                    } catch (JSONException e7) {
                        LogUtils.e(TAG, "parse TaskInfo exception", e7);
                    }
                    newChatMsg.setHasReaction(jSONObject.optInt("has_reaction", 0));
                    newChatMsg.setCategory(chatMsg.getCategory());
                    newChatMsg.setContacter(chatMsg.getContacter());
                    newChatMsg.setMsgId(chatMsg.getMsgId());
                    newChatMsg.setMsgKey(chatMsg.getMsgKey());
                    newChatMsg.setSendMsgId(chatMsg.getSendMsgId());
                    newChatMsg.setMsgTime(chatMsg.getMsgTime());
                    newChatMsg.setFromUser(chatMsg.getFromUser());
                    newChatMsg.setStatus(chatMsg.getStatus());
                    newChatMsg.setLocalUrl(chatMsg.getLocalUrl());
                    LogUtils.d(TAG, "ChatRoom newMsg :" + newChatMsg.toString() + ", \n before msg :" + chatMsg.toString());
                    arrayList.add(newChatMsg);
                } catch (Exception e8) {
                    e = e8;
                    str = str3;
                    str2 = str4;
                    LogUtils.e(TAG, "ChatRoom parse fail ", e);
                    str3 = str;
                    str4 = str2;
                }
                str3 = str;
                str4 = str2;
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ArrayList<ChatMsg> parserMessage(Context context, JSONArray jSONArray, Type<Long> type, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, jSONArray, type, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return parserMessage(context, jSONArray, type, z, z2, -1L, -1L, "", 0);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.Long] */
    public static ArrayList<ChatMsg> parserMessage(Context context, JSONArray jSONArray, Type<Long> type, boolean z, boolean z2, long j, long j2, String str, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, jSONArray, type, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i)})) == null) {
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() > 0) {
                if (z2) {
                    TaskManager.getInstance(context).submitForNetWork(new Runnable(context, jSONArray, j, j2, str) { // from class: com.baidu.android.imsdk.internal.MessageParser.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ JSONArray val$array;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$eventList;
                        public final /* synthetic */ long val$notifyId;
                        public final /* synthetic */ long val$notifyMsgId;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, jSONArray, Long.valueOf(j), Long.valueOf(j2), str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$context = context;
                            this.val$array = jSONArray;
                            this.val$notifyMsgId = j;
                            this.val$notifyId = j2;
                            this.val$eventList = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                MessageParser.handleAckArray(this.val$context, this.val$array, this.val$notifyMsgId, this.val$notifyId, this.val$eventList);
                            }
                        }
                    });
                }
                try {
                    Type type2 = new Type();
                    type2.t = 0L;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        ChatMsg realParserMessage = realParserMessage(context, jSONArray.getJSONObject(i2), type2, z, z2);
                        if (type.t.longValue() < ((Long) type2.t).longValue()) {
                            type.t = type2.t;
                        }
                        if (realParserMessage != null) {
                            realParserMessage.setFetchTriggerReason(i);
                            if (realParserMessage.isSelf(context) && realParserMessage.getCategory() != 4) {
                                realParserMessage.setMsgReaded(1);
                                realParserMessage.setIsClicked(true);
                            }
                            realParserMessage.setStatus(0);
                            realParserMessage.setEventList(str);
                            realParserMessage.setNotifyId(j2);
                            arrayList.add(realParserMessage);
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "parserMessage:", e);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0294 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0295 A[Catch: Exception -> 0x048c, TryCatch #1 {Exception -> 0x048c, blocks: (B:5:0x001b, B:150:0x03b3, B:152:0x03b9, B:154:0x03d3, B:156:0x03e5, B:157:0x03ec, B:159:0x03f4, B:160:0x03fb, B:162:0x0403, B:166:0x0410, B:167:0x0413, B:169:0x0419, B:171:0x041f, B:173:0x0425, B:174:0x0428, B:176:0x042e, B:178:0x0433, B:180:0x043f, B:182:0x044e, B:184:0x045b, B:185:0x0462, B:187:0x046a, B:188:0x0473, B:181:0x0443, B:82:0x0262, B:103:0x0289, B:106:0x0295, B:108:0x02a5, B:110:0x02cb, B:134:0x0355, B:136:0x036a, B:138:0x0377, B:139:0x0380, B:141:0x0388, B:143:0x0393, B:144:0x0396, B:124:0x0329, B:126:0x0332, B:130:0x0347, B:81:0x025e, B:113:0x02d5, B:115:0x02ea, B:117:0x02fa, B:118:0x02ff, B:120:0x030c, B:121:0x030f), top: B:199:0x001b, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0345 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0347 A[Catch: Exception -> 0x048c, TryCatch #1 {Exception -> 0x048c, blocks: (B:5:0x001b, B:150:0x03b3, B:152:0x03b9, B:154:0x03d3, B:156:0x03e5, B:157:0x03ec, B:159:0x03f4, B:160:0x03fb, B:162:0x0403, B:166:0x0410, B:167:0x0413, B:169:0x0419, B:171:0x041f, B:173:0x0425, B:174:0x0428, B:176:0x042e, B:178:0x0433, B:180:0x043f, B:182:0x044e, B:184:0x045b, B:185:0x0462, B:187:0x046a, B:188:0x0473, B:181:0x0443, B:82:0x0262, B:103:0x0289, B:106:0x0295, B:108:0x02a5, B:110:0x02cb, B:134:0x0355, B:136:0x036a, B:138:0x0377, B:139:0x0380, B:141:0x0388, B:143:0x0393, B:144:0x0396, B:124:0x0329, B:126:0x0332, B:130:0x0347, B:81:0x025e, B:113:0x02d5, B:115:0x02ea, B:117:0x02fa, B:118:0x02ff, B:120:0x030c, B:121:0x030f), top: B:199:0x001b, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x036a A[Catch: Exception -> 0x048c, TryCatch #1 {Exception -> 0x048c, blocks: (B:5:0x001b, B:150:0x03b3, B:152:0x03b9, B:154:0x03d3, B:156:0x03e5, B:157:0x03ec, B:159:0x03f4, B:160:0x03fb, B:162:0x0403, B:166:0x0410, B:167:0x0413, B:169:0x0419, B:171:0x041f, B:173:0x0425, B:174:0x0428, B:176:0x042e, B:178:0x0433, B:180:0x043f, B:182:0x044e, B:184:0x045b, B:185:0x0462, B:187:0x046a, B:188:0x0473, B:181:0x0443, B:82:0x0262, B:103:0x0289, B:106:0x0295, B:108:0x02a5, B:110:0x02cb, B:134:0x0355, B:136:0x036a, B:138:0x0377, B:139:0x0380, B:141:0x0388, B:143:0x0393, B:144:0x0396, B:124:0x0329, B:126:0x0332, B:130:0x0347, B:81:0x025e, B:113:0x02d5, B:115:0x02ea, B:117:0x02fa, B:118:0x02ff, B:120:0x030c, B:121:0x030f), top: B:199:0x001b, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0393 A[Catch: Exception -> 0x048c, TryCatch #1 {Exception -> 0x048c, blocks: (B:5:0x001b, B:150:0x03b3, B:152:0x03b9, B:154:0x03d3, B:156:0x03e5, B:157:0x03ec, B:159:0x03f4, B:160:0x03fb, B:162:0x0403, B:166:0x0410, B:167:0x0413, B:169:0x0419, B:171:0x041f, B:173:0x0425, B:174:0x0428, B:176:0x042e, B:178:0x0433, B:180:0x043f, B:182:0x044e, B:184:0x045b, B:185:0x0462, B:187:0x046a, B:188:0x0473, B:181:0x0443, B:82:0x0262, B:103:0x0289, B:106:0x0295, B:108:0x02a5, B:110:0x02cb, B:134:0x0355, B:136:0x036a, B:138:0x0377, B:139:0x0380, B:141:0x0388, B:143:0x0393, B:144:0x0396, B:124:0x0329, B:126:0x0332, B:130:0x0347, B:81:0x025e, B:113:0x02d5, B:115:0x02ea, B:117:0x02fa, B:118:0x02ff, B:120:0x030c, B:121:0x030f), top: B:199:0x001b, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027a A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ChatMsg realParserMessage(Context context, JSONObject jSONObject, Type<Long> type, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        long optLong;
        long optLong2;
        long optLong3;
        long optLong4;
        String optString;
        int optInt;
        String optString2;
        String str;
        int i;
        boolean isDuMsg;
        boolean z3;
        long j;
        String str2;
        DuParser invokeParse;
        ChatMsg msg;
        boolean isJsonParseResult;
        boolean z4;
        ChatMsg chatMsg;
        String optString3;
        int i2;
        ?? r1;
        boolean z5;
        ChatMsg newChatMsg;
        boolean z6;
        ChatMsg newChatMsg2;
        boolean msgContentFromServer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, jSONObject, type, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str3 = TAG;
            try {
                optLong = jSONObject.optLong("msgid");
                optLong2 = jSONObject.optLong("from_user");
                optLong3 = jSONObject.optLong("create_time");
                optLong4 = jSONObject.optLong("contacter");
                optString = jSONObject.optString("content");
                optInt = jSONObject.optInt("category");
                type.t = Long.valueOf(optLong);
                optString2 = jSONObject.optString("tips");
            } catch (Exception e) {
                e = e;
            }
            try {
                if (optInt != 0) {
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt != 3) {
                                if (optInt != 4) {
                                    if (optInt != 6) {
                                        if (optInt != 9) {
                                            str = "";
                                            str3 = TAG;
                                            chatMsg = null;
                                            z4 = false;
                                        } else {
                                            int optInt2 = jSONObject.optInt("type");
                                            int optInt3 = jSONObject.optInt("is_deleted");
                                            ChatMsg newChatMsg3 = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt2, -1);
                                            if (newChatMsg3 == null) {
                                                return newChatMsg3;
                                            }
                                            newChatMsg3.setCategory(optInt);
                                            newChatMsg3.setContacter(optLong4);
                                            newChatMsg3.setFromUser(optLong2);
                                            newChatMsg3.setMsgType(optInt2);
                                            newChatMsg3.setChatType(58);
                                            newChatMsg3.setDialogueId(jSONObject.optLong("dialogue_id"));
                                            newChatMsg3.setContacterIsRead(jSONObject.optInt(TableDefine.BusiChatMsgColumns.COLUMN_CONTACTER_IS_READ));
                                            newChatMsg3.setTips(jSONObject.optString("tips"));
                                            newChatMsg3.setDialogueId(jSONObject.optLong("dialogue_id"));
                                            newChatMsg3.setContacterIsRead(jSONObject.optInt(TableDefine.BusiChatMsgColumns.COLUMN_CONTACTER_IS_READ));
                                            newChatMsg3.setSessionType(jSONObject.optInt("session_type", 0));
                                            newChatMsg3.setLogicDel(optInt3);
                                            z4 = newChatMsg3.setMsgContentFromServer(optString);
                                            chatMsg = newChatMsg3;
                                        }
                                    } else {
                                        int optInt4 = jSONObject.optInt("type");
                                        newChatMsg2 = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt4, -1);
                                        if (newChatMsg2 == null) {
                                            return newChatMsg2;
                                        }
                                        newChatMsg2.setCategory(optInt);
                                        newChatMsg2.setContacter(optLong4);
                                        newChatMsg2.setFromUser(optLong2);
                                        newChatMsg2.setMsgType(optInt4);
                                        msgContentFromServer = newChatMsg2.setMsgContentFromServer(optString);
                                    }
                                } else {
                                    int optInt5 = jSONObject.optInt("type");
                                    if (optInt5 == 81) {
                                        optInt5 = 0;
                                    }
                                    newChatMsg2 = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt5, -1);
                                    if (newChatMsg2 == null) {
                                        return newChatMsg2;
                                    }
                                    newChatMsg2.setCategory(optInt);
                                    newChatMsg2.setContacter(optLong4);
                                    newChatMsg2.setFromUser(optLong2);
                                    newChatMsg2.setMsgType(optInt5);
                                    msgContentFromServer = newChatMsg2.setMsgContentFromServer(optString);
                                    if (newChatMsg2 instanceof TextMsg) {
                                        ((TextMsg) newChatMsg2).setCastId(optLong4);
                                        if (ConversationStudioManImpl.getInstance(context).isReliable(optLong4)) {
                                            ((TextMsg) newChatMsg2).setCastId(optLong4);
                                            ((TextMsg) newChatMsg2).setPriority(jSONObject.optLong("prority"));
                                            newChatMsg2.setMsgContent(jSONObject.toString());
                                        }
                                    }
                                    LogUtils.d("IMFetchMsgByIdMsg parse ", msgContentFromServer + "");
                                }
                            } else {
                                int i3 = jSONObject.getInt("cmd");
                                newChatMsg2 = ChatMsgFactory.getInstance().newChatMsg(context, 3, -1, i3);
                                if (newChatMsg2 == null) {
                                    return newChatMsg2;
                                }
                                newChatMsg2.setCategory(optInt);
                                newChatMsg2.setContacter(optLong4);
                                newChatMsg2.setFromUser(optLong2);
                                newChatMsg2.setNotifyCmd(i3);
                                msgContentFromServer = newChatMsg2.setMsgContentFromServer(optString);
                            }
                            str = "";
                            str3 = TAG;
                            ChatMsg chatMsg2 = newChatMsg2;
                            z4 = msgContentFromServer;
                            chatMsg = chatMsg2;
                        } else {
                            int i4 = jSONObject.getInt("cmd");
                            ChatMsg newChatMsg4 = ChatMsgFactory.getInstance().newChatMsg(context, optInt, -1, i4);
                            if (newChatMsg4 == null) {
                                return newChatMsg4;
                            }
                            newChatMsg4.setCategory(optInt);
                            newChatMsg4.setContacter(optLong4);
                            newChatMsg4.setFromUser(optLong2);
                            boolean msgContentFromServer2 = newChatMsg4.setMsgContentFromServer(optString);
                            newChatMsg4.setNotifyCmd(i4);
                            chatMsg = handleSysChatMsg(newChatMsg4);
                            chatMsg.setMsgType(-1);
                            z4 = msgContentFromServer2;
                        }
                        str = "";
                    } else {
                        long optLong5 = jSONObject.optLong("group_id");
                        int optInt6 = jSONObject.optInt("type");
                        if (optInt6 == 80) {
                            DuParser invokeParse2 = new DuParser(context, optString, optInt).invokeParse();
                            if (invokeParse2.isMsgNull()) {
                                return null;
                            }
                            newChatMsg = invokeParse2.getMsg();
                            z6 = invokeParse2.isJsonParseResult();
                        } else {
                            newChatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt6, -1);
                            if (newChatMsg != null) {
                                z6 = newChatMsg.setMsgContentFromServer(optString);
                                newChatMsg.setMsgType(optInt6);
                            } else {
                                z6 = false;
                            }
                        }
                        if (newChatMsg == null) {
                            return newChatMsg;
                        }
                        newChatMsg.setCategory(optInt);
                        newChatMsg.setContacter(optLong5);
                        newChatMsg.setFromUser(optLong2);
                        if (!TextUtils.isEmpty(newChatMsg.getMsgContent())) {
                            JSONObject jSONObject2 = new JSONObject(newChatMsg.getMsgContent());
                            jSONObject2.put("tips", optString2);
                            newChatMsg.setMsgContent(jSONObject2.toString());
                        }
                        chatMsg = newChatMsg;
                        str = "";
                        z4 = z6;
                    }
                    str3 = TAG;
                } else {
                    int optInt7 = jSONObject.optInt("type");
                    long optLong6 = jSONObject.optLong("msg_expires", 0L);
                    int optInt8 = jSONObject.optInt("business_type");
                    try {
                        str = "";
                        try {
                            i = new JSONObject(optString).optInt("template_type", 0);
                            str3 = TAG;
                        } catch (JSONException e2) {
                            e = e2;
                            str3 = TAG;
                            LogUtils.e(str3, "parserMessage template_type:", e);
                            i = 0;
                            isDuMsg = isDuMsg(optInt7, optInt8, i);
                            if (i != 2) {
                                z3 = false;
                                if (!isDuMsg) {
                                }
                                j = optLong6;
                                str2 = "content";
                                invokeParse = new DuParser(context, optString, optInt).invokeParse();
                                if (!invokeParse.isMsgNull()) {
                                }
                            }
                            z3 = true;
                            if (!isDuMsg) {
                            }
                            j = optLong6;
                            str2 = "content";
                            invokeParse = new DuParser(context, optString, optInt).invokeParse();
                            if (!invokeParse.isMsgNull()) {
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str = "";
                    }
                    isDuMsg = isDuMsg(optInt7, optInt8, i);
                    if (i != 2 && i != 3 && i != 5 && i != 6) {
                        z3 = false;
                        if (!isDuMsg && !z3) {
                            if ((i != 1 || i == 4) && optInt7 == 80) {
                                optInt7 = 0;
                            }
                            msg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt7, -1);
                            if (msg != null) {
                                return msg;
                            }
                            msg.setMsgType(optInt7);
                            boolean msgContentFromServer3 = msg.setMsgContentFromServer(optString);
                            msg.setTemplateType(i);
                            if (msg.isDumiMessage()) {
                                msg.setChatType(100);
                                StringBuilder sb = new StringBuilder();
                                i2 = optInt7;
                                sb.append("setchattype as dumi ");
                                j = optLong6;
                                sb.append(msg.getMsgId());
                                LogUtils.d(str3, sb.toString());
                            } else {
                                i2 = optInt7;
                                j = optLong6;
                            }
                            msg.setChatType(0);
                            str2 = "content";
                            if (optInt8 == 11) {
                                try {
                                    JSONObject jSONObject3 = new JSONObject(jSONObject.optString(str2));
                                    String optString4 = jSONObject3.optString("ext");
                                    if (!TextUtils.isEmpty(optString4) && new JSONObject(optString4).optInt("sub_app_identity") == 20) {
                                        msg.setChatType(20);
                                    }
                                    String optString5 = jSONObject3.optString("text");
                                    if (!TextUtils.isEmpty(optString5)) {
                                        msg.setMsgContent(optString5);
                                    }
                                    LogUtils.w(str3, "parserMessage studioPa msg :" + msg.toString());
                                } catch (Exception e4) {
                                    LogUtils.e(str3, "IM_BUSINESS_TYPE_STUDIO_USE_PA Exception :", e4);
                                }
                            }
                            isJsonParseResult = msgContentFromServer3;
                            optInt7 = i2;
                            if (optInt8 == 10 && optInt7 == 0) {
                                optString3 = new JSONObject(jSONObject.optString(str2)).optString("ext");
                                if (!TextUtils.isEmpty(optString3)) {
                                    JSONObject jSONObject4 = new JSONObject(optString3);
                                    if (jSONObject4.has(IMConstants.MSG_CONTENT_EXT_ACTION)) {
                                        msg.setInterActiveAction(jSONObject4.optString(IMConstants.MSG_CONTENT_EXT_ACTION));
                                    }
                                    if (jSONObject4.has(IMConstants.MSG_CONTENT_EXT_SOURCE)) {
                                        msg.setInterActiveSource(jSONObject4.optInt(IMConstants.MSG_CONTENT_EXT_SOURCE));
                                    }
                                }
                            }
                            if (optInt8 > 0) {
                                msg.setBusinessType(optInt8);
                            }
                            msg.setCategory(optInt);
                            msg.setContacter(optLong4);
                            msg.setFromUser(optLong2);
                            msg.setExpiresTime(j);
                            msg.setTips(optString2);
                            z4 = isJsonParseResult;
                            chatMsg = msg;
                        }
                        j = optLong6;
                        str2 = "content";
                        invokeParse = new DuParser(context, optString, optInt).invokeParse();
                        if (!invokeParse.isMsgNull()) {
                            return null;
                        }
                        msg = invokeParse.getMsg();
                        isJsonParseResult = invokeParse.isJsonParseResult();
                        if (optInt8 == 10) {
                            optString3 = new JSONObject(jSONObject.optString(str2)).optString("ext");
                            if (!TextUtils.isEmpty(optString3)) {
                            }
                        }
                        if (optInt8 > 0) {
                        }
                        msg.setCategory(optInt);
                        msg.setContacter(optLong4);
                        msg.setFromUser(optLong2);
                        msg.setExpiresTime(j);
                        msg.setTips(optString2);
                        z4 = isJsonParseResult;
                        chatMsg = msg;
                    }
                    z3 = true;
                    if (!isDuMsg) {
                        if (i != 1) {
                        }
                        optInt7 = 0;
                        msg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt7, -1);
                        if (msg != null) {
                        }
                    }
                    j = optLong6;
                    str2 = "content";
                    invokeParse = new DuParser(context, optString, optInt).invokeParse();
                    if (!invokeParse.isMsgNull()) {
                    }
                }
                if (!z4 && z) {
                    return null;
                }
                if (chatMsg != null) {
                    if (chatMsg.shouldAbandonMsg(context)) {
                        LogUtils.d(str3, "msg will abandon for shouldAbandonMsg=true, msg=" + chatMsg.toString());
                        return null;
                    }
                    chatMsg.setMsgId(optLong);
                    chatMsg.setMsgTime(optLong3);
                    if (jSONObject.has("contacter_uk")) {
                        chatMsg.setContacterUk(jSONObject.optLong("contacter_uk"));
                    }
                    if (jSONObject.has("appid")) {
                        chatMsg.setAppId(jSONObject.optLong("appid"));
                    }
                    if (jSONObject.has("is_read")) {
                        int optInt9 = jSONObject.optInt("is_read");
                        chatMsg.setMsgReaded(optInt9);
                        if (optInt9 == 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        chatMsg.setIsClicked(z5);
                    }
                    if (chatMsg.isSelf(context)) {
                        r1 = 1;
                        chatMsg.setMsgReaded(1);
                    } else {
                        r1 = 1;
                    }
                    if (MsgUtility.isNotice(chatMsg)) {
                        chatMsg.setMsgReaded(r1);
                    }
                    if (chatMsg.isMsgRead()) {
                        chatMsg.setIsClicked(r1);
                    }
                    if (optInt == 0 && (17592186044416L & optLong4) != 0) {
                        chatMsg.setPaid(optLong4);
                    } else {
                        chatMsg.setPaid(jSONObject.optLong(Constants.EXTRA_PAUID_TYPE, -1L));
                    }
                    JSONObject jSONObject5 = new JSONObject(optString);
                    if (jSONObject5.has("send_type")) {
                        chatMsg.setSendType(jSONObject5.optInt("send_type"));
                    }
                    if (jSONObject5.has("send_scene")) {
                        chatMsg.setSendScene(jSONObject5.optInt("send_scene"));
                    }
                    String str4 = str;
                    chatMsg.setMsgKey(jSONObject.optString("msg_key", str4));
                    chatMsg.setDeviceFlag(2);
                    chatMsg.setOriginPa(jSONObject.optString("origin_pa", str4));
                }
                return chatMsg;
            } catch (Exception e5) {
                e = e5;
                str3 = TAG;
                LogUtils.e(str3, "parserMessage:", e);
                return null;
            }
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public static void sendNewAckToServer(Context context, long j, List<NewAckMessage.Tripule> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, Long.valueOf(j), list, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            List<List<NewAckMessage.Tripule>> splitList = Utils.splitList(list, 20);
            if (splitList != null && splitList.size() > 0) {
                for (List<NewAckMessage.Tripule> list2 : splitList) {
                    NewAckMessage newAckMessage = new NewAckMessage(context, AccountManager.getUK(context), j, z);
                    newAckMessage.addTriples(list2);
                    BLCPRequest bLCPRequest = new BLCPRequest();
                    bLCPRequest.a = 2L;
                    bLCPRequest.b = 95L;
                    bLCPRequest.c = newAckMessage.getBody().getBytes();
                    bLCPRequest.d = System.nanoTime();
                    j40.d(bLCPRequest, new n40(newAckMessage, context, list, z) { // from class: com.baidu.android.imsdk.internal.MessageParser.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ boolean val$isReliable;
                        public final /* synthetic */ List val$lt;
                        public final /* synthetic */ NewAckMessage val$msg;

                        @Override // com.baidu.tieba.p40
                        public void onResponse(int i, String str, long j2, long j3, long j4, byte[] bArr) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), bArr}) == null) {
                            }
                        }

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {newAckMessage, context, list, Boolean.valueOf(z)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$msg = newAckMessage;
                            this.val$context = context;
                            this.val$lt = list;
                            this.val$isReliable = z;
                        }

                        @Override // com.baidu.tieba.n40
                        public void onResponse(int i, String str, @NonNull n40.a aVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, aVar) == null) {
                                LogUtils.d(MessageParser.TAG, "MessageParser Ack Response err :" + i + ", methodId :" + aVar.a + ", data :" + new String(aVar.c));
                                if (i == 0) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(new String(aVar.c));
                                        int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                                        String optString = jSONObject.optString("msg", "");
                                        if (aVar.a == 95) {
                                            this.val$msg.handleMessageResult(this.val$context, jSONObject, optInt, optString);
                                            if (optInt != 0 && optInt != 4001 && optInt != 4003) {
                                                LogUtils.d(MessageParser.TAG, "ack failed，retry~~");
                                                AckHandlerThread.getInstance(this.val$context).getAckHandler().sendMessageDelayed(AckMessage.getSendMessage(1, this.val$msg), 1000L);
                                            }
                                            if (optInt != 0 && ((NewAckMessage.Tripule) this.val$lt.get(0)).getCategory() == 4 && !LoginManager.getInstance(this.val$context).isIMLogined()) {
                                                IMAckRequest iMAckRequest = new IMAckRequest(this.val$context, this.val$isReliable, this.val$msg);
                                                HttpHelper.executor(this.val$context, iMAckRequest, iMAckRequest);
                                            }
                                        }
                                    } catch (JSONException e) {
                                        LogUtils.d(MessageParser.TAG, "handle sendNewAckToServer response：" + e);
                                    }
                                }
                            }
                        }
                    });
                }
                return;
            }
            LogUtils.e(TAG, "sendNewAckToServer splitList wrong!!!");
        }
    }
}
