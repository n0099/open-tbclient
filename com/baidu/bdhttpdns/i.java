package com.baidu.bdhttpdns;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aq;
import com.repackage.eq;
import com.repackage.gq;
import com.repackage.hq;
import com.yy.gslbsdk.db.ResultTB;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile i n = null;
    public static boolean o = true;
    public static c p;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public boolean c;
    public long d;
    public final HashSet<String> e;
    public final Object f;
    public final Object g;
    public ArrayList<String> h;
    public String i;
    public String j;
    public boolean k;
    public int l;
    public int m;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, d dVar, Map<String, e> map, String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public d b;
        public a c;
        public boolean d;
        public boolean e;
        public final /* synthetic */ i f;

        public b(i iVar, String str, d dVar, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = iVar;
            this.a = str;
            this.b = dVar;
            this.c = aVar;
            this.d = false;
            this.e = false;
        }

        public final String a(String str, d dVar) {
            InterceptResult invokeLL;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + this.f.d;
                String g = this.f.g(str, currentTimeMillis);
                if (g == null) {
                    return null;
                }
                if (this.f.b == null || this.f.l >= 3) {
                    str2 = this.f.a;
                    this.e = false;
                    gq.a("Using BGPServerIp(%s)", this.f.a);
                } else {
                    str2 = this.f.b;
                    this.e = true;
                    gq.a("Using IDCServerIP(%s)", this.f.b);
                }
                String format = dVar.equals(d.b) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, this.f.i, str, g, Long.valueOf(currentTimeMillis), "1.3", "android") : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, this.f.i, str, g, Long.valueOf(currentTimeMillis), "1.3", "android");
                return this.f.c ? String.format("https://%s", format) : String.format("http://%s", format);
            }
            return (String) invokeLL.objValue;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String a = a(this.a, this.b);
                if (a != null) {
                    c(a);
                    return;
                }
                this.c.a(-1, this.b, null, this.a);
                gq.a("Httpdns request failed for  %s(%s), get url error", this.b.toString(), this.a);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x013b */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x0010 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x0010 */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x016d, code lost:
            if (r1 == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x016f, code lost:
            r1.disconnect();
            r1 = r1;
            r14 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x01a2, code lost:
            if (r1 == null) goto L61;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01cc  */
        /* JADX WARN: Type inference failed for: r14v13, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r7v26, types: [com.baidu.bdhttpdns.i] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(String str) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            String str2;
            String str3;
            HttpURLConnection httpURLConnection3;
            HttpsURLConnection httpsURLConnection;
            int responseCode;
            InputStream errorStream;
            a aVar;
            d dVar;
            String str4;
            Boolean bool;
            Boolean bool2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                Map<String, e> hashMap = new HashMap<>();
                Boolean bool3 = Boolean.TRUE;
                HttpURLConnection httpURLConnection4 = null;
                try {
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection4 = bool3;
                    bool3 = str2;
                }
                try {
                    try {
                        URL url = new URL(str);
                        if (this.f.c) {
                            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                            httpsURLConnection2.setRequestProperty("Host", "httpdns.baidubce.com");
                            httpsURLConnection2.setHostnameVerifier(i.p);
                            httpsURLConnection = httpsURLConnection2;
                        } else {
                            httpsURLConnection = (HttpURLConnection) url.openConnection();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection4 = bool3;
                        bool3 = str;
                    }
                    try {
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setReadTimeout(30000);
                        httpsURLConnection.setConnectTimeout(30000);
                        httpsURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                        httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        httpsURLConnection.connect();
                        responseCode = httpsURLConnection.getResponseCode();
                        errorStream = responseCode >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream();
                    } catch (IOException e) {
                        httpURLConnection2 = httpsURLConnection;
                        e = e;
                        e.printStackTrace();
                        ?? r14 = Boolean.FALSE;
                        this.f.l(Boolean.valueOf(this.e));
                        gq.a("Httpdns request failed for %s(%s), caught network IOException", this.b.toString(), this.a);
                        a aVar2 = this.c;
                        d dVar2 = this.b;
                        str2 = this.a;
                        aVar2.a(-1, dVar2, null, str2);
                        httpURLConnection3 = httpURLConnection2;
                        str3 = r14;
                        bool3 = httpURLConnection2;
                        str = r14;
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        httpURLConnection = httpsURLConnection;
                        e = e2;
                        e.printStackTrace();
                        ?? r142 = Boolean.FALSE;
                        this.f.l(Boolean.valueOf(this.e));
                        gq.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.b.toString(), this.a);
                        a aVar3 = this.c;
                        d dVar3 = this.b;
                        str2 = this.a;
                        aVar3.a(-1, dVar3, null, str2);
                        httpURLConnection3 = httpURLConnection;
                        str3 = r142;
                        bool3 = httpURLConnection;
                        str = r142;
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection4 = httpsURLConnection;
                        bool3 = bool3;
                        th = th;
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                        if (bool3.booleanValue() && this.e) {
                            this.f.l = 0;
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    httpURLConnection2 = null;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    e = e4;
                    httpURLConnection = null;
                } catch (Throwable th4) {
                    th = th4;
                    if (httpURLConnection4 != null) {
                    }
                    if (bool3.booleanValue()) {
                        this.f.l = 0;
                    }
                    throw th;
                }
                if (errorStream != null) {
                    String f = this.f.f(errorStream, httpsURLConnection);
                    if (f == null) {
                        Boolean bool4 = Boolean.FALSE;
                        this.f.l(Boolean.valueOf(this.e));
                        gq.a("Httpdns request failed for %s(%s), get empty response data", this.b.toString(), this.a);
                        this.c.a(-1, this.b, null, this.a);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    Map j = this.f.j(f, this.a, this.b);
                    if (j.get("isSignExpired").equals(Boolean.TRUE)) {
                        this.d = true;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (this.e) {
                            this.f.l = 0;
                            return;
                        }
                        return;
                    } else if (j.get("isMsgOK").equals(Boolean.TRUE) && responseCode == 200) {
                        hashMap = this.f.i(f, this.a);
                        bool2 = bool3;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (bool2.booleanValue() && this.e) {
                            this.f.l = 0;
                        }
                        if (hashMap != null || hashMap.isEmpty()) {
                            this.c.a(-1, this.b, null, this.a);
                        } else {
                            this.c.a(0, this.b, hashMap, this.a);
                            return;
                        }
                    } else {
                        aVar = this.c;
                        dVar = this.b;
                        str4 = this.a;
                        bool = bool3;
                    }
                } else {
                    Boolean bool5 = Boolean.FALSE;
                    this.f.l(Boolean.valueOf(this.e));
                    gq.a("Httpdns request failed for %s(%s), get null response stream", this.b.toString(), this.a);
                    aVar = this.c;
                    dVar = this.b;
                    str4 = this.a;
                    bool = bool5;
                }
                aVar.a(-1, dVar, null, str4);
                bool2 = bool;
                if (httpsURLConnection != null) {
                }
                if (bool2.booleanValue()) {
                    this.f.l = 0;
                }
                if (hashMap != null) {
                }
                this.c.a(-1, this.b, null, this.a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b();
                if (this.d) {
                    gq.a("Retry for %s(%s).", this.b.toString(), this.a);
                    b();
                }
                synchronized (this.f.f) {
                    if (!this.b.equals(d.b)) {
                        for (String str : this.a.split(",")) {
                            this.f.e.remove(str);
                        }
                    }
                }
                synchronized (this.f.g) {
                    if (this.b.equals(d.a)) {
                        for (String str2 : this.a.split(",")) {
                            this.f.h.remove(str2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(i iVar, eq eqVar) {
            this(iVar);
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) ? HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession) : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public static final d b;
        public static final /* synthetic */ d[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1491126288, "Lcom/baidu/bdhttpdns/i$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1491126288, "Lcom/baidu/bdhttpdns/i$d;");
                    return;
                }
            }
            a = new d("DNLIST_HOSTS", 0);
            d dVar = new d("TAG_OF_HOSTS", 1);
            b = dVar;
            c = new d[]{a, dVar};
        }

        public d(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static d valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (d) Enum.valueOf(d.class, str) : (d) invokeL.objValue;
        }

        public static d[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (d[]) c.clone() : (d[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<String> a;
        public final long b;

        public e(i iVar, ArrayList<String> arrayList, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, arrayList, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = arrayList;
            this.b = j;
        }

        public ArrayList<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-940098064, "Lcom/baidu/bdhttpdns/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-940098064, "Lcom/baidu/bdhttpdns/i;");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "180.76.76.200";
        this.c = true;
        this.d = 0L;
        this.g = new Object();
        this.h = new ArrayList<>();
        this.i = "";
        this.j = "";
        this.k = false;
        this.m = 10;
        this.f = new Object();
        this.e = new HashSet<>();
        p = new c(this, null);
    }

    public static i b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (n == null) {
                synchronized (i.class) {
                    if (n == null) {
                        n = new i();
                    }
                }
            }
            return n;
        }
        return (i) invokeV.objValue;
    }

    public static boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !o ? this.j : aq.l(this.j) : (String) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final String f(InputStream inputStream, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, httpURLConnection)) != null) {
            return (String) invokeLL.objValue;
        }
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            try {
                if (contentEncoding.contains("gzip")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 0) {
                        contentLength = 1024;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (-1 == read) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } else {
                        byte[] bArr2 = new byte[contentLength];
                        inputStream.read(bArr2);
                        byteArrayOutputStream.write(bArr2, 0, contentLength);
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return h(byteArrayOutputStream.toByteArray(), contentLength);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    public final String g(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) ? aq.j(String.format("%s-%s-%d", str, A(), Long.valueOf(j))) : (String) invokeLJ.objValue;
    }

    public final String h(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i)) == null) {
            byte[] bArr2 = new byte[i];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                do {
                    int read = gZIPInputStream.read(bArr2, 0, i);
                    byteArrayOutputStream.write(bArr2, 0, read);
                    if (read == -1) {
                        break;
                    }
                } while (!t(byteArrayOutputStream.toString()));
                gZIPInputStream.close();
                return byteArrayOutputStream.toString();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLI.objValue;
    }

    public Map i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("serverip")) {
                    JSONArray optJSONArray = jSONObject.optJSONObject("serverip").optJSONArray("ipv4");
                    if (optJSONArray.length() > 0) {
                        this.b = optJSONArray.optString(0);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    gq.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                int i = 0;
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next).optJSONObject("ipv4");
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("ip");
                    if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                        gq.a("Httpdns request failed, host(%s), response has no ip field", next);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String optString = optJSONArray2.optString(i2);
                            if (optString == null || optString.isEmpty()) {
                                gq.a("Httpdns request warning, host(%s), response get ip error", next);
                            } else if (aq.e(optString)) {
                                arrayList.add(optString);
                            } else {
                                gq.a("Httpdns request warning, host(%s), response get invalid ip(%s)", next, optString);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            gq.a("Httpdns request failed, host(%s), response has no valid ip", next);
                        } else {
                            try {
                                long j = optJSONObject2.getLong(ResultTB.TTL);
                                if (j < 0) {
                                    gq.a("Httpdns request failed, host(%s), response has invalid ttl(%s)", next, Long.valueOf(j));
                                } else {
                                    hashMap.put(next, new e(this, arrayList, j));
                                    i++;
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                gq.a("Httpdns request failed, host(%s), response has no ttl", next);
                                return null;
                            }
                        }
                    }
                    hashMap.put(next, null);
                }
                if (i == 0) {
                    return null;
                }
                return hashMap;
            } catch (JSONException e3) {
                e3.printStackTrace();
                gq.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
                return null;
            }
        }
        return (Map) invokeLL.objValue;
    }

    public Map j(String str, String str2, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, dVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("isMsgOK", Boolean.FALSE);
            hashMap.put("isSignExpired", Boolean.FALSE);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("msg");
                if (optString == null || optString.isEmpty()) {
                    gq.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
                    return hashMap;
                } else if (!"SignatureExpired".equals(optString)) {
                    if ("ok".equals(optString)) {
                        hashMap.put("isMsgOK", Boolean.TRUE);
                        return hashMap;
                    }
                    gq.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, optString);
                    return hashMap;
                } else {
                    int optInt = jSONObject.optInt("timestamp");
                    if (optInt == 0) {
                        gq.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
                    } else {
                        this.d = optInt - (System.currentTimeMillis() / 1000);
                        hashMap.put("isSignExpired", Boolean.TRUE);
                    }
                    return hashMap;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                gq.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
                return hashMap;
            }
        }
        return (Map) invokeLLL.objValue;
    }

    public final synchronized void l(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bool) == null) {
            synchronized (this) {
                if (bool.booleanValue()) {
                    int i = this.l + 1;
                    this.l = i;
                    gq.a("requestIDCFailNum: %s", Integer.valueOf(i));
                }
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this.g) {
                if (!this.h.contains(str)) {
                    this.h.add(str);
                }
            }
        }
    }

    public void n(String str, d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, str, dVar, aVar) == null) || str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            if (dVar.equals(d.a)) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(str.split(",")));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.e.contains(str2)) {
                        gq.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.e.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append((String) arrayList.get(i));
                    sb.append(",");
                }
                str = sb.toString().replaceAll("^,*|,*$", "");
            }
            if (str != null && !str.isEmpty()) {
                try {
                    hq.a().b().execute(new b(this, str, dVar, aVar));
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                    gq.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                }
            }
        }
    }

    public void o(ArrayList<String> arrayList, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, aVar) == null) {
            ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
            int i = 0;
            int i2 = 0;
            while (i < arrayList2.size()) {
                String str = "";
                int i3 = 0;
                while (true) {
                    int i4 = this.m;
                    if (i3 >= i4 || (i = i3 + (i4 * i2)) >= arrayList2.size()) {
                        break;
                    }
                    str = str + ((String) arrayList2.get(i)) + ",";
                    i3++;
                }
                i2++;
                if (str != null && !str.isEmpty()) {
                    String substring = str.substring(0, str.length() - 1);
                    gq.a("Hosts for httpdns request is (%s) ", substring);
                    n(substring, d.a, aVar);
                }
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l = 0;
            this.b = null;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.k = z;
        }
    }

    public ArrayList v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.h : (ArrayList) invokeV.objValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.i = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            String k = aq.k(str);
            this.j = k;
            if (k == null) {
                this.j = str;
                o = false;
            }
        }
    }
}
