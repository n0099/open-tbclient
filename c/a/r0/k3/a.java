package c.a.r0.k3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import c.a.e.e.m.e;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.r0.k3.c.a;
import c.a.r0.k3.d.a;
import c.a.r0.q.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a implements c.a.q0.a1.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static a f21745j = null;
    public static String k = "normal";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21746a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.k3.d.a f21747b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.a1.b f21748c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.k3.c.a f21749d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f21750e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21751f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21752g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f21753h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f21754i;

    /* renamed from: c.a.r0.k3.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1019a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21755a;

        /* renamed from: c.a.r0.k3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1020a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1019a f21756e;

            public RunnableC1020a(C1019a c1019a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1019a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21756e = c1019a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21756e.f21755a.f21748c == null) {
                    return;
                }
                this.f21756e.f21755a.f21748c.a();
            }
        }

        /* renamed from: c.a.r0.k3.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1019a f21757e;

            public b(C1019a c1019a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1019a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21757e = c1019a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f21757e.f21755a.f21749d.g();
                }
            }
        }

        /* renamed from: c.a.r0.k3.a$a$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1019a f21758e;

            public c(C1019a c1019a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1019a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21758e = c1019a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21758e.f21755a.f21748c == null) {
                    return;
                }
                this.f21758e.f21755a.f21748c.a();
            }
        }

        public C1019a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21755a = aVar;
        }

        @Override // c.a.r0.k3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21755a.f21751f) {
                if (this.f21755a.f21748c != null && this.f21755a.f21746a != null && (this.f21755a.f21746a instanceof Activity)) {
                    if (l.C()) {
                        this.f21755a.f21748c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                c.a.r0.q.b.c().a(a.k, "onAdLoadFailed", null);
            }
        }

        @Override // c.a.r0.k3.c.a.c
        public void b(c.a.r0.k3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f21755a.f21749d.e();
                } else if (this.f21755a.f21748c != null && this.f21755a.f21746a != null && (this.f21755a.f21746a instanceof Activity)) {
                    if (l.C()) {
                        this.f21755a.f21748c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1020a(this));
                    }
                } else {
                    c.a.r0.q.b.c().a(a.k, "onAdLoadFailed", null);
                    return;
                }
                if (this.f21755a.f21751f) {
                    this.f21755a.f21750e.postDelayed(new b(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f21755a.f21749d.g();
                }
            }
        }

        @Override // c.a.r0.k3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f21755a.f21751f) {
                if (this.f21755a.f21746a != null && (this.f21755a.f21746a instanceof Activity)) {
                    c.a.r0.k3.b.b c2 = this.f21755a.f21749d.c();
                    if (c2 != null) {
                        StatisticItem h2 = c.a.r0.i3.a.h("a064", "common_fill", true, 1);
                        if (c.a.e.a.j.a(this.f21755a.f21746a) != null) {
                            c.a.r0.i3.c.g().c(c.a.e.a.j.a(this.f21755a.f21746a).getUniqueId(), h2);
                        }
                        this.f21755a.f21747b.g(obj, ((int) c2.f21765c) / 1000);
                        if (this.f21755a.f21748c != null) {
                            this.f21755a.f21748c.c(String.valueOf(c2.f21763a), c2.c(), c2.a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", obj);
                c.a.r0.q.b.c().a(a.k, "onResourceLoaded", hashMap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21759a;

        /* renamed from: c.a.r0.k3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1021a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f21760e;

            public RunnableC1021a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21760e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(c.a.e.a.b.f().b()), new String[]{this.f21760e}, true);
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21759a = aVar;
        }

        @Override // c.a.r0.k3.d.a.d
        public void a() {
            c.a.r0.k3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f21759a.f21749d.c()) == null) {
                return;
            }
            if (this.f21759a.f21748c != null) {
                this.f21759a.f21748c.b(String.valueOf(c2.f21763a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f21768f)) {
                return;
            }
            if (!this.f21759a.l(c2.f21768f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(this.f21759a.f21746a), new String[]{c2.f21768f}, true);
            } else {
                e.a().postDelayed(new RunnableC1021a(this, c2.f21768f), 500L);
            }
        }

        @Override // c.a.r0.k3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f21759a.getView() != null) {
                    if (this.f21759a.getView().getHeight() == l.i(this.f21759a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f21759a.f21748c != null) {
                    this.f21759a.f21748c.onAdDismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1788513366, "Lc/a/r0/k3/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1788513366, "Lc/a/r0/k3/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21750e = new Handler(LaunchTask.asyncLooper);
        this.f21751f = true;
        this.f21752g = false;
        this.f21753h = new C1019a(this);
        this.f21754i = new b(this);
        c.a.r0.k3.c.a aVar = new c.a.r0.k3.c.a();
        this.f21749d = aVar;
        aVar.i(this.f21753h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f21745j == null) {
                synchronized (a.class) {
                    if (f21745j == null) {
                        f21745j = new a();
                    }
                }
            }
            return f21745j;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.q0.a1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21752g) {
                k();
                this.f21752g = false;
                return;
            }
            this.f21749d.d(true);
        }
    }

    @Override // c.a.q0.a1.a
    public void b(c.a.q0.a1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f21748c = bVar;
        }
    }

    @Override // c.a.q0.a1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21747b.b() : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = this.f21746a;
            if ((context != null || (context instanceof Activity)) && !c.a.r0.q.b.c().d(k).isEmpty()) {
                for (b.a aVar : c.a.r0.q.b.c().d(k)) {
                    String str = aVar.f24072a;
                    char c2 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -610376507) {
                        if (hashCode == 539477362 && str.equals("onResourceLoaded")) {
                            c2 = 0;
                        }
                    } else if (str.equals("onAdLoadFailed")) {
                        c2 = 1;
                    }
                    if (c2 == 0) {
                        this.f21753h.c(aVar.f24073b.get("data"));
                    } else if (c2 == 1) {
                        this.f21753h.a();
                    }
                }
                c.a.r0.q.b.c().b(k);
            }
        }
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains("/swan/") || str.contains("/swangame/")) {
                return !ContextCompat.checkPermissionGranted(c.a.e.a.b.f().b(), "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21752g = true;
            this.f21749d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, context) == null) || context == null) {
            return;
        }
        this.f21746a = context;
        this.f21747b = new c.a.r0.k3.d.a(context, this.f21754i);
    }

    @Override // c.a.q0.a1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21746a = null;
            c.a.r0.k3.d.a aVar = this.f21747b;
            if (aVar != null) {
                aVar.c();
                this.f21747b = null;
            }
            this.f21748c = null;
            this.f21751f = false;
            this.f21750e.removeCallbacksAndMessages(null);
            c.a.r0.k3.c.a aVar2 = this.f21749d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
