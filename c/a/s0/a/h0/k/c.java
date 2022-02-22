package c.a.s0.a.h0.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.a.l0.g;
import c.a.s0.a.l0.h;
import c.a.s0.a.l0.k;
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
    public static final boolean f6789c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.a.l0.a a;

    /* renamed from: b  reason: collision with root package name */
    public k f6790b;

    /* loaded from: classes.dex */
    public class a extends c.a.s0.a.l0.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f6791b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f6792c;

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
            this.f6792c = cVar;
            this.a = str;
            this.f6791b = str2;
            if (c.f6789c) {
                String str3 = "basePath: " + str + ", jsFile: " + str2;
            }
        }

        @Override // c.a.s0.a.l0.p.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6791b : (String) invokeV.objValue;
        }

        @Override // c.a.s0.a.l0.p.a, c.a.s0.a.l0.p.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.b() : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // c.a.s0.a.l0.p.a, c.a.s0.a.l0.p.b
        public void c(c.a.s0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                if (this.f6792c.f6790b != null) {
                    this.f6792c.f6790b.a(aVar);
                }
                aVar.A0();
            }
        }

        @Override // c.a.s0.a.l0.p.a, c.a.s0.a.l0.p.b
        public void d(c.a.s0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                super.d(aVar);
            }
        }

        @Override // c.a.s0.a.l0.p.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1474236041, "Lc/a/s0/a/h0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1474236041, "Lc/a/s0/a/h0/k/c;");
                return;
            }
        }
        f6789c = c.a.s0.a.k.a;
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
        this.a = g.b(c(), new a(this, str, str2), null);
        this.a.addJavascriptInterface(new b(this.a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h.b bVar = new h.b();
            bVar.c(3);
            bVar.b(c.a.s0.a.h0.k.a.b());
            return bVar.a();
        }
        return (h) invokeV.objValue;
    }

    public c.a.s0.a.l0.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.s0.a.l0.a) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.a.l0.a aVar = this.a;
            if (aVar != null) {
                aVar.m0();
                this.a = null;
            }
            this.f6790b = null;
        }
    }

    public void f(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            this.f6790b = kVar;
        }
    }
}
