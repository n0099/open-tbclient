package c.a.r0.a.h0.l;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.l0.g;
import c.a.r0.a.l0.h;
import c.a.r0.a.l0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6693d;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.l0.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.y.a f6694b;

    /* renamed from: c  reason: collision with root package name */
    public k f6695c;

    /* loaded from: classes.dex */
    public class a extends c.a.r0.a.l0.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f6696b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f6697c;

        public a(@NonNull d dVar, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6697c = dVar;
            this.a = str;
            this.f6696b = str2;
            if (d.f6693d) {
                String str3 = "basePath: " + str + ", jsFile: " + str2;
            }
        }

        @Override // c.a.r0.a.l0.p.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6696b : (String) invokeV.objValue;
        }

        @Override // c.a.r0.a.l0.p.a, c.a.r0.a.l0.p.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (d.f6693d) {
                    String str = "pathList item: " + this.a;
                }
                return c.a.r0.a.h0.d.a.a("appframe", this.a);
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // c.a.r0.a.l0.p.a, c.a.r0.a.l0.p.b
        public void c(c.a.r0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                if (this.f6697c.f6695c != null) {
                    this.f6697c.f6695c.a(aVar);
                }
                aVar.A0();
            }
        }

        @Override // c.a.r0.a.l0.p.a, c.a.r0.a.l0.p.b
        public void d(c.a.r0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f6697c.f6694b.b(aVar, c.a.r0.a.c1.a.c());
            }
        }

        @Override // c.a.r0.a.l0.p.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1345183144, "Lc/a/r0/a/h0/l/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1345183144, "Lc/a/r0/a/h0/l/d;");
                return;
            }
        }
        f6693d = c.a.r0.a.k.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull String str, @NonNull String str2) {
        this(str, str2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f6694b.a(activity);
        }
    }

    public h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.b bVar = new h.b();
            bVar.c(1);
            bVar.b(c.a.r0.a.h0.l.g.e.b());
            return bVar.a();
        }
        return (h) invokeV.objValue;
    }

    public c.a.r0.a.l0.p.a f(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? new a(this, str, str2) : (c.a.r0.a.l0.p.a) invokeLL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.m0();
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.f7734g : (String) invokeV.objValue;
    }

    public c.a.r0.a.l0.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (c.a.r0.a.l0.a) invokeV.objValue;
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, codeCacheSetting) == null) {
            this.a.D0(codeCacheSetting);
        }
    }

    public void k(JsCodeCacheCallback jsCodeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsCodeCacheCallback) == null) {
            this.a.H0(jsCodeCacheCallback);
        }
    }

    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kVar) == null) {
            this.f6695c = kVar;
        }
    }

    public d(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f6694b = new c.a.r0.a.y.a();
        if (f6693d) {
            String str4 = "createV8Master: " + str + str2;
        }
        f fVar = c.a.r0.a.u1.l.e.l() ? new f() : null;
        h e2 = e();
        if (!TextUtils.isEmpty(str3)) {
            e2.f7745b = str3;
        }
        this.a = g.b(e2, f(str, str2), fVar);
    }
}
