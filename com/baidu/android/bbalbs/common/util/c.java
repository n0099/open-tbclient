package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static b f36693b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f36694c = "";

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f36695d = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f36696a;

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
        this.f36696a = context.getApplicationContext();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(f36694c)) {
                f36694c = "0newiqr3mini0";
            }
            return f36694c;
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
                if (TextUtils.isEmpty(f36695d)) {
                    f36695d = str;
                    int length = 5 - str.length();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("0newiqr3");
                    stringBuffer.append(str);
                    for (int i2 = 0; i2 < length; i2++) {
                        stringBuffer.append("0");
                    }
                    f36694c = stringBuffer.toString().trim();
                }
            }
        }
    }

    private b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            b b2 = b.b(this.f36696a);
            boolean z = b2 == null;
            if (b2 == null) {
                a b3 = a.b(this.f36696a);
                if (b3 == null) {
                    b2 = b.a(this.f36696a, a());
                } else {
                    b3.c();
                    b2 = b.a(b3);
                }
            }
            if (z) {
                b2.a(this.f36696a);
            }
            a.a(this.f36696a);
            return b2;
        }
        return (b) invokeV.objValue;
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f36693b == null) {
                synchronized (b.class) {
                    if (f36693b == null) {
                        f36693b = new c(context).b();
                    }
                }
            }
            return f36693b;
        }
        return (b) invokeL.objValue;
    }
}
