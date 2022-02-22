package c.a.d.f.j.b.l;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.t;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        int indexOf;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (m.isEmpty(str)) {
                return "";
            }
            try {
                return new URL(str).getHost();
            } catch (Exception e2) {
                BdLog.e(e2);
                if (!str.startsWith("http") || (indexOf = str.indexOf(":")) == -1) {
                    return "";
                }
                int i2 = indexOf + 3;
                int indexOf2 = str.indexOf(":", i2);
                int indexOf3 = str.indexOf("/", i2);
                if (indexOf2 != -1 && indexOf3 != -1) {
                    max = Math.min(indexOf2, indexOf3);
                } else {
                    max = Math.max(indexOf2, indexOf3);
                }
                if (max != -1 || i2 >= str.length()) {
                    if (i2 != -1 && i2 < max) {
                        return str.substring(i2, max);
                    }
                    return "";
                }
                return str.substring(i2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? m.isEmpty(str) ? "" : str.startsWith("https://") ? str.replace("https://", "http://") : str : (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String d2 = d();
            String e2 = e();
            return d2 + e2;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0129 A[Catch: Exception -> 0x0151, TryCatch #4 {Exception -> 0x0151, blocks: (B:5:0x000d, B:21:0x009f, B:48:0x00e1, B:51:0x00f4, B:53:0x00ff, B:54:0x0118, B:55:0x011e, B:56:0x0123, B:58:0x0129, B:59:0x0131, B:71:0x0150, B:70:0x0149, B:46:0x00d8, B:43:0x00d3, B:18:0x009a, B:67:0x0144), top: B:85:0x000d, inners: #3, #5, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d() {
        InterceptResult invokeV;
        long currentTimeMillis;
        String str;
        HttpGet httpGet;
        byte[] bArr;
        byte[] bArr2;
        int i2;
        HttpResponse execute;
        InputStream content;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                currentTimeMillis = System.currentTimeMillis();
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 3000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 1024);
                HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
                HttpClientParams.setRedirecting(basicHttpParams, true);
                ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(15));
                ConnManagerParams.setTimeout(basicHttpParams, 10000L);
                ConnManagerParams.setMaxTotalConnections(basicHttpParams, 15);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                str = "";
                int i3 = 0;
                InputStream inputStream = null;
                try {
                    httpGet = new HttpGet("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg");
                    try {
                        try {
                            execute = defaultHttpClient.execute(httpGet);
                            i2 = execute.getStatusLine().getStatusCode();
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            content = execute.getEntity().getContent();
                        } catch (Exception e3) {
                            e = e3;
                            i3 = i2;
                            bArr = null;
                            str = e.toString();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (httpGet != null) {
                                try {
                                    httpGet.abort();
                                } catch (Exception e4) {
                                    BdLog.e(e4.getMessage());
                                }
                            }
                            bArr2 = bArr;
                            i2 = i3;
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            sb.append("-imgResponseCode_");
                            sb.append(i2);
                            if (i2 == 200) {
                            }
                            if (!m.isEmpty(str)) {
                            }
                            sb.append("-costTime_");
                            sb.append(currentTimeMillis2);
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                    } catch (Exception e5) {
                        e = e5;
                        i3 = i2;
                        inputStream = content;
                        bArr = null;
                        str = e.toString();
                        if (inputStream != null) {
                        }
                        if (httpGet != null) {
                        }
                        bArr2 = bArr;
                        i2 = i3;
                        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                        sb.append("-imgResponseCode_");
                        sb.append(i2);
                        if (i2 == 200) {
                        }
                        if (!m.isEmpty(str)) {
                        }
                        sb.append("-costTime_");
                        sb.append(currentTimeMillis22);
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = content;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (httpGet != null) {
                            try {
                                httpGet.abort();
                            } catch (Exception e6) {
                                BdLog.e(e6.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    bArr = null;
                    httpGet = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpGet = null;
                }
            } catch (Exception e8) {
                sb.append("-imgTestFail_");
                sb.append(e8.toString());
            }
            if (content != null) {
                byte[] bArr3 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                while (true) {
                    int read = content.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (content != null) {
                    try {
                        content.close();
                    } catch (Exception unused3) {
                    }
                }
                try {
                    httpGet.abort();
                } catch (Exception e9) {
                    BdLog.e(e9.getMessage());
                }
                long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                sb.append("-imgResponseCode_");
                sb.append(i2);
                if (i2 == 200) {
                    if (bArr2 != null) {
                        int length = bArr2.length;
                        String d2 = t.d(bArr2);
                        if (!"BA30C9CC61C537ACBD68397F95684A27".equalsIgnoreCase(d2)) {
                            sb.append("-MD5Error_");
                            sb.append(d2);
                            sb.append("_");
                            sb.append("BA30C9CC61C537ACBD68397F95684A27");
                            sb.append("-size_");
                            sb.append(length);
                        } else {
                            sb.append("-imgTestOk");
                        }
                    } else {
                        sb.append("-downSizeZero");
                    }
                }
                if (!m.isEmpty(str)) {
                    sb.append("-imgException_");
                    sb.append(str);
                }
                sb.append("-costTime_");
                sb.append(currentTimeMillis222);
                return sb.toString();
            }
            throw new IOException("get_content_is_null");
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x0109 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e() {
        InterceptResult invokeV;
        Exception e2;
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        int i2;
        HttpURLConnection httpURLConnection2;
        String str;
        byte[] bArr2;
        InputStream inputStream;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ?? r0 = "http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg";
            StringBuilder sb = new StringBuilder();
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream2 = null;
            try {
                try {
                    r0 = (HttpURLConnection) new URL("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg").openConnection();
                    try {
                    } catch (Exception e3) {
                        bArr = null;
                        e2 = e3;
                        httpURLConnection = r0;
                        i2 = 0;
                        httpURLConnection2 = httpURLConnection;
                        String exc = e2.toString();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        }
                        str = exc;
                        bArr2 = bArr;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        sb.append("-imgResponseCode_");
                        sb.append(i2);
                        if (i2 == 200) {
                        }
                        if (!m.isEmpty(str)) {
                        }
                        sb.append("-costTime_");
                        sb.append(currentTimeMillis2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e5) {
                e2 = e5;
                httpURLConnection = null;
                bArr = null;
            } catch (Throwable th2) {
                th = th2;
                r0 = 0;
            }
            if (r0 != 0) {
                r0.setConnectTimeout(3000);
                r0.setReadTimeout(10000);
                r0.connect();
                i2 = r0.getResponseCode();
                try {
                    inputStream = r0.getInputStream();
                } catch (Exception e6) {
                    e2 = e6;
                    bArr = null;
                    httpURLConnection2 = r0;
                }
                try {
                    bArr3 = new byte[1024];
                } catch (Exception e7) {
                    e2 = e7;
                    bArr = null;
                    inputStream2 = inputStream;
                    httpURLConnection2 = r0;
                    String exc2 = e2.toString();
                    if (inputStream2 != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    str = exc2;
                    bArr2 = bArr;
                    long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                    sb.append("-imgResponseCode_");
                    sb.append(i2);
                    if (i2 == 200) {
                    }
                    if (!m.isEmpty(str)) {
                    }
                    sb.append("-costTime_");
                    sb.append(currentTimeMillis22);
                    return sb.toString();
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (r0 != 0) {
                        try {
                            r0.disconnect();
                        } catch (Exception e8) {
                            BdLog.e(e8.getMessage());
                        }
                    }
                    throw th;
                }
                if (inputStream != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    while (true) {
                        int read = inputStream.read(bArr3);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (r0 != 0) {
                        try {
                            r0.disconnect();
                        } catch (Exception e9) {
                            BdLog.e(e9.getMessage());
                        }
                    }
                    str = "";
                    long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                    sb.append("-imgResponseCode_");
                    sb.append(i2);
                    if (i2 == 200) {
                        if (bArr2 != null) {
                            int length = bArr2.length;
                            String d2 = t.d(bArr2);
                            if (!"BA30C9CC61C537ACBD68397F95684A27".equalsIgnoreCase(d2)) {
                                sb.append("-MD5Error_");
                                sb.append(d2);
                                sb.append("_");
                                sb.append("BA30C9CC61C537ACBD68397F95684A27");
                                sb.append("-size_");
                                sb.append(length);
                            } else {
                                sb.append("-imgTestOk");
                            }
                        } else {
                            sb.append("-downSizeZero");
                        }
                    }
                    if (!m.isEmpty(str)) {
                        sb.append("-imgException_");
                        sb.append(str);
                    }
                    sb.append("-costTime_");
                    sb.append(currentTimeMillis222);
                    return sb.toString();
                }
                throw new IOException("get_content_is_null");
            }
            throw new SocketException();
        }
        return (String) invokeV.objValue;
    }
}
