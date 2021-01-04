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
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes15.dex */
public class HttpClient {
    public static boolean isHttpsEnable = true;

    /* renamed from: a  reason: collision with root package name */
    HttpURLConnection f2784a;

    /* renamed from: b  reason: collision with root package name */
    private String f2785b = null;
    private String c = null;
    private int d;
    private int e;
    private String f;
    private ProtoResultCallback g;

    /* loaded from: classes15.dex */
    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* loaded from: classes15.dex */
    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f = str;
        this.g = protoResultCallback;
    }

    private HttpURLConnection a() {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f2785b);
            if (isHttpsEnable) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new b(this));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.d);
            httpURLConnection.setReadTimeout(this.e);
            return httpURLConnection;
        } catch (Exception e) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            return null;
        }
    }

    public static String getAuthToken() {
        return h.d;
    }

    public static String getPhoneInfo() {
        return h.d();
    }

    protected boolean checkNetwork() {
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                z = false;
            } else if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                z = networkCapabilities != null && networkCapabilities.hasCapability(12);
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            }
            return z;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0070 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x016a */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0179 A[Catch: Exception -> 0x009f, TryCatch #1 {Exception -> 0x009f, blocks: (B:13:0x003d, B:43:0x00c5, B:44:0x00cb, B:46:0x00cf, B:30:0x008e, B:31:0x0094, B:33:0x0098, B:74:0x016f, B:75:0x0175, B:77:0x0179, B:78:0x017e, B:58:0x011c, B:59:0x0122, B:61:0x0126), top: B:90:0x003d }] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void request(String str) {
        ?? r1;
        BufferedReader bufferedReader;
        InputStream inputStream;
        this.f2785b = str;
        if (!checkNetwork()) {
            this.g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        this.f2784a = a();
        if (this.f2784a == null) {
            Log.e("HttpClient", "url connection failed");
            this.g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.f2785b)) {
            this.g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            BufferedReader bufferedReader2 = null;
            try {
                this.f2784a.connect();
                try {
                    r1 = this.f2784a.getResponseCode();
                    try {
                        if (200 != r1) {
                            Log.e("HttpClient", "responseCode is: " + ((int) r1));
                            HttpStateError httpStateError = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            if (Logger.debugEnable()) {
                                inputStream = this.f2784a.getErrorStream();
                                Logger.logW("HttpClient", inputStream.toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + ((int) r1) + ", error=" + httpStateError);
                                inputStream = null;
                            }
                            this.g.onFailed(httpStateError);
                            if (inputStream != null && 0 != 0) {
                                bufferedReader2.close();
                                inputStream.close();
                            }
                            if (this.f2784a != null) {
                                this.f2784a.disconnect();
                                return;
                            }
                            return;
                        }
                        r1 = this.f2784a.getInputStream();
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
                                if (r1 != 0 && bufferedReader != null) {
                                    bufferedReader.close();
                                    r1.close();
                                }
                                if (this.f2784a != null) {
                                    this.f2784a.disconnect();
                                }
                                this.g.onSuccess(this.c);
                            } catch (Exception e) {
                                e = e;
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
                                if (this.f2784a != null) {
                                    this.f2784a.disconnect();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (r1 != 0 && bufferedReader != null) {
                                bufferedReader.close();
                                r1.close();
                            }
                            if (this.f2784a != null) {
                                this.f2784a.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        if (r1 != 0) {
                            bufferedReader.close();
                            r1.close();
                        }
                        if (this.f2784a != null) {
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    r1 = 0;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    r1 = 0;
                    bufferedReader = null;
                }
            } catch (Exception e4) {
                if (Logger.debugEnable()) {
                    e4.printStackTrace();
                } else {
                    Logger.logW("HttpClient", e4.getMessage());
                }
                Log.e("HttpClient", "Catch connection exception, INNER_ERROR", e4);
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
