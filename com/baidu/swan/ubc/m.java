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
    private static volatile m bwX;
    private ExecutorService baT;
    private ExecutorService bwY;
    private com.baidu.swan.ubc.c bwZ;
    private com.baidu.swan.ubc.d bwv;
    private int bxa;
    private boolean bxb = false;
    private Context mContext;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.bxa;
        mVar.bxa = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m Yc() {
        if (bwX == null) {
            synchronized (m.class) {
                if (bwX == null) {
                    bwX = new m();
                }
            }
        }
        return bwX;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bxa = com.baidu.swan.a.a.QH().getInt("ubc_key_flow_handle", 0);
            if (this.bxa > 1073741823) {
                this.bxa -= 1073741823;
            } else {
                this.bxa = 1073741823 + this.bxa;
            }
            if (s.Yr() == null || s.Yr().wK() == null) {
                this.baT = Executors.newSingleThreadExecutor();
            } else {
                this.baT = s.Yr().wK();
            }
            this.baT.execute(new g());
            this.bwY = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.bwv != null && this.bwv.kU(str)) {
                bVar.dr(true);
            }
            this.baT.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.bwv != null && this.bwv.kU(str)) {
                bVar.dr(true);
            }
            this.baT.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.baT.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.baT.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow g(String str, String str2, int i) {
        Flow L;
        L = L(str, i);
        if (L != null && L.getValid()) {
            d dVar = new d(L, str2);
            if (this.bwv != null && this.bwv.kU(str)) {
                dVar.dr(true);
            }
            this.baT.execute(dVar);
        }
        return L;
    }

    Flow L(String str, int i) {
        Flow flow = new Flow(str, this.bxa, i);
        if (this.bwv != null && !this.bwv.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.Yr().fQ(str)) {
            flow.setValid(false);
        } else {
            if (this.bwv != null && this.bwv.kS(str) > 0) {
                if (new Random().nextInt(100) >= this.bwv.kS(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bwv != null && this.bwv.kT(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.baT.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.baT.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        this.baT.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Yd() {
        if (!this.bxb) {
            this.bxb = true;
            this.baT.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.bwZ != null) {
                        m.this.bwZ.XB();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.baT.execute(new a(pVar));
    }

    public void initConfig() {
        Ye();
        if (!com.baidu.swan.a.a.QH().getBoolean("init_done", false)) {
            String ad = com.baidu.swan.c.a.ad(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(ad)) {
                try {
                    p pVar = new p("0", new JSONObject(ad));
                    pVar.Ym();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void Ye() {
        o Yf = o.Yf();
        Yf.Yd();
        Yf.Yg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        r.t(jSONArray);
        this.bwY.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwZ != null) {
                    m.this.bwZ.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final JSONArray jSONArray) {
        r.t(jSONArray);
        this.bwY.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwZ != null) {
                    m.this.bwZ.r(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XE() {
        this.baT.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwZ != null) {
                    m.this.bwZ.XE();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(final String str, final boolean z) {
        this.baT.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bwZ != null) {
                    if (z) {
                        m.this.bwZ.kM(str);
                    } else {
                        m.this.bwZ.kN(str);
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
            m.this.bwv = com.baidu.swan.ubc.d.XG();
            m.this.bwZ = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.bwZ.XF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private h bxg;

        b(String str, String str2, int i) {
            this.bxg = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.bxg = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.bxg = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.bxg = new h(str, str2, i, str3, j, i2);
        }

        public void dr(boolean z) {
            if (this.bxg != null) {
                this.bxg.dr(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwZ != null) {
                this.bxg.XY();
                if (!TextUtils.isEmpty(m.this.bwv.kR(this.bxg.getId()))) {
                    this.bxg.setCategory(m.this.bwv.kR(this.bxg.getId()));
                }
                if ((this.bxg.getOption() & 8) != 0) {
                    m.this.bwZ.b(this.bxg);
                } else {
                    m.this.bwZ.a(this.bxg);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class d implements Runnable {
        private j bxh;

        d(Flow flow, String str) {
            this.bxh = new j(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bxh.ai(flow.getStartTime());
            this.bxh.kX("1");
            m.d(m.this);
        }

        public void dr(boolean z) {
            if (this.bxh != null) {
                this.bxh.dr(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwZ != null) {
                this.bxh.XY();
                if (!TextUtils.isEmpty(m.this.bwv.kR(this.bxh.getId()))) {
                    this.bxh.setCategory(m.this.bwv.kR(this.bxh.getId()));
                }
                m.this.bwZ.b(this.bxh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private String aGw;
        private int bwQ;
        private String mValue;

        f(String str, int i, String str2) {
            this.aGw = str;
            this.bwQ = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwZ != null) {
                m.this.bwZ.c(this.aGw, this.bwQ, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aGw;
        private long aHr = System.currentTimeMillis();
        private int bwQ;
        private JSONArray bwW;

        e(String str, int i, JSONArray jSONArray) {
            this.aGw = str;
            this.bwQ = i;
            this.bwW = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwZ != null) {
                m.this.bwZ.a(this.aGw, this.bwQ, this.aHr, this.bwW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private String aGw;
        private int bwQ;

        c(String str, int i) {
            this.aGw = str;
            this.bwQ = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwZ != null) {
                m.this.bwZ.t(this.aGw, this.bwQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private p bxf;

        a(p pVar) {
            this.bxf = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bwZ != null) {
                m.this.bwZ.a(this.bxf);
                com.baidu.swan.a.a.QH().putBoolean("init_done", true);
            }
        }
    }
}
