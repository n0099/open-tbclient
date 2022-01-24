package c.a.r0.a.z2;

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
    public static final boolean f10193f;

    /* renamed from: g  reason: collision with root package name */
    public static c f10194g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Application a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.g1.a f10195b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10196c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10197d;

    /* renamed from: e  reason: collision with root package name */
    public int f10198e;

    /* loaded from: classes6.dex */
    public class a extends c.a.r0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w0 f10199e;

        /* renamed from: c.a.r0.a.z2.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0665a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f10200e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10201f;

            public RunnableC0665a(a aVar, Activity activity) {
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
                this.f10201f = aVar;
                this.f10200e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f10200e.getIntent();
                    c.a.r0.a.p.d.a0 o = c.a.r0.a.c1.a.o();
                    ComponentName component = intent.getComponent();
                    if (this.f10201f.f10199e.f10196c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && o != null && component != null && TextUtils.equals(o.A(), component.getClassName())) {
                        if (this.f10201f.f10199e.f10197d) {
                            boolean unused = w0.f10193f;
                            return;
                        }
                        c.a.r0.a.z2.c m = c.a.r0.a.z2.c.m();
                        if (d.a() && c.a.r0.a.z2.c.k()) {
                            u = m.w(this.f10200e, this.f10201f.f10199e.f10198e, false);
                        } else {
                            u = m.u(this.f10201f.f10199e.f10198e, false, false);
                        }
                        if (w0.f10193f) {
                            String str = "moveTaskToFront " + u + ", taskId=" + this.f10201f.f10199e.f10198e;
                        }
                        m.i();
                    }
                    if (w0.f10193f) {
                        String str2 = "class=" + this.f10200e + ", swanAppForeground=" + this.f10201f.f10199e.f10196c + ", flag=" + intent.getFlags() + ", ComponentName=" + component;
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
            this.f10199e = w0Var;
        }

        @Override // c.a.r0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && c.a.r0.a.z2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0665a runnableC0665a = new RunnableC0665a(this, activity);
                if (d.a()) {
                    runnableC0665a.run();
                } else {
                    q.j(runnableC0665a, "moveTaskToFront");
                }
            }
        }

        @Override // c.a.r0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                w0 w0Var = this.f10199e;
                w0Var.f10196c = w0Var.f10196c && activity != null && activity.getTaskId() == this.f10199e.f10198e;
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

        @Override // c.a.r0.a.z2.w0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.a.f10196c = true;
                    this.a.f10198e = i2;
                } else if (this.a.f10196c && i2 == 1) {
                    this.a.f10196c = false;
                }
                this.a.f10197d = z;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(837669988, "Lc/a/r0/a/z2/w0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(837669988, "Lc/a/r0/a/z2/w0;");
                return;
            }
        }
        f10193f = c.a.r0.a.k.a;
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
        this.f10195b = new a(this);
        f10194g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f10195b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f10194g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f10194g = null;
            this.a.unregisterActivityLifecycleCallbacks(this.f10195b);
        }
    }
}
