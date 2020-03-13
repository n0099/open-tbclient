package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class m {
    private static volatile m cET;
    private ExecutorService cEU;
    private com.baidu.swan.ubc.c cEV;
    private int cEW;
    private boolean cEX = false;
    private com.baidu.swan.ubc.d cEs;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.cEW;
        mVar.cEW = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m avF() {
        if (cET == null) {
            synchronized (m.class) {
                if (cET == null) {
                    cET = new m();
                }
            }
        }
        return cET;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.cEW = com.baidu.swan.config.b.aiV().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.cEW > 1073741823) {
                this.cEW -= 1073741823;
            } else {
                this.cEW = 1073741823 + this.cEW;
            }
            if (s.avT() == null || s.avT().HO() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.avT().HO();
            }
            this.mExecutorService.execute(new g());
            this.cEU = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!S(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.cEs != null && this.cEs.qU(str)) {
                bVar.fe(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!S(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.cEs != null && this.cEs.qU(str)) {
                bVar.fe(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean S(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.mExecutorService.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.mExecutorService.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow j(String str, String str2, int i) {
        Flow T;
        T = T(str, i);
        if (T != null && T.getValid()) {
            d dVar = new d(T, str2);
            if (this.cEs != null && this.cEs.qU(str)) {
                dVar.fe(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return T;
    }

    Flow T(String str, int i) {
        Flow flow = new Flow(str, this.cEW, i);
        if (this.cEs != null && !this.cEs.R(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.avT().jJ(str)) {
            flow.setValid(false);
        } else {
            if (this.cEs != null && this.cEs.qS(str) > 0) {
                if (new Random().nextInt(100) >= this.cEs.qS(str)) {
                    flow.ff(true);
                }
            }
            if (this.cEs != null && this.cEs.qT(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.cEX) {
            this.cEX = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.cEV != null) {
                        m.this.cEV.avd();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.mExecutorService.execute(new a(pVar));
    }

    public void initConfig() {
        avG();
        if (!com.baidu.swan.config.b.aiV().getBoolean("init_done", false)) {
            String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(readAssetData)) {
                try {
                    p pVar = new p("0", new JSONObject(readAssetData));
                    pVar.avO();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void avG() {
        o avH = o.avH();
        avH.upload();
        avH.avI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final JSONArray jSONArray, final String str) {
        r.I(jSONArray);
        this.cEU.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cEV != null) {
                    m.this.cEV.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(final JSONArray jSONArray) {
        r.I(jSONArray);
        this.cEU.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cEV != null) {
                    m.this.cEV.H(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avg() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cEV != null) {
                    m.this.cEV.avg();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cEV != null) {
                    if (z) {
                        m.this.cEV.qM(str);
                    } else {
                        m.this.cEV.qN(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            m.this.cEs = com.baidu.swan.ubc.d.avi();
            m.this.cEV = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.cEV.avh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private h cFb;

        b(String str, String str2, int i) {
            this.cFb = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.cFb = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.cFb = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.cFb = new h(str, str2, i, str3, j, i2);
        }

        public void fe(boolean z) {
            if (this.cFb != null) {
                this.cFb.fe(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cEV != null) {
                this.cFb.avz();
                if (!TextUtils.isEmpty(m.this.cEs.qR(this.cFb.getId()))) {
                    this.cFb.setCategory(m.this.cEs.qR(this.cFb.getId()));
                }
                if ((this.cFb.getOption() & 8) != 0) {
                    m.this.cEV.b(this.cFb);
                } else {
                    m.this.cEV.a(this.cFb);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private j cFc;

        d(Flow flow, String str) {
            this.cFc = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.avB());
            this.cFc.bm(flow.getStartTime());
            this.cFc.qX("1");
            m.d(m.this);
        }

        public void fe(boolean z) {
            if (this.cFc != null) {
                this.cFc.fe(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cEV != null) {
                this.cFc.avz();
                if (!TextUtils.isEmpty(m.this.cEs.qR(this.cFc.getId()))) {
                    this.cFc.setCategory(m.this.cEs.qR(this.cFc.getId()));
                }
                m.this.cEV.b(this.cFc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        private String bHr;
        private int cEN;
        private String mValue;

        f(String str, int i, String str2) {
            this.bHr = str;
            this.cEN = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cEV != null) {
                m.this.cEV.f(this.bHr, this.cEN, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        private String bHr;
        private int cEN;
        private JSONArray cES;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.bHr = str;
            this.cEN = i;
            this.cES = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cEV != null) {
                m.this.cEV.a(this.bHr, this.cEN, this.mEndTime, this.cES);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private String bHr;
        private int cEN;

        c(String str, int i) {
            this.bHr = str;
            this.cEN = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cEV != null) {
                m.this.cEV.u(this.bHr, this.cEN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private p cFa;

        a(p pVar) {
            this.cFa = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cEV != null) {
                m.this.cEV.a(this.cFa);
                com.baidu.swan.config.b.aiV().putBoolean("init_done", true);
            }
        }
    }
}
