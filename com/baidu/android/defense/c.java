package com.baidu.android.defense;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.a.s;
import com.baidu.android.defense.pkgmanager.d;
import com.baidu.android.defense.push.j;
import com.baidu.android.defense.push.n;
import com.baidu.android.nebula.a.k;
import com.baidu.android.nebula.a.l;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private static c a = null;
    private Context b;
    private BroadcastReceiver c = null;

    private c(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c(context);
            }
            cVar = a;
        }
        return cVar;
    }

    public static synchronized void a() {
        synchronized (c.class) {
            if (a != null) {
                a.d();
                a = null;
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        a(context).a(intent);
    }

    private void b() {
        this.c = new a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_appinstall");
        if (this.c != null) {
            this.b.registerReceiver(this.c, intentFilter);
        }
        j.a(this.b).a();
        d.a(this.b);
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra("file_path");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        d.a(this.b).b(stringExtra, this.b);
    }

    private void c() {
        if (this.c != null) {
            this.b.unregisterReceiver(this.c);
        }
    }

    private void d() {
        c();
        j.d();
        d.b();
        com.baidu.android.defense.a.d.b();
    }

    public void a(Intent intent) {
        byte[] byteArrayExtra;
        n a2;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if ("action_appinstall".equals(action)) {
            b(intent);
        } else if ("com.baidu.android.pushservice.action.RECEIVE".equals(action) || "com.baidu.android.pushservice.action.sdk.RECEIVE".equals(action) || "com.baidu.android.pushservice.action.internal.RECEIVE".equals(action)) {
            String stringExtra = intent.getStringExtra("method");
            if ("method_bind".equals(stringExtra) || "method_sdk_bind".equals(stringExtra)) {
                j.a(this.b).a();
            }
        } else if ("com.baidu.android.pushservice.action.MESSAGE".equals(action) || "com.baidu.android.pushservice.action.SDK_MESSAGE".equals(action)) {
            if ("com.baidu.android.pushservice.action.MESSAGE".equals(action) || "com.baidu.android.pushservice.action.SDK_MESSAGE".equals(action)) {
                byteArrayExtra = intent.getByteArrayExtra("message");
            } else {
                String stringExtra2 = intent.getStringExtra("message");
                byteArrayExtra = stringExtra2 != null ? stringExtra2.getBytes() : null;
            }
            try {
                byteArrayExtra = l.b("0102030405060708", "moplus@appsearch", byteArrayExtra != null ? k.a(byteArrayExtra) : null);
            } catch (Exception e) {
            }
            if (byteArrayExtra != null) {
                try {
                    String str = new String(byteArrayExtra, "utf-8");
                    if (new JSONObject(str).getInt("message_type") == 1 && (a2 = com.baidu.android.defense.push.l.a(this.b).a(str)) != null) {
                        a2.b();
                    }
                    s.a(this.b).m();
                } catch (UnsupportedEncodingException e2) {
                } catch (JSONException e3) {
                }
            }
        }
    }
}
