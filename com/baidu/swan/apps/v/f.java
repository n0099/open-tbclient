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
/* loaded from: classes8.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong diN = new AtomicLong(0);
    private static volatile f diO;
    private d diP = new a();

    private f() {
    }

    public static f aAo() {
        if (diO == null) {
            synchronized (f.class) {
                if (diO == null) {
                    diO = new f();
                }
            }
        }
        return diO;
    }

    boolean aAp() {
        return (this.diP == null || (this.diP instanceof a)) ? false : true;
    }

    public boolean aAq() {
        return aAp() && this.diP.azY() != null;
    }

    public void cS(Context context) {
        this.diP.cS(context);
    }

    public void cT(Context context) {
        this.diP.cT(context);
    }

    public void aiF() {
        this.diP.aiF();
    }

    public void aiG() {
        this.diP.aiG();
    }

    public void exit() {
        this.diP.exit();
    }

    public void azO() {
        this.diP.azO();
    }

    public void azP() {
        this.diP.azP();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (diO != null) {
                if (diO.diP != null) {
                    diO.diP.doRelease();
                }
                diO = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aov() {
        return this.diP.aov();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.diP.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.diP.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azR() {
        return this.diP.azR();
    }

    public FullScreenFloatView B(Activity activity) {
        return this.diP.B(activity);
    }

    public SwanAppPropertyWindow C(Activity activity) {
        return this.diP.C(activity);
    }

    public boolean azS() {
        return this.diP.azS();
    }

    public void w(Intent intent) {
        this.diP.w(intent);
    }

    public void ahS() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.axA().ahS();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aNS();
        p.b(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.cp(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aAp()) {
            hW(swanAppActivity.getFrameType());
        }
        if (aAp()) {
            this.diP.i(swanAppActivity);
        }
    }

    public void hW(int i) {
        if (!aAp()) {
            switch (i) {
                case 0:
                    this.diP = new c();
                    return;
                case 1:
                    this.diP = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion azQ() {
        return this.diP.azQ();
    }

    public SwanAppConfigData azT() {
        return this.diP.azT();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c pt(String str) {
        return this.diP.pt(str);
    }

    public com.baidu.swan.apps.runtime.config.c pu(String str) {
        return this.diP.pu(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.diP.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c azU() {
        return this.diP.azU();
    }

    public String azV() {
        return this.diP.azV();
    }

    public String azW() {
        return this.diP.azW();
    }

    public String azX() {
        return this.diP.azX();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f aga() {
        SwanAppActivity aIH;
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null || (aIH = aIO.aIH()) == null) {
            return null;
        }
        return aIH.aga();
    }

    public SwanAppActivity azY() {
        return this.diP.azY();
    }

    public com.baidu.swan.games.view.d aAr() {
        return this.diP.apZ();
    }

    public com.baidu.swan.games.view.d aAs() {
        return this.diP.aqa();
    }

    public com.baidu.swan.apps.adaptation.b.e np(String str) {
        return this.diP.np(str);
    }

    public AbsoluteLayout pv(String str) {
        return this.diP.pv(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.diP.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.diP.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.diP.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e apB() {
        return this.diP.apB();
    }

    public String aAt() {
        return ak.aOu().getPage();
    }

    public String apk() {
        return this.diP.apk();
    }

    public com.baidu.swan.apps.adaptation.b.d azZ() {
        return this.diP.azZ();
    }

    @NonNull
    public Pair<Integer, Integer> aAa() {
        return this.diP.aAa();
    }

    @NonNull
    public Pair<Integer, Integer> aAb() {
        return this.diP.aAb();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void hV(int i) {
        this.diP.hV(i);
    }

    public void showLoadingView() {
        this.diP.showLoadingView();
    }

    public void agd() {
        this.diP.agd();
    }

    public long aAu() {
        return diN.get();
    }

    public void aAv() {
        long incrementAndGet = diN.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void aAw() {
        long decrementAndGet = diN.decrementAndGet();
        if (decrementAndGet <= 0) {
            diO.diP.azN();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void azM() {
            super.azM();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean aAe() {
            return this.diy;
        }
    }

    public com.baidu.swan.games.q.a aAc() {
        return this.diP.aAc();
    }
}
