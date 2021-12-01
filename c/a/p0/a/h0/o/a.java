package c.a.p0.a.h0.o;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.y1.c.f.c;
import c.a.p0.a.y1.c.f.e;
import com.baidu.android.imsdk.internal.Constants;
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
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static f f5841b;

    /* renamed from: c  reason: collision with root package name */
    public static g f5842c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5843d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0300a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f5844b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5845c;

        public C0300a(a aVar, e eVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5845c = aVar;
            this.a = eVar;
            this.f5844b = prefetchEvent;
        }

        @Override // c.a.p0.a.h0.o.a.d
        public void a(c.a.p0.a.y1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (a.f5843d || !cVar.D()) {
                this.f5845c.f(cVar, this.f5844b, this.a);
            } else {
                this.a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.y1.c.f.c.b
        public void a(c.a.p0.a.y1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.a.a(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.p0.a.h0.c.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y1.c.f.c f5846b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f5847c;

        public c(a aVar, c.a.p0.a.y1.c.f.c cVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5846b = cVar;
            this.f5847c = eVar;
        }

        @Override // c.a.p0.a.h0.c.a.a, c.a.p0.a.h0.c.a.b.InterfaceC0255b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                boolean z = a.f5843d && this.f5846b.D();
                if (this.f5846b.R() || z) {
                    this.f5847c.a(this.f5846b, null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(c.a.p0.a.y1.c.f.c cVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(@NonNull c.a.p0.a.y1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes.dex */
    public static class f implements e.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.y1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, c.a.p0.a.y1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) {
                PrefetchEvent prefetchEvent = cVar.f8907j;
                if (prefetchEvent == null) {
                    return false;
                }
                return TextUtils.equals(str, prefetchEvent.appId);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ f(C0300a c0300a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class g implements e.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.y1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, c.a.p0.a.y1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) ? cVar.D() && TextUtils.equals(str, cVar.f8904g) : invokeLL.booleanValue;
        }

        public /* synthetic */ g(C0300a c0300a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087106986, "Lc/a/p0/a/h0/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087106986, "Lc/a/p0/a/h0/o/a;");
                return;
            }
        }
        a = k.a;
        f5841b = new f(null);
        f5842c = new g(null);
        f5843d = c.a.p0.a.h0.o.e.a.p();
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
            }
        }
    }

    public static c.a.p0.a.y1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, prefetchEvent)) == null) ? c.a.p0.a.y1.c.f.e.k().p(prefetchEvent.appId, f5841b) : (c.a.p0.a.y1.c.f.c) invokeL.objValue;
    }

    public static c.a.p0.a.y1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, prefetchEvent)) == null) ? c.a.p0.a.y1.c.f.e.k().p(prefetchEvent.appId, f5842c) : (c.a.p0.a.y1.c.f.c) invokeL.objValue;
    }

    public final void e(@NonNull c.a.p0.a.y1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, prefetchEvent, eVar) == null) {
            c.a.p0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
        }
    }

    public final void f(@NonNull c.a.p0.a.y1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, prefetchEvent, eVar) == null) {
            e(cVar, prefetchEvent, eVar);
        }
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent, eVar) == null) {
            h(prefetchEvent, new C0300a(this, eVar, prefetchEvent));
        }
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, prefetchEvent, dVar) == null) {
            c.a.p0.a.y1.c.f.c d2 = d(prefetchEvent);
            if (d2 != null) {
                dVar.a(d2);
                return;
            }
            c.a.p0.a.y1.c.f.c c2 = c(prefetchEvent);
            if (c2 != null && c2.R()) {
                dVar.a(c2);
                return;
            }
            c.a.p0.a.y1.c.f.c e2 = c.a.p0.a.y1.c.f.e.k().e();
            if (e2.D()) {
                boolean z = a;
                dVar.a(null);
            } else if (e2.R()) {
                boolean z2 = a;
                dVar.a(e2);
            } else {
                e2.j0(new b(this, dVar));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "8");
                c.a.p0.a.y1.c.f.b.m(c.a.p0.a.c1.a.c(), e2, bundle);
            }
        }
    }
}
