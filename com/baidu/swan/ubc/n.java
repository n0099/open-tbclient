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
    private static volatile n eml;
    private com.baidu.swan.ubc.d elD;
    private ExecutorService emm;
    private com.baidu.swan.ubc.c emn;
    private int emo;
    private boolean emp = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.emo;
        nVar.emo = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n bdO() {
        if (eml == null) {
            synchronized (n.class) {
                if (eml == null) {
                    eml = new n();
                }
            }
        }
        return eml;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.emo = com.baidu.swan.config.b.aOM().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.emo > 1073741823) {
                this.emo -= 1073741823;
            } else {
                this.emo = 1073741823 + this.emo;
            }
            if (com.baidu.swan.ubc.e.bds() == null || com.baidu.swan.ubc.e.bds().ahR() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.bds().ahR();
            }
            this.mExecutorService.execute(new g());
            this.emm = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.elD != null && this.elD.yS(str)) {
                bVar.hY(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.elD != null && this.elD.yS(str)) {
                bVar.hY(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ah(String str, int i) {
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
        Flow ai;
        ai = ai(str, i);
        if (ai != null && ai.getValid()) {
            d dVar = new d(ai, str2);
            if (this.elD != null && this.elD.yS(str)) {
                dVar.hY(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ai;
    }

    Flow ai(String str, int i) {
        Flow flow = new Flow(str, this.emo, i);
        if (this.elD != null && !this.elD.ag(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.bds().qD(str)) {
            flow.setValid(false);
        } else {
            if (this.elD != null && this.elD.yQ(str) > 0) {
                if (new Random().nextInt(100) >= this.elD.yQ(str)) {
                    flow.hZ(true);
                }
            }
            if (this.elD != null && this.elD.yR(str)) {
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
    public void K(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.emp) {
            this.emp = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.emn != null) {
                        n.this.emn.bdj();
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
        this.emm.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.emn != null) {
                    n.this.emn.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.emm.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.emn != null) {
                    n.this.emn.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdm() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.emn != null) {
                    n.this.emn.bdm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.emn != null) {
                    if (z) {
                        n.this.emn.yK(str);
                    } else {
                        n.this.emn.yL(str);
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
            n.this.elD = com.baidu.swan.ubc.d.bdo();
            n.this.emn = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.emn.bdn();
        }
    }

    /* loaded from: classes9.dex */
    private class b implements Runnable {
        private i emu;

        b(String str, String str2, int i) {
            this.emu = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.emu = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.emu = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.emu = new i(str, str2, i, str3, j, i2);
        }

        public void hY(boolean z) {
            if (this.emu != null) {
                this.emu.hY(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.emn != null) {
                this.emu.bdI();
                if (!TextUtils.isEmpty(n.this.elD.yP(this.emu.getId()))) {
                    this.emu.setCategory(n.this.elD.yP(this.emu.getId()));
                }
                if ((this.emu.getOption() & 8) != 0) {
                    n.this.emn.b(this.emu);
                } else {
                    n.this.emn.a(this.emu);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class d implements Runnable {
        private k emv;

        d(Flow flow, String str) {
            this.emv = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.bdK());
            this.emv.cX(flow.getStartTime());
            this.emv.yY("1");
            n.d(n.this);
        }

        public void hY(boolean z) {
            if (this.emv != null) {
                this.emv.hY(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.emn != null) {
                this.emv.bdI();
                if (!TextUtils.isEmpty(n.this.elD.yP(this.emv.getId()))) {
                    this.emv.setCategory(n.this.elD.yP(this.emv.getId()));
                }
                n.this.emn.b(this.emv);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class f implements Runnable {
        private String eme;
        private int emf;
        private String mValue;

        f(String str, int i, String str2) {
            this.eme = str;
            this.emf = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.emn != null) {
                n.this.emn.i(this.eme, this.emf, this.mValue);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class e implements Runnable {
        private String eme;
        private int emf;
        private JSONArray emk;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eme = str;
            this.emf = i;
            this.emk = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.emn != null) {
                n.this.emn.a(this.eme, this.emf, this.mEndTime, this.emk);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class c implements Runnable {
        private String eme;
        private int emf;

        c(String str, int i) {
            this.eme = str;
            this.emf = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.emn != null) {
                n.this.emn.K(this.eme, this.emf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private q emt;

        a(q qVar) {
            this.emt = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.emn != null) {
                n.this.emn.a(this.emt);
            }
        }
    }
}
