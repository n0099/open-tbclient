package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
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
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMGetUidByUkRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mKey;
    public long[] mUks;

    public IMGetUidByUkRequest(Context context, long[] jArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jArr, str};
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
        this.mKey = str;
        this.mUks = jArr;
    }

    private String contactWithComma(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jArr)) == null) {
            StringBuilder sb = new StringBuilder("" + jArr[0]);
            for (int i2 = 1; i2 < jArr.length; i2++) {
                sb.append(",");
                sb.append(jArr[i2]);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 15000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", "BDUSS=" + AccountManagerImpl.getInstance(this.mContext).getToken());
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rest/2.0/im/zhidahao";
            }
            return "https://pim.baidu.com/rest/2.0/im/zhidahao";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 15000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder("method=get_baidu_id");
            sb.append("&uks=" + contactWithComma(this.mUks));
            sb.append("&hsc=1");
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mUks, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        TreeMap treeMap;
        String str;
        int i3;
        int i4;
        String string;
        long[] jArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d("IMGetUidByUkRequest", str2);
            TreeMap treeMap2 = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    i4 = jSONObject2.getInt("error_code");
                    if (i4 == 0) {
                        TreeMap treeMap3 = new TreeMap();
                        try {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("info");
                            for (long j : this.mUks) {
                                treeMap3.put(Long.valueOf(j), Long.valueOf(jSONObject3.optLong("" + j, -1L)));
                            }
                            treeMap2 = treeMap3;
                        } catch (JSONException e2) {
                            e = e2;
                            treeMap2 = treeMap3;
                            LogUtils.e("IMGetUidByUkRequest", e.getMessage(), e);
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            treeMap = treeMap2;
                            i3 = 1010;
                            AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, i3, str, this.mUks, treeMap);
                        }
                    }
                    string = Constants.ERROR_MSG_SUCCESS;
                } else {
                    i4 = jSONObject.getInt("error_code");
                    string = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                }
                str = string;
                i3 = i4;
                treeMap = treeMap2;
            } catch (JSONException e3) {
                e = e3;
            }
            AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, i3, str, this.mUks, treeMap);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public Pair<Integer, String> transErrorCode(int i2, byte[] bArr, Throwable th) {
        InterceptResult invokeILL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, bArr, th)) == null) {
            if (th != null) {
                i2 = 1012;
                str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
            } else if (i2 == 1005) {
                str = new String(bArr);
            } else {
                str = "http response is error! response code:" + i2;
                i2 = 1011;
            }
            return new Pair<>(Integer.valueOf(i2), str);
        }
        return (Pair) invokeILL.objValue;
    }
}
