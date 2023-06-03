package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.h;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes3.dex */
public class HttpClient {
    public static boolean isHttpsEnable = true;
    public HttpURLConnection a;
    public String b = null;
    public String c = null;
    public int d;
    public int e;
    public String f;
    public ProtoResultCallback g;

    /* loaded from: classes3.dex */
    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* loaded from: classes3.dex */
    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f = str;
        this.g = protoResultCallback;
    }

    /* loaded from: classes3.dex */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    private HttpURLConnection a() {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(this.b);
            if (isHttpsEnable) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                httpsURLConnection2.setHostnameVerifier(new a());
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpsURLConnection.setRequestMethod(this.f);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setConnectTimeout(this.d);
            httpsURLConnection.setReadTimeout(this.e);
            return httpsURLConnection;
        } catch (Exception e) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e.printStackTrace();
                return null;
            }
            Logger.logW("HttpClient", e.getMessage());
            return null;
        }
    }

    public boolean checkNetwork() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                    return false;
                }
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            e.printStackTrace();
            return false;
        }
    }

    public static String getAuthToken() {
        return h.c;
    }

    public static String getPhoneInfo() {
        return h.e();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x008a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0137 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0146 A[Catch: Exception -> 0x014c, TryCatch #0 {Exception -> 0x014c, blocks: (B:14:0x0038, B:26:0x0073, B:27:0x0079, B:29:0x007d, B:68:0x0127, B:69:0x012d, B:71:0x0131, B:76:0x013c, B:77:0x0142, B:79:0x0146, B:80:0x014b, B:53:0x00f3, B:55:0x00f7), top: B:88:0x0038 }] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void request(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        ?? r1;
        Exception e;
        HttpStateError httpStateError;
        this.b = str;
        if (!checkNetwork()) {
            this.g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        HttpURLConnection a2 = a();
        this.a = a2;
        if (a2 == null) {
            Log.e("HttpClient", "url connection failed");
            this.g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.b)) {
            this.g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            try {
                this.a.connect();
                try {
                    r1 = this.a.getResponseCode();
                    try {
                        if (200 == r1) {
                            r1 = this.a.getInputStream();
                            bufferedReader = new BufferedReader(new InputStreamReader((InputStream) r1, "UTF-8"));
                            try {
                                try {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while (true) {
                                        int read = bufferedReader.read();
                                        if (read == -1) {
                                            break;
                                        }
                                        stringBuffer.append((char) read);
                                    }
                                    this.c = stringBuffer.toString();
                                    if (r1 != 0) {
                                        bufferedReader.close();
                                        r1.close();
                                    }
                                    if (this.a != null) {
                                        this.a.disconnect();
                                    }
                                    this.g.onSuccess(this.c);
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                    if (Logger.debugEnable()) {
                                        e.printStackTrace();
                                    } else {
                                        Logger.logW("HttpClient", e.getMessage());
                                    }
                                    Log.e("HttpClient", "Catch exception. INNER_ERROR", e);
                                    this.g.onFailed(HttpStateError.INNER_ERROR);
                                    if (r1 != 0 && bufferedReader != null) {
                                        bufferedReader.close();
                                        r1.close();
                                    }
                                    if (this.a != null) {
                                        this.a.disconnect();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (r1 != 0 && bufferedReader != null) {
                                    bufferedReader.close();
                                    r1.close();
                                }
                                if (this.a != null) {
                                    this.a.disconnect();
                                }
                                throw th;
                            }
                        }
                        Log.e("HttpClient", "responseCode is: " + r1);
                        if (r1 >= 500) {
                            httpStateError = HttpStateError.SERVER_ERROR;
                        } else if (r1 >= 400) {
                            httpStateError = HttpStateError.REQUEST_ERROR;
                        } else {
                            httpStateError = HttpStateError.INNER_ERROR;
                        }
                        if (Logger.debugEnable()) {
                            Logger.logW("HttpClient", this.a.getErrorStream().toString());
                        } else {
                            Logger.logW("HttpClient", "Get response from server failed, http response code=" + r1 + ", error=" + httpStateError);
                        }
                        this.g.onFailed(httpStateError);
                        if (this.a != null) {
                            this.a.disconnect();
                        }
                    } catch (Exception e3) {
                        bufferedReader = null;
                        e = e3;
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                        if (r1 != 0) {
                            bufferedReader.close();
                            r1.close();
                        }
                        if (this.a != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    bufferedReader = null;
                    e = e4;
                    r1 = 0;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    r1 = 0;
                }
            } catch (Exception e5) {
                if (Logger.debugEnable()) {
                    e5.printStackTrace();
                } else {
                    Logger.logW("HttpClient", e5.getMessage());
                }
                Log.e("HttpClient", "Catch connection exception, INNER_ERROR", e5);
                this.g.onFailed(HttpStateError.INNER_ERROR);
            }
        }
    }

    public void setMaxTimeOut(int i) {
        this.d = i;
    }

    public void setReadTimeOut(int i) {
        this.e = i;
    }
}
