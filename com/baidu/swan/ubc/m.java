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
    private static volatile m cER;
    private ExecutorService cES;
    private com.baidu.swan.ubc.c cET;
    private int cEU;
    private boolean cEV = false;
    private com.baidu.swan.ubc.d cEq;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.cEU;
        mVar.cEU = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m avD() {
        if (cER == null) {
            synchronized (m.class) {
                if (cER == null) {
                    cER = new m();
                }
            }
        }
        return cER;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.cEU = com.baidu.swan.config.b.aiT().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.cEU > 1073741823) {
                this.cEU -= 1073741823;
            } else {
                this.cEU = 1073741823 + this.cEU;
            }
            if (s.avR() == null || s.avR().HM() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.avR().HM();
            }
            this.mExecutorService.execute(new g());
            this.cES = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!S(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.cEq != null && this.cEq.qU(str)) {
                bVar.fe(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!S(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.cEq != null && this.cEq.qU(str)) {
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
            if (this.cEq != null && this.cEq.qU(str)) {
                dVar.fe(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return T;
    }

    Flow T(String str, int i) {
        Flow flow = new Flow(str, this.cEU, i);
        if (this.cEq != null && !this.cEq.R(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.avR().jJ(str)) {
            flow.setValid(false);
        } else {
            if (this.cEq != null && this.cEq.qS(str) > 0) {
                if (new Random().nextInt(100) >= this.cEq.qS(str)) {
                    flow.ff(true);
                }
            }
            if (this.cEq != null && this.cEq.qT(str)) {
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
        if (!this.cEV) {
            this.cEV = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.cET != null) {
                        m.this.cET.avb();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.mExecutorService.execute(new a(pVar));
    }

    public void initConfig() {
        avE();
        if (!com.baidu.swan.config.b.aiT().getBoolean("init_done", false)) {
            String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(readAssetData)) {
                try {
                    p pVar = new p("0", new JSONObject(readAssetData));
                    pVar.avM();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void avE() {
        o avF = o.avF();
        avF.upload();
        avF.avG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final JSONArray jSONArray, final String str) {
        r.I(jSONArray);
        this.cES.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cET != null) {
                    m.this.cET.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(final JSONArray jSONArray) {
        r.I(jSONArray);
        this.cES.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cET != null) {
                    m.this.cET.H(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ave() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cET != null) {
                    m.this.cET.ave();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cET != null) {
                    if (z) {
                        m.this.cET.qM(str);
                    } else {
                        m.this.cET.qN(str);
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
            m.this.cEq = com.baidu.swan.ubc.d.avg();
            m.this.cET = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.cET.avf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private h cEZ;

        b(String str, String str2, int i) {
            this.cEZ = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.cEZ = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.cEZ = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.cEZ = new h(str, str2, i, str3, j, i2);
        }

        public void fe(boolean z) {
            if (this.cEZ != null) {
                this.cEZ.fe(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cET != null) {
                this.cEZ.avx();
                if (!TextUtils.isEmpty(m.this.cEq.qR(this.cEZ.getId()))) {
                    this.cEZ.setCategory(m.this.cEq.qR(this.cEZ.getId()));
                }
                if ((this.cEZ.getOption() & 8) != 0) {
                    m.this.cET.b(this.cEZ);
                } else {
                    m.this.cET.a(this.cEZ);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private j cFa;

        d(Flow flow, String str) {
            this.cFa = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.avz());
            this.cFa.bm(flow.getStartTime());
            this.cFa.qX("1");
            m.d(m.this);
        }

        public void fe(boolean z) {
            if (this.cFa != null) {
                this.cFa.fe(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cET != null) {
                this.cFa.avx();
                if (!TextUtils.isEmpty(m.this.cEq.qR(this.cFa.getId()))) {
                    this.cFa.setCategory(m.this.cEq.qR(this.cFa.getId()));
                }
                m.this.cET.b(this.cFa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        private String bHp;
        private int cEL;
        private String mValue;

        f(String str, int i, String str2) {
            this.bHp = str;
            this.cEL = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cET != null) {
                m.this.cET.f(this.bHp, this.cEL, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        private String bHp;
        private int cEL;
        private JSONArray cEQ;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.bHp = str;
            this.cEL = i;
            this.cEQ = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cET != null) {
                m.this.cET.a(this.bHp, this.cEL, this.mEndTime, this.cEQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private String bHp;
        private int cEL;

        c(String str, int i) {
            this.bHp = str;
            this.cEL = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cET != null) {
                m.this.cET.u(this.bHp, this.cEL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private p cEY;

        a(p pVar) {
            this.cEY = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cET != null) {
                m.this.cET.a(this.cEY);
                com.baidu.swan.config.b.aiT().putBoolean("init_done", true);
            }
        }
    }
}
