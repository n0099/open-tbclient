package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Charset qI;
    public String rq;
    public StringBuilder rr;

    public o() {
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
        this.qI = StandardCharsets.UTF_8;
    }

    public void a(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charset) == null) {
            this.qI = charset;
        }
    }

    public void au(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.rq = str;
        }
    }

    public URL eO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.rq;
            if (str == null) {
                str = "";
            }
            StringBuilder sb = this.rr;
            if (sb != null && sb.length() > 0) {
                str = str + (str.contains("?") ? "&" : "?") + this.rr.toString();
            }
            return new URL(str);
        }
        return (URL) invokeV.objValue;
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = this.rr;
        if (sb == null) {
            this.rr = new StringBuilder();
        } else if (sb.length() > 0) {
            this.rr.append("&");
        }
        this.rr.append(j.a(str, this.qI));
        this.rr.append("=");
        this.rr.append(j.a(str2, this.qI));
    }
}
