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
/* loaded from: classes14.dex */
public class n {
    private static volatile n eAm;
    private ExecutorService eAn;
    private com.baidu.swan.ubc.c eAo;
    private int eAp;
    private boolean eAq = false;
    private com.baidu.swan.ubc.d ezE;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.eAp;
        nVar.eAp = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n bff() {
        if (eAm == null) {
            synchronized (n.class) {
                if (eAm == null) {
                    eAm = new n();
                }
            }
        }
        return eAm;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eAp = com.baidu.swan.config.b.aQh().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.eAp > 1073741823) {
                this.eAp -= 1073741823;
            } else {
                this.eAp = 1073741823 + this.eAp;
            }
            if (com.baidu.swan.ubc.e.beJ() == null || com.baidu.swan.ubc.e.beJ().aih() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.beJ().aih();
            }
            this.mExecutorService.execute(new g());
            this.eAn = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!an(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ezE != null && this.ezE.yI(str)) {
                bVar.iJ(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        if (!an(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ezE != null && this.ezE.yI(str)) {
                bVar.iJ(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean an(String str, int i) {
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
    public synchronized Flow n(String str, String str2, int i) {
        Flow ao;
        ao = ao(str, i);
        if (ao != null && ao.getValid()) {
            d dVar = new d(ao, str2);
            if (this.ezE != null && this.ezE.yI(str)) {
                dVar.iJ(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ao;
    }

    Flow ao(String str, int i) {
        Flow flow = new Flow(str, this.eAp, i);
        if (this.ezE != null && !this.ezE.am(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.beJ().ql(str)) {
            flow.setValid(false);
        } else {
            if (this.ezE != null && this.ezE.yG(str) > 0) {
                if (new Random().nextInt(100) >= this.ezE.yG(str)) {
                    flow.iK(true);
                }
            }
            if (this.ezE != null && this.ezE.yH(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.eAq) {
            this.eAq = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.eAo != null) {
                        n.this.eAo.beA();
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
        this.eAn.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eAo != null) {
                    n.this.eAo.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.eAn.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eAo != null) {
                    n.this.eAo.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beD() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eAo != null) {
                    n.this.eAo.beD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eAo != null) {
                    if (z) {
                        n.this.eAo.yA(str);
                    } else {
                        n.this.eAo.yB(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.ezE = com.baidu.swan.ubc.d.beF();
            n.this.eAo = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.eAo.beE();
        }
    }

    /* loaded from: classes14.dex */
    private class b implements Runnable {
        private i eAv;

        b(String str, String str2, int i) {
            this.eAv = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.eAv = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.eAv = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.eAv = new i(str, str2, i, str3, j, i2);
        }

        public void iJ(boolean z) {
            if (this.eAv != null) {
                this.eAv.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eAo != null) {
                this.eAv.beZ();
                if (!TextUtils.isEmpty(n.this.ezE.yF(this.eAv.getId()))) {
                    this.eAv.setCategory(n.this.ezE.yF(this.eAv.getId()));
                }
                if ((this.eAv.getOption() & 8) != 0) {
                    n.this.eAo.b(this.eAv);
                } else {
                    n.this.eAo.a(this.eAv);
                }
            }
        }
    }

    /* loaded from: classes14.dex */
    private class d implements Runnable {
        private k eAw;

        d(Flow flow, String str) {
            this.eAw = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.bfb());
            this.eAw.dC(flow.getStartTime());
            this.eAw.yO("1");
            n.d(n.this);
        }

        public void iJ(boolean z) {
            if (this.eAw != null) {
                this.eAw.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eAo != null) {
                this.eAw.beZ();
                if (!TextUtils.isEmpty(n.this.ezE.yF(this.eAw.getId()))) {
                    this.eAw.setCategory(n.this.ezE.yF(this.eAw.getId()));
                }
                n.this.eAo.b(this.eAw);
            }
        }
    }

    /* loaded from: classes14.dex */
    private class f implements Runnable {
        private String eAf;
        private int eAg;
        private String mValue;

        f(String str, int i, String str2) {
            this.eAf = str;
            this.eAg = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eAo != null) {
                n.this.eAo.i(this.eAf, this.eAg, this.mValue);
            }
        }
    }

    /* loaded from: classes14.dex */
    private class e implements Runnable {
        private String eAf;
        private int eAg;
        private JSONArray eAl;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eAf = str;
            this.eAg = i;
            this.eAl = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eAo != null) {
                n.this.eAo.a(this.eAf, this.eAg, this.mEndTime, this.eAl);
            }
        }
    }

    /* loaded from: classes14.dex */
    private class c implements Runnable {
        private String eAf;
        private int eAg;

        c(String str, int i) {
            this.eAf = str;
            this.eAg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eAo != null) {
                n.this.eAo.P(this.eAf, this.eAg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a implements Runnable {
        private q eAu;

        a(q qVar) {
            this.eAu = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eAo != null) {
                n.this.eAo.a(this.eAu);
            }
        }
    }
}
