package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515359, "Lcn/com/chinatelecom/gateway/lib/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515359, "Lcn/com/chinatelecom/gateway/lib/c/d;");
        }
    }

    public d() {
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

    /* JADX WARN: Removed duplicated region for block: B:63:0x0100 A[Catch: Exception -> 0x00e2, TRY_ENTER, TryCatch #6 {Exception -> 0x00e2, blocks: (B:46:0x00de, B:50:0x00e6, B:52:0x00eb, B:63:0x0100, B:65:0x0105, B:67:0x010a), top: B:88:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105 A[Catch: Exception -> 0x00e2, TryCatch #6 {Exception -> 0x00e2, blocks: (B:46:0x00de, B:50:0x00e6, B:52:0x00eb, B:63:0x0100, B:65:0x0105, B:67:0x010a), top: B:88:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010a A[Catch: Exception -> 0x00e2, TRY_LEAVE, TryCatch #6 {Exception -> 0x00e2, blocks: (B:46:0x00de, B:50:0x00e6, B:52:0x00eb, B:63:0x0100, B:65:0x0105, B:67:0x010a), top: B:88:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, Network network) {
        InterceptResult invokeLLL;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, network)) == null) {
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
                    HttpsURLConnection httpsURLConnection = (network == null || Build.VERSION.SDK_INT < 21) ? (HttpsURLConnection) url.openConnection() : (HttpsURLConnection) network.openConnection(url);
                    httpsURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
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
                        URL url2 = new URL(httpsURLConnection.getHeaderField(Headers.LOCATION));
                        httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
                        httpsURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
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
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0350 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0351 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x035e */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0234, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0279, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02be, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0303, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0347, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0349, code lost:
        r16 = r1;
        r2 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0231 A[Catch: all -> 0x0350, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0350, blocks: (B:109:0x0231, B:122:0x0276, B:135:0x02bb, B:148:0x0300, B:161:0x0344), top: B:182:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0276 A[Catch: all -> 0x0350, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0350, blocks: (B:109:0x0231, B:122:0x0276, B:135:0x02bb, B:148:0x0300, B:161:0x0344), top: B:182:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02bb A[Catch: all -> 0x0350, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0350, blocks: (B:109:0x0231, B:122:0x0276, B:135:0x02bb, B:148:0x0300, B:161:0x0344), top: B:182:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0300 A[Catch: all -> 0x0350, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0350, blocks: (B:109:0x0231, B:122:0x0276, B:135:0x02bb, B:148:0x0300, B:161:0x0344), top: B:182:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0344 A[Catch: all -> 0x0350, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0350, blocks: (B:109:0x0231, B:122:0x0276, B:135:0x02bb, B:148:0x0300, B:161:0x0344), top: B:182:0x0020 }] */
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, network, str3, str4})) == null) {
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
                        httpsURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setConnectTimeout(i);
                        httpsURLConnection.setReadTimeout(i2);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setHostnameVerifier(a());
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
                            str6 = Headers.LOCATION;
                        } else {
                            String headerField = httpsURLConnection.getHeaderField(Headers.LOCATION);
                            if (!TextUtils.isEmpty(headerField)) {
                                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                                    int a2 = e.a(e.b(headerField));
                                    Class<?> cls = Class.forName("android.net.ConnectivityManager");
                                    str6 = Headers.LOCATION;
                                    cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(a2));
                                    URL url2 = new URL(headerField);
                                    httpsURLConnection = (HttpsURLConnection) ((network != null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
                                    httpsURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
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
                            str6 = Headers.LOCATION;
                            URL url22 = new URL(headerField);
                            httpsURLConnection = (HttpsURLConnection) ((network != null || Build.VERSION.SDK_INT < 21) ? url22.openConnection() : network.openConnection(url22));
                            httpsURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
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
                            httpsURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
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
                                    } catch (SocketTimeoutException e2) {
                                        socketTimeoutException = e2;
                                        bufferedReader5 = bufferedReader7;
                                        str7 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}";
                                        String str8 = a;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("sendRequest SocketTimeoutException-preauth-");
                                        sb2.append(socketTimeoutException.getMessage());
                                        CtAuth.warn(str8, sb2.toString(), socketTimeoutException);
                                        cn.com.chinatelecom.gateway.lib.b.b a3 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("doPost SocketTimeoutException -- ");
                                        sb3.append(socketTimeoutException.getMessage());
                                        a3.h(sb3.toString());
                                        if (bufferedReader5 != null) {
                                        }
                                    } catch (UnknownHostException e3) {
                                        unknownHostException = e3;
                                        bufferedReader4 = bufferedReader7;
                                        str7 = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
                                        String str9 = a;
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("sendRequest UnknownHostException-preauth-");
                                        sb4.append(unknownHostException.getMessage());
                                        CtAuth.warn(str9, sb4.toString(), unknownHostException);
                                        cn.com.chinatelecom.gateway.lib.b.b a4 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("doPost UnknownHostException -- ");
                                        sb5.append(unknownHostException.getMessage());
                                        a4.h(sb5.toString());
                                        if (bufferedReader4 != null) {
                                        }
                                    } catch (SSLPeerUnverifiedException e4) {
                                        sSLPeerUnverifiedException = e4;
                                        bufferedReader3 = bufferedReader7;
                                        str7 = "{\"result\":80013,\"msg\":\"域名校验未通过\"}";
                                        String str10 = a;
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append("sendRequest SSLPeerUnverifiedException-preauth-");
                                        sb6.append(sSLPeerUnverifiedException.getMessage());
                                        CtAuth.warn(str10, sb6.toString(), sSLPeerUnverifiedException);
                                        cn.com.chinatelecom.gateway.lib.b.b a5 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("doPost SSLPeerUnverifiedException -- ");
                                        sb7.append(sSLPeerUnverifiedException.getMessage());
                                        a5.h(sb7.toString());
                                        if (bufferedReader3 != null) {
                                        }
                                    } catch (IOException e5) {
                                        iOException = e5;
                                        bufferedReader2 = bufferedReader7;
                                        str7 = "{\"result\":80007,\"msg\":\"IO异常\"}";
                                        String str11 = a;
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append("sendRequest IOException-preauth-");
                                        sb8.append(iOException.getMessage());
                                        CtAuth.warn(str11, sb8.toString(), iOException);
                                        cn.com.chinatelecom.gateway.lib.b.b a6 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                        StringBuilder sb9 = new StringBuilder();
                                        sb9.append("doPost IOException -- ");
                                        sb9.append(iOException.getMessage());
                                        a6.h(sb9.toString());
                                        if (bufferedReader2 != null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedReader = bufferedReader7;
                                        str7 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                        String str12 = a;
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append("sendRequest Throwable-preauth-");
                                        sb10.append(th.getMessage());
                                        CtAuth.warn(str12, sb10.toString(), th);
                                        cn.com.chinatelecom.gateway.lib.b.b a7 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                        StringBuilder sb11 = new StringBuilder();
                                        sb11.append("doPost Throwable -- ");
                                        sb11.append(th.getMessage());
                                        a7.h(sb11.toString());
                                        if (bufferedReader != null) {
                                        }
                                    }
                                }
                                str5 = sb.toString();
                                cn.com.chinatelecom.gateway.lib.b.e.a(str4).g(a(context, httpsURLConnection));
                                inputStream2 = inputStream;
                                bufferedReader6 = bufferedReader7;
                            } catch (SocketTimeoutException e6) {
                                socketTimeoutException = e6;
                                bufferedReader5 = null;
                                str7 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}";
                                String str82 = a;
                                StringBuilder sb22 = new StringBuilder();
                                sb22.append("sendRequest SocketTimeoutException-preauth-");
                                sb22.append(socketTimeoutException.getMessage());
                                CtAuth.warn(str82, sb22.toString(), socketTimeoutException);
                                cn.com.chinatelecom.gateway.lib.b.b a32 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                StringBuilder sb32 = new StringBuilder();
                                sb32.append("doPost SocketTimeoutException -- ");
                                sb32.append(socketTimeoutException.getMessage());
                                a32.h(sb32.toString());
                                if (bufferedReader5 != null) {
                                    bufferedReader5.close();
                                }
                            } catch (UnknownHostException e7) {
                                unknownHostException = e7;
                                bufferedReader4 = null;
                                str7 = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
                                String str92 = a;
                                StringBuilder sb42 = new StringBuilder();
                                sb42.append("sendRequest UnknownHostException-preauth-");
                                sb42.append(unknownHostException.getMessage());
                                CtAuth.warn(str92, sb42.toString(), unknownHostException);
                                cn.com.chinatelecom.gateway.lib.b.b a42 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                StringBuilder sb52 = new StringBuilder();
                                sb52.append("doPost UnknownHostException -- ");
                                sb52.append(unknownHostException.getMessage());
                                a42.h(sb52.toString());
                                if (bufferedReader4 != null) {
                                    bufferedReader4.close();
                                }
                            } catch (SSLPeerUnverifiedException e8) {
                                sSLPeerUnverifiedException = e8;
                                bufferedReader3 = null;
                                str7 = "{\"result\":80013,\"msg\":\"域名校验未通过\"}";
                                String str102 = a;
                                StringBuilder sb62 = new StringBuilder();
                                sb62.append("sendRequest SSLPeerUnverifiedException-preauth-");
                                sb62.append(sSLPeerUnverifiedException.getMessage());
                                CtAuth.warn(str102, sb62.toString(), sSLPeerUnverifiedException);
                                cn.com.chinatelecom.gateway.lib.b.b a52 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                StringBuilder sb72 = new StringBuilder();
                                sb72.append("doPost SSLPeerUnverifiedException -- ");
                                sb72.append(sSLPeerUnverifiedException.getMessage());
                                a52.h(sb72.toString());
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                            } catch (IOException e9) {
                                iOException = e9;
                                bufferedReader2 = null;
                                str7 = "{\"result\":80007,\"msg\":\"IO异常\"}";
                                String str112 = a;
                                StringBuilder sb82 = new StringBuilder();
                                sb82.append("sendRequest IOException-preauth-");
                                sb82.append(iOException.getMessage());
                                CtAuth.warn(str112, sb82.toString(), iOException);
                                cn.com.chinatelecom.gateway.lib.b.b a62 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                StringBuilder sb92 = new StringBuilder();
                                sb92.append("doPost IOException -- ");
                                sb92.append(iOException.getMessage());
                                a62.h(sb92.toString());
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = null;
                                str7 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                                String str122 = a;
                                StringBuilder sb102 = new StringBuilder();
                                sb102.append("sendRequest Throwable-preauth-");
                                sb102.append(th.getMessage());
                                CtAuth.warn(str122, sb102.toString(), th);
                                cn.com.chinatelecom.gateway.lib.b.b a72 = cn.com.chinatelecom.gateway.lib.b.e.a(str4);
                                StringBuilder sb112 = new StringBuilder();
                                sb112.append("doPost Throwable -- ");
                                sb112.append(th.getMessage());
                                a72.h(sb112.toString());
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
            } catch (SocketTimeoutException e10) {
                socketTimeoutException = e10;
                inputStream = null;
            } catch (UnknownHostException e11) {
                unknownHostException = e11;
                inputStream = null;
            } catch (SSLPeerUnverifiedException e12) {
                sSLPeerUnverifiedException = e12;
                inputStream = null;
            } catch (IOException e13) {
                iOException = e13;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, httpsURLConnection)) == null) {
            try {
                Map headerFields = httpsURLConnection.getHeaderFields();
                List list = (List) headerFields.get("Log-Level");
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        String str = (String) list.get(0);
                        if (!TextUtils.isEmpty(str)) {
                            cn.com.chinatelecom.gateway.lib.b.e.b(context, str);
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

    public static final HostnameVerifier a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new HostnameVerifier() { // from class: cn.com.chinatelecom.gateway.lib.c.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) ? HttpsURLConnection.getDefaultHostnameVerifier().verify("id6.me", sSLSession) : invokeLL.booleanValue;
            }
        } : (HostnameVerifier) invokeV.objValue;
    }
}
