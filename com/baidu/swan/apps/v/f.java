package com.baidu.swan.apps.v;

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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong cpw = new AtomicLong(0);
    private static volatile f cpx;
    private d cpy = new a();

    private f() {
    }

    public static f akr() {
        if (cpx == null) {
            synchronized (f.class) {
                if (cpx == null) {
                    cpx = new f();
                }
            }
        }
        return cpx;
    }

    boolean aks() {
        return (this.cpy == null || (this.cpy instanceof a)) ? false : true;
    }

    public boolean akt() {
        return aks() && this.cpy.akb() != null;
    }

    public void bW(Context context) {
        this.cpy.bW(context);
    }

    public void bX(Context context) {
        this.cpy.bX(context);
    }

    public void Uw() {
        this.cpy.Uw();
    }

    public void Ux() {
        this.cpy.Ux();
    }

    public void exit() {
        this.cpy.exit();
    }

    public void ajR() {
        this.cpy.ajR();
    }

    public void ajS() {
        this.cpy.ajS();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cpx != null) {
                if (cpx.cpy != null) {
                    cpx.cpy.doRelease();
                }
                cpx = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aad() {
        return this.cpy.aad();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cpy.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cpy.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a ajU() {
        return this.cpy.ajU();
    }

    public FullScreenFloatView H(Activity activity) {
        return this.cpy.H(activity);
    }

    public SwanAppPropertyWindow I(Activity activity) {
        return this.cpy.I(activity);
    }

    public boolean ajV() {
        return this.cpy.ajV();
    }

    public void u(Intent intent) {
        this.cpy.u(intent);
    }

    public void TL() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.ahJ().TL();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.awC();
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bt(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aks()) {
            gd(swanAppActivity.RU());
        }
        if (aks()) {
            this.cpy.i(swanAppActivity);
        }
    }

    public void gd(int i) {
        if (!aks()) {
            switch (i) {
                case 0:
                    this.cpy = new c();
                    return;
                case 1:
                    this.cpy = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion ajT() {
        return this.cpy.ajT();
    }

    public SwanAppConfigData ajW() {
        return this.cpy.ajW();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c lZ(String str) {
        return this.cpy.lZ(str);
    }

    public com.baidu.swan.apps.runtime.config.c ma(String str) {
        return this.cpy.ma(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cpy.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c ajX() {
        return this.cpy.ajX();
    }

    public String ajY() {
        return this.cpy.ajY();
    }

    public String ajZ() {
        return this.cpy.ajZ();
    }

    public String aka() {
        return this.cpy.aka();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f Sc() {
        SwanAppActivity arp;
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null || (arp = arw.arp()) == null) {
            return null;
        }
        return arp.Sc();
    }

    public SwanAppActivity akb() {
        return this.cpy.akb();
    }

    public com.baidu.swan.games.view.d aku() {
        return this.cpy.abz();
    }

    public com.baidu.swan.games.view.d akv() {
        return this.cpy.abA();
    }

    public com.baidu.swan.apps.adaptation.b.e kq(String str) {
        return this.cpy.kq(str);
    }

    public AbsoluteLayout mb(String str) {
        return this.cpy.mb(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cpy.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        this.cpy.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cpy.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e aba() {
        return this.cpy.aba();
    }

    public String akw() {
        return al.axg().getPage();
    }

    public String aaL() {
        return this.cpy.aaL();
    }

    public com.baidu.swan.apps.adaptation.b.d akc() {
        return this.cpy.akc();
    }

    @NonNull
    public Pair<Integer, Integer> akd() {
        return this.cpy.akd();
    }

    @NonNull
    public Pair<Integer, Integer> ake() {
        return this.cpy.ake();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void gc(int i) {
        this.cpy.gc(i);
    }

    public void showLoadingView() {
        this.cpy.showLoadingView();
    }

    public void Sf() {
        this.cpy.Sf();
    }

    public long akx() {
        return cpw.get();
    }

    public void aky() {
        long incrementAndGet = cpw.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void akz() {
        long decrementAndGet = cpw.decrementAndGet();
        if (decrementAndGet <= 0) {
            cpx.cpy.ajQ();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void ajP() {
            super.ajP();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean akh() {
            return this.cpi;
        }
    }

    public com.baidu.swan.games.q.a akf() {
        return this.cpy.akf();
    }
}
