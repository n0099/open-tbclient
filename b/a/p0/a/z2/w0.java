package b.a.p0.a.z2;

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
    public static final boolean f9884f;

    /* renamed from: g  reason: collision with root package name */
    public static c f9885g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f9886a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.g1.a f9887b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9888c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9889d;

    /* renamed from: e  reason: collision with root package name */
    public int f9890e;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w0 f9891e;

        /* renamed from: b.a.p0.a.z2.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0507a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f9892e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f9893f;

            public RunnableC0507a(a aVar, Activity activity) {
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
                this.f9893f = aVar;
                this.f9892e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f9892e.getIntent();
                    b.a.p0.a.p.d.a0 o = b.a.p0.a.c1.a.o();
                    ComponentName component = intent.getComponent();
                    if (this.f9893f.f9891e.f9888c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && o != null && component != null && TextUtils.equals(o.A(), component.getClassName())) {
                        if (this.f9893f.f9891e.f9889d) {
                            boolean unused = w0.f9884f;
                            return;
                        }
                        b.a.p0.a.z2.c m = b.a.p0.a.z2.c.m();
                        if (d.a() && b.a.p0.a.z2.c.k()) {
                            u = m.w(this.f9892e, this.f9893f.f9891e.f9890e, false);
                        } else {
                            u = m.u(this.f9893f.f9891e.f9890e, false, false);
                        }
                        if (w0.f9884f) {
                            String str = "moveTaskToFront " + u + ", taskId=" + this.f9893f.f9891e.f9890e;
                        }
                        m.i();
                    }
                    if (w0.f9884f) {
                        String str2 = "class=" + this.f9892e + ", swanAppForeground=" + this.f9893f.f9891e.f9888c + ", flag=" + intent.getFlags() + ", ComponentName=" + component;
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
            this.f9891e = w0Var;
        }

        @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && b.a.p0.a.z2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0507a runnableC0507a = new RunnableC0507a(this, activity);
                if (d.a()) {
                    runnableC0507a.run();
                } else {
                    q.j(runnableC0507a, "moveTaskToFront");
                }
            }
        }

        @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                w0 w0Var = this.f9891e;
                w0Var.f9888c = w0Var.f9888c && activity != null && activity.getTaskId() == this.f9891e.f9890e;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w0 f9894a;

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
            this.f9894a = w0Var;
        }

        @Override // b.a.p0.a.z2.w0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.f9894a.f9888c = true;
                    this.f9894a.f9890e = i2;
                } else if (this.f9894a.f9888c && i2 == 1) {
                    this.f9894a.f9888c = false;
                }
                this.f9894a.f9889d = z;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370946399, "Lb/a/p0/a/z2/w0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1370946399, "Lb/a/p0/a/z2/w0;");
                return;
            }
        }
        f9884f = b.a.p0.a.k.f6863a;
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
        this.f9886a = application;
        this.f9887b = new a(this);
        f9885g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f9887b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f9885g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f9885g = null;
            this.f9886a.unregisterActivityLifecycleCallbacks(this.f9887b);
        }
    }
}
