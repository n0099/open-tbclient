package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static b f2564b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f2565c = "";

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f2566d = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2567a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1701138886, "Lcom/baidu/android/bbalbs/common/util/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1701138886, "Lcom/baidu/android/bbalbs/common/util/c;");
        }
    }

    public c(Context context) {
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
        this.f2567a = context.getApplicationContext();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(f2565c)) {
                f2565c = "0newiqr3mini0";
            }
            return f2565c;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? b(context).a() : (String) invokeL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            if (!d.a(str, 5)) {
                throw new IllegalArgumentException("expect src only letter or number , less than 6");
            }
            synchronized (b.class) {
                if (TextUtils.isEmpty(f2566d)) {
                    f2566d = str;
                    int length = 5 - str.length();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("0newiqr3");
                    stringBuffer.append(str);
                    for (int i2 = 0; i2 < length; i2++) {
                        stringBuffer.append("0");
                    }
                    f2565c = stringBuffer.toString().trim();
                }
            }
        }
    }

    private b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            b b2 = b.b(this.f2567a);
            boolean z = b2 == null;
            if (b2 == null) {
                a b3 = a.b(this.f2567a);
                if (b3 == null) {
                    b2 = b.a(this.f2567a, a());
                } else {
                    b3.c();
                    b2 = b.a(b3);
                }
            }
            if (z) {
                b2.a(this.f2567a);
            }
            a.a(this.f2567a);
            return b2;
        }
        return (b) invokeV.objValue;
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f2564b == null) {
                synchronized (b.class) {
                    if (f2564b == null) {
                        f2564b = new c(context).b();
                    }
                }
            }
            return f2564b;
        }
        return (b) invokeL.objValue;
    }
}
