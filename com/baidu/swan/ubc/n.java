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
/* loaded from: classes11.dex */
public class n {
    private static volatile n duQ;
    private ExecutorService duR;
    private com.baidu.swan.ubc.c duS;
    private int duT;
    private boolean duU = false;
    private com.baidu.swan.ubc.d dui;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.duT;
        nVar.duT = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aJJ() {
        if (duQ == null) {
            synchronized (n.class) {
                if (duQ == null) {
                    duQ = new n();
                }
            }
        }
        return duQ;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.duT = com.baidu.swan.config.b.awc().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.duT > 1073741823) {
                this.duT -= 1073741823;
            } else {
                this.duT = 1073741823 + this.duT;
            }
            if (com.baidu.swan.ubc.e.aJn() == null || com.baidu.swan.ubc.e.aJn().Tz() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aJn().Tz();
            }
            this.mExecutorService.execute(new g());
            this.duR = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dui != null && this.dui.tR(str)) {
                bVar.gs(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dui != null && this.dui.tR(str)) {
                bVar.gs(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ab(String str, int i) {
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
        Flow ac;
        ac = ac(str, i);
        if (ac != null && ac.getValid()) {
            d dVar = new d(ac, str2);
            if (this.dui != null && this.dui.tR(str)) {
                dVar.gs(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ac;
    }

    Flow ac(String str, int i) {
        Flow flow = new Flow(str, this.duT, i);
        if (this.dui != null && !this.dui.aa(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aJn().mr(str)) {
            flow.setValid(false);
        } else {
            if (this.dui != null && this.dui.tP(str) > 0) {
                if (new Random().nextInt(100) >= this.dui.tP(str)) {
                    flow.gt(true);
                }
            }
            if (this.dui != null && this.dui.tQ(str)) {
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
        if (!this.duU) {
            this.duU = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.duS != null) {
                        n.this.duS.aJe();
                    }
                }
            });
        }
    }

    public void b(q qVar) {
        this.mExecutorService.execute(new a(qVar));
    }

    public void initConfig() {
        aJK();
    }

    private void aJK() {
        p aJL = p.aJL();
        aJL.upload();
        aJL.aJM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(final JSONArray jSONArray, final String str) {
        s.I(jSONArray);
        this.duR.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.duS != null) {
                    n.this.duS.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(final JSONArray jSONArray) {
        s.I(jSONArray);
        this.duR.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.duS != null) {
                    n.this.duS.H(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJh() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.duS != null) {
                    n.this.duS.aJh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.duS != null) {
                    if (z) {
                        n.this.duS.tJ(str);
                    } else {
                        n.this.duS.tK(str);
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
            n.this.dui = com.baidu.swan.ubc.d.aJj();
            n.this.duS = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.duS.aJi();
        }
    }

    /* loaded from: classes11.dex */
    private class b implements Runnable {
        private i duY;

        b(String str, String str2, int i) {
            this.duY = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.duY = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.duY = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.duY = new i(str, str2, i, str3, j, i2);
        }

        public void gs(boolean z) {
            if (this.duY != null) {
                this.duY.gs(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.duS != null) {
                this.duY.aJD();
                if (!TextUtils.isEmpty(n.this.dui.tO(this.duY.getId()))) {
                    this.duY.setCategory(n.this.dui.tO(this.duY.getId()));
                }
                if ((this.duY.getOption() & 8) != 0) {
                    n.this.duS.b(this.duY);
                } else {
                    n.this.duS.a(this.duY);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private k duZ;

        d(Flow flow, String str) {
            this.duZ = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aJF());
            this.duZ.bR(flow.getStartTime());
            this.duZ.tX("1");
            n.d(n.this);
        }

        public void gs(boolean z) {
            if (this.duZ != null) {
                this.duZ.gs(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.duS != null) {
                this.duZ.aJD();
                if (!TextUtils.isEmpty(n.this.dui.tO(this.duZ.getId()))) {
                    this.duZ.setCategory(n.this.dui.tO(this.duZ.getId()));
                }
                n.this.duS.b(this.duZ);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class f implements Runnable {
        private String duJ;
        private int duK;
        private String mValue;

        f(String str, int i, String str2) {
            this.duJ = str;
            this.duK = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.duS != null) {
                n.this.duS.f(this.duJ, this.duK, this.mValue);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class e implements Runnable {
        private String duJ;
        private int duK;
        private JSONArray duP;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.duJ = str;
            this.duK = i;
            this.duP = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.duS != null) {
                n.this.duS.a(this.duJ, this.duK, this.mEndTime, this.duP);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c implements Runnable {
        private String duJ;
        private int duK;

        c(String str, int i) {
            this.duJ = str;
            this.duK = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.duS != null) {
                n.this.duS.G(this.duJ, this.duK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private q duX;

        a(q qVar) {
            this.duX = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.duS != null) {
                n.this.duS.a(this.duX);
            }
        }
    }
}
