package com.alipay.security.mobile.module.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f31231b;

    /* renamed from: c  reason: collision with root package name */
    public String f31232c;

    /* renamed from: d  reason: collision with root package name */
    public String f31233d;

    /* renamed from: e  reason: collision with root package name */
    public String f31234e;

    /* renamed from: f  reason: collision with root package name */
    public String f31235f;

    /* renamed from: g  reason: collision with root package name */
    public String f31236g;

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
        this.a = str;
        this.f31231b = str2;
        this.f31232c = str3;
        this.f31233d = str4;
        this.f31234e = str5;
        this.f31235f = str6;
        this.f31236g = str7;
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
            stringBuffer.append("," + this.f31231b);
            stringBuffer.append("," + this.f31232c);
            stringBuffer.append("," + this.f31233d);
            if (com.alipay.security.mobile.module.a.a.a(this.f31234e) || this.f31234e.length() < 20) {
                sb = new StringBuilder(",");
                str = this.f31234e;
            } else {
                sb = new StringBuilder(",");
                str = this.f31234e.substring(0, 20);
            }
            sb.append(str);
            stringBuffer.append(sb.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f31235f) || this.f31235f.length() < 20) {
                sb2 = new StringBuilder(",");
                str2 = this.f31235f;
            } else {
                sb2 = new StringBuilder(",");
                str2 = this.f31235f.substring(0, 20);
            }
            sb2.append(str2);
            stringBuffer.append(sb2.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f31236g) || this.f31236g.length() < 20) {
                sb3 = new StringBuilder(",");
                str3 = this.f31236g;
            } else {
                sb3 = new StringBuilder(",");
                str3 = this.f31236g.substring(0, 20);
            }
            sb3.append(str3);
            stringBuffer.append(sb3.toString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
