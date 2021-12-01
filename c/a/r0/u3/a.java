package c.a.r0.u3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import c.a.d.f.m.e;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.r0.u3.c.a;
import c.a.r0.u3.d.a;
import c.a.r0.v.d;
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
/* loaded from: classes7.dex */
public class a implements c.a.q0.a1.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static a f24544j = null;

    /* renamed from: k  reason: collision with root package name */
    public static String f24545k = "normal";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.u3.d.a f24546b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.a1.b f24547c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.u3.c.a f24548d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f24549e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24550f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24551g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f24552h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f24553i;

    /* renamed from: c.a.r0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1396a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.u3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1397a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1396a f24554e;

            public RunnableC1397a(C1396a c1396a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1396a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24554e = c1396a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24554e.a.f24547c == null) {
                    return;
                }
                this.f24554e.a.f24547c.a();
            }
        }

        /* renamed from: c.a.r0.u3.a$a$b */
        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1396a f24555e;

            public b(C1396a c1396a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1396a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24555e = c1396a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f24555e.a.f24548d.g();
                }
            }
        }

        /* renamed from: c.a.r0.u3.a$a$c */
        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1396a f24556e;

            public c(C1396a c1396a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1396a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24556e = c1396a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24556e.a.f24547c == null) {
                    return;
                }
                this.f24556e.a.f24547c.a();
            }
        }

        /* renamed from: c.a.r0.u3.a$a$d */
        /* loaded from: classes7.dex */
        public class d implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.u3.b.b f24557b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1396a f24558c;

            public d(C1396a c1396a, Object obj, c.a.r0.u3.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1396a, obj, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24558c = c1396a;
                this.a = obj;
                this.f24557b = bVar;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f24558c.a.f24546b.g(this.a, ((int) this.f24557b.f24562c) / 1000);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C1396a(a aVar) {
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

        @Override // c.a.r0.u3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f24550f) {
                if (this.a.f24547c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (l.B()) {
                        this.a.f24547c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                c.a.r0.v.d.c().a(a.f24545k, "onAdLoadFailed", null);
            }
        }

        @Override // c.a.r0.u3.c.a.c
        public void b(c.a.r0.u3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.a.f24548d.e();
                } else if (this.a.f24547c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (l.B()) {
                        this.a.f24547c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1397a(this));
                    }
                } else {
                    c.a.r0.v.d.c().a(a.f24545k, "onAdLoadFailed", null);
                    return;
                }
                if (this.a.f24550f) {
                    this.a.f24549e.postDelayed(new b(this), 800L);
                } else if (j.z() && j.H()) {
                    this.a.f24548d.g();
                }
            }
        }

        @Override // c.a.r0.u3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.a.f24550f) {
                if (this.a.a != null && (this.a.a instanceof Activity)) {
                    c.a.r0.u3.b.b c2 = this.a.f24548d.c();
                    if (c2 != null) {
                        StatisticItem h2 = c.a.r0.s3.a.h("a064", "common_fill", true, 1);
                        if (c.a.d.a.j.a(this.a.a) != null) {
                            c.a.r0.s3.c.g().c(c.a.d.a.j.a(this.a.a).getUniqueId(), h2);
                        }
                        if (!AdToMainTabActivitySwitch.getIsOn()) {
                            this.a.f24546b.g(obj, ((int) c2.f24562c) / 1000);
                        } else {
                            Looper.myQueue().addIdleHandler(new d(this, obj, c2));
                        }
                        if (this.a.f24547c != null) {
                            this.a.f24547c.c(String.valueOf(c2.a), c2.c(), c2.a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", obj);
                c.a.r0.v.d.c().a(a.f24545k, "onResourceLoaded", hashMap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.u3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1398a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24559e;

            public RunnableC1398a(b bVar, String str) {
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
                this.f24559e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(c.a.d.a.b.g().b()), new String[]{this.f24559e}, true);
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

        @Override // c.a.r0.u3.d.a.d
        public void a() {
            c.a.r0.u3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.a.f24548d.c()) == null) {
                return;
            }
            if (this.a.f24547c != null) {
                this.a.f24547c.b(String.valueOf(c2.a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f24565f)) {
                return;
            }
            if (!this.a.l(c2.f24565f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.a.a), new String[]{c2.f24565f}, true);
            } else {
                e.a().postDelayed(new RunnableC1398a(this, c2.f24565f), 500L);
            }
        }

        @Override // c.a.r0.u3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.a.getView() != null) {
                    if (this.a.getView().getHeight() == l.i(this.a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.a.f24547c != null) {
                    this.a.f24547c.onAdDismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1797748576, "Lc/a/r0/u3/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1797748576, "Lc/a/r0/u3/a;");
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
        this.f24549e = new Handler(LaunchTask.asyncLooper);
        this.f24550f = true;
        this.f24551g = false;
        this.f24552h = new C1396a(this);
        this.f24553i = new b(this);
        c.a.r0.u3.c.a aVar = new c.a.r0.u3.c.a();
        this.f24548d = aVar;
        aVar.i(this.f24552h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f24544j == null) {
                synchronized (a.class) {
                    if (f24544j == null) {
                        f24544j = new a();
                    }
                }
            }
            return f24544j;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.q0.a1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f24551g) {
                k();
                this.f24551g = false;
                return;
            }
            this.f24548d.d(true);
        }
    }

    @Override // c.a.q0.a1.a
    public void b(c.a.q0.a1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f24547c = bVar;
        }
    }

    @Override // c.a.q0.a1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.u3.d.a aVar = this.f24546b;
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
            if ((context != null || (context instanceof Activity)) && !d.c().d(f24545k).isEmpty()) {
                for (d.a aVar : d.c().d(f24545k)) {
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
                        this.f24552h.c(aVar.f24582b.get("data"));
                    } else if (c2 == 1) {
                        this.f24552h.a();
                    }
                }
                d.c().b(f24545k);
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
                return !ContextCompat.checkPermissionGranted(c.a.d.a.b.g().b(), "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24551g = true;
            this.f24548d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.a = context;
                this.f24546b = new c.a.r0.u3.d.a(context, this.f24553i);
            }
            this.f24550f = true;
            this.f24548d.i(this.f24552h);
        }
    }

    @Override // c.a.q0.a1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            c.a.r0.u3.d.a aVar = this.f24546b;
            if (aVar != null) {
                aVar.c();
                this.f24546b = null;
            }
            this.f24547c = null;
            this.f24550f = false;
            this.f24549e.removeCallbacksAndMessages(null);
            c.a.r0.u3.c.a aVar2 = this.f24548d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
