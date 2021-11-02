package b.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.TlsVersion;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final h[] f30511e;

    /* renamed from: f  reason: collision with root package name */
    public static final h[] f30512f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f30513g;

    /* renamed from: h  reason: collision with root package name */
    public static final k f30514h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f30515a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f30516b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String[] f30517c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String[] f30518d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(741423969, "Lb/d/b/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(741423969, "Lb/d/b/k;");
                return;
            }
        }
        f30511e = new h[]{h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o};
        f30512f = new h[]{h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o, h.f30501i, h.j, h.f30499g, h.f30500h, h.f30497e, h.f30498f, h.f30496d};
        a aVar = new a(true);
        aVar.b(f30511e);
        aVar.e(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.b(f30512f);
        aVar2.e(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar2.d(true);
        f30513g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.b(f30512f);
        aVar3.e(TlsVersion.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
        f30514h = new a(false).a();
    }

    public k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30515a = aVar.f30519a;
        this.f30517c = aVar.f30520b;
        this.f30518d = aVar.f30521c;
        this.f30516b = aVar.f30522d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, sSLSocket, z) == null) {
            k e2 = e(sSLSocket, z);
            String[] strArr = e2.f30518d;
            if (strArr != null) {
                sSLSocket.setEnabledProtocols(strArr);
            }
            String[] strArr2 = e2.f30517c;
            if (strArr2 != null) {
                sSLSocket.setEnabledCipherSuites(strArr2);
            }
        }
    }

    @Nullable
    public List<h> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] strArr = this.f30517c;
            if (strArr != null) {
                return h.b(strArr);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public boolean c(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            if (this.f30515a) {
                String[] strArr = this.f30518d;
                if (strArr == null || b.d.b.e0.e.A(b.d.b.e0.e.f30195g, strArr, sSLSocket.getEnabledProtocols())) {
                    String[] strArr2 = this.f30517c;
                    return strArr2 == null || b.d.b.e0.e.A(h.f30494b, strArr2, sSLSocket.getEnabledCipherSuites());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30515a : invokeV.booleanValue;
    }

    public final k e(SSLSocket sSLSocket, boolean z) {
        InterceptResult invokeLZ;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, sSLSocket, z)) == null) {
            if (this.f30517c != null) {
                enabledCipherSuites = b.d.b.e0.e.y(h.f30494b, sSLSocket.getEnabledCipherSuites(), this.f30517c);
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            if (this.f30518d != null) {
                enabledProtocols = b.d.b.e0.e.y(b.d.b.e0.e.f30195g, sSLSocket.getEnabledProtocols(), this.f30518d);
            } else {
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int v = b.d.b.e0.e.v(h.f30494b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
            if (z && v != -1) {
                enabledCipherSuites = b.d.b.e0.e.h(enabledCipherSuites, supportedCipherSuites[v]);
            }
            a aVar = new a(this);
            aVar.c(enabledCipherSuites);
            aVar.f(enabledProtocols);
            return aVar.a();
        }
        return (k) invokeLZ.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof k) {
                if (obj == this) {
                    return true;
                }
                k kVar = (k) obj;
                boolean z = this.f30515a;
                if (z != kVar.f30515a) {
                    return false;
                }
                return !z || (Arrays.equals(this.f30517c, kVar.f30517c) && Arrays.equals(this.f30518d, kVar.f30518d) && this.f30516b == kVar.f30516b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30516b : invokeV.booleanValue;
    }

    @Nullable
    public List<TlsVersion> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String[] strArr = this.f30518d;
            if (strArr != null) {
                return TlsVersion.forJavaNames(strArr);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f30515a) {
                return ((((527 + Arrays.hashCode(this.f30517c)) * 31) + Arrays.hashCode(this.f30518d)) * 31) + (!this.f30516b ? 1 : 0);
            }
            return 17;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f30515a) {
                String obj = this.f30517c != null ? b().toString() : "[all enabled]";
                String obj2 = this.f30518d != null ? g().toString() : "[all enabled]";
                return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f30516b + SmallTailInfo.EMOTION_SUFFIX;
            }
            return "ConnectionSpec()";
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f30519a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String[] f30520b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public String[] f30521c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30522d;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f30519a = z;
        }

        public k a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new k(this) : (k) invokeV.objValue;
        }

        public a b(h... hVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVarArr)) == null) {
                if (this.f30519a) {
                    String[] strArr = new String[hVarArr.length];
                    for (int i2 = 0; i2 < hVarArr.length; i2++) {
                        strArr[i2] = hVarArr[i2].f30502a;
                    }
                    c(strArr);
                    return this;
                }
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a c(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                if (this.f30519a) {
                    if (strArr.length != 0) {
                        this.f30520b = (String[]) strArr.clone();
                        return this;
                    }
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                if (this.f30519a) {
                    this.f30522d = z;
                    return this;
                }
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            return (a) invokeZ.objValue;
        }

        public a e(TlsVersion... tlsVersionArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tlsVersionArr)) == null) {
                if (this.f30519a) {
                    String[] strArr = new String[tlsVersionArr.length];
                    for (int i2 = 0; i2 < tlsVersionArr.length; i2++) {
                        strArr[i2] = tlsVersionArr[i2].javaName;
                    }
                    f(strArr);
                    return this;
                }
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a f(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
                if (this.f30519a) {
                    if (strArr.length != 0) {
                        this.f30521c = (String[]) strArr.clone();
                        return this;
                    }
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30519a = kVar.f30515a;
            this.f30520b = kVar.f30517c;
            this.f30521c = kVar.f30518d;
            this.f30522d = kVar.f30516b;
        }
    }
}
