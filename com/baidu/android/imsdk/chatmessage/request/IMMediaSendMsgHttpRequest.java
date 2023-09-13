package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.n70;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public IMMediaSendMsgHttpRequest(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, chatMsg, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
        this.mUbc = new MessageUbc(context, chatMsg);
    }

    public IMMediaSendMsgHttpRequest(Context context, long j, ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), chatMsg, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str;
        this.mUbc = new MessageUbc(context, chatMsg);
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

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
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
                if (this.mSendMsg.getCategory() != 4 && this.mSendMsg.getCategory() != 9) {
                    jSONObject.put("client_identifier", AccountManagerImpl.getInstance(this.mContext).getExtraSafeParams());
                }
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtils.d(TAG, "BC> param=" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            n70.d().f(this.mUbc.generateUBCData(String.valueOf(transErrorCode.first), (String) transErrorCode.second), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, ((Integer) transErrorCode.first).intValue(), this.mSendMsg);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i + ", result=" + str);
            if (TextUtils.isEmpty(this.mListenerKey)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (i == 200) {
                    i = jSONObject.optInt("error_code", -1);
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
            } catch (Exception e) {
                e.printStackTrace();
                i = 1010;
            }
            n70.d().f(this.mUbc.generateUBCData(String.valueOf(i), "success"), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, i, this.mSendMsg);
        }
    }
}
