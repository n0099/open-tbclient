package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.baidu.mobstat.aq;
import com.baidu.mobstat.ar;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coremedia.iso.boxes.MetaBox;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class at {
    private static final at A = new at();
    private Context a;
    private ar b;
    private aq c;
    private Activity d;
    private Handler f;
    private HandlerThread g;
    private Handler h;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile String p;
    private volatile String q;
    private volatile String r;
    private long s;
    private long t;
    private long u;
    private String v;
    private boolean w;
    private JSONObject x = new JSONObject();
    private JSONObject y = new JSONObject();
    private bm z = bm.a();
    private Handler B = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.at.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 32:
                    at.this.b();
                    return;
                case 33:
                    at.this.c();
                    return;
                case 34:
                    at.this.h();
                    return;
                default:
                    return;
            }
        }
    };
    private ar.a C = new ar.a() { // from class: com.baidu.mobstat.at.2
        @Override // com.baidu.mobstat.ar.a
        public void a() {
            if (bk.c().b()) {
                bk.c().a("onGesture");
            }
            at.this.i();
        }
    };
    private JSONArray D = new JSONArray();
    private Object E = new Object();
    private au e = new au();
    private HandlerThread i = new HandlerThread("crawlerThread");

    public static at a() {
        return A;
    }

    private at() {
        this.i.start();
        this.h = new c(this.i.getLooper());
        this.g = new HandlerThread("downloadThread");
        this.g.start();
        this.f = new a(this.g.getLooper());
    }

    /* loaded from: classes6.dex */
    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    at.this.o();
                    return;
                case 2:
                    at.this.s();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements aq.a {
        private b() {
        }

        @Override // com.baidu.mobstat.aq.a
        public void a() {
            at.this.j();
        }

        @Override // com.baidu.mobstat.aq.a
        public void b() {
            at.this.k();
        }

        @Override // com.baidu.mobstat.aq.a
        public void a(boolean z) {
            at.this.b(z);
        }

        @Override // com.baidu.mobstat.aq.a
        public void a(String str) {
            Message obtainMessage = at.this.f.obtainMessage(24);
            Bundle bundle = new Bundle();
            bundle.putString("autoconfig.key", str);
            obtainMessage.setData(bundle);
            at.this.f.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes6.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 21:
                    at.this.l();
                    return;
                case 22:
                    at.this.m();
                    return;
                case 23:
                    at.this.n();
                    return;
                case 24:
                    Bundle data = message.getData();
                    if (data != null) {
                        at.this.b(data.getString("autoconfig.key"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(String str) {
        this.v = str;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public void a(Activity activity) {
        if (q()) {
            if (this.d != null) {
                c();
            }
            this.a = activity.getApplicationContext();
            this.d = activity;
            v();
            t();
            u();
            a(activity, true);
            c(activity);
            g();
            this.z.a(activity, true, this.y, this.w);
        }
    }

    public void b(Activity activity) {
        if (q()) {
            this.d = null;
            a(activity, false);
            f();
            this.z.a(activity, true);
        }
    }

    public void a(WebView webView, String str, bs bsVar) {
        if (TextUtils.isEmpty(this.p)) {
            this.p = bv.a(this.a, "mtj_vizParser.js");
        }
        b(webView, this.p, bsVar);
        if (TextUtils.isEmpty(this.q)) {
            this.q = bv.a(this.a, "mtj_autoTracker.js");
        }
        c(webView, this.q, bsVar);
    }

    private void c(Activity activity) {
        if (bk.c().b()) {
            bk.c().a("installConnectionTracker");
        }
        this.b = new ar(this.C);
        this.b.a(activity);
    }

    private void f() {
        if (bk.c().b()) {
            bk.c().a("uninstallConnectionTracker");
        }
        if (this.b != null) {
            this.b.b();
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

    public void b() {
        if (this.d != null) {
            ap.b(this.d);
        }
    }

    public void c() {
        if (this.d != null) {
            ap.a(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.r = bv.a(this.a, "mtj_auto.config");
        c(this.r);
        bc.b(this.r);
        ay.a(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!p()) {
            bj.c().a("autotrace: gesture success");
            a(0);
            if (!cc.s(this.a)) {
                bj.c().a("autotrace: network invalid, failed to connect to circle server");
                return;
            }
            this.h.sendMessage(this.h.obtainMessage(1));
        }
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
            this.B.sendMessage(this.B.obtainMessage(32));
            this.h.sendMessage(this.h.obtainMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.j = false;
        au.b();
        this.h.removeMessages(2);
        this.B.sendMessage(this.B.obtainMessage(33));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.k) {
            boolean a2 = bn.a(this.a, this.v, 0, true);
            this.k = true;
            if (a2) {
                this.p = bv.a(this.a, "mtj_vizParser.js");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.l) {
            boolean a2 = bn.a(this.a, this.v, 1, true);
            this.l = true;
            if (a2) {
                this.q = bv.a(this.a, "mtj_autoTracker.js");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!this.m) {
            boolean a2 = bn.a(this.a, this.v, 2, true);
            this.m = true;
            if (a2) {
                this.B.sendMessage(this.B.obtainMessage(34));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            BasicStoreTools.getInstance().setAutoTraceConfigFetchTime(this.a, System.currentTimeMillis());
            bv.a(this.a, "mtj_auto.config", str, false);
            this.B.sendMessage(this.B.obtainMessage(34));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        bj.c().a("autotrace: start to connect");
        a(1);
        if (p()) {
            bj.c().a("autotrace: connect established, no need to duplicate connect");
            return;
        }
        String a2 = a(this.a);
        if (bk.c().b()) {
            bk.c().a(TextUtils.isEmpty(a2) ? "url:" : "url:" + a2);
        }
        try {
            this.c = new aq(URI.create(a2), new b());
        } catch (Exception e) {
        }
    }

    private boolean p() {
        return this.c != null && this.c.b();
    }

    private String a(Context context) {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair("appKey", "" + this.v));
        arrayList.add(new Pair("appVersion", cc.g(context)));
        arrayList.add(new Pair("appName", cc.h(context)));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
        arrayList.add(new Pair("deviceName", cc.m(context)));
        arrayList.add(new Pair("platform", "Android"));
        arrayList.add(new Pair("model", android.os.Build.MODEL));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("auto", "1"));
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arrayList) {
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), HTTP.UTF_8);
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), HTTP.UTF_8);
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(encode + "=" + encode2);
                } else {
                    sb.append("&" + encode + "=" + encode2);
                }
            } catch (Exception e) {
            }
        }
        return "wss://mtjsocket.baidu.com/app?" + sb.toString();
    }

    private boolean q() {
        return !TextUtils.isEmpty(this.v);
    }

    private void b(WebView webView, String str, bs bsVar) {
        if (bsVar != null) {
            bsVar.a(webView, str);
        }
    }

    private void c(WebView webView, String str, bs bsVar) {
        if (bsVar != null) {
            bsVar.a(this.d, webView, str, a(this.x, r()), true);
        }
    }

    private String r() {
        if (this.d == null) {
            return null;
        }
        return this.d.getClass().getName();
    }

    private void a(Activity activity, boolean z) {
        if (!(activity instanceof IIgnoreAutoTrace)) {
            if (z) {
                BDStatCore.instance().onResume(activity, true);
            } else {
                BDStatCore.instance().onPause(activity, true, null);
            }
        }
    }

    public void d() {
        if (p()) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (p() && this.j) {
            JSONObject a2 = a(this.e.a(this.d));
            if (a2 != null) {
                if (bk.c().b()) {
                    bk.c().a("doSendSnapshot:" + a2.toString());
                }
                try {
                    this.c.a(a2);
                } catch (Exception e) {
                }
            }
            this.h.sendMessageDelayed(this.h.obtainMessage(2), 2000L);
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("type", "upload");
                jSONObject2.put("data", jSONObject);
            } catch (Exception e) {
            }
        }
        return jSONObject2;
    }

    private void t() {
        if (cc.s(this.a) && !this.m) {
            if (this.u == 0) {
                this.u = BasicStoreTools.getInstance().getAutoTraceConfigFetchTime(this.a);
            }
            if (System.currentTimeMillis() - this.u > 86400000) {
                this.f.sendMessage(this.f.obtainMessage(23));
            }
        }
    }

    private void u() {
        if (cc.s(this.a) && !this.l) {
            if (!this.n) {
                this.q = bv.a(this.a, "mtj_autoTracker.js");
                this.n = true;
            }
            if (this.s == 0) {
                this.s = BasicStoreTools.getInstance().getAutoTraceTrackJsFetchTime(this.a);
                this.t = BasicStoreTools.getInstance().getAutoTraceTrackJsFetchInterval(this.a);
            }
            if ((this.n && TextUtils.isEmpty(this.q)) || System.currentTimeMillis() - this.s > this.t) {
                this.f.sendMessage(this.f.obtainMessage(22));
            }
        }
    }

    private void v() {
        if (!this.o) {
            if (TextUtils.isEmpty(this.r)) {
                h();
            }
            this.o = true;
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(MetaBox.TYPE);
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
                this.x.put(MetaBox.TYPE, jSONObject2);
                this.x.put("data", jSONArray2);
                this.y.put(MetaBox.TYPE, jSONObject2);
                this.y.put("data", jSONArray3);
            } catch (Exception e) {
            }
        }
    }

    private JSONObject a(JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        boolean z;
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject3 = (JSONObject) jSONObject.get(MetaBox.TYPE);
            int i = jSONObject3.getInt("matchAll");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject4 = (JSONObject) jSONArray.get(i2);
                if (str.equals((String) jSONObject4.get("page"))) {
                    jSONArray2.put(jSONObject4);
                }
            }
            if (i != 0) {
                z = true;
            } else {
                z = i == 0 && jSONArray2.length() != 0;
            }
            if (z) {
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put(MetaBox.TYPE, jSONObject3);
                    jSONObject5.put("data", jSONArray2);
                    jSONObject2 = jSONObject5;
                } catch (Exception e) {
                    jSONObject2 = jSONObject5;
                }
            } else {
                jSONObject2 = null;
            }
        } catch (Exception e2) {
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    public void a(int i) {
        a(i, "");
    }

    public void a(int i, String str) {
        synchronized (this.E) {
            if (this.a != null) {
                if (str == null) {
                    str = "";
                }
                this.D.put(i + "_" + System.currentTimeMillis() + "_" + ((cc.s(this.a) ? 1 : 0) + "|" + str));
                bv.a(this.a, "trace_circle.data", this.D.toString(), false);
            }
        }
    }

    public JSONArray e() {
        JSONArray jSONArray;
        synchronized (this.E) {
            if (this.a == null) {
                jSONArray = new JSONArray();
            } else {
                String a2 = bv.a(this.a, "trace_circle.data");
                try {
                    jSONArray = !TextUtils.isEmpty(a2) ? new JSONArray(a2) : null;
                } catch (Exception e) {
                    jSONArray = null;
                }
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                this.D = new JSONArray();
                bv.a(this.a, "trace_circle.data", this.D.toString(), false);
            }
        }
        return jSONArray;
    }
}
