package b.a.r0.n3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import b.a.e.f.m.e;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.r0.n3.c.a;
import b.a.r0.n3.d.a;
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
public class a implements b.a.q0.z0.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static a j = null;
    public static String k = "normal";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f22994a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.n3.d.a f22995b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.z0.b f22996c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.r0.n3.c.a f22997d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f22998e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22999f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23000g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f23001h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f23002i;

    /* renamed from: b.a.r0.n3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1118a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23003a;

        /* renamed from: b.a.r0.n3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1119a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1118a f23004e;

            public RunnableC1119a(C1118a c1118a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1118a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23004e = c1118a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23004e.f23003a.f22996c == null) {
                    return;
                }
                this.f23004e.f23003a.f22996c.a();
            }
        }

        /* renamed from: b.a.r0.n3.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1118a f23005e;

            public b(C1118a c1118a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1118a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23005e = c1118a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f23005e.f23003a.f22997d.g();
                }
            }
        }

        /* renamed from: b.a.r0.n3.a$a$c */
        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1118a f23006e;

            public c(C1118a c1118a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1118a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23006e = c1118a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23006e.f23003a.f22996c == null) {
                    return;
                }
                this.f23006e.f23003a.f22996c.a();
            }
        }

        /* renamed from: b.a.r0.n3.a$a$d */
        /* loaded from: classes5.dex */
        public class d implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f23007a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.n3.b.b f23008b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1118a f23009c;

            public d(C1118a c1118a, Object obj, b.a.r0.n3.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1118a, obj, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23009c = c1118a;
                this.f23007a = obj;
                this.f23008b = bVar;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f23009c.f23003a.f22995b.g(this.f23007a, ((int) this.f23008b.f23016c) / 1000);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C1118a(a aVar) {
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
            this.f23003a = aVar;
        }

        @Override // b.a.r0.n3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23003a.f22999f) {
                if (this.f23003a.f22996c != null && this.f23003a.f22994a != null && (this.f23003a.f22994a instanceof Activity)) {
                    if (l.C()) {
                        this.f23003a.f22996c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                b.a.r0.r.b.c().a(a.k, "onAdLoadFailed", null);
            }
        }

        @Override // b.a.r0.n3.c.a.c
        public void b(b.a.r0.n3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f23003a.f22997d.e();
                } else if (this.f23003a.f22996c != null && this.f23003a.f22994a != null && (this.f23003a.f22994a instanceof Activity)) {
                    if (l.C()) {
                        this.f23003a.f22996c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1119a(this));
                    }
                } else {
                    b.a.r0.r.b.c().a(a.k, "onAdLoadFailed", null);
                    return;
                }
                if (this.f23003a.f22999f) {
                    this.f23003a.f22998e.postDelayed(new b(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f23003a.f22997d.g();
                }
            }
        }

        @Override // b.a.r0.n3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f23003a.f22999f) {
                if (this.f23003a.f22994a != null && (this.f23003a.f22994a instanceof Activity)) {
                    b.a.r0.n3.b.b c2 = this.f23003a.f22997d.c();
                    if (c2 != null) {
                        StatisticItem h2 = b.a.r0.l3.a.h("a064", "common_fill", true, 1);
                        if (b.a.e.a.j.a(this.f23003a.f22994a) != null) {
                            b.a.r0.l3.c.g().c(b.a.e.a.j.a(this.f23003a.f22994a).getUniqueId(), h2);
                        }
                        if (!AdToMainTabActivitySwitch.getIsOn()) {
                            this.f23003a.f22995b.g(obj, ((int) c2.f23016c) / 1000);
                        } else {
                            Looper.myQueue().addIdleHandler(new d(this, obj, c2));
                        }
                        if (this.f23003a.f22996c != null) {
                            this.f23003a.f22996c.c(String.valueOf(c2.f23014a), c2.c(), c2.a());
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
        public final /* synthetic */ a f23010a;

        /* renamed from: b.a.r0.n3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1120a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f23011e;

            public RunnableC1120a(b bVar, String str) {
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
                this.f23011e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) b.a.e.a.j.a(b.a.e.a.b.g().b()), new String[]{this.f23011e}, true);
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
            this.f23010a = aVar;
        }

        @Override // b.a.r0.n3.d.a.d
        public void a() {
            b.a.r0.n3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f23010a.f22997d.c()) == null) {
                return;
            }
            if (this.f23010a.f22996c != null) {
                this.f23010a.f22996c.b(String.valueOf(c2.f23014a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f23019f)) {
                return;
            }
            if (!this.f23010a.l(c2.f23019f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) b.a.e.a.j.a(this.f23010a.f22994a), new String[]{c2.f23019f}, true);
            } else {
                e.a().postDelayed(new RunnableC1120a(this, c2.f23019f), 500L);
            }
        }

        @Override // b.a.r0.n3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f23010a.getView() != null) {
                    if (this.f23010a.getView().getHeight() == l.i(this.f23010a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f23010a.f22996c != null) {
                    this.f23010a.f22996c.onAdDismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1662201210, "Lb/a/r0/n3/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1662201210, "Lb/a/r0/n3/a;");
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
        this.f22998e = new Handler(LaunchTask.asyncLooper);
        this.f22999f = true;
        this.f23000g = false;
        this.f23001h = new C1118a(this);
        this.f23002i = new b(this);
        b.a.r0.n3.c.a aVar = new b.a.r0.n3.c.a();
        this.f22997d = aVar;
        aVar.i(this.f23001h);
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

    @Override // b.a.q0.z0.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f23000g) {
                k();
                this.f23000g = false;
                return;
            }
            this.f22997d.d(true);
        }
    }

    @Override // b.a.q0.z0.a
    public void b(b.a.q0.z0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f22996c = bVar;
        }
    }

    @Override // b.a.q0.z0.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.r0.n3.d.a aVar = this.f22995b;
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
            Context context = this.f22994a;
            if ((context != null || (context instanceof Activity)) && !b.a.r0.r.b.c().d(k).isEmpty()) {
                for (b.a aVar : b.a.r0.r.b.c().d(k)) {
                    String str = aVar.f24467a;
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
                        this.f23001h.c(aVar.f24468b.get("data"));
                    } else if (c2 == 1) {
                        this.f23001h.a();
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
            this.f23000g = true;
            this.f22997d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.f22994a = context;
                this.f22995b = new b.a.r0.n3.d.a(context, this.f23002i);
            }
            this.f22999f = true;
            this.f22997d.i(this.f23001h);
        }
    }

    @Override // b.a.q0.z0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f22994a = null;
            b.a.r0.n3.d.a aVar = this.f22995b;
            if (aVar != null) {
                aVar.c();
                this.f22995b = null;
            }
            this.f22996c = null;
            this.f22999f = false;
            this.f22998e.removeCallbacksAndMessages(null);
            b.a.r0.n3.c.a aVar2 = this.f22997d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
