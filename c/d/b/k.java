package c.d.b;

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
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.duxiaoman.okhttp3.TlsVersion;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
/* loaded from: classes9.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final h[] f28837e;

    /* renamed from: f  reason: collision with root package name */
    public static final h[] f28838f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f28839g;

    /* renamed from: h  reason: collision with root package name */
    public static final k f28840h;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f28841b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String[] f28842c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String[] f28843d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810732992, "Lc/d/b/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810732992, "Lc/d/b/k;");
                return;
            }
        }
        f28837e = new h[]{h.q, h.r, h.s, h.t, h.u, h.f28829k, h.m, h.l, h.n, h.p, h.o};
        f28838f = new h[]{h.q, h.r, h.s, h.t, h.u, h.f28829k, h.m, h.l, h.n, h.p, h.o, h.f28827i, h.f28828j, h.f28825g, h.f28826h, h.f28823e, h.f28824f, h.f28822d};
        a aVar = new a(true);
        aVar.b(f28837e);
        aVar.e(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.b(f28838f);
        aVar2.e(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar2.d(true);
        f28839g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.b(f28838f);
        aVar3.e(TlsVersion.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
        f28840h = new a(false).a();
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
        this.a = aVar.a;
        this.f28842c = aVar.f28844b;
        this.f28843d = aVar.f28845c;
        this.f28841b = aVar.f28846d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, sSLSocket, z) == null) {
            k e2 = e(sSLSocket, z);
            String[] strArr = e2.f28843d;
            if (strArr != null) {
                sSLSocket.setEnabledProtocols(strArr);
            }
            String[] strArr2 = e2.f28842c;
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
            String[] strArr = this.f28842c;
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
            if (this.a) {
                String[] strArr = this.f28843d;
                if (strArr == null || c.d.b.e0.e.A(c.d.b.e0.e.f28543g, strArr, sSLSocket.getEnabledProtocols())) {
                    String[] strArr2 = this.f28842c;
                    return strArr2 == null || c.d.b.e0.e.A(h.f28820b, strArr2, sSLSocket.getEnabledCipherSuites());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final k e(SSLSocket sSLSocket, boolean z) {
        InterceptResult invokeLZ;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, sSLSocket, z)) == null) {
            if (this.f28842c != null) {
                enabledCipherSuites = c.d.b.e0.e.y(h.f28820b, sSLSocket.getEnabledCipherSuites(), this.f28842c);
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            if (this.f28843d != null) {
                enabledProtocols = c.d.b.e0.e.y(c.d.b.e0.e.f28543g, sSLSocket.getEnabledProtocols(), this.f28843d);
            } else {
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int v = c.d.b.e0.e.v(h.f28820b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
            if (z && v != -1) {
                enabledCipherSuites = c.d.b.e0.e.h(enabledCipherSuites, supportedCipherSuites[v]);
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
                boolean z = this.a;
                if (z != kVar.a) {
                    return false;
                }
                return !z || (Arrays.equals(this.f28842c, kVar.f28842c) && Arrays.equals(this.f28843d, kVar.f28843d) && this.f28841b == kVar.f28841b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28841b : invokeV.booleanValue;
    }

    @Nullable
    public List<TlsVersion> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String[] strArr = this.f28843d;
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
            if (this.a) {
                return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + Arrays.hashCode(this.f28842c)) * 31) + Arrays.hashCode(this.f28843d)) * 31) + (!this.f28841b ? 1 : 0);
            }
            return 17;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.a) {
                String obj = this.f28842c != null ? b().toString() : "[all enabled]";
                String obj2 = this.f28843d != null ? g().toString() : "[all enabled]";
                return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f28841b + SmallTailInfo.EMOTION_SUFFIX;
            }
            return "ConnectionSpec()";
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String[] f28844b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public String[] f28845c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28846d;

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
            this.a = z;
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
                if (this.a) {
                    String[] strArr = new String[hVarArr.length];
                    for (int i2 = 0; i2 < hVarArr.length; i2++) {
                        strArr[i2] = hVarArr[i2].a;
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
                if (this.a) {
                    if (strArr.length != 0) {
                        this.f28844b = (String[]) strArr.clone();
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
                if (this.a) {
                    this.f28846d = z;
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
                if (this.a) {
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
                if (this.a) {
                    if (strArr.length != 0) {
                        this.f28845c = (String[]) strArr.clone();
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
            this.a = kVar.a;
            this.f28844b = kVar.f28842c;
            this.f28845c = kVar.f28843d;
            this.f28846d = kVar.f28841b;
        }
    }
}
