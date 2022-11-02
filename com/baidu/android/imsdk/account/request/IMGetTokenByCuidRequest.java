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
/* loaded from: classes.dex */
public class IMGetTokenByCuidRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGenTokenByCuidRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAccountType;
    public long mAppid;
    public String mCuid;
    public int mDeviceType;
    public String mKey;

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

    public IMGetTokenByCuidRequest(Context context, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAccountType = 6;
        this.mDeviceType = 2;
        this.mContext = context;
        this.mAppid = j;
        this.mCuid = str;
        this.mKey = str2;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new HashMap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData != 3) {
                            return null;
                        }
                        return "http://180.97.36.95:8080/rest/3.0/im/generate_token";
                    }
                    return "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/rest/3.0/im/generate_token";
                }
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rest/3.0/im/generate_token";
            }
            StringBuilder sb = new StringBuilder();
            String str = "https://pim.baidu.com/";
            if (Utility.isPeakTime()) {
                str = "https://pim.baidu.com/".replace("https://", "http://");
            }
            sb.append(str);
            sb.append("rest/3.0/im/generate_token");
            return sb.toString();
        }
        return (String) invokeV.objValue;
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
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            String str = new String(bArr);
            LogUtils.e(TAG, "errorCode = " + i + ", result = " + str);
            AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i, str, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, str2);
            String str3 = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean has = jSONObject.has("error_code");
                str = Constants.ERROR_MSG_SUCCESS;
                if (has) {
                    i2 = jSONObject.getInt("error_code");
                    if (jSONObject.has(GameCodeGetResponseMsg.PARAM_ERROR_MSG)) {
                        str = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    }
                    if (i2 == 0) {
                        str3 = jSONObject.getString("token");
                        if (!TextUtils.isEmpty(str3)) {
                            Utility.writeCuidAccessToken(this.mContext, str3);
                        }
                    }
                } else {
                    i2 = 0;
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, e.getMessage(), e);
                i2 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i2, str, str3);
        }
    }
}
