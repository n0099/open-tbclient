package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j bXT;
    private HashMap<String, Boolean> bXR = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> bXS = new HashMap<>();
    private int aEG = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> bXU = null;
    private com.baidu.swan.apps.v.h bXV = null;
    private com.baidu.swan.apps.framework.a bXW = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.bXU != null && j.this.isFullScreen()) {
                j.this.bXU.I(1);
                return true;
            }
            return false;
        }
    };

    public static j aco() {
        if (bXT == null) {
            synchronized (j.class) {
                if (bXT == null) {
                    bXT = new j();
                }
            }
        }
        return bXT;
    }

    public void I(String str, boolean z) {
        if (this.bXR != null) {
            this.bXR.put(str, Boolean.valueOf(z));
        }
    }

    public void kc(String str) {
        if (this.bXR != null) {
            this.bXR.remove(str);
            int size = this.bXR.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aEG == 90 || this.aEG == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gA(int i) {
        this.aEG = i;
    }

    public void acp() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.azf();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void acq() {
        if (isFullScreen() && this.bXU != null) {
            this.bXU.I(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.bXU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acr() {
        this.bXU = null;
    }

    public void release() {
        synchronized (this) {
            acs();
            acu();
            this.bXR = null;
            this.bXS.clear();
            this.bXU = null;
        }
        bXT = null;
    }

    protected void acs() {
        if (this.bXV != null) {
            com.baidu.swan.apps.v.i.b(this.bXV);
            this.bXV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void act() {
        com.baidu.swan.apps.v.f.arY().arI().a(this.bXW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acu() {
        SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
        if (this.bXW != null && arI != null) {
            arI.b(this.bXW);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.aop())) {
            this.bXS.put(aVar.aop(), aVar);
        }
    }

    public void kd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bXS.remove(str);
        }
    }

    public void ke(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.bXS != null && this.bXS.size() > 0) {
            for (String str2 : this.bXS.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.bXS.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.aos().mY(aVar.aop());
                    }
                }
            }
        }
    }
}
