package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile h bMB;
    private HashMap<String, Boolean> bMz = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.p.e.b.a> bMA = new HashMap<>();
    private int avY = -1;
    private com.baidu.swan.apps.aq.e.b<Integer> bMC = null;
    private com.baidu.swan.apps.w.h bMD = null;
    private com.baidu.swan.apps.framework.a bME = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.h.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && h.this.bMC != null && h.this.isFullScreen()) {
                h.this.bMC.H(1);
                return true;
            }
            return false;
        }
    };

    public static h Uv() {
        if (bMB == null) {
            synchronized (h.class) {
                if (bMB == null) {
                    bMB = new h();
                }
            }
        }
        return bMB;
    }

    public void B(String str, boolean z) {
        if (this.bMz != null) {
            this.bMz.put(str, Boolean.valueOf(z));
        }
    }

    public void ik(String str) {
        if (this.bMz != null) {
            this.bMz.remove(str);
            int size = this.bMz.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.avY == 90 || this.avY == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eq(int i) {
        this.avY = i;
    }

    public void Uw() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aod();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void Ux() {
        if (isFullScreen() && this.bMC != null) {
            this.bMC.H(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.apps.aq.e.b<Integer> bVar) {
        this.bMC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uy() {
        this.bMC = null;
    }

    public void release() {
        synchronized (this) {
            Uz();
            UB();
            this.bMz = null;
            this.bMA.clear();
            this.bMC = null;
        }
        bMB = null;
    }

    protected void Uz() {
        if (this.bMD != null) {
            com.baidu.swan.apps.w.i.b(this.bMD);
            this.bMD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UA() {
        com.baidu.swan.apps.w.f.ahV().ahF().a(this.bME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UB() {
        SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
        if (this.bME != null && ahF != null) {
            ahF.b(this.bME);
        }
    }

    public void a(com.baidu.swan.apps.p.e.b.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.aey())) {
            this.bMA.put(aVar.aey(), aVar);
        }
    }

    public void il(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bMA.remove(str);
        }
    }

    public void im(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.bMA != null && this.bMA.size() > 0) {
            for (String str2 : this.bMA.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.p.e.b.a aVar = this.bMA.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.aeB().kA(aVar.aey());
                    }
                }
            }
        }
    }
}
