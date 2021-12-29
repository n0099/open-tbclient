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
    public static a f26336j = null;

    /* renamed from: k  reason: collision with root package name */
    public static String f26337k = "normal";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.x3.d.a f26338b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.b1.b f26339c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.x3.c.a f26340d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f26341e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26342f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26343g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f26344h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f26345i;

    /* renamed from: c.a.t0.x3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1522a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.t0.x3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1523a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1522a f26346e;

            public RunnableC1523a(C1522a c1522a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1522a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26346e = c1522a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26346e.a.f26339c == null) {
                    return;
                }
                this.f26346e.a.f26339c.a();
            }
        }

        /* renamed from: c.a.t0.x3.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1522a f26347e;

            public b(C1522a c1522a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1522a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26347e = c1522a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && l.z() && l.H()) {
                    this.f26347e.a.f26340d.g();
                }
            }
        }

        /* renamed from: c.a.t0.x3.a$a$c */
        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1522a f26348e;

            public c(C1522a c1522a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1522a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26348e = c1522a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26348e.a.f26339c == null) {
                    return;
                }
                this.f26348e.a.f26339c.a();
            }
        }

        /* renamed from: c.a.t0.x3.a$a$d */
        /* loaded from: classes8.dex */
        public class d implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.t0.x3.b.b f26349b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1522a f26350c;

            public d(C1522a c1522a, Object obj, c.a.t0.x3.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1522a, obj, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26350c = c1522a;
                this.a = obj;
                this.f26349b = bVar;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f26350c.a.f26338b.g(this.a, ((int) this.f26349b.f26354c) / 1000);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C1522a(a aVar) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f26342f) {
                if (this.a.f26339c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (n.B()) {
                        this.a.f26339c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                c.a.t0.v.d.c().a(a.f26337k, "onAdLoadFailed", null);
            }
        }

        @Override // c.a.t0.x3.c.a.c
        public void b(c.a.t0.x3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (l.z()) {
                    this.a.f26340d.e();
                } else if (this.a.f26339c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (n.B()) {
                        this.a.f26339c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1523a(this));
                    }
                } else {
                    c.a.t0.v.d.c().a(a.f26337k, "onAdLoadFailed", null);
                    return;
                }
                if (this.a.f26342f) {
                    this.a.f26341e.postDelayed(new b(this), 800L);
                } else if (l.z() && l.H()) {
                    this.a.f26340d.g();
                }
            }
        }

        @Override // c.a.t0.x3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.a.f26342f) {
                if (this.a.a != null && (this.a.a instanceof Activity)) {
                    c.a.t0.x3.b.b c2 = this.a.f26340d.c();
                    if (c2 != null) {
                        StatisticItem h2 = c.a.t0.v3.a.h("a064", "common_fill", true, 1);
                        if (j.a(this.a.a) != null) {
                            c.a.t0.v3.c.g().c(j.a(this.a.a).getUniqueId(), h2);
                        }
                        if (!AdToMainTabActivitySwitch.getIsOn()) {
                            this.a.f26338b.g(obj, ((int) c2.f26354c) / 1000);
                        } else {
                            Looper.myQueue().addIdleHandler(new d(this, obj, c2));
                        }
                        if (this.a.f26339c != null) {
                            this.a.f26339c.c(String.valueOf(c2.a), c2.c(), c2.a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", obj);
                c.a.t0.v.d.c().a(a.f26337k, "onResourceLoaded", hashMap);
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
        public class RunnableC1524a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f26351e;

            public RunnableC1524a(b bVar, String str) {
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
                this.f26351e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(c.a.d.a.b.g().b()), new String[]{this.f26351e}, true);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.a.f26340d.c()) == null) {
                return;
            }
            if (this.a.f26339c != null) {
                this.a.f26339c.b(String.valueOf(c2.a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f26357f)) {
                return;
            }
            if (!this.a.l(c2.f26357f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a), new String[]{c2.f26357f}, true);
            } else {
                e.a().postDelayed(new RunnableC1524a(this, c2.f26357f), 500L);
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
                if (this.a.f26339c != null) {
                    this.a.f26339c.onAdDismiss();
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
        this.f26341e = new Handler(LaunchTask.asyncLooper);
        this.f26342f = true;
        this.f26343g = false;
        this.f26344h = new C1522a(this);
        this.f26345i = new b(this);
        c.a.t0.x3.c.a aVar = new c.a.t0.x3.c.a();
        this.f26340d = aVar;
        aVar.i(this.f26344h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f26336j == null) {
                synchronized (a.class) {
                    if (f26336j == null) {
                        f26336j = new a();
                    }
                }
            }
            return f26336j;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.s0.b1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f26343g) {
                k();
                this.f26343g = false;
                return;
            }
            this.f26340d.d(true);
        }
    }

    @Override // c.a.s0.b1.a
    public void b(c.a.s0.b1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f26339c = bVar;
        }
    }

    @Override // c.a.s0.b1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.t0.x3.d.a aVar = this.f26338b;
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
            if ((context != null || (context instanceof Activity)) && !d.c().d(f26337k).isEmpty()) {
                for (d.a aVar : d.c().d(f26337k)) {
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
                        this.f26344h.c(aVar.f25158b.get("data"));
                    } else if (c2 == 1) {
                        this.f26344h.a();
                    }
                }
                d.c().b(f26337k);
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
            this.f26343g = true;
            this.f26340d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.a = context;
                this.f26338b = new c.a.t0.x3.d.a(context, this.f26345i);
            }
            this.f26342f = true;
            this.f26340d.i(this.f26344h);
        }
    }

    @Override // c.a.s0.b1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            c.a.t0.x3.d.a aVar = this.f26338b;
            if (aVar != null) {
                aVar.c();
                this.f26338b = null;
            }
            this.f26339c = null;
            this.f26342f = false;
            this.f26341e.removeCallbacksAndMessages(null);
            c.a.t0.x3.c.a aVar2 = this.f26340d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
