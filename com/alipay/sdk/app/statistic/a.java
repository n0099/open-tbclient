package com.alipay.sdk.app.statistic;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1818a = "alipay_cashier_statistic_record";

    /* renamed from: b  reason: collision with root package name */
    public static c f1819b;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && f1819b == null) {
            f1819b = new c(context);
        }
    }

    public static synchronized void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            synchronized (a.class) {
                if (f1819b == null) {
                    return;
                }
                a(context, f1819b.a(str));
                f1819b = null;
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            new Thread(new b(context, str)).start();
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, th) == null) || f1819b == null || th == null || th.getClass() == null) {
            return;
        }
        f1819b.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(String str, String str2, Throwable th, String str3) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, th, str3) == null) || (cVar = f1819b) == null) {
            return;
        }
        cVar.a(str, str2, th, str3);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) || (cVar = f1819b) == null) {
            return;
        }
        cVar.a(str, str2, th);
    }

    public static void a(String str, String str2, String str3) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65540, null, str, str2, str3) == null) || (cVar = f1819b) == null) {
            return;
        }
        cVar.a(str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, context, str, str2, str3) == null) || context == null) {
            return;
        }
        try {
            c cVar = new c(context);
            cVar.a(str, str2, str3);
            a(context, cVar.a(""));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
