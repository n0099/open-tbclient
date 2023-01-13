package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.MediaChatMessageManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DuzhanUpMsgCreator;
import com.baidu.android.imsdk.chatmessage.request.params.RequestParamManager;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.u70;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSendMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSendMsg";
    public static IRequestMsgConstructor mRequestMsgConstructor;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatMsg chatMsg;
    public Context mContext;
    public boolean mFromMedia;
    public SendMsgParam sendMsgParam;
    public MessageUbc ubcData;

    /* renamed from: com.baidu.android.imsdk.chatmessage.request.IMSendMsg$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public interface IRequestMsgConstructor {
        IMSendMsg constructSendMsg(Context context, boolean z, Intent intent);

        JSONObject getRequestParamJsonObj(Context context, IMSendMsg iMSendMsg);
    }

    /* loaded from: classes.dex */
    public static class MediaRequestMsgConstructor implements IRequestMsgConstructor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MediaRequestMsgConstructor() {
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

        public /* synthetic */ MediaRequestMsgConstructor(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.baidu.android.imsdk.chatmessage.request.IMSendMsg.IRequestMsgConstructor
        public IMSendMsg constructSendMsg(Context context, boolean z, Intent intent) {
            InterceptResult invokeCommon;
            SendMsgParam sendMsgParam;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), intent})) == null) {
                if (!intent.hasExtra(Constants.EXTRA_PARAM) || (sendMsgParam = (SendMsgParam) intent.getSerializableExtra(Constants.EXTRA_PARAM)) == null || sendMsgParam.getChatMsg() == null) {
                    return null;
                }
                return new IMSendMsg(context, sendMsgParam, (AnonymousClass1) null);
            }
            return (IMSendMsg) invokeCommon.objValue;
        }

        @Override // com.baidu.android.imsdk.chatmessage.request.IMSendMsg.IRequestMsgConstructor
        public JSONObject getRequestParamJsonObj(Context context, IMSendMsg iMSendMsg) {
            InterceptResult invokeLL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iMSendMsg)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    ChatMsg chatMsg = iMSendMsg.getChatMsg();
                    SendMsgParam sendMsgParam = iMSendMsg.sendMsgParam;
                    jSONObject.put("method", 55);
                    jSONObject.put("appid", AccountManager.getAppid(context));
                    jSONObject.put("app_version", Utility.getAppVersionName(context));
                    jSONObject.put("uk", AccountManagerImpl.getInstance(context).getUK());
                    long bduid = AccountManagerImpl.getInstance(context).getBduid();
                    jSONObject.put("pass_uk", Utility.transBDUID(String.valueOf(bduid)));
                    jSONObject.put("bduid", bduid);
                    jSONObject.put(Constants.EXTRA_PAUID_TYPE, MediaSessionManager.getInstance(context).getMeidaPaid());
                    if (AccountManagerImpl.getInstance(context).getMediaRole()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("user_type", i);
                    jSONObject.put(RequestContants.EXTRA_TO_USER, sendMsgParam.getToUser());
                    jSONObject.put("contacter_pass_uk", sendMsgParam.getContacterPassUk());
                    jSONObject.put("contacter_uk", sendMsgParam.getContacterUk());
                    jSONObject.put("contacter_bduid", sendMsgParam.getContacterBduid());
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_USER_TYPE, sendMsgParam.getContacterUserType());
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_PA_UID, sendMsgParam.getContacterPaUid());
                    jSONObject.put("origin_id", Utility.getTriggerId(context));
                    jSONObject.put("msg_expires", chatMsg.getExpiresTime());
                    if (RequestParamManager.getMediaByUserType(sendMsgParam.getContacterUserType())) {
                        jSONObject.put("content", chatMsg.getMsgContent());
                    } else {
                        jSONObject.put("content", chatMsg.getSendMsgContent());
                    }
                    jSONObject.put("type", chatMsg.getMsgType());
                    jSONObject.put("msg_key", chatMsg.getMsgKey());
                    jSONObject.put("category", chatMsg.getCategory());
                    jSONObject.put("client_identifier", AccountManagerImpl.getInstance(context).getExtraSafeParams());
                    jSONObject.put("dialogue_id", chatMsg.getDialogueId());
                    if (AccountManagerImpl.getInstance(context).getLoginType() == 11) {
                        jSONObject.put("client_id", AccountManagerImpl.getInstance(context).getXDClientId());
                    }
                    jSONObject.put("business_type", chatMsg.getBusinessType());
                    jSONObject.put("msg_control", chatMsg.getAdvisoryMsgControl());
                    jSONObject.put("ext", chatMsg.getExt());
                } catch (JSONException e) {
                    LogUtils.e(IMSendMsg.TAG, "Exception ", e);
                }
                LogUtils.d(IMSendMsg.TAG, "media params:" + jSONObject.toString());
                return jSONObject;
            }
            return (JSONObject) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class OriginRequestMsgConstructor implements IRequestMsgConstructor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OriginRequestMsgConstructor() {
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

        public /* synthetic */ OriginRequestMsgConstructor(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.baidu.android.imsdk.chatmessage.request.IMSendMsg.IRequestMsgConstructor
        public IMSendMsg constructSendMsg(Context context, boolean z, Intent intent) {
            InterceptResult invokeCommon;
            ChatMsg chatMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), intent})) == null) {
                if (!intent.hasExtra(Constants.EXTRA_SEND_MSG) || (chatMsg = (ChatMsg) intent.getParcelableExtra(Constants.EXTRA_SEND_MSG)) == null) {
                    return null;
                }
                return new IMSendMsg(context, chatMsg, (AnonymousClass1) null);
            }
            return (IMSendMsg) invokeCommon.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x0234 A[Catch: JSONException -> 0x024f, TryCatch #1 {JSONException -> 0x024f, blocks: (B:21:0x007e, B:23:0x0085, B:25:0x00a2, B:27:0x00ad, B:29:0x00b3, B:30:0x00bc, B:32:0x00c2, B:33:0x00cc, B:35:0x00d3, B:37:0x00d9, B:38:0x00e2, B:40:0x00e8, B:41:0x00f2, B:71:0x01f9, B:73:0x0234, B:74:0x0241, B:42:0x00f9, B:44:0x0101, B:46:0x0159, B:47:0x015e, B:48:0x0169, B:52:0x017e, B:56:0x018e, B:53:0x0182, B:55:0x018a, B:58:0x019c, B:60:0x01af, B:61:0x01b7, B:63:0x01bd, B:64:0x01cb, B:66:0x01df, B:67:0x01e4, B:69:0x01eb, B:70:0x01ee), top: B:88:0x0071 }] */
        @Override // com.baidu.android.imsdk.chatmessage.request.IMSendMsg.IRequestMsgConstructor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public JSONObject getRequestParamJsonObj(Context context, IMSendMsg iMSendMsg) {
            InterceptResult invokeLL;
            String str;
            ChatMsg chatMsg;
            int msgType;
            String sendMsgContent;
            long contacter;
            String msgKey;
            List<Long> atUsers;
            List<Long> castids;
            int loginType;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iMSendMsg)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    chatMsg = iMSendMsg.getChatMsg();
                    int chatType = chatMsg.getChatType();
                    msgType = chatMsg.getMsgType();
                    if (chatType == 7 || chatType == 16 || chatType == 25 || msgType == 18) {
                        DuzhanUpMsgCreator.reCreateChatMsg(chatType, chatMsg);
                        msgType = 80;
                    }
                    sendMsgContent = chatMsg.getSendMsgContent();
                    contacter = chatMsg.getContacter();
                    msgKey = chatMsg.getMsgKey();
                    atUsers = chatMsg.getAtUsers();
                    castids = chatMsg.getCastids();
                    LogUtils.d(IMSendMsg.TAG, "IMSendMsg " + contacter + " " + msgType + GlideException.IndentedAppendable.INDENT + sendMsgContent);
                } catch (JSONException e) {
                    e = e;
                    str = IMSendMsg.TAG;
                }
                try {
                } catch (JSONException e2) {
                    e = e2;
                    LogUtils.e(str, "Exception ", e);
                    return jSONObject;
                }
                if (chatMsg.getCategory() != 0) {
                    int category = chatMsg.getCategory();
                    str = IMSendMsg.TAG;
                    if (category != 7) {
                        if (chatMsg.getCategory() == 4) {
                            jSONObject.put("method", Constants.METHOD_IM_SEND_MCAST_MSG);
                            jSONObject.put("mcast_id", contacter);
                            jSONObject.put("role", Utility.getLoginRole(context));
                            if (!TextUtils.isEmpty(Utility.getAccessToken(context))) {
                                jSONObject.put("token", Utility.getAccessToken(context));
                            }
                            if (atUsers != null && atUsers.size() > 0) {
                                JSONArray jSONArray = new JSONArray();
                                for (Long l : atUsers) {
                                    jSONArray.put(l);
                                }
                                jSONObject.put("at_uks", jSONArray);
                            }
                            if (castids != null && castids.size() > 0) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (Long l2 : castids) {
                                    jSONArray2.put(l2);
                                }
                                jSONObject.put(Constants.EXTRA_CAST_IDS, jSONArray2);
                            }
                        } else if (chatMsg.getCategory() == 9) {
                            jSONObject.put("method", 55);
                            jSONObject.put("business_type", chatMsg.getBusinessType());
                            jSONObject.put("dialogue_id", chatMsg.getDialogueId());
                            jSONObject.put("category", chatMsg.getCategory());
                            jSONObject.put(RequestContants.EXTRA_TO_USER, contacter);
                            jSONObject.put("to_bduid", chatMsg.getToBduid());
                            jSONObject.put("bduid", chatMsg.getSenderUid());
                            jSONObject.put("session_type", chatMsg.getSessionType());
                            jSONObject.put("description", chatMsg.getAdvisoryDescription());
                            jSONObject.put("msg_control", chatMsg.getAdvisoryMsgControl());
                            if (TextUtils.isEmpty(chatMsg.getSource())) {
                                chatMsg.setSource("Na");
                            }
                            jSONObject.put("client_business_source", chatMsg.getSource());
                        } else {
                            jSONObject.put("method", 65);
                            jSONObject.put("group_id", contacter);
                            if (sendMsgContent.contains("stargroupext")) {
                                jSONObject.put("group_type", 2);
                            } else if (chatMsg.getChatType() == 57) {
                                jSONObject.put("group_type", 3);
                            }
                            jSONObject.put("client_identifier", AccountManagerImpl.getInstance(context).getExtraSafeParams());
                        }
                        jSONObject.put("appid", iMSendMsg.mAppid);
                        jSONObject.put("uk", iMSendMsg.mUk);
                        jSONObject.put("origin_id", Utility.getTriggerId(context));
                        jSONObject.put("type", msgType);
                        jSONObject.put("content", sendMsgContent);
                        jSONObject.put("msg_key", msgKey);
                        loginType = AccountManagerImpl.getInstance(context).getLoginType();
                        jSONObject.put("account_type", loginType);
                        if (loginType == 11) {
                            jSONObject.put("client_id", AccountManagerImpl.getInstance(context).getXDClientId());
                        }
                        jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(context));
                        return jSONObject;
                    }
                } else {
                    str = IMSendMsg.TAG;
                }
                jSONObject.put("method", 55);
                Map<String, Object> otherParameters = IMConfigInternal.getInstance().getIMConfig(context).getOtherParameters(context, chatMsg);
                if (otherParameters != null) {
                    for (String str2 : otherParameters.keySet()) {
                        jSONObject.put(str2, otherParameters.get(str2));
                    }
                }
                jSONObject.put(RequestContants.EXTRA_TO_USER, contacter);
                if ((chatMsg.getContacter() & Constants.PAFLAG) != 0) {
                    jSONObject.put(Constants.EXTRA_PAUID_TYPE, contacter);
                }
                if (chatMsg.getCategory() == 7) {
                    jSONObject.put("category", 7);
                }
                jSONObject.put("client_identifier", AccountManagerImpl.getInstance(context).getExtraSafeParams());
                jSONObject.put("appid", iMSendMsg.mAppid);
                jSONObject.put("uk", iMSendMsg.mUk);
                jSONObject.put("origin_id", Utility.getTriggerId(context));
                jSONObject.put("type", msgType);
                jSONObject.put("content", sendMsgContent);
                jSONObject.put("msg_key", msgKey);
                loginType = AccountManagerImpl.getInstance(context).getLoginType();
                jSONObject.put("account_type", loginType);
                if (loginType == 11) {
                }
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(context));
                return jSONObject;
            }
            return (JSONObject) invokeLL.objValue;
        }
    }

    public IMSendMsg(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.chatMsg = chatMsg;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(55);
        this.ubcData = new MessageUbc(this.mContext, chatMsg);
    }

    public /* synthetic */ IMSendMsg(Context context, ChatMsg chatMsg, AnonymousClass1 anonymousClass1) {
        this(context, chatMsg);
    }

    public IMSendMsg(Context context, SendMsgParam sendMsgParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sendMsgParam};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.sendMsgParam = sendMsgParam;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(55);
        this.ubcData = new MessageUbc(this.mContext, sendMsgParam.getChatMsg());
    }

    public /* synthetic */ IMSendMsg(Context context, SendMsgParam sendMsgParam, AnonymousClass1 anonymousClass1) {
        this(context, sendMsgParam);
    }

    public static IMSendMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        IRequestMsgConstructor originRequestMsgConstructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, intent)) == null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_FROM_MEDIA, false);
            if (booleanExtra) {
                originRequestMsgConstructor = new MediaRequestMsgConstructor(null);
            } else {
                originRequestMsgConstructor = new OriginRequestMsgConstructor(null);
            }
            mRequestMsgConstructor = originRequestMsgConstructor;
            IMSendMsg constructSendMsg = originRequestMsgConstructor.constructSendMsg(context, booleanExtra, intent);
            if (constructSendMsg != null) {
                constructSendMsg.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                constructSendMsg.mFromMedia = booleanExtra;
            }
            return constructSendMsg;
        }
        return (IMSendMsg) invokeLL.objValue;
    }

    private void setEventList(JSONObject jSONObject, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, jSONObject, chatMsg) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < 3; i++) {
                    String str = "CClickSendBegin";
                    long sendMsgTime = chatMsg.getSendMsgTime();
                    try {
                        JSONObject jSONObject2 = new JSONObject(chatMsg.getMsgContent());
                        if (jSONObject2.has(Constants.EXTRA_BUSINESS_MSG_EXT)) {
                            sendMsgTime = new JSONObject(jSONObject2.optString(Constants.EXTRA_BUSINESS_MSG_EXT)).optLong("sn_send_begin");
                        }
                    } catch (JSONException unused) {
                        LogUtils.e(TAG, "msg_ext exception");
                    }
                    if (i == 1) {
                        str = "CSendBegin";
                        sendMsgTime = chatMsg.getSdkSendMsgTime();
                    } else if (i == 2) {
                        str = "CIMSendBegin";
                        sendMsgTime = System.currentTimeMillis();
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("event", str);
                    jSONObject3.put("timestamp_ms", sendMsgTime);
                    jSONArray.put(jSONObject3);
                }
                jSONObject.put("event_list", jSONArray);
                chatMsg.setEventList(jSONObject.optString("event_list"));
            } catch (JSONException e) {
                LogUtils.e(TAG, "event_list ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject requestParamJsonObj = mRequestMsgConstructor.getRequestParamJsonObj(this.mContext, this);
            if (requestParamJsonObj != null && requestParamJsonObj.length() > 0) {
                setEventList(requestParamJsonObj, getChatMsg());
                this.mBody = requestParamJsonObj.toString();
            }
            LogUtils.d(TAG, "send body :" + this.mBody);
        }
    }

    public ChatMsg getChatMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SendMsgParam sendMsgParam = this.sendMsgParam;
            if (sendMsgParam != null) {
                return sendMsgParam.getChatMsg();
            }
            return this.chatMsg;
        }
        return (ChatMsg) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0123  */
    @Override // com.baidu.android.imsdk.request.Message
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Exception exc;
        int i2;
        long j;
        int i3;
        int i4;
        int i5;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, i, str) == null) {
            LogUtils.d(TAG, "handleMessageResult errorCode:" + i + ";strMsg:" + str);
            String str3 = "";
            long msgId = getChatMsg().getMsgId();
            int i6 = -1;
            boolean z = false;
            try {
                z = jSONObject.has("msgid");
                if (z) {
                    try {
                        msgId = jSONObject.getLong("msgid");
                        getChatMsg().setMsgId(msgId);
                    } catch (Exception e) {
                        e = e;
                        j = -1;
                        exc = e;
                        i2 = -1;
                        LogUtils.e(TAG, "handle IMSendMsg exception :", exc);
                        i3 = i6;
                        i4 = i2;
                        if (i != 0) {
                        }
                        i5 = i;
                        str2 = str;
                        super.handleMessageResult(context, jSONObject, i5, str2);
                        LogUtils.d(TAG, "errorCode:" + i5 + "  strMsg" + str2);
                        getChatMsg().setTipsCode(i5);
                        getChatMsg().setTips(str3);
                        getChatMsg().setRemainNum(i3);
                        getChatMsg().setSendNum(i4);
                        if (j != -1) {
                        }
                        if (this.mFromMedia) {
                        }
                        ChatMsg chatMsg = getChatMsg();
                        MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
                        debugInfo.methodId = getType();
                        debugInfo.eventList = chatMsg.getEventList();
                        debugInfo.msgId = msgId;
                        debugInfo.clientSource = chatMsg.getSource();
                        this.ubcData.setDebugInfo(debugInfo);
                        u70.d().f(this.ubcData.generateUBCData(String.valueOf(i5), str2), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                    }
                }
                j = jSONObject.optLong("time", -1L);
            } catch (Exception e2) {
                exc = e2;
                i2 = -1;
                j = -1;
            }
            try {
                String optString = jSONObject.optString("tips_new");
                if (TextUtils.isEmpty(optString)) {
                    if (jSONObject.optBoolean("display_tips")) {
                        str3 = jSONObject.optString("tips");
                    }
                } else {
                    str3 = optString;
                }
                i3 = jSONObject.optInt("remain_msg_num", -1);
                try {
                    i4 = jSONObject.optInt("send_msg_num", -1);
                } catch (Exception e3) {
                    exc = e3;
                    i6 = i3;
                    i2 = -1;
                    LogUtils.e(TAG, "handle IMSendMsg exception :", exc);
                    i3 = i6;
                    i4 = i2;
                    if (i != 0) {
                    }
                    i5 = i;
                    str2 = str;
                    super.handleMessageResult(context, jSONObject, i5, str2);
                    LogUtils.d(TAG, "errorCode:" + i5 + "  strMsg" + str2);
                    getChatMsg().setTipsCode(i5);
                    getChatMsg().setTips(str3);
                    getChatMsg().setRemainNum(i3);
                    getChatMsg().setSendNum(i4);
                    if (j != -1) {
                    }
                    if (this.mFromMedia) {
                    }
                    ChatMsg chatMsg2 = getChatMsg();
                    MessageUbc.DebugInfo debugInfo2 = new MessageUbc.DebugInfo();
                    debugInfo2.methodId = getType();
                    debugInfo2.eventList = chatMsg2.getEventList();
                    debugInfo2.msgId = msgId;
                    debugInfo2.clientSource = chatMsg2.getSource();
                    this.ubcData.setDebugInfo(debugInfo2);
                    u70.d().f(this.ubcData.generateUBCData(String.valueOf(i5), str2), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                }
                try {
                    LogUtils.d(TAG, "handleMessageResult :" + jSONObject.toString());
                } catch (Exception e4) {
                    exc = e4;
                    i2 = i4;
                    i6 = i3;
                    LogUtils.e(TAG, "handle IMSendMsg exception :", exc);
                    i3 = i6;
                    i4 = i2;
                    if (i != 0) {
                    }
                    i5 = i;
                    str2 = str;
                    super.handleMessageResult(context, jSONObject, i5, str2);
                    LogUtils.d(TAG, "errorCode:" + i5 + "  strMsg" + str2);
                    getChatMsg().setTipsCode(i5);
                    getChatMsg().setTips(str3);
                    getChatMsg().setRemainNum(i3);
                    getChatMsg().setSendNum(i4);
                    if (j != -1) {
                    }
                    if (this.mFromMedia) {
                    }
                    ChatMsg chatMsg22 = getChatMsg();
                    MessageUbc.DebugInfo debugInfo22 = new MessageUbc.DebugInfo();
                    debugInfo22.methodId = getType();
                    debugInfo22.eventList = chatMsg22.getEventList();
                    debugInfo22.msgId = msgId;
                    debugInfo22.clientSource = chatMsg22.getSource();
                    this.ubcData.setDebugInfo(debugInfo22);
                    u70.d().f(this.ubcData.generateUBCData(String.valueOf(i5), str2), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                }
            } catch (Exception e5) {
                e = e5;
                exc = e;
                i2 = -1;
                LogUtils.e(TAG, "handle IMSendMsg exception :", exc);
                i3 = i6;
                i4 = i2;
                if (i != 0) {
                }
                i5 = i;
                str2 = str;
                super.handleMessageResult(context, jSONObject, i5, str2);
                LogUtils.d(TAG, "errorCode:" + i5 + "  strMsg" + str2);
                getChatMsg().setTipsCode(i5);
                getChatMsg().setTips(str3);
                getChatMsg().setRemainNum(i3);
                getChatMsg().setSendNum(i4);
                if (j != -1) {
                }
                if (this.mFromMedia) {
                }
                ChatMsg chatMsg222 = getChatMsg();
                MessageUbc.DebugInfo debugInfo222 = new MessageUbc.DebugInfo();
                debugInfo222.methodId = getType();
                debugInfo222.eventList = chatMsg222.getEventList();
                debugInfo222.msgId = msgId;
                debugInfo222.clientSource = chatMsg222.getSource();
                this.ubcData.setDebugInfo(debugInfo222);
                u70.d().f(this.ubcData.generateUBCData(String.valueOf(i5), str2), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
            }
            if (i != 0 && !z) {
                i5 = 1015;
                str2 = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
            } else {
                i5 = i;
                str2 = str;
            }
            super.handleMessageResult(context, jSONObject, i5, str2);
            LogUtils.d(TAG, "errorCode:" + i5 + "  strMsg" + str2);
            getChatMsg().setTipsCode(i5);
            getChatMsg().setTips(str3);
            getChatMsg().setRemainNum(i3);
            getChatMsg().setSendNum(i4);
            if (j != -1) {
                getChatMsg().setMsgTime(j);
            }
            if (this.mFromMedia) {
                SendMsgResponse sendMsgResponse = new SendMsgResponse();
                sendMsgResponse.msg = getChatMsg();
                sendMsgResponse.listenerKey = getListenerKey();
                MediaChatMessageManager.getInstance(this.mContext).onSendMessageResult(i5, str2, sendMsgResponse);
            } else {
                ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(i5, getChatMsg(), j, getListenerKey());
            }
            ChatMsg chatMsg2222 = getChatMsg();
            MessageUbc.DebugInfo debugInfo2222 = new MessageUbc.DebugInfo();
            debugInfo2222.methodId = getType();
            debugInfo2222.eventList = chatMsg2222.getEventList();
            debugInfo2222.msgId = msgId;
            debugInfo2222.clientSource = chatMsg2222.getSource();
            this.ubcData.setDebugInfo(debugInfo2222);
            u70.d().f(this.ubcData.generateUBCData(String.valueOf(i5), str2), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
        }
    }
}
