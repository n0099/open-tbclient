package c.a.t0.x3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import c.a.d.a.j;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.v.d;
import c.a.t0.x3.c.a;
import c.a.t0.x3.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a implements c.a.s0.b1.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static a f25552j = null;
    public static String k = "normal";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.x3.d.a f25553b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.b1.b f25554c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.x3.c.a f25555d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f25556e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25557f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25558g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f25559h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f25560i;

    /* renamed from: c.a.t0.x3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1538a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.t0.x3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1539a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1538a f25561e;

            public RunnableC1539a(C1538a c1538a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1538a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25561e = c1538a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25561e.a.f25554c == null) {
                    return;
                }
                this.f25561e.a.f25554c.a();
            }
        }

        /* renamed from: c.a.t0.x3.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1538a f25562e;

            public b(C1538a c1538a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1538a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25562e = c1538a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && l.z() && l.H()) {
                    this.f25562e.a.f25555d.g();
                }
            }
        }

        /* renamed from: c.a.t0.x3.a$a$c */
        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1538a f25563e;

            public c(C1538a c1538a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1538a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25563e = c1538a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25563e.a.f25554c == null) {
                    return;
                }
                this.f25563e.a.f25554c.a();
            }
        }

        /* renamed from: c.a.t0.x3.a$a$d */
        /* loaded from: classes8.dex */
        public class d implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.t0.x3.b.b f25564b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1538a f25565c;

            public d(C1538a c1538a, Object obj, c.a.t0.x3.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1538a, obj, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25565c = c1538a;
                this.a = obj;
                this.f25564b = bVar;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f25565c.a.f25553b.g(this.a, ((int) this.f25564b.f25569c) / 1000);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C1538a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.t0.x3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f25557f) {
                if (this.a.f25554c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (n.B()) {
                        this.a.f25554c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                c.a.t0.v.d.c().a(a.k, "onAdLoadFailed", null);
            }
        }

        @Override // c.a.t0.x3.c.a.c
        public void b(c.a.t0.x3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (l.z()) {
                    this.a.f25555d.e();
                } else if (this.a.f25554c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (n.B()) {
                        this.a.f25554c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1539a(this));
                    }
                } else {
                    c.a.t0.v.d.c().a(a.k, "onAdLoadFailed", null);
                    return;
                }
                if (this.a.f25557f) {
                    this.a.f25556e.postDelayed(new b(this), 800L);
                } else if (l.z() && l.H()) {
                    this.a.f25555d.g();
                }
            }
        }

        @Override // c.a.t0.x3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.a.f25557f) {
                if (this.a.a != null && (this.a.a instanceof Activity)) {
                    c.a.t0.x3.b.b c2 = this.a.f25555d.c();
                    if (c2 != null) {
                        StatisticItem h2 = c.a.t0.v3.a.h("a064", "common_fill", true, 1);
                        if (j.a(this.a.a) != null) {
                            c.a.t0.v3.c.g().c(j.a(this.a.a).getUniqueId(), h2);
                        }
                        if (!AdToMainTabActivitySwitch.getIsOn()) {
                            this.a.f25553b.g(obj, ((int) c2.f25569c) / 1000);
                        } else {
                            Looper.myQueue().addIdleHandler(new d(this, obj, c2));
                        }
                        if (this.a.f25554c != null) {
                            this.a.f25554c.c(String.valueOf(c2.a), c2.c(), c2.a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", obj);
                c.a.t0.v.d.c().a(a.k, "onResourceLoaded", hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.t0.x3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1540a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25566e;

            public RunnableC1540a(b bVar, String str) {
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
                this.f25566e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(c.a.d.a.b.f().b()), new String[]{this.f25566e}, true);
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
            this.a = aVar;
        }

        @Override // c.a.t0.x3.d.a.d
        public void a() {
            c.a.t0.x3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.a.f25555d.c()) == null) {
                return;
            }
            if (this.a.f25554c != null) {
                this.a.f25554c.b(String.valueOf(c2.a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f25572f)) {
                return;
            }
            if (!this.a.l(c2.f25572f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a), new String[]{c2.f25572f}, true);
            } else {
                e.a().postDelayed(new RunnableC1540a(this, c2.f25572f), 500L);
            }
        }

        @Override // c.a.t0.x3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.a.getView() != null) {
                    if (this.a.getView().getHeight() == n.i(this.a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.a.f25554c != null) {
                    this.a.f25554c.onAdDismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(991172513, "Lc/a/t0/x3/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(991172513, "Lc/a/t0/x3/a;");
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
        this.f25556e = new Handler(LaunchTask.asyncLooper);
        this.f25557f = true;
        this.f25558g = false;
        this.f25559h = new C1538a(this);
        this.f25560i = new b(this);
        c.a.t0.x3.c.a aVar = new c.a.t0.x3.c.a();
        this.f25555d = aVar;
        aVar.i(this.f25559h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f25552j == null) {
                synchronized (a.class) {
                    if (f25552j == null) {
                        f25552j = new a();
                    }
                }
            }
            return f25552j;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.s0.b1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f25558g) {
                k();
                this.f25558g = false;
                return;
            }
            this.f25555d.d(true);
        }
    }

    @Override // c.a.s0.b1.a
    public void b(c.a.s0.b1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f25554c = bVar;
        }
    }

    @Override // c.a.s0.b1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.t0.x3.d.a aVar = this.f25553b;
            if (aVar == null) {
                return null;
            }
            return aVar.b();
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = this.a;
            if ((context != null || (context instanceof Activity)) && !d.c().d(k).isEmpty()) {
                for (d.a aVar : d.c().d(k)) {
                    String str = aVar.a;
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
                        this.f25559h.c(aVar.f24455b.get("data"));
                    } else if (c2 == 1) {
                        this.f25559h.a();
                    }
                }
                d.c().b(k);
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
                return !ContextCompat.checkPermissionGranted(c.a.d.a.b.f().b(), "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25558g = true;
            this.f25555d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.a = context;
                this.f25553b = new c.a.t0.x3.d.a(context, this.f25560i);
            }
            this.f25557f = true;
            this.f25555d.i(this.f25559h);
        }
    }

    @Override // c.a.s0.b1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            c.a.t0.x3.d.a aVar = this.f25553b;
            if (aVar != null) {
                aVar.c();
                this.f25553b = null;
            }
            this.f25554c = null;
            this.f25557f = false;
            this.f25556e.removeCallbacksAndMessages(null);
            c.a.t0.x3.c.a aVar2 = this.f25555d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
