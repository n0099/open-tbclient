package com.alipay.security.mobile.module.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34307a;

    /* renamed from: b  reason: collision with root package name */
    public String f34308b;

    /* renamed from: c  reason: collision with root package name */
    public String f34309c;

    /* renamed from: d  reason: collision with root package name */
    public String f34310d;

    /* renamed from: e  reason: collision with root package name */
    public String f34311e;

    /* renamed from: f  reason: collision with root package name */
    public String f34312f;

    /* renamed from: g  reason: collision with root package name */
    public String f34313g;

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
        this.f34307a = str;
        this.f34308b = str2;
        this.f34309c = str3;
        this.f34310d = str4;
        this.f34311e = str5;
        this.f34312f = str6;
        this.f34313g = str7;
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
            stringBuffer.append("," + this.f34307a);
            stringBuffer.append("," + this.f34308b);
            stringBuffer.append("," + this.f34309c);
            stringBuffer.append("," + this.f34310d);
            if (com.alipay.security.mobile.module.a.a.a(this.f34311e) || this.f34311e.length() < 20) {
                sb = new StringBuilder(",");
                str = this.f34311e;
            } else {
                sb = new StringBuilder(",");
                str = this.f34311e.substring(0, 20);
            }
            sb.append(str);
            stringBuffer.append(sb.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f34312f) || this.f34312f.length() < 20) {
                sb2 = new StringBuilder(",");
                str2 = this.f34312f;
            } else {
                sb2 = new StringBuilder(",");
                str2 = this.f34312f.substring(0, 20);
            }
            sb2.append(str2);
            stringBuffer.append(sb2.toString());
            if (com.alipay.security.mobile.module.a.a.a(this.f34313g) || this.f34313g.length() < 20) {
                sb3 = new StringBuilder(",");
                str3 = this.f34313g;
            } else {
                sb3 = new StringBuilder(",");
                str3 = this.f34313g.substring(0, 20);
            }
            sb3.append(str3);
            stringBuffer.append(sb3.toString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
