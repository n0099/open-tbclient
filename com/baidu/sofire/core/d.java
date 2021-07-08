package com.baidu.sofire.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.utility.s;
import com.baidu.sofire.utility.t;
import com.baidu.sofire.utility.u;
import com.baidu.sofire.utility.x;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f10339a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f10340b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10341c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f10342d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1595443416, "Lcom/baidu/sofire/core/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1595443416, "Lcom/baidu/sofire/core/d;");
        }
    }

    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            synchronized (d.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (f10341c) {
                        f10341c = false;
                        x.a(context).b(new Runnable(context) { // from class: com.baidu.sofire.core.d.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f10348a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f10348a = context;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        c a2 = c.a(this.f10348a);
                                        if (a2 != null) {
                                            c.a(1);
                                            a2.b();
                                        }
                                    } catch (Throwable unused) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        com.baidu.sofire.h.a a2;
        String E;
        byte[] re;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                a2 = com.baidu.sofire.h.a.a(context);
                E = a2.E();
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (!TextUtils.isEmpty(E)) {
                f10339a = E;
                return E;
            }
            String string = a2.f10412c.getString("xytk_m", "");
            if (!TextUtils.isEmpty(string)) {
                f10339a = string;
                return string;
            }
            String b2 = com.baidu.sofire.utility.e.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String[] split = b2.split("\\|");
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                        String str = split[0] + com.baidu.sofire.utility.c.a(re);
                        a2.f10413d.putString("xytk_m", str);
                        if (Build.VERSION.SDK_INT >= 9) {
                            a2.f10413d.apply();
                        } else {
                            a2.f10413d.commit();
                        }
                        f10339a = str;
                        return str;
                    }
                }
                f10339a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
            f10339a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void a(Context context, int i2, String str, String str2, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, Integer.valueOf(i2), str, str2, iArr}) == null) {
            synchronized (d.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (f10340b) {
                        return;
                    }
                    f10340b = true;
                    c.f10323b = context;
                    x.a(context).b(new Runnable(context, str, str2, iArr, i2) { // from class: com.baidu.sofire.core.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f10343a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f10344b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f10345c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ int[] f10346d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ int f10347e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, str, str2, iArr, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f10343a = context;
                            this.f10344b = str;
                            this.f10345c = str2;
                            this.f10346d = iArr;
                            this.f10347e = i2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.baidu.sofire.utility.c.j(this.f10343a);
                                try {
                                    s.a(this.f10343a);
                                    if (com.baidu.sofire.utility.c.a(this.f10343a, true)) {
                                        if (com.baidu.sofire.utility.c.a(this.f10343a) != 1) {
                                            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                                            intent.setClass(this.f10343a, MyService.class);
                                            intent.setPackage(this.f10343a.getPackageName());
                                            intent.addCategory("com.baidu.category.SOFIRE");
                                            intent.addCategory("android.intent.category.DEFAULT");
                                            Bundle bundle = new Bundle();
                                            bundle.putStringArray("appkey", new String[]{this.f10344b, this.f10345c});
                                            bundle.putIntArray("key", this.f10346d);
                                            bundle.putInt(DelayTB.DELAY, this.f10347e);
                                            intent.putExtra("bundle", bundle);
                                            this.f10343a.startService(intent);
                                            com.baidu.sofire.mutiprocess.b.b(this.f10343a);
                                            return;
                                        }
                                        d.a(this.f10343a);
                                        c a2 = c.a(this.f10343a);
                                        com.baidu.sofire.utility.e.a(this.f10343a);
                                        com.baidu.sofire.utility.e.b(this.f10343a);
                                        if (!TextUtils.isEmpty(this.f10344b) && !TextUtils.isEmpty(this.f10345c)) {
                                            String str3 = this.f10344b;
                                            String str4 = this.f10345c;
                                            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (!com.baidu.sofire.utility.c.f10492e.equals(str3) || !com.baidu.sofire.utility.c.f10493f.equals(str4))) {
                                                com.baidu.sofire.h.a aVar = a2.f10328a;
                                                SharedPreferences.Editor editor = aVar.f10411b;
                                                editor.putString("svi", str3 + "-" + str4);
                                                aVar.f10411b.commit();
                                            }
                                        }
                                        if (this.f10347e > 0) {
                                            Thread.sleep(this.f10347e * 1000);
                                        }
                                        com.baidu.sofire.h.a.a(this.f10343a).a(this.f10346d);
                                        if (!t.a(this.f10343a)) {
                                            boolean unused = d.f10341c = true;
                                            return;
                                        }
                                        c.a(1);
                                        a2.b();
                                    }
                                } catch (Throwable unused2) {
                                    com.baidu.sofire.utility.c.a();
                                }
                            }
                        }
                    });
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    public static Pair<Integer, Object> b(String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        f a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, str, clsArr, objArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(1, null);
            }
            try {
                a2 = f.a();
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (a2 == null) {
                return new Pair<>(3, null);
            }
            ApkInfo d2 = a2.d("com.baidu.sofire.x0");
            if (d2 != null) {
                Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                return new Pair<>(0, com.baidu.sofire.utility.c.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.f10323b), str, clsArr, objArr));
            }
            return new Pair<>(3, null);
        }
        return (Pair) invokeLLL.objValue;
    }

    public static Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), str, clsArr, objArr})) == null) {
            try {
                Context context = c.f10323b;
                if (context == null) {
                    return new Pair<>(4, null);
                }
                if (!t.a(c.f10323b)) {
                    return new Pair<>(12, null);
                }
                if (!com.baidu.sofire.utility.c.a(c.f10323b, false)) {
                    return new Pair<>(11, null);
                }
                String b2 = com.baidu.sofire.utility.c.b(c.f10323b);
                if (TextUtils.isEmpty(b2)) {
                    if (com.baidu.sofire.utility.c.b(c.f10323b.getPackageName())) {
                        return new Pair<>(5, null);
                    }
                    return c.a(context).a(i2, str, clsArr, objArr);
                } else if (com.baidu.sofire.utility.c.b(b2)) {
                    return b(c.f10323b, i2, str, clsArr, objArr);
                } else {
                    return c.a(context).a(i2, str, clsArr, objArr);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public static String b(Context context, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65553, null, context, str, i2, str2)) == null) {
            if (context == null) {
                return "";
            }
            if (i2 != 0) {
                if (TextUtils.isEmpty(str2) && t.a(context)) {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
                } else {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i2), str2);
                }
            }
            return c(context);
        }
        return (String) invokeLLIL.objValue;
    }

    public static Pair<Integer, Object> b(Context context, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, Integer.valueOf(i2), str, clsArr, objArr})) == null) ? a(context, i2, 1, str, clsArr, objArr) : (Pair) invokeCommon.objValue;
    }

    public static synchronized void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, null, context, z) == null) {
            synchronized (d.class) {
                if (context == null) {
                    return;
                }
                try {
                    int a2 = com.baidu.sofire.utility.c.a(context);
                    if (a2 == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("_agree_policy", z);
                        u.a(context, "setAgreePolicy", bundle);
                        return;
                    }
                    if (a2 == 1) {
                        t.a(context, z);
                        if (z && !f10342d) {
                            f10342d = true;
                            b(context);
                        }
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    public static Pair<Integer, Object> a(String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, clsArr, objArr)) == null) {
            try {
                Context context = c.f10323b;
                if (context == null) {
                    return new Pair<>(4, null);
                }
                if (!com.baidu.sofire.utility.c.a(c.f10323b, false)) {
                    return new Pair<>(11, null);
                }
                String b2 = com.baidu.sofire.utility.c.b(c.f10323b);
                if (TextUtils.isEmpty(b2)) {
                    if (com.baidu.sofire.utility.c.b(c.f10323b.getPackageName())) {
                        return new Pair<>(5, null);
                    }
                    c.a(context);
                    return b(str, clsArr, objArr);
                } else if (com.baidu.sofire.utility.c.b(b2)) {
                    return b(c.f10323b, 1, str, clsArr, objArr);
                } else {
                    c.a(context);
                    return b(str, clsArr, objArr);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeLLL.objValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, context, str) == null) || context == null) {
            return;
        }
        try {
            if (t.a(context)) {
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                a2.f10413d.putString("s_h_d_id", str);
                if (Build.VERSION.SDK_INT >= 9) {
                    a2.f10413d.apply();
                } else {
                    a2.f10413d.commit();
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static boolean a(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), str, callback, clsArr, objArr})) == null) {
            try {
                return x.a(c.f10323b).a(new Runnable(callback, i2, str, clsArr, objArr) { // from class: com.baidu.sofire.core.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Callback f10349a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f10350b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f10351c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Class[] f10352d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Object[] f10353e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr2 = {callback, Integer.valueOf(i2), str, clsArr, objArr};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10349a = callback;
                        this.f10350b = i2;
                        this.f10351c = str;
                        this.f10352d = clsArr;
                        this.f10353e = objArr;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                Context context = c.f10323b;
                                if (context == null) {
                                    for (int i3 = 0; i3 < 20; i3++) {
                                        try {
                                            Thread.sleep(50L);
                                        } catch (InterruptedException unused) {
                                            com.baidu.sofire.utility.c.a();
                                        }
                                        context = c.f10323b;
                                        if (context != null) {
                                            break;
                                        }
                                    }
                                    if (context == null) {
                                        if (this.f10349a != null) {
                                            this.f10349a.onError(4);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } catch (Throwable unused2) {
                                com.baidu.sofire.utility.c.a();
                            }
                            if (!t.a(c.f10323b)) {
                                this.f10349a.onError(12);
                            } else if (!com.baidu.sofire.utility.c.a(c.f10323b, false)) {
                                if (this.f10349a != null) {
                                    this.f10349a.onError(11);
                                }
                            } else {
                                String b2 = com.baidu.sofire.utility.c.b(c.f10323b);
                                if (TextUtils.isEmpty(b2)) {
                                    if (com.baidu.sofire.utility.c.b(c.f10323b.getPackageName())) {
                                        if (this.f10349a != null) {
                                            this.f10349a.onError(5);
                                            return;
                                        }
                                        return;
                                    }
                                    c a2 = c.a();
                                    if (a2 == null) {
                                        for (int i4 = 0; i4 < 20; i4++) {
                                            try {
                                                Thread.sleep(50L);
                                            } catch (InterruptedException unused3) {
                                                com.baidu.sofire.utility.c.a();
                                            }
                                            a2 = c.a();
                                            if (a2 != null) {
                                                break;
                                            }
                                        }
                                        if (a2 == null) {
                                            if (this.f10349a != null) {
                                                this.f10349a.onError(11);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    a2.a(this.f10350b, this.f10351c, this.f10349a, this.f10352d, this.f10353e);
                                    return;
                                } else if (com.baidu.sofire.utility.c.b(b2)) {
                                    d.a(c.f10323b, this.f10350b, this.f10351c, this.f10349a, this.f10352d, this.f10353e);
                                    return;
                                } else {
                                    c a3 = c.a();
                                    if (a3 == null) {
                                        for (int i5 = 0; i5 < 20; i5++) {
                                            try {
                                                Thread.sleep(50L);
                                            } catch (InterruptedException unused4) {
                                                com.baidu.sofire.utility.c.a();
                                            }
                                            a3 = c.a();
                                            if (a3 != null) {
                                                break;
                                            }
                                        }
                                        if (a3 == null) {
                                            if (this.f10349a != null) {
                                                this.f10349a.onError(11);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    a3.a(this.f10350b, this.f10351c, this.f10349a, this.f10352d, this.f10353e);
                                    return;
                                }
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                    }
                }) == 1;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static String a(Context context, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLIL = interceptable.invokeLLIL(65544, null, context, str, i2, str2)) != null) {
            return (String) invokeLLIL.objValue;
        }
        if (context == null) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(f10339a)) {
                if (i2 != 0 && t.a(context)) {
                    if (TextUtils.isEmpty(str2)) {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
                    } else {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i2), str2);
                    }
                }
                return f10339a;
            } else if (com.baidu.sofire.utility.c.a(context, false)) {
                String b2 = com.baidu.sofire.utility.c.b(context);
                if (TextUtils.isEmpty(b2)) {
                    return com.baidu.sofire.utility.c.b(context.getPackageName()) ? "" : b(context, str, i2, str2);
                } else if (com.baidu.sofire.utility.c.b(b2)) {
                    Pair<Integer, Object> b3 = b(context, 0, "gzfi", null, str, Integer.valueOf(i2), str2);
                    return (b3 == null || ((Integer) b3.first).intValue() != 0) ? "" : (String) b3.second;
                } else {
                    return b(context, str, i2, str2);
                }
            } else {
                return "";
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return "";
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65548, null, context, z) == null) && context != null && t.a(context)) {
            com.baidu.sofire.h.a.a(context).a(z);
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (!TextUtils.isEmpty(f10339a)) {
                return f10339a;
            }
            if (context != null && com.baidu.sofire.utility.c.a(context, false)) {
                String b2 = com.baidu.sofire.utility.c.b(context);
                if (TextUtils.isEmpty(b2)) {
                    return com.baidu.sofire.utility.c.b(context.getPackageName()) ? "" : c(context);
                } else if (com.baidu.sofire.utility.c.b(b2)) {
                    Pair<Integer, Object> b3 = b(context, 0, "gz", null, new Object[0]);
                    if (b3 != null) {
                        return ((Integer) b3.first).intValue() == 0 ? (String) b3.second : "";
                    }
                    f10339a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                    return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                } else {
                    return c(context);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context != null) {
                try {
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                    i2 = 501;
                }
                if (t.a(context)) {
                    Pair<Integer, Object> a2 = a("xgz", new Class[]{String.class}, str);
                    if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
                        return (String) a2.second;
                    }
                    i2 = ((Integer) a2.first).intValue() == 0 ? 502 : ((Integer) a2.first).intValue();
                    try {
                        return new JSONObject().put("rc", i2).put("z", a(context)).toString();
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
                        return "";
                    }
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Context context, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Integer.valueOf(i2), str3})) == null) {
            if (context != null) {
                try {
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
                if (t.a(context)) {
                    if (TextUtils.isEmpty(str)) {
                        return com.baidu.sofire.utility.c.a(context, 8);
                    }
                    Pair<Integer, Object> a2 = a(100067, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i2), str3);
                    if (((Integer) a2.first).intValue() == 0) {
                        String str4 = (String) a2.second;
                        return !TextUtils.isEmpty(str4) ? str4 : com.baidu.sofire.utility.c.a(context, 9);
                    }
                    if (((Integer) a2.first).intValue() != 4 && ((Integer) a2.first).intValue() != 3) {
                        if (((Integer) a2.first).intValue() == 5 || ((Integer) a2.first).intValue() == 11) {
                            return com.baidu.sofire.utility.c.a(context, 7);
                        }
                        return com.baidu.sofire.utility.c.a(context, 8);
                    }
                    String[] g2 = com.baidu.sofire.utility.c.g(context);
                    a(context, 0, g2[0], g2[1], 100067);
                    return com.baidu.sofire.utility.c.a(context, ((Integer) a2.first).intValue() == 3 ? 5 : 2);
                }
                return "";
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c A[Catch: all -> 0x0099, TryCatch #4 {all -> 0x0184, blocks: (B:5:0x0010, B:8:0x0026, B:10:0x002b, B:30:0x00a0, B:32:0x00aa, B:34:0x00af, B:69:0x0159, B:71:0x0161, B:73:0x016e, B:74:0x0172, B:76:0x0180, B:11:0x0030, B:13:0x0041, B:15:0x0046, B:23:0x0080, B:25:0x008c, B:26:0x0090, B:22:0x007c, B:16:0x0058, B:18:0x005d, B:35:0x00b4, B:37:0x00cd, B:38:0x00d0, B:40:0x00d3, B:42:0x00dd, B:44:0x00e5, B:46:0x00eb, B:48:0x00f8, B:47:0x00ee, B:49:0x00fb, B:52:0x0101, B:54:0x010a, B:56:0x0113, B:58:0x0128, B:65:0x014b, B:55:0x010f, B:60:0x012f, B:64:0x0145), top: B:85:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c A[Catch: all -> 0x0099, TryCatch #4 {all -> 0x0184, blocks: (B:5:0x0010, B:8:0x0026, B:10:0x002b, B:30:0x00a0, B:32:0x00aa, B:34:0x00af, B:69:0x0159, B:71:0x0161, B:73:0x016e, B:74:0x0172, B:76:0x0180, B:11:0x0030, B:13:0x0041, B:15:0x0046, B:23:0x0080, B:25:0x008c, B:26:0x0090, B:22:0x007c, B:16:0x0058, B:18:0x005d, B:35:0x00b4, B:37:0x00cd, B:38:0x00d0, B:40:0x00d3, B:42:0x00dd, B:44:0x00e5, B:46:0x00eb, B:48:0x00f8, B:47:0x00ee, B:49:0x00fb, B:52:0x0101, B:54:0x010a, B:56:0x0113, B:58:0x0128, B:65:0x014b, B:55:0x010f, B:60:0x012f, B:64:0x0145), top: B:85:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #4 {all -> 0x0184, blocks: (B:5:0x0010, B:8:0x0026, B:10:0x002b, B:30:0x00a0, B:32:0x00aa, B:34:0x00af, B:69:0x0159, B:71:0x0161, B:73:0x016e, B:74:0x0172, B:76:0x0180, B:11:0x0030, B:13:0x0041, B:15:0x0046, B:23:0x0080, B:25:0x008c, B:26:0x0090, B:22:0x007c, B:16:0x0058, B:18:0x005d, B:35:0x00b4, B:37:0x00cd, B:38:0x00d0, B:40:0x00d3, B:42:0x00dd, B:44:0x00e5, B:46:0x00eb, B:48:0x00f8, B:47:0x00ee, B:49:0x00fb, B:52:0x0101, B:54:0x010a, B:56:0x0113, B:58:0x0128, B:65:0x014b, B:55:0x010f, B:60:0x012f, B:64:0x0145), top: B:85:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle a(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Pair<Integer, Object> a2;
        Integer num;
        String str2;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            try {
                Class[] clsArr = null;
                String str3 = null;
                if ("gzfi".equals(str)) {
                    bundle2.putBoolean("handle_flag", true);
                    if (bundle != null) {
                        CallArgs callArgs = new CallArgs();
                        bundle.setClassLoader(MyProvider.class.getClassLoader());
                        CallArgs callArgs2 = (CallArgs) bundle.getParcelable("args");
                        if (callArgs2 != null) {
                            if (callArgs2.f10311e.length == 2) {
                                num = (Integer) callArgs2.f10311e[1];
                                str3 = (String) callArgs2.f10311e[0];
                                str2 = null;
                            } else if (callArgs2.f10311e.length == 3) {
                                str3 = (String) callArgs2.f10311e[0];
                                Integer num2 = (Integer) callArgs2.f10311e[1];
                                str2 = (String) callArgs2.f10311e[2];
                                num = num2;
                            }
                            b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                            if (!TextUtils.isEmpty(b2)) {
                                bundle2.putInt("status", 8);
                            } else {
                                callArgs.f10312f = b2;
                                bundle2.putParcelable("result", callArgs);
                                bundle2.putInt("status", 0);
                            }
                            return bundle2;
                        }
                        num = null;
                        str2 = null;
                        b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                        if (!TextUtils.isEmpty(b2)) {
                        }
                        return bundle2;
                    }
                } else if ("invokeMethod".equals(str)) {
                    bundle2.putBoolean("handle_flag", true);
                    if (bundle != null) {
                        CallArgs callArgs3 = new CallArgs();
                        bundle.setClassLoader(MyProvider.class.getClassLoader());
                        CallArgs callArgs4 = (CallArgs) bundle.getParcelable("args");
                        int i2 = callArgs4.f10307a;
                        int i3 = callArgs4.f10308b;
                        String str4 = callArgs4.f10309c;
                        Object[] objArr = callArgs4.f10310d;
                        if (objArr != null) {
                            clsArr = new Class[objArr.length];
                            for (int i4 = 0; i4 < objArr.length; i4++) {
                                String str5 = (String) objArr[i4];
                                if (!TextUtils.isEmpty(str5) && str5.contains("@@")) {
                                    Class<?> a3 = com.baidu.sofire.utility.c.a(str5);
                                    if (a3 != null) {
                                        clsArr[i4] = a3;
                                    }
                                } else {
                                    clsArr[i4] = Class.forName((String) objArr[i4]);
                                }
                            }
                        }
                        Object[] objArr2 = callArgs4.f10311e;
                        if (i3 == 1) {
                            if (i2 == 1 && "xgz".equals(str4)) {
                                a2 = b(str4, clsArr, objArr2);
                            } else {
                                a2 = a(i2, str4, clsArr, objArr2);
                            }
                            bundle2.putInt("status", ((Integer) a2.first).intValue());
                            if (((Integer) a2.first).intValue() == 0) {
                                callArgs3.f10312f = a2.second;
                            }
                        } else if (i3 == 0) {
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            a(i2, str4, new Callback(bundle2, callArgs3, countDownLatch, str4) { // from class: com.baidu.sofire.core.d.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ Bundle f10354a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ CallArgs f10355b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ CountDownLatch f10356c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ String f10357d;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr3 = {bundle2, callArgs3, countDownLatch, str4};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f10354a = bundle2;
                                    this.f10355b = callArgs3;
                                    this.f10356c = countDownLatch;
                                    this.f10357d = str4;
                                }

                                @Override // com.baidu.sofire.ac.Callback
                                public final Object onEnd(Object... objArr3) {
                                    InterceptResult invokeL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objArr3)) == null) {
                                        try {
                                            try {
                                                this.f10354a.putInt("status", 0);
                                                this.f10355b.f10312f = objArr3[0];
                                            } catch (Throwable unused) {
                                                com.baidu.sofire.utility.c.a();
                                            }
                                            this.f10356c.countDown();
                                            return null;
                                        } catch (Throwable th) {
                                            this.f10356c.countDown();
                                            throw th;
                                        }
                                    }
                                    return invokeL.objValue;
                                }

                                @Override // com.baidu.sofire.ac.Callback
                                public final Object onError(Object... objArr3) {
                                    InterceptResult invokeL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr3)) == null) {
                                        try {
                                            try {
                                                this.f10354a.putInt("status", ((Integer) objArr3[0]).intValue());
                                            } catch (Throwable th) {
                                                this.f10356c.countDown();
                                                throw th;
                                            }
                                        } catch (Throwable unused) {
                                            com.baidu.sofire.utility.c.a();
                                        }
                                        this.f10356c.countDown();
                                        return null;
                                    }
                                    return invokeL.objValue;
                                }
                            }, clsArr, objArr2);
                            try {
                                countDownLatch.await(180000L, TimeUnit.MILLISECONDS);
                            } catch (Throwable unused) {
                                bundle2.putInt("status", 3);
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                        bundle2.putParcelable("result", callArgs3);
                        return bundle2;
                    }
                } else if ("gz".equals(str)) {
                    bundle2.putBoolean("handle_flag", true);
                    String c2 = c(context);
                    if (TextUtils.isEmpty(c2)) {
                        bundle2.putInt("status", 8);
                    } else {
                        CallArgs callArgs5 = new CallArgs();
                        callArgs5.f10312f = c2;
                        bundle2.putParcelable("result", callArgs5);
                        bundle2.putInt("status", 0);
                    }
                    return bundle2;
                } else {
                    bundle2.putInt("status", 2);
                    return bundle2;
                }
            } catch (Throwable unused2) {
                com.baidu.sofire.utility.c.a();
            }
            bundle2.putInt("status", 10);
            return bundle2;
        }
        return (Bundle) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:5:0x0006, B:7:0x000c, B:9:0x0016, B:11:0x001e, B:16:0x002b, B:18:0x0038, B:19:0x003c, B:21:0x003f, B:23:0x0047, B:25:0x0053, B:27:0x006f, B:26:0x0067, B:28:0x0072, B:29:0x0074, B:31:0x0086, B:33:0x008f, B:35:0x00a1, B:37:0x00ab, B:41:0x00b5, B:40:0x00b3), top: B:49:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086 A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:5:0x0006, B:7:0x000c, B:9:0x0016, B:11:0x001e, B:16:0x002b, B:18:0x0038, B:19:0x003c, B:21:0x003f, B:23:0x0047, B:25:0x0053, B:27:0x006f, B:26:0x0067, B:28:0x0072, B:29:0x0074, B:31:0x0086, B:33:0x008f, B:35:0x00a1, B:37:0x00ab, B:41:0x00b5, B:40:0x00b3), top: B:49:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:5:0x0006, B:7:0x000c, B:9:0x0016, B:11:0x001e, B:16:0x002b, B:18:0x0038, B:19:0x003c, B:21:0x003f, B:23:0x0047, B:25:0x0053, B:27:0x006f, B:26:0x0067, B:28:0x0072, B:29:0x0074, B:31:0x0086, B:33:0x008f, B:35:0x00a1, B:37:0x00ab, B:41:0x00b5, B:40:0x00b3), top: B:49:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Object> a(Context context, int i2, int i3, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        String str2;
        Bundle a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str, clsArr, objArr})) != null) {
            return (Pair) invokeCommon.objValue;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return Pair.create(1, null);
            }
            if (!"gzfi".equals(str) && !"gz".equals(str)) {
                str2 = "invokeMethod";
                CallArgs callArgs = new CallArgs();
                callArgs.f10307a = i2;
                callArgs.f10309c = str;
                callArgs.f10308b = i3;
                if (clsArr != null) {
                    Object[] objArr2 = new Object[clsArr.length];
                    for (int i4 = 0; i4 < clsArr.length; i4++) {
                        if (clsArr[i4].isPrimitive()) {
                            String a3 = com.baidu.sofire.utility.c.a(clsArr[i4]);
                            if (!TextUtils.isEmpty(a3)) {
                                objArr2[i4] = a3 + "@@";
                            }
                        } else {
                            objArr2[i4] = clsArr[i4].getName();
                        }
                    }
                    callArgs.f10310d = objArr2;
                }
                callArgs.f10311e = objArr;
                Bundle bundle = new Bundle();
                bundle.putParcelable("args", callArgs);
                a2 = u.a(context, str2, bundle);
                if (a2 != null) {
                    return Pair.create(3, null);
                }
                a2.setClassLoader(CallArgs.class.getClassLoader());
                int i5 = a2.getInt("status");
                CallArgs callArgs2 = i5 == 0 ? (CallArgs) a2.getParcelable("result") : null;
                return Pair.create(Integer.valueOf(i5), callArgs2 == null ? null : callArgs2.f10312f);
            }
            str2 = str;
            CallArgs callArgs3 = new CallArgs();
            callArgs3.f10307a = i2;
            callArgs3.f10309c = str;
            callArgs3.f10308b = i3;
            if (clsArr != null) {
            }
            callArgs3.f10311e = objArr;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("args", callArgs3);
            a2 = u.a(context, str2, bundle2);
            if (a2 != null) {
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return Pair.create(3, null);
        }
    }

    public static /* synthetic */ void a(Context context, int i2, String str, Callback callback, Class[] clsArr, Object[] objArr) {
        try {
            if (!TextUtils.isEmpty(str)) {
                x.a(context).a(new Runnable(callback, context, i2, str, clsArr, objArr) { // from class: com.baidu.sofire.core.d.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Callback f10358a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f10359b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f10360c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f10361d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Class[] f10362e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ Object[] f10363f;

                    {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr2 = {callback, context, Integer.valueOf(i2), str, clsArr, objArr};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10358a = callback;
                        this.f10359b = context;
                        this.f10360c = i2;
                        this.f10361d = str;
                        this.f10362e = clsArr;
                        this.f10363f = objArr;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            Callback callback2 = this.f10358a;
                            if (callback2 != null) {
                                callback2.onBegin(new Object[0]);
                            }
                            Pair a2 = d.a(this.f10359b, this.f10360c, 0, this.f10361d, this.f10362e, this.f10363f);
                            if (this.f10358a != null) {
                                if (((Integer) a2.first).intValue() != 0) {
                                    this.f10358a.onError(a2.first);
                                } else {
                                    this.f10358a.onEnd(a2.second);
                                }
                            }
                        }
                    }
                });
            } else if (callback != null) {
                callback.onError(1);
            }
        } catch (Throwable unused) {
            if (callback != null) {
                try {
                    callback.onError(3);
                } catch (Throwable unused2) {
                }
            }
            com.baidu.sofire.utility.c.a();
        }
    }
}
