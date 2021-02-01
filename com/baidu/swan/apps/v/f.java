package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong dhj = new AtomicLong(0);
    private static volatile f dhk;
    private d dhl = new a();

    private f() {
    }

    public static f aAl() {
        if (dhk == null) {
            synchronized (f.class) {
                if (dhk == null) {
                    dhk = new f();
                }
            }
        }
        return dhk;
    }

    boolean aAm() {
        return (this.dhl == null || (this.dhl instanceof a)) ? false : true;
    }

    public boolean aAn() {
        return aAm() && this.dhl.azV() != null;
    }

    public void cT(Context context) {
        this.dhl.cT(context);
    }

    public void cU(Context context) {
        this.dhl.cU(context);
    }

    public void aiC() {
        this.dhl.aiC();
    }

    public void aiD() {
        this.dhl.aiD();
    }

    public void exit() {
        this.dhl.exit();
    }

    public void azL() {
        this.dhl.azL();
    }

    public void azM() {
        this.dhl.azM();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (dhk != null) {
                if (dhk.dhl != null) {
                    dhk.dhl.doRelease();
                }
                dhk = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aos() {
        return this.dhl.aos();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.dhl.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.dhl.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azO() {
        return this.dhl.azO();
    }

    public FullScreenFloatView B(Activity activity) {
        return this.dhl.B(activity);
    }

    public SwanAppPropertyWindow C(Activity activity) {
        return this.dhl.C(activity);
    }

    public boolean azP() {
        return this.dhl.azP();
    }

    public void w(Intent intent) {
        this.dhl.w(intent);
    }

    public void ahP() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.axx().ahP();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aNP();
        p.b(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.cq(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aAm()) {
            hV(swanAppActivity.getFrameType());
        }
        if (aAm()) {
            this.dhl.i(swanAppActivity);
        }
    }

    public void hV(int i) {
        if (!aAm()) {
            switch (i) {
                case 0:
                    this.dhl = new c();
                    return;
                case 1:
                    this.dhl = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion azN() {
        return this.dhl.azN();
    }

    public SwanAppConfigData azQ() {
        return this.dhl.azQ();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c pm(String str) {
        return this.dhl.pm(str);
    }

    public com.baidu.swan.apps.runtime.config.c pn(String str) {
        return this.dhl.pn(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.dhl.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c azR() {
        return this.dhl.azR();
    }

    public String azS() {
        return this.dhl.azS();
    }

    public String azT() {
        return this.dhl.azT();
    }

    public String azU() {
        return this.dhl.azU();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f afX() {
        SwanAppActivity aIE;
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null || (aIE = aIL.aIE()) == null) {
            return null;
        }
        return aIE.afX();
    }

    public SwanAppActivity azV() {
        return this.dhl.azV();
    }

    public com.baidu.swan.games.view.d aAo() {
        return this.dhl.apW();
    }

    public com.baidu.swan.games.view.d aAp() {
        return this.dhl.apX();
    }

    public com.baidu.swan.apps.adaptation.b.e ni(String str) {
        return this.dhl.ni(str);
    }

    public AbsoluteLayout po(String str) {
        return this.dhl.po(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.dhl.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.dhl.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.dhl.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e apy() {
        return this.dhl.apy();
    }

    public String aAq() {
        return ak.aOr().getPage();
    }

    public String apg() {
        return this.dhl.apg();
    }

    public com.baidu.swan.apps.adaptation.b.d azW() {
        return this.dhl.azW();
    }

    @NonNull
    public Pair<Integer, Integer> azX() {
        return this.dhl.azX();
    }

    @NonNull
    public Pair<Integer, Integer> azY() {
        return this.dhl.azY();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void hU(int i) {
        this.dhl.hU(i);
    }

    public void showLoadingView() {
        this.dhl.showLoadingView();
    }

    public void aga() {
        this.dhl.aga();
    }

    public long aAr() {
        return dhj.get();
    }

    public void aAs() {
        long incrementAndGet = dhj.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void aAt() {
        long decrementAndGet = dhj.decrementAndGet();
        if (decrementAndGet <= 0) {
            dhk.dhl.azK();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void azJ() {
            super.azJ();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean aAb() {
            return this.dgU;
        }
    }

    public com.baidu.swan.games.q.a azZ() {
        return this.dhl.azZ();
    }
}
