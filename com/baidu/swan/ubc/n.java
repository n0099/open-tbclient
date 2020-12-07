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
/* loaded from: classes17.dex */
public class n {
    private static volatile n erH;
    private com.baidu.swan.ubc.d eqY;
    private ExecutorService erI;
    private com.baidu.swan.ubc.c erJ;
    private int erK;
    private boolean erL = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.erK;
        nVar.erK = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n bgm() {
        if (erH == null) {
            synchronized (n.class) {
                if (erH == null) {
                    erH = new n();
                }
            }
        }
        return erH;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.erK = com.baidu.swan.config.b.aRj().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.erK > 1073741823) {
                this.erK -= 1073741823;
            } else {
                this.erK = 1073741823 + this.erK;
            }
            if (com.baidu.swan.ubc.e.bfQ() == null || com.baidu.swan.ubc.e.bfQ().akr() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.bfQ().akr();
            }
            this.mExecutorService.execute(new g());
            this.erI = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ai(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.eqY != null && this.eqY.zu(str)) {
                bVar.iq(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        if (!ai(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.eqY != null && this.eqY.zu(str)) {
                bVar.iq(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ai(String str, int i) {
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
    public synchronized Flow k(String str, String str2, int i) {
        Flow aj;
        aj = aj(str, i);
        if (aj != null && aj.getValid()) {
            d dVar = new d(aj, str2);
            if (this.eqY != null && this.eqY.zu(str)) {
                dVar.iq(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return aj;
    }

    Flow aj(String str, int i) {
        Flow flow = new Flow(str, this.erK, i);
        if (this.eqY != null && !this.eqY.ah(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.bfQ().re(str)) {
            flow.setValid(false);
        } else {
            if (this.eqY != null && this.eqY.zs(str) > 0) {
                if (new Random().nextInt(100) >= this.eqY.zs(str)) {
                    flow.ir(true);
                }
            }
            if (this.eqY != null && this.eqY.zt(str)) {
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
    public void L(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.erL) {
            this.erL = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.erJ != null) {
                        n.this.erJ.bfH();
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
        s.M(jSONArray);
        this.erI.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.erJ != null) {
                    n.this.erJ.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(final JSONArray jSONArray) {
        s.M(jSONArray);
        this.erI.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.erJ != null) {
                    n.this.erJ.L(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfK() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.erJ != null) {
                    n.this.erJ.bfK();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.erJ != null) {
                    if (z) {
                        n.this.erJ.zm(str);
                    } else {
                        n.this.erJ.zn(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.eqY = com.baidu.swan.ubc.d.bfM();
            n.this.erJ = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.erJ.bfL();
        }
    }

    /* loaded from: classes17.dex */
    private class b implements Runnable {
        private i erQ;

        b(String str, String str2, int i) {
            this.erQ = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.erQ = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.erQ = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.erQ = new i(str, str2, i, str3, j, i2);
        }

        public void iq(boolean z) {
            if (this.erQ != null) {
                this.erQ.iq(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.erJ != null) {
                this.erQ.bgg();
                if (!TextUtils.isEmpty(n.this.eqY.zr(this.erQ.getId()))) {
                    this.erQ.setCategory(n.this.eqY.zr(this.erQ.getId()));
                }
                if ((this.erQ.getOption() & 8) != 0) {
                    n.this.erJ.b(this.erQ);
                } else {
                    n.this.erJ.a(this.erQ);
                }
            }
        }
    }

    /* loaded from: classes17.dex */
    private class d implements Runnable {
        private k erR;

        d(Flow flow, String str) {
            this.erR = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.bgi());
            this.erR.dw(flow.getStartTime());
            this.erR.zA("1");
            n.d(n.this);
        }

        public void iq(boolean z) {
            if (this.erR != null) {
                this.erR.iq(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.erJ != null) {
                this.erR.bgg();
                if (!TextUtils.isEmpty(n.this.eqY.zr(this.erR.getId()))) {
                    this.erR.setCategory(n.this.eqY.zr(this.erR.getId()));
                }
                n.this.erJ.b(this.erR);
            }
        }
    }

    /* loaded from: classes17.dex */
    private class f implements Runnable {
        private String erA;
        private int erB;
        private String mValue;

        f(String str, int i, String str2) {
            this.erA = str;
            this.erB = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.erJ != null) {
                n.this.erJ.i(this.erA, this.erB, this.mValue);
            }
        }
    }

    /* loaded from: classes17.dex */
    private class e implements Runnable {
        private String erA;
        private int erB;
        private JSONArray erG;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.erA = str;
            this.erB = i;
            this.erG = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.erJ != null) {
                n.this.erJ.a(this.erA, this.erB, this.mEndTime, this.erG);
            }
        }
    }

    /* loaded from: classes17.dex */
    private class c implements Runnable {
        private String erA;
        private int erB;

        c(String str, int i) {
            this.erA = str;
            this.erB = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.erJ != null) {
                n.this.erJ.L(this.erA, this.erB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a implements Runnable {
        private q erP;

        a(q qVar) {
            this.erP = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.erJ != null) {
                n.this.erJ.a(this.erP);
            }
        }
    }
}
