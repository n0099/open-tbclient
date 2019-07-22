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
import com.baidu.mobstat.aj;
import com.baidu.mobstat.ak;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coremedia.iso.boxes.MetaBox;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class am {
    private static final am B = new am();
    private Context a;
    private ak b;
    private aj c;
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
    private String x;
    private JSONObject y = new JSONObject();
    private JSONObject z = new JSONObject();
    private bf A = bf.a();
    private Handler C = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.am.1
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
    private ak.a D = new ak.a() { // from class: com.baidu.mobstat.am.2
        @Override // com.baidu.mobstat.ak.a
        public void a() {
            if (bd.c().b()) {
                bd.c().a("onGesture");
            }
            am.this.i();
        }
    };
    private boolean E = true;
    private JSONArray F = new JSONArray();
    private Object G = new Object();
    private an e = new an();
    private HandlerThread i = new HandlerThread("crawlerThread");

    public static am a() {
        return B;
    }

    private am() {
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
                    am.this.o();
                    return;
                case 2:
                    am.this.s();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements aj.a {
        private b() {
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
            Message obtainMessage = am.this.f.obtainMessage(24);
            Bundle bundle = new Bundle();
            bundle.putString("autoconfig.key", str);
            obtainMessage.setData(bundle);
            am.this.f.sendMessage(obtainMessage);
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
            String queryParameter2 = data.getQueryParameter(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            if (!scheme.startsWith("mtj") || scheme.length() <= "mtj".length()) {
                return false;
            }
            String substring = scheme.substring("mtj".length());
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
        } catch (Exception e) {
            return false;
        }
    }

    public void a(Activity activity) {
    }

    private void d(Activity activity) {
        Intent intent;
        if (activity != null && (intent = activity.getIntent()) != null) {
            boolean booleanExtra = intent.getBooleanExtra(MtjConfig.BAIDU_MTJ_PUSH_CALL, false);
            String stringExtra = intent.getStringExtra(MtjConfig.BAIDU_MTJ_PUSH_MSG);
            if (this.E) {
                LaunchInfo launchInfo = new LaunchInfo();
                if (booleanExtra) {
                    launchInfo.setPushInfo(bj.e(activity), stringExtra);
                }
                String g = bj.g(activity);
                if (!TextUtils.isEmpty(g)) {
                    launchInfo.setRefererPkgName(g);
                }
                BDStatCore.instance().autoTrackLaunchInfo(this.a, launchInfo, true);
            } else {
                LaunchInfo launchInfo2 = new LaunchInfo();
                if (booleanExtra) {
                    launchInfo2.setPushInfo(bj.e(activity), stringExtra);
                }
                String g2 = bj.g(activity);
                if (!TextUtils.isEmpty(g2)) {
                    launchInfo2.setRefererPkgName(g2);
                }
                BDStatCore.instance().autoTrackLaunchInfo(this.a, launchInfo2, false);
            }
            this.E = false;
        }
    }

    public void b(Activity activity) {
        Intent intent;
        if (q()) {
            this.a = activity.getApplicationContext();
            if (activity != null && (intent = activity.getIntent()) != null && a(activity, intent)) {
                a().i();
            }
            if (this.d != null) {
                c();
            }
            this.d = activity;
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

    public void a(Activity activity, boolean z) {
        if (!(activity instanceof IIgnoreAutoEvent)) {
            if (z) {
                this.A.a(activity, true, this.z, this.w);
            } else {
                this.A.a(activity, true);
            }
        }
    }

    public void c(Activity activity) {
        if (q()) {
            this.d = null;
            b(activity, false);
            f();
            a(activity, false);
        }
    }

    public void a(WebView webView, String str, bl blVar) {
        if (TextUtils.isEmpty(this.p)) {
            this.p = bo.a(this.a, "mtj_vizParser.js");
        }
        b(webView, this.p, blVar);
        if (TextUtils.isEmpty(this.q)) {
            this.q = bo.a(this.a, "mtj_autoTracker.js");
        }
        c(webView, this.q, blVar);
    }

    private void e(Activity activity) {
        if (bd.c().b()) {
            bd.c().a("installConnectionTracker");
        }
        this.b = new ak(this.D);
        this.b.a(activity);
    }

    private void f() {
        if (bd.c().b()) {
            bd.c().a("uninstallConnectionTracker");
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
            ai.b(this.d);
        }
    }

    public void c() {
        if (this.d != null) {
            ai.a(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.r = bo.a(this.a, "mtj_auto.config");
        c(this.r);
        av.b(this.r);
        ar.a(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!p()) {
            bc.c().a("autotrace: gesture success");
            a(0);
            if (!bw.s(this.a)) {
                bc.c().a("autotrace: network invalid, failed to connect to circle server");
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
            this.C.sendMessage(this.C.obtainMessage(32));
            this.h.sendMessage(this.h.obtainMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.j = false;
        an.b();
        this.h.removeMessages(2);
        this.C.sendMessage(this.C.obtainMessage(33));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.k) {
            boolean a2 = bg.a(this.a, this.v, 0, true);
            this.k = true;
            if (a2) {
                this.p = bo.a(this.a, "mtj_vizParser.js");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.l) {
            boolean a2 = bg.a(this.a, this.v, 1, true);
            this.l = true;
            if (a2) {
                this.q = bo.a(this.a, "mtj_autoTracker.js");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!this.m) {
            boolean a2 = bg.a(this.a, this.v, 2, true);
            this.m = true;
            if (a2) {
                this.C.sendMessage(this.C.obtainMessage(34));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            bq.a().c(this.a, System.currentTimeMillis());
            bo.a(this.a, "mtj_auto.config", str, false);
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
        String a2 = a(this.a);
        if (bd.c().b()) {
            bd.c().a(TextUtils.isEmpty(a2) ? "url:" : "url:" + a2);
        }
        try {
            this.c = new aj(URI.create(a2), new b());
        } catch (Exception e) {
        }
    }

    private boolean p() {
        return this.c != null && this.c.b();
    }

    private String a(Context context) {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair("appKey", "" + this.v));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("appName", bw.h(context)));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
        arrayList.add(new Pair("deviceName", bw.m(context)));
        arrayList.add(new Pair("platform", "Android"));
        arrayList.add(new Pair("model", android.os.Build.MODEL));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("auto", "1"));
        if (!TextUtils.isEmpty(this.x)) {
            arrayList.add(new Pair("token", this.x));
        }
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
        String str = "wss://mtjsocket.baidu.com/app?" + sb.toString();
        this.x = null;
        return str;
    }

    private boolean q() {
        return !TextUtils.isEmpty(this.v);
    }

    private void b(WebView webView, String str, bl blVar) {
        if (blVar != null) {
            blVar.a(webView, str);
        }
    }

    private void c(WebView webView, String str, bl blVar) {
        if (blVar != null) {
            blVar.a(this.d, webView, str, a(this.y, r()), true);
        }
    }

    private String r() {
        if (this.d == null) {
            return null;
        }
        return this.d.getClass().getName();
    }

    private void b(Activity activity, boolean z) {
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
                if (bd.c().b()) {
                    bd.c().a("doSendSnapshot:" + a2.toString());
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
        if (bw.s(this.a) && !this.m) {
            if (this.u == 0) {
                this.u = bq.a().p(this.a);
            }
            if (System.currentTimeMillis() - this.u > 86400000) {
                this.f.sendMessage(this.f.obtainMessage(23));
            }
        }
    }

    private void u() {
        if (bw.s(this.a) && !this.l) {
            if (!this.n) {
                this.q = bo.a(this.a, "mtj_autoTracker.js");
                this.n = true;
            }
            if (this.s == 0) {
                this.s = bq.a().n(this.a);
                this.t = bq.a().o(this.a);
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
                this.y.put(MetaBox.TYPE, jSONObject2);
                this.y.put("data", jSONArray2);
                this.z.put(MetaBox.TYPE, jSONObject2);
                this.z.put("data", jSONArray3);
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
        synchronized (this.G) {
            if (this.a != null) {
                if (str == null) {
                    str = "";
                }
                this.F.put(i + "_" + System.currentTimeMillis() + "_" + ((bw.s(this.a) ? 1 : 0) + "|" + str));
                bo.a(this.a, "trace_circle.data", this.F.toString(), false);
            }
        }
    }

    public JSONArray e() {
        JSONArray jSONArray;
        synchronized (this.G) {
            if (this.a == null) {
                jSONArray = new JSONArray();
            } else {
                String a2 = bo.a(this.a, "trace_circle.data");
                try {
                    jSONArray = !TextUtils.isEmpty(a2) ? new JSONArray(a2) : null;
                } catch (Exception e) {
                    jSONArray = null;
                }
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                this.F = new JSONArray();
                bo.a(this.a, "trace_circle.data", this.F.toString(), false);
            }
        }
        return jSONArray;
    }
}
