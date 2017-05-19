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
import com.baidu.android.pushservice.config.ModeConfig;
import com.baidu.android.pushservice.f.p;
import com.baidu.android.pushservice.h.l;
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.h.n;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.t;
import com.baidu.android.pushservice.h.u;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static int a = -1;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    private static final ConcurrentLinkedQueue<Runnable> g = new ConcurrentLinkedQueue<>();
    public static Handler f = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public a(Context context) {
            super(context.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 65553 || f.f == null || f.g == null || f.g.isEmpty()) {
                return;
            }
            f.f.removeCallbacks((b) f.g.poll());
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
            if (ModeConfig.isXiaomiProxyMode(this.a)) {
                str = n.b(this.a);
            } else if (ModeConfig.isHuaweiProxyMode(this.a)) {
                str = n.a(this.a);
            }
            if (TextUtils.isEmpty(str)) {
                f.j(this.a);
                if (f.g == null || f.g.isEmpty()) {
                    return;
                }
                f.g.poll();
            }
        }
    }

    public static Intent a(Context context) {
        if (g(context)) {
            return null;
        }
        int b2 = a != -1 ? a : m.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        String a2 = !TextUtils.isEmpty(b) ? b : m.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.android.pushservice.e.b.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            f(context);
            return null;
        }
        Intent c2 = t.c(context);
        if (b2 == 0) {
            c2.putExtra("secret_key", a2);
            return c2;
        }
        return null;
    }

    public static Intent a(Context context, int i) {
        Intent a2 = a(context);
        if (a2 == null) {
            return null;
        }
        a2.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        a2.putExtra("bind_name", Build.MODEL);
        a2.putExtra("bind_status", i);
        a2.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        a2.setFlags(a2.getFlags() | 32);
        if (Build.VERSION.SDK_INT >= 19) {
            if (l.a(context)) {
                a2.putExtra("bind_notify_status", "1");
                return a2;
            }
            a2.putExtra("bind_notify_status", "0");
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

    public static void a(Context context, int i, String str, boolean z) {
        if (g(context)) {
            return;
        }
        if (ModeConfig.isProxyMode(context)) {
            u.z(context);
            u.A(context);
            com.baidu.android.pushservice.e.a.c("PushManagerHandler", "proxyMode, uploadPushAPPInfo & uploadPushLBSAPPListInfo");
        }
        boolean b2 = b(context);
        com.baidu.android.pushservice.a.b(context, true);
        u.a(context, true, true);
        u.b("startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
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
                com.baidu.android.pushservice.e.b.b("PushManagerHandler", "error " + e2.getMessage(), context.getApplicationContext());
            }
            boolean a2 = a(context, i, str);
            if (z2 && a2 && str2 != null && !b2) {
                Intent intent = new Intent();
                intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
                intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
                intent.putExtra("content", str2.getBytes());
                intent.putExtra("bind_status", 0);
                com.baidu.android.pushservice.e.b.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:" + PushConstants.METHOD_BIND + " ,errorCode : 0 ,content : " + new String(str2), context.getApplicationContext());
                u.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
                if (com.baidu.android.pushservice.a.b() > 0) {
                    p.a(context, "039901", 1, str2);
                    return;
                }
                return;
            }
        }
        b(context, i, str);
    }

    public static void a(Context context, String str) {
        try {
            if (f == null || g == null || g.isEmpty()) {
                return;
            }
            f.sendEmptyMessage(65553);
            Intent a2 = a(context, 0);
            if (a2 == null) {
                com.baidu.android.pushservice.e.a.e("PushManagerHandler", "bind for proxy err, intent is null !!!");
                return;
            }
            int currentMode = ModeConfig.getInstance(context).getCurrentMode();
            if (TextUtils.isEmpty(str)) {
                j(context);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (currentMode == ModeConfig.MODE_I_HW) {
                jSONObject2.put("huawei_token", str);
                jSONObject.put("huawei", jSONObject2);
                n.a(context, str);
            } else if (currentMode == ModeConfig.MODE_I_XM) {
                jSONObject2.put("regid", str);
                jSONObject.put("xiaomi", jSONObject2);
                n.b(context, str);
            }
            a2.putExtra("push_proxy", jSONObject.toString());
            a(context, a2);
        } catch (Exception e2) {
            j(context);
            com.baidu.android.pushservice.e.a.a("PushManagerHandler", e2);
        }
    }

    public static boolean a(Context context, int i, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        Long valueOf = Long.valueOf(sharedPreferences.getLong("currbindtime", 0L));
        String string = sharedPreferences.getString("access_token", "");
        String string2 = sharedPreferences.getString("secret_key", "");
        Long valueOf2 = Long.valueOf(sharedPreferences.getLong("version_code", 0L));
        if (Long.valueOf(System.currentTimeMillis()).longValue() - valueOf.longValue() > 43200000) {
            sharedPreferences.edit().clear().commit();
            return false;
        }
        if (i == 1) {
            if (!str.equals(string)) {
                return false;
            }
        } else if (i == 0 && !str.equals(string2)) {
            return false;
        }
        return ((long) u.d(context, context.getPackageName())) == valueOf2.longValue();
    }

    public static boolean a(Context context, Intent intent) {
        return i.a(context).a(intent);
    }

    public static boolean a(Context context, String str, String str2) {
        boolean z = false;
        try {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                String a2 = com.baidu.android.pushservice.i.f.a(u.a(u.B(context, context.getPackageName()).getBytes(), str2.getBytes()), false);
                com.baidu.android.pushservice.e.a.c("PushManagerHandler", "msg md5 = " + a2);
                byte[] a3 = com.baidu.android.pushservice.i.f.a(str);
                if (a3 != null) {
                    String a4 = com.baidu.android.pushservice.i.f.a(com.baidu.android.pushservice.i.g.a(a3, "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAtadv7/MPKp+9Djta\r/DIEt15755s3h1KYA4Lbej2GL2Mx0mdk4wzmjMCzfvNh+v4R7/mF8kfN8Kzowuaa\rFjAzfwIDAQABAkBVYQxguFoxi4DddpJuJMhIs3UDR9YSmYRvagrkapRuIqJmj3hO\rk+EsDQUtNA7JYJdiv/hrPrH0UACDV/Whb1MJAiEA8Rw37/dC157fsxasiTDz9bMQ\reAq9F8GudeH8oT5j8r0CIQDA30JBzOmu7CpPWbsTFh9YuL9wujJdiAdcBVHqmmfg\r6wIhAJbQIMkPr5axgJlDqH5TyXU5IScFCIwwkNCZn2y4Wso9AiBmMydhxJojFYNJ\r7stBTtynX6YZrqBXjWgQ68S/YrgepwIgdIQpvO4xNCT1j/mGIRcM/dqTGwiPOi/x\r/YLmfF2zQkM=\r"), "", false);
                    com.baidu.android.pushservice.e.a.c("PushManagerHandler", "sign md5 = " + a4);
                    if (u.A(context, a4)) {
                        com.baidu.android.pushservice.e.a.c("PushManagerHandler", "MD5 value = true");
                        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a2) && a2.equals(a4)) {
                            com.baidu.android.pushservice.e.a.c("PushManagerHandler", "MD5 value is equal");
                            z = true;
                        }
                    } else {
                        com.baidu.android.pushservice.e.a.c("PushManagerHandler", "MD5 value = false");
                    }
                }
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.a("PushManagerHandler", e2);
        }
        return z;
    }

    public static void b(Context context, int i) {
        Intent a2 = a(context, i);
        if (a2 == null) {
            return;
        }
        com.baidu.android.pushservice.e.b.a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
        a(context, a2);
        u.b("Bind by selfEventHandler", context);
    }

    public static void b(final Context context, final int i, final String str) {
        ModeConfig.getInstance(context.getApplicationContext()).updateConfig(new ModeConfig.a() { // from class: com.baidu.android.pushservice.f.1
            @Override // com.baidu.android.pushservice.config.ModeConfig.a
            public void a() {
                if (i == 0) {
                    m.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                    m.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
                }
                boolean isHuaweiProxyMode = ModeConfig.isHuaweiProxyMode(context);
                boolean isXiaomiProxyMode = ModeConfig.isXiaomiProxyMode(context);
                if (isHuaweiProxyMode) {
                    com.baidu.android.pushservice.e.a.c("PushManagerHandler", "****curMode == ModeConfig.MODE_I_HW****");
                    com.baidu.android.pushservice.a.b(context, false);
                    u.a(context, true, false);
                    f.d(context);
                } else if (isXiaomiProxyMode) {
                    com.baidu.android.pushservice.e.a.c("PushManagerHandler", "****curMode == ModeConfig.MODE_I_XM****");
                    com.baidu.android.pushservice.a.b(context, false);
                    u.a(context, true, false);
                    f.c(context);
                } else {
                    com.baidu.android.pushservice.e.b.a("PushManagerHandler", "login type = " + i, context.getApplicationContext());
                    if (i == 0) {
                        com.baidu.android.pushservice.e.a.c("PushManagerHandler", "loginType=" + i);
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            p.a(context, "039901", 2, str);
                        }
                        f.c(context, i, str);
                        return;
                    }
                    com.baidu.android.pushservice.e.b.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        p.a(context, "039901", -1, "");
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
        int i;
        try {
            if (u.D(context)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
                sharedPreferences.edit();
                i = sharedPreferences.getInt("version2", 0);
            } else {
                i = -1;
            }
            if (i == -1) {
                i = q.c(context);
            }
            return i != com.baidu.android.pushservice.a.a();
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.a("PushManagerHandler", e2);
            return true;
        }
    }

    public static String c(Context context, Intent intent) {
        String[] split;
        String[] split2;
        String str = null;
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
                for (int i = 0; i < split.length; i++) {
                    if (split[i].contains("S.bdpush_hwsigninfo") && (split2 = split[i].split("=")) != null && 1 < split2.length) {
                        str = split2[1];
                        com.baidu.android.pushservice.e.a.c("PushManagerHandler", "EMUI 4.0/3.1 hwsigninfo = " + str);
                        return str;
                    }
                }
                return stringExtra;
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.a("PushManagerHandler", e2);
                return str;
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
            f(applicationContext);
            return;
        }
        u.d(applicationContext, d, e);
        i(applicationContext);
    }

    public static void c(Context context, int i) {
        String str = "errorCode:" + i;
        com.baidu.android.pushservice.e.b.b("PushManagerHandler", str, context.getApplicationContext());
        if (context != null) {
            q.a(context, 0L);
            if (u.D(context)) {
                SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
                edit.putLong("priority2", 0L);
                edit.commit();
            }
            SharedPreferences.Editor edit2 = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            edit2.putBoolean("bind_status", false);
            edit2.commit();
        }
        Intent intent = new Intent();
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra("content", str.getBytes());
        intent.putExtra("bind_status", 0);
        com.baidu.android.pushservice.e.a.b("PushManagerHandler", "> sendResult to " + context.getPackageName() + " ,method:" + PushConstants.METHOD_BIND + " ,errorCode : " + i + " ,content : " + new String(str));
        u.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
    }

    public static void c(Context context, int i, String str) {
        u.b("startWork at time of " + System.currentTimeMillis(), context);
        t.a(context);
        b(context, 0);
    }

    public static String d(Context context, Intent intent) {
        int c2;
        String[] split;
        String[] split2;
        int i = 0;
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
                            if (i < split.length) {
                                if (split[i].contains("S.bdpush_hwmsgid") && (split2 = split[i].split("=")) != null && 1 < split2.length) {
                                    stringExtra2 = split2[1];
                                    com.baidu.android.pushservice.e.a.c("PushManagerHandler", "EMUI 4.0/3.1 hwmsgid = " + stringExtra2);
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                    String uri = data.toString();
                    if (TextUtils.isEmpty(uri) || !uri.contains("#Intent;") || (c2 = u.c(uri)) <= 0) {
                        return null;
                    }
                    String str = stringExtra2 + uri.substring(0, c2);
                    com.baidu.android.pushservice.e.a.c("PushManagerHandler", "EMUI 4.0/3.1 checkinfo = " + str);
                    return str;
                } else {
                    return null;
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.a("PushManagerHandler", e2);
                return null;
            }
        }
        return null;
    }

    public static void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        u.y(applicationContext);
        i(applicationContext);
    }

    public static void e(Context context) {
        Intent a2 = a(context);
        if (a2 == null) {
            return;
        }
        a2.putExtra(PushConstants.EXTRA_METHOD, "method_unbind");
        b(context, a2);
    }

    public static void f(Context context) {
        Intent intent = new Intent();
        String a2 = PushConstants.a(30602);
        intent.setAction(PushConstants.ACTION_RECEIVE);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 30602);
        intent.putExtra("content", a2.getBytes());
        intent.setFlags(32);
        u.b(context, intent, intent.getAction(), context.getPackageName());
    }

    public static boolean g(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushManagerHandler", "Context is null!");
            return true;
        }
        return false;
    }

    private static void i(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (g == null || g.size() > 100) {
            return;
        }
        b bVar = new b(applicationContext);
        g.add(bVar);
        if (f == null) {
            f = new a(applicationContext);
        }
        f.postDelayed(bVar, 9000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context) {
        com.baidu.android.pushservice.e.b.b("PushManagerHandler", "errorCode:10011", context.getApplicationContext());
        Intent intent = new Intent();
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 10011);
        intent.putExtra("content", "errorCode:10011".getBytes());
        intent.putExtra("bind_status", 0);
        com.baidu.android.pushservice.e.a.b("PushManagerHandler", "> sendResult to " + context.getPackageName() + ", method:" + PushConstants.METHOD_BIND + ", errorCode : 10011, content : errorCode:10011");
        u.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
    }
}
