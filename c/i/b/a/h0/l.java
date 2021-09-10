package c.i.b.a.h0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class l implements HttpDataSource {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern q;
    public static final AtomicReference<byte[]> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f33743a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33744b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33745c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33746d;

    /* renamed from: e  reason: collision with root package name */
    public final c.i.b.a.i0.n<String> f33747e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpDataSource.b f33748f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpDataSource.b f33749g;

    /* renamed from: h  reason: collision with root package name */
    public final p<? super l> f33750h;

    /* renamed from: i  reason: collision with root package name */
    public g f33751i;

    /* renamed from: j  reason: collision with root package name */
    public HttpURLConnection f33752j;
    public InputStream k;
    public boolean l;
    public long m;
    public long n;
    public long o;
    public long p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-718020227, "Lc/i/b/a/h0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-718020227, "Lc/i/b/a/h0/l;");
                return;
            }
        }
        q = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
        r = new AtomicReference<>();
    }

    public l(String str, c.i.b.a.i0.n<String> nVar, p<? super l> pVar, int i2, int i3, boolean z, HttpDataSource.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, nVar, pVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.d(str);
        this.f33746d = str;
        this.f33747e = nVar;
        this.f33750h = pVar;
        this.f33749g = new HttpDataSource.b();
        this.f33744b = i2;
        this.f33745c = i3;
        this.f33743a = z;
        this.f33748f = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long d(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        long parseLong;
        String headerField;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, httpURLConnection)) != null) {
            return invokeL.longValue;
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                String str = "Unexpected Content-Length [" + headerField2 + PreferencesUtil.RIGHT_MOUNT;
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                Matcher matcher = q.matcher(headerField);
                if (matcher.find()) {
                    try {
                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            String str2 = "Inconsistent headers [" + headerField2 + "] [" + headerField + PreferencesUtil.RIGHT_MOUNT;
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        String str3 = "Unexpected Content-Range [" + headerField + PreferencesUtil.RIGHT_MOUNT;
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField)) {
        }
    }

    public static URL e(URL url, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, url, str)) == null) {
            if (str != null) {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if ("https".equals(protocol) || "http".equals(protocol)) {
                    return url2;
                }
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            throw new ProtocolException("Null location redirect");
        }
        return (URL) invokeLL.objValue;
    }

    public static void h(HttpURLConnection httpURLConnection, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, httpURLConnection, j2) == null) {
            int i2 = v.f33838a;
            if (i2 == 19 || i2 == 20) {
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (j2 == -1) {
                        if (inputStream.read() == -1) {
                            return;
                        }
                    } else if (j2 <= 2048) {
                        return;
                    }
                    String name = inputStream.getClass().getName();
                    if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                        Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(inputStream, new Object[0]);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws HttpDataSource.HttpDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            this.f33751i = gVar;
            long j2 = 0;
            this.p = 0L;
            this.o = 0L;
            try {
                HttpURLConnection f2 = f(gVar);
                this.f33752j = f2;
                try {
                    int responseCode = f2.getResponseCode();
                    if (responseCode >= 200 && responseCode <= 299) {
                        String contentType = this.f33752j.getContentType();
                        c.i.b.a.i0.n<String> nVar = this.f33747e;
                        if (nVar != null && !nVar.a(contentType)) {
                            c();
                            throw new HttpDataSource.InvalidContentTypeException(contentType, gVar);
                        }
                        if (responseCode == 200) {
                            long j3 = gVar.f33705d;
                            if (j3 != 0) {
                                j2 = j3;
                            }
                        }
                        this.m = j2;
                        if (!gVar.a(1)) {
                            long j4 = gVar.f33706e;
                            if (j4 != -1) {
                                this.n = j4;
                            } else {
                                long d2 = d(this.f33752j);
                                this.n = d2 != -1 ? d2 - this.m : -1L;
                            }
                        } else {
                            this.n = gVar.f33706e;
                        }
                        try {
                            this.k = this.f33752j.getInputStream();
                            this.l = true;
                            p<? super l> pVar = this.f33750h;
                            if (pVar != null) {
                                pVar.d(this, gVar);
                            }
                            return this.n;
                        } catch (IOException e2) {
                            c();
                            throw new HttpDataSource.HttpDataSourceException(e2, gVar, 1);
                        }
                    }
                    Map<String, List<String>> headerFields = this.f33752j.getHeaderFields();
                    c();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields, gVar);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                } catch (IOException e3) {
                    c();
                    throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + gVar.f33702a.toString(), e3, gVar, 1);
                }
            } catch (IOException e4) {
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + gVar.f33702a.toString(), e4, gVar, 1);
            }
        }
        return invokeL.longValue;
    }

    public final long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.n;
            return j2 == -1 ? j2 : j2 - this.p;
        }
        return invokeV.longValue;
    }

    public final void c() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (httpURLConnection = this.f33752j) == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
        this.f33752j = null;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws HttpDataSource.HttpDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.k != null) {
                    h(this.f33752j, b());
                    try {
                        this.k.close();
                    } catch (IOException e2) {
                        throw new HttpDataSource.HttpDataSourceException(e2, this.f33751i, 3);
                    }
                }
            } finally {
                this.k = null;
                c();
                if (this.l) {
                    this.l = false;
                    p<? super l> pVar = this.f33750h;
                    if (pVar != null) {
                        pVar.b(this);
                    }
                }
            }
        }
    }

    public final HttpURLConnection f(g gVar) throws IOException {
        InterceptResult invokeL;
        HttpURLConnection g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
            URL url = new URL(gVar.f33702a.toString());
            byte[] bArr = gVar.f33703b;
            long j2 = gVar.f33705d;
            long j3 = gVar.f33706e;
            boolean a2 = gVar.a(1);
            if (this.f33743a) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 <= 20) {
                        long j4 = j2;
                        g2 = g(url, bArr, j2, j3, a2, false);
                        int responseCode = g2.getResponseCode();
                        if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                            bArr = null;
                            String headerField = g2.getHeaderField("Location");
                            g2.disconnect();
                            url = e(url, headerField);
                            i2 = i3;
                            j2 = j4;
                        }
                    } else {
                        throw new NoRouteToHostException("Too many redirects: " + i3);
                    }
                }
                return g2;
            }
            return g(url, bArr, j2, j3, a2, true);
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public final HttpURLConnection g(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{url, bArr, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.f33744b);
            httpURLConnection.setReadTimeout(this.f33745c);
            HttpDataSource.b bVar = this.f33748f;
            if (bVar != null) {
                for (Map.Entry<String, String> entry : bVar.a().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.f33749g.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
            }
            if (j2 != 0 || j3 != -1) {
                String str = "bytes=" + j2 + "-";
                if (j3 != -1) {
                    str = str + ((j2 + j3) - 1);
                }
                httpURLConnection.setRequestProperty("Range", str);
            }
            httpURLConnection.setRequestProperty("User-Agent", this.f33746d);
            if (!z) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            }
            httpURLConnection.setInstanceFollowRedirects(z2);
            httpURLConnection.setDoOutput(bArr != null);
            if (bArr != null) {
                httpURLConnection.setRequestMethod("POST");
                if (bArr.length == 0) {
                    httpURLConnection.connect();
                } else {
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.close();
                }
            } else {
                httpURLConnection.connect();
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeCommon.objValue;
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HttpURLConnection httpURLConnection = this.f33752j;
            if (httpURLConnection == null) {
                return null;
            }
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        return (Uri) invokeV.objValue;
    }

    public final int i(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.n;
            if (j2 != -1) {
                long j3 = j2 - this.p;
                if (j3 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j3);
            }
            int read = this.k.read(bArr, i2, i3);
            if (read == -1) {
                if (this.n == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.p += read;
            p<? super l> pVar = this.f33750h;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }

    public final void j() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.o == this.m) {
            return;
        }
        byte[] andSet = r.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j2 = this.o;
            long j3 = this.m;
            if (j2 != j3) {
                int read = this.k.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                }
                if (read != -1) {
                    this.o += read;
                    p<? super l> pVar = this.f33750h;
                    if (pVar != null) {
                        pVar.a(this, read);
                    }
                } else {
                    throw new EOFException();
                }
            } else {
                r.set(andSet);
                return;
            }
        }
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource.HttpDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, bArr, i2, i3)) == null) {
            try {
                j();
                return i(bArr, i2, i3);
            } catch (IOException e2) {
                throw new HttpDataSource.HttpDataSourceException(e2, this.f33751i, 2);
            }
        }
        return invokeLII.intValue;
    }
}
