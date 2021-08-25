package c.a.o0.a.v2;

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
/* loaded from: classes.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9400f;

    /* renamed from: g  reason: collision with root package name */
    public static c f9401g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f9402a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.a.g1.a f9403b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9404c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9405d;

    /* renamed from: e  reason: collision with root package name */
    public int f9406e;

    /* loaded from: classes.dex */
    public class a extends c.a.o0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f9407e;

        /* renamed from: c.a.o0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0439a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f9408e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f9409f;

            public RunnableC0439a(a aVar, Activity activity) {
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
                this.f9409f = aVar;
                this.f9408e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f9408e.getIntent();
                    c.a.o0.a.p.d.a0 n = c.a.o0.a.c1.a.n();
                    ComponentName component = intent.getComponent();
                    if (this.f9409f.f9407e.f9404c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                        if (this.f9409f.f9407e.f9405d) {
                            boolean unused = v0.f9400f;
                            return;
                        }
                        c.a.o0.a.v2.c m = c.a.o0.a.v2.c.m();
                        if (d.a() && c.a.o0.a.v2.c.k()) {
                            u = m.w(this.f9408e, this.f9409f.f9407e.f9406e, false);
                        } else {
                            u = m.u(this.f9409f.f9407e.f9406e, false, false);
                        }
                        if (v0.f9400f) {
                            String str = "moveTaskToFront " + u + ", taskId=" + this.f9409f.f9407e.f9406e;
                        }
                        m.i();
                    }
                    if (v0.f9400f) {
                        String str2 = "class=" + this.f9408e + ", swanAppForeground=" + this.f9409f.f9407e.f9404c + ", flag=" + intent.getFlags() + ", ComponentName=" + component;
                    }
                }
            }
        }

        public a(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9407e = v0Var;
        }

        @Override // c.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && c.a.o0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0439a runnableC0439a = new RunnableC0439a(this, activity);
                if (d.a()) {
                    runnableC0439a.run();
                } else {
                    q.i(runnableC0439a, "moveTaskToFront");
                }
            }
        }

        @Override // c.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                v0 v0Var = this.f9407e;
                v0Var.f9404c = v0Var.f9404c && activity != null && activity.getTaskId() == this.f9407e.f9406e;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f9410a;

        public b(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9410a = v0Var;
        }

        @Override // c.a.o0.a.v2.v0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.f9410a.f9404c = true;
                    this.f9410a.f9406e = i2;
                } else if (this.f9410a.f9404c && i2 == 1) {
                    this.f9410a.f9404c = false;
                }
                this.f9410a.f9405d = z;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819039204, "Lc/a/o0/a/v2/v0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819039204, "Lc/a/o0/a/v2/v0;");
                return;
            }
        }
        f9400f = c.a.o0.a.k.f7049a;
    }

    public v0(@NonNull Application application) {
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
        this.f9402a = application;
        this.f9403b = new a(this);
        f9401g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f9403b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f9401g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f9401g = null;
            this.f9402a.unregisterActivityLifecycleCallbacks(this.f9403b);
        }
    }
}
