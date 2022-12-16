package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMClueGetEncryptedPhoneRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMClueGetEncryptedPhoneRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String mBusinessExt;
    public String mBusinessSource;
    public String mKey;
    public long mUk;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1675701608, "Lcom/baidu/android/imsdk/chatmessage/request/IMClueGetEncryptedPhoneRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1675701608, "Lcom/baidu/android/imsdk/chatmessage/request/IMClueGetEncryptedPhoneRequest;");
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMClueGetEncryptedPhoneRequest(Context context, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBusinessExt = "";
        this.mBusinessSource = "";
        this.mContext = context;
        this.mUk = j;
        this.mBusinessExt = str;
        this.mBusinessSource = str2;
        this.mKey = str3;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String hostUrl = BaseHttpRequest.getHostUrl(this.mContext);
            if (hostUrl == null) {
                return null;
            }
            return hostUrl + "rest/3.0/im/get_encrypted_phone";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long appid = AccountManager.getAppid(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return ("method=unbind&appid=" + appid + "&uk=" + this.mUk + "&app_version=" + BIMManager.getAppVersion(this.mContext) + "&sdk_version=" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext) + "&cuid=" + Utility.getIMDeviceId(this.mContext) + "&business_source=" + this.mBusinessSource + "&business_ext=" + this.mBusinessExt + "&timestamp=" + currentTimeMillis + "&sign=" + getMd5("" + currentTimeMillis + bduss + appid)).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            String str = new String(bArr);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, str);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str = new String(bArr);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                if (i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        ((BIMValueCallBack) removeListener).onResult(jSONObject.optInt("error_code", -1), jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG), str);
                        return;
                    } catch (Exception e) {
                        LogUtils.e(TAG, "JSONException", e);
                        ((BIMValueCallBack) removeListener).onResult(1010, Constants.ERROR_MSG_JSON_PARSE_EXCEPTION, str);
                        return;
                    }
                }
                ((BIMValueCallBack) removeListener).onResult(i, Constants.ERROR_MSG_SUCCESS, str);
            }
        }
    }
}
