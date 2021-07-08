package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ABTestUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GetFPResponse.Exp[] exps;

    public ABTestUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public JSONObject getABTestStatistics(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exp_id", str);
                jSONObject.put("exp_version", getABTestVersion(str));
                jSONObject.put("exp_name", str2);
                jSONObject.put("exp_value", getABTestValueString(str, str2, str3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public String getABTestValueString(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        GetFPResponse.Exp[] expArr;
        GetFPResponse.ExpContent[] expContentArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (this.exps != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                for (GetFPResponse.Exp exp : this.exps) {
                    if (exp != null && str.equals(exp.exp_id) && "1".equals(exp.is_enable) && (expContentArr = exp.exp_contents) != null) {
                        for (int i2 = 0; i2 < expContentArr.length; i2++) {
                            if (str2.equals(expContentArr[i2].exp_name)) {
                                return expContentArr[i2].exp_value;
                            }
                        }
                        continue;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
    }

    public String getABTestVersion(String str) {
        InterceptResult invokeL;
        GetFPResponse.Exp[] expArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.exps == null || TextUtils.isEmpty(str)) {
                return "";
            }
            for (GetFPResponse.Exp exp : this.exps) {
                if (exp != null && str.equals(exp.exp_id)) {
                    return exp.exp_version;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public ABTestUtils(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String exps = BdWalletUtils.getExps(context);
        if (TextUtils.isEmpty(exps)) {
            return;
        }
        try {
            this.exps = (GetFPResponse.Exp[]) JsonUtils.fromJson(exps, GetFPResponse.Exp[].class);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
