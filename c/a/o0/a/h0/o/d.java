package c.a.o0.a.h0.o;

import android.text.TextUtils;
import c.a.o0.a.h0.o.a;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6262c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.h0.o.a f6263a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.a.h0.o.b f6264b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f6265e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f6266f;

        public a(d dVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6266f = dVar;
            this.f6265e = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6266f.c(this.f6265e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f6267a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f6268b;

        public b(d dVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6268b = dVar;
            this.f6267a = prefetchEvent;
        }

        @Override // c.a.o0.a.h0.o.a.e
        public void a(c.a.o0.a.v1.c.f.c cVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, pMSAppInfo) == null) {
                this.f6268b.f6264b.b(this.f6267a, cVar, pMSAppInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f6269a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1538389641, "Lc/a/o0/a/h0/o/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1538389641, "Lc/a/o0/a/h0/o/d$c;");
                    return;
                }
            }
            f6269a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(958024360, "Lc/a/o0/a/h0/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(958024360, "Lc/a/o0/a/h0/o/d;");
                return;
            }
        }
        f6262c = k.f7049a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? c.f6269a : (d) invokeV.objValue;
    }

    public final void c(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, prefetchEvent) == null) {
            this.f6263a.g(prefetchEvent, new b(this, prefetchEvent));
        }
    }

    public void d(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent) == null) {
            if (f6262c) {
                String str = "fire preloadEvent abSwitch: " + c.a.o0.a.h0.o.e.a.f();
            }
            if (f(prefetchEvent)) {
                return;
            }
            if (f6262c) {
                String str2 = "firePrefetchEvent event: " + prefetchEvent;
            }
            ExecutorUtilsExt.postOnSerial(new a(this, prefetchEvent), "prefetch-event-thread");
        }
    }

    public final boolean f(PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent)) == null) ? (c.a.o0.a.h0.o.e.a.f() && prefetchEvent != null && prefetchEvent.isValid() && TextUtils.equals(prefetchEvent.state, "show")) ? false : true : invokeL.booleanValue;
    }

    public d() {
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
        this.f6263a = new c.a.o0.a.h0.o.a();
        this.f6264b = new c.a.o0.a.h0.o.b();
    }
}
