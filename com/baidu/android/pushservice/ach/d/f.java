package com.baidu.android.pushservice.ach.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public WindowManager a;
    public boolean b;
    public c c;
    public WeakReference<com.baidu.android.pushservice.ach.d.b> d;
    public Handler e;
    public Runnable f;
    public Runnable g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15993, this, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static final f a = new f(null);

        public static /* synthetic */ f a() {
            return (f) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15996, null, null);
        }
    }

    public f() {
        this.b = false;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new Runnable() { // from class: com.baidu.tieba.zj
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    com.baidu.android.pushservice.ach.d.f.this.f();
                }
            }
        };
        this.g = new a();
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
        return b.a();
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
        com.baidu.android.pushservice.ach.d.b e = e();
        if (e == null) {
            return;
        }
        e.b();
    }

    public final void a(int i) {
        com.baidu.android.pushservice.ach.d.b e = e();
        if (e == null) {
            return;
        }
        e.b(i);
    }

    public boolean a(Context context, int i) {
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

    public final c b(Context context, int i) {
        if (i == 0 || i == 1) {
            return new d(context);
        }
        return null;
    }

    public final void b() {
        c cVar;
        if (this.b && this.a != null && (cVar = this.c) != null && cVar.a() != null) {
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
        com.baidu.android.pushservice.ach.d.b e = e();
        if (e == null) {
            return;
        }
        e.a(i);
    }

    public void b(final Context context, final int i, final e eVar, final long j, final com.baidu.android.pushservice.ach.d.b bVar) {
        if (context != null && eVar != null && c(eVar.d)) {
            this.e.post(new Runnable() { // from class: com.baidu.tieba.yj
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        com.baidu.android.pushservice.ach.d.f.this.a(context, i, eVar, j, bVar);
                    }
                }
            });
        } else if (bVar == null) {
        } else {
            bVar.b();
        }
    }

    public void c() {
        c cVar;
        if (!this.b || this.a == null || (cVar = this.c) == null || cVar.a() == null || this.c.b() == null) {
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
        this.c.a().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xj
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
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

    public boolean c(int i) {
        if (i == -1) {
            return false;
        }
        return (536870912 & i) > 0 || (i & LaunchTaskConstants.OTHER_PROCESS) > 0;
    }

    public final com.baidu.android.pushservice.ach.d.b e() {
        WeakReference<com.baidu.android.pushservice.ach.d.b> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
