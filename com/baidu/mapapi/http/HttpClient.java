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
/* loaded from: classes4.dex */
public class HttpClient {
    public static boolean isHttpsEnable = false;

    /* renamed from: a  reason: collision with root package name */
    HttpURLConnection f2683a;

    /* renamed from: b  reason: collision with root package name */
    private String f2684b = null;
    private String c = null;
    private int d;
    private int e;
    private String f;
    private ProtoResultCallback g;

    /* loaded from: classes4.dex */
    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* loaded from: classes4.dex */
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
            URL url = new URL(this.f2684b);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0070 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x0171 */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0180 A[Catch: Exception -> 0x009f, TryCatch #2 {Exception -> 0x009f, blocks: (B:13:0x003d, B:43:0x00ca, B:44:0x00d0, B:46:0x00d4, B:30:0x008e, B:31:0x0094, B:33:0x0098, B:74:0x0176, B:75:0x017c, B:77:0x0180, B:78:0x0185, B:58:0x0123, B:59:0x0129, B:61:0x012d), top: B:91:0x003d }] */
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
        this.f2684b = str;
        if (!checkNetwork()) {
            this.g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        this.f2683a = a();
        if (this.f2683a == null) {
            Log.e("HttpClient", "url connection failed");
            this.g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.f2684b)) {
            this.g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            BufferedReader bufferedReader2 = null;
            try {
                this.f2683a.connect();
                try {
                    r1 = this.f2683a.getResponseCode();
                    try {
                        if (200 != r1) {
                            Log.e("HttpClient", "responseCode is: " + ((int) r1));
                            HttpStateError httpStateError = HttpStateError.NO_ERROR;
                            HttpStateError httpStateError2 = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            if (Logger.debugEnable()) {
                                inputStream = this.f2683a.getErrorStream();
                                Logger.logW("HttpClient", inputStream.toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + ((int) r1) + ", error=" + httpStateError2);
                                inputStream = null;
                            }
                            this.g.onFailed(httpStateError2);
                            if (inputStream != null && 0 != 0) {
                                bufferedReader2.close();
                                inputStream.close();
                            }
                            if (this.f2683a != null) {
                                this.f2683a.disconnect();
                                return;
                            }
                            return;
                        }
                        r1 = this.f2683a.getInputStream();
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
                                a(this.c);
                                if (r1 != 0 && bufferedReader != null) {
                                    bufferedReader.close();
                                    r1.close();
                                }
                                if (this.f2683a != null) {
                                    this.f2683a.disconnect();
                                }
                                this.g.onSuccess(this.c);
                            } catch (Exception e) {
                                e = e;
                                if (Logger.debugEnable()) {
                                    e.printStackTrace();
                                } else {
                                    Logger.logW("HttpClient", e.getMessage());
                                }
                                Log.e("HttpClient", "Catch exception. INNER_ERROR");
                                this.g.onFailed(HttpStateError.INNER_ERROR);
                                if (r1 != 0 && bufferedReader != null) {
                                    bufferedReader.close();
                                    r1.close();
                                }
                                if (this.f2683a != null) {
                                    this.f2683a.disconnect();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (r1 != 0 && bufferedReader != null) {
                                bufferedReader.close();
                                r1.close();
                            }
                            if (this.f2683a != null) {
                                this.f2683a.disconnect();
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
                        if (this.f2683a != null) {
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
