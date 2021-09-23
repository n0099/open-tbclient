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
    public static a f21759j = null;
    public static String k = "normal";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21760a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.k3.d.a f21761b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.a1.b f21762c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.k3.c.a f21763d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f21764e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21765f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21766g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f21767h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f21768i;

    /* renamed from: c.a.r0.k3.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1017a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21769a;

        /* renamed from: c.a.r0.k3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1018a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1017a f21770e;

            public RunnableC1018a(C1017a c1017a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1017a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21770e = c1017a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21770e.f21769a.f21762c == null) {
                    return;
                }
                this.f21770e.f21769a.f21762c.a();
            }
        }

        /* renamed from: c.a.r0.k3.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1017a f21771e;

            public b(C1017a c1017a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1017a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21771e = c1017a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f21771e.f21769a.f21763d.g();
                }
            }
        }

        /* renamed from: c.a.r0.k3.a$a$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1017a f21772e;

            public c(C1017a c1017a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1017a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21772e = c1017a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21772e.f21769a.f21762c == null) {
                    return;
                }
                this.f21772e.f21769a.f21762c.a();
            }
        }

        public C1017a(a aVar) {
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
            this.f21769a = aVar;
        }

        @Override // c.a.r0.k3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21769a.f21765f) {
                if (this.f21769a.f21762c != null && this.f21769a.f21760a != null && (this.f21769a.f21760a instanceof Activity)) {
                    if (l.C()) {
                        this.f21769a.f21762c.a();
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
                    this.f21769a.f21763d.e();
                } else if (this.f21769a.f21762c != null && this.f21769a.f21760a != null && (this.f21769a.f21760a instanceof Activity)) {
                    if (l.C()) {
                        this.f21769a.f21762c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1018a(this));
                    }
                } else {
                    c.a.r0.q.b.c().a(a.k, "onAdLoadFailed", null);
                    return;
                }
                if (this.f21769a.f21765f) {
                    this.f21769a.f21764e.postDelayed(new b(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f21769a.f21763d.g();
                }
            }
        }

        @Override // c.a.r0.k3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f21769a.f21765f) {
                if (this.f21769a.f21760a != null && (this.f21769a.f21760a instanceof Activity)) {
                    c.a.r0.k3.b.b c2 = this.f21769a.f21763d.c();
                    if (c2 != null) {
                        StatisticItem h2 = c.a.r0.i3.a.h("a064", "common_fill", true, 1);
                        if (c.a.e.a.j.a(this.f21769a.f21760a) != null) {
                            c.a.r0.i3.c.g().c(c.a.e.a.j.a(this.f21769a.f21760a).getUniqueId(), h2);
                        }
                        this.f21769a.f21761b.g(obj, ((int) c2.f21779c) / 1000);
                        if (this.f21769a.f21762c != null) {
                            this.f21769a.f21762c.c(String.valueOf(c2.f21777a), c2.c(), c2.a());
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
        public final /* synthetic */ a f21773a;

        /* renamed from: c.a.r0.k3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1019a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f21774e;

            public RunnableC1019a(b bVar, String str) {
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
                this.f21774e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(c.a.e.a.b.f().b()), new String[]{this.f21774e}, true);
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
            this.f21773a = aVar;
        }

        @Override // c.a.r0.k3.d.a.d
        public void a() {
            c.a.r0.k3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f21773a.f21763d.c()) == null) {
                return;
            }
            if (this.f21773a.f21762c != null) {
                this.f21773a.f21762c.b(String.valueOf(c2.f21777a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f21782f)) {
                return;
            }
            if (!this.f21773a.l(c2.f21782f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(this.f21773a.f21760a), new String[]{c2.f21782f}, true);
            } else {
                e.a().postDelayed(new RunnableC1019a(this, c2.f21782f), 500L);
            }
        }

        @Override // c.a.r0.k3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f21773a.getView() != null) {
                    if (this.f21773a.getView().getHeight() == l.i(this.f21773a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f21773a.f21762c != null) {
                    this.f21773a.f21762c.onAdDismiss();
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
        this.f21764e = new Handler(LaunchTask.asyncLooper);
        this.f21765f = true;
        this.f21766g = false;
        this.f21767h = new C1017a(this);
        this.f21768i = new b(this);
        c.a.r0.k3.c.a aVar = new c.a.r0.k3.c.a();
        this.f21763d = aVar;
        aVar.i(this.f21767h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f21759j == null) {
                synchronized (a.class) {
                    if (f21759j == null) {
                        f21759j = new a();
                    }
                }
            }
            return f21759j;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.q0.a1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21766g) {
                k();
                this.f21766g = false;
                return;
            }
            this.f21763d.d(true);
        }
    }

    @Override // c.a.q0.a1.a
    public void b(c.a.q0.a1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f21762c = bVar;
        }
    }

    @Override // c.a.q0.a1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21761b.b() : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = this.f21760a;
            if ((context != null || (context instanceof Activity)) && !c.a.r0.q.b.c().d(k).isEmpty()) {
                for (b.a aVar : c.a.r0.q.b.c().d(k)) {
                    String str = aVar.f24088a;
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
                        this.f21767h.c(aVar.f24089b.get("data"));
                    } else if (c2 == 1) {
                        this.f21767h.a();
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
            this.f21766g = true;
            this.f21763d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.f21760a = context;
                this.f21761b = new c.a.r0.k3.d.a(context, this.f21768i);
            }
            this.f21765f = true;
            this.f21763d.i(this.f21767h);
        }
    }

    @Override // c.a.q0.a1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21760a = null;
            c.a.r0.k3.d.a aVar = this.f21761b;
            if (aVar != null) {
                aVar.c();
                this.f21761b = null;
            }
            this.f21762c = null;
            this.f21765f = false;
            this.f21764e.removeCallbacksAndMessages(null);
            c.a.r0.k3.c.a aVar2 = this.f21763d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
