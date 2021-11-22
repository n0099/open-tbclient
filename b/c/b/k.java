package b.c.b;

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
    public static final h[] f31369e;

    /* renamed from: f  reason: collision with root package name */
    public static final h[] f31370f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f31371g;

    /* renamed from: h  reason: collision with root package name */
    public static final k f31372h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31373a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f31374b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String[] f31375c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String[] f31376d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712794818, "Lb/c/b/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712794818, "Lb/c/b/k;");
                return;
            }
        }
        f31369e = new h[]{h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o};
        f31370f = new h[]{h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o, h.f31359i, h.j, h.f31357g, h.f31358h, h.f31355e, h.f31356f, h.f31354d};
        a aVar = new a(true);
        aVar.b(f31369e);
        aVar.e(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.b(f31370f);
        aVar2.e(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar2.d(true);
        f31371g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.b(f31370f);
        aVar3.e(TlsVersion.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
        f31372h = new a(false).a();
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
        this.f31373a = aVar.f31377a;
        this.f31375c = aVar.f31378b;
        this.f31376d = aVar.f31379c;
        this.f31374b = aVar.f31380d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, sSLSocket, z) == null) {
            k e2 = e(sSLSocket, z);
            String[] strArr = e2.f31376d;
            if (strArr != null) {
                sSLSocket.setEnabledProtocols(strArr);
            }
            String[] strArr2 = e2.f31375c;
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
            String[] strArr = this.f31375c;
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
            if (this.f31373a) {
                String[] strArr = this.f31376d;
                if (strArr == null || b.c.b.e0.e.A(b.c.b.e0.e.f31053g, strArr, sSLSocket.getEnabledProtocols())) {
                    String[] strArr2 = this.f31375c;
                    return strArr2 == null || b.c.b.e0.e.A(h.f31352b, strArr2, sSLSocket.getEnabledCipherSuites());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31373a : invokeV.booleanValue;
    }

    public final k e(SSLSocket sSLSocket, boolean z) {
        InterceptResult invokeLZ;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, sSLSocket, z)) == null) {
            if (this.f31375c != null) {
                enabledCipherSuites = b.c.b.e0.e.y(h.f31352b, sSLSocket.getEnabledCipherSuites(), this.f31375c);
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            if (this.f31376d != null) {
                enabledProtocols = b.c.b.e0.e.y(b.c.b.e0.e.f31053g, sSLSocket.getEnabledProtocols(), this.f31376d);
            } else {
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int v = b.c.b.e0.e.v(h.f31352b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
            if (z && v != -1) {
                enabledCipherSuites = b.c.b.e0.e.h(enabledCipherSuites, supportedCipherSuites[v]);
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
                boolean z = this.f31373a;
                if (z != kVar.f31373a) {
                    return false;
                }
                return !z || (Arrays.equals(this.f31375c, kVar.f31375c) && Arrays.equals(this.f31376d, kVar.f31376d) && this.f31374b == kVar.f31374b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31374b : invokeV.booleanValue;
    }

    @Nullable
    public List<TlsVersion> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String[] strArr = this.f31376d;
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
            if (this.f31373a) {
                return ((((527 + Arrays.hashCode(this.f31375c)) * 31) + Arrays.hashCode(this.f31376d)) * 31) + (!this.f31374b ? 1 : 0);
            }
            return 17;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f31373a) {
                String obj = this.f31375c != null ? b().toString() : "[all enabled]";
                String obj2 = this.f31376d != null ? g().toString() : "[all enabled]";
                return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f31374b + SmallTailInfo.EMOTION_SUFFIX;
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
        public boolean f31377a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String[] f31378b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public String[] f31379c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31380d;

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
            this.f31377a = z;
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
                if (this.f31377a) {
                    String[] strArr = new String[hVarArr.length];
                    for (int i2 = 0; i2 < hVarArr.length; i2++) {
                        strArr[i2] = hVarArr[i2].f31360a;
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
                if (this.f31377a) {
                    if (strArr.length != 0) {
                        this.f31378b = (String[]) strArr.clone();
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
                if (this.f31377a) {
                    this.f31380d = z;
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
                if (this.f31377a) {
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
                if (this.f31377a) {
                    if (strArr.length != 0) {
                        this.f31379c = (String[]) strArr.clone();
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
            this.f31377a = kVar.f31373a;
            this.f31378b = kVar.f31375c;
            this.f31379c = kVar.f31376d;
            this.f31380d = kVar.f31374b;
        }
    }
}
