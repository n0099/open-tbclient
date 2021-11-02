package b.a.p0.a.h0.l;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import b.a.p0.a.l0.g;
import b.a.p0.a.l0.j;
import com.baidu.android.imsdk.internal.Constants;
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
    public static final boolean f5414d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.l0.a f5415a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.y.a f5416b;

    /* renamed from: c  reason: collision with root package name */
    public j f5417c;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5418a;

        /* renamed from: b  reason: collision with root package name */
        public String f5419b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f5420c;

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
            this.f5420c = dVar;
            this.f5418a = str;
            this.f5419b = str2;
            if (d.f5414d) {
                String str3 = "basePath: " + str + ", jsFile: " + str2;
            }
        }

        @Override // b.a.p0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5419b : (String) invokeV.objValue;
        }

        @Override // b.a.p0.a.l0.n.a, b.a.p0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (d.f5414d) {
                    String str = "pathList item: " + this.f5418a;
                }
                return b.a.p0.a.h0.d.a.a("appframe", this.f5418a);
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // b.a.p0.a.l0.n.a, b.a.p0.a.l0.n.b
        public void c(b.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                if (this.f5420c.f5417c != null) {
                    this.f5420c.f5417c.a(aVar);
                }
                aVar.y0();
            }
        }

        @Override // b.a.p0.a.l0.n.a, b.a.p0.a.l0.n.b
        public void d(b.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f5420c.f5416b.b(aVar, b.a.p0.a.c1.a.b());
            }
        }

        @Override // b.a.p0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5418a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597551883, "Lb/a/p0/a/h0/l/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597551883, "Lb/a/p0/a/h0/l/d;");
                return;
            }
        }
        f5414d = k.f6397a;
    }

    public d(@NonNull String str, @NonNull String str2) {
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
        this.f5416b = new b.a.p0.a.y.a();
        this.f5415a = b.a.p0.a.l0.f.c(e(), new a(this, str, str2), b.a.p0.a.r1.l.e.m() ? new f() : null);
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f5416b.a(activity);
        }
    }

    public g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g.b bVar = new g.b();
            bVar.c(1);
            bVar.b(b.a.p0.a.h0.l.g.e.b());
            return bVar.a();
        }
        return (g) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f5415a.k0();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5415a.f6493g : (String) invokeV.objValue;
    }

    public b.a.p0.a.l0.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5415a : (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSCacheCallback) == null) {
            this.f5415a.B0(jSCacheCallback);
        }
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, codeCacheSetting) == null) {
            this.f5415a.C0(codeCacheSetting);
        }
    }

    public void k(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jVar) == null) {
            this.f5417c = jVar;
        }
    }
}
