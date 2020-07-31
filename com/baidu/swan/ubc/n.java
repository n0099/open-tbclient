package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class n {
    private static volatile n dAF;
    private ExecutorService dAG;
    private com.baidu.swan.ubc.c dAH;
    private int dAI;
    private boolean dAJ = false;
    private com.baidu.swan.ubc.d dzX;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.dAI;
        nVar.dAI = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aNB() {
        if (dAF == null) {
            synchronized (n.class) {
                if (dAF == null) {
                    dAF = new n();
                }
            }
        }
        return dAF;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dAI = com.baidu.swan.config.b.ayQ().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dAI > 1073741823) {
                this.dAI -= 1073741823;
            } else {
                this.dAI = 1073741823 + this.dAI;
            }
            if (com.baidu.swan.ubc.e.aNf() == null || com.baidu.swan.ubc.e.aNf().TZ() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aNf().TZ();
            }
            this.mExecutorService.execute(new g());
            this.dAG = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ac(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dzX != null && this.dzX.uU(str)) {
                bVar.gN(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!ac(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dzX != null && this.dzX.uU(str)) {
                bVar.gN(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ac(String str, int i) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
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
    public synchronized Flow i(String str, String str2, int i) {
        Flow ad;
        ad = ad(str, i);
        if (ad != null && ad.getValid()) {
            d dVar = new d(ad, str2);
            if (this.dzX != null && this.dzX.uU(str)) {
                dVar.gN(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ad;
    }

    Flow ad(String str, int i) {
        Flow flow = new Flow(str, this.dAI, i);
        if (this.dzX != null && !this.dzX.ab(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aNf().mR(str)) {
            flow.setValid(false);
        } else {
            if (this.dzX != null && this.dzX.uS(str) > 0) {
                if (new Random().nextInt(100) >= this.dzX.uS(str)) {
                    flow.gO(true);
                }
            }
            if (this.dzX != null && this.dzX.uT(str)) {
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
    public void G(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.dAJ) {
            this.dAJ = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.dAH != null) {
                        n.this.dAH.aMW();
                    }
                }
            });
        }
    }

    public void b(q qVar) {
        this.mExecutorService.execute(new a(qVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(final JSONArray jSONArray, final String str) {
        s.J(jSONArray);
        this.dAG.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dAH != null) {
                    n.this.dAH.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(final JSONArray jSONArray) {
        s.J(jSONArray);
        this.dAG.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dAH != null) {
                    n.this.dAH.I(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMZ() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dAH != null) {
                    n.this.dAH.aMZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ak(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dAH != null) {
                    if (z) {
                        n.this.dAH.uM(str);
                    } else {
                        n.this.dAH.uN(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.dzX = com.baidu.swan.ubc.d.aNb();
            n.this.dAH = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.dAH.aNa();
        }
    }

    /* loaded from: classes9.dex */
    private class b implements Runnable {
        private i dAN;

        b(String str, String str2, int i) {
            this.dAN = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dAN = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dAN = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dAN = new i(str, str2, i, str3, j, i2);
        }

        public void gN(boolean z) {
            if (this.dAN != null) {
                this.dAN.gN(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dAH != null) {
                this.dAN.aNv();
                if (!TextUtils.isEmpty(n.this.dzX.uR(this.dAN.getId()))) {
                    this.dAN.setCategory(n.this.dzX.uR(this.dAN.getId()));
                }
                if ((this.dAN.getOption() & 8) != 0) {
                    n.this.dAH.b(this.dAN);
                } else {
                    n.this.dAH.a(this.dAN);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class d implements Runnable {
        private k dAO;

        d(Flow flow, String str) {
            this.dAO = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aNx());
            this.dAO.cg(flow.getStartTime());
            this.dAO.va("1");
            n.d(n.this);
        }

        public void gN(boolean z) {
            if (this.dAO != null) {
                this.dAO.gN(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dAH != null) {
                this.dAO.aNv();
                if (!TextUtils.isEmpty(n.this.dzX.uR(this.dAO.getId()))) {
                    this.dAO.setCategory(n.this.dzX.uR(this.dAO.getId()));
                }
                n.this.dAH.b(this.dAO);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class f implements Runnable {
        private String dAy;
        private int dAz;
        private String mValue;

        f(String str, int i, String str2) {
            this.dAy = str;
            this.dAz = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dAH != null) {
                n.this.dAH.f(this.dAy, this.dAz, this.mValue);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class e implements Runnable {
        private JSONArray dAE;
        private String dAy;
        private int dAz;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dAy = str;
            this.dAz = i;
            this.dAE = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dAH != null) {
                n.this.dAH.a(this.dAy, this.dAz, this.mEndTime, this.dAE);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class c implements Runnable {
        private String dAy;
        private int dAz;

        c(String str, int i) {
            this.dAy = str;
            this.dAz = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dAH != null) {
                n.this.dAH.G(this.dAy, this.dAz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private q dAM;

        a(q qVar) {
            this.dAM = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dAH != null) {
                n.this.dAH.a(this.dAM);
            }
        }
    }
}
