package com.baidu.android.imsdk.consult.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUpdateCollectSessionTagRequest extends IMConsultBaseRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMUpdateCollectSessionTagRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBusinessType;
    public final int mCategory;
    public final int mCollectAction;
    public final long mContacterImuk;
    public final BIMValueCallBack<Void> mListener;
    public final int mSessionType;

    @Override // com.baidu.android.imsdk.consult.request.IMConsultBaseRequest
    public String getRequestUrlPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "rest/3.0/im/update_collect_session_tag" : (String) invokeV.objValue;
    }

    public IMUpdateCollectSessionTagRequest(Context context, int i, long j, int i2, int i3, BIMValueCallBack<Void> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), bIMValueCallBack};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCategory = 9;
        this.mContext = context;
        this.mBusinessType = i;
        this.mContacterImuk = j;
        this.mSessionType = i2;
        this.mCollectAction = i3;
        this.mListener = bIMValueCallBack;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("contacter_uk", this.mContacterImuk);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("category", 9);
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("session_type", this.mSessionType);
                jSONObject.put("collect_action", this.mCollectAction);
                jSONObject.put(HttpConstants.DEVICE_TYPE, "6");
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("sign", generateSign(jSONObject));
                LogUtils.d(TAG, "getRequestParameter :" + jSONObject);
            } catch (JSONException e) {
                LogUtils.e(TAG, "getRequestParameter JSONException:", e);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            BIMValueCallBack<Void> bIMValueCallBack = this.mListener;
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "FXF  json is " + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMUpdateCollectSessionTagRequest JSONException", e);
                i2 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i2 == 0) {
                BusinessMessageDBManager.getInstance(this.mContext).updateSessionCollectStatus(this.mBusinessType, this.mContacterImuk, this.mSessionType, this.mCollectAction);
            }
            BIMValueCallBack<Void> bIMValueCallBack = this.mListener;
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(i2, str, null);
            }
        }
    }
}
