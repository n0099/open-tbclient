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
    private static volatile m dej;
    private com.baidu.swan.ubc.d ddI;
    private ExecutorService dek;
    private com.baidu.swan.ubc.c del;
    private int dem;
    private boolean den = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.dem;
        mVar.dem = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m aDT() {
        if (dej == null) {
            synchronized (m.class) {
                if (dej == null) {
                    dej = new m();
                }
            }
        }
        return dej;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dem = com.baidu.swan.config.b.arf().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dem > 1073741823) {
                this.dem -= 1073741823;
            } else {
                this.dem = 1073741823 + this.dem;
            }
            if (s.aEh() == null || s.aEh().PC() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.aEh().PC();
            }
            this.mExecutorService.execute(new g());
            this.dek = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ddI != null && this.ddI.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ddI != null && this.ddI.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean aa(String str, int i) {
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
        Flow ab;
        ab = ab(str, i);
        if (ab != null && ab.getValid()) {
            d dVar = new d(ab, str2);
            if (this.ddI != null && this.ddI.sg(str)) {
                dVar.gc(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ab;
    }

    Flow ab(String str, int i) {
        Flow flow = new Flow(str, this.dem, i);
        if (this.ddI != null && !this.ddI.Z(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.aEh().kV(str)) {
            flow.setValid(false);
        } else {
            if (this.ddI != null && this.ddI.se(str) > 0) {
                if (new Random().nextInt(100) >= this.ddI.se(str)) {
                    flow.gd(true);
                }
            }
            if (this.ddI != null && this.ddI.sf(str)) {
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
    public void C(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.den) {
            this.den = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.del != null) {
                        m.this.del.aDr();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.mExecutorService.execute(new a(pVar));
    }

    public void initConfig() {
        aDU();
        if (!com.baidu.swan.config.b.arf().getBoolean("init_done", false)) {
            String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(readAssetData)) {
                try {
                    p pVar = new p("0", new JSONObject(readAssetData));
                    pVar.aEc();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void aDU() {
        o aDV = o.aDV();
        aDV.upload();
        aDV.aDW();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final JSONArray jSONArray, final String str) {
        r.J(jSONArray);
        this.dek.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.del != null) {
                    m.this.del.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(final JSONArray jSONArray) {
        r.J(jSONArray);
        this.dek.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.del != null) {
                    m.this.del.I(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.del != null) {
                    m.this.del.aDu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.del != null) {
                    if (z) {
                        m.this.del.rY(str);
                    } else {
                        m.this.del.rZ(str);
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
            m.this.ddI = com.baidu.swan.ubc.d.aDw();
            m.this.del = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.del.aDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private h der;

        b(String str, String str2, int i) {
            this.der = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.der = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.der = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.der = new h(str, str2, i, str3, j, i2);
        }

        public void gc(boolean z) {
            if (this.der != null) {
                this.der.gc(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.del != null) {
                this.der.aDN();
                if (!TextUtils.isEmpty(m.this.ddI.sd(this.der.getId()))) {
                    this.der.setCategory(m.this.ddI.sd(this.der.getId()));
                }
                if ((this.der.getOption() & 8) != 0) {
                    m.this.del.b(this.der);
                } else {
                    m.this.del.a(this.der);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private j det;

        d(Flow flow, String str) {
            this.det = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aDP());
            this.det.bR(flow.getStartTime());
            this.det.sj("1");
            m.d(m.this);
        }

        public void gc(boolean z) {
            if (this.det != null) {
                this.det.gc(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.del != null) {
                this.det.aDN();
                if (!TextUtils.isEmpty(m.this.ddI.sd(this.det.getId()))) {
                    this.det.setCategory(m.this.ddI.sd(this.det.getId()));
                }
                m.this.del.b(this.det);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        private String cgr;
        private int ded;
        private String mValue;

        f(String str, int i, String str2) {
            this.cgr = str;
            this.ded = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.del != null) {
                m.this.del.f(this.cgr, this.ded, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        private String cgr;
        private int ded;
        private JSONArray dei;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.cgr = str;
            this.ded = i;
            this.dei = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.del != null) {
                m.this.del.a(this.cgr, this.ded, this.mEndTime, this.dei);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private String cgr;
        private int ded;

        c(String str, int i) {
            this.cgr = str;
            this.ded = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.del != null) {
                m.this.del.C(this.cgr, this.ded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private p deq;

        a(p pVar) {
            this.deq = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.del != null) {
                m.this.del.a(this.deq);
                com.baidu.swan.config.b.arf().putBoolean("init_done", true);
            }
        }
    }
}
