package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7848b = true;

    /* renamed from: c  reason: collision with root package name */
    public static final String f7849c = "c";

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f7850a;

    /* renamed from: d  reason: collision with root package name */
    public String f7851d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f7852e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f7853f;

    /* renamed from: g  reason: collision with root package name */
    public int f7854g;

    /* renamed from: h  reason: collision with root package name */
    public String f7855h;

    /* renamed from: i  reason: collision with root package name */
    public e f7856i;

    /* loaded from: classes2.dex */
    public enum a {
        SUCCESS,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public c(String str, e eVar) {
        this.f7855h = str;
        this.f7856i = eVar;
    }

    private void a(InputStream inputStream, BufferedReader bufferedReader, HttpURLConnection httpURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "IOException happened when release res", e2);
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String str = f7849c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "responseCode is: " + responseCode);
            if (200 != responseCode) {
                a(httpURLConnection, responseCode);
            } else {
                b(httpURLConnection);
            }
        } catch (IOException unused) {
            httpURLConnection.disconnect();
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7849c, "Catch connection exception, INNER_ERROR");
            this.f7856i.a(a.INNER_ERROR);
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i2) {
        a aVar = a.SUCCESS;
        a aVar2 = i2 >= 500 ? a.SERVER_ERROR : i2 >= 400 ? a.REQUEST_ERROR : a.INNER_ERROR;
        InputStream errorStream = httpURLConnection.getErrorStream();
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, errorStream.toString());
        String str = f7849c;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "Response error, response code = " + i2 + ", error = " + aVar2);
        if (errorStream != null) {
            try {
                errorStream.close();
            } catch (IOException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "IOException caught", e2);
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f7856i.a(aVar2);
    }

    private boolean a() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "Exception happened when check network", e2);
            e2.printStackTrace();
            return false;
        }
    }

    private HttpURLConnection b() {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(this.f7851d);
            if (f7848b) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                httpsURLConnection2.setHostnameVerifier(new d(this));
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpsURLConnection.setRequestMethod(this.f7855h);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setConnectTimeout(this.f7853f);
            httpsURLConnection.setReadTimeout(this.f7854g);
            return httpsURLConnection;
        } catch (Exception e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "url connect failed", e2);
            return null;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        IOException e2;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e3) {
            bufferedReader = null;
            e2 = e3;
            inputStream = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
            inputStream = null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int read = bufferedReader.read();
                        if (read == -1) {
                            String stringBuffer2 = stringBuffer.toString();
                            this.f7852e = stringBuffer2;
                            c(stringBuffer2);
                            a(inputStream, bufferedReader, httpURLConnection);
                            this.f7856i.a(this.f7852e);
                            return;
                        }
                        stringBuffer.append((char) read);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "Catch exception. INNER_ERROR", e2);
                    this.f7856i.a(a.INNER_ERROR);
                    a(inputStream, bufferedReader, httpURLConnection);
                }
            } catch (Throwable th3) {
                th = th3;
                a(inputStream, bufferedReader, httpURLConnection);
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            e2 = e5;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            a(inputStream, bufferedReader, httpURLConnection);
            throw th;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str) || this.f7856i == null) {
            String str2 = f7849c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "RequestUrl or ResultCallback is null. RequestUrl = " + str + "; ResultCallback is: " + this.f7856i);
            this.f7856i.a(a.REQUEST_ERROR);
            return false;
        }
        return true;
    }

    private void c(String str) {
        if (d(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7849c, "Permission check failed, try again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str2 = f7849c;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "The authorized result is: " + permissionCheck);
            }
        }
    }

    private boolean d(String str) {
        return e(str) || f(str);
    }

    private boolean e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                if (106 == i2 || 105 == i2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "Permission check failed due token");
                    return true;
                }
                return false;
            }
            return false;
        } catch (JSONException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "Parse json happened exception", e2);
            return false;
        }
    }

    private boolean f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7849c, "Permission check error due other");
                return true;
            }
            return false;
        } catch (JSONException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7849c, "Parse json happened exception", e2);
            return false;
        }
    }

    public void a(int i2) {
        this.f7854g = i2;
    }

    public void a(String str) {
        e eVar;
        a aVar;
        if (b(str)) {
            this.f7851d = str;
            String str2 = f7849c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "mRequestUrl is: " + this.f7851d);
            if (a()) {
                HttpURLConnection b2 = b();
                this.f7850a = b2;
                if (b2 != null) {
                    a(b2);
                    return;
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7849c, "url connection failed");
                eVar = this.f7856i;
                aVar = a.INNER_ERROR;
            } else {
                eVar = this.f7856i;
                aVar = a.NETWORK_ERROR;
            }
            eVar.a(aVar);
        }
    }

    public void b(int i2) {
        this.f7853f = i2;
    }
}
