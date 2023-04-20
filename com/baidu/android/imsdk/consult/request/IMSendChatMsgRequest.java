package com.baidu.android.imsdk.consult.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DuzhanUpMsgCreator;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSendChatMsgRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSendChatMsgRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public ChatMsg mChatMsg;
    public ISendMessageListener mListener;
    public int mMsgType;
    public MessageUbc mUbc;

    private int getToUserType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i, i2)) == null) {
            if (i == 9) {
                return 0;
            }
            if (i == 1) {
                return 2;
            }
            return (i != 0 || i2 == 1) ? 0 : 1;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMSendChatMsgRequest(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg, iSendMessageListener};
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
        this.mChatMsg = chatMsg;
        if (chatMsg != null) {
            this.mMsgType = chatMsg.getMsgType();
        }
        this.mListener = iSendMessageListener;
        this.mUbc = new MessageUbc(context, chatMsg);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            this.mChatMsg.setStatus(2);
            MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
            debugInfo.clientSource = IMSendChatMsgRequest.class.getSimpleName() + "_onFailure";
            debugInfo.msgId = this.mChatMsg.getMsgId();
            MessageUbc.uploadUbc(this.mContext, i, UBCConstants.SEND_FAIL_RECORD_UBC, debugInfo, this.mChatMsg);
            ISendMessageListener iSendMessageListener = this.mListener;
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(((Integer) transErrorCode.first).intValue(), this.mChatMsg);
            }
        }
    }

    private String getMsgContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mChatMsg == null) {
                return null;
            }
            if (!AccountManager.getMediaRole(this.mContext) && this.mChatMsg.getChatType() == 7) {
                DuzhanUpMsgCreator.reCreateChatMsg(this.mChatMsg.getChatType(), this.mChatMsg);
                this.mMsgType = 80;
                return this.mChatMsg.getSendMsgContent();
            }
            this.mMsgType = this.mChatMsg.getMsgType();
            String sendMsgContent = this.mChatMsg.getSendMsgContent();
            if (AccountManager.getMediaRole(this.mContext)) {
                if (this.mChatMsg.getChatType() == 7 || this.mChatMsg.getChatType() == 0) {
                    return this.mChatMsg.getMsgContent();
                }
                return sendMsgContent;
            }
            return sendMsgContent;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            hashMap.put("Cookie", "BDUSS=" + bduss);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (BaseHttpRequest.getHostUrl(this.mContext) == null) {
                return null;
            }
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/send_msg_client";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
                if (AccountManager.isCuidLogin(this.mContext)) {
                    jSONObject.put("token", Utility.getAccessToken(this.mContext));
                }
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("host_device_type", 2);
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, this.mChatMsg.getPaid());
                jSONObject.put(RequestContants.EXTRA_TO_USER, this.mChatMsg.getContacter());
                if (AccountManagerImpl.getInstance(this.mContext).getMediaRole()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("user_type", i);
                jSONObject.put("category", this.mChatMsg.getCategory());
                if (this.mChatMsg.getCategory() == 9) {
                    jSONObject.put("business_type", this.mChatMsg.getBusinessType());
                    jSONObject.put("dialogue_id", this.mChatMsg.getDialogueId());
                }
                jSONObject.put(Constants.EXTRA_TO_USER_TYPE, getToUserType(this.mChatMsg.getCategory(), this.mChatMsg.getBusinessType()));
                jSONObject.put("content", getMsgContent());
                jSONObject.put("msg_type", this.mMsgType);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("msg_key", this.mChatMsg.getMsgKey());
                if (this.mChatMsg.getCategory() == 9) {
                    if (TextUtils.isEmpty(this.mChatMsg.getSource())) {
                        this.mChatMsg.setSource("Na");
                    }
                    jSONObject.put("client_business_source", this.mChatMsg.getSource());
                    jSONObject.put("msg_control", this.mChatMsg.getAdvisoryMsgControl());
                }
                jSONObject.put("sign", generateSign(jSONObject));
                LogUtils.d(TAG, "send body :" + jSONObject);
            } catch (JSONException e) {
                LogUtils.e(TAG, "getRequestParameter Exception ", e);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        ISendMessageListener iSendMessageListener;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "onSuccess result = " + str);
            long j = -1;
            try {
                jSONObject = new JSONObject(str);
                i2 = jSONObject.optInt("error_code");
            } catch (Exception e) {
                e = e;
                i2 = i;
            }
            try {
                j = jSONObject.optLong("msgid", -1L);
            } catch (Exception e2) {
                e = e2;
                LogUtils.e(TAG, "onSuccess Exception ", e);
                if (j > 0) {
                }
                if (i2 != 0) {
                }
                iSendMessageListener = this.mListener;
                if (iSendMessageListener == null) {
                }
            }
            if (j > 0) {
                this.mChatMsg.setMsgId(j);
            }
            if (i2 != 0) {
                this.mChatMsg.setStatus(0);
            } else {
                this.mChatMsg.setStatus(2);
                MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
                debugInfo.clientSource = IMSendChatMsgRequest.class.getSimpleName() + "_onSuccess";
                debugInfo.msgId = this.mChatMsg.getMsgId();
                MessageUbc.uploadUbc(this.mContext, i, UBCConstants.SEND_FAIL_RECORD_UBC, debugInfo, this.mChatMsg);
            }
            iSendMessageListener = this.mListener;
            if (iSendMessageListener == null) {
                iSendMessageListener.onSendMessageResult(i2, this.mChatMsg);
            }
        }
    }
}
