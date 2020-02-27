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
/* loaded from: classes8.dex */
public class c {
    HttpURLConnection a;
    private String d = null;
    private String e = null;
    private int f;
    private int g;
    private String h;
    private e i;
    private static final String c = c.class.getSimpleName();
    public static boolean b = true;

    /* loaded from: classes8.dex */
    public enum a {
        SUCCESS,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public c(String str, e eVar) {
        this.h = str;
        this.i = eVar;
    }

    private void a(InputStream inputStream, BufferedReader bufferedReader, HttpURLConnection httpURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "IOException happened when release res", e);
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
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "responseCode is: " + responseCode);
            if (200 != responseCode) {
                a(httpURLConnection, responseCode);
            } else {
                b(httpURLConnection);
            }
        } catch (IOException e) {
            httpURLConnection.disconnect();
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Catch connection exception, INNER_ERROR");
            this.i.a(a.INNER_ERROR);
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        a aVar = a.SUCCESS;
        a aVar2 = i >= 500 ? a.SERVER_ERROR : i >= 400 ? a.REQUEST_ERROR : a.INNER_ERROR;
        InputStream errorStream = httpURLConnection.getErrorStream();
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, errorStream.toString());
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Response error, response code = " + i + ", error = " + aVar2);
        if (errorStream != null) {
            try {
                errorStream.close();
            } catch (IOException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "IOException caught", e);
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.i.a(aVar2);
    }

    private boolean a() {
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
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Exception happened when check network", e);
            e.printStackTrace();
            return false;
        }
    }

    private HttpURLConnection b() {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.d);
            if (b) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new d(this));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.h);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.f);
            httpURLConnection.setReadTimeout(this.g);
            return httpURLConnection;
        } catch (Exception e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "url connect failed", e);
            return null;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int read = bufferedReader.read();
                if (read == -1) {
                    this.e = stringBuffer.toString();
                    c(this.e);
                    a(inputStream, bufferedReader, httpURLConnection);
                    this.i.a(this.e);
                    return;
                }
                stringBuffer.append((char) read);
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Catch exception. INNER_ERROR", e);
            this.i.a(a.INNER_ERROR);
            a(inputStream, bufferedReader2, httpURLConnection);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            a(inputStream, bufferedReader2, httpURLConnection);
            throw th;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str) || this.i == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "RequestUrl or ResultCallback is null. RequestUrl = " + str + "; ResultCallback is: " + this.i);
            this.i.a(a.REQUEST_ERROR);
            return false;
        }
        return true;
    }

    private void c(String str) {
        if (d(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Permission check failed, try again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "The authorized result is: " + permissionCheck);
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
                int i = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                if (106 == i || 105 == i) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Permission check failed due token");
                    return true;
                }
            }
        } catch (JSONException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Parse json happened exception", e);
        }
        return false;
    }

    private boolean f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Permission check error due other");
                return true;
            }
        } catch (JSONException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Parse json happened exception", e);
        }
        return false;
    }

    public void a(int i) {
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (b(str)) {
            this.d = str;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "mRequestUrl is: " + this.d);
            if (!a()) {
                this.i.a(a.NETWORK_ERROR);
                return;
            }
            this.a = b();
            if (this.a != null) {
                a(this.a);
                return;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "url connection failed");
            this.i.a(a.INNER_ERROR);
        }
    }

    public void b(int i) {
        this.f = i;
    }
}
