package c.d.b.e0.m;

import androidx.core.view.InputDeviceCompat;
import c.d.b.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g f32055a;

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f32056b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090345046, "Lc/d/b/e0/m/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090345046, "Lc/d/b/e0/m/g;");
                return;
            }
        }
        f32055a = l();
        f32056b = Logger.getLogger(w.class.getName());
    }

    public g() {
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

    public static List<String> b(List<Protocol> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Protocol protocol = list.get(i2);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static byte[] f(List<Protocol> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            Buffer buffer = new Buffer();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Protocol protocol = list.get(i2);
                if (protocol != Protocol.HTTP_1_0) {
                    buffer.writeByte(protocol.toString().length());
                    buffer.writeUtf8(protocol.toString());
                }
            }
            return buffer.readByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            g A = a.A();
            if (A != null) {
                return A;
            }
            g A2 = b.A();
            if (A2 != null) {
                return A2;
            }
            throw new NullPointerException("No platform found on Android");
        }
        return (g) invokeV.objValue;
    }

    public static g k() {
        InterceptResult invokeV;
        c y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (!t() || (y = c.y()) == null) {
                d y2 = d.y();
                if (y2 != null) {
                    return y2;
                }
                g y3 = e.y();
                return y3 != null ? y3 : new g();
            }
            return y;
        }
        return (g) invokeV.objValue;
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (r()) {
                return j();
            }
            return k();
        }
        return (g) invokeV.objValue;
    }

    public static g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f32055a : (g) invokeV.objValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? "Dalvik".equals(System.getProperty("java.vm.name")) : invokeV.booleanValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
                return true;
            }
            return "Conscrypt".equals(Security.getProviders()[0].getName());
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static <T> T w(Object obj, Class<T> cls, String str) {
        InterceptResult invokeLLL;
        Object w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, obj, cls, str)) == null) {
            for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null && cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                    return null;
                } catch (IllegalAccessException unused) {
                    throw new AssertionError();
                } catch (NoSuchFieldException unused2) {
                }
            }
            if (str.equals("delegate") || (w = w(obj, Object.class, "delegate")) == null) {
                return null;
            }
            return (T) w(w, cls, str);
        }
        return (T) invokeLLL.objValue;
    }

    public void a(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sSLSocket) == null) {
        }
    }

    public c.d.b.e0.o.c c(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocketFactory)) == null) {
            X509TrustManager x = x(sSLSocketFactory);
            if (x != null) {
                return d(x);
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + m() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }
        return (c.d.b.e0.o.c) invokeL.objValue;
    }

    public c.d.b.e0.o.c d(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x509TrustManager)) == null) ? new c.d.b.e0.o.a(e(x509TrustManager)) : (c.d.b.e0.o.c) invokeL.objValue;
    }

    public c.d.b.e0.o.e e(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, x509TrustManager)) == null) ? new c.d.b.e0.o.b(x509TrustManager.getAcceptedIssuers()) : (c.d.b.e0.o.e) invokeL.objValue;
    }

    public void g(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sSLSocketFactory) == null) {
        }
    }

    public void h(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, sSLSocket, str, list) == null) {
        }
    }

    public void i(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, socket, inetSocketAddress, i2) == null) {
            socket.connect(inetSocketAddress, i2);
        }
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "OkHttp" : (String) invokeV.objValue;
    }

    public SSLContext o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if ("1.7".equals(System.getProperty("java.specification.version"))) {
                try {
                    return SSLContext.getInstance("TLSv1.2");
                } catch (NoSuchAlgorithmException unused) {
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

    @Nullable
    public String p(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, sSLSocket)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public Object q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (f32056b.isLoggable(Level.FINE)) {
                return new Throwable(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getClass().getSimpleName() : (String) invokeV.objValue;
    }

    public void u(int i2, String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i2, str, th) == null) {
            f32056b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
        }
    }

    public void v(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, obj) == null) {
            if (obj == null) {
                str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
            }
            u(5, str, (Throwable) obj);
        }
    }

    @Nullable
    public X509TrustManager x(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, sSLSocketFactory)) == null) {
            try {
                Object w = w(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
                if (w == null) {
                    return null;
                }
                return (X509TrustManager) w(w, X509TrustManager.class, "trustManager");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return (X509TrustManager) invokeL.objValue;
    }
}
