package c.a.o0.a.h0.o;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.v1.c.f.c;
import c.a.o0.a.v1.c.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6249a;

    /* renamed from: b  reason: collision with root package name */
    public static f f6250b;

    /* renamed from: c  reason: collision with root package name */
    public static g f6251c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6252d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0236a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f6253a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f6254b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6255c;

        public C0236a(a aVar, e eVar, PrefetchEvent prefetchEvent) {
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
            this.f6255c = aVar;
            this.f6253a = eVar;
            this.f6254b = prefetchEvent;
        }

        @Override // c.a.o0.a.h0.o.a.d
        public void a(c.a.o0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (a.f6252d || !cVar.C()) {
                this.f6255c.f(cVar, this.f6254b, this.f6253a);
            } else {
                this.f6253a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6256a;

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
            this.f6256a = dVar;
        }

        @Override // c.a.o0.a.v1.c.f.c.b
        public void a(c.a.o0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f6256a.a(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.o0.a.h0.c.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v1.c.f.c f6257b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f6258c;

        public c(a aVar, c.a.o0.a.v1.c.f.c cVar, e eVar) {
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
            this.f6257b = cVar;
            this.f6258c = eVar;
        }

        @Override // c.a.o0.a.h0.c.a.a, c.a.o0.a.h0.c.a.b.InterfaceC0195b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                boolean z = a.f6252d && this.f6257b.C();
                if (this.f6257b.G() || z) {
                    this.f6258c.a(this.f6257b, null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(c.a.o0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(@NonNull c.a.o0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
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
        @Override // c.a.o0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, c.a.o0.a.v1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) {
                PrefetchEvent prefetchEvent = cVar.f9240j;
                if (prefetchEvent == null) {
                    return false;
                }
                return TextUtils.equals(str, prefetchEvent.appId);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ f(C0236a c0236a) {
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
        @Override // c.a.o0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, c.a.o0.a.v1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) ? cVar.C() && TextUtils.equals(str, cVar.f9237g) : invokeLL.booleanValue;
        }

        public /* synthetic */ g(C0236a c0236a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(958024267, "Lc/a/o0/a/h0/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(958024267, "Lc/a/o0/a/h0/o/a;");
                return;
            }
        }
        f6249a = k.f7049a;
        f6250b = new f(null);
        f6251c = new g(null);
        f6252d = c.a.o0.a.h0.o.e.a.m();
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

    public static c.a.o0.a.v1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, prefetchEvent)) == null) ? c.a.o0.a.v1.c.f.e.k().p(prefetchEvent.appId, f6250b) : (c.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public static c.a.o0.a.v1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, prefetchEvent)) == null) ? c.a.o0.a.v1.c.f.e.k().p(prefetchEvent.appId, f6251c) : (c.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public final void e(@NonNull c.a.o0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, prefetchEvent, eVar) == null) {
            c.a.o0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
        }
    }

    public final void f(@NonNull c.a.o0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, prefetchEvent, eVar) == null) {
            e(cVar, prefetchEvent, eVar);
        }
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent, eVar) == null) {
            h(prefetchEvent, new C0236a(this, eVar, prefetchEvent));
        }
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, prefetchEvent, dVar) == null) {
            c.a.o0.a.v1.c.f.c d2 = d(prefetchEvent);
            if (d2 != null) {
                dVar.a(d2);
                return;
            }
            c.a.o0.a.v1.c.f.c c2 = c(prefetchEvent);
            if (c2 != null && c2.G()) {
                dVar.a(c2);
                return;
            }
            c.a.o0.a.v1.c.f.c e2 = c.a.o0.a.v1.c.f.e.k().e();
            if (e2.C()) {
                boolean z = f6249a;
                dVar.a(null);
            } else if (e2.G()) {
                boolean z2 = f6249a;
                dVar.a(e2);
            } else {
                e2.Y(new b(this, dVar));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "8");
                c.a.o0.a.v1.c.f.b.m(c.a.o0.a.c1.a.b(), e2, bundle);
            }
        }
    }
}
