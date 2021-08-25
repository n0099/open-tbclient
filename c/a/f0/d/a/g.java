package c.a.f0.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.prologue.service.network.Request;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class g extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f3462a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f3463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f3464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f3465g;

        public a(g gVar, Request request, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, request, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3465g = gVar;
            this.f3463e = request;
            this.f3464f = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f3465g;
                Request request = this.f3463e;
                gVar.h(0, request, request.f44309a, this.f3464f);
            }
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3462a = new ThreadPoolExecutor(0, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static void d(HttpURLConnection httpURLConnection, Request request) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, httpURLConnection, request) == null) {
            e(httpURLConnection, request);
            Map<String, String> map = request.f44311c;
            if (map == null || map.size() == 0) {
                return;
            }
            for (Map.Entry<String, String> entry : request.f44311c.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void e(HttpURLConnection httpURLConnection, Request request) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, httpURLConnection, request) != null) {
            return;
        }
        Map<String, String> map = request.f44311c;
        if (map != null && map.containsKey("Cookie")) {
            return;
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(request.f44309a.toString());
                if (TextUtils.isEmpty(cookie)) {
                    return;
                }
                httpURLConnection.setRequestProperty("Cookie", cookie);
            }
        } finally {
            if (!z) {
            }
        }
    }

    public static String f(String str, String str2) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? str == null ? "" : URLEncoder.encode(str, str2) : (String) invokeLL.objValue;
    }

    public static StringBuffer g(Map<String, String> map, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, map, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(f(entry.getValue(), str));
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static void j(HttpURLConnection httpURLConnection) {
        List<String> emptyList;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, httpURLConnection) != null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            emptyList = headerFields.get("Set-Cookie");
            List<String> list = headerFields.get(SM.SET_COOKIE2);
            if (list != null && emptyList != null) {
                ArrayList arrayList = new ArrayList(emptyList);
                arrayList.addAll(list);
                emptyList = arrayList;
            }
        } else {
            emptyList = Collections.emptyList();
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (emptyList == null || cookieManager == null) {
                return;
            }
            for (String str : emptyList) {
                cookieManager.setCookie(httpURLConnection.getURL().toString(), str);
            }
        } finally {
            if (!z) {
            }
        }
    }

    @Override // c.a.f0.d.a.e
    public void a(Request request, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, kVar) == null) {
            this.f3462a.execute(new a(this, request, kVar));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:16|17|18|(4:45|46|47|48)|20|(3:25|27|28)|30|31|32|33|34|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
        r8 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i2, Request request, URL url, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), request, url, kVar}) == null) {
            if (i2 >= 10) {
                kVar.a(new Throwable("Too many redirects"));
                return;
            }
            try {
                byte[] bytes = request.f() ? g(request.f44312d, "utf-8").toString().getBytes() : null;
                HttpURLConnection i3 = i(url, 30000, request.f(), request.f44310b, request.f44318j);
                if (i3 == null) {
                    kVar.a(new Exception("Unable to open connection"));
                    return;
                }
                try {
                    d(i3, request);
                    i3.addRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    boolean z = true;
                    if (bytes != null) {
                        try {
                            i3.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                            OutputStream outputStream = i3.getOutputStream();
                            outputStream.write(bytes, 0, bytes.length);
                            c.a.f0.a.c.k.a(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (!z) {
                                try {
                                    kVar.a(th);
                                } finally {
                                    i3.disconnect();
                                }
                            }
                        }
                    }
                    j(i3);
                    int responseCode = i3.getResponseCode();
                    int contentLength = i3.getContentLength();
                    if (responseCode != 200 && responseCode != 206) {
                        switch (responseCode) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                h(i2 + 1, request, new URL(url, URLDecoder.decode(i3.getHeaderField("Location"), "UTF-8")), kVar);
                                break;
                        }
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(k(i3));
                    kVar.b(contentLength, bufferedInputStream);
                    c.a.f0.a.c.k.a(bufferedInputStream);
                } catch (UnsupportedEncodingException e2) {
                    kVar.a(e2);
                }
            } catch (UnsupportedEncodingException e3) {
                kVar.a(e3);
            }
        }
    }

    public final HttpURLConnection i(URL url, int i2, boolean z, String str, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{url, Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)})) != null) {
            return (HttpURLConnection) invokeCommon.objValue;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(j.b());
                    ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(j.a());
                }
                httpURLConnection2.setInstanceFollowRedirects(true);
                if (z2) {
                    httpURLConnection2.setConnectTimeout(d.f3458b);
                    httpURLConnection2.setReadTimeout(d.f3459c);
                } else {
                    httpURLConnection2.setConnectTimeout(i2);
                    httpURLConnection2.setReadTimeout(60000);
                }
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(z);
                httpURLConnection2.setRequestMethod(str);
                if ("POST".equals(str)) {
                    httpURLConnection2.setUseCaches(false);
                } else if ("GET".equals(str)) {
                    httpURLConnection2.setUseCaches(true);
                }
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                return httpURLConnection2;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                c.a.f0.a.c.g gVar = c.a.f0.a.c.g.f3360a;
                gVar.e("OriginHttp", "failed to connect to url " + url, th);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return httpURLConnection;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final InputStream k(HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, httpURLConnection)) == null) {
            String contentEncoding = httpURLConnection.getContentEncoding();
            InputStream inputStream = httpURLConnection.getInputStream();
            return AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(contentEncoding) ? new GZIPInputStream(inputStream) : inputStream;
        }
        return (InputStream) invokeL.objValue;
    }
}
