package com.alipay.security.mobile.module.c;

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

    /* renamed from: a  reason: collision with root package name */
    public String f2059a;

    /* renamed from: b  reason: collision with root package name */
    public String f2060b;

    /* renamed from: c  reason: collision with root package name */
    public String f2061c;

    /* renamed from: d  reason: collision with root package name */
    public String f2062d;

    /* renamed from: e  reason: collision with root package name */
    public String f2063e;

    /* renamed from: f  reason: collision with root package name */
    public String f2064f;

    /* renamed from: g  reason: collision with root package name */
    public String f2065g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2059a = str;
        this.f2060b = str2;
        this.f2061c = str3;
        this.f2062d = str4;
        this.f2063e = str5;
        this.f2064f = str6;
        this.f2065g = str7;
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
            stringBuffer.append("," + this.f2059a);
            stringBuffer.append("," + this.f2060b);
            stringBuffer.append("," + this.f2061c);
            stringBuffer.append("," + this.f2062d);
            if (com.alipay.security.mobile.module.a.a.a(this.f2063e) || this.f2063e.length() < 20) {
                sb = new StringBuilder(",");
                str = this.f2063e;
            } else {
                sb = new StringBuilder(",");
                str = this.f2063e.substring(0, 20);
            }
            sb.append(str);
            stringBuffer.append(sb.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f2064f) || this.f2064f.length() < 20) {
                sb2 = new StringBuilder(",");
                str2 = this.f2064f;
            } else {
                sb2 = new StringBuilder(",");
                str2 = this.f2064f.substring(0, 20);
            }
            sb2.append(str2);
            stringBuffer.append(sb2.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f2065g) || this.f2065g.length() < 20) {
                sb3 = new StringBuilder(",");
                str3 = this.f2065g;
            } else {
                sb3 = new StringBuilder(",");
                str3 = this.f2065g.substring(0, 20);
            }
            sb3.append(str3);
            stringBuffer.append(sb3.toString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
