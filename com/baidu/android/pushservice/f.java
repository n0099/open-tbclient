package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.PushManager;
import com.baidu.android.pushservice.c.d;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.n;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    private static boolean l;
    public static int a = -1;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static String i = null;
    private static final ConcurrentLinkedQueue<Runnable> k = new ConcurrentLinkedQueue<>();
    public static Handler j = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public a(Context context) {
            super(context.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 65553 || f.j == null || f.k == null || f.k.isEmpty()) {
                return;
            }
            f.j.removeCallbacks((b) f.k.poll());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        private Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = null;
            if (com.baidu.android.pushservice.c.d.c(this.a)) {
                str = n.b(this.a);
            } else if (com.baidu.android.pushservice.c.d.d(this.a)) {
                str = n.a(this.a);
            } else if (com.baidu.android.pushservice.c.d.b(this.a)) {
                str = n.c(this.a);
            }
            if (TextUtils.isEmpty(str)) {
                f.p(this.a);
                if (f.k.isEmpty()) {
                    return;
                }
                f.k.poll();
            }
        }
    }

    public static Intent a(Context context) {
        if (l(context)) {
            return null;
        }
        int b2 = a != -1 ? a : m.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        String a2 = !TextUtils.isEmpty(b) ? b : m.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            k(context);
            return null;
        }
        Intent c2 = o.c(context);
        if (b2 == 0) {
            c2.putExtra("secret_key", a2);
            return c2;
        }
        return null;
    }

    public static Intent a(Context context, int i2) {
        Intent a2 = a(context);
        if (a2 == null) {
            return null;
        }
        a2.putExtra("method", PushConstants.METHOD_BIND);
        a2.putExtra("bind_status", i2);
        a2.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        a2.setFlags(a2.getFlags() | 32);
        if (Build.VERSION.SDK_INT >= 19) {
            a2.putExtra("bind_notify_status", l.a(context) + "");
            return a2;
        }
        return a2;
    }

    public static String a(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", str2);
        jSONObject.put("channel_id", str3);
        jSONObject.put("user_id", str4);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("request_id", str);
        jSONObject2.put("response_params", jSONObject);
        return jSONObject2.toString();
    }

    public static void a(final Context context, int i2, String str, boolean z) {
        if (l(context)) {
            return;
        }
        boolean g2 = com.baidu.android.pushservice.c.d.g(context);
        boolean b2 = b(context);
        com.baidu.android.pushservice.a.b(context, true);
        p.a(context, true, true);
        if (!g2) {
            com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c() { // from class: com.baidu.android.pushservice.f.1
                @Override // com.baidu.android.pushservice.i.c
                public void a() {
                    com.baidu.android.pushservice.d.d.a(context);
                }
            });
        }
        q(context);
        p.b("startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (z) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
            boolean z2 = sharedPreferences.getBoolean("bind_status", false);
            String string = sharedPreferences.getString("request_id", "");
            String string2 = sharedPreferences.getString("appid", "");
            String string3 = sharedPreferences.getString("channel_id", "");
            String string4 = sharedPreferences.getString("user_id", "");
            String str2 = null;
            try {
                str2 = a(string, string2, string3, string4);
            } catch (JSONException e2) {
                com.baidu.android.pushservice.g.a.b("PushManagerHandler", "error " + e2.getMessage(), context.getApplicationContext());
            }
            boolean a2 = a(context, i2, str);
            if (z2 && a2 && str2 != null && !b2) {
                Intent intent = new Intent();
                intent.putExtra("method", PushConstants.METHOD_BIND);
                intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
                intent.putExtra("content", str2.getBytes());
                intent.putExtra("bind_status", 0);
                com.baidu.android.pushservice.g.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:" + PushConstants.METHOD_BIND + " ,errorCode : 0 ,content : " + new String(str2), context.getApplicationContext());
                p.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
                if (com.baidu.android.pushservice.a.b() > 0) {
                    q.a(context, "039901", 1, str2);
                }
                r(context);
                return;
            }
        }
        b(context, i2, str);
        r(context);
    }

    public static void a(Context context, String str) {
        boolean z = true;
        try {
            if (j != null && !k.isEmpty()) {
                j.sendEmptyMessage(65553);
            } else if (!com.baidu.android.pushservice.c.d.e(context)) {
                return;
            }
            Intent a2 = a(context, 0);
            if (a2 == null) {
                return;
            }
            int b2 = com.baidu.android.pushservice.c.d.a(context).b();
            if (TextUtils.isEmpty(str)) {
                p(context);
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
            } else {
                z = false;
            }
            if (z) {
                jSONObject2.put(Constants.EXTRA_KEY_TOKEN, str);
                jSONObject.put(LoginActivityConfig.INFO, jSONObject2);
                n.a(context, b2, str);
            }
            a2.putExtra("push_proxy", jSONObject.toString());
            a(context, a2);
        } catch (Exception e2) {
            p(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, boolean z, int i2, long j2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit();
        edit.putString("base_url", str);
        edit.putBoolean("switch_enable", z);
        edit.putInt("sync_type", i2);
        edit.putLong("target_time", j2);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, final String str, final boolean z, final int i2, final PushManager.SyncCallback syncCallback) {
        final String s = s(context);
        if (!TextUtils.isEmpty(s)) {
            com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("uploadPushEnabledStatus", (short) 100) { // from class: com.baidu.android.pushservice.f.5
                @Override // com.baidu.android.pushservice.i.c
                public void a() {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("setting_type", 1);
                        jSONObject.put("msg_setting", z ? 1 : 0);
                        jSONObject.put("sys_default_setting", i2);
                        jSONArray.put(jSONObject);
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", com.baidu.android.pushservice.k.e.a(context));
                        hashMap.put("bccs_apikey", s);
                        hashMap.put("data", jSONArray.toString());
                        com.baidu.android.pushservice.f.a a2 = com.baidu.android.pushservice.f.b.a(str + "/boxmessage?type=message&action=setting", "POST", hashMap);
                        if (a2.b() != 200) {
                            if (syncCallback != null) {
                                syncCallback.onSyncResult(-1);
                                return;
                            }
                            return;
                        }
                        int i3 = new JSONObject(com.baidu.android.pushservice.h.a.b.a(a2.a())).getInt("errno");
                        if (syncCallback != null) {
                            syncCallback.onSyncResult(i3);
                        }
                        if (i3 == 0) {
                            f.t(context);
                        }
                    } catch (Exception e2) {
                        if (syncCallback != null) {
                            syncCallback.onSyncResult(-1);
                        }
                    }
                }
            });
        } else if (syncCallback != null) {
            syncCallback.onSyncResult(-1);
        }
    }

    public static void a(Context context, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(h)) {
            h = m.a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(i)) {
            i = m.a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
        }
        if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(i)) {
            p.a(applicationContext, h, i, new com.coloros.mcssdk.d.b() { // from class: com.baidu.android.pushservice.f.2
                @Override // com.coloros.mcssdk.d.b
                public void onGetAliases(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onGetNotificationStatus(int i2, int i3) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onGetPushStatus(int i2, int i3) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onGetTags(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onGetUserAccounts(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onRegister(int i2, String str) {
                    if (z) {
                        if (i2 != 0) {
                            f.p(applicationContext);
                        } else if (com.baidu.android.pushservice.c.d.e(applicationContext)) {
                            if (TextUtils.isEmpty(str)) {
                                f.p(applicationContext);
                            } else {
                                f.a(applicationContext, str);
                            }
                        }
                    }
                }

                @Override // com.coloros.mcssdk.d.b
                public void onSetAliases(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onSetPushTime(int i2, String str) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onSetTags(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onSetUserAccounts(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onUnRegister(int i2) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onUnsetAliases(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onUnsetTags(int i2, List<com.coloros.mcssdk.e.e> list) {
                }

                @Override // com.coloros.mcssdk.d.b
                public void onUnsetUserAccounts(int i2, List<com.coloros.mcssdk.e.e> list) {
                }
            });
        } else if (z) {
            k(applicationContext);
        }
    }

    public static boolean a(Context context, int i2, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        Long valueOf = Long.valueOf(sharedPreferences.getLong("currbindtime", 0L));
        String string = sharedPreferences.getString("access_token", "");
        String string2 = sharedPreferences.getString("secret_key", "");
        Long valueOf2 = Long.valueOf(sharedPreferences.getLong(com.baidu.ar.util.Constants.HTTP_VERSION_CODE, 0L));
        if (Long.valueOf(System.currentTimeMillis()).longValue() - valueOf.longValue() > 43200000) {
            sharedPreferences.edit().clear().commit();
            return false;
        }
        if (i2 == 1) {
            if (!str.equals(string)) {
                return false;
            }
        } else if (i2 == 0 && !str.equals(string2)) {
            return false;
        }
        return ((long) p.d(context, context.getPackageName())) == valueOf2.longValue();
    }

    public static boolean a(Context context, Intent intent) {
        return i.a(context).a(intent);
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || str2 == null) {
                return false;
            }
            String a2 = com.baidu.android.pushservice.k.f.a(p.a(p.B(context, context.getPackageName()).getBytes(), str2.getBytes()), false);
            byte[] a3 = com.baidu.android.pushservice.k.f.a(str);
            if (a3 != null) {
                String a4 = com.baidu.android.pushservice.k.f.a(BaiduAppSSOJni.decryptR(a3, 0), "", false);
                if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(a2)) {
                    return false;
                }
                return a2.equals(a4);
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.android.pushservice.f.4.a():void] */
    static /* synthetic */ boolean a(boolean z) {
        l = z;
        return z;
    }

    public static void b(Context context, int i2) {
        Intent a2 = a(context, i2);
        if (a2 == null) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
        a(context, a2);
        p.b("Bind by selfEventHandler", context);
    }

    public static void b(final Context context, final int i2, final String str) {
        com.baidu.android.pushservice.c.d.a(context.getApplicationContext()).a(new d.a() { // from class: com.baidu.android.pushservice.f.3
            @Override // com.baidu.android.pushservice.c.d.a
            public void a() {
                if (i2 == 0) {
                    m.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                    m.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
                }
                if (com.baidu.android.pushservice.c.d.d(context)) {
                    com.baidu.android.pushservice.a.b(context, false);
                    p.a(context, true, false);
                    f.e(context);
                } else if (com.baidu.android.pushservice.c.d.c(context)) {
                    com.baidu.android.pushservice.a.b(context, false);
                    p.a(context, true, false);
                    f.c(context);
                } else if (com.baidu.android.pushservice.c.d.b(context)) {
                    com.baidu.android.pushservice.a.b(context, false);
                    p.a(context, true, false);
                    f.d(context);
                } else if (com.baidu.android.pushservice.c.d.e(context) && com.baidu.android.pushservice.c.d.f(context)) {
                    com.baidu.android.pushservice.a.b(context, false);
                    p.a(context, true, false);
                    f.a(context, true);
                } else {
                    com.baidu.android.pushservice.g.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
                    if (i2 == 0) {
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            q.a(context, "039901", 2, str);
                        }
                        f.c(context, i2, str);
                        return;
                    }
                    com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        q.a(context, "039901", -1, "");
                    }
                }
            }
        });
    }

    public static void b(Context context, Intent intent) {
        if (a(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static boolean b(Context context) {
        int i2;
        try {
            if (p.E(context)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
                sharedPreferences.edit();
                i2 = sharedPreferences.getInt("version2", 0);
            } else {
                i2 = -1;
            }
            if (i2 == -1) {
                i2 = com.baidu.android.pushservice.d.c.c(context);
            }
            return i2 != com.baidu.android.pushservice.a.a();
        } catch (Exception e2) {
            return true;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || str2 == null) {
                return false;
            }
            String a2 = com.baidu.android.pushservice.k.f.a(p.a(p.B(context, context.getPackageName()).getBytes(), str2.getBytes()), false);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            return BaiduAppSSOJni.verify(a2.getBytes(), str, 0);
        } catch (Exception e2) {
            return false;
        }
    }

    public static String c(Context context, Intent intent) {
        String[] split;
        String[] split2;
        if (intent != null) {
            try {
                Uri data = intent.getData();
                String stringExtra = intent.getStringExtra("bdpush_hwsigninfo");
                if (!TextUtils.isEmpty(stringExtra) || data == null) {
                    return stringExtra;
                }
                String fragment = data.getFragment();
                if (TextUtils.isEmpty(fragment) || (split = fragment.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) == null || split.length <= 0) {
                    return stringExtra;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].contains("S.bdpush_hwsigninfo") && (split2 = split[i2].split("=")) != null && 1 < split2.length) {
                        return split2[1];
                    }
                }
                return stringExtra;
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    public static void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(d)) {
            d = m.a(applicationContext, "BD_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(e)) {
            e = m.a(applicationContext, "BD_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(d) || TextUtils.isEmpty(e)) {
            k(applicationContext);
            return;
        }
        p.d(applicationContext, d, e);
        o(applicationContext);
    }

    public static void c(Context context, int i2, String str) {
        p.b("startWork at time of " + System.currentTimeMillis(), context);
        o.a(context);
        b(context, 0);
    }

    public static String d(Context context, Intent intent) {
        int c2;
        String[] split;
        String[] split2;
        int i2 = 0;
        if (intent != null) {
            try {
                Uri data = intent.getData();
                String stringExtra = intent.getStringExtra("bdpush_hwsigninfo");
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
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    }
                    String uri = data.toString();
                    if (TextUtils.isEmpty(uri) || !uri.contains("#Intent;") || (c2 = p.c(uri)) <= 0) {
                        return null;
                    }
                    return stringExtra2 + uri.substring(0, c2);
                } else {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    public static void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f)) {
            f = m.a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(g)) {
            g = m.a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f) || TextUtils.isEmpty(g)) {
            k(applicationContext);
            return;
        }
        p.e(applicationContext, f, g);
        o(applicationContext);
    }

    public static void d(Context context, int i2, String str) {
        String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
        com.baidu.android.pushservice.g.a.b("PushManagerHandler", str2, context.getApplicationContext());
        if (context != null) {
            com.baidu.android.pushservice.d.c.a(context, 0L);
            if (p.E(context)) {
                SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
                edit.putLong("priority2", 0L);
                edit.commit();
            }
            SharedPreferences.Editor edit2 = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            edit2.putBoolean("bind_status", false);
            edit2.commit();
        }
        Intent intent = new Intent();
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i2);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        p.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
    }

    public static void e(Context context) {
        Context applicationContext = context.getApplicationContext();
        p.z(applicationContext);
        o(applicationContext);
    }

    public static void f(Context context) {
        Intent a2 = a(context);
        if (a2 == null) {
            return;
        }
        a2.putExtra("method", "method_unbind");
        b(context, a2);
    }

    public static void g(Context context) {
        Intent a2 = a(context);
        if (a2 == null) {
            return;
        }
        a2.putExtra("method", "method_unbind");
        a2.putExtra("should_notify_user", false);
        b(context, a2);
    }

    public static void h(Context context) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_RECEIVE);
        intent.putExtra("method", "method_unbind");
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
        intent.putExtra("content", PushConstants.a(0).getBytes());
        intent.setFlags(32);
        intent.setPackage(context.getPackageName());
        p.b(context, intent, intent.getAction(), context.getPackageName());
    }

    public static void i(Context context) {
        if (j == null || k.isEmpty()) {
            return;
        }
        j.sendEmptyMessage(65553);
        k(context);
    }

    public static void j(Context context) {
        i(context);
    }

    public static void k(Context context) {
        Intent intent = new Intent();
        String a2 = PushConstants.a(30602);
        intent.setAction(PushConstants.ACTION_RECEIVE);
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 30602);
        intent.putExtra("content", a2.getBytes());
        intent.setFlags(32);
        p.b(context, intent, intent.getAction(), context.getPackageName());
    }

    public static boolean l(Context context) {
        return context == null;
    }

    private static void o(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (k.size() > 100) {
            return;
        }
        b bVar = new b(applicationContext);
        k.add(bVar);
        if (j == null) {
            j = new a(applicationContext);
        }
        j.postDelayed(bVar, 9000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Context context) {
        try {
            com.baidu.android.pushservice.g.a.b("PushManagerHandler", "errorCode:10011", context.getApplicationContext());
            Intent intent = new Intent();
            intent.putExtra("method", PushConstants.METHOD_BIND);
            intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 10011);
            intent.putExtra("content", "errorCode:10011".getBytes());
            intent.putExtra("bind_status", 0);
            p.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
        } catch (Throwable th) {
        }
    }

    private static void q(final Context context) {
        if (l) {
            return;
        }
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("checkAppStatus", (short) 90) { // from class: com.baidu.android.pushservice.f.4
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                /*
                    r14 = this;
                    r0 = 1
                    com.baidu.android.pushservice.f.a(r0)
                    android.content.Context r0 = r3
                    java.lang.String r1 = "com.baidu.pushservice.app_stat"
                    r2 = 0
                    android.content.SharedPreferences r7 = r0.getSharedPreferences(r1, r2)
                    java.lang.String r0 = "last_save"
                    r2 = -1
                    long r0 = r7.getLong(r0, r2)
                    r2 = -1
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 != 0) goto L29
                    android.content.Context r0 = r3
                    java.util.List r0 = com.baidu.android.pushservice.j.p.m(r0)
                    android.content.Context r1 = r3
                    com.baidu.android.pushservice.j.m.a(r1, r0)
                L28:
                    return
                L29:
                    r2 = 86400000(0x5265c00, double:4.2687272E-316)
                    long r2 = r2 + r0
                    boolean r2 = android.text.format.DateUtils.isToday(r2)
                    if (r2 == 0) goto L1ac
                    android.content.Context r0 = r3
                    java.util.List r10 = com.baidu.android.pushservice.j.p.m(r0)
                    if (r10 == 0) goto L28
                    int r0 = r10.size()
                    r1 = 20
                    if (r0 > r1) goto L28
                    r8 = -1
                    java.util.Iterator r11 = r10.iterator()
                L49:
                    boolean r0 = r11.hasNext()
                    if (r0 == 0) goto L1c7
                    java.lang.Object r0 = r11.next()
                    r1 = r0
                    java.lang.String r1 = (java.lang.String) r1
                    r6 = 0
                    android.content.Context r0 = r3     // Catch: java.lang.Throwable -> L147
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L147
                    if (r0 == 0) goto L13c
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L147
                    r2.<init>()     // Catch: java.lang.Throwable -> L147
                    java.lang.String r3 = "content://"
                    java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L147
                    java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L147
                    java.lang.String r2 = ".bdpush"
                    java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L147
                    java.lang.String r2 = "/"
                    java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L147
                    java.lang.String r2 = "appstatus"
                    java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L147
                    java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L147
                    android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L147
                    com.baidu.android.pushservice.d.c$a r2 = com.baidu.android.pushservice.d.c.a.timeStamp     // Catch: java.lang.Throwable -> L147
                    java.lang.String r12 = r2.name()     // Catch: java.lang.Throwable -> L147
                    r2 = 0
                    r3 = 0
                    r4 = 0
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L147
                    r5.<init>()     // Catch: java.lang.Throwable -> L147
                    java.lang.StringBuilder r5 = r5.append(r12)     // Catch: java.lang.Throwable -> L147
                    java.lang.String r13 = " DESC"
                    java.lang.StringBuilder r5 = r5.append(r13)     // Catch: java.lang.Throwable -> L147
                    java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L147
                    android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L147
                    if (r0 == 0) goto L13d
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1c5
                    if (r1 == 0) goto L13d
                    int r1 = r0.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L1c5
                    long r2 = r0.getLong(r1)     // Catch: java.lang.Throwable -> L1c5
                    if (r0 == 0) goto Lc2
                    r0.close()     // Catch: java.lang.Exception -> L139
                Lc2:
                    r0 = r2
                Lc3:
                    r2 = -1
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 == 0) goto Lcf
                    boolean r0 = android.text.format.DateUtils.isToday(r0)
                    if (r0 != 0) goto L1a5
                Lcf:
                    java.lang.String r0 = "pkg_list"
                    java.lang.String r1 = ""
                    java.lang.String r0 = r7.getString(r0, r1)
                    boolean r1 = android.text.TextUtils.isEmpty(r0)
                    if (r1 != 0) goto L1a5
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    java.lang.String r3 = ":"
                    java.lang.String[] r0 = r0.split(r3)
                    java.util.List r0 = java.util.Arrays.asList(r0)
                    r2.<init>(r0)
                    java.util.ArrayList r3 = new java.util.ArrayList
                    r3.<init>(r2)
                    r3.retainAll(r10)
                    java.util.Iterator r4 = r3.iterator()
                L100:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L15a
                    java.lang.Object r0 = r4.next()
                    java.lang.String r0 = (java.lang.String) r0
                    java.lang.String r5 = ""
                    java.lang.String r5 = r7.getString(r0, r5)
                    boolean r6 = android.text.TextUtils.isEmpty(r5)
                    if (r6 != 0) goto L100
                    java.lang.String r6 = ":"
                    java.lang.String[] r5 = r5.split(r6)
                    com.baidu.android.pushservice.h.h r6 = new com.baidu.android.pushservice.h.h
                    r8 = 0
                    r8 = r5[r8]
                    java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                    int r8 = r8.intValue()
                    r9 = 1
                    r5 = r5[r9]
                    r9 = 1000(0x3e8, float:1.401E-42)
                    r6.<init>(r0, r8, r5, r9)
                    r1.add(r6)
                    goto L100
                L139:
                    r0 = move-exception
                    r0 = r2
                    goto Lc3
                L13c:
                    r0 = r6
                L13d:
                    if (r0 == 0) goto L49
                    r0.close()     // Catch: java.lang.Exception -> L144
                    goto L49
                L144:
                    r0 = move-exception
                    goto L49
                L147:
                    r0 = move-exception
                    r0 = r6
                L149:
                    if (r0 == 0) goto L49
                    r0.close()     // Catch: java.lang.Exception -> L150
                    goto L49
                L150:
                    r0 = move-exception
                    goto L49
                L153:
                    r0 = move-exception
                L154:
                    if (r6 == 0) goto L159
                    r6.close()     // Catch: java.lang.Exception -> L1bf
                L159:
                    throw r0
                L15a:
                    r2.removeAll(r3)
                    java.util.Iterator r2 = r2.iterator()
                L161:
                    boolean r0 = r2.hasNext()
                    if (r0 == 0) goto L1a0
                    java.lang.Object r0 = r2.next()
                    java.lang.String r0 = (java.lang.String) r0
                    boolean r3 = r10.contains(r0)
                    if (r3 != 0) goto L161
                    java.lang.String r3 = ""
                    java.lang.String r3 = r7.getString(r0, r3)
                    boolean r4 = android.text.TextUtils.isEmpty(r3)
                    if (r4 != 0) goto L161
                    java.lang.String r4 = ":"
                    java.lang.String[] r3 = r3.split(r4)
                    com.baidu.android.pushservice.h.h r4 = new com.baidu.android.pushservice.h.h
                    r5 = 0
                    r5 = r3[r5]
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    int r5 = r5.intValue()
                    r6 = 1
                    r3 = r3[r6]
                    r6 = 1001(0x3e9, float:1.403E-42)
                    r4.<init>(r0, r5, r3, r6)
                    r1.add(r4)
                    goto L161
                L1a0:
                    android.content.Context r0 = r3
                    com.baidu.android.pushservice.d.c.a(r0, r1)
                L1a5:
                    android.content.Context r0 = r3
                    com.baidu.android.pushservice.j.m.a(r0, r10)
                    goto L28
                L1ac:
                    boolean r0 = android.text.format.DateUtils.isToday(r0)
                    if (r0 != 0) goto L28
                    android.content.Context r0 = r3
                    java.util.List r0 = com.baidu.android.pushservice.j.p.m(r0)
                    android.content.Context r1 = r3
                    com.baidu.android.pushservice.j.m.a(r1, r0)
                    goto L28
                L1bf:
                    r1 = move-exception
                    goto L159
                L1c1:
                    r1 = move-exception
                    r6 = r0
                    r0 = r1
                    goto L154
                L1c5:
                    r1 = move-exception
                    goto L149
                L1c7:
                    r0 = r8
                    goto Lc3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.f.AnonymousClass4.a():void");
            }
        });
    }

    private static void r(Context context) {
        if (context.getPackageName().startsWith("com.baidu")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0);
            String string = sharedPreferences.getString("base_url", "");
            boolean z = sharedPreferences.getBoolean("switch_enable", true);
            int i2 = sharedPreferences.getInt("sync_type", 1);
            long j2 = sharedPreferences.getLong("target_time", 0L);
            if (TextUtils.isEmpty(string) || j2 == 0 || System.currentTimeMillis() < j2) {
                return;
            }
            a(context, string, z, i2, (PushManager.SyncCallback) null);
        }
    }

    private static String s(Context context) {
        return TextUtils.isEmpty(b) ? m.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE") : b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(Context context) {
        context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit().clear().apply();
    }
}
