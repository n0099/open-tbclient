package com.baidu.android.pushservice.ach.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WindowManager a;
    public boolean b;
    public c c;
    public WeakReference<com.baidu.android.pushservice.ach.d.b> d;
    public Handler e;
    public Runnable f;
    public Runnable g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15993, this, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(207269869, "Lcom/baidu/android/pushservice/ach/d/f$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(207269869, "Lcom/baidu/android/pushservice/ach/d/f$b;");
                    return;
                }
            }
            a = new f(null);
        }

        public static /* synthetic */ f a() {
            return (f) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15996, null, null);
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new Runnable() { // from class: com.baidu.tieba.lo
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.baidu.android.pushservice.ach.d.f.this.f();
                }
            }
        };
        this.g = new a(this);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, View view2) {
        b();
        a(i);
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b.a() : (f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        b();
        com.baidu.android.pushservice.ach.d.b e = e();
        if (e != null) {
            e.a();
        }
    }

    public final void a() {
        com.baidu.android.pushservice.ach.d.b e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (e = e()) == null) {
            return;
        }
        e.b();
    }

    public final void a(int i) {
        com.baidu.android.pushservice.ach.d.b e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (e = e()) == null) {
            return;
        }
        e.b(i);
    }

    public boolean a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i)) == null) {
            int i2 = (i & 12) >> 2;
            boolean B = Utility.B(context);
            if (i2 != 0) {
                if (i2 == 1 && B) {
                    return true;
                }
                return i2 == 2 && !B;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final c b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i)) == null) {
            if (i == 0 || i == 1) {
                return new d(context);
            }
            return null;
        }
        return (c) invokeLI.objValue;
    }

    public final void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b && this.a != null && (cVar = this.c) != null && cVar.a() != null) {
            try {
                this.e.removeCallbacks(this.f);
                this.a.removeView(this.c.a());
                this.c = null;
                this.b = false;
            } catch (Exception unused) {
            }
        }
    }

    public final void b(int i) {
        com.baidu.android.pushservice.ach.d.b e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (e = e()) == null) {
            return;
        }
        e.a(i);
    }

    public void b(final Context context, final int i, final e eVar, final long j, final com.baidu.android.pushservice.ach.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), eVar, Long.valueOf(j), bVar}) == null) {
            if (context != null && eVar != null && c(eVar.d)) {
                this.e.post(new Runnable() { // from class: com.baidu.tieba.ko
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.baidu.android.pushservice.ach.d.f.this.a(context, i, eVar, j, bVar);
                        }
                    }
                });
            } else if (bVar == null) {
            } else {
                bVar.b();
            }
        }
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || !this.b || this.a == null || (cVar = this.c) == null || cVar.a() == null || this.c.b() == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.g.run();
        } else {
            this.e.post(this.g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public final void a(Context context, int i, e eVar, long j, com.baidu.android.pushservice.ach.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i), eVar, Long.valueOf(j), bVar}) == null) {
            if (this.b) {
                c();
            }
            this.d = new WeakReference<>(bVar);
            if (this.a == null) {
                this.a = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            }
            if (this.a == null) {
                a();
                return;
            }
            c b2 = b(context, i);
            this.c = b2;
            if (b2 == null || b2.a() == null) {
                a();
                return;
            }
            WindowManager.LayoutParams b3 = this.c.b();
            if (b3 == null) {
                a();
                return;
            }
            final int a2 = this.c.a(context, eVar);
            if (a2 == -10000) {
                a();
                return;
            }
            b3.type = a2;
            this.c.a(eVar);
            this.c.a().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jo
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        com.baidu.android.pushservice.ach.d.f.this.a(a2, view2);
                    }
                }
            });
            try {
            } catch (Throwable unused) {
                this.b = false;
                a();
            }
            if (this.a != null && this.c != null && this.c.a() != null) {
                this.a.addView(this.c.a(), b3);
                this.b = true;
                b(a2);
                this.e.postDelayed(this.f, j);
            }
        }
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (i == -1) {
                return false;
            }
            return (536870912 & i) > 0 || (i & LaunchTaskConstants.OTHER_PROCESS) > 0;
        }
        return invokeI.booleanValue;
    }

    public final com.baidu.android.pushservice.ach.d.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            WeakReference<com.baidu.android.pushservice.ach.d.b> weakReference = this.d;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (com.baidu.android.pushservice.ach.d.b) invokeV.objValue;
    }
}
