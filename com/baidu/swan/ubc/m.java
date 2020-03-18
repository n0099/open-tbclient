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
    private static volatile m cFe;
    private com.baidu.swan.ubc.d cED;
    private ExecutorService cFf;
    private com.baidu.swan.ubc.c cFg;
    private int cFh;
    private boolean cFi = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.cFh;
        mVar.cFh = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m avI() {
        if (cFe == null) {
            synchronized (m.class) {
                if (cFe == null) {
                    cFe = new m();
                }
            }
        }
        return cFe;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.cFh = com.baidu.swan.config.b.aiY().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.cFh > 1073741823) {
                this.cFh -= 1073741823;
            } else {
                this.cFh = 1073741823 + this.cFh;
            }
            if (s.avW() == null || s.avW().HR() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.avW().HR();
            }
            this.mExecutorService.execute(new g());
            this.cFf = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!S(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.cED != null && this.cED.qT(str)) {
                bVar.ff(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!S(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.cED != null && this.cED.qT(str)) {
                bVar.ff(true);
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
            if (this.cED != null && this.cED.qT(str)) {
                dVar.ff(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return T;
    }

    Flow T(String str, int i) {
        Flow flow = new Flow(str, this.cFh, i);
        if (this.cED != null && !this.cED.R(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.avW().jI(str)) {
            flow.setValid(false);
        } else {
            if (this.cED != null && this.cED.qR(str) > 0) {
                if (new Random().nextInt(100) >= this.cED.qR(str)) {
                    flow.fg(true);
                }
            }
            if (this.cED != null && this.cED.qS(str)) {
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
        if (!this.cFi) {
            this.cFi = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.cFg != null) {
                        m.this.cFg.avg();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.mExecutorService.execute(new a(pVar));
    }

    public void initConfig() {
        avJ();
        if (!com.baidu.swan.config.b.aiY().getBoolean("init_done", false)) {
            String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(readAssetData)) {
                try {
                    p pVar = new p("0", new JSONObject(readAssetData));
                    pVar.avR();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void avJ() {
        o avK = o.avK();
        avK.upload();
        avK.avL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final JSONArray jSONArray, final String str) {
        r.I(jSONArray);
        this.cFf.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cFg != null) {
                    m.this.cFg.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(final JSONArray jSONArray) {
        r.I(jSONArray);
        this.cFf.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cFg != null) {
                    m.this.cFg.H(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avj() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cFg != null) {
                    m.this.cFg.avj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cFg != null) {
                    if (z) {
                        m.this.cFg.qL(str);
                    } else {
                        m.this.cFg.qM(str);
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
            m.this.cED = com.baidu.swan.ubc.d.avl();
            m.this.cFg = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.cFg.avk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private h cFm;

        b(String str, String str2, int i) {
            this.cFm = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.cFm = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.cFm = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.cFm = new h(str, str2, i, str3, j, i2);
        }

        public void ff(boolean z) {
            if (this.cFm != null) {
                this.cFm.ff(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cFg != null) {
                this.cFm.avC();
                if (!TextUtils.isEmpty(m.this.cED.qQ(this.cFm.getId()))) {
                    this.cFm.setCategory(m.this.cED.qQ(this.cFm.getId()));
                }
                if ((this.cFm.getOption() & 8) != 0) {
                    m.this.cFg.b(this.cFm);
                } else {
                    m.this.cFg.a(this.cFm);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private j cFn;

        d(Flow flow, String str) {
            this.cFn = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.avE());
            this.cFn.bm(flow.getStartTime());
            this.cFn.qW("1");
            m.d(m.this);
        }

        public void ff(boolean z) {
            if (this.cFn != null) {
                this.cFn.ff(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cFg != null) {
                this.cFn.avC();
                if (!TextUtils.isEmpty(m.this.cED.qQ(this.cFn.getId()))) {
                    this.cFn.setCategory(m.this.cED.qQ(this.cFn.getId()));
                }
                m.this.cFg.b(this.cFn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        private String bHC;
        private int cEY;
        private String mValue;

        f(String str, int i, String str2) {
            this.bHC = str;
            this.cEY = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cFg != null) {
                m.this.cFg.f(this.bHC, this.cEY, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        private String bHC;
        private int cEY;
        private JSONArray cFd;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.bHC = str;
            this.cEY = i;
            this.cFd = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cFg != null) {
                m.this.cFg.a(this.bHC, this.cEY, this.mEndTime, this.cFd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private String bHC;
        private int cEY;

        c(String str, int i) {
            this.bHC = str;
            this.cEY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cFg != null) {
                m.this.cFg.u(this.bHC, this.cEY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private p cFl;

        a(p pVar) {
            this.cFl = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cFg != null) {
                m.this.cFg.a(this.cFl);
                com.baidu.swan.config.b.aiY().putBoolean("init_done", true);
            }
        }
    }
}
