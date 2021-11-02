package b.a.p0.a.v2;

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
    public static final boolean f8681f;

    /* renamed from: g  reason: collision with root package name */
    public static c f8682g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f8683a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.g1.a f8684b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8685c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8686d;

    /* renamed from: e  reason: collision with root package name */
    public int f8687e;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f8688e;

        /* renamed from: b.a.p0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0436a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f8689e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8690f;

            public RunnableC0436a(a aVar, Activity activity) {
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
                this.f8690f = aVar;
                this.f8689e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f8689e.getIntent();
                    b.a.p0.a.p.d.a0 n = b.a.p0.a.c1.a.n();
                    ComponentName component = intent.getComponent();
                    if (this.f8690f.f8688e.f8685c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                        if (this.f8690f.f8688e.f8686d) {
                            boolean unused = v0.f8681f;
                            return;
                        }
                        b.a.p0.a.v2.c m = b.a.p0.a.v2.c.m();
                        if (d.a() && b.a.p0.a.v2.c.k()) {
                            u = m.w(this.f8689e, this.f8690f.f8688e.f8687e, false);
                        } else {
                            u = m.u(this.f8690f.f8688e.f8687e, false, false);
                        }
                        if (v0.f8681f) {
                            String str = "moveTaskToFront " + u + ", taskId=" + this.f8690f.f8688e.f8687e;
                        }
                        m.i();
                    }
                    if (v0.f8681f) {
                        String str2 = "class=" + this.f8689e + ", swanAppForeground=" + this.f8690f.f8688e.f8685c + ", flag=" + intent.getFlags() + ", ComponentName=" + component;
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
            this.f8688e = v0Var;
        }

        @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && b.a.p0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0436a runnableC0436a = new RunnableC0436a(this, activity);
                if (d.a()) {
                    runnableC0436a.run();
                } else {
                    q.i(runnableC0436a, "moveTaskToFront");
                }
            }
        }

        @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                v0 v0Var = this.f8688e;
                v0Var.f8685c = v0Var.f8685c && activity != null && activity.getTaskId() == this.f8688e.f8687e;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f8691a;

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
            this.f8691a = v0Var;
        }

        @Override // b.a.p0.a.v2.v0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.f8691a.f8685c = true;
                    this.f8691a.f8687e = i2;
                } else if (this.f8691a.f8685c && i2 == 1) {
                    this.f8691a.f8685c = false;
                }
                this.f8691a.f8686d = z;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1485463964, "Lb/a/p0/a/v2/v0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1485463964, "Lb/a/p0/a/v2/v0;");
                return;
            }
        }
        f8681f = b.a.p0.a.k.f6397a;
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
        this.f8683a = application;
        this.f8684b = new a(this);
        f8682g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f8684b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f8682g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f8682g = null;
            this.f8683a.unregisterActivityLifecycleCallbacks(this.f8684b);
        }
    }
}
