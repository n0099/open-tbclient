package com.baidu.android.pushservice;

import android.annotation.TargetApi;
import android.content.ComponentName;
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
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pushservice.a0.l;
import com.baidu.android.pushservice.a0.m;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.n6c;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.kuaishou.weapon.p0.u;
import com.tencent.connect.common.Constants;
import com.vivo.push.PushClient;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static int a = -1;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static final ConcurrentLinkedQueue<Runnable> i = new ConcurrentLinkedQueue<>();
    public static int j = 0;
    public static ConnectivityManager.NetworkCallback k;
    public static Handler l;

    /* loaded from: classes.dex */
    public static class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;

        public a(Context context) {
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            String str;
            e.h(this.c);
            try {
                str = HmsInstanceId.getInstance(this.c).getToken(n6c.c(this.c).a("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
            } catch (Throwable unused) {
                PushSettings.h = 1;
                com.baidu.android.pushservice.a0.i.b(this.c, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 1);
                Utility.W(this.c);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e.a(this.c, str, 5);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements d.InterfaceC0029d {
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public b(int i, Context context, String str, boolean z) {
            this.a = i;
            this.b = context;
            this.c = str;
            this.d = z;
        }

        @Override // com.baidu.android.pushservice.l.d.InterfaceC0029d
        public void a() {
            if (this.a == 0) {
                com.baidu.android.pushservice.a0.i.b(this.b, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                com.baidu.android.pushservice.a0.i.b(this.b, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", this.c);
            }
            int unused = e.j = 0;
            com.baidu.android.pushservice.i.g = false;
            e.b(this.b, this.d, this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ TokenBindListener e;

        public c(Context context, String str, TokenBindListener tokenBindListener) {
            this.c = context;
            this.d = str;
            this.e = tokenBindListener;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            TokenBindListener tokenBindListener;
            e.u(this.c);
            if (!Utility.b(this.c) && !TextUtils.isEmpty(this.d) && (tokenBindListener = this.e) != null) {
                tokenBindListener.onResult(0, "sdk_bind");
            }
            e.c(this.c, 0, this.d);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            e.A(this.a);
        }
    }

    /* renamed from: com.baidu.android.pushservice.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0028e extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;

        public C0028e(Context context) {
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            if (e.f(this.c)) {
                m.a(this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;

        public f(String str, Context context) {
            this.a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent();
                intent.setPackage(this.a);
                intent.setClassName(this.a, "com.baidu.android.pushservice.PushService");
                intent.putExtra("source", this.b.getPackageName());
                this.b.startService(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements d.InterfaceC0029d {
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ClientEventInfo d;

        public g(Context context, int i, String str, ClientEventInfo clientEventInfo) {
            this.a = context;
            this.b = i;
            this.c = str;
            this.d = clientEventInfo;
        }

        @Override // com.baidu.android.pushservice.l.d.InterfaceC0029d
        public void a() {
            if (Utility.I(this.a) && this.b == 0) {
                com.baidu.android.pushservice.a0.i.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                com.baidu.android.pushservice.a0.i.b(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", this.c);
            }
            if (Utility.T(this.a) || Utility.J(this.a) || Utility.I(this.a)) {
                com.baidu.android.pushservice.i.g = false;
                int unused = e.j = 0;
                e.b(this.a, true, this.b);
            }
            m.b(this.a.getApplicationContext(), null, this.d);
        }
    }

    /* loaded from: classes.dex */
    public static class h extends Handler {
        public h(Context context) {
            super(context.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 65553 || e.l == null || e.i == null || e.i.isEmpty()) {
                return;
            }
            e.l.removeCallbacks((i) e.i.poll());
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public Context a;

        public i(Context context) {
            this.a = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (r0 > com.baidu.mobads.sdk.internal.bj.e) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
            if (r0 > 86400000) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
            r2 = "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
            if (r0 > com.baidu.tbadk.core.util.StorageFile.MAX_BUBBULE_CACHE_TIME) goto L15;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.android.pushservice.a0.j.d(this.a);
            String str = com.baidu.android.pushservice.l.d.B(this.a) ? com.baidu.android.pushservice.a0.j.e(this.a) : (com.baidu.android.pushservice.l.d.m(this.a) || com.baidu.android.pushservice.l.d.t(this.a)) ? com.baidu.android.pushservice.a0.j.b(this.a) : com.baidu.android.pushservice.l.d.n(this.a) ? com.baidu.android.pushservice.a0.j.c(this.a) : null;
            if (!TextUtils.isEmpty(str)) {
                e.a(this.a, str);
                return;
            }
            if (!e.i.isEmpty()) {
                e.i.poll();
            }
            e.z(this.a);
        }
    }

    public static void A(Context context) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.z.e.a().a(new C0028e(context));
    }

    @TargetApi(24)
    public static void B(Context context) {
        if (k != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(k);
                    k = null;
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static void C(Context context) {
        Intent i2 = i(context);
        if (i2 == null) {
            return;
        }
        i2.putExtra("method", "method_unbind");
        a(context, i2);
        Utility.c(context, false);
    }

    public static boolean D(Context context) {
        return System.currentTimeMillis() - com.baidu.android.pushservice.a0.i.b(context, "key_widget_push_source_set_time") < 259200000;
    }

    public static Intent a(Context context, boolean z) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CHANGE_ALARM");
        intent.setFlags(32);
        intent.putExtra("com.baidu.android.pushservice.action.receiver.ALARM_IS_BACK", z);
        intent.setClass(context, PushServiceReceiver.class);
        return intent;
    }

    public static void a(Context context, int i2) {
        Intent b2 = b(context, i2);
        if (b2 == null) {
            return;
        }
        d(context, b2);
        com.baidu.android.pushservice.u.a.a("PushManagerHandler", "Bind by selfEventHandler", context);
    }

    public static void a(Context context, int i2, String str) {
        String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
        com.baidu.android.pushservice.u.a.b("PushManagerHandler", str2, context.getApplicationContext());
        Utility.c(context, false);
        Intent intent = new Intent();
        intent.putExtra("method", "method_bind");
        intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i2);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        Utility.c(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
    }

    public static void a(Context context, int i2, String str, ClientEventInfo clientEventInfo) {
        com.baidu.android.pushservice.l.d.i(context.getApplicationContext()).a(str, new g(context, i2, str, clientEventInfo));
    }

    public static void a(Context context, int i2, String str, boolean z) {
        com.baidu.android.pushservice.l.d.i(context.getApplicationContext()).a(str, new b(i2, context, str, z));
    }

    public static void a(Context context, Intent intent) {
        if (d(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i2) {
        try {
            if (l != null && !i.isEmpty()) {
                l.sendEmptyMessage(65553);
            }
            System.currentTimeMillis();
            Intent b2 = b(context, 0);
            if (b2 == null) {
                return;
            }
            if (i2 == -1) {
                i2 = com.baidu.android.pushservice.l.d.i(context).b();
            }
            if (TextUtils.isEmpty(str)) {
                z(context);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            boolean z = true;
            if (i2 == 5) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 0);
            } else if (i2 == 6) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 1);
            } else if (i2 == 7) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 3);
            } else if (i2 == 8) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 4);
            } else if (i2 == 9) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 5);
            } else if (i2 == 10) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 9);
            } else {
                z = false;
            }
            if (z) {
                jSONObject2.put("token", str);
                JSONObject l2 = l(context);
                if (l2.length() > 0) {
                    jSONObject2.put("ext", l2);
                }
                jSONObject.put("info", jSONObject2);
                com.baidu.android.pushservice.a0.j.a(context, i2, str);
            }
            b2.putExtra("push_proxy", jSONObject.toString());
            if (com.baidu.android.pushservice.i.g) {
                com.baidu.android.pushservice.i.a(context).a(jSONObject.toString());
            } else {
                d(context, b2);
            }
            com.baidu.android.pushservice.a0.j.b(context, "need_retry_proxy_bind", false);
        } catch (Exception unused) {
            z(context);
        }
    }

    public static void a(Context context, String str, int i2, String str2, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.i.a(context).a(i2, str2, clientEventInfo, tokenBindListener);
        com.baidu.android.pushservice.z.e.a().a(new c(context, str, tokenBindListener));
    }

    public static boolean a(Context context, UploadDataListener uploadDataListener) {
        if (uploadDataListener == null) {
            return false;
        }
        if (context == null) {
            uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            String d2 = Utility.d(context, context.getPackageName());
            if (d2 != null) {
                String a2 = com.baidu.android.pushservice.a0.f.a(Utility.a(d2.getBytes(), str2.getBytes()), false);
                if (!TextUtils.isEmpty(a2)) {
                    if (l.a(a2.getBytes(), str, BaiduAppSSOJni.getPublicKey(3))) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static Intent b(Context context, int i2) {
        Intent i3 = i(context);
        if (i3 == null) {
            return null;
        }
        i3.putExtra("method", "method_bind");
        i3.putExtra("bind_status", i2);
        i3.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        i3.setFlags(i3.getFlags() | 32);
        if (Build.VERSION.SDK_INT >= 19) {
            int b2 = com.baidu.android.pushservice.a0.h.b(context);
            i3.putExtra("bind_notify_status", b2 + "");
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
        r2 = r1.getFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r2 = r2.split(com.yy.hiidostatis.defs.obj.ParamableElem.DIVIDE_PARAM);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r2 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r2.length <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r4 >= r2.length) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r2[r4].contains("S.bdpush_hwmsgid") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        r6 = r2[r4].split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        if (r6 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (1 >= r6.length) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r3 = r6[1];
        r10.putExtra("bdpush_hwmsgid", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        r10 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (r10.contains("#Intent;") == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
        r9 = com.baidu.android.pushservice.util.Utility.f(r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r9 <= 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append(r3);
        r0.append(r10.substring(0, r9));
        r9 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, Intent intent) {
        if (intent != null) {
            try {
                Uri data = intent.getData();
                String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                String stringExtra2 = intent.getStringExtra("bdpush_hwmsgid");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    if (data != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(stringExtra2);
                        sb.append(data.toString());
                        return sb.toString();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void b(Context context, int i2, String str) {
        if (s(context)) {
            return;
        }
        com.baidu.android.pushservice.a.a(context, true);
        Utility.a(context, true, false);
        com.baidu.android.pushservice.u.a.a("PushManagerHandler", "startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (f(context)) {
            Utility.a(context, true, true);
            String e2 = e(context);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
            intent.putExtra("content", e2.getBytes());
            intent.putExtra("bind_status", 0);
            com.baidu.android.pushservice.u.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:method_bind ,errorCode : 0 ,content : " + e2, context.getApplicationContext());
            Utility.c(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
            t(context);
        } else {
            a(context, i2, str, false);
        }
        if (Build.VERSION.SDK_INT >= 24 && Utility.j(context, context.getPackageName()) >= 24) {
            v(context);
        }
        g(context);
    }

    public static void b(Context context, String str) {
        Intent b2 = b(context, 0);
        if (b2 == null) {
            return;
        }
        if (com.baidu.android.pushservice.i.g) {
            com.baidu.android.pushservice.i.a(context).a(str);
            return;
        }
        b2.putExtra("push_proxy", str);
        d(context, b2);
    }

    public static void b(Context context, boolean z, int i2) {
        boolean q = com.baidu.android.pushservice.l.d.q(context);
        System.currentTimeMillis();
        if (com.baidu.android.pushservice.l.d.m(context)) {
            if (!z && !q) {
                com.baidu.android.pushservice.a.a(context, false);
            }
        } else if (!com.baidu.android.pushservice.l.d.t(context)) {
            if (com.baidu.android.pushservice.l.d.B(context)) {
                if (!z && !q) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                q(context);
                return;
            } else if (com.baidu.android.pushservice.l.d.p(context) && com.baidu.android.pushservice.l.d.w(context)) {
                if (!z && !q) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                p(context);
                return;
            } else if (com.baidu.android.pushservice.l.d.n(context)) {
                if (!z && !q) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                o(context);
                return;
            } else if (com.baidu.android.pushservice.l.d.y(context)) {
                Utility.b(context.getApplicationContext(), z);
                return;
            } else {
                com.baidu.android.pushservice.u.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
                if (i2 != 0) {
                    com.baidu.android.pushservice.u.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                    return;
                }
                com.baidu.android.pushservice.u.a.a("PushManagerHandler", "startWork at time of " + System.currentTimeMillis(), context);
                if (com.baidu.android.pushservice.i.g) {
                    com.baidu.android.pushservice.i.a(context).a("");
                    return;
                } else {
                    a(context, 0);
                    return;
                }
            }
        } else if (com.baidu.android.pushservice.l.d.l(context)) {
            com.baidu.android.pushservice.o.a.a(context).e();
            return;
        }
        n(context);
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
                if (TextUtils.isEmpty(fragment) || (split = fragment.split(ParamableElem.DIVIDE_PARAM)) == null || split.length <= 0) {
                    return stringExtra;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].startsWith("S.bdpush_hwprisigninfo")) {
                        return split[i2].substring(23);
                    }
                }
                return stringExtra;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static void c(Context context) {
        d(context);
    }

    public static void c(Context context, int i2) {
        if (i2 == 3) {
            com.baidu.android.pushservice.a0.i.b(context, "key_widget_push_source_set_time", System.currentTimeMillis());
        }
    }

    public static void c(Context context, int i2, String str) {
        com.baidu.android.pushservice.i.g = true;
        if (i2 == 0) {
            com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        }
        b(context, true, i2);
    }

    public static void d(Context context) {
        if (l == null || i.isEmpty()) {
            return;
        }
        l.sendEmptyMessage(65553);
        y(context);
    }

    public static void d(Context context, int i2) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PushSystemNotifyReceiver.class.getName()), i2, 1);
        } catch (Throwable unused) {
        }
        if (i2 == 2) {
            com.baidu.android.pushservice.v.c.a().d(context, i2);
        }
    }

    public static boolean d(Context context, Intent intent) {
        return com.baidu.android.pushservice.h.a(context).c(intent);
    }

    public static String e(Context context) {
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

    public static boolean f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        if (sharedPreferences.getBoolean("bind_status", false)) {
            if (System.currentTimeMillis() - sharedPreferences.getLong("currbindtime", 0L) > com.baidu.android.pushservice.l.d.f(context) * 3600 * 1000) {
                sharedPreferences.edit().clear().commit();
                return false;
            } else if (com.baidu.android.pushservice.a0.j.a(context, "need_retry_proxy_bind", false)) {
                return false;
            } else {
                return ((long) Utility.k(context, context.getPackageName())) == sharedPreferences.getLong("version_code", 0L) && com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.SDK_INT_VERSION", (int) com.baidu.android.pushservice.a.a()) == com.baidu.android.pushservice.a.a();
            }
        }
        return false;
    }

    public static void g(Context context) {
        if ((Utility.N(context) || Utility.P(context) || Utility.M(context)) && PushSettings.k(context) && Utility.E(context) && TextUtils.isEmpty(com.baidu.android.pushservice.a0.i.c(context, "notification_channel_id"))) {
            com.baidu.android.pushservice.a0.h.a(context, "com.baidu.android.pushservice.push", "云推送");
        }
    }

    public static void h(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (i.size() > 100) {
            return;
        }
        i iVar = new i(applicationContext);
        i.add(iVar);
        if (l == null) {
            l = new h(applicationContext);
        }
        l.postDelayed(iVar, 10000L);
    }

    public static Intent i(Context context) {
        if (s(context)) {
            return null;
        }
        int i2 = a;
        if (i2 == -1) {
            i2 = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        }
        String k2 = k(context);
        if (TextUtils.isEmpty(k2)) {
            com.baidu.android.pushservice.u.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            y(context);
            return null;
        }
        Intent b2 = m.b(context);
        if (i2 == 0) {
            b2.putExtra("secret_key", k2);
            return b2;
        }
        return null;
    }

    public static Intent j(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.ALARM");
        intent.putExtra(com.baidu.android.imsdk.internal.Constants.EXTRA_ALARM_ALERT, bx.k);
        intent.setFlags(32);
        intent.setClass(context, PushServiceReceiver.class);
        return intent;
    }

    public static String k(Context context) {
        return !TextUtils.isEmpty(b) ? b : com.baidu.android.pushservice.a0.i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
    }

    public static JSONObject l(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.android.pushservice.l.d.y(context)) {
                jSONObject.put("control_strategies", PushClient.getInstance(context).isSupportNewControlStrategies() == 0 ? 1 : 0);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static Intent m(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM");
        intent.setFlags(32);
        intent.setClass(context, PushServiceReceiver.class);
        return intent;
    }

    public static void n(Context context) {
        PushSettings.h = 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 0);
        com.baidu.android.pushservice.z.e.a().a(new a(context));
    }

    public static void o(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(e)) {
            e = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(f)) {
            f = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(f)) {
            y(applicationContext);
            return;
        }
        h(applicationContext);
        Utility.c(applicationContext, e, f);
    }

    public static void p(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(g)) {
            g = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(h)) {
            h = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
        }
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(h)) {
            y(applicationContext);
            return;
        }
        h(applicationContext);
        Utility.d(applicationContext, g, h);
    }

    public static void q(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(c)) {
            c = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(d)) {
            d = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            y(applicationContext);
            return;
        }
        h(applicationContext);
        Utility.e(applicationContext, c, d);
    }

    public static boolean r(Context context) {
        return context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).contains("bind_status");
    }

    public static boolean s(Context context) {
        return context == null;
    }

    public static void t(Context context) {
        List<String> j2 = com.baidu.android.pushservice.l.d.j(context);
        if (j2.isEmpty()) {
            return;
        }
        Handler handler = new Handler(context.getMainLooper());
        for (int i2 = 0; i2 < j2.size(); i2++) {
            String str = j2.get(i2);
            if (Utility.m(context, str)) {
                handler.postDelayed(new f(str, context), (5 + i2) * 1000);
            }
        }
    }

    public static void u(Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        context.getSharedPreferences(u.x, 0);
        context.getSharedPreferences("push_client_self_info", 0);
        context.getSharedPreferences("pst_bdservice_v1", 0);
        com.baidu.android.pushservice.l.d.i(context);
    }

    @TargetApi(24)
    public static void v(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                if (k == null) {
                    d dVar = new d(context);
                    k = dVar;
                    connectivityManager.registerDefaultNetworkCallback(dVar);
                }
            } catch (Exception unused) {
                k = null;
            }
        }
    }

    public static void w(Context context) {
        String k2 = k(context);
        if (TextUtils.isEmpty(k2)) {
            return;
        }
        a(context, 0, k2, false);
    }

    public static boolean x(Context context) {
        if (j >= 2 || TextUtils.isEmpty(b)) {
            return false;
        }
        j++;
        b(context, true, a);
        return true;
    }

    public static void y(Context context) {
        Intent intent = new Intent();
        String a2 = PushConstants.a(IMConstants.ERROR_GROUP_DISBAND);
        intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
        intent.putExtra("method", "method_bind");
        intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, IMConstants.ERROR_GROUP_DISBAND);
        intent.putExtra("content", a2.getBytes());
        intent.setFlags(32);
        Utility.c(context, intent, intent.getAction(), context.getPackageName());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:2:0x0000, B:4:0x0006, B:7:0x001d, B:22:0x0043, B:23:0x0050, B:10:0x0024, B:13:0x002b, B:16:0x0034, B:19:0x003d, B:25:0x005c, B:28:0x0063, B:31:0x006a), top: B:34:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void z(Context context) {
        Intent b2;
        try {
            boolean z = false;
            if (!com.baidu.android.pushservice.i.g) {
                if (x(context) || (b2 = b(context, 0)) == null) {
                    return;
                }
                b2.putExtra("ignore_token", true);
                d(context, b2);
                com.baidu.android.pushservice.a0.j.b(context, "need_retry_proxy_bind", true);
                return;
            }
            int b3 = com.baidu.android.pushservice.l.d.i(context).b();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (b3 == 5) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 0);
            } else if (b3 == 6) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 1);
            } else if (b3 == 7) {
                jSONObject2.put(Constants.PARAM_PLATFORM, 3);
            } else if (b3 != 8) {
                if (b3 == 9) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 5);
                }
                if (z) {
                    jSONObject2.put("token", "");
                    jSONObject.put("info", jSONObject2);
                }
                com.baidu.android.pushservice.i.a(context).a(jSONObject.toString());
            } else {
                jSONObject2.put(Constants.PARAM_PLATFORM, 4);
            }
            z = true;
            if (z) {
            }
            com.baidu.android.pushservice.i.a(context).a(jSONObject.toString());
        } catch (Throwable unused) {
        }
    }
}
