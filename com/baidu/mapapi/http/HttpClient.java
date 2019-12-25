package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.f;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class HttpClient {
    public static boolean isHttpsEnable = false;
    HttpURLConnection a;
    private String b = null;
    private String c = null;
    private int d;
    private int e;
    private String f;
    private ProtoResultCallback g;

    /* loaded from: classes5.dex */
    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* loaded from: classes5.dex */
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

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                switch (jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp")) {
                    case 105:
                    case 106:
                        int permissionCheck = PermissionCheck.permissionCheck();
                        if (permissionCheck != 0) {
                            Log.e("HttpClient", "permissionCheck result is: " + permissionCheck);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (JSONException e) {
            Log.e("HttpClient", "Parse json happened exception");
            e.printStackTrace();
        }
    }

    public static String getAuthToken() {
        return f.z;
    }

    public static String getPhoneInfo() {
        return f.c();
    }

    protected boolean checkNetwork() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x01a3 */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0183 A[Catch: Exception -> 0x00a0, TryCatch #1 {Exception -> 0x00a0, blocks: (B:13:0x003d, B:44:0x00cb, B:45:0x00d1, B:47:0x00d5, B:31:0x008f, B:32:0x0095, B:34:0x0099, B:76:0x0179, B:77:0x017f, B:79:0x0183, B:80:0x0188, B:59:0x0124, B:60:0x012a, B:62:0x012e), top: B:92:0x003d }] */
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
                            HttpStateError httpStateError = HttpStateError.NO_ERROR;
                            HttpStateError httpStateError2 = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            if (Logger.debugEnable()) {
                                inputStream = this.a.getErrorStream();
                                Logger.logW("HttpClient", inputStream.toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + ((int) r1) + ", error=" + httpStateError2);
                                inputStream = null;
                            }
                            this.g.onFailed(httpStateError2);
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
                            a(this.c);
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
                                Log.e("HttpClient", "Catch exception. INNER_ERROR");
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
                Log.e("HttpClient", "Catch connection exception, INNER_ERROR");
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
