package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "h";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515235, "Lcn/com/chinatelecom/gateway/lib/c/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515235, "Lcn/com/chinatelecom/gateway/lib/c/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0338 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0339 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0346 */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0270, code lost:
        if (r1 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02b0, code lost:
        if (r1 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02f0, code lost:
        if (r1 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x032f, code lost:
        if (r1 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0331, code lost:
        r16 = r1;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0230, code lost:
        if (r1 == null) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x026d A[Catch: all -> 0x0338, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0338, blocks: (B:96:0x022d, B:105:0x026d, B:114:0x02ad, B:123:0x02ed, B:132:0x032c), top: B:155:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ad A[Catch: all -> 0x0338, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0338, blocks: (B:96:0x022d, B:105:0x026d, B:114:0x02ad, B:123:0x02ed, B:132:0x032c), top: B:155:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ed A[Catch: all -> 0x0338, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0338, blocks: (B:96:0x022d, B:105:0x026d, B:114:0x02ad, B:123:0x02ed, B:132:0x032c), top: B:155:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x032c A[Catch: all -> 0x0338, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0338, blocks: (B:96:0x022d, B:105:0x026d, B:114:0x02ad, B:123:0x02ed, B:132:0x032c), top: B:155:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x022d A[Catch: all -> 0x0338, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0338, blocks: (B:96:0x022d, B:105:0x026d, B:114:0x02ad, B:123:0x02ed, B:132:0x032c), top: B:155:0x0020 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.BufferedReader, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, String str2, Network network, String str3, String str4) {
        InterceptResult invokeCommon;
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        SSLPeerUnverifiedException sSLPeerUnverifiedException;
        UnknownHostException unknownHostException;
        SocketTimeoutException socketTimeoutException;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        BufferedReader bufferedReader4;
        BufferedReader bufferedReader5;
        InputStream inputStream2;
        String str5;
        String str6;
        BufferedReader bufferedReader6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, network, str3, str4})) == null) {
            String str7 = "POST";
            int i = CtAuth.mConnTimeoutL;
            if (i <= 0) {
                i = 3000;
            }
            ?? r10 = CtAuth.mReadTimeout;
            int i2 = r10 > 0 ? r10 : 3000;
            try {
                try {
                    try {
                        URL url = new URL(str);
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url.openConnection() : network.openConnection(url));
                        httpsURLConnection.setRequestProperty("accept", "*/*");
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setConnectTimeout(i);
                        httpsURLConnection.setReadTimeout(i2);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setHostnameVerifier(new i());
                        if (Build.VERSION.SDK_INT < 21) {
                            httpsURLConnection.setInstanceFollowRedirects(false);
                        }
                        httpsURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                        httpsURLConnection.addRequestProperty("deviceId", str3);
                        httpsURLConnection.addRequestProperty("reqId", str4);
                        if (TextUtils.isEmpty(str2)) {
                            httpsURLConnection.connect();
                        } else {
                            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpsURLConnection.getOutputStream()));
                            dataOutputStream.write(str2.getBytes("UTF-8"));
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        }
                        if (Build.VERSION.SDK_INT >= 21 || httpsURLConnection.getResponseCode() != 302) {
                            str6 = "Location";
                        } else {
                            String headerField = httpsURLConnection.getHeaderField("Location");
                            if (!TextUtils.isEmpty(headerField)) {
                                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                                    str6 = "Location";
                                    Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(j.a(j.b(headerField))));
                                    URL url2 = new URL(headerField);
                                    httpsURLConnection = (HttpsURLConnection) ((network != null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
                                    httpsURLConnection.setRequestProperty("accept", "*/*");
                                    httpsURLConnection.setRequestMethod("POST");
                                    httpsURLConnection.setDoOutput(true);
                                    httpsURLConnection.setDoInput(true);
                                    httpsURLConnection.setConnectTimeout(i);
                                    httpsURLConnection.setReadTimeout(i2);
                                    httpsURLConnection.setUseCaches(false);
                                    httpsURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                                    httpsURLConnection.connect();
                                }
                            }
                            str6 = "Location";
                            URL url22 = new URL(headerField);
                            httpsURLConnection = (HttpsURLConnection) ((network != null || Build.VERSION.SDK_INT < 21) ? url22.openConnection() : network.openConnection(url22));
                            httpsURLConnection.setRequestProperty("accept", "*/*");
                            httpsURLConnection.setRequestMethod("POST");
                            httpsURLConnection.setDoOutput(true);
                            httpsURLConnection.setDoInput(true);
                            httpsURLConnection.setConnectTimeout(i);
                            httpsURLConnection.setReadTimeout(i2);
                            httpsURLConnection.setUseCaches(false);
                            httpsURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                            httpsURLConnection.connect();
                        }
                        if (httpsURLConnection.getResponseCode() == 302) {
                            URL url3 = new URL(httpsURLConnection.getHeaderField(str6));
                            httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url3.openConnection() : network.openConnection(url3));
                            httpsURLConnection.setRequestProperty("accept", "*/*");
                            httpsURLConnection.setRequestMethod("GET");
                            httpsURLConnection.setConnectTimeout(i);
                            httpsURLConnection.setReadTimeout(i2);
                            httpsURLConnection.setUseCaches(false);
                            httpsURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                            httpsURLConnection.connect();
                        }
                        if (httpsURLConnection.getResponseCode() == 200) {
                            inputStream = httpsURLConnection.getInputStream();
                            try {
                                StringBuilder sb = new StringBuilder();
                                BufferedReader bufferedReader7 = new BufferedReader(new InputStreamReader(inputStream));
                                while (true) {
                                    try {
                                        String readLine = bufferedReader7.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        sb.append(readLine);
                                        sb.append("\n");
                                    } catch (SocketTimeoutException e) {
                                        socketTimeoutException = e;
                                        bufferedReader5 = bufferedReader7;
                                        str7 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}";
                                        String str8 = a;
                                        CtAuth.warn(str8, "sendRequest SocketTimeoutException-preauth-" + socketTimeoutException.getMessage(), socketTimeoutException);
                                        cn.com.chinatelecom.gateway.lib.b.a a2 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                        a2.h("doPost SocketTimeoutException -- " + socketTimeoutException.getMessage());
                                        if (bufferedReader5 != null) {
                                        }
                                    } catch (UnknownHostException e2) {
                                        unknownHostException = e2;
                                        bufferedReader4 = bufferedReader7;
                                        str7 = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
                                        String str9 = a;
                                        CtAuth.warn(str9, "sendRequest UnknownHostException-preauth-" + unknownHostException.getMessage(), unknownHostException);
                                        cn.com.chinatelecom.gateway.lib.b.a a3 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                        a3.h("doPost UnknownHostException -- " + unknownHostException.getMessage());
                                        if (bufferedReader4 != null) {
                                        }
                                    } catch (SSLPeerUnverifiedException e3) {
                                        sSLPeerUnverifiedException = e3;
                                        bufferedReader3 = bufferedReader7;
                                        str7 = "{\"result\":80013,\"msg\":\"域名校验未通过\"}";
                                        String str10 = a;
                                        CtAuth.warn(str10, "sendRequest SSLPeerUnverifiedException-preauth-" + sSLPeerUnverifiedException.getMessage(), sSLPeerUnverifiedException);
                                        cn.com.chinatelecom.gateway.lib.b.a a4 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                        a4.h("doPost SSLPeerUnverifiedException -- " + sSLPeerUnverifiedException.getMessage());
                                        if (bufferedReader3 != null) {
                                        }
                                    } catch (IOException e4) {
                                        iOException = e4;
                                        bufferedReader2 = bufferedReader7;
                                        str7 = "{\"result\":80007,\"msg\":\"IO异常\"}";
                                        String str11 = a;
                                        CtAuth.warn(str11, "sendRequest IOException-preauth-" + iOException.getMessage(), iOException);
                                        cn.com.chinatelecom.gateway.lib.b.a a5 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                        a5.h("doPost IOException -- " + iOException.getMessage());
                                        if (bufferedReader2 != null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedReader = bufferedReader7;
                                        str7 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                        String str12 = a;
                                        CtAuth.warn(str12, "sendRequest Throwable-preauth-" + th.getMessage(), th);
                                        cn.com.chinatelecom.gateway.lib.b.a a6 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                        a6.h("doPost Throwable -- " + th.getMessage());
                                        if (bufferedReader != null) {
                                        }
                                    }
                                }
                                str5 = sb.toString();
                                cn.com.chinatelecom.gateway.lib.b.d.a(str4).g(a(context, httpsURLConnection));
                                inputStream2 = inputStream;
                                bufferedReader6 = bufferedReader7;
                            } catch (SocketTimeoutException e5) {
                                socketTimeoutException = e5;
                                bufferedReader5 = null;
                                str7 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}";
                                String str82 = a;
                                CtAuth.warn(str82, "sendRequest SocketTimeoutException-preauth-" + socketTimeoutException.getMessage(), socketTimeoutException);
                                cn.com.chinatelecom.gateway.lib.b.a a22 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                a22.h("doPost SocketTimeoutException -- " + socketTimeoutException.getMessage());
                                if (bufferedReader5 != null) {
                                    bufferedReader5.close();
                                }
                            } catch (UnknownHostException e6) {
                                unknownHostException = e6;
                                bufferedReader4 = null;
                                str7 = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
                                String str92 = a;
                                CtAuth.warn(str92, "sendRequest UnknownHostException-preauth-" + unknownHostException.getMessage(), unknownHostException);
                                cn.com.chinatelecom.gateway.lib.b.a a32 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                a32.h("doPost UnknownHostException -- " + unknownHostException.getMessage());
                                if (bufferedReader4 != null) {
                                    bufferedReader4.close();
                                }
                            } catch (SSLPeerUnverifiedException e7) {
                                sSLPeerUnverifiedException = e7;
                                bufferedReader3 = null;
                                str7 = "{\"result\":80013,\"msg\":\"域名校验未通过\"}";
                                String str102 = a;
                                CtAuth.warn(str102, "sendRequest SSLPeerUnverifiedException-preauth-" + sSLPeerUnverifiedException.getMessage(), sSLPeerUnverifiedException);
                                cn.com.chinatelecom.gateway.lib.b.a a42 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                a42.h("doPost SSLPeerUnverifiedException -- " + sSLPeerUnverifiedException.getMessage());
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                            } catch (IOException e8) {
                                iOException = e8;
                                bufferedReader2 = null;
                                str7 = "{\"result\":80007,\"msg\":\"IO异常\"}";
                                String str112 = a;
                                CtAuth.warn(str112, "sendRequest IOException-preauth-" + iOException.getMessage(), iOException);
                                cn.com.chinatelecom.gateway.lib.b.a a52 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                a52.h("doPost IOException -- " + iOException.getMessage());
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = null;
                                str7 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                String str122 = a;
                                CtAuth.warn(str122, "sendRequest Throwable-preauth-" + th.getMessage(), th);
                                cn.com.chinatelecom.gateway.lib.b.a a62 = cn.com.chinatelecom.gateway.lib.b.d.a(str4);
                                a62.h("doPost Throwable -- " + th.getMessage());
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                        } else {
                            str5 = "";
                            bufferedReader6 = null;
                            inputStream2 = null;
                        }
                        if (bufferedReader6 != null) {
                            try {
                                bufferedReader6.close();
                            } catch (Throwable unused) {
                                return str5;
                            }
                        }
                        if (inputStream2 == null) {
                            return str5;
                        }
                    } catch (Throwable unused2) {
                        return str7;
                    }
                } catch (Throwable th4) {
                    if (r10 != 0) {
                        try {
                            r10.close();
                        } catch (Throwable unused3) {
                            throw th4;
                        }
                    }
                    if (context != 0) {
                        context.close();
                    }
                    throw th4;
                }
            } catch (SocketTimeoutException e9) {
                socketTimeoutException = e9;
                inputStream = null;
            } catch (UnknownHostException e10) {
                unknownHostException = e10;
                inputStream = null;
            } catch (SSLPeerUnverifiedException e11) {
                sSLPeerUnverifiedException = e11;
                inputStream = null;
            } catch (IOException e12) {
                iOException = e12;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
            inputStream2.close();
            return str5;
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(Context context, HttpsURLConnection httpsURLConnection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, httpsURLConnection)) == null) {
            try {
                Map headerFields = httpsURLConnection.getHeaderFields();
                List list = (List) headerFields.get("Log-Level");
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        String str = (String) list.get(0);
                        if (!TextUtils.isEmpty(str)) {
                            cn.com.chinatelecom.gateway.lib.b.d.b(context, str);
                        }
                    }
                }
                List list2 = (List) headerFields.get("p-ikgx");
                if (list2 == null || list2.isEmpty()) {
                    return null;
                }
                String str2 = (String) list2.get(0);
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0101 A[Catch: Exception -> 0x00e3, TRY_ENTER, TryCatch #5 {Exception -> 0x00e3, blocks: (B:44:0x00df, B:48:0x00e7, B:50:0x00ec, B:59:0x0101, B:61:0x0106, B:63:0x010b), top: B:84:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106 A[Catch: Exception -> 0x00e3, TryCatch #5 {Exception -> 0x00e3, blocks: (B:44:0x00df, B:48:0x00e7, B:50:0x00ec, B:59:0x0101, B:61:0x0106, B:63:0x010b), top: B:84:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010b A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #5 {Exception -> 0x00e3, blocks: (B:44:0x00df, B:48:0x00e7, B:50:0x00ec, B:59:0x0101, B:61:0x0106, B:63:0x010b), top: B:84:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, Network network) {
        InterceptResult invokeLL;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, network)) == null) {
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
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url.openConnection() : network.openConnection(url));
                    httpsURLConnection.setRequestProperty("accept", "*/*");
                    httpsURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setDoOutput(false);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setConnectTimeout(i);
                    httpsURLConnection.setReadTimeout(i3);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 302) {
                        URL url2 = new URL(httpsURLConnection.getHeaderField("Location"));
                        httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
                        httpsURLConnection.setRequestProperty("accept", "*/*");
                        httpsURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setDoOutput(false);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setConnectTimeout(i);
                        httpsURLConnection.setReadTimeout(i3);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                        httpsURLConnection.connect();
                    }
                    if (httpsURLConnection.getResponseCode() == 200) {
                        inputStream = httpsURLConnection.getInputStream();
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
                                            CtAuth.warn(a, "doGet error", th);
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
                                        } catch (Throwable th2) {
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
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
                                inputStreamReader2 = inputStreamReader;
                                bufferedReader2 = bufferedReader3;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = null;
                                CtAuth.warn(a, "doGet error", th);
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                return str2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamReader = null;
                            bufferedReader = null;
                            CtAuth.warn(a, "doGet error", th);
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
                        bufferedReader2 = null;
                        inputStreamReader2 = null;
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
