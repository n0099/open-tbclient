package c.a.o0.a.h0.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.k;
import c.a.o0.a.l0.g;
import c.a.o0.a.l0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6027c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.l0.a f6028a;

    /* renamed from: b  reason: collision with root package name */
    public j f6029b;

    /* loaded from: classes.dex */
    public class a extends c.a.o0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6030a;

        /* renamed from: b  reason: collision with root package name */
        public String f6031b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f6032c;

        public a(@NonNull c cVar, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6032c = cVar;
            this.f6030a = str;
            this.f6031b = str2;
            if (c.f6027c) {
                String str3 = "basePath: " + str + ", jsFile: " + str2;
            }
        }

        @Override // c.a.o0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6031b : (String) invokeV.objValue;
        }

        @Override // c.a.o0.a.l0.n.a, c.a.o0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.b() : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // c.a.o0.a.l0.n.a, c.a.o0.a.l0.n.b
        public void c(c.a.o0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                if (this.f6032c.f6029b != null) {
                    this.f6032c.f6029b.a(aVar);
                }
                aVar.y0();
            }
        }

        @Override // c.a.o0.a.l0.n.a, c.a.o0.a.l0.n.b
        public void d(c.a.o0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                super.d(aVar);
            }
        }

        @Override // c.a.o0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6030a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957905165, "Lc/a/o0/a/h0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957905165, "Lc/a/o0/a/h0/k/c;");
                return;
            }
        }
        f6027c = k.f7049a;
    }

    public c(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6028a = c.a.o0.a.l0.f.c(c(), new a(this, str, str2), null);
        this.f6028a.addJavascriptInterface(new b(this.f6028a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g.b bVar = new g.b();
            bVar.c(3);
            bVar.b(c.a.o0.a.h0.k.a.b());
            return bVar.a();
        }
        return (g) invokeV.objValue;
    }

    public c.a.o0.a.l0.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6028a : (c.a.o0.a.l0.a) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.a.l0.a aVar = this.f6028a;
            if (aVar != null) {
                aVar.k0();
                this.f6028a = null;
            }
            this.f6029b = null;
        }
    }

    public void f(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
            this.f6029b = jVar;
        }
    }
}
