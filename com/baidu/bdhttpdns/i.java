package com.baidu.bdhttpdns;

import androidx.core.view.InputDeviceCompat;
import c.a.j.k;
import c.a.j.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
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
/* loaded from: classes5.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile i n = null;
    public static boolean o = true;
    public static c p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38543a;

    /* renamed from: b  reason: collision with root package name */
    public String f38544b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38545c;

    /* renamed from: d  reason: collision with root package name */
    public long f38546d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f38547e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f38548f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f38549g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f38550h;

    /* renamed from: i  reason: collision with root package name */
    public String f38551i;

    /* renamed from: j  reason: collision with root package name */
    public String f38552j;
    public boolean k;
    public int l;
    public int m;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2, d dVar, Map<String, e> map, String str);
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f38553e;

        /* renamed from: f  reason: collision with root package name */
        public d f38554f;

        /* renamed from: g  reason: collision with root package name */
        public a f38555g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38556h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f38557i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f38558j;

        public b(i iVar, String str, d dVar, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38558j = iVar;
            this.f38553e = str;
            this.f38554f = dVar;
            this.f38555g = aVar;
            this.f38556h = false;
            this.f38557i = false;
        }

        public final String a(String str, d dVar) {
            InterceptResult invokeLL;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + this.f38558j.f38546d;
                String g2 = this.f38558j.g(str, currentTimeMillis);
                if (g2 == null) {
                    return null;
                }
                if (this.f38558j.f38544b == null || this.f38558j.l >= 3) {
                    str2 = this.f38558j.f38543a;
                    this.f38557i = false;
                    k.a("Using BGPServerIp(%s)", this.f38558j.f38543a);
                } else {
                    str2 = this.f38558j.f38544b;
                    this.f38557i = true;
                    k.a("Using IDCServerIP(%s)", this.f38558j.f38544b);
                }
                String format = dVar.equals(d.f38560b) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, this.f38558j.f38551i, str, g2, Long.valueOf(currentTimeMillis), "1.3", "android") : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, this.f38558j.f38551i, str, g2, Long.valueOf(currentTimeMillis), "1.3", "android");
                return this.f38558j.f38545c ? String.format("https://%s", format) : String.format("http://%s", format);
            }
            return (String) invokeLL.objValue;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String a2 = a(this.f38553e, this.f38554f);
                if (a2 != null) {
                    c(a2);
                    return;
                }
                this.f38555g.a(-1, this.f38554f, null, this.f38553e);
                k.a("Httpdns request failed for  %s(%s), get url error", this.f38554f.toString(), this.f38553e);
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
                        if (this.f38558j.f38545c) {
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
                    } catch (IOException e2) {
                        httpURLConnection2 = httpsURLConnection;
                        e = e2;
                        e.printStackTrace();
                        ?? r14 = Boolean.FALSE;
                        this.f38558j.l(Boolean.valueOf(this.f38557i));
                        k.a("Httpdns request failed for %s(%s), caught network IOException", this.f38554f.toString(), this.f38553e);
                        a aVar2 = this.f38555g;
                        d dVar2 = this.f38554f;
                        str2 = this.f38553e;
                        aVar2.a(-1, dVar2, null, str2);
                        httpURLConnection3 = httpURLConnection2;
                        str3 = r14;
                        bool3 = httpURLConnection2;
                        str = r14;
                    } catch (ArrayIndexOutOfBoundsException e3) {
                        httpURLConnection = httpsURLConnection;
                        e = e3;
                        e.printStackTrace();
                        ?? r142 = Boolean.FALSE;
                        this.f38558j.l(Boolean.valueOf(this.f38557i));
                        k.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.f38554f.toString(), this.f38553e);
                        a aVar3 = this.f38555g;
                        d dVar3 = this.f38554f;
                        str2 = this.f38553e;
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
                        if (bool3.booleanValue() && this.f38557i) {
                            this.f38558j.l = 0;
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    httpURLConnection2 = null;
                } catch (ArrayIndexOutOfBoundsException e5) {
                    e = e5;
                    httpURLConnection = null;
                } catch (Throwable th4) {
                    th = th4;
                    if (httpURLConnection4 != null) {
                    }
                    if (bool3.booleanValue()) {
                        this.f38558j.l = 0;
                    }
                    throw th;
                }
                if (errorStream != null) {
                    String f2 = this.f38558j.f(errorStream, httpsURLConnection);
                    if (f2 == null) {
                        Boolean bool4 = Boolean.FALSE;
                        this.f38558j.l(Boolean.valueOf(this.f38557i));
                        k.a("Httpdns request failed for %s(%s), get empty response data", this.f38554f.toString(), this.f38553e);
                        this.f38555g.a(-1, this.f38554f, null, this.f38553e);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    Map j2 = this.f38558j.j(f2, this.f38553e, this.f38554f);
                    if (j2.get("isSignExpired").equals(Boolean.TRUE)) {
                        this.f38556h = true;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (this.f38557i) {
                            this.f38558j.l = 0;
                            return;
                        }
                        return;
                    } else if (j2.get("isMsgOK").equals(Boolean.TRUE) && responseCode == 200) {
                        hashMap = this.f38558j.i(f2, this.f38553e);
                        bool2 = bool3;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (bool2.booleanValue() && this.f38557i) {
                            this.f38558j.l = 0;
                        }
                        if (hashMap != null || hashMap.isEmpty()) {
                            this.f38555g.a(-1, this.f38554f, null, this.f38553e);
                        } else {
                            this.f38555g.a(0, this.f38554f, hashMap, this.f38553e);
                            return;
                        }
                    } else {
                        aVar = this.f38555g;
                        dVar = this.f38554f;
                        str4 = this.f38553e;
                        bool = bool3;
                    }
                } else {
                    Boolean bool5 = Boolean.FALSE;
                    this.f38558j.l(Boolean.valueOf(this.f38557i));
                    k.a("Httpdns request failed for %s(%s), get null response stream", this.f38554f.toString(), this.f38553e);
                    aVar = this.f38555g;
                    dVar = this.f38554f;
                    str4 = this.f38553e;
                    bool = bool5;
                }
                aVar.a(-1, dVar, null, str4);
                bool2 = bool;
                if (httpsURLConnection != null) {
                }
                if (bool2.booleanValue()) {
                    this.f38558j.l = 0;
                }
                if (hashMap != null) {
                }
                this.f38555g.a(-1, this.f38554f, null, this.f38553e);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b();
                if (this.f38556h) {
                    k.a("Retry for %s(%s).", this.f38554f.toString(), this.f38553e);
                    b();
                }
                synchronized (this.f38558j.f38548f) {
                    if (!this.f38554f.equals(d.f38560b)) {
                        for (String str : this.f38553e.split(",")) {
                            this.f38558j.f38547e.remove(str);
                        }
                    }
                }
                synchronized (this.f38558j.f38549g) {
                    if (this.f38554f.equals(d.f38559a)) {
                        for (String str2 : this.f38553e.split(",")) {
                            this.f38558j.f38550h.remove(str2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(i iVar, c.a.j.i iVar2) {
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
    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f38559a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f38560b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ d[] f38561c;
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
            f38559a = new d("DNLIST_HOSTS", 0);
            d dVar = new d("TAG_OF_HOSTS", 1);
            f38560b = dVar;
            f38561c = new d[]{f38559a, dVar};
        }

        public d(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (d[]) f38561c.clone() : (d[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<String> f38562a;

        /* renamed from: b  reason: collision with root package name */
        public final long f38563b;

        public e(i iVar, ArrayList<String> arrayList, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, arrayList, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38562a = arrayList;
            this.f38563b = j2;
        }

        public ArrayList<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38562a : (ArrayList) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38563b : invokeV.longValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38543a = "180.76.76.200";
        this.f38545c = true;
        this.f38546d = 0L;
        this.f38549g = new Object();
        this.f38550h = new ArrayList<>();
        this.f38551i = "";
        this.f38552j = "";
        this.k = false;
        this.m = 10;
        this.f38548f = new Object();
        this.f38547e = new HashSet<>();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !o ? this.f38552j : c.a.j.e.l(this.f38552j) : (String) invokeV.objValue;
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
                if (contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) {
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

    public final String g(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j2)) == null) ? c.a.j.e.j(String.format("%s-%s-%d", str, A(), Long.valueOf(j2))) : (String) invokeLJ.objValue;
    }

    public final String h(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i2)) == null) {
            byte[] bArr2 = new byte[i2];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i2);
                do {
                    int read = gZIPInputStream.read(bArr2, 0, i2);
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
                        this.f38544b = optJSONArray.optString(0);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    k.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                int i2 = 0;
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next).optJSONObject("ipv4");
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("ip");
                    if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                        k.a("Httpdns request failed, host(%s), response has no ip field", next);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.optString(i3);
                            if (optString == null || optString.isEmpty()) {
                                k.a("Httpdns request warning, host(%s), response get ip error", next);
                            } else if (c.a.j.e.e(optString)) {
                                arrayList.add(optString);
                            } else {
                                k.a("Httpdns request warning, host(%s), response get invalid ip(%s)", next, optString);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            k.a("Httpdns request failed, host(%s), response has no valid ip", next);
                        } else {
                            try {
                                long j2 = optJSONObject2.getLong(ResultTB.TTL);
                                if (j2 < 0) {
                                    k.a("Httpdns request failed, host(%s), response has invalid ttl(%s)", next, Long.valueOf(j2));
                                } else {
                                    hashMap.put(next, new e(this, arrayList, j2));
                                    i2++;
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                k.a("Httpdns request failed, host(%s), response has no ttl", next);
                                return null;
                            }
                        }
                    }
                    hashMap.put(next, null);
                }
                if (i2 == 0) {
                    return null;
                }
                return hashMap;
            } catch (JSONException e3) {
                e3.printStackTrace();
                k.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
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
                    k.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
                    return hashMap;
                } else if (!"SignatureExpired".equals(optString)) {
                    if (NewBindCardEntry.BING_CARD_SUCCESS_MSG.equals(optString)) {
                        hashMap.put("isMsgOK", Boolean.TRUE);
                        return hashMap;
                    }
                    k.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, optString);
                    return hashMap;
                } else {
                    int optInt = jSONObject.optInt("timestamp");
                    if (optInt == 0) {
                        k.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
                    } else {
                        this.f38546d = optInt - (System.currentTimeMillis() / 1000);
                        hashMap.put("isSignExpired", Boolean.TRUE);
                    }
                    return hashMap;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                k.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
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
                    int i2 = this.l + 1;
                    this.l = i2;
                    k.a("requestIDCFailNum: %s", Integer.valueOf(i2));
                }
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this.f38549g) {
                if (!this.f38550h.contains(str)) {
                    this.f38550h.add(str);
                }
            }
        }
    }

    public void n(String str, d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, str, dVar, aVar) == null) || str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.f38548f) {
            if (dVar.equals(d.f38559a)) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(str.split(",")));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.f38547e.contains(str2)) {
                        k.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.f38547e.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    sb.append((String) arrayList.get(i2));
                    sb.append(",");
                }
                str = sb.toString().replaceAll("^,*|,*$", "");
            }
            if (str != null && !str.isEmpty()) {
                try {
                    l.a().b().execute(new b(this, str, dVar, aVar));
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                    k.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                }
            }
        }
    }

    public void o(ArrayList<String> arrayList, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, aVar) == null) {
            ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
            int i2 = 0;
            int i3 = 0;
            while (i2 < arrayList2.size()) {
                String str = "";
                int i4 = 0;
                while (true) {
                    int i5 = this.m;
                    if (i4 >= i5 || (i2 = i4 + (i5 * i3)) >= arrayList2.size()) {
                        break;
                    }
                    str = str + ((String) arrayList2.get(i2)) + ",";
                    i4++;
                }
                i3++;
                if (str != null && !str.isEmpty()) {
                    String substring = str.substring(0, str.length() - 1);
                    k.a("Hosts for httpdns request is (%s) ", substring);
                    n(substring, d.f38559a, aVar);
                }
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f38545c = z;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l = 0;
            this.f38544b = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f38550h : (ArrayList) invokeV.objValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f38551i = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            String k = c.a.j.e.k(str);
            this.f38552j = k;
            if (k == null) {
                this.f38552j = str;
                o = false;
            }
        }
    }
}
