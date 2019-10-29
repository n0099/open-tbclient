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
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.i.j;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.coloros.mcssdk.callback.PushCallback;
import com.coloros.mcssdk.mode.SubscribeResult;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static Handler j;
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
    private static int l = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a(Context context) {
            super(context.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 65553 || e.j == null || e.k == null || e.k.isEmpty()) {
                return;
            }
            e.j.removeCallbacks((b) e.k.poll());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = null;
            long currentTimeMillis = System.currentTimeMillis() - j.a(this.a);
            if (com.baidu.android.pushservice.b.d.e(this.a)) {
                str = j.c(this.a);
                if (currentTimeMillis > -1702967296) {
                    str = "";
                }
            } else if (com.baidu.android.pushservice.b.d.f(this.a)) {
                str = j.b(this.a);
                if (currentTimeMillis > 86400000) {
                    str = "";
                }
            } else if (com.baidu.android.pushservice.b.d.d(this.a)) {
                str = j.d(this.a);
                if (currentTimeMillis > 172800000) {
                    str = "";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                e.a(this.a, str);
                return;
            }
            if (!e.k.isEmpty()) {
                e.k.poll();
            }
            e.i(this.a);
        }
    }

    public static Intent a(Context context) {
        if (k(context)) {
            return null;
        }
        int b2 = a != -1 ? a : com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        String a2 = !TextUtils.isEmpty(b) ? b : com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.android.pushservice.f.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            j(context);
            return null;
        }
        Intent c2 = k.c(context);
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
            a2.putExtra("bind_notify_status", com.baidu.android.pushservice.i.h.a(context) + "");
            return a2;
        }
        return a2;
    }

    public static String a(Intent intent) {
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
                return null;
            }
        }
        return null;
    }

    public static String a(String str, String str2, String str3, String str4, String str5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", str2);
        jSONObject.put("channel_id", str3);
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("new_channel_id", str4);
        }
        jSONObject.put("user_id", str5);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("request_id", str);
        jSONObject2.put("response_params", jSONObject);
        return jSONObject2.toString();
    }

    public static void a(final Context context, int i2, String str) {
        if (k(context)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        boolean z = sharedPreferences.getBoolean("bind_status", false);
        String string = sharedPreferences.getString("request_id", "");
        String string2 = sharedPreferences.getString("appid", "");
        String string3 = sharedPreferences.getString("channel_id", "");
        String string4 = sharedPreferences.getString("new_channel_id", "");
        String string5 = sharedPreferences.getString("user_id", "");
        boolean l2 = com.baidu.android.pushservice.b.d.l(context);
        boolean k2 = com.baidu.android.pushservice.b.d.k(context);
        boolean c2 = com.baidu.android.pushservice.b.d.c(context);
        com.baidu.android.pushservice.a.b(context, true);
        if (!l2) {
            l.a(context, true, true);
        } else if (!k2 || c2) {
            l.a(context, true, z);
        } else {
            l.a(context, true, false);
        }
        if (!k2) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("getMsgInfo", (short) 99) { // from class: com.baidu.android.pushservice.e.1
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    com.baidu.android.pushservice.c.d.a(context);
                }
            });
        }
        l.b("startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        String str2 = null;
        try {
            str2 = a(string, string2, string3, string4, string5);
        } catch (JSONException e2) {
            com.baidu.android.pushservice.f.a.b("PushManagerHandler", "error " + e2.getMessage(), context.getApplicationContext());
        }
        boolean b2 = b(context);
        boolean c3 = c(context, i2, str);
        if (!z || !c3 || str2 == null || b2) {
            a(context, i2, str, false);
            o(context);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        com.baidu.android.pushservice.f.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:" + PushConstants.METHOD_BIND + " ,errorCode : 0 ,content : " + str2, context.getApplicationContext());
        l.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
        o(context);
    }

    public static void a(final Context context, final int i2, final String str, final boolean z) {
        com.baidu.android.pushservice.b.d.a(context.getApplicationContext()).a(new d.a() { // from class: com.baidu.android.pushservice.e.3
            @Override // com.baidu.android.pushservice.b.d.a
            public void a() {
                if (i2 == 0) {
                    com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                    com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
                }
                int unused = e.l = 0;
                e.b(context, z, i2);
            }
        });
    }

    public static void a(Context context, String str) {
        boolean z = true;
        try {
            if (j != null && !k.isEmpty()) {
                j.sendEmptyMessage(65553);
            } else if (!com.baidu.android.pushservice.b.d.g(context) && !com.baidu.android.pushservice.b.d.h(context)) {
                return;
            }
            Intent a2 = a(context, 0);
            if (a2 == null) {
                return;
            }
            int b2 = com.baidu.android.pushservice.b.d.a(context).b();
            if (TextUtils.isEmpty(str)) {
                i(context);
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
                jSONObject.put(Config.LAUNCH_INFO, jSONObject2);
                j.a(context, b2, str);
            }
            a2.putExtra("push_proxy", jSONObject.toString());
            a(context, a2);
        } catch (Exception e2) {
            i(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, boolean z, int i2, long j2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit();
        edit.putString("base_url", str);
        edit.putBoolean("switch_enable", z);
        edit.putInt(IMConstants.SYNC_TYPE, i2);
        edit.putLong("target_time", j2);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, final String str, final boolean z, final int i2, final PushManager.SyncCallback syncCallback) {
        final String p = p(context);
        if (!TextUtils.isEmpty(p)) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("uploadPushEnabledStatus", (short) 100) { // from class: com.baidu.android.pushservice.e.4
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("setting_type", 1);
                        jSONObject.put("msg_setting", z ? 1 : 0);
                        jSONObject.put("sys_default_setting", i2);
                        jSONArray.put(jSONObject);
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", DeviceId.getCUID(context));
                        hashMap.put("bccs_apikey", p);
                        hashMap.put("data", jSONArray.toString());
                        com.baidu.android.pushservice.e.a a2 = com.baidu.android.pushservice.e.b.a(str + "/boxmessage?type=message&action=setting", "POST", hashMap);
                        if (a2.b() != 200) {
                            if (syncCallback != null) {
                                syncCallback.onSyncResult(-1);
                                return;
                            }
                            return;
                        }
                        int i3 = new JSONObject(com.baidu.android.pushservice.g.a.b.a(a2.a())).getInt("errno");
                        if (syncCallback != null) {
                            syncCallback.onSyncResult(i3);
                        }
                        if (i3 == 0) {
                            e.q(context);
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
            h = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(i)) {
            i = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
        }
        if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(i)) {
            l.a(applicationContext, h, i, new PushCallback() { // from class: com.baidu.android.pushservice.e.2
                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onGetAliases(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onGetNotificationStatus(int i2, int i3) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onGetPushStatus(int i2, int i3) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onGetTags(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onGetUserAccounts(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onRegister(int i2, String str) {
                    if (z) {
                        if (i2 != 0) {
                            e.i(applicationContext);
                        } else if (TextUtils.isEmpty(str)) {
                            e.i(applicationContext);
                        } else {
                            e.a(applicationContext, str);
                        }
                    }
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onSetAliases(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onSetPushTime(int i2, String str) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onSetTags(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onSetUserAccounts(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onUnRegister(int i2) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onUnsetAliases(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onUnsetTags(int i2, List<SubscribeResult> list) {
                }

                @Override // com.coloros.mcssdk.callback.PushCallback
                public void onUnsetUserAccounts(int i2, List<SubscribeResult> list) {
                }
            });
        } else if (z) {
            j(applicationContext);
        }
    }

    public static boolean a(Context context, Intent intent) {
        return h.a(context).a(intent);
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                String B = l.B(context, context.getPackageName());
                if (B == null) {
                    return true;
                }
                String a2 = com.baidu.android.pushservice.j.d.a(l.a(B.getBytes(), str2.getBytes()), false);
                if (!TextUtils.isEmpty(a2)) {
                    if (BaiduAppSSOJni.verify(a2.getBytes(), str, 0)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
        } catch (UnsatisfiedLinkError e3) {
            return true;
        }
        return false;
    }

    public static String b(Intent intent) {
        int b2;
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
                    if (TextUtils.isEmpty(uri) || !uri.contains("#Intent;") || (b2 = l.b(uri)) <= 0) {
                        return null;
                    }
                    return stringExtra2 + uri.substring(0, b2);
                } else {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    public static void b(Context context, int i2) {
        Intent a2 = a(context, i2);
        if (a2 == null) {
            return;
        }
        com.baidu.android.pushservice.f.a.a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
        a(context, a2);
        l.b("Bind by selfEventHandler", context);
    }

    public static void b(Context context, int i2, String str) {
        String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
        com.baidu.android.pushservice.f.a.b("PushManagerHandler", str2, context.getApplicationContext());
        com.baidu.android.pushservice.c.c.a(context, 0L);
        if (l.C(context)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
            edit.putLong("priority2", 0L);
            edit.commit();
        }
        SharedPreferences.Editor edit2 = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
        edit2.putBoolean("bind_status", false);
        edit2.commit();
        Intent intent = new Intent();
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i2);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        l.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
    }

    public static void b(Context context, Intent intent) {
        if (a(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static void b(Context context, boolean z) {
        l.b("startWork at time of " + System.currentTimeMillis(), context);
        if (!z) {
            if (com.baidu.android.pushservice.b.d.l(context)) {
                l.a(context, true, true);
            } else {
                k.a(context);
            }
        }
        b(context, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, boolean z, int i2) {
        boolean c2 = com.baidu.android.pushservice.b.d.c(context);
        if (com.baidu.android.pushservice.b.d.f(context)) {
            if (!z) {
                if (c2) {
                    l.a(context, true, true);
                } else {
                    com.baidu.android.pushservice.a.b(context, false);
                    l.a(context, true, false);
                }
            }
            e(context);
        } else if (com.baidu.android.pushservice.b.d.e(context)) {
            if (!z) {
                if (c2) {
                    l.a(context, true, true);
                } else {
                    com.baidu.android.pushservice.a.b(context, false);
                    l.a(context, true, false);
                }
            }
            c(context);
        } else if (com.baidu.android.pushservice.b.d.g(context) && com.baidu.android.pushservice.b.d.j(context)) {
            if (!z) {
                if (c2) {
                    l.a(context, true, true);
                } else {
                    com.baidu.android.pushservice.a.b(context, false);
                    l.a(context, true, false);
                }
            }
            a(context, true);
        } else if (com.baidu.android.pushservice.b.d.d(context)) {
            if (!z) {
                if (c2) {
                    l.a(context, true, true);
                } else {
                    com.baidu.android.pushservice.a.b(context, false);
                    l.a(context, true, false);
                }
            }
            d(context);
        } else if (com.baidu.android.pushservice.b.d.i(context)) {
            l.a(context.getApplicationContext(), z);
        } else {
            com.baidu.android.pushservice.f.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
            if (i2 != 0) {
                com.baidu.android.pushservice.f.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
            } else {
                b(context, z);
            }
        }
    }

    public static boolean b(Context context) {
        int i2;
        try {
            if (l.C(context)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
                sharedPreferences.edit();
                i2 = sharedPreferences.getInt("version2", 0);
            } else {
                i2 = -1;
            }
            if (i2 == -1) {
                i2 = com.baidu.android.pushservice.c.c.c(context);
            }
            return i2 != com.baidu.android.pushservice.a.a();
        } catch (Exception e2) {
            return true;
        }
    }

    public static void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(d)) {
            d = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(e)) {
            e = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(d) || TextUtils.isEmpty(e)) {
            j(applicationContext);
            return;
        }
        l.d(applicationContext, d, e);
        m(applicationContext);
    }

    private static boolean c(Context context, int i2, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        Long valueOf = Long.valueOf(sharedPreferences.getLong("currbindtime", 0L));
        String string = sharedPreferences.getString("secret_key", "");
        Long valueOf2 = Long.valueOf(sharedPreferences.getLong("version_code", 0L));
        if (Long.valueOf(System.currentTimeMillis()).longValue() - valueOf.longValue() <= 43200000) {
            return i2 == 0 && str.equals(string) && ((long) l.d(context, context.getPackageName())) == valueOf2.longValue();
        }
        sharedPreferences.edit().clear().commit();
        return false;
    }

    public static void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f)) {
            f = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(g)) {
            g = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f) || TextUtils.isEmpty(g)) {
            j(applicationContext);
            return;
        }
        l.e(applicationContext, f, g);
        m(applicationContext);
    }

    public static void e(Context context) {
        l.z(context);
        m(context);
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
        if (j == null || k.isEmpty()) {
            return;
        }
        j.sendEmptyMessage(65553);
        j(context);
    }

    public static void h(Context context) {
        g(context);
    }

    public static void i(Context context) {
        try {
            if (n(context)) {
                return;
            }
            com.baidu.android.pushservice.f.a.b("PushManagerHandler", "errorCode:10011", context.getApplicationContext());
            Intent intent = new Intent();
            intent.putExtra("method", PushConstants.METHOD_BIND);
            intent.putExtra(PushConstants.EXTRA_ERROR_CODE, CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE);
            intent.putExtra("content", "errorCode:10011".getBytes());
            intent.putExtra("bind_status", 0);
            l.b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
        } catch (Throwable th) {
        }
    }

    public static void j(Context context) {
        Intent intent = new Intent();
        String a2 = PushConstants.a(30602);
        intent.setAction(PushConstants.ACTION_RECEIVE);
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 30602);
        intent.putExtra("content", a2.getBytes());
        intent.setFlags(32);
        l.b(context, intent, intent.getAction(), context.getPackageName());
    }

    public static boolean k(Context context) {
        return context == null;
    }

    private static void m(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (k.size() > 100) {
            return;
        }
        b bVar = new b(applicationContext);
        k.add(bVar);
        if (j == null) {
            j = new a(applicationContext);
        }
        j.postDelayed(bVar, 6000L);
    }

    private static boolean n(Context context) {
        if (l >= 3 || TextUtils.isEmpty(b)) {
            return false;
        }
        l++;
        b(context, true, a);
        return true;
    }

    private static void o(Context context) {
        if (context.getPackageName().startsWith("com.baidu")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0);
            String string = sharedPreferences.getString("base_url", "");
            boolean z = sharedPreferences.getBoolean("switch_enable", true);
            int i2 = sharedPreferences.getInt(IMConstants.SYNC_TYPE, 1);
            long j2 = sharedPreferences.getLong("target_time", 0L);
            if (TextUtils.isEmpty(string) || j2 == 0 || System.currentTimeMillis() < j2) {
                return;
            }
            a(context, string, z, i2, (PushManager.SyncCallback) null);
        }
    }

    private static String p(Context context) {
        return TextUtils.isEmpty(b) ? com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE") : b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Context context) {
        context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit().clear().apply();
    }
}
