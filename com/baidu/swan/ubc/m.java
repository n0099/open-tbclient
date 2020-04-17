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
    private static volatile m dee;
    private com.baidu.swan.ubc.d ddD;
    private ExecutorService def;
    private com.baidu.swan.ubc.c deg;
    private int deh;
    private boolean dei = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.deh;
        mVar.deh = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m aDT() {
        if (dee == null) {
            synchronized (m.class) {
                if (dee == null) {
                    dee = new m();
                }
            }
        }
        return dee;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.deh = com.baidu.swan.config.b.arg().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.deh > 1073741823) {
                this.deh -= 1073741823;
            } else {
                this.deh = 1073741823 + this.deh;
            }
            if (s.aEh() == null || s.aEh().PD() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.aEh().PD();
            }
            this.mExecutorService.execute(new g());
            this.def = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ddD != null && this.ddD.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ddD != null && this.ddD.sg(str)) {
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
            if (this.ddD != null && this.ddD.sg(str)) {
                dVar.gc(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ab;
    }

    Flow ab(String str, int i) {
        Flow flow = new Flow(str, this.deh, i);
        if (this.ddD != null && !this.ddD.Z(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.aEh().kV(str)) {
            flow.setValid(false);
        } else {
            if (this.ddD != null && this.ddD.se(str) > 0) {
                if (new Random().nextInt(100) >= this.ddD.se(str)) {
                    flow.gd(true);
                }
            }
            if (this.ddD != null && this.ddD.sf(str)) {
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
        if (!this.dei) {
            this.dei = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.deg != null) {
                        m.this.deg.aDr();
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
        if (!com.baidu.swan.config.b.arg().getBoolean("init_done", false)) {
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
        this.def.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.deg != null) {
                    m.this.deg.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(final JSONArray jSONArray) {
        r.J(jSONArray);
        this.def.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.deg != null) {
                    m.this.deg.I(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.deg != null) {
                    m.this.deg.aDu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.deg != null) {
                    if (z) {
                        m.this.deg.rY(str);
                    } else {
                        m.this.deg.rZ(str);
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
            m.this.ddD = com.baidu.swan.ubc.d.aDw();
            m.this.deg = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.deg.aDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private h dem;

        b(String str, String str2, int i) {
            this.dem = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dem = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dem = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dem = new h(str, str2, i, str3, j, i2);
        }

        public void gc(boolean z) {
            if (this.dem != null) {
                this.dem.gc(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.deg != null) {
                this.dem.aDN();
                if (!TextUtils.isEmpty(m.this.ddD.sd(this.dem.getId()))) {
                    this.dem.setCategory(m.this.ddD.sd(this.dem.getId()));
                }
                if ((this.dem.getOption() & 8) != 0) {
                    m.this.deg.b(this.dem);
                } else {
                    m.this.deg.a(this.dem);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private j den;

        d(Flow flow, String str) {
            this.den = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aDP());
            this.den.bR(flow.getStartTime());
            this.den.sj("1");
            m.d(m.this);
        }

        public void gc(boolean z) {
            if (this.den != null) {
                this.den.gc(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.deg != null) {
                this.den.aDN();
                if (!TextUtils.isEmpty(m.this.ddD.sd(this.den.getId()))) {
                    this.den.setCategory(m.this.ddD.sd(this.den.getId()));
                }
                m.this.deg.b(this.den);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        private String cgl;
        private int ddY;
        private String mValue;

        f(String str, int i, String str2) {
            this.cgl = str;
            this.ddY = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.deg != null) {
                m.this.deg.f(this.cgl, this.ddY, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        private String cgl;
        private int ddY;
        private JSONArray ded;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.cgl = str;
            this.ddY = i;
            this.ded = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.deg != null) {
                m.this.deg.a(this.cgl, this.ddY, this.mEndTime, this.ded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private String cgl;
        private int ddY;

        c(String str, int i) {
            this.cgl = str;
            this.ddY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.deg != null) {
                m.this.deg.C(this.cgl, this.ddY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private p del;

        a(p pVar) {
            this.del = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.deg != null) {
                m.this.deg.a(this.del);
                com.baidu.swan.config.b.arg().putBoolean("init_done", true);
            }
        }
    }
}
