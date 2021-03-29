package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1565a = "d";

    /* JADX WARN: Removed duplicated region for block: B:61:0x00fc A[Catch: Exception -> 0x00de, TRY_ENTER, TryCatch #1 {Exception -> 0x00de, blocks: (B:44:0x00da, B:48:0x00e2, B:50:0x00e7, B:61:0x00fc, B:63:0x0101, B:65:0x0106), top: B:82:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101 A[Catch: Exception -> 0x00de, TryCatch #1 {Exception -> 0x00de, blocks: (B:44:0x00da, B:48:0x00e2, B:50:0x00e7, B:61:0x00fc, B:63:0x0101, B:65:0x0106), top: B:82:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0106 A[Catch: Exception -> 0x00de, TRY_LEAVE, TryCatch #1 {Exception -> 0x00de, blocks: (B:44:0x00da, B:48:0x00e2, B:50:0x00e7, B:61:0x00fc, B:63:0x0101, B:65:0x0106), top: B:82:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, Network network) {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str2 = "";
        int i = CtAuth.mConnTimeoutL;
        if (i <= 0) {
            i = 3000;
        }
        int i2 = CtAuth.mReadTimeout;
        int i3 = i2 > 0 ? i2 : 3000;
        try {
            try {
                URL url = new URL(str);
                HttpURLConnection httpURLConnection = (network == null || Build.VERSION.SDK_INT < 21) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) network.openConnection(url);
                httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i3);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 302) {
                    URL url2 = new URL(httpURLConnection.getHeaderField("Location"));
                    httpURLConnection = (HttpURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                    httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i3);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection.connect();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader3.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    str2 = str2 + readLine;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader3;
                                    try {
                                        CtAuth.warn(f1565a, "doGet error", th);
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        return str2;
                                    } catch (Throwable th2) {
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                throw th2;
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th2;
                                    }
                                }
                            }
                            bufferedReader2 = bufferedReader3;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            CtAuth.warn(f1565a, "doGet error", th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return str2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        bufferedReader = null;
                        CtAuth.warn(f1565a, "doGet error", th);
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        return str2;
                    }
                } else {
                    inputStream = null;
                    inputStreamReader = null;
                    bufferedReader2 = null;
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        return str2;
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x02d2 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x02d3 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x02df */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0242, code lost:
        if (r1 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0286, code lost:
        if (r1 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02c9, code lost:
        if (r1 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02cb, code lost:
        r16 = r1;
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01fe, code lost:
        if (r1 == null) goto L91;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023f A[Catch: all -> 0x02d2, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x02d2, blocks: (B:97:0x01fb, B:110:0x023f, B:123:0x0283, B:136:0x02c6), top: B:152:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0283 A[Catch: all -> 0x02d2, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x02d2, blocks: (B:97:0x01fb, B:110:0x023f, B:123:0x0283, B:136:0x02c6), top: B:152:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c6 A[Catch: all -> 0x02d2, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x02d2, blocks: (B:97:0x01fb, B:110:0x023f, B:123:0x0283, B:136:0x02c6), top: B:152:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01fb A[Catch: all -> 0x02d2, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x02d2, blocks: (B:97:0x01fb, B:110:0x023f, B:123:0x0283, B:136:0x02c6), top: B:152:0x001c }] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r23v0, types: [android.net.Network, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int, java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, String str2, Network network, String str3) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        BufferedReader bufferedReader4;
        InputStream inputStream2;
        String str4;
        BufferedReader bufferedReader5;
        String str5 = "POST";
        int i = CtAuth.mConnTimeoutL;
        if (i <= 0) {
            i = 3000;
        }
        ?? r9 = CtAuth.mReadTimeout;
        int i2 = r9 > 0 ? r9 : 3000;
        try {
            try {
                try {
                    URL url = new URL(str);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) ((network == 0 || Build.VERSION.SDK_INT < 21) ? url.openConnection() : network.openConnection(url));
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i2);
                    httpURLConnection.setUseCaches(false);
                    if (Build.VERSION.SDK_INT < 21) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                    }
                    httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                    if (TextUtils.isEmpty(str2)) {
                        httpURLConnection.connect();
                    } else {
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                        dataOutputStream.write(str2.getBytes("UTF-8"));
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    }
                    if (Build.VERSION.SDK_INT < 21 && httpURLConnection.getResponseCode() == 302) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (!TextUtils.isEmpty(headerField)) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                                Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(e.a(e.b(headerField))));
                            }
                        }
                        URL url2 = new URL(headerField);
                        httpURLConnection = (network == 0 || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2);
                        httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setConnectTimeout(i);
                        httpURLConnection.setReadTimeout(i2);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection.connect();
                    }
                    if (httpURLConnection.getResponseCode() == 302) {
                        URL url3 = new URL(httpURLConnection.getHeaderField("Location"));
                        httpURLConnection = (network == 0 || Build.VERSION.SDK_INT < 21) ? url3.openConnection() : network.openConnection(url3);
                        httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(i);
                        httpURLConnection.setReadTimeout(i2);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection.connect();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            BufferedReader bufferedReader6 = new BufferedReader(new InputStreamReader(inputStream));
                            while (true) {
                                try {
                                    String readLine = bufferedReader6.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                    sb.append("\n");
                                } catch (SocketTimeoutException e2) {
                                    e = e2;
                                    bufferedReader4 = bufferedReader6;
                                    str5 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}";
                                    String str6 = f1565a;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("sendRequest SocketTimeoutException-preauth-");
                                    sb2.append(e.getMessage());
                                    CtAuth.warn(str6, sb2.toString(), e);
                                    cn.com.chinatelecom.gateway.lib.b.b a2 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("doPost SocketTimeoutException -- ");
                                    sb3.append(e.getMessage());
                                    a2.h(sb3.toString());
                                    if (bufferedReader4 != null) {
                                    }
                                } catch (UnknownHostException e3) {
                                    e = e3;
                                    bufferedReader3 = bufferedReader6;
                                    str5 = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
                                    String str7 = f1565a;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("sendRequest UnknownHostException-preauth-");
                                    sb4.append(e.getMessage());
                                    CtAuth.warn(str7, sb4.toString(), e);
                                    cn.com.chinatelecom.gateway.lib.b.b a3 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("doPost UnknownHostException -- ");
                                    sb5.append(e.getMessage());
                                    a3.h(sb5.toString());
                                    if (bufferedReader3 != null) {
                                    }
                                } catch (IOException e4) {
                                    e = e4;
                                    bufferedReader2 = bufferedReader6;
                                    str5 = "{\"result\":80007,\"msg\":\"IO异常\"}";
                                    String str8 = f1565a;
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("sendRequest IOException-preauth-");
                                    sb6.append(e.getMessage());
                                    CtAuth.warn(str8, sb6.toString(), e);
                                    cn.com.chinatelecom.gateway.lib.b.b a4 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("doPost IOException -- ");
                                    sb7.append(e.getMessage());
                                    a4.h(sb7.toString());
                                    if (bufferedReader2 != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader6;
                                    str5 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                    String str9 = f1565a;
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("sendRequest Throwable-preauth-");
                                    sb8.append(th.getMessage());
                                    CtAuth.warn(str9, sb8.toString(), th);
                                    cn.com.chinatelecom.gateway.lib.b.b a5 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append("doPost Throwable -- ");
                                    sb9.append(th.getMessage());
                                    a5.h(sb9.toString());
                                    if (bufferedReader != null) {
                                    }
                                }
                            }
                            str4 = sb.toString();
                            cn.com.chinatelecom.gateway.lib.b.e.a(str3).g(a(context, httpURLConnection));
                            inputStream2 = inputStream;
                            bufferedReader5 = bufferedReader6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            bufferedReader4 = null;
                            str5 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}";
                            String str62 = f1565a;
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append("sendRequest SocketTimeoutException-preauth-");
                            sb22.append(e.getMessage());
                            CtAuth.warn(str62, sb22.toString(), e);
                            cn.com.chinatelecom.gateway.lib.b.b a22 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                            StringBuilder sb32 = new StringBuilder();
                            sb32.append("doPost SocketTimeoutException -- ");
                            sb32.append(e.getMessage());
                            a22.h(sb32.toString());
                            if (bufferedReader4 != null) {
                                bufferedReader4.close();
                            }
                        } catch (UnknownHostException e6) {
                            e = e6;
                            bufferedReader3 = null;
                            str5 = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
                            String str72 = f1565a;
                            StringBuilder sb42 = new StringBuilder();
                            sb42.append("sendRequest UnknownHostException-preauth-");
                            sb42.append(e.getMessage());
                            CtAuth.warn(str72, sb42.toString(), e);
                            cn.com.chinatelecom.gateway.lib.b.b a32 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                            StringBuilder sb52 = new StringBuilder();
                            sb52.append("doPost UnknownHostException -- ");
                            sb52.append(e.getMessage());
                            a32.h(sb52.toString());
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                        } catch (IOException e7) {
                            e = e7;
                            bufferedReader2 = null;
                            str5 = "{\"result\":80007,\"msg\":\"IO异常\"}";
                            String str82 = f1565a;
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append("sendRequest IOException-preauth-");
                            sb62.append(e.getMessage());
                            CtAuth.warn(str82, sb62.toString(), e);
                            cn.com.chinatelecom.gateway.lib.b.b a42 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                            StringBuilder sb72 = new StringBuilder();
                            sb72.append("doPost IOException -- ");
                            sb72.append(e.getMessage());
                            a42.h(sb72.toString());
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = null;
                            str5 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                            String str92 = f1565a;
                            StringBuilder sb82 = new StringBuilder();
                            sb82.append("sendRequest Throwable-preauth-");
                            sb82.append(th.getMessage());
                            CtAuth.warn(str92, sb82.toString(), th);
                            cn.com.chinatelecom.gateway.lib.b.b a52 = cn.com.chinatelecom.gateway.lib.b.e.a(str3);
                            StringBuilder sb92 = new StringBuilder();
                            sb92.append("doPost Throwable -- ");
                            sb92.append(th.getMessage());
                            a52.h(sb92.toString());
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                    } else {
                        str4 = "";
                        bufferedReader5 = null;
                        inputStream2 = null;
                    }
                    if (bufferedReader5 != null) {
                        try {
                            bufferedReader5.close();
                        } catch (Throwable unused) {
                            return str4;
                        }
                    }
                    if (inputStream2 == null) {
                        return str4;
                    }
                } catch (Throwable unused2) {
                    return str5;
                }
            } catch (Throwable th3) {
                if (r9 != 0) {
                    try {
                        r9.close();
                    } catch (Throwable unused3) {
                        throw th3;
                    }
                }
                if (network != 0) {
                    network.close();
                }
                throw th3;
            }
        } catch (SocketTimeoutException e8) {
            e = e8;
            inputStream = null;
        } catch (UnknownHostException e9) {
            e = e9;
            inputStream = null;
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
        inputStream2.close();
        return str4;
    }

    public static String a(Context context, HttpURLConnection httpURLConnection) {
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            List<String> list = headerFields.get("Log-Level");
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        cn.com.chinatelecom.gateway.lib.b.e.b(context, str);
                    }
                }
            }
            List<String> list2 = headerFields.get("p-ikgx");
            if (list2 == null || list2.isEmpty()) {
                return null;
            }
            String str2 = list2.get(0);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
