package com.baidu.adp.lib.network.http.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import org.apache.http.HttpHost;
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
    public static String getHost(String str) {
        int indexOf;
        int max;
        if (k.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (Exception e) {
            BdLog.e(e);
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || (indexOf = str.indexOf(":")) == -1) {
                return "";
            }
            int i = indexOf + 3;
            int indexOf2 = str.indexOf(":", i);
            int indexOf3 = str.indexOf("/", i);
            if (indexOf2 == -1 || indexOf3 == -1) {
                max = Math.max(indexOf2, indexOf3);
            } else {
                max = Math.min(indexOf2, indexOf3);
            }
            if (max == -1 && i < str.length()) {
                return str.substring(i);
            }
            if (i != -1 && i < max) {
                return str.substring(i, max);
            }
            return "";
        }
    }

    public static String mk() {
        String ml = ml();
        return ml + mm();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0107 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9 A[Catch: Exception -> 0x0113, TryCatch #5 {Exception -> 0x0113, blocks: (B:3:0x000d, B:17:0x0099, B:20:0x00ad, B:22:0x00b8, B:56:0x0153, B:57:0x015b, B:23:0x00d3, B:25:0x00d9, B:26:0x00e2, B:51:0x0136, B:53:0x0140, B:40:0x0112, B:55:0x014b, B:39:0x010f, B:48:0x0130, B:15:0x0095), top: B:77:0x000d, inners: #0, #4, #8 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String ml() {
        HttpGet httpGet;
        long currentTimeMillis;
        String str;
        InputStream inputStream;
        byte[] bArr;
        int i = 0;
        ?? r1 = "http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg";
        StringBuilder sb = new StringBuilder();
        try {
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
                schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                str = "";
                try {
                    httpGet = new HttpGet("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg");
                    try {
                        HttpResponse execute = defaultHttpClient.execute(httpGet);
                        i = execute.getStatusLine().getStatusCode();
                        inputStream = execute.getEntity().getContent();
                        try {
                        } catch (Exception e) {
                            e = e;
                            bArr = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                        bArr = null;
                    } catch (Throwable th) {
                        th = th;
                        r1 = 0;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (httpGet != null) {
                            try {
                                httpGet.abort();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    inputStream = null;
                    bArr = null;
                    httpGet = null;
                } catch (Throwable th2) {
                    th = th2;
                    r1 = 0;
                    httpGet = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e6) {
            sb.append("-imgTestFail_");
            sb.append(e6.toString());
        }
        if (inputStream == null) {
            throw new IOException("get_content_is_null");
        }
        byte[] bArr2 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        while (true) {
            int read = inputStream.read(bArr2);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
        byte[] bArr3 = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e7) {
                }
            }
            if (httpGet != null) {
                try {
                    httpGet.abort();
                } catch (Exception e8) {
                    BdLog.e(e8.getMessage());
                }
            }
        } catch (Exception e9) {
            e = e9;
            bArr = bArr3;
            str = e.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e10) {
                }
            }
            if (httpGet != null) {
                try {
                    httpGet.abort();
                } catch (Exception e11) {
                    BdLog.e(e11.getMessage());
                    bArr3 = bArr;
                }
            }
            bArr3 = bArr;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            sb.append("-imgResponseCode_");
            sb.append(i);
            if (i == 200) {
            }
            if (!k.isEmpty(str)) {
            }
            sb.append("-costTime_");
            sb.append(currentTimeMillis2);
            return sb.toString();
        }
        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
        sb.append("-imgResponseCode_");
        sb.append(i);
        if (i == 200) {
            if (bArr3 != null) {
                int length = bArr3.length;
                String md5 = s.toMd5(bArr3);
                if (!"BA30C9CC61C537ACBD68397F95684A27".equalsIgnoreCase(md5)) {
                    sb.append("-MD5Error_");
                    sb.append(md5);
                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
        if (!k.isEmpty(str)) {
            sb.append("-imgException_");
            sb.append(str);
        }
        sb.append("-costTime_");
        sb.append(currentTimeMillis22);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String mm() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Exception e;
        byte[] bArr;
        int i;
        HttpURLConnection httpURLConnection2;
        byte[] bArr2;
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        String str = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpURLConnection2 = (HttpURLConnection) new URL("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg").openConnection();
            try {
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection2;
                bArr = null;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            bArr = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            inputStream = null;
        }
        if (httpURLConnection2 != null) {
            httpURLConnection2.setConnectTimeout(3000);
            httpURLConnection2.setReadTimeout(10000);
            httpURLConnection2.connect();
            i2 = httpURLConnection2.getResponseCode();
            inputStream = httpURLConnection2.getInputStream();
            try {
                try {
                    bArr2 = new byte[1024];
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection = httpURLConnection2;
                bArr = null;
            }
            if (inputStream == null) {
                throw new IOException("get_content_is_null");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e6) {
                        BdLog.e(e6.getMessage());
                        i = i2;
                    }
                }
                i = i2;
            } catch (Exception e7) {
                e = e7;
                httpURLConnection = httpURLConnection2;
                try {
                    str = e.toString();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e8) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e9) {
                            BdLog.e(e9.getMessage());
                            i = i2;
                        }
                    }
                    i = i2;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    sb.append("-imgResponseCode_");
                    sb.append(i);
                    if (i == 200) {
                    }
                    if (!k.isEmpty(str)) {
                    }
                    sb.append("-costTime_");
                    sb.append(currentTimeMillis2);
                    return sb.toString();
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e10) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e11) {
                            BdLog.e(e11.getMessage());
                        }
                    }
                    throw th;
                }
            }
            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
            sb.append("-imgResponseCode_");
            sb.append(i);
            if (i == 200) {
                if (bArr != null) {
                    int length = bArr.length;
                    String md5 = s.toMd5(bArr);
                    if (!"BA30C9CC61C537ACBD68397F95684A27".equalsIgnoreCase(md5)) {
                        sb.append("-MD5Error_");
                        sb.append(md5);
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            if (!k.isEmpty(str)) {
                sb.append("-imgException_");
                sb.append(str);
            }
            sb.append("-costTime_");
            sb.append(currentTimeMillis22);
            return sb.toString();
        }
        throw new SocketException();
    }

    public static String bL(String str) {
        if (k.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return str.replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://");
        }
        return str;
    }
}
