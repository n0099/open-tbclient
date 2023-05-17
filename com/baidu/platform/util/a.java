package com.baidu.platform.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements ParamBuilder<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.a == null) {
                this.a = new LinkedHashMap();
            }
            this.a.put(str, str2);
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.a;
            if (map != null && !map.isEmpty()) {
                String str = new String();
                int i = 0;
                for (String str2 : this.a.keySet()) {
                    String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.a.get(str2));
                    if (i == 0) {
                        str = str + str2 + "=" + encodeUrlParamsValue;
                    } else {
                        str = str + "&" + str2 + "=" + encodeUrlParamsValue;
                    }
                    i++;
                }
                return str;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
