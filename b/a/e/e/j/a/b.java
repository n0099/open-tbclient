package b.a.e.e.j.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static String p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f1767a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f1768b;

    /* renamed from: c  reason: collision with root package name */
    public long f1769c;

    /* renamed from: d  reason: collision with root package name */
    public long f1770d;

    /* renamed from: e  reason: collision with root package name */
    public long f1771e;

    /* renamed from: f  reason: collision with root package name */
    public long f1772f;

    /* renamed from: g  reason: collision with root package name */
    public long f1773g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1774h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1775i;
    public boolean j;
    public boolean k;
    public int l;
    public TimerTask m;
    public TimerTask n;
    public Timer o;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1776e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1776e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f1776e.b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b.a.e.e.j.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0030b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1777e;

        public C0030b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1777e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.a.e.e.m.a.e(this.f1777e.f1768b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpsURLConnection f1778a;

        public c(b bVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1778a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                String requestProperty = this.f1778a.getRequestProperty("Host");
                if (requestProperty == null) {
                    requestProperty = this.f1778a.getURL().getHost();
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(833606823, "Lb/a/e/e/j/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(833606823, "Lb/a/e/e/j/a/b;");
                return;
            }
        }
        Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        p = "--------7da3d81520810*";
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1769c = 0L;
        this.f1770d = 0L;
        this.f1771e = 0L;
        this.f1772f = 0L;
        this.f1773g = 0L;
        this.f1774h = false;
        this.f1775i = true;
        this.j = true;
        this.k = true;
        this.l = 0;
        this.m = new a(this);
        this.n = new C0030b(this);
        this.o = new Timer();
        if (eVar != null) {
            this.f1767a = eVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1767a.c().f1805a = true;
            b.a.e.e.m.a.e(this.f1768b);
        }
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str != null && str.toLowerCase().contains(AsyncHttpClient.ENCODING_GZIP)) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                b.a.e.e.p.g.c(byteArrayInputStream, byteArrayOutputStream);
                this.f1773g = System.currentTimeMillis();
                return byteArrayOutputStream.toByteArray();
            }
            if (this.f1773g == 0) {
                this.f1773g = System.currentTimeMillis();
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:133:0x0301 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public boolean d(String str, h hVar, int i2, int i3, boolean z, d dVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        ?? r15;
        File i4;
        InputStream inputStream;
        boolean z3;
        URL url;
        String str2;
        String headerField;
        int indexOf;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, hVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), dVar, Boolean.valueOf(z2)})) != null) {
            return invokeCommon.booleanValue;
        }
        d dVar2 = dVar == null ? new d() : dVar;
        InputStream inputStream2 = null;
        try {
            String i6 = this.f1767a.b().i();
            dVar2.s = i6;
            URL n = n(i6, dVar2);
            this.f1768b = g(n, i3, i2);
            if (this.f1767a.c().f1805a) {
                this.f1772f = System.currentTimeMillis();
                b.a.e.e.m.a.c(null);
                b.a.e.e.m.a.e(this.f1768b);
                b.a.e.e.m.a.d(null);
                return false;
            }
            if (z2) {
                try {
                    b.a.e.e.p.f.k(str);
                } catch (Throwable th) {
                    th = th;
                    r15 = inputStream2;
                    this.f1772f = System.currentTimeMillis();
                    b.a.e.e.m.a.c(inputStream2);
                    b.a.e.e.m.a.e(this.f1768b);
                    b.a.e.e.m.a.d(r15);
                    throw th;
                }
            }
            if (z) {
                i4 = new File(str);
            } else {
                i4 = b.a.e.e.p.f.i(str);
            }
            if (i4 != null) {
                long length = i4.length();
                r15 = new FileOutputStream(i4, true);
                try {
                    try {
                        this.f1767a.b().t(this.f1768b);
                        this.f1768b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f1768b.connect();
                        if (this.f1769c <= 0) {
                            try {
                                this.f1769c = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = null;
                                this.f1772f = System.currentTimeMillis();
                                b.a.e.e.m.a.c(inputStream2);
                                b.a.e.e.m.a.e(this.f1768b);
                                b.a.e.e.m.a.d(r15);
                                throw th;
                            }
                        }
                        this.f1770d = System.currentTimeMillis();
                        int responseCode = this.f1768b.getResponseCode();
                        this.f1771e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.f1768b.getURL();
                            if (url != null) {
                                dVar2.r = url.toString();
                            }
                            if (url != null) {
                                i5 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), n.getProtocol())) {
                                    b.a.e.e.m.a.e(this.f1768b);
                                    this.f1768b = g(new URL(url.toString()), i3, i2);
                                    this.f1767a.b().t(this.f1768b);
                                    this.f1768b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.f1768b.connect();
                                    responseCode = this.f1768b.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i5 = responseCode;
                            }
                            responseCode = i5;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.f1767a.c().f1806b = responseCode;
                        String headerField2 = this.f1768b.getHeaderField("Content-Range");
                        int e2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : b.a.e.e.m.b.e(headerField2.substring(indexOf + 1), 0);
                        if (e2 == 0 && this.f1767a.c().f1806b == 200 && (headerField = this.f1768b.getHeaderField("Content-Length")) != null) {
                            e2 = b.a.e.e.m.b.e(headerField, 0);
                        }
                        this.f1767a.c().f1810f = String.valueOf(e2);
                        if (!o()) {
                            str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + n + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (e2 > 0 && e2 == length) {
                                    this.f1772f = System.currentTimeMillis();
                                    b.a.e.e.m.a.c(null);
                                    b.a.e.e.m.a.e(this.f1768b);
                                    b.a.e.e.m.a.d(r15);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + e2;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.f1768b.getContentType() != null && this.f1768b.getContentType().contains("text/vnd.wap.wml")) {
                            this.f1768b.disconnect();
                            this.f1767a.c().f1806b = 0;
                            boolean d2 = d(str, hVar, i2, i3, z, dVar2, z2);
                            this.f1772f = System.currentTimeMillis();
                            b.a.e.e.m.a.c(null);
                            b.a.e.e.m.a.e(this.f1768b);
                            b.a.e.e.m.a.d(r15);
                            return d2;
                        } else {
                            dVar2.f1785a = i6.getBytes().length;
                            long length2 = this.f1768b.getHeaderFields().toString().getBytes().length;
                            dVar2.f1786b = length2;
                            long j = e2;
                            dVar2.f1786b = length2 + j;
                            if (e2 != 0 && length >= j) {
                                this.f1772f = System.currentTimeMillis();
                                this.f1772f = System.currentTimeMillis();
                                b.a.e.e.m.a.c(null);
                                b.a.e.e.m.a.e(this.f1768b);
                                b.a.e.e.m.a.d(r15);
                                return true;
                            }
                            inputStream = null;
                            try {
                                inputStream2 = this.f1768b.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    int i7 = e2 > 0 ? e2 / 50 : 0;
                                    if (hVar != null && length > 0) {
                                        hVar.onProgress((int) length, e2);
                                    }
                                    int i8 = 0;
                                    loop0: while (true) {
                                        int i9 = 0;
                                        while (!this.f1767a.c().f1805a) {
                                            int read = inputStream2.read(bArr);
                                            if (read == -1) {
                                                break loop0;
                                            }
                                            try {
                                                r15.write(bArr, 0, read);
                                                i8 += read;
                                                i9 += read;
                                                if (hVar == null || (i9 <= i7 && i8 != e2)) {
                                                    i7 = i7;
                                                } else {
                                                    int i10 = i7;
                                                    hVar.onProgress((int) (i8 + length), e2);
                                                    i7 = i10;
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                        break loop0;
                                    }
                                    try {
                                        r15.flush();
                                        long j2 = i8;
                                        dVar2.w = j2;
                                        dVar2.x = length;
                                        dVar2.y = j;
                                        boolean z4 = j2 + length >= j;
                                        this.f1772f = System.currentTimeMillis();
                                        b.a.e.e.m.a.c(inputStream2);
                                        b.a.e.e.m.a.e(this.f1768b);
                                        b.a.e.e.m.a.d(r15);
                                        return z4;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    this.f1772f = System.currentTimeMillis();
                                    b.a.e.e.m.a.c(inputStream2);
                                    b.a.e.e.m.a.e(this.f1768b);
                                    b.a.e.e.m.a.d(r15);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream;
                                this.f1772f = System.currentTimeMillis();
                                b.a.e.e.m.a.c(inputStream2);
                                b.a.e.e.m.a.e(this.f1768b);
                                b.a.e.e.m.a.d(r15);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } else {
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th7) {
                    th = th7;
                    inputStream2 = null;
                    r15 = inputStream2;
                    this.f1772f = System.currentTimeMillis();
                    b.a.e.e.m.a.c(inputStream2);
                    b.a.e.e.m.a.e(this.f1768b);
                    b.a.e.e.m.a.d(r15);
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1773g : invokeV.longValue;
    }

    public final HttpURLConnection f(URL url) {
        InterceptResult invokeL;
        String c2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, url)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        HttpsURLConnection httpsURLConnection = null;
        try {
            if (j.z()) {
                if (j.x() && (c2 = j.c()) != null && c2.length() > 0) {
                    if (j.F(c2) && j.D()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(c2);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.f1767a.b().a("X-Online-Host", url.getHost());
                        } catch (Exception e2) {
                            e = e2;
                            httpsURLConnection = httpURLConnection;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, j.d())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.f1774h && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new i(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new c(this, httpsURLConnection2));
                    return httpsURLConnection2;
                }
                return httpsURLConnection;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final HttpURLConnection g(URL url, int i2, int i3) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, url, i2, i3)) == null) {
            HttpURLConnection f2 = f(url);
            if (f2 != null) {
                f2.setConnectTimeout(i2);
                f2.setReadTimeout(i3);
                return f2;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1771e : invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1769c : invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1770d : invokeV.longValue;
    }

    public void k(int i2, int i3, d dVar) throws Exception {
        HttpURLConnection httpURLConnection;
        URL url;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, dVar) == null) {
            dVar.j = -1;
            if (!this.f1767a.c().f1805a) {
                String f2 = this.f1767a.b().f(dVar);
                dVar.s = f2;
                URL n = n(f2, dVar);
                if (!this.f1767a.c().f1805a) {
                    dVar.j = -2;
                    this.f1768b = f(n);
                    dVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (this.f1768b != null) {
                            this.f1768b.setRequestMethod("GET");
                            this.f1768b.setConnectTimeout(i3);
                            this.f1768b.setReadTimeout(i2);
                            this.f1767a.b().t(this.f1768b);
                            if (!this.f1767a.c().f1805a) {
                                dVar.f1791g = new Date().getTime() - currentTimeMillis;
                                dVar.j = -4;
                                this.f1768b.connect();
                                if (this.f1769c <= 0) {
                                    this.f1769c = System.currentTimeMillis();
                                }
                                this.f1770d = System.currentTimeMillis();
                                dVar.j = -5;
                                dVar.f1787c = (new Date().getTime() - currentTimeMillis) - dVar.f1791g;
                                if (!this.f1767a.c().f1805a) {
                                    if (this.f1767a.b().k() && this.o != null && this.l >= 0 && this.l < 3) {
                                        this.o.schedule(this.n, (this.l + 1) * 3000);
                                    }
                                    String contentType = this.f1768b.getContentType();
                                    this.f1771e = System.currentTimeMillis();
                                    if (b.a.e.e.j.b.b.c(contentType)) {
                                        this.f1768b.disconnect();
                                        this.f1768b.connect();
                                        if (this.f1767a.c().f1805a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    dVar.j = -8;
                                    this.f1767a.c().a(this.f1768b);
                                    if (f2.contains("c.tieba.baidu.com") && (map = this.f1767a.c().f1811g) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                        dVar.t = list.get(0);
                                        dVar.u = list.get(1);
                                    }
                                    if (this.f1767a.c().f1806b == 302 && (url = this.f1768b.getURL()) != null) {
                                        dVar.r = url.toString();
                                    }
                                    dVar.f1793i = this.f1767a.c().f1806b;
                                    dVar.f1786b = this.f1768b.getHeaderFields().toString().getBytes().length;
                                    if (this.o != null) {
                                        this.o.cancel();
                                    }
                                    byte[] m = m(this.f1768b);
                                    if (m != null) {
                                        dVar.f1786b += m.length;
                                        this.f1767a.c().f1812h = c(this.f1767a.c().f1808d, m);
                                    }
                                    dVar.j = -9;
                                    dVar.f1788d = new Date().getTime() - currentTimeMillis;
                                    if (httpURLConnection != null) {
                                        return;
                                    }
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new SocketException("network not available.");
                    } finally {
                        Timer timer = this.o;
                        if (timer != null) {
                            timer.cancel();
                        }
                        httpURLConnection = this.f1768b;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
                throw new BdHttpCancelException();
            }
            throw new BdHttpCancelException();
        }
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1772f : invokeV.longValue;
    }

    public final byte[] m(HttpURLConnection httpURLConnection) throws Exception {
        InterceptResult invokeL;
        InputStream inputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, httpURLConnection)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = null;
            if (httpURLConnection != null) {
                try {
                    byte[] bArr2 = new byte[1024];
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    while (!this.f1767a.c().f1805a && (read = inputStream2.read(bArr2)) != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    if (!this.f1767a.c().f1805a) {
                        bArr = byteArrayOutputStream.toByteArray();
                        inputStream = inputStream2;
                    } else {
                        throw new BdHttpCancelException();
                    }
                } catch (Throwable th) {
                    this.f1772f = System.currentTimeMillis();
                    b.a.e.e.m.a.d(byteArrayOutputStream);
                    b.a.e.e.m.a.c(null);
                    throw th;
                }
            } else {
                inputStream = null;
            }
            this.f1772f = System.currentTimeMillis();
            b.a.e.e.m.a.d(byteArrayOutputStream);
            b.a.e.e.m.a.c(inputStream);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final URL n(String str, d dVar) throws Exception {
        InterceptResult invokeLL;
        b.a.e.e.j.a.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, dVar)) == null) {
            String str2 = "hiphotos.baidu.com";
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str) && this.j && this.k) {
                try {
                    String host = url.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!host.contains("hiphotos.baidu.com")) {
                            str2 = host;
                        }
                        BDHttpDnsResult r = BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).r(str2, true);
                        if (r != null) {
                            dVar.m = r.d();
                            dVar.o = r.c();
                            ArrayList<String> a2 = r.a();
                            if (a2 != null && a2.size() > 0) {
                                dVar.p = a2.toString();
                                int size = this.l % a2.size();
                                String str3 = a2.get(size);
                                if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url.getProtocol().equals("https"))) {
                                    this.f1767a.b().a("Host", str2);
                                    URL url2 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                    try {
                                        this.f1774h = true;
                                        dVar.q = size;
                                        dVar.l = str3;
                                        dVar.n = true;
                                        return url2;
                                    } catch (Exception e2) {
                                        e = e2;
                                        url = url2;
                                        BdLog.e(e);
                                        return this.f1775i ? url : url;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (this.f1775i || !this.k || (b2 = b.a.e.e.j.a.a.b()) == null) {
                return url;
            }
            String a3 = b2.a(str);
            if (TextUtils.isEmpty(a3)) {
                return url;
            }
            this.f1767a.b().a("Host", url.getHost());
            URL url3 = new URL(str.replace("://" + url.getHost(), "://" + a3));
            this.f1774h = true;
            dVar.l = a3;
            return url3;
        }
        return (URL) invokeLL.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1767a.c().f1806b == 200 || this.f1767a.c().f1806b == 206 : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1774h : invokeV.booleanValue;
    }

    public void q(int i2, int i3, d dVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, dVar) == null) {
            dVar.j = -1;
            try {
                String i4 = this.f1767a.b().i();
                dVar.s = i4;
                URL n = n(i4, dVar);
                if (!this.f1767a.c().f1805a) {
                    dVar.j = -2;
                    this.f1768b = f(n);
                    dVar.j = -3;
                    System.currentTimeMillis();
                    if (this.f1768b != null) {
                        this.f1768b.setRequestMethod("POST");
                        this.f1768b.setDoOutput(true);
                        this.f1768b.setDoInput(true);
                        this.f1768b.setConnectTimeout(i3);
                        this.f1768b.setReadTimeout(i2);
                        this.f1768b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + p);
                        if (!this.f1767a.c().f1805a) {
                            this.f1767a.b().t(this.f1768b);
                            if (!this.f1767a.c().f1805a) {
                                long time = new Date().getTime();
                                dVar.f1791g = new Date().getTime() - time;
                                dVar.j = -4;
                                this.f1768b.connect();
                                if (this.f1769c <= 0) {
                                    this.f1769c = System.currentTimeMillis();
                                }
                                this.f1770d = System.currentTimeMillis();
                                dVar.j = -5;
                                dVar.f1787c = (new Date().getTime() - time) - dVar.f1791g;
                                if (!this.f1767a.c().f1805a) {
                                    if (this.o != null) {
                                        this.o.schedule(this.m, 45000L);
                                    }
                                    dVar.j = -6;
                                    this.f1767a.b().v(this.f1768b, p, dVar);
                                    dVar.j = -7;
                                    String contentType = this.f1768b.getContentType();
                                    this.f1771e = System.currentTimeMillis();
                                    if (b.a.e.e.j.b.b.c(contentType)) {
                                        this.f1768b.disconnect();
                                        this.f1768b.connect();
                                        if (this.f1767a.c().f1805a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    if (!this.f1767a.c().f1805a) {
                                        dVar.j = -8;
                                        this.f1767a.c().a(this.f1768b);
                                        dVar.f1793i = this.f1767a.c().f1806b;
                                        dVar.f1786b = this.f1768b.getHeaderFields().toString().getBytes().length;
                                        byte[] m = m(this.f1768b);
                                        if (m != null) {
                                            dVar.f1786b += m.length;
                                            this.f1767a.c().f1813i = m.length;
                                            this.f1767a.c().f1812h = c(this.f1767a.c().f1808d, m);
                                        }
                                        dVar.f1788d = new Date().getTime() - time;
                                        dVar.j = -9;
                                        return;
                                    }
                                    throw new BdHttpCancelException();
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new SocketException("network not available.");
                }
                throw new BdHttpCancelException();
            } finally {
                Timer timer = this.o;
                if (timer != null) {
                    timer.cancel();
                }
                b.a.e.e.m.a.e(this.f1768b);
            }
        }
    }

    public void r(int i2, int i3, d dVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i2, i3, dVar) == null) {
            dVar.j = -1;
            try {
                String i4 = this.f1767a.b().i();
                dVar.s = i4;
                URL n = n(i4, dVar);
                if (!this.f1767a.c().f1805a) {
                    dVar.j = -2;
                    this.f1768b = f(n);
                    dVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.f1768b != null) {
                        this.f1768b.setRequestMethod("POST");
                        this.f1768b.setDoOutput(true);
                        this.f1768b.setDoInput(true);
                        this.f1768b.setConnectTimeout(i3);
                        this.f1768b.setReadTimeout(i2);
                        this.f1768b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        if (!this.f1767a.c().f1805a) {
                            this.f1767a.b().t(this.f1768b);
                            if (!this.f1767a.c().f1805a) {
                                dVar.f1791g = System.currentTimeMillis() - currentTimeMillis;
                                dVar.j = -4;
                                this.f1768b.connect();
                                if (this.f1769c <= 0) {
                                    this.f1769c = System.currentTimeMillis();
                                }
                                this.f1770d = System.currentTimeMillis();
                                dVar.j = -5;
                                dVar.f1787c = (System.currentTimeMillis() - currentTimeMillis) - dVar.f1791g;
                                if (!this.f1767a.c().f1805a) {
                                    dVar.j = -6;
                                    this.f1767a.b().u(this.f1768b, dVar);
                                    dVar.j = -7;
                                    if (!this.f1767a.c().f1805a) {
                                        String contentType = this.f1768b.getContentType();
                                        this.f1771e = System.currentTimeMillis();
                                        if (b.a.e.e.j.b.b.c(contentType)) {
                                            this.f1768b.disconnect();
                                            this.f1768b.connect();
                                            if (this.f1767a.c().f1805a) {
                                                throw new BdHttpCancelException();
                                            }
                                        }
                                        dVar.j = -8;
                                        this.f1767a.c().a(this.f1768b);
                                        dVar.f1793i = this.f1767a.c().f1806b;
                                        dVar.f1786b = this.f1768b.getHeaderFields().toString().getBytes().length;
                                        byte[] m = m(this.f1768b);
                                        if (m != null) {
                                            dVar.f1786b += m.length;
                                            this.f1767a.c().f1813i = m.length;
                                            this.f1767a.c().f1812h = c(this.f1767a.c().f1808d, m);
                                        }
                                        dVar.f1788d = new Date().getTime() - currentTimeMillis;
                                        dVar.j = -9;
                                        return;
                                    }
                                    throw new BdHttpCancelException();
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new SocketException("network not available.");
                }
                throw new BdHttpCancelException();
            } finally {
                b.a.e.e.m.a.e(this.f1768b);
            }
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.l = i2;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.k = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.j = z;
        }
    }
}
