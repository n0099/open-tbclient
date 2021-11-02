package b.a.p0.a.h0.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import b.a.p0.a.l0.g;
import b.a.p0.a.l0.j;
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
    public static final boolean f5406c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.l0.a f5407a;

    /* renamed from: b  reason: collision with root package name */
    public j f5408b;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5409a;

        /* renamed from: b  reason: collision with root package name */
        public String f5410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f5411c;

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
            this.f5411c = cVar;
            this.f5409a = str;
            this.f5410b = str2;
            if (c.f5406c) {
                String str3 = "basePath: " + str + ", jsFile: " + str2;
            }
        }

        @Override // b.a.p0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5410b : (String) invokeV.objValue;
        }

        @Override // b.a.p0.a.l0.n.a, b.a.p0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.b() : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // b.a.p0.a.l0.n.a, b.a.p0.a.l0.n.b
        public void c(b.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                if (this.f5411c.f5408b != null) {
                    this.f5411c.f5408b.a(aVar);
                }
                aVar.y0();
            }
        }

        @Override // b.a.p0.a.l0.n.a, b.a.p0.a.l0.n.b
        public void d(b.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                super.d(aVar);
            }
        }

        @Override // b.a.p0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5409a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597522061, "Lb/a/p0/a/h0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597522061, "Lb/a/p0/a/h0/k/c;");
                return;
            }
        }
        f5406c = k.f6397a;
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
        this.f5407a = b.a.p0.a.l0.f.c(c(), new a(this, str, str2), null);
        this.f5407a.addJavascriptInterface(new b(this.f5407a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g.b bVar = new g.b();
            bVar.c(3);
            bVar.b(b.a.p0.a.h0.k.a.b());
            return bVar.a();
        }
        return (g) invokeV.objValue;
    }

    public b.a.p0.a.l0.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5407a : (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.a.l0.a aVar = this.f5407a;
            if (aVar != null) {
                aVar.k0();
                this.f5407a = null;
            }
            this.f5408b = null;
        }
    }

    public void f(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
            this.f5408b = jVar;
        }
    }
}
