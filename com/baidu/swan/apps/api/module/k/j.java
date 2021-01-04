package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cKF;
    private HashMap<String, Boolean> cKD = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cKE = new HashMap<>();
    private int aMj = -1;
    private com.baidu.swan.apps.ao.e.b<Integer> cKG = null;
    private com.baidu.swan.apps.v.h cKH = null;
    private com.baidu.swan.apps.framework.a cKI = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cKG != null && j.this.isFullScreen()) {
                j.this.cKG.L(1);
                return true;
            }
            return false;
        }
    };

    public static j anN() {
        if (cKF == null) {
            synchronized (j.class) {
                if (cKF == null) {
                    cKF = new j();
                }
            }
        }
        return cKF;
    }

    public void P(String str, boolean z) {
        if (this.cKD != null) {
            this.cKD.put(str, Boolean.valueOf(z));
        }
    }

    public void mj(String str) {
        if (this.cKD != null) {
            this.cKD.remove(str);
            int size = this.cKD.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aMj == 90 || this.aMj == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hP(int i) {
        this.aMj = i;
    }

    public void anO() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aLk();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void anP() {
        if (isFullScreen() && this.cKG != null) {
            this.cKG.L(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        this.cKG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anQ() {
        this.cKG = null;
    }

    public void release() {
        synchronized (this) {
            anR();
            anT();
            this.cKD = null;
            this.cKE.clear();
            this.cKG = null;
        }
        cKF = null;
    }

    protected void anR() {
        if (this.cKH != null) {
            com.baidu.swan.apps.v.i.b(this.cKH);
            this.cKH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anS() {
        com.baidu.swan.apps.v.f.aDG().aDq().a(this.cKI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anT() {
        SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
        if (this.cKI != null && aDq != null) {
            aDq.b(this.cKI);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.azX())) {
            this.cKE.put(aVar.azX(), aVar);
        }
    }

    public void mk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cKE.remove(str);
        }
    }

    public void ml(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cKE != null && this.cKE.size() > 0) {
            for (String str2 : this.cKE.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cKE.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.aAa().pg(aVar.azX());
                    }
                }
            }
        }
    }
}
