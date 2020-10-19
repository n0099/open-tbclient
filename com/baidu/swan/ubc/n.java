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
    private static volatile n dXX;
    private ExecutorService dXY;
    private com.baidu.swan.ubc.c dXZ;
    private com.baidu.swan.ubc.d dXp;
    private int dYa;
    private boolean dYb = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.dYa;
        nVar.dYa = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aZv() {
        if (dXX == null) {
            synchronized (n.class) {
                if (dXX == null) {
                    dXX = new n();
                }
            }
        }
        return dXX;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dYa = com.baidu.swan.config.b.aKs().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dYa > 1073741823) {
                this.dYa -= 1073741823;
            } else {
                this.dYa = 1073741823 + this.dYa;
            }
            if (com.baidu.swan.ubc.e.aYZ() == null || com.baidu.swan.ubc.e.aYZ().adx() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aYZ().adx();
            }
            this.mExecutorService.execute(new g());
            this.dXY = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dXp != null && this.dXp.yl(str)) {
                bVar.hC(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dXp != null && this.dXp.yl(str)) {
                bVar.hC(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean af(String str, int i) {
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
    public synchronized Flow j(String str, String str2, int i) {
        Flow ag;
        ag = ag(str, i);
        if (ag != null && ag.getValid()) {
            d dVar = new d(ag, str2);
            if (this.dXp != null && this.dXp.yl(str)) {
                dVar.hC(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ag;
    }

    Flow ag(String str, int i) {
        Flow flow = new Flow(str, this.dYa, i);
        if (this.dXp != null && !this.dXp.ae(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aYZ().pW(str)) {
            flow.setValid(false);
        } else {
            if (this.dXp != null && this.dXp.yj(str) > 0) {
                if (new Random().nextInt(100) >= this.dXp.yj(str)) {
                    flow.hD(true);
                }
            }
            if (this.dXp != null && this.dXp.yk(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.dYb) {
            this.dYb = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.dXZ != null) {
                        n.this.dXZ.aYQ();
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
        s.L(jSONArray);
        this.dXY.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dXZ != null) {
                    n.this.dXZ.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.dXY.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dXZ != null) {
                    n.this.dXZ.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYT() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dXZ != null) {
                    n.this.dXZ.aYT();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void as(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dXZ != null) {
                    if (z) {
                        n.this.dXZ.yd(str);
                    } else {
                        n.this.dXZ.ye(str);
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
            n.this.dXp = com.baidu.swan.ubc.d.aYV();
            n.this.dXZ = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.dXZ.aYU();
        }
    }

    /* loaded from: classes9.dex */
    private class b implements Runnable {
        private i dYg;

        b(String str, String str2, int i) {
            this.dYg = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dYg = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dYg = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dYg = new i(str, str2, i, str3, j, i2);
        }

        public void hC(boolean z) {
            if (this.dYg != null) {
                this.dYg.hC(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dXZ != null) {
                this.dYg.aZp();
                if (!TextUtils.isEmpty(n.this.dXp.yi(this.dYg.getId()))) {
                    this.dYg.setCategory(n.this.dXp.yi(this.dYg.getId()));
                }
                if ((this.dYg.getOption() & 8) != 0) {
                    n.this.dXZ.b(this.dYg);
                } else {
                    n.this.dXZ.a(this.dYg);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class d implements Runnable {
        private k dYh;

        d(Flow flow, String str) {
            this.dYh = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aZr());
            this.dYh.cz(flow.getStartTime());
            this.dYh.yr("1");
            n.d(n.this);
        }

        public void hC(boolean z) {
            if (this.dYh != null) {
                this.dYh.hC(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dXZ != null) {
                this.dYh.aZp();
                if (!TextUtils.isEmpty(n.this.dXp.yi(this.dYh.getId()))) {
                    this.dYh.setCategory(n.this.dXp.yi(this.dYh.getId()));
                }
                n.this.dXZ.b(this.dYh);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class f implements Runnable {
        private String dXQ;
        private int dXR;
        private String mValue;

        f(String str, int i, String str2) {
            this.dXQ = str;
            this.dXR = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dXZ != null) {
                n.this.dXZ.h(this.dXQ, this.dXR, this.mValue);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class e implements Runnable {
        private String dXQ;
        private int dXR;
        private JSONArray dXW;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dXQ = str;
            this.dXR = i;
            this.dXW = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dXZ != null) {
                n.this.dXZ.a(this.dXQ, this.dXR, this.mEndTime, this.dXW);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class c implements Runnable {
        private String dXQ;
        private int dXR;

        c(String str, int i) {
            this.dXQ = str;
            this.dXR = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dXZ != null) {
                n.this.dXZ.I(this.dXQ, this.dXR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private q dYf;

        a(q qVar) {
            this.dYf = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dXZ != null) {
                n.this.dXZ.a(this.dYf);
            }
        }
    }
}
