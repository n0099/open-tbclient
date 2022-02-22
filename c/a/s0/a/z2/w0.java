package c.a.s0.a.z2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f10293f;

    /* renamed from: g  reason: collision with root package name */
    public static c f10294g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Application a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.a.g1.a f10295b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10296c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10297d;

    /* renamed from: e  reason: collision with root package name */
    public int f10298e;

    /* loaded from: classes6.dex */
    public class a extends c.a.s0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w0 f10299e;

        /* renamed from: c.a.s0.a.z2.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0676a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f10300e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10301f;

            public RunnableC0676a(a aVar, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10301f = aVar;
                this.f10300e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f10300e.getIntent();
                    c.a.s0.a.p.d.a0 o = c.a.s0.a.c1.a.o();
                    ComponentName component = intent.getComponent();
                    if (this.f10301f.f10299e.f10296c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && o != null && component != null && TextUtils.equals(o.A(), component.getClassName())) {
                        if (this.f10301f.f10299e.f10297d) {
                            boolean unused = w0.f10293f;
                            return;
                        }
                        c.a.s0.a.z2.c m = c.a.s0.a.z2.c.m();
                        if (d.a() && c.a.s0.a.z2.c.k()) {
                            u = m.w(this.f10300e, this.f10301f.f10299e.f10298e, false);
                        } else {
                            u = m.u(this.f10301f.f10299e.f10298e, false, false);
                        }
                        if (w0.f10293f) {
                            String str = "moveTaskToFront " + u + ", taskId=" + this.f10301f.f10299e.f10298e;
                        }
                        m.i();
                    }
                    if (w0.f10293f) {
                        String str2 = "class=" + this.f10300e + ", swanAppForeground=" + this.f10301f.f10299e.f10296c + ", flag=" + intent.getFlags() + ", ComponentName=" + component;
                    }
                }
            }
        }

        public a(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10299e = w0Var;
        }

        @Override // c.a.s0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && c.a.s0.a.z2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0676a runnableC0676a = new RunnableC0676a(this, activity);
                if (d.a()) {
                    runnableC0676a.run();
                } else {
                    q.j(runnableC0676a, "moveTaskToFront");
                }
            }
        }

        @Override // c.a.s0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                w0 w0Var = this.f10299e;
                w0Var.f10296c = w0Var.f10296c && activity != null && activity.getTaskId() == this.f10299e.f10298e;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w0 a;

        public b(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w0Var;
        }

        @Override // c.a.s0.a.z2.w0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.a.f10296c = true;
                    this.a.f10298e = i2;
                } else if (this.a.f10296c && i2 == 1) {
                    this.a.f10296c = false;
                }
                this.a.f10297d = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-959281371, "Lc/a/s0/a/z2/w0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-959281371, "Lc/a/s0/a/z2/w0;");
                return;
            }
        }
        f10293f = c.a.s0.a.k.a;
    }

    public w0(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = application;
        this.f10295b = new a(this);
        f10294g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f10295b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f10294g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f10294g = null;
            this.a.unregisterActivityLifecycleCallbacks(this.f10295b);
        }
    }
}
