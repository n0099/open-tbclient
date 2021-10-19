package c.a.r0.z2.f0.o;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static String f29612i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29613a;

    /* renamed from: b  reason: collision with root package name */
    public g f29614b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f29615c;

    /* renamed from: d  reason: collision with root package name */
    public long f29616d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29617e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29618f;

    /* renamed from: g  reason: collision with root package name */
    public TimerTask f29619g;

    /* renamed from: h  reason: collision with root package name */
    public Timer f29620h;

    /* loaded from: classes4.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29621e;

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
            this.f29621e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f29621e.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1399473938, "Lc/a/r0/z2/f0/o/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1399473938, "Lc/a/r0/z2/f0/o/b;");
                return;
            }
        }
        Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        f29612i = "--------7da3d81520810*";
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29616d = 0L;
        this.f29617e = false;
        this.f29618f = true;
        this.f29619g = new a(this);
        this.f29620h = new Timer();
        if (gVar != null) {
            this.f29614b = gVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29614b.b().f29650a = true;
            c.a.e.e.m.a.e(this.f29615c);
        }
    }

    public final byte[] b(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str == null || !str.toLowerCase().contains(AsyncHttpClient.ENCODING_GZIP)) {
                return bArr;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            c.a.e.e.p.g.c(byteArrayInputStream, byteArrayOutputStream);
            System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x028d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v45 */
    public boolean c(String str, j jVar, int i2, int i3, boolean z, e eVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        String e2;
        File i4;
        InputStream inputStream;
        InputStream inputStream2;
        int read;
        String headerField;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, jVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), eVar, Boolean.valueOf(z2)})) == null) {
            this.f29613a = 0;
            e eVar2 = eVar == null ? new e() : eVar;
            InputStream inputStream3 = null;
            try {
                e2 = this.f29614b.a().e();
                eVar2.f29642j = e2;
                HttpURLConnection e3 = e(i(e2, eVar2), i3, i2);
                this.f29615c = e3;
                e3.setInstanceFollowRedirects(true);
                HttpURLConnection.setFollowRedirects(false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (this.f29614b.b().f29650a) {
                System.currentTimeMillis();
                c.a.e.e.m.a.c(null);
                c.a.e.e.m.a.e(this.f29615c);
                c.a.e.e.m.a.d(null);
                return false;
            }
            if (z2) {
                c.a.e.e.p.f.k(str);
            }
            if (z) {
                i4 = new File(str);
            } else {
                i4 = c.a.e.e.p.f.i(str);
            }
            if (i4 != null) {
                long length = i4.length();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i4, true);
                    try {
                        this.f29614b.a().j(this.f29615c);
                        this.f29615c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f29615c.connect();
                        if (this.f29616d <= 0) {
                            try {
                                this.f29616d = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                inputStream3 = null;
                            }
                        }
                        System.currentTimeMillis();
                        int responseCode = this.f29615c.getResponseCode();
                        while (l(responseCode) && this.f29613a <= 5) {
                            this.f29615c = j(this.f29615c, i3, i2);
                            this.f29614b.a().j(this.f29615c);
                            this.f29615c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                            this.f29615c.connect();
                            responseCode = this.f29615c.getResponseCode();
                        }
                        System.currentTimeMillis();
                        this.f29614b.b().f29651b = responseCode;
                        if (k()) {
                            if (this.f29615c.getContentType() != null && this.f29615c.getContentType().contains("text/vnd.wap.wml")) {
                                this.f29615c.disconnect();
                                this.f29614b.b().f29651b = 0;
                                boolean c2 = c(str, jVar, i2, i3, z, eVar2, z2);
                                System.currentTimeMillis();
                                c.a.e.e.m.a.c(null);
                                c.a.e.e.m.a.e(this.f29615c);
                                c.a.e.e.m.a.d(fileOutputStream2);
                                return c2;
                            }
                            String headerField2 = this.f29615c.getHeaderField("Content-Range");
                            int e4 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : c.a.e.e.m.b.e(headerField2.substring(indexOf + 1), 0);
                            if (e4 == 0 && this.f29614b.b().f29651b == 200 && (headerField = this.f29615c.getHeaderField("Content-Length")) != null) {
                                e4 = c.a.e.e.m.b.e(headerField, 0);
                            }
                            this.f29614b.b().f29654e = String.valueOf(e4);
                            eVar2.f29633a = e2.getBytes().length;
                            long length2 = this.f29615c.getHeaderFields().toString().getBytes().length;
                            eVar2.f29634b = length2;
                            long j2 = e4;
                            eVar2.f29634b = length2 + j2;
                            if (this.f29614b.b().f29651b != 416 && this.f29614b.b().f29651b != 204) {
                                if (e4 != 0 && length >= j2) {
                                    System.currentTimeMillis();
                                    System.currentTimeMillis();
                                    c.a.e.e.m.a.c(null);
                                    c.a.e.e.m.a.e(this.f29615c);
                                    c.a.e.e.m.a.d(fileOutputStream2);
                                    return true;
                                }
                                InputStream inputStream4 = this.f29615c.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    int i5 = e4 > 0 ? e4 / 50 : 0;
                                    if (jVar != null && length > 0) {
                                        jVar.onProgress((int) length, e4);
                                    }
                                    int i6 = 0;
                                    loop1: while (true) {
                                        int i7 = 0;
                                        while (!this.f29614b.b().f29650a && (read = inputStream4.read(bArr)) != -1) {
                                            try {
                                                fileOutputStream2.write(bArr, 0, read);
                                                i6 += read;
                                                i7 += read;
                                                if (jVar != null && (i7 > i5 || i6 == e4)) {
                                                    jVar.onProgress((int) (i6 + length), e4);
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                    }
                                    try {
                                        fileOutputStream2.flush();
                                        boolean z3 = ((long) i6) + length >= j2;
                                        System.currentTimeMillis();
                                        c.a.e.e.m.a.c(inputStream4);
                                        c.a.e.e.m.a.e(this.f29615c);
                                        c.a.e.e.m.a.d(fileOutputStream2);
                                        return z3;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream2;
                                    inputStream3 = inputStream4;
                                }
                            }
                            System.currentTimeMillis();
                            c.a.e.e.m.a.c(null);
                            c.a.e.e.m.a.e(this.f29615c);
                            c.a.e.e.m.a.d(fileOutputStream2);
                            return true;
                        }
                        inputStream2 = null;
                        try {
                            throw new UnsupportedOperationException();
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream3 = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            System.currentTimeMillis();
                            c.a.e.e.m.a.c(inputStream3);
                            c.a.e.e.m.a.e(this.f29615c);
                            c.a.e.e.m.a.d(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } else {
                inputStream = null;
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th7) {
                    th = th7;
                }
            }
            inputStream3 = inputStream;
            fileOutputStream = inputStream;
            System.currentTimeMillis();
            c.a.e.e.m.a.c(inputStream3);
            c.a.e.e.m.a.e(this.f29615c);
            c.a.e.e.m.a.d(fileOutputStream);
            throw th;
        }
        return invokeCommon.booleanValue;
    }

    public final HttpURLConnection d(URL url) {
        InterceptResult invokeL;
        String c2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, url)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (c.a.e.e.p.j.z()) {
                if (c.a.e.e.p.j.x() && (c2 = c.a.e.e.p.j.c()) != null && c2.length() > 0) {
                    if (c.a.e.e.p.j.F(c2) && c.a.e.e.p.j.D()) {
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
                            this.f29614b.a().a("X-Online-Host", url.getHost());
                        } catch (Exception e2) {
                            e = e2;
                            httpURLConnection2 = httpURLConnection;
                            e.printStackTrace();
                            return httpURLConnection2;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, c.a.e.e.p.j.d())));
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                return httpURLConnection2 == null ? (HttpURLConnection) url.openConnection() : httpURLConnection2;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final HttpURLConnection e(URL url, int i2, int i3) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, url, i2, i3)) == null) {
            HttpURLConnection d2 = d(url);
            if (d2 != null) {
                d2.setConnectTimeout(i2);
                d2.setReadTimeout(i3);
                return d2;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29616d : invokeV.longValue;
    }

    public void g(int i2, int i3, e eVar) throws Exception {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, eVar) == null) {
            eVar.f29640h = -1;
            if (!this.f29614b.b().f29650a) {
                String c2 = this.f29614b.a().c(eVar);
                eVar.f29642j = c2;
                URL i4 = i(c2, eVar);
                if (!this.f29614b.b().f29650a) {
                    eVar.f29640h = -2;
                    this.f29615c = d(i4);
                    eVar.f29640h = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (this.f29615c != null) {
                            this.f29615c.setRequestMethod("GET");
                            this.f29615c.setConnectTimeout(i3);
                            this.f29615c.setReadTimeout(i2);
                            this.f29614b.a().j(this.f29615c);
                            if (!this.f29614b.b().f29650a) {
                                eVar.f29637e = new Date().getTime() - currentTimeMillis;
                                eVar.f29640h = -4;
                                this.f29615c.connect();
                                if (this.f29616d <= 0) {
                                    this.f29616d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                eVar.f29640h = -5;
                                eVar.f29635c = (new Date().getTime() - currentTimeMillis) - eVar.f29637e;
                                if (!this.f29614b.b().f29650a) {
                                    String contentType = this.f29615c.getContentType();
                                    System.currentTimeMillis();
                                    if (f.a(contentType)) {
                                        this.f29615c.disconnect();
                                        this.f29615c.connect();
                                        if (this.f29614b.b().f29650a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    eVar.f29640h = -8;
                                    this.f29614b.b().a(this.f29615c);
                                    if (c2.contains("c.tieba.baidu.com") && (map = this.f29614b.b().f29655f) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                        eVar.k = list.get(0);
                                        eVar.l = list.get(1);
                                    }
                                    eVar.f29639g = this.f29614b.b().f29651b;
                                    eVar.f29634b = this.f29615c.getHeaderFields().toString().getBytes().length;
                                    byte[] h2 = h(this.f29615c);
                                    if (h2 != null) {
                                        eVar.f29634b += h2.length;
                                        this.f29614b.b().f29656g = b(this.f29614b.b().f29653d, h2);
                                    }
                                    eVar.f29640h = -9;
                                    eVar.f29636d = new Date().getTime() - currentTimeMillis;
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
                        httpURLConnection = this.f29615c;
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

    public final byte[] h(HttpURLConnection httpURLConnection) throws Exception {
        InterceptResult invokeL;
        InputStream inputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpURLConnection)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = null;
            if (httpURLConnection != null) {
                try {
                    byte[] bArr2 = new byte[1024];
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    while (!this.f29614b.b().f29650a && (read = inputStream2.read(bArr2)) != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    if (!this.f29614b.b().f29650a) {
                        bArr = byteArrayOutputStream.toByteArray();
                        inputStream = inputStream2;
                    } else {
                        throw new BdHttpCancelException();
                    }
                } catch (Throwable th) {
                    System.currentTimeMillis();
                    c.a.e.e.m.a.d(byteArrayOutputStream);
                    c.a.e.e.m.a.c(null);
                    throw th;
                }
            } else {
                inputStream = null;
            }
            System.currentTimeMillis();
            c.a.e.e.m.a.d(byteArrayOutputStream);
            c.a.e.e.m.a.c(inputStream);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final URL i(String str, e eVar) throws Exception {
        InterceptResult invokeLL;
        c.a.r0.z2.f0.o.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, eVar)) == null) {
            URL url = new URL(str);
            if (!this.f29618f || (b2 = c.a.r0.z2.f0.o.a.b()) == null) {
                return url;
            }
            String a2 = b2.a(str);
            if (TextUtils.isEmpty(a2)) {
                return url;
            }
            this.f29614b.a().a("Host", url.getHost());
            URL url2 = new URL(str.replace("://" + url.getHost(), "://" + a2));
            this.f29617e = true;
            eVar.f29641i = a2;
            return url2;
        }
        return (URL) invokeLL.objValue;
    }

    public final HttpURLConnection j(HttpURLConnection httpURLConnection, int i2, int i3) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, httpURLConnection, i2, i3)) == null) {
            if (httpURLConnection == null) {
                return null;
            }
            URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField("Location")).toURL();
            c.a.e.e.m.a.e(httpURLConnection);
            HttpURLConnection e2 = e(url, i2, i3);
            this.f29613a++;
            return e2;
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29614b.b().f29651b == 200 || this.f29614b.b().f29651b == 206 : invokeV.booleanValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 == 302 || i2 == 301 || i2 == 304 || i2 == 300 || i2 == 307 || i2 == 308 || i2 == 303 : invokeI.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f29617e : invokeV.booleanValue;
    }

    public void n(int i2, int i3, e eVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, eVar) == null) {
            eVar.f29640h = -1;
            try {
                String e2 = this.f29614b.a().e();
                eVar.f29642j = e2;
                URL i4 = i(e2, eVar);
                if (!this.f29614b.b().f29650a) {
                    eVar.f29640h = -2;
                    this.f29615c = d(i4);
                    eVar.f29640h = -3;
                    System.currentTimeMillis();
                    if (this.f29615c != null) {
                        this.f29615c.setRequestMethod("POST");
                        this.f29615c.setDoOutput(true);
                        this.f29615c.setDoInput(true);
                        this.f29615c.setConnectTimeout(i3);
                        this.f29615c.setReadTimeout(i2);
                        this.f29615c.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + f29612i);
                        if (!this.f29614b.b().f29650a) {
                            this.f29614b.a().j(this.f29615c);
                            if (!this.f29614b.b().f29650a) {
                                long time = new Date().getTime();
                                eVar.f29637e = new Date().getTime() - time;
                                eVar.f29640h = -4;
                                this.f29615c.connect();
                                if (this.f29616d <= 0) {
                                    this.f29616d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                eVar.f29640h = -5;
                                eVar.f29635c = (new Date().getTime() - time) - eVar.f29637e;
                                if (!this.f29614b.b().f29650a) {
                                    if (this.f29620h != null) {
                                        this.f29620h.schedule(this.f29619g, 45000L);
                                    }
                                    eVar.f29640h = -6;
                                    this.f29614b.a().l(this.f29615c, f29612i, eVar);
                                    eVar.f29640h = -7;
                                    String contentType = this.f29615c.getContentType();
                                    System.currentTimeMillis();
                                    if (f.a(contentType)) {
                                        this.f29615c.disconnect();
                                        this.f29615c.connect();
                                        if (this.f29614b.b().f29650a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    if (!this.f29614b.b().f29650a) {
                                        eVar.f29640h = -8;
                                        this.f29614b.b().a(this.f29615c);
                                        eVar.f29639g = this.f29614b.b().f29651b;
                                        eVar.f29634b = this.f29615c.getHeaderFields().toString().getBytes().length;
                                        byte[] h2 = h(this.f29615c);
                                        if (h2 != null) {
                                            eVar.f29634b += h2.length;
                                            this.f29614b.b().f29657h = h2.length;
                                            this.f29614b.b().f29656g = b(this.f29614b.b().f29653d, h2);
                                        }
                                        eVar.f29636d = new Date().getTime() - time;
                                        eVar.f29640h = -9;
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
                Timer timer = this.f29620h;
                if (timer != null) {
                    timer.cancel();
                }
                c.a.e.e.m.a.e(this.f29615c);
            }
        }
    }

    public void o(int i2, int i3, e eVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, eVar) == null) {
            eVar.f29640h = -1;
            try {
                String e2 = this.f29614b.a().e();
                eVar.f29642j = e2;
                URL i4 = i(e2, eVar);
                if (!this.f29614b.b().f29650a) {
                    eVar.f29640h = -2;
                    this.f29615c = d(i4);
                    eVar.f29640h = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.f29615c != null) {
                        this.f29615c.setRequestMethod("POST");
                        this.f29615c.setDoOutput(true);
                        this.f29615c.setDoInput(true);
                        this.f29615c.setConnectTimeout(i3);
                        this.f29615c.setReadTimeout(i2);
                        this.f29615c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        if (!this.f29614b.b().f29650a) {
                            this.f29614b.a().j(this.f29615c);
                            if (!this.f29614b.b().f29650a) {
                                eVar.f29637e = System.currentTimeMillis() - currentTimeMillis;
                                eVar.f29640h = -4;
                                this.f29615c.connect();
                                if (this.f29616d <= 0) {
                                    this.f29616d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                eVar.f29640h = -5;
                                eVar.f29635c = (System.currentTimeMillis() - currentTimeMillis) - eVar.f29637e;
                                if (!this.f29614b.b().f29650a) {
                                    eVar.f29640h = -6;
                                    this.f29614b.a().k(this.f29615c, eVar);
                                    eVar.f29640h = -7;
                                    if (!this.f29614b.b().f29650a) {
                                        String contentType = this.f29615c.getContentType();
                                        System.currentTimeMillis();
                                        if (f.a(contentType)) {
                                            this.f29615c.disconnect();
                                            this.f29615c.connect();
                                            if (this.f29614b.b().f29650a) {
                                                throw new BdHttpCancelException();
                                            }
                                        }
                                        this.f29614b.b().a(this.f29615c);
                                        eVar.f29640h = -8;
                                        eVar.f29639g = this.f29614b.b().f29651b;
                                        eVar.f29634b = this.f29615c.getHeaderFields().toString().getBytes().length;
                                        byte[] h2 = h(this.f29615c);
                                        if (h2 != null) {
                                            eVar.f29634b += h2.length;
                                            this.f29614b.b().f29657h = h2.length;
                                            this.f29614b.b().f29656g = b(this.f29614b.b().f29653d, h2);
                                        }
                                        eVar.f29636d = new Date().getTime() - currentTimeMillis;
                                        eVar.f29640h = -9;
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
                c.a.e.e.m.a.e(this.f29615c);
            }
        }
    }
}
