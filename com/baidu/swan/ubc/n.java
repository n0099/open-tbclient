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
/* loaded from: classes15.dex */
public class n {
    private static volatile n eyL;
    private ExecutorService eyM;
    private com.baidu.swan.ubc.c eyN;
    private int eyO;
    private boolean eyP = false;
    private com.baidu.swan.ubc.d eyb;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.eyO;
        nVar.eyO = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n bfd() {
        if (eyL == null) {
            synchronized (n.class) {
                if (eyL == null) {
                    eyL = new n();
                }
            }
        }
        return eyL;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eyO = com.baidu.swan.config.b.aQe().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.eyO > 1073741823) {
                this.eyO -= 1073741823;
            } else {
                this.eyO = 1073741823 + this.eyO;
            }
            if (com.baidu.swan.ubc.e.beH() == null || com.baidu.swan.ubc.e.beH().aie() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.beH().aie();
            }
            this.mExecutorService.execute(new g());
            this.eyM = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!am(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.eyb != null && this.eyb.yB(str)) {
                bVar.iJ(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        if (!am(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.eyb != null && this.eyb.yB(str)) {
                bVar.iJ(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean am(String str, int i) {
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
        Flow an;
        an = an(str, i);
        if (an != null && an.getValid()) {
            d dVar = new d(an, str2);
            if (this.eyb != null && this.eyb.yB(str)) {
                dVar.iJ(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return an;
    }

    Flow an(String str, int i) {
        Flow flow = new Flow(str, this.eyO, i);
        if (this.eyb != null && !this.eyb.al(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.beH().qe(str)) {
            flow.setValid(false);
        } else {
            if (this.eyb != null && this.eyb.yz(str) > 0) {
                if (new Random().nextInt(100) >= this.eyb.yz(str)) {
                    flow.iK(true);
                }
            }
            if (this.eyb != null && this.eyb.yA(str)) {
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
    public void O(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.eyP) {
            this.eyP = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.eyN != null) {
                        n.this.eyN.bey();
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
        this.eyM.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eyN != null) {
                    n.this.eyN.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.eyM.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eyN != null) {
                    n.this.eyN.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beB() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eyN != null) {
                    n.this.eyN.beB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eyN != null) {
                    if (z) {
                        n.this.eyN.yt(str);
                    } else {
                        n.this.eyN.yu(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.eyb = com.baidu.swan.ubc.d.beD();
            n.this.eyN = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.eyN.beC();
        }
    }

    /* loaded from: classes15.dex */
    private class b implements Runnable {
        private i eyU;

        b(String str, String str2, int i) {
            this.eyU = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.eyU = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.eyU = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.eyU = new i(str, str2, i, str3, j, i2);
        }

        public void iJ(boolean z) {
            if (this.eyU != null) {
                this.eyU.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eyN != null) {
                this.eyU.beX();
                if (!TextUtils.isEmpty(n.this.eyb.yy(this.eyU.getId()))) {
                    this.eyU.setCategory(n.this.eyb.yy(this.eyU.getId()));
                }
                if ((this.eyU.getOption() & 8) != 0) {
                    n.this.eyN.b(this.eyU);
                } else {
                    n.this.eyN.a(this.eyU);
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    private class d implements Runnable {
        private k eyV;

        d(Flow flow, String str) {
            this.eyV = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.beZ());
            this.eyV.dC(flow.getStartTime());
            this.eyV.yH("1");
            n.d(n.this);
        }

        public void iJ(boolean z) {
            if (this.eyV != null) {
                this.eyV.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eyN != null) {
                this.eyV.beX();
                if (!TextUtils.isEmpty(n.this.eyb.yy(this.eyV.getId()))) {
                    this.eyV.setCategory(n.this.eyb.yy(this.eyV.getId()));
                }
                n.this.eyN.b(this.eyV);
            }
        }
    }

    /* loaded from: classes15.dex */
    private class f implements Runnable {
        private String eyE;
        private int eyF;
        private String mValue;

        f(String str, int i, String str2) {
            this.eyE = str;
            this.eyF = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eyN != null) {
                n.this.eyN.i(this.eyE, this.eyF, this.mValue);
            }
        }
    }

    /* loaded from: classes15.dex */
    private class e implements Runnable {
        private String eyE;
        private int eyF;
        private JSONArray eyK;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eyE = str;
            this.eyF = i;
            this.eyK = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eyN != null) {
                n.this.eyN.a(this.eyE, this.eyF, this.mEndTime, this.eyK);
            }
        }
    }

    /* loaded from: classes15.dex */
    private class c implements Runnable {
        private String eyE;
        private int eyF;

        c(String str, int i) {
            this.eyE = str;
            this.eyF = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eyN != null) {
                n.this.eyN.O(this.eyE, this.eyF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        private q eyT;

        a(q qVar) {
            this.eyT = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eyN != null) {
                n.this.eyN.a(this.eyT);
            }
        }
    }
}
