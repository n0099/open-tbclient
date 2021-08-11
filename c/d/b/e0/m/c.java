package c.d.b.e0.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
/* loaded from: classes4.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class.forName("org.conscrypt.Conscrypt");
                if (Conscrypt.isAvailable()) {
                    return new c();
                }
                return null;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return (c) invokeV.objValue;
    }

    @Override // c.d.b.e0.m.g
    public void g(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sSLSocketFactory) == null) && Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // c.d.b.e0.m.g
    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket, str, list) == null) {
            if (Conscrypt.isConscrypt(sSLSocket)) {
                if (str != null) {
                    Conscrypt.setUseSessionTickets(sSLSocket, true);
                    Conscrypt.setHostname(sSLSocket, str);
                }
                Conscrypt.setApplicationProtocols(sSLSocket, (String[]) g.b(list).toArray(new String[0]));
                return;
            }
            super.h(sSLSocket, str, list);
        }
    }

    @Override // c.d.b.e0.m.g
    public SSLContext o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return SSLContext.getInstance("TLSv1.3", z());
            } catch (NoSuchAlgorithmException e2) {
                try {
                    return SSLContext.getInstance("TLS", z());
                } catch (NoSuchAlgorithmException unused) {
                    throw new IllegalStateException("No TLS provider", e2);
                }
            }
        }
        return (SSLContext) invokeV.objValue;
    }

    @Override // c.d.b.e0.m.g
    @Nullable
    public String p(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sSLSocket)) == null) {
            if (Conscrypt.isConscrypt(sSLSocket)) {
                return Conscrypt.getApplicationProtocol(sSLSocket);
            }
            return super.p(sSLSocket);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.d.b.e0.m.g
    @Nullable
    public X509TrustManager x(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sSLSocketFactory)) == null) {
            if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
                return super.x(sSLSocketFactory);
            }
            try {
                Object w = g.w(sSLSocketFactory, Object.class, "sslParameters");
                if (w != null) {
                    return (X509TrustManager) g.w(w, X509TrustManager.class, "x509TrustManager");
                }
                return null;
            } catch (Exception e2) {
                throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e2);
            }
        }
        return (X509TrustManager) invokeL.objValue;
    }

    public final Provider z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Conscrypt.newProviderBuilder().provideTrustManager().build() : (Provider) invokeV.objValue;
    }
}
