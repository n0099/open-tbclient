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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    private static final String b = com.baidu.android.moplus.b.f635a + "/xcloudboss?r=push/register";
    private static j c = null;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f631a = true;
    private Context d;
    private int e;
    private BroadcastReceiver f;

    private j(Context context) {
        this.d = null;
        this.e = 1;
        this.f = null;
        this.d = context.getApplicationContext();
        if (l.k(this.d)) {
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
                l.h(this.d);
            }
        } catch (JSONException e) {
        }
    }

    public static synchronized void e() {
        synchronized (j.class) {
            if (c != null) {
                c.d();
                c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (System.currentTimeMillis() - l.i(this.d) < Util.MILLSECONDS_OF_DAY) {
            return;
        }
        String c2 = l.c(this.d);
        if (TextUtils.isEmpty(c2)) {
            if (this.f631a) {
                this.f631a = false;
                b();
                return;
            }
            return;
        }
        Intent createMethodIntent = PushConstants.createMethodIntent(this.d);
        createMethodIntent.putExtra("access_token", PushConstants.rsaEncrypt(c2));
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        createMethodIntent.putExtra(PushConstants.EXTRA_BIND_NAME, Build.MODEL);
        createMethodIntent.putExtra(PushConstants.EXTRA_BIND_STATUS, 0);
        if (this.e == 2) {
            createMethodIntent.putExtra("method_type", "internal");
        }
        this.d.sendBroadcast(createMethodIntent);
        l.j(this.d);
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
        String d = l.d(this.d);
        String e2 = l.e(this.d);
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        String valueOf2 = String.valueOf(displayMetrics.widthPixels);
        String valueOf3 = String.valueOf(displayMetrics.heightPixels);
        String valueOf4 = String.valueOf(displayMetrics.densityDpi);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(cuid)) {
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, cuid));
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
        long f = l.f(this.d);
        if (l.b(this.d) != this.e || (l.g(this.d) && System.currentTimeMillis() - f > 259200000)) {
            l.a(this.d, 0);
            l.a(this.d, false);
            this.f631a = true;
            f();
        }
        if (!l.a(this.d)) {
            f();
        } else if (l.g(this.d)) {
        } else {
            a(this.d).c();
        }
    }

    public void b() {
        UrlEncodedFormEntity urlEncodedFormEntity;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_GRANT_TYPE, "client_credentials"));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CLIENT_ID, "Zq8wwbvNemxR4qGmWGhE6sva"));
        arrayList.add(new BasicNameValuePair("client_secret", "iq1WKpTUQYoplQqGUmu6iVtU0vkKN41I"));
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            urlEncodedFormEntity = null;
        }
        if (urlEncodedFormEntity != null) {
            new Thread(new k(this, "https://openapi.baidu.com/oauth/2.0/token", urlEncodedFormEntity, 0), "getAccessToken").start();
        }
    }

    public void c() {
        UrlEncodedFormEntity g = g();
        if (g != null) {
            new Thread(new k(this, b, g, 1), "registerUserInfo").start();
        }
    }

    public void d() {
        if (this.f != null) {
            this.d.unregisterReceiver(this.f);
        }
    }
}
