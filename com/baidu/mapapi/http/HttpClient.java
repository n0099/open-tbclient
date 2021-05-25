package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.i;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HttpClient {
    public static boolean isHttpsEnable = true;

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f6764a;

    /* renamed from: b  reason: collision with root package name */
    public String f6765b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f6766c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f6767d;

    /* renamed from: e  reason: collision with root package name */
    public int f6768e;

    /* renamed from: f  reason: collision with root package name */
    public String f6769f;

    /* renamed from: g  reason: collision with root package name */
    public ProtoResultCallback f6770g;

    /* loaded from: classes2.dex */
    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* loaded from: classes2.dex */
    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f6769f = str;
        this.f6770g = protoResultCallback;
    }

    private HttpURLConnection a() {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(this.f6765b);
            if (isHttpsEnable) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                httpsURLConnection2.setHostnameVerifier(new b(this));
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpsURLConnection.setRequestMethod(this.f6769f);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setConnectTimeout(this.f6767d);
            httpsURLConnection.setReadTimeout(this.f6768e);
            return httpsURLConnection;
        } catch (Exception e2) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e2.printStackTrace();
                return null;
            }
            Logger.logW("HttpClient", e2.getMessage());
            return null;
        }
    }

    private void a(String str) {
        int permissionCheck;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                if ((i2 == 105 || i2 == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                    Log.e("HttpClient", "permissionCheck result is: " + permissionCheck);
                }
            }
        } catch (JSONException e2) {
            Log.e("HttpClient", "Parse json happened exception");
            e2.printStackTrace();
        }
    }

    public static String getAuthToken() {
        return i.f7922d;
    }

    public static String getPhoneInfo() {
        return i.c();
    }

    public boolean checkNetwork() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception e2) {
            if (Logger.debugEnable()) {
                e2.printStackTrace();
            } else {
                Logger.logW("HttpClient", e2.getMessage());
            }
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x008d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x013a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0149 A[Catch: Exception -> 0x014f, TryCatch #2 {Exception -> 0x014f, blocks: (B:14:0x0038, B:26:0x0076, B:27:0x007c, B:29:0x0080, B:68:0x012a, B:69:0x0130, B:71:0x0134, B:76:0x013f, B:77:0x0145, B:79:0x0149, B:80:0x014e, B:53:0x00f6, B:55:0x00fa), top: B:88:0x0038 }] */
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
        Exception e2;
        this.f6765b = str;
        if (!checkNetwork()) {
            this.f6770g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        HttpURLConnection a2 = a();
        this.f6764a = a2;
        if (a2 == null) {
            Log.e("HttpClient", "url connection failed");
            this.f6770g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.f6765b)) {
            this.f6770g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            try {
                this.f6764a.connect();
                try {
                    r1 = this.f6764a.getResponseCode();
                    try {
                        if (200 != r1) {
                            Log.e("HttpClient", "responseCode is: " + r1);
                            HttpStateError httpStateError = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            if (Logger.debugEnable()) {
                                Logger.logW("HttpClient", this.f6764a.getErrorStream().toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + r1 + ", error=" + httpStateError);
                            }
                            this.f6770g.onFailed(httpStateError);
                            if (this.f6764a != null) {
                                this.f6764a.disconnect();
                                return;
                            }
                            return;
                        }
                        r1 = this.f6764a.getInputStream();
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
                                String stringBuffer2 = stringBuffer.toString();
                                this.f6766c = stringBuffer2;
                                a(stringBuffer2);
                                if (r1 != 0) {
                                    bufferedReader.close();
                                    r1.close();
                                }
                                if (this.f6764a != null) {
                                    this.f6764a.disconnect();
                                }
                                this.f6770g.onSuccess(this.f6766c);
                            } catch (Exception e3) {
                                e2 = e3;
                                if (Logger.debugEnable()) {
                                    e2.printStackTrace();
                                } else {
                                    Logger.logW("HttpClient", e2.getMessage());
                                }
                                Log.e("HttpClient", "Catch exception. INNER_ERROR", e2);
                                this.f6770g.onFailed(HttpStateError.INNER_ERROR);
                                if (r1 != 0 && bufferedReader != null) {
                                    bufferedReader.close();
                                    r1.close();
                                }
                                if (this.f6764a != null) {
                                    this.f6764a.disconnect();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (r1 != 0 && bufferedReader != null) {
                                bufferedReader.close();
                                r1.close();
                            }
                            if (this.f6764a != null) {
                                this.f6764a.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        bufferedReader = null;
                        e2 = e4;
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                        if (r1 != 0) {
                            bufferedReader.close();
                            r1.close();
                        }
                        if (this.f6764a != null) {
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    bufferedReader = null;
                    e2 = e5;
                    r1 = 0;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    r1 = 0;
                }
            } catch (Exception e6) {
                if (Logger.debugEnable()) {
                    e6.printStackTrace();
                } else {
                    Logger.logW("HttpClient", e6.getMessage());
                }
                Log.e("HttpClient", "Catch connection exception, INNER_ERROR", e6);
                this.f6770g.onFailed(HttpStateError.INNER_ERROR);
            }
        }
    }

    public void setMaxTimeOut(int i2) {
        this.f6767d = i2;
    }

    public void setReadTimeOut(int i2) {
        this.f6768e = i2;
    }
}
