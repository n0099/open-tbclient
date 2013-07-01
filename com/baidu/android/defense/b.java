package com.baidu.android.defense;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.android.defense.b.e;
import com.baidu.android.defense.push.d;
import com.baidu.android.defense.push.f;
import com.baidu.android.defense.push.i;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f234a = null;
    private Context b;
    private BroadcastReceiver c = null;

    private b(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f234a == null) {
                f234a = new b(context);
            }
            bVar = f234a;
        }
        return bVar;
    }

    public static synchronized void a() {
        synchronized (b.class) {
            if (f234a != null) {
                f234a.d();
                f234a = null;
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
        d.a(this.b).a();
        e.a(this.b);
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra("file_path");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        e.a(this.b).a(stringExtra, this.b);
    }

    private void c() {
        if (this.c != null) {
            this.b.unregisterReceiver(this.c);
        }
    }

    private void d() {
        c();
        d.e();
        e.b();
        com.baidu.android.defense.a.b.b();
    }

    public void a(Intent intent) {
        byte[] bytes;
        i a2;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if ("action_appinstall".equals(action)) {
            b(intent);
        } else if (PushConstants.ACTION_RECEIVE.equals(action) || "com.baidu.android.pushservice.action.internal.RECEIVE".equals(action)) {
            if (PushConstants.METHOD_BIND.equals(intent.getStringExtra(PushConstants.EXTRA_METHOD))) {
                d.a(this.b).a();
            }
        } else if (PushConstants.ACTION_MESSAGE.equals(action) || "com.baidu.pushservice.action.supper.MESSAGE".equals(action)) {
            if (PushConstants.ACTION_MESSAGE.equals(action)) {
                bytes = intent.getByteArrayExtra(PushConstants.EXTRA_PUSH_MESSAGE);
            } else {
                String stringExtra = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE);
                bytes = stringExtra != null ? stringExtra.getBytes() : null;
            }
            try {
                bytes = AESUtil.decrypt("0102030405060708", "moplus@appsearch", bytes != null ? Base64.decode(bytes) : null);
            } catch (Exception e) {
            }
            if (bytes != null) {
                try {
                    String str = new String(bytes, BdUtil.UTF8);
                    if (new JSONObject(str).getInt("message_type") != 1 || (a2 = f.a(this.b).a(str)) == null) {
                        return;
                    }
                    a2.b();
                } catch (UnsupportedEncodingException e2) {
                } catch (JSONException e3) {
                }
            }
        }
    }
}
