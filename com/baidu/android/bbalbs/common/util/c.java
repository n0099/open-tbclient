package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static b f31525b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f31526c = "";

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f31527d = "";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

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
        this.a = context.getApplicationContext();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(f31526c)) {
                f31526c = "0newiqr3mini0";
            }
            return f31526c;
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            if (!d.a(str, 5)) {
                throw new IllegalArgumentException("expect src only letter or number , less than 6");
            }
            synchronized (b.class) {
                if (TextUtils.isEmpty(f31527d)) {
                    f31527d = str;
                    int length = 5 - str.length();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("0newiqr3");
                    stringBuffer.append(str);
                    for (int i2 = 0; i2 < length; i2++) {
                        stringBuffer.append("0");
                    }
                    f31526c = stringBuffer.toString().trim();
                }
            }
        }
    }

    private b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            b b2 = b.b(this.a);
            boolean z = b2 == null;
            if (b2 == null) {
                a b3 = a.b(this.a);
                if (b3 == null) {
                    b2 = b.a(this.a, a());
                } else {
                    b3.c();
                    b2 = b.a(b3);
                }
            }
            if (z) {
                b2.a(this.a);
            }
            a.a(this.a);
            return b2;
        }
        return (b) invokeV.objValue;
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (f31525b == null) {
                synchronized (b.class) {
                    if (f31525b == null) {
                        f31525b = new c(context).b();
                    }
                }
            }
            return f31525b;
        }
        return (b) invokeL.objValue;
    }
}
