package com.baidu.android.pushservice;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.SubscribeResult;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static Handler i;
    private static ConnectivityManager.NetworkCallback m;

    /* renamed from: a  reason: collision with root package name */
    public static int f1289a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f1290b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    private static final ConcurrentLinkedQueue<Runnable> j = new ConcurrentLinkedQueue<>();
    private static int k = 0;
    private static long l = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a(Context context) {
            super(context.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 65553 || f.i == null || f.j == null || f.j.isEmpty()) {
                return;
            }
            f.i.removeCallbacks((b) f.j.poll());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f1299a;

        public b(Context context) {
            this.f1299a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = null;
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.android.pushservice.i.j.a(this.f1299a);
            if (com.baidu.android.pushservice.b.d.k(this.f1299a)) {
                str = com.baidu.android.pushservice.i.j.c(this.f1299a);
                if (currentTimeMillis > -1702967296) {
                    str = "";
                }
            } else if (com.baidu.android.pushservice.b.d.l(this.f1299a)) {
                str = com.baidu.android.pushservice.i.j.b(this.f1299a);
                if (currentTimeMillis > 86400000) {
                    str = "";
                }
            } else if (com.baidu.android.pushservice.b.d.j(this.f1299a)) {
                str = com.baidu.android.pushservice.i.j.d(this.f1299a);
                if (currentTimeMillis > 172800000) {
                    str = "";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                f.a(this.f1299a, str);
                return;
            }
            if (!f.j.isEmpty()) {
                f.j.poll();
            }
            f.k(this.f1299a);
        }
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.ALARM");
        intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
        intent.setFlags(32);
        intent.setClass(context, PushServiceReceiver.class);
        return intent;
    }

    public static Intent a(Context context, int i2) {
        Intent c2 = c(context);
        if (c2 == null) {
            return null;
        }
        c2.putExtra("method", "method_bind");
        c2.putExtra("bind_status", i2);
        c2.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        c2.setFlags(c2.getFlags() | 32);
        if (Build.VERSION.SDK_INT >= 19) {
            c2.putExtra("bind_notify_status", com.baidu.android.pushservice.i.h.a(context) + "");
            return c2;
        }
        return c2;
    }

    public static void a(Context context, int i2, String str) {
        if (m(context)) {
            return;
        }
        com.baidu.android.pushservice.a.a(context, true);
        m.a(context, true, false);
        m.a("startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (o(context)) {
            m.a(context, true, true);
            String p = p(context);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra("error_msg", 0);
            intent.putExtra("content", p.getBytes());
            intent.putExtra("bind_status", 0);
            com.baidu.android.pushservice.f.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:method_bind ,errorCode : 0 ,content : " + p, context.getApplicationContext());
            m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
            u(context);
        } else {
            a(context, i2, str, false);
        }
        if (Build.VERSION.SDK_INT >= 24 && m.m(context, context.getPackageName()) >= 24) {
            t(context);
        }
        v(context);
    }

    public static void a(final Context context, final int i2, final String str, final boolean z) {
        int f2 = com.baidu.android.pushservice.b.d.g() ? com.baidu.android.pushservice.b.d.f() : 0;
        if (i == null) {
            i = new a(context);
        }
        i.postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.f.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.b.d.a(context.getApplicationContext()).a(new d.a() { // from class: com.baidu.android.pushservice.f.2.1
                    @Override // com.baidu.android.pushservice.b.d.a
                    public void a() {
                        if (i2 == 0) {
                            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
                        }
                        int unused = f.k = 0;
                        f.b(context, z, i2);
                    }
                });
            }
        }, f2 * 1000);
    }

    public static void a(Context context, String str) {
        boolean z = true;
        try {
            if (i != null && !j.isEmpty()) {
                i.sendEmptyMessage(65553);
            } else if (!com.baidu.android.pushservice.b.d.m(context) && !com.baidu.android.pushservice.b.d.n(context)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Intent a2 = a(context, 0);
            if (a2 == null) {
                return;
            }
            int b2 = com.baidu.android.pushservice.b.d.a(context).b();
            if (TextUtils.isEmpty(str)) {
                k(context);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (b2 == 5) {
                jSONObject2.put("platform", 0);
            } else if (b2 == 6) {
                jSONObject2.put("platform", 1);
            } else if (b2 == 7) {
                jSONObject2.put("platform", 3);
            } else if (b2 == 8) {
                jSONObject2.put("platform", 4);
            } else if (b2 == 9) {
                jSONObject2.put("platform", 5);
            } else {
                z = false;
            }
            if (z) {
                jSONObject2.put("token", str);
                jSONObject.put("info", jSONObject2);
                com.baidu.android.pushservice.i.j.a(context, b2, str);
            }
            a2.putExtra("push_proxy", jSONObject.toString());
            a(context, a2);
            com.baidu.android.pushservice.i.j.a(context, "need_retry_proxy_bind", false);
            new b.d(context.getApplicationContext()).a("bindForProxy").c(0L).d(501002L).b(currentTimeMillis).a(l).c(Build.FINGERPRINT).a();
        } catch (Exception e2) {
            k(context);
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    public static void a(Context context, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(g)) {
            g = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(h)) {
            h = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
        }
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(h)) {
            m.a(applicationContext, g, h, new PushCallback() { // from class: com.baidu.android.pushservice.f.1
                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onGetAliases(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onGetNotificationStatus(int i2, int i3) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onGetPushStatus(int i2, int i3) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onGetTags(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onGetUserAccounts(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onRegister(int i2, String str) {
                    if (z) {
                        if (i2 != 0) {
                            f.k(applicationContext);
                        } else if (TextUtils.isEmpty(str)) {
                            f.k(applicationContext);
                        } else {
                            f.a(applicationContext, str);
                        }
                    }
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onSetAliases(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onSetPushTime(int i2, String str) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onSetTags(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onSetUserAccounts(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onUnRegister(int i2) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onUnsetAliases(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onUnsetTags(int i2, List<SubscribeResult> list) {
                }

                @Override // com.heytap.mcssdk.callback.PushCallback
                public void onUnsetUserAccounts(int i2, List<SubscribeResult> list) {
                }
            });
        } else if (z) {
            l(applicationContext);
        }
    }

    public static boolean a(Context context, Intent intent) {
        return i.a(context).a(intent);
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                String n = m.n(context, context.getPackageName());
                if (n == null) {
                    return true;
                }
                String a2 = com.baidu.android.pushservice.i.f.a(m.a(n.getBytes(), str2.getBytes()), false);
                if (!TextUtils.isEmpty(a2)) {
                    if (k.a(a2.getBytes(), str, BaiduAppSSOJni.getPublicKey(3))) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        } catch (UnsatisfiedLinkError e3) {
            new b.c(context).a(Log.getStackTraceString(e3)).a();
            return true;
        }
        return false;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM");
        intent.setFlags(32);
        intent.setClass(context, PushServiceReceiver.class);
        return intent;
    }

    public static void b(Context context, int i2) {
        Intent a2 = a(context, i2);
        if (a2 == null) {
            return;
        }
        com.baidu.android.pushservice.f.a.a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
        a(context, a2);
        m.a("Bind by selfEventHandler", context);
    }

    public static void b(Context context, int i2, String str) {
        String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
        com.baidu.android.pushservice.f.a.b("PushManagerHandler", str2, context.getApplicationContext());
        com.baidu.android.pushservice.c.c.a(context, 0L);
        m.a(context, false);
        Intent intent = new Intent();
        intent.putExtra("method", "method_bind");
        intent.putExtra("error_msg", i2);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
    }

    public static void b(Context context, Intent intent) {
        if (a(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, boolean z, int i2) {
        boolean c2 = com.baidu.android.pushservice.b.d.c(context);
        l = System.currentTimeMillis();
        new b.d(context.getApplicationContext()).a("startBind").d(501005L).a(l).a();
        if (com.baidu.android.pushservice.b.d.l(context)) {
            if (!z) {
                m.a(context, true, false);
                if (!c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
            }
            f(context);
        } else if (com.baidu.android.pushservice.b.d.k(context)) {
            if (!z) {
                m.a(context, true, false);
                if (!c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
            }
            d(context);
        } else if (com.baidu.android.pushservice.b.d.m(context) && com.baidu.android.pushservice.b.d.p(context)) {
            if (!z) {
                m.a(context, true, false);
                if (!c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
            }
            a(context, true);
        } else if (com.baidu.android.pushservice.b.d.j(context)) {
            if (!z) {
                m.a(context, true, false);
                if (!c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
            }
            e(context);
        } else if (com.baidu.android.pushservice.b.d.o(context)) {
            m.b(context.getApplicationContext(), z);
        } else {
            com.baidu.android.pushservice.f.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
            if (i2 != 0) {
                com.baidu.android.pushservice.f.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                return;
            }
            m.a("startWork at time of " + System.currentTimeMillis(), context);
            b(context, 0);
        }
    }

    public static Intent c(Context context) {
        if (m(context)) {
            return null;
        }
        int b2 = f1289a != -1 ? f1289a : com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        String q = q(context);
        if (TextUtils.isEmpty(q)) {
            com.baidu.android.pushservice.f.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            l(context);
            return null;
        }
        Intent a2 = l.a(context);
        if (b2 == 0) {
            a2.putExtra("secret_key", q);
            return a2;
        }
        return null;
    }

    public static String c(Context context, Intent intent) {
        String[] split;
        if (intent != null) {
            try {
                Uri data = intent.getData();
                String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                if (!TextUtils.isEmpty(stringExtra) || data == null) {
                    return stringExtra;
                }
                String fragment = data.getFragment();
                if (TextUtils.isEmpty(fragment) || (split = fragment.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) == null || split.length <= 0) {
                    return stringExtra;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].startsWith("S.bdpush_hwprisigninfo")) {
                        return split[i2].substring("S.bdpush_hwprisigninfo".length() + 1);
                    }
                }
                return stringExtra;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return null;
    }

    public static String d(Context context, Intent intent) {
        int o;
        String[] split;
        String[] split2;
        int i2 = 0;
        if (intent != null) {
            try {
                Uri data = intent.getData();
                String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                String stringExtra2 = intent.getStringExtra("bdpush_hwmsgid");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    if (data != null) {
                        return stringExtra2 + data.toString();
                    }
                    return null;
                } else if (data != null) {
                    String fragment = data.getFragment();
                    if (!TextUtils.isEmpty(fragment) && (split = fragment.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length > 0) {
                        while (true) {
                            if (i2 < split.length) {
                                if (split[i2].contains("S.bdpush_hwmsgid") && (split2 = split[i2].split("=")) != null && 1 < split2.length) {
                                    stringExtra2 = split2[1];
                                    intent.putExtra("bdpush_hwmsgid", stringExtra2);
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    }
                    String uri = data.toString();
                    if (TextUtils.isEmpty(uri) || !uri.contains("#Intent;") || (o = m.o(context, uri)) <= 0) {
                        return null;
                    }
                    return stringExtra2 + uri.substring(0, o);
                } else {
                    return null;
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return null;
    }

    public static void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(c)) {
            c = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(d)) {
            d = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            l(applicationContext);
            return;
        }
        m.c(applicationContext, c, d);
        r(applicationContext);
    }

    public static void e(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(e)) {
            e = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(f)) {
            f = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(f)) {
            l(applicationContext);
            return;
        }
        m.d(applicationContext, e, f);
        r(applicationContext);
    }

    public static void f(Context context) {
        m.k(context);
        r(context);
    }

    public static void g(Context context) {
        Intent c2 = c(context);
        if (c2 == null) {
            return;
        }
        c2.putExtra("method", "method_unbind");
        b(context, c2);
        m.a(context, false);
    }

    public static void h(Context context) {
        String q = q(context);
        if (TextUtils.isEmpty(q)) {
            return;
        }
        a(context, 0, q, false);
    }

    public static void i(Context context) {
        if (i == null || j.isEmpty()) {
            return;
        }
        i.sendEmptyMessage(65553);
        l(context);
    }

    public static void j(Context context) {
        i(context);
    }

    public static void k(Context context) {
        Intent a2;
        try {
            if (s(context) || (a2 = a(context, 0)) == null) {
                return;
            }
            a2.putExtra("ignore_token", true);
            a(context, a2);
            com.baidu.android.pushservice.i.j.a(context, "need_retry_proxy_bind", true);
            new b.d(context.getApplicationContext()).a("bindForProxy").c(10011L).d(501002L).b(System.currentTimeMillis()).a(l).c(Build.FINGERPRINT).a();
        } catch (Throwable th) {
            new b.c(context).a(Log.getStackTraceString(th)).a();
        }
    }

    public static void l(Context context) {
        Intent intent = new Intent();
        String a2 = PushConstants.a(30602);
        intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
        intent.putExtra("method", "method_bind");
        intent.putExtra("error_msg", 30602);
        intent.putExtra("content", a2.getBytes());
        intent.setFlags(32);
        m.b(context, intent, intent.getAction(), context.getPackageName());
        new b.d(context.getApplicationContext()).a("bindForProxy").c(30602L).d(501002L).b(System.currentTimeMillis()).a(l).a();
    }

    public static boolean m(Context context) {
        return context == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static void n(Context context) {
        if (m != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(m);
                    m = null;
                }
            } catch (SecurityException e2) {
            }
        }
    }

    private static boolean o(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        if (sharedPreferences.getBoolean("bind_status", false)) {
            if (System.currentTimeMillis() - sharedPreferences.getLong("currbindtime", 0L) > com.baidu.android.pushservice.b.d.f(context) * SdkConfigData.DEFAULT_REQUEST_INTERVAL * 1000) {
                sharedPreferences.edit().clear().commit();
                return false;
            } else if (com.baidu.android.pushservice.i.j.b(context, "need_retry_proxy_bind", false)) {
                return false;
            } else {
                return ((long) m.c(context, context.getPackageName())) == sharedPreferences.getLong("version_code", 0L) && com.baidu.android.pushservice.c.c.b(context) == com.baidu.android.pushservice.a.a();
            }
        }
        return false;
    }

    private static String p(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
            String string = sharedPreferences.getString("request_id", "");
            String string2 = sharedPreferences.getString("appid", "");
            String string3 = sharedPreferences.getString(SharedPrefConfig.CHANNEL_ID, "");
            String string4 = sharedPreferences.getString("new_channel_id", "");
            String string5 = sharedPreferences.getString("user_id", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", string2);
            jSONObject.put(SharedPrefConfig.CHANNEL_ID, string3);
            if (!TextUtils.isEmpty(string4)) {
                jSONObject.put("new_channel_id", string4);
            }
            jSONObject.put("user_id", string5);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("request_id", string);
            jSONObject2.put("response_params", jSONObject);
            return jSONObject2.toString();
        } catch (Exception e2) {
            return "";
        }
    }

    private static String q(Context context) {
        return !TextUtils.isEmpty(f1290b) ? f1290b : com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
    }

    private static void r(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (j.size() > 100) {
            return;
        }
        b bVar = new b(applicationContext);
        j.add(bVar);
        if (i == null) {
            i = new a(applicationContext);
        }
        i.postDelayed(bVar, 6000L);
    }

    private static boolean s(Context context) {
        if (k >= 2 || TextUtils.isEmpty(f1290b)) {
            return false;
        }
        k++;
        b(context, true, f1289a);
        return true;
    }

    @TargetApi(24)
    private static void t(final Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                if (m == null) {
                    m = new ConnectivityManager.NetworkCallback() { // from class: com.baidu.android.pushservice.f.3
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            super.onAvailable(network);
                            l.b(context);
                        }
                    };
                    connectivityManager.registerDefaultNetworkCallback(m);
                }
            } catch (SecurityException e2) {
            }
        }
    }

    private static void u(final Context context) {
        List<String> i2 = com.baidu.android.pushservice.b.d.i(context);
        if (i2.isEmpty()) {
            return;
        }
        Handler handler = new Handler(context.getMainLooper());
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2.size()) {
                return;
            }
            final String str = i2.get(i4);
            if (m.b(context, str)) {
                handler.postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Intent intent = new Intent();
                            intent.setPackage(str);
                            intent.setClassName(str, "com.baidu.android.pushservice.PushService");
                            intent.putExtra("source", context.getPackageName());
                            context.startService(intent);
                            new b.d(context).d(501010L).a(System.currentTimeMillis()).c(str).a();
                        } catch (Exception e2) {
                        }
                    }
                }, (5 + i4) * 1000);
            }
            i3 = i4 + 1;
        }
    }

    private static void v(Context context) {
        if ((m.e() || m.g()) && m.p(context) && PushSettings.h(context) && TextUtils.isEmpty(com.baidu.android.pushservice.i.i.a(context, "notification_channel_id"))) {
            com.baidu.android.pushservice.i.h.a(context, "com.baidu.android.pushservice.push", "云推送");
        }
    }
}
