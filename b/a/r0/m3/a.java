package b.a.r0.m3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import b.a.e.e.m.e;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.r0.m3.c.a;
import b.a.r0.m3.d.a;
import b.a.r0.r.b;
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
/* loaded from: classes5.dex */
public class a implements b.a.q0.a1.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static a j = null;
    public static String k = "normal";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21210a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.m3.d.a f21211b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.a1.b f21212c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.r0.m3.c.a f21213d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f21214e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21215f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21216g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f21217h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f21218i;

    /* renamed from: b.a.r0.m3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1040a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21219a;

        /* renamed from: b.a.r0.m3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1041a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1040a f21220e;

            public RunnableC1041a(C1040a c1040a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1040a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21220e = c1040a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21220e.f21219a.f21212c == null) {
                    return;
                }
                this.f21220e.f21219a.f21212c.a();
            }
        }

        /* renamed from: b.a.r0.m3.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1040a f21221e;

            public b(C1040a c1040a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1040a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21221e = c1040a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f21221e.f21219a.f21213d.g();
                }
            }
        }

        /* renamed from: b.a.r0.m3.a$a$c */
        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1040a f21222e;

            public c(C1040a c1040a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1040a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21222e = c1040a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21222e.f21219a.f21212c == null) {
                    return;
                }
                this.f21222e.f21219a.f21212c.a();
            }
        }

        /* renamed from: b.a.r0.m3.a$a$d */
        /* loaded from: classes5.dex */
        public class d implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f21223a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.m3.b.b f21224b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1040a f21225c;

            public d(C1040a c1040a, Object obj, b.a.r0.m3.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1040a, obj, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21225c = c1040a;
                this.f21223a = obj;
                this.f21224b = bVar;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f21225c.f21219a.f21211b.g(this.f21223a, ((int) this.f21224b.f21232c) / 1000);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C1040a(a aVar) {
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
            this.f21219a = aVar;
        }

        @Override // b.a.r0.m3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21219a.f21215f) {
                if (this.f21219a.f21212c != null && this.f21219a.f21210a != null && (this.f21219a.f21210a instanceof Activity)) {
                    if (l.C()) {
                        this.f21219a.f21212c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                b.a.r0.r.b.c().a(a.k, "onAdLoadFailed", null);
            }
        }

        @Override // b.a.r0.m3.c.a.c
        public void b(b.a.r0.m3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f21219a.f21213d.e();
                } else if (this.f21219a.f21212c != null && this.f21219a.f21210a != null && (this.f21219a.f21210a instanceof Activity)) {
                    if (l.C()) {
                        this.f21219a.f21212c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1041a(this));
                    }
                } else {
                    b.a.r0.r.b.c().a(a.k, "onAdLoadFailed", null);
                    return;
                }
                if (this.f21219a.f21215f) {
                    this.f21219a.f21214e.postDelayed(new b(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f21219a.f21213d.g();
                }
            }
        }

        @Override // b.a.r0.m3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f21219a.f21215f) {
                if (this.f21219a.f21210a != null && (this.f21219a.f21210a instanceof Activity)) {
                    b.a.r0.m3.b.b c2 = this.f21219a.f21213d.c();
                    if (c2 != null) {
                        StatisticItem h2 = b.a.r0.k3.a.h("a064", "common_fill", true, 1);
                        if (b.a.e.a.j.a(this.f21219a.f21210a) != null) {
                            b.a.r0.k3.c.g().c(b.a.e.a.j.a(this.f21219a.f21210a).getUniqueId(), h2);
                        }
                        if (!AdToMainTabActivitySwitch.getIsOn()) {
                            this.f21219a.f21211b.g(obj, ((int) c2.f21232c) / 1000);
                        } else {
                            Looper.myQueue().addIdleHandler(new d(this, obj, c2));
                        }
                        if (this.f21219a.f21212c != null) {
                            this.f21219a.f21212c.c(String.valueOf(c2.f21230a), c2.c(), c2.a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", obj);
                b.a.r0.r.b.c().a(a.k, "onResourceLoaded", hashMap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21226a;

        /* renamed from: b.a.r0.m3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1042a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f21227e;

            public RunnableC1042a(b bVar, String str) {
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
                this.f21227e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) b.a.e.a.j.a(b.a.e.a.b.g().b()), new String[]{this.f21227e}, true);
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
            this.f21226a = aVar;
        }

        @Override // b.a.r0.m3.d.a.d
        public void a() {
            b.a.r0.m3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f21226a.f21213d.c()) == null) {
                return;
            }
            if (this.f21226a.f21212c != null) {
                this.f21226a.f21212c.b(String.valueOf(c2.f21230a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f21235f)) {
                return;
            }
            if (!this.f21226a.l(c2.f21235f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) b.a.e.a.j.a(this.f21226a.f21210a), new String[]{c2.f21235f}, true);
            } else {
                e.a().postDelayed(new RunnableC1042a(this, c2.f21235f), 500L);
            }
        }

        @Override // b.a.r0.m3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f21226a.getView() != null) {
                    if (this.f21226a.getView().getHeight() == l.i(this.f21226a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f21226a.f21212c != null) {
                    this.f21226a.f21212c.onAdDismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1661277689, "Lb/a/r0/m3/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1661277689, "Lb/a/r0/m3/a;");
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
        this.f21214e = new Handler(LaunchTask.asyncLooper);
        this.f21215f = true;
        this.f21216g = false;
        this.f21217h = new C1040a(this);
        this.f21218i = new b(this);
        b.a.r0.m3.c.a aVar = new b.a.r0.m3.c.a();
        this.f21213d = aVar;
        aVar.i(this.f21217h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (j == null) {
                synchronized (a.class) {
                    if (j == null) {
                        j = new a();
                    }
                }
            }
            return j;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.q0.a1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21216g) {
                k();
                this.f21216g = false;
                return;
            }
            this.f21213d.d(true);
        }
    }

    @Override // b.a.q0.a1.a
    public void b(b.a.q0.a1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f21212c = bVar;
        }
    }

    @Override // b.a.q0.a1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21211b.b() : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = this.f21210a;
            if ((context != null || (context instanceof Activity)) && !b.a.r0.r.b.c().d(k).isEmpty()) {
                for (b.a aVar : b.a.r0.r.b.c().d(k)) {
                    String str = aVar.f22935a;
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
                        this.f21217h.c(aVar.f22936b.get("data"));
                    } else if (c2 == 1) {
                        this.f21217h.a();
                    }
                }
                b.a.r0.r.b.c().b(k);
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
                return !ContextCompat.checkPermissionGranted(b.a.e.a.b.g().b(), "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21216g = true;
            this.f21213d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.f21210a = context;
                this.f21211b = new b.a.r0.m3.d.a(context, this.f21218i);
            }
            this.f21215f = true;
            this.f21213d.i(this.f21217h);
        }
    }

    @Override // b.a.q0.a1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21210a = null;
            b.a.r0.m3.d.a aVar = this.f21211b;
            if (aVar != null) {
                aVar.c();
                this.f21211b = null;
            }
            this.f21212c = null;
            this.f21215f = false;
            this.f21214e.removeCallbacksAndMessages(null);
            b.a.r0.m3.c.a aVar2 = this.f21213d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
