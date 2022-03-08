package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
/* loaded from: classes3.dex */
public class IMGetTokenByCuidRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGenTokenByCuidRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAccountType;
    public long mAppid;
    public String mCuid;
    public int mDeviceType;
    public String mKey;

    public IMGetTokenByCuidRequest(Context context, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAccountType = 6;
        this.mDeviceType = 2;
        this.mContext = context;
        this.mAppid = j2;
        this.mCuid = str;
        this.mKey = str2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new HashMap() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(Utility.isPeakTime() ? "https://pim.baidu.com/".replace("https://", "http://") : "https://pim.baidu.com/");
                sb.append("rest/3.0/im/generate_token");
                return sb.toString();
            } else if (readIntData != 1) {
                if (readIntData != 2) {
                    if (readIntData != 3) {
                        return null;
                    }
                    return "http://180.97.36.95:8080/rest/3.0/im/generate_token";
                }
                return "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/rest/3.0/im/generate_token";
            } else {
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rest/3.0/im/generate_token";
            }
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
            sb.append("appid=" + this.mAppid);
            sb.append("&account_type=" + this.mAccountType);
            sb.append("&cuid=" + this.mCuid);
            sb.append("&device_type=" + this.mDeviceType);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            sb.append("&timestamp=" + currentTimeMillis);
            if (!TextUtils.isEmpty(Utility.getCuidAccessToken(this.mContext))) {
                sb.append("&token=" + Utility.getCuidAccessToken(this.mContext));
            }
            sb.append("&sign=");
            sb.append(getMd5(this.mAppid + "" + this.mAccountType + "" + this.mCuid + "" + this.mDeviceType + "" + currentTimeMillis));
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            String str = new String(bArr);
            LogUtils.e(TAG, "errorCode = " + i2 + ", result = " + str);
            AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i2, str, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, str2);
            String str3 = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean has = jSONObject.has("error_code");
                str = Constants.ERROR_MSG_SUCCESS;
                if (has) {
                    i3 = jSONObject.getInt("error_code");
                    if (jSONObject.has(GameCodeGetResponseMsg.PARAM_ERROR_MSG)) {
                        str = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    }
                    if (i3 == 0) {
                        str3 = jSONObject.getString("token");
                        if (!TextUtils.isEmpty(str3)) {
                            Utility.writeCuidAccessToken(this.mContext, str3);
                        }
                    }
                } else {
                    i3 = 0;
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, e2.getMessage(), e2);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i3, str, str3);
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
