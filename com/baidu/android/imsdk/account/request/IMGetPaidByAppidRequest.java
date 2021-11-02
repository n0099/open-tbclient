package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
/* loaded from: classes6.dex */
public class IMGetPaidByAppidRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public String mBduss;
    public String mKey;

    public IMGetPaidByAppidRequest(Context context, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str2;
        this.mAppid = j;
        this.mBduss = str;
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
            hashMap.put("Cookie", "BDUSS=" + this.mBduss);
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
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData != 3) {
                            return null;
                        }
                        return "http://180.97.36.95:8080/rest/2.0/im/zhidahao";
                    }
                    return "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/rest/2.0/im/zhidahao";
                }
                return "https://rd-im-server.bcc-szth.baidu.com:8444/rest/2.0/im/zhidahao";
            }
            return "https://pim.baidu.com/rest/2.0/im/zhidahao";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("method=get_pa_by_appid");
            sb.append("&hsc=1");
            sb.append("&appid=" + this.mAppid);
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            AccountManagerImpl.getInstance(this.mContext).onSetZhidaAppidResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mAppid, -1L);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        long j;
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d("IMGetPaidByAppidRequest", str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    i4 = jSONObject2.getInt("error_code");
                    r1 = i4 == 0 ? jSONObject2.getLong("pa_uid") : -1L;
                    string = Constants.ERROR_MSG_SUCCESS;
                } else {
                    i4 = jSONObject.getInt("error_code");
                    string = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                }
                str = string;
                i3 = i4;
                j = r1;
            } catch (JSONException e2) {
                LogUtils.e("IMGetPaidByAppidRequest", e2.getMessage(), e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                j = -1;
                i3 = 1010;
            }
            AccountManagerImpl.getInstance(this.mContext).onSetZhidaAppidResult(this.mKey, i3, str, this.mAppid, j);
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
