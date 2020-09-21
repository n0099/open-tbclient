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
/* loaded from: classes3.dex */
public class HttpClient {
    public static boolean isHttpsEnable = true;
    HttpURLConnection a;
    private String b = null;
    private String c = null;
    private int d;
    private int e;
    private String f;
    private ProtoResultCallback g;

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

    private HttpURLConnection a() {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.b);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x019c */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c A[Catch: Exception -> 0x00a0, TryCatch #1 {Exception -> 0x00a0, blocks: (B:13:0x003d, B:44:0x00c6, B:45:0x00cc, B:47:0x00d0, B:31:0x008f, B:32:0x0095, B:34:0x0099, B:76:0x0172, B:77:0x0178, B:79:0x017c, B:80:0x0181, B:59:0x011d, B:60:0x0123, B:62:0x0127), top: B:92:0x003d }] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void request(String str) {
        BufferedReader bufferedReader;
        ?? r1;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r2 = null;
        BufferedReader bufferedReader2 = null;
        this.b = str;
        if (!checkNetwork()) {
            this.g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        this.a = a();
        if (this.a == null) {
            Log.e("HttpClient", "url connection failed");
            this.g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.b)) {
            this.g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            BufferedReader bufferedReader3 = null;
            try {
                this.a.connect();
                try {
                    r1 = this.a.getResponseCode();
                    try {
                        if (200 != r1) {
                            Log.e("HttpClient", "responseCode is: " + ((int) r1));
                            HttpStateError httpStateError = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            if (Logger.debugEnable()) {
                                inputStream = this.a.getErrorStream();
                                Logger.logW("HttpClient", inputStream.toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + ((int) r1) + ", error=" + httpStateError);
                                inputStream = null;
                            }
                            this.g.onFailed(httpStateError);
                            if (inputStream != null && 0 != 0) {
                                bufferedReader3.close();
                                inputStream.close();
                            }
                            if (this.a != null) {
                                this.a.disconnect();
                                return;
                            }
                            return;
                        }
                        r1 = this.a.getInputStream();
                        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) r1, "UTF-8"));
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
                            if (this.a != null) {
                                this.a.disconnect();
                            }
                            this.g.onSuccess(this.c);
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            try {
                                if (Logger.debugEnable()) {
                                    e.printStackTrace();
                                } else {
                                    Logger.logW("HttpClient", e.getMessage());
                                }
                                Log.e("HttpClient", "Catch exception. INNER_ERROR", e);
                                this.g.onFailed(HttpStateError.INNER_ERROR);
                                if (r1 != 0 && bufferedReader2 != null) {
                                    bufferedReader2.close();
                                    r1.close();
                                }
                                if (this.a != null) {
                                    this.a.disconnect();
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                inputStream2 = r1;
                                if (inputStream2 != null && bufferedReader != null) {
                                    bufferedReader.close();
                                    inputStream2.close();
                                }
                                if (this.a != null) {
                                    this.a.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = r1;
                            if (inputStream2 != null) {
                                bufferedReader.close();
                                inputStream2.close();
                            }
                            if (this.a != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        inputStream2 = r1;
                    }
                } catch (Exception e3) {
                    e = e3;
                    r1 = 0;
                } catch (Throwable th4) {
                    th = th4;
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
