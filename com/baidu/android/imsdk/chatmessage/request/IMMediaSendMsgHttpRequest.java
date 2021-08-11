package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import c.a.s.a.a;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMMediaSendMsgHttpRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaSendMsgHttpRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContactor;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mContent;
    public String mListenerKey;
    public String mMsgKey;
    public int mMsgType;
    public ChatMsg mSendMsg;
    public MessageUbc mUbc;

    public IMMediaSendMsgHttpRequest(Context context, long j2, ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), chatMsg, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j2;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str;
        this.mUbc = new MessageUbc(context, chatMsg, UBCConstants.BCSEND_UBCID);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getHostUrl() + "rest/3.0/im/send_msg";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                putCommonParams(jSONObject);
                if (this.mContactor > 0) {
                    LogUtils.d(TAG, "BC> before transBDUID mContactor=" + this.mContactor);
                    jSONObject.put("contacter", Utility.transBDUID(this.mContactor + ""));
                }
                if (this.mContactorType >= 0) {
                    jSONObject.put("contacter_type", this.mContactorType);
                }
                if (this.mContactorPauid > 0) {
                    jSONObject.put("contacter_pa_uid", this.mContactorPauid);
                }
                if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                    jSONObject.put("contacter_third_id", this.mContactorThirdid);
                }
                int msgType = this.mSendMsg.getMsgType();
                this.mMsgType = msgType;
                jSONObject.put("type", msgType);
                String msgContent = this.mSendMsg.getMsgContent();
                this.mContent = msgContent;
                jSONObject.put("content", msgContent);
                String msgKey = this.mSendMsg.getMsgKey();
                this.mMsgKey = msgKey;
                if (TextUtils.isEmpty(msgKey)) {
                    this.mSendMsg.createMsgKey(this.mContext);
                    this.mMsgKey = this.mSendMsg.getMsgKey();
                }
                jSONObject.put("msg_key", this.mMsgKey);
                LogUtils.d(TAG, "BC> before genSign param=" + jSONObject);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LogUtils.d(TAG, "BC> param=" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            a.d().f(this.mUbc.generateUBCData(String.valueOf(transErrorCode.first), (String) transErrorCode.second), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, ((Integer) transErrorCode.first).intValue(), this.mSendMsg);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i2 + ", result=" + str);
            if (TextUtils.isEmpty(this.mListenerKey)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (i2 == 200) {
                    i2 = jSONObject.optInt("error_code", -1);
                    long optLong = jSONObject.optLong("msgid", -1L);
                    long optLong2 = jSONObject.optLong("msg_time", -1L);
                    if (optLong > 0) {
                        this.mSendMsg.setMsgId(optLong);
                    }
                    if (optLong2 > 0) {
                        this.mSendMsg.setMsgTime(optLong2);
                    }
                }
                this.mSendMsg.setMediaRoleMsg(true);
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = 1010;
            }
            a.d().f(this.mUbc.generateUBCData(String.valueOf(i2), "success"), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, i2, this.mSendMsg);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaSendMsgHttpRequest(Context context, long j2, int i2, long j3, String str, ChatMsg chatMsg, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, chatMsg, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j2;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str2;
        this.mContactorType = i2;
        this.mContactorPauid = j3;
        this.mContactorThirdid = str;
        this.mUbc = new MessageUbc(context, chatMsg, UBCConstants.BCSEND_UBCID);
    }
}
