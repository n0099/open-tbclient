package com.baidu.android.defense.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    private static final String b = com.baidu.android.moplus.d.f251a + "/xcloudboss?r=push/register";
    private static d c = null;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f243a = true;
    private Context d;
    private int e;
    private BroadcastReceiver f;

    private d(Context context) {
        this.d = null;
        this.e = 1;
        this.f = null;
        this.d = context.getApplicationContext();
        if (b.k(this.d)) {
            this.e = 2;
        } else {
            this.e = 1;
        }
        this.f = new PushMsgReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.android.pushservice.action.internal.RECEIVE");
        intentFilter.addAction("com.baidu.pushservice.action.supper.MESSAGE");
        this.d.registerReceiver(this.f, intentFilter);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (c == null) {
                c = new d(context);
            }
            dVar = c;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ((jSONObject.has("status") ? jSONObject.getInt("status") : -1) == 0) {
                b.h(this.d);
            }
        } catch (JSONException e) {
        }
    }

    public static synchronized void e() {
        synchronized (d.class) {
            if (c != null) {
                c.d();
                c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (System.currentTimeMillis() - b.i(this.d) < 86400000) {
            return;
        }
        String c2 = b.c(this.d);
        if (TextUtils.isEmpty(c2)) {
            if (this.f243a) {
                this.f243a = false;
                b();
                return;
            }
            return;
        }
        Intent createMethodIntent = PushConstants.createMethodIntent(this.d);
        createMethodIntent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(c2));
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        createMethodIntent.putExtra(PushConstants.EXTRA_BIND_NAME, Build.MODEL);
        createMethodIntent.putExtra(PushConstants.EXTRA_BIND_STATUS, 0);
        if (this.e == 2) {
            createMethodIntent.putExtra("method_type", "internal");
        }
        this.d.sendBroadcast(createMethodIntent);
        b.j(this.d);
    }

    private UrlEncodedFormEntity g() {
        String str = "";
        String packageName = this.d.getPackageName();
        try {
            str = String.valueOf(this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String cuid = CommonParam.getCUID(this.d);
        String d = b.d(this.d);
        String e2 = b.e(this.d);
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        String valueOf2 = String.valueOf(displayMetrics.widthPixels);
        String valueOf3 = String.valueOf(displayMetrics.heightPixels);
        String valueOf4 = String.valueOf(displayMetrics.densityDpi);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(cuid)) {
            arrayList.add(new BasicNameValuePair("cuid", cuid));
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
            return new UrlEncodedFormEntity(arrayList, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e3) {
            return null;
        }
    }

    public void a() {
        long f = b.f(this.d);
        if (b.b(this.d) != this.e || (b.g(this.d) && System.currentTimeMillis() - f > 259200000)) {
            b.a(this.d, 0);
            b.a(this.d, false);
            this.f243a = true;
            f();
        }
        if (!b.a(this.d)) {
            f();
        } else if (b.g(this.d)) {
        } else {
            a(this.d).c();
        }
    }

    public void b() {
        UrlEncodedFormEntity urlEncodedFormEntity;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("grant_type", "client_credentials"));
        arrayList.add(new BasicNameValuePair("client_id", "Zq8wwbvNemxR4qGmWGhE6sva"));
        arrayList.add(new BasicNameValuePair("client_secret", "iq1WKpTUQYoplQqGUmu6iVtU0vkKN41I"));
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            urlEncodedFormEntity = null;
        }
        if (urlEncodedFormEntity != null) {
            new Thread(new e(this, "https://openapi.baidu.com/oauth/2.0/token", urlEncodedFormEntity, 0), "getAccessToken").start();
        }
    }

    public void c() {
        UrlEncodedFormEntity g = g();
        if (g != null) {
            new Thread(new e(this, b, g, 1), "registerUserInfo").start();
        }
    }

    public void d() {
        if (this.f != null) {
            this.d.unregisterReceiver(this.f);
        }
    }
}
