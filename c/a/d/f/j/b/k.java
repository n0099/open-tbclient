package c.a.d.f.j.b;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class k implements IHttpNet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f2633b;

    /* renamed from: c  reason: collision with root package name */
    public final IHttpNet.HttpNetType f2634c;

    /* loaded from: classes.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpsURLConnection a;

        public a(k kVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                String requestProperty = this.a.getRequestProperty("Host");
                if (requestProperty == null) {
                    requestProperty = this.a.getURL().getHost();
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    public k(f fVar, IHttpNet.HttpNetType httpNetType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, httpNetType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
        this.f2634c = httpNetType;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void a(URL url, int i2, int i3) throws SocketException, ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, url, i2, i3) == null) {
            HttpURLConnection httpURLConnection = this.f2633b;
            if (httpURLConnection != null) {
                if (this.f2634c == IHttpNet.HttpNetType.GET) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    this.f2633b.setDoOutput(true);
                    this.f2633b.setDoInput(true);
                    IHttpNet.HttpNetType httpNetType = this.f2634c;
                    if (httpNetType == IHttpNet.HttpNetType.POST_FORM) {
                        this.f2633b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    } else if (httpNetType == IHttpNet.HttpNetType.POST_BYTE) {
                        this.f2633b.setRequestProperty("Content-Type", "multipart/form-data; boundary=--------7da3d81520810*");
                    }
                }
                this.f2633b.setConnectTimeout(i2);
                this.f2633b.setReadTimeout(i3);
                return;
            }
            throw new SocketException("network not available.");
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2633b.getHeaderFields() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int c() throws IOException {
        InterceptResult invokeV;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f2633b == null) {
                return 0;
            }
            IHttpNet.HttpNetType httpNetType = this.f2634c;
            if (httpNetType == IHttpNet.HttpNetType.POST_FORM) {
                String sb = i().toString();
                dataOutputStream = new DataOutputStream(this.f2633b.getOutputStream());
                try {
                    dataOutputStream.writeBytes(sb);
                    dataOutputStream.flush();
                    c.a.d.f.m.a.d(dataOutputStream);
                    return sb.length();
                } finally {
                }
            } else if (httpNetType == IHttpNet.HttpNetType.POST_BYTE) {
                dataOutputStream = new DataOutputStream(this.f2633b.getOutputStream());
                try {
                    if (this.a.b().k() != null) {
                        Iterator<BasicNameValuePair> it = this.a.b().k().iterator();
                        while (it.hasNext()) {
                            BasicNameValuePair next = it.next();
                            if (next != null) {
                                String name = next.getName();
                                String value = next.getValue();
                                if (value != null && name != null) {
                                    dataOutputStream.writeBytes("----------7da3d81520810*\r\n");
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes("\r\n");
                                }
                            }
                        }
                    }
                    if (this.a.b().f2620f != null) {
                        for (Map.Entry<String, byte[]> entry : this.a.b().f2620f.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (value2 != null) {
                                dataOutputStream.writeBytes("----------7da3d81520810*\r\n");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                    dataOutputStream.writeBytes("----------7da3d81520810*--\r\n");
                    dataOutputStream.flush();
                    return dataOutputStream.size();
                } finally {
                }
            } else {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void connect() throws IOException {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (httpURLConnection = this.f2633b) == null) {
            return;
        }
        httpURLConnection.connect();
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public URL d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HttpURLConnection httpURLConnection = this.f2633b;
            if (httpURLConnection == null) {
                return null;
            }
            return httpURLConnection.getURL();
        }
        return (URL) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.d.f.m.a.e(this.f2633b);
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void e(URL url) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, url) == null) && l.z() && l.x()) {
            try {
                String c2 = l.c();
                if (c2 == null || c2.length() <= 0) {
                    return;
                }
                if (l.F(c2) && l.D()) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("http://");
                    sb.append(c2);
                    String file = url.getFile();
                    if (file != null && file.startsWith("?")) {
                        sb.append("/");
                    }
                    sb.append(file);
                    this.f2633b = (HttpURLConnection) new URL(sb.toString()).openConnection();
                    this.a.b().a("X-Online-Host", url.getHost());
                    return;
                }
                this.f2633b = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, l.d())));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public byte[] execute() throws IOException {
        InterceptResult invokeV;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f2633b == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                InputStream inputStream = this.f2633b.getInputStream();
                while (!this.a.c().a && (read = inputStream.read(bArr)) != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (!this.a.c().a) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    c.a.d.f.m.a.d(byteArrayOutputStream);
                    c.a.d.f.m.a.c(inputStream);
                    return byteArray;
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                c.a.d.f.m.a.d(byteArrayOutputStream);
                c.a.d.f.m.a.c(null);
                throw th;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f2633b == null || this.a.b().h() == null) {
            return;
        }
        for (Map.Entry<String, String> entry : this.a.b().h().entrySet()) {
            this.f2633b.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void g(URL url, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, url, z) == null) {
            try {
                if (this.f2633b == null) {
                    this.f2633b = (HttpURLConnection) url.openConnection();
                }
                if (z && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.f2633b;
                    httpsURLConnection.setSSLSocketFactory(new j(httpsURLConnection));
                    httpsURLConnection.setHostnameVerifier(new a(this, httpsURLConnection));
                    this.f2633b = httpsURLConnection;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HttpURLConnection httpURLConnection = this.f2633b;
            return httpURLConnection == null ? "" : httpURLConnection.getContentEncoding();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HttpURLConnection httpURLConnection = this.f2633b;
            if (httpURLConnection == null) {
                return 0L;
            }
            return httpURLConnection.getContentLength();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HttpURLConnection httpURLConnection = this.f2633b;
            return httpURLConnection == null ? "" : httpURLConnection.getContentType();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HttpURLConnection httpURLConnection = this.f2633b;
            if (httpURLConnection == null) {
                return 0;
            }
            return httpURLConnection.getResponseCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void h() throws IOException {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (httpURLConnection = this.f2633b) != null && c.a.d.f.j.c.b.c(httpURLConnection.getContentType())) {
            this.f2633b.disconnect();
            this.f2633b.connect();
            if (this.a.c().a) {
                throw new BdHttpCancelException();
            }
        }
    }

    public final StringBuilder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder(1024);
            LinkedList<BasicNameValuePair> k = this.a.b().k();
            if (k == null) {
                return sb;
            }
            int i2 = 0;
            Iterator<BasicNameValuePair> it = k.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(m.getUrlEncode(value));
                    i2++;
                }
            }
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }
}
