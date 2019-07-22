package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    private static volatile m bwz;
    private ExecutorService bav;
    private com.baidu.swan.ubc.d bvX;
    private ExecutorService bwA;
    private com.baidu.swan.ubc.c bwB;
    private int bwC;
    private boolean bwD = false;
    private Context mContext;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.bwC;
        mVar.bwC = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m XY() {
        if (bwz == null) {
            synchronized (m.class) {
                if (bwz == null) {
                    bwz = new m();
                }
            }
        }
        return bwz;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bwC = com.baidu.swan.a.a.QD().getInt("ubc_key_flow_handle", 0);
            if (this.bwC > 1073741823) {
                this.bwC -= 1073741823;
            } else {
                this.bwC = 1073741823 + this.bwC;
            }
            if (s.Yn() == null || s.Yn().wG() == null) {
                this.bav = Executors.newSingleThreadExecutor();
            } else {
                this.bav = s.Yn().wG();
            }
            this.bav.execute(new g());
            this.bwA = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.bvX != null && this.bvX.kS(str)) {
                bVar.dr(true);
            }
            this.bav.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.bvX != null && this.bvX.kS(str)) {
                bVar.dr(true);
            }
            this.bav.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.bav.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bav.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow g(String str, String str2, int i) {
        Flow L;
        L = L(str, i);
        if (L != null && L.getValid()) {
            d dVar = new d(L, str2);
            if (this.bvX != null && this.bvX.kS(str)) {
                dVar.dr(true);
            }
            this.bav.execute(dVar);
        }
        return L;
    }

    Flow L(String str, int i) {
        Flow flow = new Flow(str, this.bwC, i);
        if (this.bvX != null && !this.bvX.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.Yn().fO(str)) {
            flow.setValid(false);
        } else {
            if (this.bvX != null && this.bvX.kQ(str) > 0) {
                if (new Random().nextInt(100) >= this.bvX.kQ(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bvX != null && this.bvX.kR(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bav.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.bav.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        this.bav.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XZ() {
        if (!this.bwD) {
            this.bwD = true;
            this.bav.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.bwB != null) {
                        m.this.bwB.Xx();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.bav.execute(new a(pVar));
    }

    public void initConfig() {
        Ya();
        if (!com.baidu.swan.a.a.QD().getBoolean("init_done", false)) {
            String ad = com.baidu.swan.c.a.ad(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(ad)) {
                try {
                    p pVar = new p("0", new JSONObject(ad));
                    pVar.Yi();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void Ya() {
        o Yb = o.Yb();
        Yb.XZ();
        Yb.Yc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        r.t(jSONArray);
        this.bwA.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwB != null) {
                    m.this.bwB.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final JSONArray jSONArray) {
        r.t(jSONArray);
        this.bwA.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwB != null) {
                    m.this.bwB.r(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XA() {
        this.bav.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwB != null) {
                    m.this.bwB.XA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(final String str, final boolean z) {
        this.bav.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwB != null) {
                    if (z) {
                        m.this.bwB.kK(str);
                    } else {
                        m.this.bwB.kL(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            m.this.bvX = com.baidu.swan.ubc.d.XC();
            m.this.bwB = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.bwB.XB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private h bwI;

        b(String str, String str2, int i) {
            this.bwI = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.bwI = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.bwI = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.bwI = new h(str, str2, i, str3, j, i2);
        }

        public void dr(boolean z) {
            if (this.bwI != null) {
                this.bwI.dr(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwB != null) {
                this.bwI.XU();
                if (!TextUtils.isEmpty(m.this.bvX.kP(this.bwI.getId()))) {
                    this.bwI.setCategory(m.this.bvX.kP(this.bwI.getId()));
                }
                if ((this.bwI.getOption() & 8) != 0) {
                    m.this.bwB.b(this.bwI);
                } else {
                    m.this.bwB.a(this.bwI);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class d implements Runnable {
        private j bwJ;

        d(Flow flow, String str) {
            this.bwJ = new j(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bwJ.ai(flow.getStartTime());
            this.bwJ.kV("1");
            m.d(m.this);
        }

        public void dr(boolean z) {
            if (this.bwJ != null) {
                this.bwJ.dr(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwB != null) {
                this.bwJ.XU();
                if (!TextUtils.isEmpty(m.this.bvX.kP(this.bwJ.getId()))) {
                    this.bwJ.setCategory(m.this.bvX.kP(this.bwJ.getId()));
                }
                m.this.bwB.b(this.bwJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private String aFY;
        private int bws;
        private String mValue;

        f(String str, int i, String str2) {
            this.aFY = str;
            this.bws = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwB != null) {
                m.this.bwB.c(this.aFY, this.bws, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aFY;
        private long aGT = System.currentTimeMillis();
        private int bws;
        private JSONArray bwy;

        e(String str, int i, JSONArray jSONArray) {
            this.aFY = str;
            this.bws = i;
            this.bwy = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwB != null) {
                m.this.bwB.a(this.aFY, this.bws, this.aGT, this.bwy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private String aFY;
        private int bws;

        c(String str, int i) {
            this.aFY = str;
            this.bws = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwB != null) {
                m.this.bwB.t(this.aFY, this.bws);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private p bwH;

        a(p pVar) {
            this.bwH = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwB != null) {
                m.this.bwB.a(this.bwH);
                com.baidu.swan.a.a.QD().putBoolean("init_done", true);
            }
        }
    }
}
