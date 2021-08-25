package c.d.b.e0.l;

import c.d.b.q;
import c.d.b.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public final class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final OkHttpURLConnection f31910b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(URL url, w wVar, c.d.b.e0.d dVar) {
        this(new OkHttpURLConnection(url, wVar, dVar));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, wVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((OkHttpURLConnection) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.d.b.e0.l.b
    public q a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            OkHttpURLConnection okHttpURLConnection = this.f31910b;
            if (okHttpURLConnection.f69064e != null) {
                return okHttpURLConnection.o;
            }
            throw new IllegalStateException("Connection has not yet been established");
        }
        return (q) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31910b.f69060a.q() : (HostnameVerifier) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31910b.f69060a.G() : (SSLSocketFactory) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hostnameVerifier) == null) {
            OkHttpURLConnection okHttpURLConnection = this.f31910b;
            w.b v = okHttpURLConnection.f69060a.v();
            v.j(hostnameVerifier);
            okHttpURLConnection.f69060a = v.a();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sSLSocketFactory) == null) {
            if (sSLSocketFactory != null) {
                OkHttpURLConnection okHttpURLConnection = this.f31910b;
                w.b v = okHttpURLConnection.f69060a.v();
                v.o(sSLSocketFactory);
                okHttpURLConnection.f69060a = v.a();
                return;
            }
            throw new IllegalArgumentException("sslSocketFactory == null");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpURLConnection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((HttpURLConnection) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31910b = okHttpURLConnection;
    }
}
