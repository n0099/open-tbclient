package com.alipay.security.mobile.module.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String toString() {
        InterceptResult invokeV;
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
            stringBuffer.append("," + this.a);
            stringBuffer.append("," + this.b);
            stringBuffer.append("," + this.c);
            stringBuffer.append("," + this.d);
            if (com.alipay.security.mobile.module.a.a.a(this.e) || this.e.length() < 20) {
                sb = new StringBuilder(",");
                str = this.e;
            } else {
                sb = new StringBuilder(",");
                str = this.e.substring(0, 20);
            }
            sb.append(str);
            stringBuffer.append(sb.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f) || this.f.length() < 20) {
                sb2 = new StringBuilder(",");
                str2 = this.f;
            } else {
                sb2 = new StringBuilder(",");
                str2 = this.f.substring(0, 20);
            }
            sb2.append(str2);
            stringBuffer.append(sb2.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.g) || this.g.length() < 20) {
                sb3 = new StringBuilder(",");
                str3 = this.g;
            } else {
                sb3 = new StringBuilder(",");
                str3 = this.g.substring(0, 20);
            }
            sb3.append(str3);
            stringBuffer.append(sb3.toString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
