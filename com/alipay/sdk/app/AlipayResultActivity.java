package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.util.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlipayResultActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f1733a = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a remove = f1733a.remove(str);
        if (remove == null) {
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(l.f1975b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            com.alipay.sdk.app.statistic.a.a("biz", "BSPReturned", "");
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("session");
            Bundle bundleExtra = intent.getBundleExtra("result");
            String stringExtra2 = intent.getStringExtra("scene");
            com.alipay.sdk.app.statistic.a.a("biz", "BSPSession", stringExtra);
            if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                a(stringExtra, bundleExtra);
                return;
            }
            if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                    jSONObject = jSONObject2.getJSONObject("result");
                    stringExtra = jSONObject2.getString("session");
                    com.alipay.sdk.app.statistic.a.a("biz", "BSPUriSession", stringExtra);
                    bundle2 = new Bundle();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle2.putString(next, jSONObject.getString(next));
                    }
                    bundleExtra = bundle2;
                } catch (Throwable th2) {
                    th = th2;
                    bundleExtra = bundle2;
                    com.alipay.sdk.app.statistic.a.a("biz", "BSPResEx", th);
                    com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.Z, th);
                    if (TextUtils.isEmpty(stringExtra)) {
                    }
                    com.alipay.sdk.app.statistic.a.b(this, "");
                    finish();
                }
            }
            if (TextUtils.isEmpty(stringExtra) && bundleExtra != null) {
                a(stringExtra, bundleExtra);
                com.alipay.sdk.app.statistic.a.b(this, "");
                finish();
                return;
            }
            com.alipay.sdk.app.statistic.a.b(this, "");
            finish();
        } catch (Throwable unused) {
            finish();
        }
    }
}
