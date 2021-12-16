package c.d.b.e0.n;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes9.dex */
public final class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Method f28728c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f28729d;

    public d(Method method, Method method2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, method2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28728c = method;
        this.f28729d = method2;
    }

    public static d y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return new d(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (d) invokeV.objValue;
    }

    @Override // c.d.b.e0.n.g
    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sSLSocket, str, list) == null) {
            try {
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                List<String> b2 = g.b(list);
                this.f28728c.invoke(sSLParameters, b2.toArray(new String[b2.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw c.d.b.e0.e.b("unable to set ssl parameters", e2);
            }
        }
    }

    @Override // c.d.b.e0.n.g
    @Nullable
    public String p(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket)) == null) {
            try {
                String str = (String) this.f28729d.invoke(sSLSocket, new Object[0]);
                if (str != null) {
                    if (!str.equals("")) {
                        return str;
                    }
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw c.d.b.e0.e.b("failed to get ALPN selected protocol", e2);
            } catch (InvocationTargetException e3) {
                if (e3.getCause() instanceof UnsupportedOperationException) {
                    return null;
                }
                throw c.d.b.e0.e.b("failed to get ALPN selected protocol", e3);
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // c.d.b.e0.n.g
    public X509TrustManager x(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocketFactory)) == null) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
        }
        return (X509TrustManager) invokeL.objValue;
    }
}
