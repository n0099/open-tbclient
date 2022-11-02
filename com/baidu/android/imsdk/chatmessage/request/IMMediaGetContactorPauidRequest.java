package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.IMediaGetContactorPauidListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMediaGetContactorPauidRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaGetContactorPauidRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mKey;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public IMMediaGetContactorPauidRequest(Context context, long j, int i, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, str2};
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
        this.mContacter = j;
        this.mKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }

    public IMMediaGetContactorPauidRequest(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str};
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
        this.mContacter = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
            IMediaGetContactorPauidListener iMediaGetContactorPauidListener = (IMediaGetContactorPauidListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(((Integer) transErrorCode.first).intValue(), -1L, -1, (String) transErrorCode.second);
            }
        }
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
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/b_get_contacter_pauid";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (AccountManager.isCuidLogin(this.mContext)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                putCommonParams(jSONObject);
                if (this.mContacter > 0) {
                    jSONObject.put("contacter", Utility.transBDUID(String.valueOf(this.mContacter)));
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
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.e(TAG, "getRequestParameter Exception ", e);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        long j;
        String str;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "onSuccess resultContent = " + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int optInt = jSONObject.optInt("error_code", 0);
                String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                long optLong = jSONObject.optLong("pa_uid", -1L);
                i3 = jSONObject.optInt("is_buser", -1);
                str = optString;
                j = optLong;
                i2 = optInt;
            } catch (JSONException e) {
                LogUtils.e(TAG, "IMMediaSetSessionReadRequest JSONException", e);
                j = -1;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i2 = 1010;
                i3 = -1;
            }
            IMediaGetContactorPauidListener iMediaGetContactorPauidListener = (IMediaGetContactorPauidListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(i2, j, i3, str);
            }
        }
    }
}
