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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.SubscribeResult;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f3061a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f3062b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3063c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3064d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3065e;

    /* renamed from: f  reason: collision with root package name */
    public static String f3066f;

    /* renamed from: g  reason: collision with root package name */
    public static String f3067g;

    /* renamed from: h  reason: collision with root package name */
    public static String f3068h;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f3069i;
    public static final ConcurrentLinkedQueue<Runnable> j = new ConcurrentLinkedQueue<>();
    public static int k = 0;
    public static long l = 0;
    public static ConnectivityManager.NetworkCallback m;

    /* loaded from: classes.dex */
    public static class a extends Handler {
        public a(Context context) {
            super(context.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 65553 || f.f3069i == null || f.j == null || f.j.isEmpty()) {
                return;
            }
            f.f3069i.removeCallbacks((b) f.j.poll());
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f3080a;

        public b(Context context) {
            this.f3080a = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            if (r0 > 86400000) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
            if (r0 > 172800000) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
            if (r0 > com.baidu.tbadk.core.util.StorageFile.MAX_BUBBULE_CACHE_TIME) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
            r3 = r2;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String d2;
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.android.pushservice.j.j.a(this.f3080a);
            String str = "";
            if (com.baidu.android.pushservice.b.d.k(this.f3080a)) {
                d2 = com.baidu.android.pushservice.j.j.c(this.f3080a);
            } else if (com.baidu.android.pushservice.b.d.l(this.f3080a)) {
                d2 = com.baidu.android.pushservice.j.j.b(this.f3080a);
            } else if (com.baidu.android.pushservice.b.d.j(this.f3080a)) {
                d2 = com.baidu.android.pushservice.j.j.d(this.f3080a);
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                f.a(this.f3080a, str);
                return;
            }
            if (!f.j.isEmpty()) {
                f.j.poll();
            }
            f.k(this.f3080a);
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
            int b2 = com.baidu.android.pushservice.j.h.b(context);
            c2.putExtra("bind_notify_status", b2 + "");
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
            com.baidu.android.pushservice.g.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:method_bind ,errorCode : 0 ,content : " + p, context.getApplicationContext());
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
        if (f3069i == null) {
            f3069i = new a(context);
        }
        f3069i.postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.f.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.b.d.a(context.getApplicationContext()).a(str, new d.a() { // from class: com.baidu.android.pushservice.f.2.1
                    @Override // com.baidu.android.pushservice.b.d.a
                    public void a() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (i2 == 0) {
                            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
                        }
                        int unused = f.k = 0;
                        j.f3443a = false;
                        AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                        f.b(context, z, i2);
                    }
                });
            }
        }, f2 * 1000);
    }

    public static void a(Context context, String str) {
        try {
            if (f3069i != null && !j.isEmpty()) {
                f3069i.sendEmptyMessage(65553);
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
            boolean z = true;
            if (b2 == 5) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 0);
            } else if (b2 == 6) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 1);
            } else if (b2 == 7) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 3);
            } else if (b2 == 8) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 4);
            } else if (b2 == 9) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 5);
            } else {
                z = false;
            }
            if (z) {
                jSONObject2.put("token", str);
                jSONObject.put("info", jSONObject2);
                com.baidu.android.pushservice.j.j.a(context, b2, str);
            }
            a2.putExtra("push_proxy", jSONObject.toString());
            if (j.f3443a) {
                j.a(context).a(jSONObject.toString());
            } else {
                a(context, a2);
            }
            com.baidu.android.pushservice.j.j.a(context, "need_retry_proxy_bind", false);
            new b.d(context.getApplicationContext()).a("bindForProxy").c(0L).d(501002L).b(currentTimeMillis).a(l).c(Build.FINGERPRINT).a();
        } catch (Exception e2) {
            k(context);
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    public static void a(Context context, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f3067g)) {
            f3067g = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f3068h)) {
            f3068h = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
        }
        if (!TextUtils.isEmpty(f3067g) && !TextUtils.isEmpty(f3068h)) {
            m.a(applicationContext, f3067g, f3068h, new PushCallback() { // from class: com.baidu.android.pushservice.f.1
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
                        if (i2 != 0 || TextUtils.isEmpty(str)) {
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

    public static boolean a(Context context, UploadDataListener uploadDataListener) {
        if (uploadDataListener == null) {
            return false;
        }
        if (context == null) {
            uploadDataListener.onResult(30602);
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                String n = m.n(context, context.getPackageName());
                if (n != null) {
                    String a2 = com.baidu.android.pushservice.j.f.a(m.a(n.getBytes(), str2.getBytes()), false);
                    if (!TextUtils.isEmpty(a2)) {
                        if (com.baidu.android.pushservice.j.k.a(a2.getBytes(), str, BaiduAppSSOJni.getPublicKey(3))) {
                        }
                    }
                }
                return true;
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
        com.baidu.android.pushservice.g.a.a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
        a(context, a2);
        m.a("Bind by selfEventHandler", context);
    }

    public static void b(Context context, int i2, String str) {
        j.f3443a = true;
        if (i2 == 0) {
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        }
        b(context, true, i2);
    }

    public static void b(Context context, Intent intent) {
        if (a(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static void b(Context context, boolean z, int i2) {
        boolean c2 = com.baidu.android.pushservice.b.d.c(context);
        l = System.currentTimeMillis();
        new b.d(context.getApplicationContext()).a("startBind").d(501005L).a(l).a();
        if (com.baidu.android.pushservice.b.d.l(context)) {
            if (!z && !c2) {
                com.baidu.android.pushservice.a.a(context, false);
            }
            f(context);
        } else if (com.baidu.android.pushservice.b.d.k(context)) {
            if (!z && !c2) {
                com.baidu.android.pushservice.a.a(context, false);
            }
            d(context);
        } else if (com.baidu.android.pushservice.b.d.m(context) && com.baidu.android.pushservice.b.d.p(context)) {
            if (!z && !c2) {
                com.baidu.android.pushservice.a.a(context, false);
            }
            a(context, true);
        } else if (com.baidu.android.pushservice.b.d.j(context)) {
            if (!z && !c2) {
                com.baidu.android.pushservice.a.a(context, false);
            }
            e(context);
        } else if (com.baidu.android.pushservice.b.d.o(context)) {
            m.b(context.getApplicationContext(), z);
        } else {
            com.baidu.android.pushservice.g.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
            if (i2 != 0) {
                com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                return;
            }
            m.a("startWork at time of " + System.currentTimeMillis(), context);
            if (j.f3443a) {
                j.a(context).a("");
            } else {
                b(context, 0);
            }
        }
    }

    public static Intent c(Context context) {
        if (m(context)) {
            return null;
        }
        int i2 = f3061a;
        if (i2 == -1) {
            i2 = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        }
        String q = q(context);
        if (TextUtils.isEmpty(q)) {
            com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            l(context);
            return null;
        }
        Intent a2 = l.a(context);
        if (i2 == 0) {
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
                if (TextUtils.isEmpty(fragment) || (split = fragment.split(";")) == null || split.length <= 0) {
                    return stringExtra;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].startsWith("S.bdpush_hwprisigninfo")) {
                        return split[i2].substring(23);
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

    public static void c(Context context, int i2, String str) {
        String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
        com.baidu.android.pushservice.g.a.b("PushManagerHandler", str2, context.getApplicationContext());
        com.baidu.android.pushservice.c.c.a(context, 0L);
        m.a(context, false);
        Intent intent = new Intent();
        intent.putExtra("method", "method_bind");
        intent.putExtra("error_msg", i2);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r3 = r2.getFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        r3 = r3.split(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r3 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r3.length <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r5 >= r3.length) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r3[r5].contains("S.bdpush_hwmsgid") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        r7 = r3[r5].split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        if (r7 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
        if (1 >= r7.length) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
        r4 = r7[1];
        r11.putExtra("bdpush_hwmsgid", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        r11 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        if (android.text.TextUtils.isEmpty(r11) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        if (r11.contains("#Intent;") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        r0 = com.baidu.android.pushservice.j.m.o(r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008a, code lost:
        if (r0 <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        return r4 + r11.substring(0, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context, Intent intent) {
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
                }
                return null;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return null;
    }

    public static void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f3063c)) {
            f3063c = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(f3064d)) {
            f3064d = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f3063c) || TextUtils.isEmpty(f3064d)) {
            l(applicationContext);
            return;
        }
        m.c(applicationContext, f3063c, f3064d);
        r(applicationContext);
    }

    public static void e(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f3065e)) {
            f3065e = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(f3066f)) {
            f3066f = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f3065e) || TextUtils.isEmpty(f3066f)) {
            l(applicationContext);
            return;
        }
        m.d(applicationContext, f3065e, f3066f);
        r(applicationContext);
    }

    public static void f(Context context) {
        m.j(context);
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
        if (f3069i == null || j.isEmpty()) {
            return;
        }
        f3069i.sendEmptyMessage(65553);
        l(context);
    }

    public static void j(Context context) {
        i(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: all -> 0x00aa, TryCatch #0 {all -> 0x00aa, blocks: (B:2:0x0000, B:4:0x0006, B:7:0x001d, B:22:0x0043, B:23:0x004f, B:10:0x0024, B:13:0x002b, B:16:0x0034, B:19:0x003d, B:25:0x005b, B:28:0x0062, B:31:0x0069), top: B:36:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(Context context) {
        Intent a2;
        try {
            boolean z = false;
            if (!j.f3443a) {
                if (s(context) || (a2 = a(context, 0)) == null) {
                    return;
                }
                a2.putExtra("ignore_token", true);
                a(context, a2);
                com.baidu.android.pushservice.j.j.a(context, "need_retry_proxy_bind", true);
                new b.d(context.getApplicationContext()).a("bindForProxy").c(LightappBusinessClient.SVC_ID_H5_QRGEN).d(501002L).b(System.currentTimeMillis()).a(l).c(Build.FINGERPRINT).a();
                return;
            }
            int b2 = com.baidu.android.pushservice.b.d.a(context).b();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (b2 == 5) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 0);
            } else if (b2 == 6) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 1);
            } else if (b2 == 7) {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 3);
            } else if (b2 != 8) {
                if (b2 == 9) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 5);
                }
                if (z) {
                    jSONObject2.put("token", "");
                    jSONObject.put("info", jSONObject2);
                }
                j.a(context).a(jSONObject.toString());
            } else {
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 4);
            }
            z = true;
            if (z) {
            }
            j.a(context).a(jSONObject.toString());
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

    @TargetApi(24)
    public static void n(Context context) {
        if (m != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(m);
                    m = null;
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static boolean o(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        if (sharedPreferences.getBoolean("bind_status", false)) {
            if (System.currentTimeMillis() - sharedPreferences.getLong("currbindtime", 0L) > com.baidu.android.pushservice.b.d.f(context) * 3600 * 1000) {
                sharedPreferences.edit().clear().commit();
                return false;
            } else if (com.baidu.android.pushservice.j.j.b(context, "need_retry_proxy_bind", false)) {
                return false;
            } else {
                return ((long) m.c(context, context.getPackageName())) == sharedPreferences.getLong("version_code", 0L) && com.baidu.android.pushservice.c.c.b(context) == com.baidu.android.pushservice.a.a();
            }
        }
        return false;
    }

    public static String p(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
            String string = sharedPreferences.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
            String string2 = sharedPreferences.getString("appid", "");
            String string3 = sharedPreferences.getString("channel_id", "");
            String string4 = sharedPreferences.getString("new_channel_id", "");
            String string5 = sharedPreferences.getString("user_id", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", string2);
            jSONObject.put("channel_id", string3);
            if (!TextUtils.isEmpty(string4)) {
                jSONObject.put("new_channel_id", string4);
            }
            jSONObject.put("user_id", string5);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, string);
            jSONObject2.put("response_params", jSONObject);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String q(Context context) {
        return !TextUtils.isEmpty(f3062b) ? f3062b : com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
    }

    public static void r(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (j.size() > 100) {
            return;
        }
        b bVar = new b(applicationContext);
        j.add(bVar);
        if (f3069i == null) {
            f3069i = new a(applicationContext);
        }
        f3069i.postDelayed(bVar, 6000L);
    }

    public static boolean s(Context context) {
        if (k >= 2 || TextUtils.isEmpty(f3062b)) {
            return false;
        }
        k++;
        b(context, true, f3061a);
        return true;
    }

    @TargetApi(24)
    public static void t(final Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                if (m == null) {
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.baidu.android.pushservice.f.3
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            super.onAvailable(network);
                            l.b(context);
                        }
                    };
                    m = networkCallback;
                    connectivityManager.registerDefaultNetworkCallback(networkCallback);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static void u(final Context context) {
        List<String> i2 = com.baidu.android.pushservice.b.d.i(context);
        if (i2.isEmpty()) {
            return;
        }
        Handler handler = new Handler(context.getMainLooper());
        for (int i3 = 0; i3 < i2.size(); i3++) {
            final String str = i2.get(i3);
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
                        } catch (Exception unused) {
                        }
                    }
                }, (5 + i3) * 1000);
            }
        }
    }

    public static void v(Context context) {
        if ((m.e() || m.g() || m.f()) && PushSettings.i(context) && m.p(context) && TextUtils.isEmpty(com.baidu.android.pushservice.j.i.a(context, "notification_channel_id"))) {
            com.baidu.android.pushservice.j.h.a(context, "com.baidu.android.pushservice.push", "云推送");
        }
    }
}
