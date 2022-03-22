package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMSendMsgRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSendMsgRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String key;
    public ChatMsg msg;

    public IMSendMsgRequest(Context context, ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg, str};
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
        this.msg = chatMsg;
        this.key = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            if (!TextUtils.isEmpty(bduss)) {
                hashMap.put("Cookie", "BDUSS=" + bduss);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            String str = "https://pim.baidu.com/";
            if (readIntData != 0) {
                if (readIntData == 1) {
                    str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
                } else if (readIntData == 2) {
                    str = Constants.URL_HTTP_QA;
                } else if (readIntData == 3) {
                    str = Constants.URL_HTTP_BOX;
                }
            }
            boolean isStudioHostSendMsg = Utility.isStudioHostSendMsg(this.mContext);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("imsapi/1.0/send_mcast_msg/");
            sb.append(isStudioHostSendMsg ? "liveshowhost" : "liveshowuser");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("appid=");
            sb.append(Utility.readAppId(this.mContext));
            sb.append("&sdk_version=");
            sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            sb.append("&app_version=");
            sb.append(Utility.getAppVersionName(this.mContext));
            sb.append("&device_type=android");
            sb.append("&cuid=");
            sb.append(Utility.getDeviceId(this.mContext));
            sb.append("&mcast_id=");
            sb.append(this.msg.getContacter());
            sb.append("&content=");
            sb.append(this.msg.getMsgContent());
            sb.append("&msg_key=");
            sb.append(this.msg.getMsgKey());
            sb.append("&msg_type=");
            sb.append(this.msg.getMsgType());
            sb.append("&timestamp=");
            sb.append(System.currentTimeMillis() / 1000);
            String[] split = sb.toString().split("&");
            Arrays.sort(split);
            String str = "";
            for (String str2 : split) {
                str = str + str2;
            }
            LogUtils.d(TAG, "smd5: " + str);
            sb.append("&sign=");
            sb.append(getMd5(str));
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode.first);
            ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(((Integer) transErrorCode.first).intValue(), this.msg, -1L, this.key);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "onSuccess :" + str);
            try {
                i2 = new JSONObject(str).getInt("error_code");
            } catch (Exception e2) {
                LogUtils.e(TAG, "JSONException", e2);
                i2 = 1010;
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(i2, this.msg, System.currentTimeMillis(), this.key);
        }
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
}
