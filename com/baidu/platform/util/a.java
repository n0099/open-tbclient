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
/* loaded from: classes7.dex */
public class a implements ParamBuilder<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f42078a;

    public a() {
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

    public a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f42078a == null) {
                this.f42078a = new LinkedHashMap();
            }
            this.f42078a.put(str, str2);
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.f42078a;
            if (map == null || map.isEmpty()) {
                return null;
            }
            String str = new String();
            int i2 = 0;
            for (String str2 : this.f42078a.keySet()) {
                String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f42078a.get(str2));
                if (i2 == 0) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    str = "&";
                }
                sb.append(str);
                sb.append(str2);
                sb.append("=");
                sb.append(encodeUrlParamsValue);
                str = sb.toString();
                i2++;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
