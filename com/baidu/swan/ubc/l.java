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
    private static volatile l bpx;
    private com.baidu.swan.ubc.c bpA;
    private int bpB;
    private boolean bpC = false;
    private com.baidu.swan.ubc.d bpd;
    private ExecutorService bpy;
    private ExecutorService bpz;
    private Context mContext;

    static /* synthetic */ int d(l lVar) {
        int i = lVar.bpB;
        lVar.bpB = i + 1;
        return i;
    }

    private l() {
        init(q.getContext());
    }

    public static l Ti() {
        if (bpx == null) {
            synchronized (l.class) {
                if (bpx == null) {
                    bpx = new l();
                }
            }
        }
        return bpx;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpB = com.baidu.swan.a.a.Nc().getInt("ubc_key_flow_handle", 0);
            if (this.bpB > 1073741823) {
                this.bpB -= 1073741823;
            } else {
                this.bpB = 1073741823 + this.bpB;
            }
            this.bpy = Executors.newSingleThreadExecutor();
            this.bpy.execute(new f(this, null));
            this.bpz = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, jSONObject, i);
            if (this.bpd != null && this.bpd.jN(str)) {
                aVar.cV(true);
            }
            this.bpy.execute(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, str2, i);
            if (this.bpd != null && this.bpd.jN(str)) {
                aVar.cV(true);
            }
            this.bpy.execute(aVar);
        }
    }

    boolean P(String str, int i) {
        if (this.bpd == null || this.bpd.O(str, i)) {
            if ((i & 16) == 0 || q.Tq().fv(str)) {
                if (this.bpd != null && this.bpd.jL(str) > 0) {
                    if (new Random().nextInt(100) >= this.bpd.jL(str)) {
                        return true;
                    }
                }
                return this.bpd != null && this.bpd.jM(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpy.execute(new a(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpy.execute(new a(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow i(String str, String str2, int i) {
        Flow Q;
        Q = Q(str, i);
        if (Q != null && Q.getValid()) {
            c cVar = new c(Q, str2);
            if (this.bpd != null && this.bpd.jN(str)) {
                cVar.cV(true);
            }
            this.bpy.execute(cVar);
        }
        return Q;
    }

    Flow Q(String str, int i) {
        Flow flow = new Flow(str, this.bpB, i);
        if (this.bpd != null && !this.bpd.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !q.Tq().fv(str)) {
            flow.setValid(false);
        } else {
            if (this.bpd != null && this.bpd.jL(str) > 0) {
                if (new Random().nextInt(100) >= this.bpd.jL(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bpd != null && this.bpd.jM(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bpy.execute(new e(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.bpy.execute(new d(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        this.bpy.execute(new b(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.ubc.l$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ l bpD;

        @Override // java.lang.Runnable
        public void run() {
            if (this.bpD.bpA != null) {
                this.bpD.bpA.SQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        p.u(jSONArray);
        this.bpz.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpA != null) {
                    l.this.bpA.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final JSONArray jSONArray) {
        p.u(jSONArray);
        this.bpz.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.3
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpA != null) {
                    l.this.bpA.t(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpy.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.4
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpA != null) {
                    if (z) {
                        l.this.bpA.jG(str);
                    } else {
                        l.this.bpA.jH(str);
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
            l.this.bpd = com.baidu.swan.ubc.d.SU();
            l.this.bpA = new com.baidu.swan.ubc.c(l.this.mContext);
            l.this.bpA.ST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private h bpG;

        a(String str, String str2, int i) {
            this.bpG = new h(str, str2, i);
        }

        a(String str, JSONObject jSONObject, int i) {
            this.bpG = new h(str, jSONObject, i);
        }

        a(String str, String str2, int i, String str3, int i2) {
            this.bpG = new h(str, str2, i, str3, i2);
        }

        a(String str, String str2, int i, String str3, long j, int i2) {
            this.bpG = new h(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.bpG != null) {
                this.bpG.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpA != null) {
                this.bpG.Tf();
                if (!TextUtils.isEmpty(l.this.bpd.jK(this.bpG.getId()))) {
                    this.bpG.setCategory(l.this.bpd.jK(this.bpG.getId()));
                }
                if ((this.bpG.getOption() & 8) != 0) {
                    l.this.bpA.b(this.bpG);
                } else {
                    l.this.bpA.a(this.bpG);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private i bpH;

        c(Flow flow, String str) {
            this.bpH = new i(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bpH.X(flow.getStartTime());
            this.bpH.jP("1");
            l.d(l.this);
        }

        public void cV(boolean z) {
            if (this.bpH != null) {
                this.bpH.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpA != null) {
                this.bpH.Tf();
                if (!TextUtils.isEmpty(l.this.bpd.jK(this.bpH.getId()))) {
                    this.bpH.setCategory(l.this.bpd.jK(this.bpH.getId()));
                }
                l.this.bpA.b(this.bpH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aDy;
        private int bpr;
        private String mValue;

        e(String str, int i, String str2) {
            this.aDy = str;
            this.bpr = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpA != null) {
                l.this.bpA.c(this.aDy, this.bpr, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private String aDy;
        private long aEt = System.currentTimeMillis();
        private int bpr;
        private JSONArray bpw;

        d(String str, int i, JSONArray jSONArray) {
            this.aDy = str;
            this.bpr = i;
            this.bpw = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpA != null) {
                l.this.bpA.a(this.aDy, this.bpr, this.aEt, this.bpw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private String aDy;
        private int bpr;

        b(String str, int i) {
            this.aDy = str;
            this.bpr = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpA != null) {
                l.this.bpA.y(this.aDy, this.bpr);
            }
        }
    }
}
