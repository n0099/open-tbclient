package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    private static volatile l bpt;
    private com.baidu.swan.ubc.d boZ;
    private ExecutorService bpu;
    private ExecutorService bpv;
    private com.baidu.swan.ubc.c bpw;
    private int bpx;
    private boolean bpy = false;
    private Context mContext;

    static /* synthetic */ int d(l lVar) {
        int i = lVar.bpx;
        lVar.bpx = i + 1;
        return i;
    }

    private l() {
        init(q.getContext());
    }

    public static l Tk() {
        if (bpt == null) {
            synchronized (l.class) {
                if (bpt == null) {
                    bpt = new l();
                }
            }
        }
        return bpt;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpx = com.baidu.swan.a.a.Ne().getInt("ubc_key_flow_handle", 0);
            if (this.bpx > 1073741823) {
                this.bpx -= 1073741823;
            } else {
                this.bpx = 1073741823 + this.bpx;
            }
            this.bpu = Executors.newSingleThreadExecutor();
            this.bpu.execute(new f(this, null));
            this.bpv = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, jSONObject, i);
            if (this.boZ != null && this.boZ.jM(str)) {
                aVar.cV(true);
            }
            this.bpu.execute(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, str2, i);
            if (this.boZ != null && this.boZ.jM(str)) {
                aVar.cV(true);
            }
            this.bpu.execute(aVar);
        }
    }

    boolean P(String str, int i) {
        if (this.boZ == null || this.boZ.O(str, i)) {
            if ((i & 16) == 0 || q.Ts().fu(str)) {
                if (this.boZ != null && this.boZ.jK(str) > 0) {
                    if (new Random().nextInt(100) >= this.boZ.jK(str)) {
                        return true;
                    }
                }
                return this.boZ != null && this.boZ.jL(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpu.execute(new a(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpu.execute(new a(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow i(String str, String str2, int i) {
        Flow Q;
        Q = Q(str, i);
        if (Q != null && Q.getValid()) {
            c cVar = new c(Q, str2);
            if (this.boZ != null && this.boZ.jM(str)) {
                cVar.cV(true);
            }
            this.bpu.execute(cVar);
        }
        return Q;
    }

    Flow Q(String str, int i) {
        Flow flow = new Flow(str, this.bpx, i);
        if (this.boZ != null && !this.boZ.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !q.Ts().fu(str)) {
            flow.setValid(false);
        } else {
            if (this.boZ != null && this.boZ.jK(str) > 0) {
                if (new Random().nextInt(100) >= this.boZ.jK(str)) {
                    flow.setValid(false);
                }
            }
            if (this.boZ != null && this.boZ.jL(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bpu.execute(new e(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.bpu.execute(new d(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        this.bpu.execute(new b(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.ubc.l$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ l bpz;

        @Override // java.lang.Runnable
        public void run() {
            if (this.bpz.bpw != null) {
                this.bpz.bpw.SS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        p.u(jSONArray);
        this.bpv.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpw != null) {
                    l.this.bpw.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final JSONArray jSONArray) {
        p.u(jSONArray);
        this.bpv.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.3
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpw != null) {
                    l.this.bpw.t(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpu.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.4
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpw != null) {
                    if (z) {
                        l.this.bpw.jF(str);
                    } else {
                        l.this.bpw.jG(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(l lVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            l.this.boZ = com.baidu.swan.ubc.d.SW();
            l.this.bpw = new com.baidu.swan.ubc.c(l.this.mContext);
            l.this.bpw.SV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private h bpC;

        a(String str, String str2, int i) {
            this.bpC = new h(str, str2, i);
        }

        a(String str, JSONObject jSONObject, int i) {
            this.bpC = new h(str, jSONObject, i);
        }

        a(String str, String str2, int i, String str3, int i2) {
            this.bpC = new h(str, str2, i, str3, i2);
        }

        a(String str, String str2, int i, String str3, long j, int i2) {
            this.bpC = new h(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.bpC != null) {
                this.bpC.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpw != null) {
                this.bpC.Th();
                if (!TextUtils.isEmpty(l.this.boZ.jJ(this.bpC.getId()))) {
                    this.bpC.setCategory(l.this.boZ.jJ(this.bpC.getId()));
                }
                if ((this.bpC.getOption() & 8) != 0) {
                    l.this.bpw.b(this.bpC);
                } else {
                    l.this.bpw.a(this.bpC);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private i bpD;

        c(Flow flow, String str) {
            this.bpD = new i(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bpD.X(flow.getStartTime());
            this.bpD.jO("1");
            l.d(l.this);
        }

        public void cV(boolean z) {
            if (this.bpD != null) {
                this.bpD.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpw != null) {
                this.bpD.Th();
                if (!TextUtils.isEmpty(l.this.boZ.jJ(this.bpD.getId()))) {
                    this.bpD.setCategory(l.this.boZ.jJ(this.bpD.getId()));
                }
                l.this.bpw.b(this.bpD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aDu;
        private int bpn;
        private String mValue;

        e(String str, int i, String str2) {
            this.aDu = str;
            this.bpn = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpw != null) {
                l.this.bpw.c(this.aDu, this.bpn, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private String aDu;
        private long aEp = System.currentTimeMillis();
        private int bpn;
        private JSONArray bps;

        d(String str, int i, JSONArray jSONArray) {
            this.aDu = str;
            this.bpn = i;
            this.bps = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpw != null) {
                l.this.bpw.a(this.aDu, this.bpn, this.aEp, this.bps);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private String aDu;
        private int bpn;

        b(String str, int i) {
            this.aDu = str;
            this.bpn = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpw != null) {
                l.this.bpw.y(this.aDu, this.bpn);
            }
        }
    }
}
