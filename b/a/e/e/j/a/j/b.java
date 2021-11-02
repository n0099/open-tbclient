package b.a.e.e.j.a.j;

import b.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f1821b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b.a.e.e.j.a.j.a> f1822a;

    /* loaded from: classes.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1823a;

        public a(b bVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1823a = cVar;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
                if (!verify) {
                    this.f1823a.e(true);
                }
                return verify;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2062497556, "Lb/a/e/e/j/a/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2062497556, "Lb/a/e/e/j/a/j/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1822a = new HashMap<>();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1821b == null) {
                synchronized (b.class) {
                    if (f1821b == null) {
                        f1821b = new b();
                    }
                }
            }
            return f1821b;
        }
        return (b) invokeV.objValue;
    }

    public c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = new c();
            b.a.e.e.j.a.j.a aVar = this.f1822a.get(str);
            if (aVar != null && !aVar.c(System.currentTimeMillis()) && aVar.a() != null && aVar.a().size() > 0) {
                cVar.g(aVar.a().get(0));
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00e4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0126 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010b A[Catch: all -> 0x0126, TryCatch #1 {all -> 0x0126, blocks: (B:22:0x00b2, B:24:0x00b8, B:25:0x00bc, B:50:0x00fc, B:52:0x010b, B:53:0x010e), top: B:81:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0118 A[Catch: Exception -> 0x0125, TryCatch #10 {Exception -> 0x0125, blocks: (B:55:0x0113, B:57:0x0118, B:59:0x011d, B:61:0x0122), top: B:84:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011d A[Catch: Exception -> 0x0125, TryCatch #10 {Exception -> 0x0125, blocks: (B:55:0x0113, B:57:0x0118, B:59:0x011d, B:61:0x0122), top: B:84:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0122 A[Catch: Exception -> 0x0125, TRY_LEAVE, TryCatch #10 {Exception -> 0x0125, blocks: (B:55:0x0113, B:57:0x0118, B:59:0x011d, B:61:0x0122), top: B:84:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012f A[Catch: Exception -> 0x013c, TryCatch #7 {Exception -> 0x013c, blocks: (B:66:0x012a, B:68:0x012f, B:70:0x0134, B:72:0x0139), top: B:82:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134 A[Catch: Exception -> 0x013c, TryCatch #7 {Exception -> 0x013c, blocks: (B:66:0x012a, B:68:0x012f, B:70:0x0134, B:72:0x0139), top: B:82:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0139 A[Catch: Exception -> 0x013c, TRY_LEAVE, TryCatch #7 {Exception -> 0x013c, blocks: (B:66:0x012a, B:68:0x012f, B:70:0x0134, B:72:0x0139), top: B:82:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b.a.e.e.j.a.j.a c(String str, c cVar) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2;
        InputStream inputStream3;
        ?? r5;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) != null) {
            return (b.a.e.e.j.a.j.a) invokeLL.objValue;
        }
        InputStreamReader inputStreamReader = null;
        if (k.isEmpty(str)) {
            return null;
        }
        cVar.i(true);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                if (cVar.c()) {
                    HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL("http://180.76.76.112/v2/0011/?dn=" + ((String) str)).openConnection();
                    try {
                        httpURLConnection4.setDoOutput(true);
                        httpURLConnection4.setDoInput(true);
                        httpURLConnection4.setUseCaches(false);
                        httpURLConnection4.setConnectTimeout(5000);
                        httpURLConnection4.setReadTimeout(10000);
                        httpURLConnection4.setRequestMethod("GET");
                        httpURLConnection4.connect();
                        inputStream3 = httpURLConnection4.getInputStream();
                        str = httpURLConnection4;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection4;
                        inputStream2 = inputStream;
                        inputStream3 = inputStream;
                        str = httpURLConnection2;
                        r5 = inputStream2;
                        cVar.h(e.getClass().getName());
                        if (e instanceof SSLException) {
                        }
                        e.printStackTrace();
                        if (inputStream2 != null) {
                        }
                        if (inputStream3 != null) {
                        }
                        if (r5 != 0) {
                        }
                        if (str != 0) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection4;
                        bufferedReader2 = bufferedReader;
                        inputStream4 = bufferedReader;
                        httpURLConnection3 = httpURLConnection;
                        if (inputStreamReader != null) {
                        }
                        if (inputStream4 != 0) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        throw th;
                    }
                } else {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + ((String) str)).openConnection();
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(10000);
                    httpsURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
                    httpsURLConnection.setHostnameVerifier(new a(this, cVar));
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.connect();
                    inputStream3 = httpsURLConnection.getInputStream();
                    str = 0;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                inputStream2 = new InputStreamReader(inputStream3, "utf-8");
            } catch (Exception e3) {
                e = e3;
                inputStream2 = null;
                inputStream3 = inputStream3;
                str = str;
                r5 = inputStream2;
                cVar.h(e.getClass().getName());
                if (e instanceof SSLException) {
                }
                e.printStackTrace();
                if (inputStream2 != null) {
                }
                if (inputStream3 != null) {
                }
                if (r5 != 0) {
                }
                if (str != 0) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                inputStream4 = inputStream3;
                httpURLConnection3 = str;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused) {
                        throw th;
                    }
                }
                if (inputStream4 != 0) {
                    inputStream4.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
            try {
                r5 = new BufferedReader(inputStream2);
                while (true) {
                    try {
                        String readLine = r5.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (Exception e4) {
                        e = e4;
                        cVar.h(e.getClass().getName());
                        if (e instanceof SSLException) {
                            cVar.e(true);
                        }
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (r5 != 0) {
                            r5.close();
                        }
                        if (str != 0) {
                            str.disconnect();
                        }
                        return null;
                    }
                }
                b.a.e.e.j.a.j.a aVar = new b.a.e.e.j.a.j.a();
                aVar.e(System.currentTimeMillis());
                cVar.d();
                b.a.e.e.j.a.j.a b2 = aVar.b(stringBuffer.toString());
                try {
                    inputStream2.close();
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    r5.close();
                    if (str != 0) {
                        str.disconnect();
                    }
                } catch (Exception unused3) {
                }
                return b2;
            } catch (Exception e5) {
                e = e5;
                r5 = 0;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                inputStreamReader = inputStream2;
                inputStream4 = inputStream3;
                httpURLConnection3 = str;
                if (inputStreamReader != null) {
                }
                if (inputStream4 != 0) {
                }
                if (bufferedReader2 != null) {
                }
                if (httpURLConnection3 != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            httpURLConnection2 = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedReader = null;
        }
    }

    public c d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            c cVar = new c();
            if (k.isEmpty(str)) {
                return cVar;
            }
            b.a.e.e.j.a.j.a aVar = this.f1822a.get(str);
            if (aVar != null && !aVar.c(System.currentTimeMillis()) && aVar.a() != null && aVar.a().size() > 0) {
                for (int i2 = 0; i2 < aVar.a().size(); i2++) {
                    if (!k.isEquals(str2, aVar.a().get(i2))) {
                        cVar.j(i2);
                        cVar.g(aVar.a().get(i2));
                        return cVar;
                    } else if (i2 == aVar.a().size() - 1) {
                        cVar.j(0);
                        cVar.g(aVar.a().get(0));
                        return cVar;
                    }
                }
            }
            for (int i3 = 0; i3 < 3; i3++) {
                cVar.d();
                cVar.l(i3);
                long currentTimeMillis = System.currentTimeMillis();
                b.a.e.e.j.a.j.a c2 = c(str, cVar);
                cVar.f(System.currentTimeMillis() - currentTimeMillis);
                if (c2 != null && c2.a() != null && c2.a().size() > 0) {
                    c2.d(300L);
                    this.f1822a.put(str, c2);
                    for (int i4 = 0; i4 < c2.a().size(); i4++) {
                        if (!k.isEquals(str2, c2.a().get(i3))) {
                            cVar.j(i4);
                            cVar.g(c2.a().get(i4));
                            return cVar;
                        } else if (i4 == c2.a().size() - 1) {
                            cVar.j(0);
                            cVar.g(c2.a().get(0));
                            return cVar;
                        }
                    }
                    continue;
                } else {
                    b.a.e.e.j.a.j.a aVar2 = this.f1822a.get(str);
                    if (aVar2 != null && aVar2.a() != null && aVar2.a().size() > 0) {
                        cVar.g(aVar2.a().get(0));
                        return cVar;
                    }
                }
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }
}
