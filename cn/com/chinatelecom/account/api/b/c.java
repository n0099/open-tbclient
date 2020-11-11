package cn.com.chinatelecom.account.api.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.c.i;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.xiaomi.mipush.sdk.Constants;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f975a = c.class.getSimpleName();

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:105:0x0233 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:113:0x023f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:119:0x0248 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:125:0x0253 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0222 A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:95:0x021d, B:97:0x0222, B:99:0x0227), top: B:137:0x021d }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0227 A[Catch: Exception -> 0x022b, TRY_LEAVE, TryCatch #3 {Exception -> 0x022b, blocks: (B:95:0x021d, B:97:0x0222, B:99:0x0227), top: B:137:0x021d }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(Context context, String str, Network network) {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        InputStream inputStream2;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2 = null;
        e eVar = new e();
        int connTimeout = CtSetting.getConnTimeout(null);
        ?? readTimeout = CtSetting.getReadTimeout(null);
        try {
            try {
                URL url = new URL(str);
                HttpURLConnection httpURLConnection = (network == null || Build.VERSION.SDK_INT < 21) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) network.openConnection(url);
                httpURLConnection.setRequestProperty(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, "*/*");
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(connTimeout);
                httpURLConnection.setReadTimeout(readTimeout);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                a(httpURLConnection, context);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                HttpURLConnection httpURLConnection2 = httpURLConnection;
                if (responseCode == 302) {
                    URL url2 = new URL(httpURLConnection.getHeaderField(com.baidubce.http.Headers.LOCATION));
                    HttpURLConnection httpURLConnection3 = (network == null || Build.VERSION.SDK_INT < 21) ? (HttpURLConnection) url2.openConnection() : (HttpURLConnection) network.openConnection(url2);
                    httpURLConnection3.setRequestProperty(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, "*/*");
                    httpURLConnection3.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection3.setRequestMethod("GET");
                    httpURLConnection3.setDoOutput(false);
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.setConnectTimeout(connTimeout);
                    httpURLConnection3.setReadTimeout(readTimeout);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.addRequestProperty("Accept-Charset", "UTF-8");
                    a(httpURLConnection3, context);
                    httpURLConnection3.connect();
                    httpURLConnection2 = httpURLConnection3;
                }
                HttpURLConnection httpURLConnection4 = httpURLConnection2;
                int responseCode2 = httpURLConnection4.getResponseCode();
                if (responseCode2 == 200) {
                    inputStream = httpURLConnection4.getInputStream();
                    try {
                        readTimeout = new InputStreamReader(inputStream);
                        try {
                            bufferedReader = new BufferedReader(readTimeout);
                            String str2 = "";
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    str2 = str2 + readLine;
                                } catch (SocketTimeoutException e) {
                                    e = e;
                                    bufferedReader2 = bufferedReader;
                                    inputStreamReader = readTimeout;
                                    inputStream2 = inputStream;
                                    try {
                                        CtAuth.warn(f975a, "doGet SocketTimeoutException : " + e.getMessage(), e);
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        return eVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream = inputStream2;
                                        readTimeout = inputStreamReader;
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (readTimeout != 0) {
                                            readTimeout.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (UnknownHostException e4) {
                                    e = e4;
                                    bufferedReader2 = bufferedReader;
                                    CtAuth.warn(f975a, "doGet UnknownHostException : " + e.getMessage(), e);
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (readTimeout != 0) {
                                        readTimeout.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return eVar;
                                } catch (IOException e6) {
                                    e = e6;
                                    bufferedReader2 = bufferedReader;
                                    CtAuth.warn(f975a, "doGet IOException : " + e.getMessage(), e);
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (readTimeout != 0) {
                                        readTimeout.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return eVar;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader2 = bufferedReader;
                                    if (bufferedReader2 != null) {
                                    }
                                    if (readTimeout != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                            eVar.f978a = 0;
                            eVar.b = str2;
                            b a2 = cn.com.chinatelecom.account.api.c.a.a(context, httpURLConnection4, true);
                            inputStreamReader2 = readTimeout;
                            if (a2 != null) {
                                eVar.c = a2.b;
                                eVar.d = a2.f974a;
                                inputStreamReader2 = readTimeout;
                            }
                        } catch (SocketTimeoutException e8) {
                            e = e8;
                            inputStreamReader = readTimeout;
                            inputStream2 = inputStream;
                        } catch (UnknownHostException e9) {
                            e = e9;
                        } catch (IOException e10) {
                            e = e10;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (SocketTimeoutException e11) {
                        e = e11;
                        inputStreamReader = null;
                        inputStream2 = inputStream;
                    } catch (UnknownHostException e12) {
                        e = e12;
                        readTimeout = 0;
                    } catch (IOException e13) {
                        e = e13;
                        readTimeout = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        readTimeout = 0;
                    }
                } else {
                    CtAuth.info(f975a, "redirect 30002 Http response code : " + responseCode2);
                    bufferedReader = null;
                    inputStreamReader2 = null;
                    inputStream = null;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SocketTimeoutException e15) {
            e = e15;
            inputStreamReader = null;
            inputStream2 = null;
        } catch (UnknownHostException e16) {
            e = e16;
            readTimeout = 0;
            inputStream = null;
        } catch (IOException e17) {
            e = e17;
            readTimeout = 0;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            readTimeout = 0;
            inputStream = null;
        }
        return eVar;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0338: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:118:0x0338 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0339: MOVE  (r11 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:118:0x0338 */
    public static e a(Context context, String str, String str2, CtSetting ctSetting, Network network, boolean z, int i, String str3) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2;
        e eVar = new e();
        InputStream inputStream3 = null;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    boolean d = cn.com.chinatelecom.account.api.c.e.d(context);
                    int connTimeout = CtSetting.getConnTimeout(ctSetting);
                    int readTimeout = CtSetting.getReadTimeout(ctSetting);
                    if (i > 0 && !d && Build.VERSION.SDK_INT < 21) {
                        a(context, str);
                    }
                    URL url = new URL(str);
                    HttpURLConnection httpURLConnection = (network == null || Build.VERSION.SDK_INT < 21) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) network.openConnection(url);
                    httpURLConnection.setRequestProperty(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, "*/*");
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(connTimeout);
                    httpURLConnection.setReadTimeout(readTimeout);
                    httpURLConnection.setUseCaches(false);
                    if (!d && Build.VERSION.SDK_INT < 21) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                    }
                    httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                    a(httpURLConnection, context);
                    if (TextUtils.isEmpty(str2)) {
                        httpURLConnection.connect();
                    } else {
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                        dataOutputStream.write(str2.getBytes("UTF-8"));
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        inputStream2 = httpURLConnection.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine).append("\n");
                                } catch (SocketTimeoutException e) {
                                    e = e;
                                    eVar.b = i.a(-8102, "Socket超时异常-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                                    CtAuth.warn(f975a, "doPost SocketTimeoutException-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage(), e);
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    return eVar;
                                } catch (UnknownHostException e3) {
                                    e = e3;
                                    bufferedReader3 = bufferedReader2;
                                    inputStream3 = inputStream2;
                                    eVar.b = i.a(-8103, "域名解析异常-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                                    CtAuth.warn(f975a, "doPost UnknownHostException-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage(), e);
                                    if (bufferedReader3 != null) {
                                        try {
                                            bufferedReader3.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    return eVar;
                                } catch (IOException e5) {
                                    e = e5;
                                    bufferedReader3 = bufferedReader2;
                                    inputStream3 = inputStream2;
                                    eVar.b = i.a(-8104, "IO异常-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                                    CtAuth.warn(f975a, "doPost IOException-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage(), e);
                                    if (bufferedReader3 != null) {
                                        try {
                                            bufferedReader3.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    return eVar;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader3 = bufferedReader2;
                                    inputStream3 = inputStream2;
                                    eVar.b = i.a(-8001, "请求网络异常-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.toString());
                                    CtAuth.warn(f975a, "doPost Throwable-" + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage(), th);
                                    if (bufferedReader3 != null) {
                                        try {
                                            bufferedReader3.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    return eVar;
                                }
                            }
                            eVar.f978a = 0;
                            eVar.b = sb.toString();
                            b a2 = cn.com.chinatelecom.account.api.c.a.a(context, httpURLConnection, z);
                            if (a2 != null) {
                                eVar.c = a2.b;
                                eVar.d = a2.f974a;
                            }
                            bufferedReader3 = bufferedReader2;
                            inputStream3 = inputStream2;
                        } catch (SocketTimeoutException e8) {
                            e = e8;
                            bufferedReader2 = null;
                        } catch (UnknownHostException e9) {
                            e = e9;
                            inputStream3 = inputStream2;
                        } catch (IOException e10) {
                            e = e10;
                            inputStream3 = inputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream3 = inputStream2;
                        }
                    } else if (responseCode != 302) {
                        eVar.b = i.a(-8101, "响应码错误-" + str3 + "-code : " + responseCode);
                        CtAuth.info(f975a, "doPost > Http response code :" + responseCode);
                    } else if (i < 10) {
                        e a3 = a(context, httpURLConnection.getHeaderField(com.baidubce.http.Headers.LOCATION), null, ctSetting, network, z, i + 1, "redirect");
                        if (0 != 0) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                return a3;
                            }
                        }
                        if (0 != 0) {
                            inputStream3.close();
                            return a3;
                        }
                        return a3;
                    } else {
                        eVar.b = i.a(-8001, "请求网络异常-Redirect more than 10 times ");
                    }
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (SocketTimeoutException e13) {
                e = e13;
                bufferedReader2 = null;
                inputStream2 = null;
            } catch (UnknownHostException e14) {
                e = e14;
            } catch (IOException e15) {
                e = e15;
            } catch (Throwable th4) {
                th = th4;
            }
            return eVar;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader3 = bufferedReader;
            inputStream3 = inputStream;
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                ((Boolean) Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(d.a(d.b(str))))).booleanValue();
            }
        } catch (Throwable th) {
            CtAuth.warn(f975a, "http doPost > requestUrlToRoute error", th);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                string = "";
            }
            httpURLConnection.setRequestProperty("guid", string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
