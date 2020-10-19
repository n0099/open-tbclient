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

    public static String mN() {
        String mO = mO();
        return mO + mP();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de A[Catch: Exception -> 0x0118, TryCatch #5 {Exception -> 0x0118, blocks: (B:3:0x000d, B:18:0x009d, B:21:0x00b2, B:23:0x00bd, B:57:0x015a, B:58:0x0162, B:24:0x00d8, B:26:0x00de, B:27:0x00e7, B:52:0x013b, B:54:0x0145, B:41:0x0117, B:56:0x0152, B:40:0x0114, B:49:0x0135, B:16:0x0097), top: B:86:0x000d, inners: #7, #11, #14 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String mO() {
        HttpGet httpGet;
        long currentTimeMillis;
        String str;
        byte[] bArr;
        int i;
        InputStream inputStream;
        int i2;
        InputStream inputStream2 = null;
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
                        try {
                            HttpResponse execute = defaultHttpClient.execute(httpGet);
                            i2 = execute.getStatusLine().getStatusCode();
                            try {
                                inputStream = execute.getEntity().getContent();
                                try {
                                } catch (Exception e) {
                                    e = e;
                                    bArr = null;
                                    i = i2;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                inputStream = null;
                                bArr = null;
                                i = i2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bArr = null;
                            inputStream = null;
                            i = 0;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = null;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (httpGet != null) {
                            try {
                                httpGet.abort();
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    bArr = null;
                    httpGet = null;
                    i = 0;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = null;
                    httpGet = null;
                }
            } catch (Exception e7) {
                sb.append("-imgTestFail_");
                sb.append(e7.toString());
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
                    } catch (Exception e8) {
                    }
                }
                if (httpGet != null) {
                    try {
                        httpGet.abort();
                    } catch (Exception e9) {
                        BdLog.e(e9.getMessage());
                    }
                }
            } catch (Exception e10) {
                e = e10;
                bArr = bArr3;
                i = i2;
                str = e.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                    }
                }
                if (httpGet != null) {
                    try {
                        httpGet.abort();
                    } catch (Exception e12) {
                        BdLog.e(e12.getMessage());
                        int i3 = i;
                        bArr3 = bArr;
                        i2 = i3;
                    }
                }
                int i4 = i;
                bArr3 = bArr;
                i2 = i4;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                sb.append("-imgResponseCode_");
                sb.append(i2);
                if (i2 == 200) {
                }
                if (!k.isEmpty(str)) {
                }
                sb.append("-costTime_");
                sb.append(currentTimeMillis2);
                return sb.toString();
            }
            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
            sb.append("-imgResponseCode_");
            sb.append(i2);
            if (i2 == 200) {
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
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String mP() {
        InputStream inputStream;
        Exception e;
        byte[] bArr;
        int i;
        String exc;
        HttpURLConnection httpURLConnection;
        byte[] bArr2;
        HttpURLConnection httpURLConnection2 = null;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg").openConnection();
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    i = 0;
                }
            } catch (Throwable th) {
                inputStream = null;
                httpURLConnection2 = httpURLConnection;
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
            bArr = null;
            i = 0;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (httpURLConnection != null) {
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    try {
                        bArr2 = new byte[1024];
                    } catch (Throwable th3) {
                        httpURLConnection2 = httpURLConnection;
                        th = th3;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    bArr = null;
                    httpURLConnection2 = httpURLConnection;
                    i = responseCode;
                    e = e6;
                }
            } catch (Exception e7) {
                inputStream = null;
                i = responseCode;
                e = e7;
                bArr = null;
                httpURLConnection2 = httpURLConnection;
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
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
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
                        i = responseCode;
                        exc = "";
                        bArr = byteArray;
                    }
                }
                i = responseCode;
                exc = "";
                bArr = byteArray;
            } catch (Exception e10) {
                bArr = byteArray;
                httpURLConnection2 = httpURLConnection;
                i = responseCode;
                e = e10;
                try {
                    exc = e.toString();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e11) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e12) {
                            BdLog.e(e12.getMessage());
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    sb.append("-imgResponseCode_");
                    sb.append(i);
                    if (i == 200) {
                    }
                    if (!k.isEmpty(exc)) {
                    }
                    sb.append("-costTime_");
                    sb.append(currentTimeMillis2);
                    return sb.toString();
                } catch (Throwable th4) {
                    th = th4;
                    if (inputStream != null) {
                    }
                    if (httpURLConnection2 != null) {
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
            if (!k.isEmpty(exc)) {
                sb.append("-imgException_");
                sb.append(exc);
            }
            sb.append("-costTime_");
            sb.append(currentTimeMillis22);
            return sb.toString();
        }
        throw new SocketException();
    }

    public static String bO(String str) {
        if (k.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return str.replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://");
        }
        return str;
    }
}
