package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ISetMsgSettingSwitchListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSetMsgSettingSwitchRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSetMsgSettingSwitchRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public ISetMsgSettingSwitchListener mListener;
    public int mStatus;
    public int mSwitchCategory;

    public IMSetMsgSettingSwitchRequest(Context context, int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), iSetMsgSettingSwitchListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mSwitchCategory = i;
        this.mStatus = i2;
        this.mListener = iSetMsgSettingSwitchListener;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
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
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                replace = readIntData != 1 ? readIntData != 2 ? readIntData != 3 ? null : Constants.URL_HTTP_BOX : Constants.URL_HTTP_QA : "http://rd-im-server.bcc-szth.baidu.com:8080/";
            } else {
                replace = Utility.isPeakTime() ? "https://pim.baidu.com/".replace("https://", "http://") : "https://pim.baidu.com/";
            }
            if (TextUtils.isEmpty(replace)) {
                return replace;
            }
            return replace + "rest/3.0/im/set_user_setting";
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
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long uk = AccountManager.getUK(this.mContext);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("uk", uk);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
                jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
                if (this.mSwitchCategory == 1) {
                    jSONObject.put("push_privacy", this.mStatus);
                } else if (this.mSwitchCategory == 0) {
                    jSONObject.put("block_stranger", this.mStatus);
                }
                LogUtils.d(TAG, "IMSetMsgSettingSwitchRequest getRequestParameter :" + jSONObject.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener = this.mListener;
            if (iSetMsgSettingSwitchListener != null) {
                iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.e(TAG, "IMSetMsgSettingSwitchRequest onSuccess :" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
            } catch (JSONException e) {
                LogUtils.e(TAG, "JSONException", e);
                i2 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener = this.mListener;
            if (iSetMsgSettingSwitchListener != null) {
                iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(i2, str);
            }
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
