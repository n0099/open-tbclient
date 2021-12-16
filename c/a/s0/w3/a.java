package c.a.s0.w3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import c.a.d.a.j;
import c.a.d.f.m.e;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.s0.v.d;
import c.a.s0.w3.c.a;
import c.a.s0.w3.d.a;
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
public class a implements c.a.r0.a1.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static a f25288j = null;

    /* renamed from: k  reason: collision with root package name */
    public static String f25289k = "normal";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.w3.d.a f25290b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a1.b f25291c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.s0.w3.c.a f25292d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f25293e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25294f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25295g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f25296h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f25297i;

    /* renamed from: c.a.s0.w3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1465a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.s0.w3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1466a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1465a f25298e;

            public RunnableC1466a(C1465a c1465a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1465a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25298e = c1465a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25298e.a.f25291c == null) {
                    return;
                }
                this.f25298e.a.f25291c.a();
            }
        }

        /* renamed from: c.a.s0.w3.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1465a f25299e;

            public b(C1465a c1465a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1465a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25299e = c1465a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k.z() && k.H()) {
                    this.f25299e.a.f25292d.g();
                }
            }
        }

        /* renamed from: c.a.s0.w3.a$a$c */
        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1465a f25300e;

            public c(C1465a c1465a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1465a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25300e = c1465a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25300e.a.f25291c == null) {
                    return;
                }
                this.f25300e.a.f25291c.a();
            }
        }

        /* renamed from: c.a.s0.w3.a$a$d */
        /* loaded from: classes8.dex */
        public class d implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.w3.b.b f25301b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1465a f25302c;

            public d(C1465a c1465a, Object obj, c.a.s0.w3.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1465a, obj, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25302c = c1465a;
                this.a = obj;
                this.f25301b = bVar;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f25302c.a.f25290b.g(this.a, ((int) this.f25301b.f25306c) / 1000);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C1465a(a aVar) {
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

        @Override // c.a.s0.w3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f25294f) {
                if (this.a.f25291c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (m.B()) {
                        this.a.f25291c.a();
                        return;
                    } else {
                        e.a().postAtFrontOfQueue(new c(this));
                        return;
                    }
                }
                c.a.s0.v.d.c().a(a.f25289k, "onAdLoadFailed", null);
            }
        }

        @Override // c.a.s0.w3.c.a.c
        public void b(c.a.s0.w3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (k.z()) {
                    this.a.f25292d.e();
                } else if (this.a.f25291c != null && this.a.a != null && (this.a.a instanceof Activity)) {
                    if (m.B()) {
                        this.a.f25291c.a();
                    } else {
                        e.a().postAtFrontOfQueue(new RunnableC1466a(this));
                    }
                } else {
                    c.a.s0.v.d.c().a(a.f25289k, "onAdLoadFailed", null);
                    return;
                }
                if (this.a.f25294f) {
                    this.a.f25293e.postDelayed(new b(this), 800L);
                } else if (k.z() && k.H()) {
                    this.a.f25292d.g();
                }
            }
        }

        @Override // c.a.s0.w3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.a.f25294f) {
                if (this.a.a != null && (this.a.a instanceof Activity)) {
                    c.a.s0.w3.b.b c2 = this.a.f25292d.c();
                    if (c2 != null) {
                        StatisticItem h2 = c.a.s0.u3.a.h("a064", "common_fill", true, 1);
                        if (j.a(this.a.a) != null) {
                            c.a.s0.u3.c.g().c(j.a(this.a.a).getUniqueId(), h2);
                        }
                        if (!AdToMainTabActivitySwitch.getIsOn()) {
                            this.a.f25290b.g(obj, ((int) c2.f25306c) / 1000);
                        } else {
                            Looper.myQueue().addIdleHandler(new d(this, obj, c2));
                        }
                        if (this.a.f25291c != null) {
                            this.a.f25291c.c(String.valueOf(c2.a), c2.c(), c2.a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", obj);
                c.a.s0.v.d.c().a(a.f25289k, "onResourceLoaded", hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.s0.w3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1467a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25303e;

            public RunnableC1467a(b bVar, String str) {
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
                this.f25303e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(c.a.d.a.b.g().b()), new String[]{this.f25303e}, true);
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

        @Override // c.a.s0.w3.d.a.d
        public void a() {
            c.a.s0.w3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.a.f25292d.c()) == null) {
                return;
            }
            if (this.a.f25291c != null) {
                this.a.f25291c.b(String.valueOf(c2.a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f25309f)) {
                return;
            }
            if (!this.a.l(c2.f25309f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a), new String[]{c2.f25309f}, true);
            } else {
                e.a().postDelayed(new RunnableC1467a(this, c2.f25309f), 500L);
            }
        }

        @Override // c.a.s0.w3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.a.getView() != null) {
                    if (this.a.getView().getHeight() == m.i(this.a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.a.f25291c != null) {
                    this.a.f25291c.onAdDismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-752561343, "Lc/a/s0/w3/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-752561343, "Lc/a/s0/w3/a;");
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
        this.f25293e = new Handler(LaunchTask.asyncLooper);
        this.f25294f = true;
        this.f25295g = false;
        this.f25296h = new C1465a(this);
        this.f25297i = new b(this);
        c.a.s0.w3.c.a aVar = new c.a.s0.w3.c.a();
        this.f25292d = aVar;
        aVar.i(this.f25296h);
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f25288j == null) {
                synchronized (a.class) {
                    if (f25288j == null) {
                        f25288j = new a();
                    }
                }
            }
            return f25288j;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.r0.a1.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f25295g) {
                k();
                this.f25295g = false;
                return;
            }
            this.f25292d.d(true);
        }
    }

    @Override // c.a.r0.a1.a
    public void b(c.a.r0.a1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f25291c = bVar;
        }
    }

    @Override // c.a.r0.a1.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.s0.w3.d.a aVar = this.f25290b;
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
            if ((context != null || (context instanceof Activity)) && !d.c().d(f25289k).isEmpty()) {
                for (d.a aVar : d.c().d(f25289k)) {
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
                        this.f25296h.c(aVar.f24646b.get("data"));
                    } else if (c2 == 1) {
                        this.f25296h.a();
                    }
                }
                d.c().b(f25289k);
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
            this.f25295g = true;
            this.f25292d.d(false);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (context != null) {
                this.a = context;
                this.f25290b = new c.a.s0.w3.d.a(context, this.f25297i);
            }
            this.f25294f = true;
            this.f25292d.i(this.f25296h);
        }
    }

    @Override // c.a.r0.a1.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            c.a.s0.w3.d.a aVar = this.f25290b;
            if (aVar != null) {
                aVar.c();
                this.f25290b = null;
            }
            this.f25291c = null;
            this.f25294f = false;
            this.f25293e.removeCallbacksAndMessages(null);
            c.a.s0.w3.c.a aVar2 = this.f25292d;
            if (aVar2 != null) {
                aVar2.h();
            }
        }
    }
}
