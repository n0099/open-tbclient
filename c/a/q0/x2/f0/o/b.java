package c.a.q0.x2.f0.o;

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
    public static String f28799i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28800a;

    /* renamed from: b  reason: collision with root package name */
    public g f28801b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f28802c;

    /* renamed from: d  reason: collision with root package name */
    public long f28803d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28804e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28805f;

    /* renamed from: g  reason: collision with root package name */
    public TimerTask f28806g;

    /* renamed from: h  reason: collision with root package name */
    public Timer f28807h;

    /* loaded from: classes4.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28808e;

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
            this.f28808e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f28808e.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2085903955, "Lc/a/q0/x2/f0/o/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2085903955, "Lc/a/q0/x2/f0/o/b;");
                return;
            }
        }
        Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        f28799i = "--------7da3d81520810*";
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
        this.f28803d = 0L;
        this.f28804e = false;
        this.f28805f = true;
        this.f28806g = new a(this);
        this.f28807h = new Timer();
        if (gVar != null) {
            this.f28801b = gVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28801b.b().f28837a = true;
            c.a.e.e.m.a.e(this.f28802c);
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
            this.f28800a = 0;
            e eVar2 = eVar == null ? new e() : eVar;
            InputStream inputStream3 = null;
            try {
                e2 = this.f28801b.a().e();
                eVar2.f28829j = e2;
                HttpURLConnection e3 = e(i(e2, eVar2), i3, i2);
                this.f28802c = e3;
                e3.setInstanceFollowRedirects(true);
                HttpURLConnection.setFollowRedirects(false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (this.f28801b.b().f28837a) {
                System.currentTimeMillis();
                c.a.e.e.m.a.c(null);
                c.a.e.e.m.a.e(this.f28802c);
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
                        this.f28801b.a().j(this.f28802c);
                        this.f28802c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f28802c.connect();
                        if (this.f28803d <= 0) {
                            try {
                                this.f28803d = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                inputStream3 = null;
                            }
                        }
                        System.currentTimeMillis();
                        int responseCode = this.f28802c.getResponseCode();
                        while (l(responseCode) && this.f28800a <= 5) {
                            this.f28802c = j(this.f28802c, i3, i2);
                            this.f28801b.a().j(this.f28802c);
                            this.f28802c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                            this.f28802c.connect();
                            responseCode = this.f28802c.getResponseCode();
                        }
                        System.currentTimeMillis();
                        this.f28801b.b().f28838b = responseCode;
                        if (k()) {
                            if (this.f28802c.getContentType() != null && this.f28802c.getContentType().contains("text/vnd.wap.wml")) {
                                this.f28802c.disconnect();
                                this.f28801b.b().f28838b = 0;
                                boolean c2 = c(str, jVar, i2, i3, z, eVar2, z2);
                                System.currentTimeMillis();
                                c.a.e.e.m.a.c(null);
                                c.a.e.e.m.a.e(this.f28802c);
                                c.a.e.e.m.a.d(fileOutputStream2);
                                return c2;
                            }
                            String headerField2 = this.f28802c.getHeaderField("Content-Range");
                            int d2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : c.a.e.e.m.b.d(headerField2.substring(indexOf + 1), 0);
                            if (d2 == 0 && this.f28801b.b().f28838b == 200 && (headerField = this.f28802c.getHeaderField("Content-Length")) != null) {
                                d2 = c.a.e.e.m.b.d(headerField, 0);
                            }
                            this.f28801b.b().f28841e = String.valueOf(d2);
                            eVar2.f28820a = e2.getBytes().length;
                            long length2 = this.f28802c.getHeaderFields().toString().getBytes().length;
                            eVar2.f28821b = length2;
                            long j2 = d2;
                            eVar2.f28821b = length2 + j2;
                            if (this.f28801b.b().f28838b != 416 && this.f28801b.b().f28838b != 204) {
                                if (d2 != 0 && length >= j2) {
                                    System.currentTimeMillis();
                                    System.currentTimeMillis();
                                    c.a.e.e.m.a.c(null);
                                    c.a.e.e.m.a.e(this.f28802c);
                                    c.a.e.e.m.a.d(fileOutputStream2);
                                    return true;
                                }
                                InputStream inputStream4 = this.f28802c.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    int i5 = d2 > 0 ? d2 / 50 : 0;
                                    if (jVar != null && length > 0) {
                                        jVar.onProgress((int) length, d2);
                                    }
                                    int i6 = 0;
                                    loop1: while (true) {
                                        int i7 = 0;
                                        while (!this.f28801b.b().f28837a && (read = inputStream4.read(bArr)) != -1) {
                                            try {
                                                fileOutputStream2.write(bArr, 0, read);
                                                i6 += read;
                                                i7 += read;
                                                if (jVar != null && (i7 > i5 || i6 == d2)) {
                                                    jVar.onProgress((int) (i6 + length), d2);
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
                                        c.a.e.e.m.a.e(this.f28802c);
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
                            c.a.e.e.m.a.e(this.f28802c);
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
                            c.a.e.e.m.a.e(this.f28802c);
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
            c.a.e.e.m.a.e(this.f28802c);
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
                            this.f28801b.a().a("X-Online-Host", url.getHost());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28803d : invokeV.longValue;
    }

    public void g(int i2, int i3, e eVar) throws Exception {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, eVar) == null) {
            eVar.f28827h = -1;
            if (!this.f28801b.b().f28837a) {
                String c2 = this.f28801b.a().c(eVar);
                eVar.f28829j = c2;
                URL i4 = i(c2, eVar);
                if (!this.f28801b.b().f28837a) {
                    eVar.f28827h = -2;
                    this.f28802c = d(i4);
                    eVar.f28827h = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (this.f28802c != null) {
                            this.f28802c.setRequestMethod("GET");
                            this.f28802c.setConnectTimeout(i3);
                            this.f28802c.setReadTimeout(i2);
                            this.f28801b.a().j(this.f28802c);
                            if (!this.f28801b.b().f28837a) {
                                eVar.f28824e = new Date().getTime() - currentTimeMillis;
                                eVar.f28827h = -4;
                                this.f28802c.connect();
                                if (this.f28803d <= 0) {
                                    this.f28803d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                eVar.f28827h = -5;
                                eVar.f28822c = (new Date().getTime() - currentTimeMillis) - eVar.f28824e;
                                if (!this.f28801b.b().f28837a) {
                                    String contentType = this.f28802c.getContentType();
                                    System.currentTimeMillis();
                                    if (f.a(contentType)) {
                                        this.f28802c.disconnect();
                                        this.f28802c.connect();
                                        if (this.f28801b.b().f28837a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    eVar.f28827h = -8;
                                    this.f28801b.b().a(this.f28802c);
                                    if (c2.contains("c.tieba.baidu.com") && (map = this.f28801b.b().f28842f) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                        eVar.k = list.get(0);
                                        eVar.l = list.get(1);
                                    }
                                    eVar.f28826g = this.f28801b.b().f28838b;
                                    eVar.f28821b = this.f28802c.getHeaderFields().toString().getBytes().length;
                                    byte[] h2 = h(this.f28802c);
                                    if (h2 != null) {
                                        eVar.f28821b += h2.length;
                                        this.f28801b.b().f28843g = b(this.f28801b.b().f28840d, h2);
                                    }
                                    eVar.f28827h = -9;
                                    eVar.f28823d = new Date().getTime() - currentTimeMillis;
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
                        httpURLConnection = this.f28802c;
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
                    while (!this.f28801b.b().f28837a && (read = inputStream2.read(bArr2)) != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    if (!this.f28801b.b().f28837a) {
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
        c.a.q0.x2.f0.o.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, eVar)) == null) {
            URL url = new URL(str);
            if (!this.f28805f || (b2 = c.a.q0.x2.f0.o.a.b()) == null) {
                return url;
            }
            String a2 = b2.a(str);
            if (TextUtils.isEmpty(a2)) {
                return url;
            }
            this.f28801b.a().a("Host", url.getHost());
            URL url2 = new URL(str.replace("://" + url.getHost(), "://" + a2));
            this.f28804e = true;
            eVar.f28828i = a2;
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
            this.f28800a++;
            return e2;
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28801b.b().f28838b == 200 || this.f28801b.b().f28838b == 206 : invokeV.booleanValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 == 302 || i2 == 301 || i2 == 304 || i2 == 300 || i2 == 307 || i2 == 308 || i2 == 303 : invokeI.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f28804e : invokeV.booleanValue;
    }

    public void n(int i2, int i3, e eVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, eVar) == null) {
            eVar.f28827h = -1;
            try {
                String e2 = this.f28801b.a().e();
                eVar.f28829j = e2;
                URL i4 = i(e2, eVar);
                if (!this.f28801b.b().f28837a) {
                    eVar.f28827h = -2;
                    this.f28802c = d(i4);
                    eVar.f28827h = -3;
                    System.currentTimeMillis();
                    if (this.f28802c != null) {
                        this.f28802c.setRequestMethod("POST");
                        this.f28802c.setDoOutput(true);
                        this.f28802c.setDoInput(true);
                        this.f28802c.setConnectTimeout(i3);
                        this.f28802c.setReadTimeout(i2);
                        this.f28802c.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + f28799i);
                        if (!this.f28801b.b().f28837a) {
                            this.f28801b.a().j(this.f28802c);
                            if (!this.f28801b.b().f28837a) {
                                long time = new Date().getTime();
                                eVar.f28824e = new Date().getTime() - time;
                                eVar.f28827h = -4;
                                this.f28802c.connect();
                                if (this.f28803d <= 0) {
                                    this.f28803d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                eVar.f28827h = -5;
                                eVar.f28822c = (new Date().getTime() - time) - eVar.f28824e;
                                if (!this.f28801b.b().f28837a) {
                                    if (this.f28807h != null) {
                                        this.f28807h.schedule(this.f28806g, 45000L);
                                    }
                                    eVar.f28827h = -6;
                                    this.f28801b.a().l(this.f28802c, f28799i, eVar);
                                    eVar.f28827h = -7;
                                    String contentType = this.f28802c.getContentType();
                                    System.currentTimeMillis();
                                    if (f.a(contentType)) {
                                        this.f28802c.disconnect();
                                        this.f28802c.connect();
                                        if (this.f28801b.b().f28837a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    if (!this.f28801b.b().f28837a) {
                                        eVar.f28827h = -8;
                                        this.f28801b.b().a(this.f28802c);
                                        eVar.f28826g = this.f28801b.b().f28838b;
                                        eVar.f28821b = this.f28802c.getHeaderFields().toString().getBytes().length;
                                        byte[] h2 = h(this.f28802c);
                                        if (h2 != null) {
                                            eVar.f28821b += h2.length;
                                            this.f28801b.b().f28844h = h2.length;
                                            this.f28801b.b().f28843g = b(this.f28801b.b().f28840d, h2);
                                        }
                                        eVar.f28823d = new Date().getTime() - time;
                                        eVar.f28827h = -9;
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
                Timer timer = this.f28807h;
                if (timer != null) {
                    timer.cancel();
                }
                c.a.e.e.m.a.e(this.f28802c);
            }
        }
    }

    public void o(int i2, int i3, e eVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, eVar) == null) {
            eVar.f28827h = -1;
            try {
                String e2 = this.f28801b.a().e();
                eVar.f28829j = e2;
                URL i4 = i(e2, eVar);
                if (!this.f28801b.b().f28837a) {
                    eVar.f28827h = -2;
                    this.f28802c = d(i4);
                    eVar.f28827h = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.f28802c != null) {
                        this.f28802c.setRequestMethod("POST");
                        this.f28802c.setDoOutput(true);
                        this.f28802c.setDoInput(true);
                        this.f28802c.setConnectTimeout(i3);
                        this.f28802c.setReadTimeout(i2);
                        this.f28802c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        if (!this.f28801b.b().f28837a) {
                            this.f28801b.a().j(this.f28802c);
                            if (!this.f28801b.b().f28837a) {
                                eVar.f28824e = System.currentTimeMillis() - currentTimeMillis;
                                eVar.f28827h = -4;
                                this.f28802c.connect();
                                if (this.f28803d <= 0) {
                                    this.f28803d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                eVar.f28827h = -5;
                                eVar.f28822c = (System.currentTimeMillis() - currentTimeMillis) - eVar.f28824e;
                                if (!this.f28801b.b().f28837a) {
                                    eVar.f28827h = -6;
                                    this.f28801b.a().k(this.f28802c, eVar);
                                    eVar.f28827h = -7;
                                    if (!this.f28801b.b().f28837a) {
                                        String contentType = this.f28802c.getContentType();
                                        System.currentTimeMillis();
                                        if (f.a(contentType)) {
                                            this.f28802c.disconnect();
                                            this.f28802c.connect();
                                            if (this.f28801b.b().f28837a) {
                                                throw new BdHttpCancelException();
                                            }
                                        }
                                        this.f28801b.b().a(this.f28802c);
                                        eVar.f28827h = -8;
                                        eVar.f28826g = this.f28801b.b().f28838b;
                                        eVar.f28821b = this.f28802c.getHeaderFields().toString().getBytes().length;
                                        byte[] h2 = h(this.f28802c);
                                        if (h2 != null) {
                                            eVar.f28821b += h2.length;
                                            this.f28801b.b().f28844h = h2.length;
                                            this.f28801b.b().f28843g = b(this.f28801b.b().f28840d, h2);
                                        }
                                        eVar.f28823d = new Date().getTime() - currentTimeMillis;
                                        eVar.f28827h = -9;
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
                c.a.e.e.m.a.e(this.f28802c);
            }
        }
    }
}
