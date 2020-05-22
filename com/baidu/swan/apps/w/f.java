package com.baidu.swan.apps.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes11.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong ciB = new AtomicLong(0);
    private static volatile f ciC;
    private d ciD = new a();

    private f() {
    }

    public static f ahV() {
        if (ciC == null) {
            synchronized (f.class) {
                if (ciC == null) {
                    ciC = new f();
                }
            }
        }
        return ciC;
    }

    boolean ahW() {
        return (this.ciD == null || (this.ciD instanceof a)) ? false : true;
    }

    public boolean ahX() {
        return ahW() && this.ciD.ahF() != null;
    }

    public void bS(Context context) {
        this.ciD.bS(context);
    }

    public void bT(Context context) {
        this.ciD.bT(context);
    }

    public void SQ() {
        this.ciD.SQ();
    }

    public void SR() {
        this.ciD.SR();
    }

    public void exit() {
        this.ciD.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.ciD.a(i, strArr, aVar);
    }

    public void ahv() {
        this.ciD.ahv();
    }

    public void ahw() {
        this.ciD.ahw();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (ciC != null) {
                if (ciC.ciD != null) {
                    ciC.ciD.doRelease();
                }
                ciC = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e Zc() {
        return this.ciD.Zc();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.ciD.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.ciD.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a ahy() {
        return this.ciD.ahy();
    }

    public FullScreenFloatView I(Activity activity) {
        return this.ciD.I(activity);
    }

    public SwanAppPropertyWindow J(Activity activity) {
        return this.ciD.J(activity);
    }

    public boolean ahz() {
        return this.ciD.ahz();
    }

    public void u(Intent intent) {
        this.ciD.u(intent);
    }

    public void Sh() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.afq().Sh();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        n.atu();
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.w.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bp(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void h(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !ahW()) {
            fG(swanAppActivity.Qz());
        }
        if (ahW()) {
            this.ciD.h(swanAppActivity);
        }
    }

    public void fG(int i) {
        if (!ahW()) {
            switch (i) {
                case 0:
                    this.ciD = new c();
                    return;
                case 1:
                    this.ciD = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion ahx() {
        return this.ciD.ahx();
    }

    public SwanAppConfigData ahA() {
        return this.ciD.ahA();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c lq(String str) {
        return this.ciD.lq(str);
    }

    public com.baidu.swan.apps.runtime.config.c lr(String str) {
        return this.ciD.lr(str);
    }

    public com.baidu.swan.apps.storage.b.c ahB() {
        return this.ciD.ahB();
    }

    public String ahC() {
        return this.ciD.ahC();
    }

    public String ahD() {
        return this.ciD.ahD();
    }

    public String ahE() {
        return this.ciD.ahE();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.e QH() {
        SwanAppActivity aoz;
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null || (aoz = aoG.aoz()) == null) {
            return null;
        }
        return aoz.QH();
    }

    public SwanAppActivity ahF() {
        return this.ciD.ahF();
    }

    public com.baidu.swan.games.view.d ahY() {
        return this.ciD.Zr();
    }

    public com.baidu.swan.games.view.d ahZ() {
        return this.ciD.Zs();
    }

    public com.baidu.swan.apps.adaptation.b.e jO(String str) {
        return this.ciD.jO(str);
    }

    public AbsoluteLayout ls(String str) {
        return this.ciD.ls(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.ciD.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        this.ciD.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.ciD.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d YQ() {
        return this.ciD.YQ();
    }

    public String aia() {
        return aj.atU().getPage();
    }

    public String YB() {
        return this.ciD.YB();
    }

    public com.baidu.swan.apps.adaptation.b.d ahG() {
        return this.ciD.ahG();
    }

    @NonNull
    public Pair<Integer, Integer> ahH() {
        return this.ciD.ahH();
    }

    @NonNull
    public Pair<Integer, Integer> ahI() {
        return this.ciD.ahI();
    }

    @Override // com.baidu.swan.apps.w.e.b
    public void fF(int i) {
        this.ciD.fF(i);
    }

    public void showLoadingView() {
        this.ciD.showLoadingView();
    }

    public void QK() {
        this.ciD.QK();
    }

    public long aib() {
        return ciB.get();
    }

    public void aic() {
        long incrementAndGet = ciB.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void aid() {
        long decrementAndGet = ciB.decrementAndGet();
        if (decrementAndGet <= 0) {
            ciC.ciD.ahu();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.w.b
        protected void aht() {
            super.aht();
        }

        @Override // com.baidu.swan.apps.w.d
        public boolean ahL() {
            return this.cin;
        }
    }

    public com.baidu.swan.games.q.a ahJ() {
        return this.ciD.ahJ();
    }
}
