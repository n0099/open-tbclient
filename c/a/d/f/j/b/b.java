package c.a.d.f.j.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.pyramid.runtime.service.ServiceManager;
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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f2131b;

    /* renamed from: c  reason: collision with root package name */
    public long f2132c;

    /* renamed from: d  reason: collision with root package name */
    public long f2133d;

    /* renamed from: e  reason: collision with root package name */
    public long f2134e;

    /* renamed from: f  reason: collision with root package name */
    public long f2135f;

    /* renamed from: g  reason: collision with root package name */
    public long f2136g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2137h;
    public boolean i;
    public boolean j;
    public int k;
    public TimerTask l;
    public TimerTask m;
    public Timer n;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: c.a.d.f.j.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0095b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0095b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.d.f.m.a.e(this.a.f2131b);
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
        public final /* synthetic */ HttpsURLConnection a;

        public c(b bVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2027565467, "Lc/a/d/f/j/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2027565467, "Lc/a/d/f/j/b/b;");
                return;
            }
        }
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2132c = 0L;
        this.f2133d = 0L;
        this.f2134e = 0L;
        this.f2135f = 0L;
        this.f2136g = 0L;
        this.f2137h = false;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.l = new a(this);
        this.m = new C0095b(this);
        this.n = new Timer();
        if (fVar != null) {
            this.a = fVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c().a = true;
            c.a.d.f.m.a.e(this.f2131b);
        }
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str != null && str.toLowerCase().contains("gzip")) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                c.a.d.f.p.i.c(byteArrayInputStream, byteArrayOutputStream);
                this.f2136g = System.currentTimeMillis();
                return byteArrayOutputStream.toByteArray();
            }
            if (this.f2136g == 0) {
                this.f2136g = System.currentTimeMillis();
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:136:0x030a */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02cc, code lost:
        r10.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02cf, code lost:
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d0, code lost:
        r7.w = r2;
        r7.x = r14;
        r7.y = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02d9, code lost:
        if ((r2 + r14) < r5) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02db, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02dd, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02de, code lost:
        r21.f2135f = java.lang.System.currentTimeMillis();
        c.a.d.f.m.a.c(r1);
        c.a.d.f.m.a.e(r21.f2131b);
        c.a.d.f.m.a.d(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02ef, code lost:
        return r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v56 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        String l;
        URL m;
        File i3;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z3;
        URL url;
        String str2;
        String headerField;
        int indexOf;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, iVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), eVar, Boolean.valueOf(z2)})) == null) {
            e eVar2 = eVar == null ? new e() : eVar;
            InputStream inputStream3 = null;
            try {
                l = this.a.b().l();
                eVar2.s = l;
                m = m(l, eVar2);
                this.f2131b = g(m, i2, i);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (this.a.c().a) {
                this.f2135f = System.currentTimeMillis();
                c.a.d.f.m.a.c(null);
                c.a.d.f.m.a.e(this.f2131b);
                c.a.d.f.m.a.d(null);
                return false;
            }
            if (z2) {
                c.a.d.f.p.h.k(str);
            }
            if (z) {
                i3 = new File(str);
            } else {
                i3 = c.a.d.f.p.h.i(str);
            }
            if (i3 != null) {
                long length = i3.length();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i3, true);
                    try {
                        this.a.b().u(this.f2131b);
                        this.f2131b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f2131b.connect();
                        if (this.f2132c <= 0) {
                            try {
                                this.f2132c = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                inputStream3 = null;
                            }
                        }
                        this.f2133d = System.currentTimeMillis();
                        int responseCode = this.f2131b.getResponseCode();
                        this.f2134e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.f2131b.getURL();
                            if (url != null) {
                                eVar2.r = url.toString();
                            }
                            if (url != null) {
                                i4 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), m.getProtocol())) {
                                    c.a.d.f.m.a.e(this.f2131b);
                                    this.f2131b = g(new URL(url.toString()), i2, i);
                                    this.a.b().u(this.f2131b);
                                    this.f2131b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.f2131b.connect();
                                    responseCode = this.f2131b.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i4 = responseCode;
                            }
                            responseCode = i4;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.a.c().f2163b = responseCode;
                        String headerField2 = this.f2131b.getHeaderField("Content-Range");
                        int e2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : c.a.d.f.m.b.e(headerField2.substring(indexOf + 1), 0);
                        if (e2 == 0 && this.a.c().f2163b == 200 && (headerField = this.f2131b.getHeaderField("Content-Length")) != null) {
                            e2 = c.a.d.f.m.b.e(headerField, 0);
                        }
                        this.a.c().f2167f = String.valueOf(e2);
                        if (!n()) {
                            str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + m + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (e2 > 0 && e2 == length) {
                                    this.f2135f = System.currentTimeMillis();
                                    c.a.d.f.m.a.c(null);
                                    c.a.d.f.m.a.e(this.f2131b);
                                    c.a.d.f.m.a.d(fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + e2;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.f2131b.getContentType() != null && this.f2131b.getContentType().contains("text/vnd.wap.wml")) {
                            this.f2131b.disconnect();
                            this.a.c().f2163b = 0;
                            boolean d2 = d(str, iVar, i, i2, z, eVar2, z2);
                            this.f2135f = System.currentTimeMillis();
                            c.a.d.f.m.a.c(null);
                            c.a.d.f.m.a.e(this.f2131b);
                            c.a.d.f.m.a.d(fileOutputStream2);
                            return d2;
                        } else {
                            eVar2.a = l.getBytes().length;
                            long length2 = this.f2131b.getHeaderFields().toString().getBytes().length;
                            eVar2.f2146b = length2;
                            long j = e2;
                            eVar2.f2146b = length2 + j;
                            if (e2 != 0 && length >= j) {
                                this.f2135f = System.currentTimeMillis();
                                this.f2135f = System.currentTimeMillis();
                                c.a.d.f.m.a.c(null);
                                c.a.d.f.m.a.e(this.f2131b);
                                c.a.d.f.m.a.d(fileOutputStream2);
                                return true;
                            }
                            inputStream2 = null;
                            try {
                                inputStream2 = this.f2131b.getInputStream();
                                byte[] bArr = new byte[1024];
                                int i5 = e2 > 0 ? e2 / 50 : 0;
                                if (iVar != null && length > 0) {
                                    iVar.onProgress((int) length, e2);
                                }
                                int i6 = 0;
                                loop0: while (true) {
                                    int i7 = 0;
                                    while (!this.a.c().a) {
                                        int read = inputStream2.read(bArr);
                                        if (read != -1) {
                                            try {
                                                fileOutputStream2.write(bArr, 0, read);
                                                i6 += read;
                                                i7 += read;
                                                if (iVar == null || (i7 <= i5 && i6 != e2)) {
                                                    bArr = bArr;
                                                } else {
                                                    byte[] bArr2 = bArr;
                                                    iVar.onProgress((int) (i6 + length), e2);
                                                    bArr = bArr2;
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                    }
                                    try {
                                        break loop0;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream3 = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                this.f2135f = System.currentTimeMillis();
                                c.a.d.f.m.a.c(inputStream3);
                                c.a.d.f.m.a.e(this.f2131b);
                                c.a.d.f.m.a.d(fileOutputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream2 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } else {
                inputStream = null;
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            inputStream3 = inputStream;
            fileOutputStream = inputStream;
            this.f2135f = System.currentTimeMillis();
            c.a.d.f.m.a.c(inputStream3);
            c.a.d.f.m.a.e(this.f2131b);
            c.a.d.f.m.a.d(fileOutputStream);
            throw th;
        }
        return invokeCommon.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2136g : invokeV.longValue;
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
            if (l.z()) {
                if (l.x() && (c2 = l.c()) != null && c2.length() > 0) {
                    if (l.F(c2) && l.D()) {
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
                            this.a.b().a("X-Online-Host", url.getHost());
                        } catch (Exception e2) {
                            e = e2;
                            httpsURLConnection = httpURLConnection;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, l.d())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.f2137h && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new j(httpsURLConnection2));
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

    public final HttpURLConnection g(URL url, int i, int i2) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, url, i, i2)) == null) {
            HttpURLConnection f2 = f(url);
            if (f2 != null) {
                f2.setConnectTimeout(i);
                f2.setReadTimeout(i2);
                return f2;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2134e : invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2132c : invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2133d : invokeV.longValue;
    }

    public void k(int i, int i2, e eVar) throws Exception {
        IHttpNet kVar;
        URL d2;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, eVar) == null) {
            eVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                if (!this.a.c().a) {
                    String f2 = this.a.b().f(eVar);
                    eVar.s = f2;
                    URL m = m(f2, eVar);
                    if (!this.a.c().a) {
                        eVar.j = -2;
                        if (((c.a.d.f.j.a.a) ServiceManager.getService(c.a.d.f.j.a.a.a)).netABTest()) {
                            kVar = new d(this.a, IHttpNet.HttpNetType.GET);
                        } else {
                            kVar = new k(this.a, IHttpNet.HttpNetType.GET);
                        }
                        IHttpNet iHttpNet2 = kVar;
                        iHttpNet2.e(m);
                        iHttpNet2.g(m, this.f2137h);
                        eVar.j = -3;
                        long currentTimeMillis = System.currentTimeMillis();
                        iHttpNet2.a(m, i2, i);
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            eVar.f2151g = new Date().getTime() - currentTimeMillis;
                            eVar.j = -4;
                            iHttpNet2.connect();
                            if (this.f2132c <= 0) {
                                this.f2132c = System.currentTimeMillis();
                            }
                            this.f2133d = System.currentTimeMillis();
                            eVar.j = -5;
                            eVar.f2147c = (new Date().getTime() - currentTimeMillis) - eVar.f2151g;
                            if (!this.a.c().a) {
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                if (this.a.b().n() && this.n != null && this.k >= 0 && this.k < 3) {
                                    this.n.schedule(this.m, (this.k + 1) * 3000);
                                }
                                this.f2134e = System.currentTimeMillis();
                                iHttpNet2.h();
                                eVar.j = -8;
                                if (f2.contains("c.tieba.baidu.com") && (map = this.a.c().f2169h) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    eVar.t = list.get(0);
                                    eVar.u = list.get(1);
                                }
                                if (this.a.c().f2163b == 302 && (d2 = iHttpNet2.d()) != null) {
                                    eVar.r = d2.toString();
                                }
                                eVar.i = this.a.c().f2163b;
                                eVar.f2146b = iHttpNet2.b().toString().getBytes().length;
                                if (this.n != null) {
                                    this.n.cancel();
                                }
                                if (execute != null) {
                                    eVar.f2146b += execute.length;
                                    this.a.c().i = c(this.a.c().f2165d, execute);
                                }
                                eVar.j = -9;
                                eVar.f2148d = new Date().getTime() - currentTimeMillis;
                                Timer timer = this.n;
                                if (timer != null) {
                                    timer.cancel();
                                }
                                iHttpNet2.disconnect();
                                return;
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.n;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2135f : invokeV.longValue;
    }

    public final URL m(String str, e eVar) throws Exception {
        InterceptResult invokeLL;
        c.a.d.f.j.b.a b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) != null) {
            return (URL) invokeLL.objValue;
        }
        String str2 = "hiphotos.baidu.com";
        boolean netABTest = ((c.a.d.f.j.a.a) ServiceManager.getService(c.a.d.f.j.a.a.a)).netABTest();
        URL url = new URL(str);
        if (netABTest && url.getProtocol().equals("https")) {
            return url;
        }
        if (!TextUtils.isEmpty(str) && this.i && this.j) {
            try {
                String host = url.getHost();
                if (!TextUtils.isEmpty(host)) {
                    if (!host.contains("hiphotos.baidu.com")) {
                        str2 = host;
                    }
                    BDHttpDnsResult r = BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).r(str2, true);
                    if (r != null) {
                        eVar.m = r.d();
                        eVar.o = r.c();
                        ArrayList<String> a2 = r.a();
                        if (a2 != null && a2.size() > 0) {
                            eVar.p = a2.toString();
                            int size = this.k % a2.size();
                            String str3 = a2.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url.getProtocol().equals("https"))) {
                                this.a.b().a("Host", str2);
                                URL url2 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.f2137h = true;
                                    eVar.q = size;
                                    eVar.l = str3;
                                    eVar.n = true;
                                    return url2;
                                } catch (Exception e2) {
                                    e = e2;
                                    url = url2;
                                    BdLog.e(e);
                                    return !this.j ? url : url;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        if (!this.j && (b2 = c.a.d.f.j.b.a.b()) != null) {
            String a3 = b2.a(str);
            if (TextUtils.isEmpty(a3)) {
                return url;
            }
            this.a.b().a("Host", url.getHost());
            URL url3 = new URL(str.replace("://" + url.getHost(), "://" + a3));
            this.f2137h = true;
            eVar.l = a3;
            return url3;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.c().f2163b == 200 || this.a.c().f2163b == 206 : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2137h : invokeV.booleanValue;
    }

    public void p(int i, int i2, e eVar) throws Exception {
        IHttpNet kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, eVar) == null) {
            eVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String l = this.a.b().l();
                eVar.s = l;
                URL m = m(l, eVar);
                if (!this.a.c().a) {
                    eVar.j = -2;
                    if (((c.a.d.f.j.a.a) ServiceManager.getService(c.a.d.f.j.a.a.a)).netABTest()) {
                        kVar = new d(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    } else {
                        kVar = new k(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    }
                    IHttpNet iHttpNet2 = kVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.f2137h);
                    eVar.j = -3;
                    System.currentTimeMillis();
                    iHttpNet2.a(m, i2, i);
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            long time = new Date().getTime();
                            eVar.f2151g = new Date().getTime() - time;
                            eVar.j = -4;
                            iHttpNet2.connect();
                            if (this.f2132c <= 0) {
                                this.f2132c = System.currentTimeMillis();
                            }
                            this.f2133d = System.currentTimeMillis();
                            eVar.j = -5;
                            eVar.f2147c = (new Date().getTime() - time) - eVar.f2151g;
                            if (!this.a.c().a) {
                                if (this.n != null) {
                                    this.n.schedule(this.l, 45000L);
                                }
                                eVar.j = -6;
                                iHttpNet2.c();
                                eVar.j = -7;
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                iHttpNet2.h();
                                this.f2134e = System.currentTimeMillis();
                                if (!this.a.c().a) {
                                    eVar.j = -8;
                                    eVar.i = this.a.c().f2163b;
                                    long length = iHttpNet2.b().toString().getBytes().length;
                                    eVar.f2146b = length;
                                    if (execute != null) {
                                        eVar.f2146b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().f2165d, execute);
                                    }
                                    eVar.f2148d = new Date().getTime() - time;
                                    eVar.j = -9;
                                    Timer timer = this.n;
                                    if (timer != null) {
                                        timer.cancel();
                                    }
                                    iHttpNet2.disconnect();
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
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.n;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public void q(int i, int i2, e eVar) throws Exception {
        IHttpNet kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i, i2, eVar) == null) {
            eVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String l = this.a.b().l();
                eVar.s = l;
                URL m = m(l, eVar);
                if (!this.a.c().a) {
                    eVar.j = -2;
                    if (((c.a.d.f.j.a.a) ServiceManager.getService(c.a.d.f.j.a.a.a)).netABTest()) {
                        kVar = new d(this.a, IHttpNet.HttpNetType.POST_FORM);
                    } else {
                        kVar = new k(this.a, IHttpNet.HttpNetType.POST_FORM);
                    }
                    IHttpNet iHttpNet2 = kVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.f2137h);
                    iHttpNet2.a(m, i2, i);
                    eVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            eVar.f2151g = System.currentTimeMillis() - currentTimeMillis;
                            eVar.j = -4;
                            iHttpNet2.connect();
                            if (this.f2132c <= 0) {
                                this.f2132c = System.currentTimeMillis();
                            }
                            this.f2133d = System.currentTimeMillis();
                            eVar.j = -5;
                            eVar.f2147c = (System.currentTimeMillis() - currentTimeMillis) - eVar.f2151g;
                            if (!this.a.c().a) {
                                eVar.j = -6;
                                eVar.a = iHttpNet2.c();
                                eVar.j = -7;
                                if (!this.a.c().a) {
                                    iHttpNet2.h();
                                    this.f2134e = System.currentTimeMillis();
                                    eVar.j = -8;
                                    byte[] execute = iHttpNet2.execute();
                                    this.f2135f = System.currentTimeMillis();
                                    this.a.c().a(iHttpNet2);
                                    eVar.i = this.a.c().f2163b;
                                    long length = this.a.c().f2169h.toString().getBytes().length;
                                    eVar.f2146b = length;
                                    if (execute != null) {
                                        eVar.f2146b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().f2165d, execute);
                                    }
                                    eVar.f2148d = new Date().getTime() - currentTimeMillis;
                                    eVar.j = -9;
                                    iHttpNet2.disconnect();
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
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.k = i;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.i = z;
        }
    }
}
