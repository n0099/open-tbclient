package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public final class q implements Callable<u> {
    public static /* synthetic */ Interceptable $ic;
    public static final HttpRequestRetryHandler e;
    public transient /* synthetic */ FieldHolder $fh;
    public l a;
    public Context b;
    public o c;
    public String d;
    public HttpUriRequest f;
    public HttpContext g;
    public CookieStore h;
    public CookieManager i;
    public AbstractHttpEntity j;
    public HttpHost k;
    public URL l;
    public int m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-834063025, "Lcom/alipay/android/phone/mrpc/core/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-834063025, "Lcom/alipay/android/phone/mrpc/core/q;");
                return;
            }
        }
        e = new ad();
    }

    public q(l lVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, oVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new BasicHttpContext();
        this.h = new BasicCookieStore();
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = null;
        this.a = lVar;
        this.b = lVar.a;
        this.c = oVar;
    }

    public static long a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, strArr)) == null) {
            for (int i = 0; i < strArr.length; i++) {
                if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(strArr[i])) {
                    int i2 = i + 1;
                    if (strArr[i2] != null) {
                        try {
                            return Long.parseLong(strArr[i2]);
                        } catch (Exception unused) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        InterceptResult invokeL;
        Header[] allHeaders;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpResponse)) == null) {
            HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
            for (Header header : httpResponse.getAllHeaders()) {
                httpUrlHeader.setHead(header.getName(), header.getValue());
            }
            return httpUrlHeader;
        }
        return (HttpUrlHeader) invokeL.objValue;
    }

    private u a(HttpResponse httpResponse, int i, String str) {
        InterceptResult invokeLIL;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpResponse, i, str)) == null) {
            new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
            HttpEntity entity = httpResponse.getEntity();
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            String str3 = null;
            if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
                if (entity == null) {
                    httpResponse.getStatusLine().getStatusCode();
                    return null;
                }
                return null;
            }
            new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a(entity, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.o = false;
                this.a.c(System.currentTimeMillis() - currentTimeMillis);
                this.a.a(byteArray.length);
                new StringBuilder("res:").append(byteArray.length);
                p pVar = new p(a(httpResponse), i, str, byteArray);
                long b = b(httpResponse);
                Header contentType = httpResponse.getEntity().getContentType();
                if (contentType != null) {
                    HashMap<String, String> a = a(contentType.getValue());
                    str3 = a.get("charset");
                    str2 = a.get("Content-Type");
                } else {
                    str2 = null;
                }
                pVar.b(str2);
                pVar.a(str3);
                pVar.a(System.currentTimeMillis());
                pVar.b(b);
                try {
                    byteArrayOutputStream.close();
                    return pVar;
                } catch (IOException e2) {
                    throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e3) {
                        throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                    }
                }
                throw th;
            }
        }
        return (u) invokeLIL.objValue;
    }

    public static HashMap<String, String> a(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str2 : str.split(";")) {
                String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
                hashMap.put(split2[0], split2[1]);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, httpEntity, outputStream) == null) {
            InputStream a = b.a(httpEntity);
            httpEntity.getContentLength();
            try {
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = a.read(bArr);
                        if (read == -1 || this.c.h()) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                        this.c.f();
                    }
                    outputStream.flush();
                } catch (Exception e2) {
                    e2.getCause();
                    throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
                }
            } finally {
                r.a(a);
            }
        }
    }

    public static long b(HttpResponse httpResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, httpResponse)) == null) {
            Header firstHeader = httpResponse.getFirstHeader(Headers.CACHE_CONTROL);
            if (firstHeader != null) {
                String[] split = firstHeader.getValue().split("=");
                if (split.length >= 2) {
                    try {
                        return a(split);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            Header firstHeader2 = httpResponse.getFirstHeader(Headers.EXPIRES);
            if (firstHeader2 != null) {
                return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    private URI b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            String a = this.c.a();
            String str = this.d;
            if (str != null) {
                a = str;
            }
            if (a != null) {
                return new URI(a);
            }
            throw new RuntimeException("url should not be null");
        }
        return (URI) invokeV.objValue;
    }

    private HttpUriRequest c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            HttpUriRequest httpUriRequest = this.f;
            if (httpUriRequest != null) {
                return httpUriRequest;
            }
            if (this.j == null) {
                byte[] b = this.c.b();
                String b2 = this.c.b("gzip");
                if (b != null) {
                    if (TextUtils.equals(b2, "true")) {
                        this.j = b.a(b);
                    } else {
                        this.j = new ByteArrayEntity(b);
                    }
                    this.j.setContentType(this.c.c());
                }
            }
            AbstractHttpEntity abstractHttpEntity = this.j;
            if (abstractHttpEntity != null) {
                HttpPost httpPost = new HttpPost(b());
                httpPost.setEntity(abstractHttpEntity);
                this.f = httpPost;
            } else {
                this.f = new HttpGet(b());
            }
            return this.f;
        }
        return (HttpUriRequest) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a A[Catch: Exception -> 0x0266, NullPointerException -> 0x0288, IOException -> 0x02ac, UnknownHostException -> 0x02d6, HttpHostConnectException -> 0x0302, NoHttpResponseException -> 0x0326, SocketTimeoutException -> 0x0351, ConnectTimeoutException -> 0x037c, ConnectionPoolTimeoutException -> 0x03a6, SSLException -> 0x03d0, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x0424, URISyntaxException -> 0x044e, HttpException -> 0x045b, TryCatch #3 {HttpException -> 0x045b, NullPointerException -> 0x0288, SocketTimeoutException -> 0x0351, URISyntaxException -> 0x044e, UnknownHostException -> 0x02d6, SSLHandshakeException -> 0x0424, SSLPeerUnverifiedException -> 0x03fa, SSLException -> 0x03d0, NoHttpResponseException -> 0x0326, ConnectionPoolTimeoutException -> 0x03a6, ConnectTimeoutException -> 0x037c, HttpHostConnectException -> 0x0302, IOException -> 0x02ac, Exception -> 0x0266, blocks: (B:6:0x000a, B:20:0x0036, B:22:0x003e, B:24:0x0044, B:25:0x0048, B:27:0x004e, B:28:0x005c, B:30:0x0070, B:32:0x0085, B:34:0x00c5, B:36:0x00d4, B:38:0x00da, B:40:0x00e4, B:43:0x00ed, B:45:0x00f9, B:49:0x0103, B:51:0x010a, B:53:0x0125, B:55:0x012d, B:56:0x013a, B:58:0x0160, B:59:0x0167, B:61:0x016d, B:62:0x0171, B:64:0x0177, B:66:0x0183, B:70:0x01b2, B:71:0x01ce, B:79:0x01eb, B:80:0x0204, B:81:0x0205, B:83:0x020d, B:85:0x0213, B:89:0x021f, B:91:0x0223, B:93:0x0233, B:95:0x023b, B:97:0x0245, B:52:0x010d, B:99:0x025a, B:100:0x0265, B:9:0x001b, B:11:0x001f, B:13:0x0023, B:15:0x0029, B:18:0x0031), top: B:189:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d A[Catch: Exception -> 0x0266, NullPointerException -> 0x0288, IOException -> 0x02ac, UnknownHostException -> 0x02d6, HttpHostConnectException -> 0x0302, NoHttpResponseException -> 0x0326, SocketTimeoutException -> 0x0351, ConnectTimeoutException -> 0x037c, ConnectionPoolTimeoutException -> 0x03a6, SSLException -> 0x03d0, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x0424, URISyntaxException -> 0x044e, HttpException -> 0x045b, TryCatch #3 {HttpException -> 0x045b, NullPointerException -> 0x0288, SocketTimeoutException -> 0x0351, URISyntaxException -> 0x044e, UnknownHostException -> 0x02d6, SSLHandshakeException -> 0x0424, SSLPeerUnverifiedException -> 0x03fa, SSLException -> 0x03d0, NoHttpResponseException -> 0x0326, ConnectionPoolTimeoutException -> 0x03a6, ConnectTimeoutException -> 0x037c, HttpHostConnectException -> 0x0302, IOException -> 0x02ac, Exception -> 0x0266, blocks: (B:6:0x000a, B:20:0x0036, B:22:0x003e, B:24:0x0044, B:25:0x0048, B:27:0x004e, B:28:0x005c, B:30:0x0070, B:32:0x0085, B:34:0x00c5, B:36:0x00d4, B:38:0x00da, B:40:0x00e4, B:43:0x00ed, B:45:0x00f9, B:49:0x0103, B:51:0x010a, B:53:0x0125, B:55:0x012d, B:56:0x013a, B:58:0x0160, B:59:0x0167, B:61:0x016d, B:62:0x0171, B:64:0x0177, B:66:0x0183, B:70:0x01b2, B:71:0x01ce, B:79:0x01eb, B:80:0x0204, B:81:0x0205, B:83:0x020d, B:85:0x0213, B:89:0x021f, B:91:0x0223, B:93:0x0233, B:95:0x023b, B:97:0x0245, B:52:0x010d, B:99:0x025a, B:100:0x0265, B:9:0x001b, B:11:0x001f, B:13:0x0023, B:15:0x0029, B:18:0x0031), top: B:189:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012d A[Catch: Exception -> 0x0266, NullPointerException -> 0x0288, IOException -> 0x02ac, UnknownHostException -> 0x02d6, HttpHostConnectException -> 0x0302, NoHttpResponseException -> 0x0326, SocketTimeoutException -> 0x0351, ConnectTimeoutException -> 0x037c, ConnectionPoolTimeoutException -> 0x03a6, SSLException -> 0x03d0, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x0424, URISyntaxException -> 0x044e, HttpException -> 0x045b, TryCatch #3 {HttpException -> 0x045b, NullPointerException -> 0x0288, SocketTimeoutException -> 0x0351, URISyntaxException -> 0x044e, UnknownHostException -> 0x02d6, SSLHandshakeException -> 0x0424, SSLPeerUnverifiedException -> 0x03fa, SSLException -> 0x03d0, NoHttpResponseException -> 0x0326, ConnectionPoolTimeoutException -> 0x03a6, ConnectTimeoutException -> 0x037c, HttpHostConnectException -> 0x0302, IOException -> 0x02ac, Exception -> 0x0266, blocks: (B:6:0x000a, B:20:0x0036, B:22:0x003e, B:24:0x0044, B:25:0x0048, B:27:0x004e, B:28:0x005c, B:30:0x0070, B:32:0x0085, B:34:0x00c5, B:36:0x00d4, B:38:0x00da, B:40:0x00e4, B:43:0x00ed, B:45:0x00f9, B:49:0x0103, B:51:0x010a, B:53:0x0125, B:55:0x012d, B:56:0x013a, B:58:0x0160, B:59:0x0167, B:61:0x016d, B:62:0x0171, B:64:0x0177, B:66:0x0183, B:70:0x01b2, B:71:0x01ce, B:79:0x01eb, B:80:0x0204, B:81:0x0205, B:83:0x020d, B:85:0x0213, B:89:0x021f, B:91:0x0223, B:93:0x0233, B:95:0x023b, B:97:0x0245, B:52:0x010d, B:99:0x025a, B:100:0x0265, B:9:0x001b, B:11:0x001f, B:13:0x0023, B:15:0x0029, B:18:0x0031), top: B:189:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0160 A[Catch: Exception -> 0x0266, NullPointerException -> 0x0288, IOException -> 0x02ac, UnknownHostException -> 0x02d6, HttpHostConnectException -> 0x0302, NoHttpResponseException -> 0x0326, SocketTimeoutException -> 0x0351, ConnectTimeoutException -> 0x037c, ConnectionPoolTimeoutException -> 0x03a6, SSLException -> 0x03d0, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x0424, URISyntaxException -> 0x044e, HttpException -> 0x045b, TryCatch #3 {HttpException -> 0x045b, NullPointerException -> 0x0288, SocketTimeoutException -> 0x0351, URISyntaxException -> 0x044e, UnknownHostException -> 0x02d6, SSLHandshakeException -> 0x0424, SSLPeerUnverifiedException -> 0x03fa, SSLException -> 0x03d0, NoHttpResponseException -> 0x0326, ConnectionPoolTimeoutException -> 0x03a6, ConnectTimeoutException -> 0x037c, HttpHostConnectException -> 0x0302, IOException -> 0x02ac, Exception -> 0x0266, blocks: (B:6:0x000a, B:20:0x0036, B:22:0x003e, B:24:0x0044, B:25:0x0048, B:27:0x004e, B:28:0x005c, B:30:0x0070, B:32:0x0085, B:34:0x00c5, B:36:0x00d4, B:38:0x00da, B:40:0x00e4, B:43:0x00ed, B:45:0x00f9, B:49:0x0103, B:51:0x010a, B:53:0x0125, B:55:0x012d, B:56:0x013a, B:58:0x0160, B:59:0x0167, B:61:0x016d, B:62:0x0171, B:64:0x0177, B:66:0x0183, B:70:0x01b2, B:71:0x01ce, B:79:0x01eb, B:80:0x0204, B:81:0x0205, B:83:0x020d, B:85:0x0213, B:89:0x021f, B:91:0x0223, B:93:0x0233, B:95:0x023b, B:97:0x0245, B:52:0x010d, B:99:0x025a, B:100:0x0265, B:9:0x001b, B:11:0x001f, B:13:0x0023, B:15:0x0029, B:18:0x0031), top: B:189:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016d A[Catch: Exception -> 0x0266, NullPointerException -> 0x0288, IOException -> 0x02ac, UnknownHostException -> 0x02d6, HttpHostConnectException -> 0x0302, NoHttpResponseException -> 0x0326, SocketTimeoutException -> 0x0351, ConnectTimeoutException -> 0x037c, ConnectionPoolTimeoutException -> 0x03a6, SSLException -> 0x03d0, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x0424, URISyntaxException -> 0x044e, HttpException -> 0x045b, TryCatch #3 {HttpException -> 0x045b, NullPointerException -> 0x0288, SocketTimeoutException -> 0x0351, URISyntaxException -> 0x044e, UnknownHostException -> 0x02d6, SSLHandshakeException -> 0x0424, SSLPeerUnverifiedException -> 0x03fa, SSLException -> 0x03d0, NoHttpResponseException -> 0x0326, ConnectionPoolTimeoutException -> 0x03a6, ConnectTimeoutException -> 0x037c, HttpHostConnectException -> 0x0302, IOException -> 0x02ac, Exception -> 0x0266, blocks: (B:6:0x000a, B:20:0x0036, B:22:0x003e, B:24:0x0044, B:25:0x0048, B:27:0x004e, B:28:0x005c, B:30:0x0070, B:32:0x0085, B:34:0x00c5, B:36:0x00d4, B:38:0x00da, B:40:0x00e4, B:43:0x00ed, B:45:0x00f9, B:49:0x0103, B:51:0x010a, B:53:0x0125, B:55:0x012d, B:56:0x013a, B:58:0x0160, B:59:0x0167, B:61:0x016d, B:62:0x0171, B:64:0x0177, B:66:0x0183, B:70:0x01b2, B:71:0x01ce, B:79:0x01eb, B:80:0x0204, B:81:0x0205, B:83:0x020d, B:85:0x0213, B:89:0x021f, B:91:0x0223, B:93:0x0233, B:95:0x023b, B:97:0x0245, B:52:0x010d, B:99:0x025a, B:100:0x0265, B:9:0x001b, B:11:0x001f, B:13:0x0023, B:15:0x0029, B:18:0x0031), top: B:189:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e2  */
    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public u call() {
        InterceptResult invokeV;
        boolean z;
        HttpHost httpHost;
        HttpHost httpHost2;
        List<Cookie> cookies;
        int statusCode;
        u a;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65546, this)) != null) {
            return (u) invokeV.objValue;
        }
        while (true) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z2 = true;
                if (allNetworkInfo != null) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    ArrayList<Header> d = this.c.d();
                    if (d != null && !d.isEmpty()) {
                        Iterator<Header> it = d.iterator();
                        while (it.hasNext()) {
                            c().addHeader(it.next());
                        }
                    }
                    b.a((HttpRequest) c());
                    b.b((HttpRequest) c());
                    c().addHeader("cookie", i().getCookie(this.c.a()));
                    this.g.setAttribute(ClientContext.COOKIE_STORE, this.h);
                    this.a.a().a(e);
                    long currentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder("By Http/Https to request. operationType=");
                    sb.append(f());
                    sb.append(" url=");
                    sb.append(this.f.getURI().toString());
                    HttpParams params = this.a.a().getParams();
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
                    HttpHost httpHost3 = null;
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        String defaultHost = Proxy.getDefaultHost();
                        int defaultPort = Proxy.getDefaultPort();
                        if (defaultHost != null) {
                            httpHost = new HttpHost(defaultHost, defaultPort);
                            if (httpHost != null || !TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                                httpHost3 = httpHost;
                            }
                            params.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost3);
                            if (this.k == null) {
                                httpHost2 = this.k;
                            } else {
                                URL h = h();
                                HttpHost httpHost4 = new HttpHost(h.getHost(), g(), h.getProtocol());
                                this.k = httpHost4;
                                httpHost2 = httpHost4;
                            }
                            if (g() == 80) {
                                httpHost2 = new HttpHost(h().getHost());
                            }
                            HttpResponse execute = this.a.a().execute(httpHost2, this.f, this.g);
                            this.a.b(System.currentTimeMillis() - currentTimeMillis);
                            cookies = this.h.getCookies();
                            if (this.c.e()) {
                                i().removeAllCookie();
                            }
                            if (!cookies.isEmpty()) {
                                for (Cookie cookie : cookies) {
                                    if (cookie.getDomain() != null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(cookie.getName());
                                        sb2.append("=");
                                        sb2.append(cookie.getValue());
                                        sb2.append("; domain=");
                                        sb2.append(cookie.getDomain());
                                        sb2.append(cookie.isSecure() ? "; Secure" : "");
                                        i().setCookie(this.c.a(), sb2.toString());
                                        CookieSyncManager.getInstance().sync();
                                    }
                                }
                            }
                            statusCode = execute.getStatusLine().getStatusCode();
                            String reasonPhrase = execute.getStatusLine().getReasonPhrase();
                            if (statusCode != 200) {
                                if (statusCode != 304) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    throw new HttpException(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                                }
                            }
                            a = a(execute, statusCode, reasonPhrase);
                            if (((a != null || a.b() == null) ? -1L : a.b().length) == -1 && (a instanceof p)) {
                                try {
                                    Long.parseLong(((p) a).a().getHead("Content-Length"));
                                } catch (Exception unused) {
                                }
                            }
                            a2 = this.c.a();
                            if (a2 != null && !TextUtils.isEmpty(f())) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(a2);
                                sb3.append("#");
                                sb3.append(f());
                            }
                            return a;
                        }
                    }
                    httpHost = null;
                    if (httpHost != null) {
                    }
                    httpHost3 = httpHost;
                    params.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost3);
                    if (this.k == null) {
                    }
                    if (g() == 80) {
                    }
                    HttpResponse execute2 = this.a.a().execute(httpHost2, this.f, this.g);
                    this.a.b(System.currentTimeMillis() - currentTimeMillis);
                    cookies = this.h.getCookies();
                    if (this.c.e()) {
                    }
                    if (!cookies.isEmpty()) {
                    }
                    statusCode = execute2.getStatusLine().getStatusCode();
                    String reasonPhrase2 = execute2.getStatusLine().getReasonPhrase();
                    if (statusCode != 200) {
                    }
                    a = a(execute2, statusCode, reasonPhrase2);
                    if (((a != null || a.b() == null) ? -1L : a.b().length) == -1) {
                        Long.parseLong(((p) a).a().getHead("Content-Length"));
                    }
                    a2 = this.c.a();
                    if (a2 != null) {
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append(a2);
                        sb32.append("#");
                        sb32.append(f());
                    }
                    return a;
                }
                throw new HttpException(1, "The network is not available");
            } catch (HttpException e2) {
                e();
                if (this.c.f() != null) {
                    e2.getCode();
                    e2.getMsg();
                }
                new StringBuilder().append(e2);
                throw e2;
            } catch (NullPointerException e3) {
                e();
                int i = this.m;
                if (i > 0) {
                    new StringBuilder().append(e3);
                    throw new HttpException(0, String.valueOf(e3));
                }
                this.m = i + 1;
            } catch (SocketTimeoutException e4) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e4);
                }
                new StringBuilder().append(e4);
                throw new HttpException(4, String.valueOf(e4));
            } catch (URISyntaxException e5) {
                throw new RuntimeException("Url parser error!", e5.getCause());
            } catch (UnknownHostException e6) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e6);
                }
                new StringBuilder().append(e6);
                throw new HttpException(9, String.valueOf(e6));
            } catch (SSLHandshakeException e7) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e7);
                }
                new StringBuilder().append(e7);
                throw new HttpException(2, String.valueOf(e7));
            } catch (SSLPeerUnverifiedException e8) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e8);
                }
                new StringBuilder().append(e8);
                throw new HttpException(2, String.valueOf(e8));
            } catch (SSLException e9) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e9);
                }
                new StringBuilder().append(e9);
                throw new HttpException(6, String.valueOf(e9));
            } catch (NoHttpResponseException e10) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e10);
                }
                new StringBuilder().append(e10);
                throw new HttpException(5, String.valueOf(e10));
            } catch (ConnectionPoolTimeoutException e11) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e11);
                }
                new StringBuilder().append(e11);
                throw new HttpException(3, String.valueOf(e11));
            } catch (ConnectTimeoutException e12) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e12);
                }
                new StringBuilder().append(e12);
                throw new HttpException(3, String.valueOf(e12));
            } catch (HttpHostConnectException e13) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e13);
                }
                throw new HttpException(8, String.valueOf(e13));
            } catch (IOException e14) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e14);
                }
                new StringBuilder().append(e14);
                throw new HttpException(6, String.valueOf(e14));
            } catch (Exception e15) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e15);
                }
                throw new HttpException(0, String.valueOf(e15));
            }
        }
    }

    private void e() {
        HttpUriRequest httpUriRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (httpUriRequest = this.f) == null) {
            return;
        }
        httpUriRequest.abort();
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (TextUtils.isEmpty(this.q)) {
                String b = this.c.b("operationType");
                this.q = b;
                return b;
            }
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    private int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            URL h = h();
            return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
        }
        return invokeV.intValue;
    }

    private URL h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            URL url = this.l;
            if (url != null) {
                return url;
            }
            URL url2 = new URL(this.c.a());
            this.l = url2;
            return url2;
        }
        return (URL) invokeV.objValue;
    }

    private CookieManager i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            CookieManager cookieManager = this.i;
            if (cookieManager != null) {
                return cookieManager;
            }
            CookieManager cookieManager2 = CookieManager.getInstance();
            this.i = cookieManager2;
            return cookieManager2;
        }
        return (CookieManager) invokeV.objValue;
    }

    public final o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (o) invokeV.objValue;
    }
}
