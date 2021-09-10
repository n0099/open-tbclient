package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.sys.a;
import com.baidu.android.imsdk.chatmessage.IMediaContactorSettingListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMMediaGetContactorSettingRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaGetContactorSettingRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mKey;
    public int mSetting;

    public IMMediaGetContactorSettingRequest(Context context, long j2, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j2;
        this.mSetting = i2;
        this.mKey = str;
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
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/b_get_contacter_setting";
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
                jSONObject.put(a.f36039j, this.mSetting);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e2) {
                LogUtils.e(TAG, "getRequestParameter Exception ", e2);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
            IMediaContactorSettingListener iMediaContactorSettingListener = (IMediaContactorSettingListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, -1);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "onSuccess resultContent = " + str2);
            int i4 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i3 = jSONObject.optInt("error_code", 0);
                str = jSONObject.optString("error_msg");
                i4 = jSONObject.optInt("status", -1);
            } catch (JSONException e2) {
                LogUtils.e(TAG, "IMMediaGetContactorSettingRequest JSONException", e2);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMediaContactorSettingListener iMediaContactorSettingListener = (IMediaContactorSettingListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(i3, str, i4);
            }
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaGetContactorSettingRequest(Context context, long j2, int i2, long j3, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j2;
        this.mSetting = i3;
        this.mKey = str2;
        this.mContactorType = i2;
        this.mContactorPauid = j3;
        this.mContactorThirdid = str;
    }
}
