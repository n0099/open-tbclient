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
import com.baidu.mobstat.ai;
import com.baidu.mobstat.aj;
import com.tencent.connect.common.Constants;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class al {
    public static final al B = new al();
    public Context a;
    public aj b;
    public ai c;
    public Activity d;
    public Handler f;
    public HandlerThread g;
    public Handler h;
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
    public be A = be.a();
    public Handler C = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.al.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 32:
                    al.this.b();
                    return;
                case 33:
                    al.this.c();
                    return;
                case 34:
                    al.this.h();
                    return;
                default:
                    return;
            }
        }
    };
    public aj.a D = new aj.a() { // from class: com.baidu.mobstat.al.2
        @Override // com.baidu.mobstat.aj.a
        public void a() {
            if (bc.c().b()) {
                bc.c().a("onGesture");
            }
            al.this.i();
        }
    };
    public boolean E = true;
    public JSONArray F = new JSONArray();
    public Object G = new Object();
    public am e = new am();

    public void a(Activity activity) {
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 21:
                    al.this.l();
                    return;
                case 22:
                    al.this.m();
                    return;
                case 23:
                    al.this.n();
                    return;
                case 24:
                    Bundle data = message.getData();
                    if (data != null) {
                        al.this.b(data.getString("autoconfig.key"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ai.a {
        public b() {
        }

        @Override // com.baidu.mobstat.ai.a
        public void a(String str) {
            Message obtainMessage = al.this.f.obtainMessage(24);
            Bundle bundle = new Bundle();
            bundle.putString("autoconfig.key", str);
            obtainMessage.setData(bundle);
            al.this.f.sendMessage(obtainMessage);
        }

        @Override // com.baidu.mobstat.ai.a
        public void a() {
            al.this.j();
        }

        @Override // com.baidu.mobstat.ai.a
        public void b() {
            al.this.k();
        }

        @Override // com.baidu.mobstat.ai.a
        public void a(boolean z) {
            al.this.b(z);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                al.this.s();
                return;
            }
            al.this.o();
        }
    }

    public static al a() {
        return B;
    }

    private void f() {
        if (bc.c().b()) {
            bc.c().a("uninstallConnectionTracker");
        }
        aj ajVar = this.b;
        if (ajVar != null) {
            ajVar.b();
            this.b = null;
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
        this.r = bn.a(this.a, af.c);
        c(this.r);
        au.b(this.r);
        aq.a(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.k) {
            this.f.sendMessage(this.f.obtainMessage(21));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j = true;
        if (p() && this.j) {
            this.C.sendMessage(this.C.obtainMessage(32));
            this.h.sendMessage(this.h.obtainMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.k) {
            return;
        }
        boolean a2 = bf.a(this.a, this.v, 0, true);
        this.k = true;
        if (a2) {
            this.p = bn.a(this.a, af.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.l || !bw.q(this.a)) {
            return;
        }
        boolean a2 = bf.a(this.a, this.v, 1, true);
        this.l = true;
        if (a2) {
            this.q = bn.a(this.a, af.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.m || !bw.q(this.a)) {
            return;
        }
        boolean a2 = bf.a(this.a, this.v, 2, true);
        this.m = true;
        if (a2) {
            this.C.sendMessage(this.C.obtainMessage(34));
        }
    }

    private boolean p() {
        ai aiVar = this.c;
        if (aiVar != null && aiVar.b()) {
            return true;
        }
        return false;
    }

    private boolean q() {
        if (TextUtils.isEmpty(this.v)) {
            return false;
        }
        return true;
    }

    private String r() {
        Activity activity = this.d;
        if (activity != null) {
            return activity.getClass().getName();
        }
        return null;
    }

    private void v() {
        if (!this.o) {
            if (TextUtils.isEmpty(this.r)) {
                h();
            }
            this.o = true;
        }
    }

    public void b() {
        Activity activity = this.d;
        if (activity == null) {
            return;
        }
        ah.b(activity);
    }

    public void c() {
        Activity activity = this.d;
        if (activity == null) {
            return;
        }
        ah.a(activity);
    }

    public void d() {
        if (p()) {
            this.c.a();
        }
    }

    public al() {
        HandlerThread handlerThread = new HandlerThread("crawlerThread");
        this.i = handlerThread;
        handlerThread.start();
        this.h = new c(this.i.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("downloadThread");
        this.g = handlerThread2;
        handlerThread2.start();
        this.f = new a(this.g.getLooper());
    }

    private String a(Context context) {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair("appKey", "" + this.v));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("appName", bw.h(context)));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair(com.heytap.mcssdk.constant.b.C, StatService.getSdkVersion()));
        arrayList.add(new Pair("deviceName", bw.k(context)));
        arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
        arrayList.add(new Pair("model", CooperService.instance().getPhoneModel()));
        CooperService.instance().getCUID(context, false);
        arrayList.add(new Pair("cuid", ""));
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

    private void e(Activity activity) {
        if (bc.c().b()) {
            bc.c().a("installConnectionTracker");
        }
        aj ajVar = new aj(this.D);
        this.b = ajVar;
        ajVar.a(activity);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        bp.a().c(this.a, System.currentTimeMillis());
        bn.a(this.a, af.c, str, false);
        this.C.sendMessage(this.C.obtainMessage(34));
    }

    public void c(Activity activity) {
        if (!q()) {
            return;
        }
        this.d = null;
        b(activity, false);
        f();
        a(activity, false);
    }

    private void b(Activity activity, boolean z) {
        if ((activity instanceof IIgnoreAutoTrace) || CooperService.instance().isCloseTrace()) {
            return;
        }
        if (z) {
            BDStatCore.instance().onResume(activity, true);
        } else {
            BDStatCore.instance().onPause(activity, true, null);
        }
    }

    private void b(WebView webView, String str, bk bkVar) {
        if (bkVar == null) {
            return;
        }
        bkVar.a(webView, str);
    }

    private void c(WebView webView, String str, bk bkVar) {
        if (bkVar == null) {
            return;
        }
        bkVar.a(this.d, webView, str, a(this.y, r()), true);
    }

    public void a(WebView webView, String str, bk bkVar) {
        if (TextUtils.isEmpty(this.p)) {
            this.p = bn.a(this.a, af.a);
        }
        b(webView, this.p, bkVar);
        if (TextUtils.isEmpty(this.q)) {
            this.q = bn.a(this.a, af.b);
        }
        c(webView, this.q, bkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.j = false;
        am.b();
        this.h.removeMessages(2);
        this.C.sendMessage(this.C.obtainMessage(33));
    }

    public void a(int i) {
        a(i, "");
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
                launchInfo.setPushInfo(bi.e(activity), stringExtra);
            }
            String g = bi.g(activity);
            if (!TextUtils.isEmpty(g)) {
                launchInfo.setRefererPkgName(g);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.a, launchInfo, true);
        } else {
            LaunchInfo launchInfo2 = new LaunchInfo();
            if (booleanExtra) {
                launchInfo2.setPushInfo(bi.e(activity), stringExtra);
            }
            String g2 = bi.g(activity);
            if (!TextUtils.isEmpty(g2)) {
                launchInfo2.setRefererPkgName(g2);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.a, launchInfo2, false);
        }
        this.E = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (p()) {
            return;
        }
        bb.c().a("autotrace: gesture success");
        a(0);
        if (!bw.q(this.a)) {
            bb.c().a("autotrace: network invalid, failed to connect to circle server");
            return;
        }
        this.h.sendMessage(this.h.obtainMessage(1));
    }

    private void t() {
        if (this.m) {
            return;
        }
        if (this.u == 0) {
            this.u = bp.a().p(this.a);
        }
        if (System.currentTimeMillis() - this.u > 86400000) {
            this.f.sendMessage(this.f.obtainMessage(23));
        }
    }

    public JSONArray e() {
        synchronized (this.G) {
            if (this.a == null) {
                return new JSONArray();
            }
            String a2 = bn.a(this.a, af.d);
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
            bn.a(this.a, af.d, jSONArray2.toString(), false);
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        bb.c().a("autotrace: start to connect");
        a(1);
        if (p()) {
            bb.c().a("autotrace: connect established, no need to duplicate connect");
            return;
        }
        String a2 = a(this.a);
        if (bc.c().b()) {
            String str = HttpRetryStatistic.RETRY_URL;
            if (!TextUtils.isEmpty(a2)) {
                str = HttpRetryStatistic.RETRY_URL + a2;
            }
            bc.c().a(str);
        }
        try {
            this.c = new ai(URI.create(a2), new b());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (p() && this.j) {
            JSONObject a2 = a(this.e.a(this.d));
            if (a2 != null) {
                if (bc.c().b()) {
                    bc c2 = bc.c();
                    c2.a("doSendSnapshot:" + a2.toString());
                }
                try {
                    this.c.a(a2);
                } catch (Exception unused) {
                }
            }
            this.h.sendMessageDelayed(this.h.obtainMessage(2), 2000L);
        }
    }

    private void u() {
        if (this.l) {
            return;
        }
        if (!this.n) {
            this.q = bn.a(this.a, af.b);
            this.n = true;
        }
        if (this.s == 0) {
            this.s = bp.a().n(this.a);
            this.t = bp.a().o(this.a);
        }
        long j = this.t;
        if ((this.n && TextUtils.isEmpty(this.q)) || System.currentTimeMillis() - this.s > j) {
            this.f.sendMessage(this.f.obtainMessage(22));
        }
    }

    public void a(int i, String str) {
        int i2;
        synchronized (this.G) {
            if (this.a == null) {
                return;
            }
            if (str == null) {
                str = "";
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean q = bw.q(this.a);
            StringBuilder sb = new StringBuilder();
            if (q) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            sb.append(i2);
            sb.append("|");
            sb.append(str);
            String sb2 = sb.toString();
            this.F.put(i + "_" + currentTimeMillis + "_" + sb2);
            bn.a(this.a, af.d, this.F.toString(), false);
        }
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

    public void a(String str) {
        this.v = str;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public boolean a(Activity activity, Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
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
            String s = bp.a().s(activity);
            if (TextUtils.isEmpty(queryParameter2) || queryParameter2.equals(s)) {
                return false;
            }
            bp.a().k(activity, queryParameter2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b(Activity activity) {
        Intent intent;
        if (!q()) {
            return;
        }
        this.a = activity.getApplicationContext();
        if (activity != null && (intent = activity.getIntent()) != null && a(activity, intent)) {
            a().i();
        }
        if (this.d != null) {
            c();
        }
        this.d = activity;
        if (bu.a().e()) {
            d(activity);
        }
        v();
        t();
        u();
        b(activity, true);
        e(activity);
        g();
        a(activity, true);
    }
}
