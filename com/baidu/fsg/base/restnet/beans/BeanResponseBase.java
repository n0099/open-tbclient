package com.baidu.fsg.base.restnet.beans;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BeanResponseBase implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String csign;
    public JSONObject result;
    public int retCode;
    public String retMsg;
    public String sign;

    public BeanResponseBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.retCode = 0;
        this.retMsg = null;
        this.result = null;
        this.csign = null;
        this.sign = null;
    }

    public String getRealResponseContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.result;
            return jSONObject != null ? StringUtils.replaceBom(jSONObject.toString()) : "";
        }
        return (String) invokeV.objValue;
    }

    public int getServerReturnValue(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            int i2 = this.retCode;
            if (i2 != 0) {
                return i2;
            }
            if (i2 == 0) {
                if (this.result != null || cls == null || JsonUtils.DataType.isString(cls)) {
                    return this.retCode;
                }
                return -3;
            }
            return -3;
        }
        return invokeL.intValue;
    }
}
