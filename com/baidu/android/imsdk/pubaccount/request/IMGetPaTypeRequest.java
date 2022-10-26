package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetPaTypeRequest extends PaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mKey;
    public long mPaId;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    public IMGetPaTypeRequest(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j)};
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
        this.mPaId = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String hostUrl = getHostUrl();
            if (hostUrl == null) {
                return null;
            }
            return hostUrl + "rest/2.0/im/zhidahao";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (AccountManager.isCuidLogin(this.mContext)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ("method=get_pa_type&pa_uid=" + this.mPaId + "&bduss=" + AccountManager.getUid(this.mContext)).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, bArr, th) == null) {
            LogUtils.d(RetrieveReportRequest.APP_NAME, "IMGetPaTypeRequest " + this.mPaId + GlideException.IndentedAppendable.INDENT + i + " " + bArr);
            Pair transErrorCode = transErrorCode(i, bArr, th);
            PaManagerImpl.getInstance(this.mContext).onGetPaTypeResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mPaId, -1);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        int i3;
        int i4;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) {
            LogUtils.d(RetrieveReportRequest.APP_NAME, "IMGetPaTypeRequest " + this.mPaId + GlideException.IndentedAppendable.INDENT + i + " " + bArr);
            String str2 = new String(bArr);
            LogUtils.d(RetrieveReportRequest.APP_NAME, "IMGetPaTypeRequest " + this.mPaId + GlideException.IndentedAppendable.INDENT + i + " " + str2);
            int i5 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    i4 = jSONObject2.getInt("error_code");
                    i5 = jSONObject2.optInt("type");
                    optString = Constants.ERROR_MSG_SUCCESS;
                } else {
                    i4 = jSONObject.getInt("error_code");
                    optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                }
                i3 = i5;
                str = optString;
                i2 = i4;
            } catch (JSONException e) {
                LogUtils.e("IMQueryZhidaSubscribedStateRequest", "JSONException", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i2 = 1010;
                i3 = -1;
            }
            PaManagerImpl.getInstance(this.mContext).onGetPaTypeResult(this.mKey, i2, str, this.mPaId, i3);
        }
    }
}
