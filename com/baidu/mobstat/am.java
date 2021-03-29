package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.mobstat.aj;
import com.baidu.mobstat.ak;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.heytap.mcssdk.mode.CommandMessage;
import com.tencent.connect.common.Constants;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class am {
    public static final am B = new am();

    /* renamed from: a  reason: collision with root package name */
    public Context f8914a;

    /* renamed from: b  reason: collision with root package name */
    public ak f8915b;

    /* renamed from: c  reason: collision with root package name */
    public aj f8916c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f8917d;

    /* renamed from: f  reason: collision with root package name */
    public Handler f8919f;

    /* renamed from: g  reason: collision with root package name */
    public HandlerThread f8920g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f8921h;
    public HandlerThread i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile String p;
    public volatile String q;
    public volatile String r;
    public long s;
    public long t;
    public long u;
    public String v;
    public boolean w;
    public String x;
    public JSONObject y = new JSONObject();
    public JSONObject z = new JSONObject();
    public bf A = bf.a();
    public Handler C = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.am.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 32:
                    am.this.b();
                    return;
                case 33:
                    am.this.c();
                    return;
                case 34:
                    am.this.h();
                    return;
                default:
                    return;
            }
        }
    };
    public ak.a D = new ak.a() { // from class: com.baidu.mobstat.am.2
        @Override // com.baidu.mobstat.ak.a
        public void a() {
            if (bd.c().b()) {
                bd.c().a("onGesture");
            }
            am.this.i();
        }
    };
    public boolean E = true;
    public JSONArray F = new JSONArray();
    public Object G = new Object();

    /* renamed from: e  reason: collision with root package name */
    public an f8918e = new an();

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 21:
                    am.this.l();
                    return;
                case 22:
                    am.this.m();
                    return;
                case 23:
                    am.this.n();
                    return;
                case 24:
                    Bundle data = message.getData();
                    if (data != null) {
                        am.this.b(data.getString("autoconfig.key"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements aj.a {
        public b() {
        }

        @Override // com.baidu.mobstat.aj.a
        public void a() {
            am.this.j();
        }

        @Override // com.baidu.mobstat.aj.a
        public void b() {
            am.this.k();
        }

        @Override // com.baidu.mobstat.aj.a
        public void a(boolean z) {
            am.this.b(z);
        }

        @Override // com.baidu.mobstat.aj.a
        public void a(String str) {
            Message obtainMessage = am.this.f8919f.obtainMessage(24);
            Bundle bundle = new Bundle();
            bundle.putString("autoconfig.key", str);
            obtainMessage.setData(bundle);
            am.this.f8919f.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                am.this.o();
            } else if (i != 2) {
            } else {
                am.this.s();
            }
        }
    }

    public am() {
        HandlerThread handlerThread = new HandlerThread("crawlerThread");
        this.i = handlerThread;
        handlerThread.start();
        this.f8921h = new c(this.i.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("downloadThread");
        this.f8920g = handlerThread2;
        handlerThread2.start();
        this.f8919f = new a(this.f8920g.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j = true;
        if (p() && this.j) {
            this.C.sendMessage(this.C.obtainMessage(32));
            this.f8921h.sendMessage(this.f8921h.obtainMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.k) {
            return;
        }
        boolean a2 = bg.a(this.f8914a, this.v, 0, true);
        this.k = true;
        if (a2) {
            this.p = bo.a(this.f8914a, "mtj_vizParser.js");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.l) {
            return;
        }
        boolean a2 = bg.a(this.f8914a, this.v, 1, true);
        this.l = true;
        if (a2) {
            this.q = bo.a(this.f8914a, "mtj_autoTracker.js");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.m) {
            return;
        }
        boolean a2 = bg.a(this.f8914a, this.v, 2, true);
        this.m = true;
        if (a2) {
            this.C.sendMessage(this.C.obtainMessage(34));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        bc.c().a("autotrace: start to connect");
        a(1);
        if (p()) {
            bc.c().a("autotrace: connect established, no need to duplicate connect");
            return;
        }
        String a2 = a(this.f8914a);
        if (bd.c().b()) {
            String str = HttpRetryStatistic.RETRY_URL;
            if (!TextUtils.isEmpty(a2)) {
                str = HttpRetryStatistic.RETRY_URL + a2;
            }
            bd.c().a(str);
        }
        try {
            this.f8916c = new aj(URI.create(a2), new b());
        } catch (Exception unused) {
        }
    }

    private boolean p() {
        aj ajVar = this.f8916c;
        return ajVar != null && ajVar.b();
    }

    private boolean q() {
        return !TextUtils.isEmpty(this.v);
    }

    private String r() {
        Activity activity = this.f8917d;
        if (activity != null) {
            return activity.getClass().getName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (p() && this.j) {
            JSONObject a2 = a(this.f8918e.a(this.f8917d));
            if (a2 != null) {
                if (bd.c().b()) {
                    bd c2 = bd.c();
                    c2.a("doSendSnapshot:" + a2.toString());
                }
                try {
                    this.f8916c.a(a2);
                } catch (Exception unused) {
                }
            }
            this.f8921h.sendMessageDelayed(this.f8921h.obtainMessage(2), 2000L);
        }
    }

    private void t() {
        if (bw.s(this.f8914a) && !this.m) {
            if (this.u == 0) {
                this.u = bq.a().p(this.f8914a);
            }
            if (System.currentTimeMillis() - this.u > 86400000) {
                this.f8919f.sendMessage(this.f8919f.obtainMessage(23));
            }
        }
    }

    private void u() {
        if (bw.s(this.f8914a) && !this.l) {
            if (!this.n) {
                this.q = bo.a(this.f8914a, "mtj_autoTracker.js");
                this.n = true;
            }
            if (this.s == 0) {
                this.s = bq.a().n(this.f8914a);
                this.t = bq.a().o(this.f8914a);
            }
            if (!(this.n && TextUtils.isEmpty(this.q)) && System.currentTimeMillis() - this.s <= this.t) {
                return;
            }
            this.f8919f.sendMessage(this.f8919f.obtainMessage(22));
        }
    }

    private void v() {
        if (this.o) {
            return;
        }
        if (TextUtils.isEmpty(this.r)) {
            h();
        }
        this.o = true;
    }

    public void a(Activity activity) {
    }

    private void d(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(MtjConfig.BAIDU_MTJ_PUSH_CALL, false);
        String stringExtra = intent.getStringExtra(MtjConfig.BAIDU_MTJ_PUSH_MSG);
        if (this.E) {
            LaunchInfo launchInfo = new LaunchInfo();
            if (booleanExtra) {
                launchInfo.setPushInfo(bj.e(activity), stringExtra);
            }
            String g2 = bj.g(activity);
            if (!TextUtils.isEmpty(g2)) {
                launchInfo.setRefererPkgName(g2);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.f8914a, launchInfo, true);
        } else {
            LaunchInfo launchInfo2 = new LaunchInfo();
            if (booleanExtra) {
                launchInfo2.setPushInfo(bj.e(activity), stringExtra);
            }
            String g3 = bj.g(activity);
            if (!TextUtils.isEmpty(g3)) {
                launchInfo2.setRefererPkgName(g3);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.f8914a, launchInfo2, false);
        }
        this.E = false;
    }

    private void e(Activity activity) {
        if (bd.c().b()) {
            bd.c().a("installConnectionTracker");
        }
        ak akVar = new ak(this.D);
        this.f8915b = akVar;
        akVar.a(activity);
    }

    private void f() {
        if (bd.c().b()) {
            bd.c().a("uninstallConnectionTracker");
        }
        ak akVar = this.f8915b;
        if (akVar != null) {
            akVar.b();
            this.f8915b = null;
        }
    }

    private void g() {
        if (p() && this.j) {
            b();
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.r = bo.a(this.f8914a, "mtj_auto.config");
        c(this.r);
        av.b(this.r);
        ar.a(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (p()) {
            return;
        }
        bc.c().a("autotrace: gesture success");
        a(0);
        if (!bw.s(this.f8914a)) {
            bc.c().a("autotrace: network invalid, failed to connect to circle server");
            return;
        }
        this.f8921h.sendMessage(this.f8921h.obtainMessage(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.k) {
            return;
        }
        this.f8919f.sendMessage(this.f8919f.obtainMessage(21));
    }

    public void b(Activity activity) {
        Intent intent;
        if (q()) {
            this.f8914a = activity.getApplicationContext();
            if (activity != null && (intent = activity.getIntent()) != null && a(activity, intent)) {
                a().i();
            }
            if (this.f8917d != null) {
                c();
            }
            this.f8917d = activity;
            d(activity);
            v();
            t();
            u();
            b(activity, true);
            e(activity);
            g();
            a(activity, true);
        }
    }

    public void c(Activity activity) {
        if (q()) {
            this.f8917d = null;
            b(activity, false);
            f();
            a(activity, false);
        }
    }

    public static am a() {
        return B;
    }

    public void a(String str) {
        this.v = str;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public JSONArray e() {
        synchronized (this.G) {
            if (this.f8914a == null) {
                return new JSONArray();
            }
            String a2 = bo.a(this.f8914a, "trace_circle.data");
            JSONArray jSONArray = null;
            try {
                if (!TextUtils.isEmpty(a2)) {
                    jSONArray = new JSONArray(a2);
                }
            } catch (Exception unused) {
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            JSONArray jSONArray2 = new JSONArray();
            this.F = jSONArray2;
            bo.a(this.f8914a, "trace_circle.data", jSONArray2.toString(), false);
            return jSONArray;
        }
    }

    public boolean a(Activity activity, Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String scheme = data.getScheme();
            if (TextUtils.isEmpty(scheme)) {
                return false;
            }
            try {
                String queryParameter = data.getQueryParameter("token");
                String queryParameter2 = data.getQueryParameter("time");
                if (!scheme.startsWith("mtj") || scheme.length() <= 3) {
                    return false;
                }
                String substring = scheme.substring(3);
                if (TextUtils.isEmpty(substring) || !substring.equals(this.v.toLowerCase()) || TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                this.x = queryParameter;
                String r = bq.a().r(activity);
                if (TextUtils.isEmpty(queryParameter2) || queryParameter2.equals(r)) {
                    return false;
                }
                bq.a().j(activity, queryParameter2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public void c() {
        Activity activity = this.f8917d;
        if (activity == null) {
            return;
        }
        ai.a(activity);
    }

    private void c(WebView webView, String str, bl blVar) {
        if (blVar == null) {
            return;
        }
        blVar.a(this.f8917d, webView, str, a(this.y, r()), true);
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
                String str2 = (String) jSONObject3.opt("url");
                if (TextUtils.isEmpty((String) jSONObject3.opt("webLayout")) && TextUtils.isEmpty(str2)) {
                    jSONArray3.put(jSONObject3);
                } else {
                    jSONArray2.put(jSONObject3);
                }
            }
            this.y.put("meta", jSONObject2);
            this.y.put("data", jSONArray2);
            this.z.put("meta", jSONObject2);
            this.z.put("data", jSONArray3);
        } catch (Exception unused) {
        }
    }

    public void b() {
        Activity activity = this.f8917d;
        if (activity == null) {
            return;
        }
        ai.b(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.j = false;
        an.b();
        this.f8921h.removeMessages(2);
        this.C.sendMessage(this.C.obtainMessage(33));
    }

    public void a(Activity activity, boolean z) {
        if (activity instanceof IIgnoreAutoEvent) {
            return;
        }
        if (z) {
            this.A.a(activity, true, this.z, this.w);
        } else {
            this.A.a(activity, true);
        }
    }

    public void d() {
        if (p()) {
            this.f8916c.a();
        }
    }

    public void a(WebView webView, String str, bl blVar) {
        if (TextUtils.isEmpty(this.p)) {
            this.p = bo.a(this.f8914a, "mtj_vizParser.js");
        }
        b(webView, this.p, blVar);
        if (TextUtils.isEmpty(this.q)) {
            this.q = bo.a(this.f8914a, "mtj_autoTracker.js");
        }
        c(webView, this.q, blVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.f8914a == null || TextUtils.isEmpty(str)) {
            return;
        }
        bq.a().c(this.f8914a, System.currentTimeMillis());
        bo.a(this.f8914a, "mtj_auto.config", str, false);
        this.C.sendMessage(this.C.obtainMessage(34));
    }

    private String a(Context context) {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair("appKey", "" + this.v));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("appName", bw.h(context)));
        arrayList.add(new Pair(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, context.getPackageName()));
        arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
        arrayList.add(new Pair("deviceName", bw.m(context)));
        arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
        arrayList.add(new Pair("model", android.os.Build.MODEL));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("auto", "1"));
        if (!TextUtils.isEmpty(this.x)) {
            arrayList.add(new Pair("token", this.x));
        }
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arrayList) {
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(encode + "=" + encode2);
                } else {
                    sb.append("&" + encode + "=" + encode2);
                }
            } catch (Exception unused) {
            }
        }
        String str = "wss://mtjsocket.baidu.com/app?" + sb.toString();
        this.x = null;
        return str;
    }

    private void b(WebView webView, String str, bl blVar) {
        if (blVar == null) {
            return;
        }
        blVar.a(webView, str);
    }

    private void b(Activity activity, boolean z) {
        if (activity instanceof IIgnoreAutoTrace) {
            return;
        }
        if (z) {
            BDStatCore.instance().onResume(activity, true);
        } else {
            BDStatCore.instance().onPause(activity, true, null);
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            jSONObject2.put("type", "upload");
            jSONObject2.put("data", jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: Exception -> 0x0064, TRY_LEAVE, TryCatch #0 {Exception -> 0x0064, blocks: (B:8:0x000f, B:9:0x0028, B:11:0x002e, B:13:0x0042, B:14:0x0045, B:23:0x0058, B:19:0x004f), top: B:29:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
            int i = jSONObject2.getInt("matchAll");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            boolean z = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                if (str.equals((String) jSONObject3.get("page"))) {
                    jSONArray2.put(jSONObject3);
                }
            }
            if (i == 0) {
                if (i == 0 && jSONArray2.length() != 0) {
                }
                if (z) {
                    return null;
                }
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("meta", jSONObject2);
                    jSONObject4.put("data", jSONArray2);
                } catch (Exception unused) {
                }
                return jSONObject4;
            }
            z = true;
            if (z) {
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public void a(int i) {
        a(i, "");
    }

    public void a(int i, String str) {
        synchronized (this.G) {
            if (this.f8914a == null) {
                return;
            }
            if (str == null) {
                str = "";
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean s = bw.s(this.f8914a);
            StringBuilder sb = new StringBuilder();
            sb.append(s ? 1 : 0);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            String sb2 = sb.toString();
            this.F.put(i + "_" + currentTimeMillis + "_" + sb2);
            bo.a(this.f8914a, "trace_circle.data", this.F.toString(), false);
        }
    }
}
