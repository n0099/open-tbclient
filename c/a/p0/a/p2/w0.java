package c.a.p0.a.p2;

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
public class w0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7021f;

    /* renamed from: g  reason: collision with root package name */
    public static c f7022g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Application a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.w0.a f7023b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7024c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7025d;

    /* renamed from: e  reason: collision with root package name */
    public int f7026e;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w0 f7027e;

        /* renamed from: c.a.p0.a.p2.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0433a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f7028e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7029f;

            public RunnableC0433a(a aVar, Activity activity) {
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
                this.f7029f = aVar;
                this.f7028e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f7028e.getIntent();
                    c.a.p0.a.f.d.a0 o = c.a.p0.a.s0.a.o();
                    ComponentName component = intent.getComponent();
                    if (this.f7029f.f7027e.f7024c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && o != null && component != null && TextUtils.equals(o.A(), component.getClassName())) {
                        if (this.f7029f.f7027e.f7025d) {
                            boolean unused = w0.f7021f;
                            return;
                        }
                        c.a.p0.a.p2.c m = c.a.p0.a.p2.c.m();
                        if (d.a() && c.a.p0.a.p2.c.k()) {
                            u = m.w(this.f7028e, this.f7029f.f7027e.f7026e, false);
                        } else {
                            u = m.u(this.f7029f.f7027e.f7026e, false, false);
                        }
                        if (w0.f7021f) {
                            String str = "moveTaskToFront " + u + ", taskId=" + this.f7029f.f7027e.f7026e;
                        }
                        m.i();
                    }
                    if (w0.f7021f) {
                        String str2 = "class=" + this.f7028e + ", swanAppForeground=" + this.f7029f.f7027e.f7024c + ", flag=" + intent.getFlags() + ", ComponentName=" + component;
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
            this.f7027e = w0Var;
        }

        @Override // c.a.p0.a.w0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && c.a.p0.a.p2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0433a runnableC0433a = new RunnableC0433a(this, activity);
                if (d.a()) {
                    runnableC0433a.run();
                } else {
                    q.j(runnableC0433a, "moveTaskToFront");
                }
            }
        }

        @Override // c.a.p0.a.w0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                w0 w0Var = this.f7027e;
                w0Var.f7024c = w0Var.f7024c && activity != null && activity.getTaskId() == this.f7027e.f7026e;
            }
        }
    }

    /* loaded from: classes.dex */
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

        @Override // c.a.p0.a.p2.w0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.a.f7024c = true;
                    this.a.f7026e = i2;
                } else if (this.a.f7024c && i2 == 1) {
                    this.a.f7024c = false;
                }
                this.a.f7025d = z;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-149686100, "Lc/a/p0/a/p2/w0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-149686100, "Lc/a/p0/a/p2/w0;");
                return;
            }
        }
        f7021f = c.a.p0.a.a.a;
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
        this.f7023b = new a(this);
        f7022g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f7023b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f7022g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f7022g = null;
            this.a.unregisterActivityLifecycleCallbacks(this.f7023b);
        }
    }
}
