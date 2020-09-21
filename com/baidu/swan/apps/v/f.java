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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong czk = new AtomicLong(0);
    private static volatile f czl;
    private d czm = new a();

    private f() {
    }

    public static f asJ() {
        if (czl == null) {
            synchronized (f.class) {
                if (czl == null) {
                    czl = new f();
                }
            }
        }
        return czl;
    }

    boolean asK() {
        return (this.czm == null || (this.czm instanceof a)) ? false : true;
    }

    public boolean asL() {
        return asK() && this.czm.ast() != null;
    }

    public void cb(Context context) {
        this.czm.cb(context);
    }

    public void cc(Context context) {
        this.czm.cc(context);
    }

    public void abh() {
        this.czm.abh();
    }

    public void abi() {
        this.czm.abi();
    }

    public void exit() {
        this.czm.exit();
    }

    public void asi() {
        this.czm.asi();
    }

    public void asj() {
        this.czm.asj();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (czl != null) {
                if (czl.czm != null) {
                    czl.czm.doRelease();
                }
                czl = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e agX() {
        return this.czm.agX();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.czm.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.czm.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a asl() {
        return this.czm.asl();
    }

    public FullScreenFloatView I(Activity activity) {
        return this.czm.I(activity);
    }

    public SwanAppPropertyWindow J(Activity activity) {
        return this.czm.J(activity);
    }

    public boolean asn() {
        return this.czm.asn();
    }

    public void w(Intent intent) {
        this.czm.w(intent);
    }

    public void aaw() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.apV().aaw();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aFw();
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.bz(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !asK()) {
            ir(swanAppActivity.Yy());
        }
        if (asK()) {
            this.czm.i(swanAppActivity);
        }
    }

    public void ir(int i) {
        if (!asK()) {
            switch (i) {
                case 0:
                    this.czm = new c();
                    return;
                case 1:
                    this.czm = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion ask() {
        return this.czm.ask();
    }

    public SwanAppConfigData aso() {
        return this.czm.aso();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c os(String str) {
        return this.czm.os(str);
    }

    public com.baidu.swan.apps.runtime.config.c ot(String str) {
        return this.czm.ot(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.czm.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c asp() {
        return this.czm.asp();
    }

    public String asq() {
        return this.czm.asq();
    }

    public String asr() {
        return this.czm.asr();
    }

    public String ass() {
        return this.czm.ass();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f YG() {
        SwanAppActivity aAl;
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null || (aAl = aAs.aAl()) == null) {
            return null;
        }
        return aAl.YG();
    }

    public SwanAppActivity ast() {
        return this.czm.ast();
    }

    public com.baidu.swan.games.view.d asM() {
        return this.czm.aiv();
    }

    public com.baidu.swan.games.view.d asN() {
        return this.czm.aiw();
    }

    public com.baidu.swan.apps.adaptation.b.e mn(String str) {
        return this.czm.mn(str);
    }

    public AbsoluteLayout ou(String str) {
        return this.czm.ou(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.czm.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.czm.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.czm.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e ahX() {
        return this.czm.ahX();
    }

    public String asO() {
        return ak.aFZ().getPage();
    }

    public String ahG() {
        return this.czm.ahG();
    }

    public com.baidu.swan.apps.adaptation.b.d asu() {
        return this.czm.asu();
    }

    @NonNull
    public Pair<Integer, Integer> asv() {
        return this.czm.asv();
    }

    @NonNull
    public Pair<Integer, Integer> asw() {
        return this.czm.asw();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void iq(int i) {
        this.czm.iq(i);
    }

    public void showLoadingView() {
        this.czm.showLoadingView();
    }

    public void YJ() {
        this.czm.YJ();
    }

    public long asP() {
        return czk.get();
    }

    public void asQ() {
        long incrementAndGet = czk.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void asR() {
        long decrementAndGet = czk.decrementAndGet();
        if (decrementAndGet <= 0) {
            czl.czm.ash();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void asg() {
            super.asg();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean asz() {
            return this.cyV;
        }
    }

    public com.baidu.swan.games.q.a asx() {
        return this.czm.asx();
    }
}
