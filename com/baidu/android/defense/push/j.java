package com.baidu.android.defense.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    private static final String b = com.baidu.android.moplus.a.a + "/xcloudboss?r=push/register";
    private static j c = null;
    protected boolean a = true;
    private Context d;
    private int e;
    private BroadcastReceiver f;

    private j(Context context) {
        this.d = null;
        this.e = 1;
        this.f = null;
        this.d = context.getApplicationContext();
        this.e = 1;
        this.f = new PushMsgReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.android.pushservice.action.internal.RECEIVE");
        this.d.registerReceiver(this.f, intentFilter);
    }

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (c == null) {
                c = new j(context);
            }
            jVar = c;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ((jSONObject.has("status") ? jSONObject.getInt("status") : -1) == 0) {
                g.h(this.d);
            }
        } catch (JSONException e) {
        }
    }

    public static synchronized void d() {
        synchronized (j.class) {
            if (c != null) {
                c.c();
                c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (System.currentTimeMillis() - g.i(this.d) < 86400000) {
            return;
        }
        String c2 = g.c(this.d);
        if (TextUtils.isEmpty(c2)) {
            if (this.a) {
                this.a = false;
                f();
                return;
            }
            return;
        }
        Intent a = b.a(this.d);
        if (com.baidu.android.moplus.util.a.j(this.d)) {
            a.putExtra("access_token", b.a(c2));
            a.putExtra("method", "method_sdk_bind");
            a.putExtra("bind_name", Build.MODEL);
            a.putExtra("bind_status", 0);
            a.putExtra("secret_key", "Zq8wwbvNemxR4qGmWGhE6sva");
            a.putExtra("sdk_client_version", 20);
        } else {
            a.putExtra("access_token", b.a(c2));
            a.putExtra("method", "method_bind");
            a.putExtra("bind_name", Build.MODEL);
            a.putExtra("bind_status", 0);
            a.putExtra("secret_key", "Zq8wwbvNemxR4qGmWGhE6sva");
            a.putExtra("sdk_client_version", 20);
        }
        this.d.sendBroadcast(a);
        g.j(this.d);
    }

    private void f() {
        UrlEncodedFormEntity urlEncodedFormEntity;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("grant_type", "client_credentials"));
        arrayList.add(new BasicNameValuePair("client_id", "Zq8wwbvNemxR4qGmWGhE6sva"));
        arrayList.add(new BasicNameValuePair("client_secret", "iq1WKpTUQYoplQqGUmu6iVtU0vkKN41I"));
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
        } catch (UnsupportedEncodingException e) {
            urlEncodedFormEntity = null;
        }
        if (urlEncodedFormEntity != null) {
            new Thread(new a(this, "https://openapi.baidu.com/oauth/2.0/token", urlEncodedFormEntity, 0), "getAccessToken").start();
        }
    }

    private UrlEncodedFormEntity g() {
        String str = "";
        String packageName = this.d.getPackageName();
        try {
            str = String.valueOf(this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String a = com.baidu.android.nebula.a.j.a(this.d);
        String d = g.d(this.d);
        String e2 = g.e(this.d);
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        String valueOf2 = String.valueOf(displayMetrics.widthPixels);
        String valueOf3 = String.valueOf(displayMetrics.heightPixels);
        String valueOf4 = String.valueOf(displayMetrics.densityDpi);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(a)) {
            arrayList.add(new BasicNameValuePair("cuid", a));
        }
        if (!TextUtils.isEmpty(e2)) {
            arrayList.add(new BasicNameValuePair("ch_uid", e2));
        }
        if (!TextUtils.isEmpty(d)) {
            arrayList.add(new BasicNameValuePair("ch_cid", d));
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new BasicNameValuePair("version_code", str));
        }
        if (!TextUtils.isEmpty(packageName)) {
            arrayList.add(new BasicNameValuePair("packagename", packageName));
        }
        arrayList.add(new BasicNameValuePair("sdk_version", valueOf));
        arrayList.add(new BasicNameValuePair("mobile_width", valueOf2));
        arrayList.add(new BasicNameValuePair("mobile_height", valueOf3));
        arrayList.add(new BasicNameValuePair("mobile_density", valueOf4));
        arrayList.add(new BasicNameValuePair("bindtype", String.valueOf(this.e)));
        try {
            return new UrlEncodedFormEntity(arrayList, "utf-8");
        } catch (UnsupportedEncodingException e3) {
            return null;
        }
    }

    public void a() {
        long f = g.f(this.d);
        if (g.b(this.d) != this.e || (g.g(this.d) && System.currentTimeMillis() - f > 259200000)) {
            g.a(this.d, 0);
            g.a(this.d, false);
            this.a = true;
            e();
        }
        if (!g.a(this.d)) {
            e();
        } else if (g.g(this.d)) {
        } else {
            a(this.d).b();
        }
    }

    public void b() {
        UrlEncodedFormEntity g = g();
        if (g != null) {
            new Thread(new a(this, b, g, 1), "registerUserInfo").start();
        }
    }

    public void c() {
        if (this.f != null) {
            this.d.unregisterReceiver(this.f);
        }
    }
}
