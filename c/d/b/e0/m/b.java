package c.d.b.e0.m;

import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes4.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f32050c;

    /* renamed from: d  reason: collision with root package name */
    public final f<Socket> f32051d;

    /* renamed from: e  reason: collision with root package name */
    public final f<Socket> f32052e;

    /* renamed from: f  reason: collision with root package name */
    public final f<Socket> f32053f;

    /* renamed from: g  reason: collision with root package name */
    public final f<Socket> f32054g;

    /* renamed from: h  reason: collision with root package name */
    public final c f32055h;

    /* loaded from: classes4.dex */
    public static final class a extends c.d.b.e0.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Object f32056a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f32057b;

        public a(Object obj, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32056a = obj;
            this.f32057b = method;
        }

        @Override // c.d.b.e0.o.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
                try {
                    return (List) this.f32057b.invoke(this.f32056a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                } catch (InvocationTargetException e3) {
                    SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                    sSLPeerUnverifiedException.initCause(e3);
                    throw sSLPeerUnverifiedException;
                }
            }
            return (List) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? obj instanceof a : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* renamed from: c.d.b.e0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1456b implements c.d.b.e0.o.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f32058a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f32059b;

        public C1456b(X509TrustManager x509TrustManager, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32059b = method;
            this.f32058a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C1456b) {
                    C1456b c1456b = (C1456b) obj;
                    return this.f32058a.equals(c1456b.f32058a) && this.f32059b.equals(c1456b.f32059b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.d.b.e0.o.e
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509Certificate)) == null) {
                try {
                    TrustAnchor trustAnchor = (TrustAnchor) this.f32059b.invoke(this.f32058a, x509Certificate);
                    if (trustAnchor != null) {
                        return trustAnchor.getTrustedCert();
                    }
                    return null;
                } catch (IllegalAccessException e2) {
                    throw c.d.b.e0.e.b("unable to get issues and signature", e2);
                } catch (InvocationTargetException unused) {
                    return null;
                }
            }
            return (X509Certificate) invokeL.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32058a.hashCode() + (this.f32059b.hashCode() * 31) : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Method f32060a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f32061b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f32062c;

        public c(Method method, Method method2, Method method3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {method, method2, method3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32060a = method;
            this.f32061b = method2;
            this.f32062c = method3;
        }

        public static c b() {
            InterceptResult invokeV;
            Method method;
            Method method2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                Method method3 = null;
                try {
                    Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                    Method method4 = cls.getMethod("get", new Class[0]);
                    method2 = cls.getMethod("open", String.class);
                    method = cls.getMethod("warnIfOpen", new Class[0]);
                    method3 = method4;
                } catch (Exception unused) {
                    method = null;
                    method2 = null;
                }
                return new c(method3, method2, method);
            }
            return (c) invokeV.objValue;
        }

        public Object a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Method method = this.f32060a;
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, new Object[0]);
                        this.f32061b.invoke(invoke, str);
                        return invoke;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return invokeL.objValue;
        }

        public boolean c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj != null) {
                    try {
                        this.f32062c.invoke(obj, new Object[0]);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public b(Class<?> cls, f<Socket> fVar, f<Socket> fVar2, f<Socket> fVar3, f<Socket> fVar4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, fVar, fVar2, fVar3, fVar4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32055h = c.b();
        this.f32050c = cls;
        this.f32051d = fVar;
        this.f32052e = fVar2;
        this.f32053f = fVar3;
        this.f32054g = fVar4;
    }

    public static g A() {
        InterceptResult invokeV;
        Class<?> cls;
        f fVar;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g.r()) {
                try {
                    try {
                        cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                    } catch (ClassNotFoundException unused) {
                        cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                    }
                    Class<?> cls2 = cls;
                    f fVar3 = new f(null, "setUseSessionTickets", Boolean.TYPE);
                    f fVar4 = new f(null, "setHostname", String.class);
                    if (C()) {
                        f fVar5 = new f(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                        fVar2 = new f(null, "setAlpnProtocols", byte[].class);
                        fVar = fVar5;
                    } else {
                        fVar = null;
                        fVar2 = null;
                    }
                    return new b(cls2, fVar3, fVar4, fVar, fVar2);
                } catch (ClassNotFoundException unused2) {
                    return null;
                }
            }
            return null;
        }
        return (g) invokeV.objValue;
    }

    public static int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (NoClassDefFoundError unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Security.getProvider("GMSCore_OpenSSL") != null) {
                return true;
            }
            try {
                Class.forName("android.net.Network");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.d.b.e0.m.g
    public c.d.b.e0.o.c d(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x509TrustManager)) == null) {
            try {
                Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
            } catch (Exception unused) {
                return super.d(x509TrustManager);
            }
        }
        return (c.d.b.e0.o.c) invokeL.objValue;
    }

    @Override // c.d.b.e0.m.g
    public c.d.b.e0.o.e e(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509TrustManager)) == null) {
            try {
                Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                declaredMethod.setAccessible(true);
                return new C1456b(x509TrustManager, declaredMethod);
            } catch (NoSuchMethodException unused) {
                return super.e(x509TrustManager);
            }
        }
        return (c.d.b.e0.o.e) invokeL.objValue;
    }

    @Override // c.d.b.e0.m.g
    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket, str, list) == null) {
            if (str != null) {
                this.f32051d.e(sSLSocket, Boolean.TRUE);
                this.f32052e.e(sSLSocket, str);
            }
            f<Socket> fVar = this.f32054g;
            if (fVar == null || !fVar.g(sSLSocket)) {
                return;
            }
            this.f32054g.f(sSLSocket, g.f(list));
        }
    }

    @Override // c.d.b.e0.m.g
    public void i(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, socket, inetSocketAddress, i2) == null) {
            try {
                socket.connect(inetSocketAddress, i2);
            } catch (AssertionError e2) {
                if (!c.d.b.e0.e.z(e2)) {
                    throw e2;
                }
                throw new IOException(e2);
            } catch (ClassCastException e3) {
                if (Build.VERSION.SDK_INT == 26) {
                    IOException iOException = new IOException("Exception in connect");
                    iOException.initCause(e3);
                    throw iOException;
                }
                throw e3;
            } catch (SecurityException e4) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e4);
                throw iOException2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L10;
     */
    @Override // c.d.b.e0.m.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SSLContext o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean z = true;
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                }
                z = false;
            } catch (NoClassDefFoundError unused) {
            }
            if (z) {
                try {
                    return SSLContext.getInstance("TLSv1.2");
                } catch (NoSuchAlgorithmException unused2) {
                }
            }
            try {
                return SSLContext.getInstance("TLS");
            } catch (NoSuchAlgorithmException e2) {
                throw new IllegalStateException("No TLS provider", e2);
            }
        }
        return (SSLContext) invokeV.objValue;
    }

    @Override // c.d.b.e0.m.g
    @Nullable
    public String p(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sSLSocket)) == null) {
            f<Socket> fVar = this.f32053f;
            if (fVar == null || !fVar.g(sSLSocket) || (bArr = (byte[]) this.f32053f.f(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, c.d.b.e0.e.f31785d);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.d.b.e0.m.g
    public Object q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f32055h.a(str) : invokeL.objValue;
    }

    @Override // c.d.b.e0.m.g
    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.s(str);
            }
            try {
                Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                return z(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return super.s(str);
            } catch (IllegalAccessException e2) {
                e = e2;
                throw c.d.b.e0.e.b("unable to determine cleartext support", e);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw c.d.b.e0.e.b("unable to determine cleartext support", e);
            } catch (InvocationTargetException e4) {
                e = e4;
                throw c.d.b.e0.e.b("unable to determine cleartext support", e);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.d.b.e0.m.g
    public void u(int i2, String str, @Nullable Throwable th) {
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str, th) == null) {
            int i3 = i2 != 5 ? 3 : 5;
            if (th != null) {
                str = str + '\n' + Log.getStackTraceString(th);
            }
            int i4 = 0;
            int length = str.length();
            while (i4 < length) {
                int indexOf = str.indexOf(10, i4);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i4 + 4000);
                    Log.println(i3, "OkHttp", str.substring(i4, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i4 = min;
                }
                i4 = min + 1;
            }
        }
    }

    @Override // c.d.b.e0.m.g
    public void v(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, obj) == null) || this.f32055h.c(obj)) {
            return;
        }
        u(5, str, null);
    }

    @Override // c.d.b.e0.m.g
    @Nullable
    public X509TrustManager x(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, sSLSocketFactory)) == null) {
            Object w = g.w(sSLSocketFactory, this.f32050c, "sslParameters");
            if (w == null) {
                try {
                    w = g.w(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException unused) {
                    return super.x(sSLSocketFactory);
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) g.w(w, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) g.w(w, X509TrustManager.class, "trustManager");
        }
        return (X509TrustManager) invokeL.objValue;
    }

    public final boolean y(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, cls, obj)) == null) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
            } catch (NoSuchMethodException unused) {
                return super.s(str);
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean z(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, str, cls, obj)) == null) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
            } catch (NoSuchMethodException unused) {
                return y(str, cls, obj);
            }
        }
        return invokeLLL.booleanValue;
    }
}
