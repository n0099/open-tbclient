package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j bXP;
    private HashMap<String, Boolean> bXN = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> bXO = new HashMap<>();
    private int aEE = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> bXQ = null;
    private com.baidu.swan.apps.v.h bXR = null;
    private com.baidu.swan.apps.framework.a bXS = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.bXQ != null && j.this.isFullScreen()) {
                j.this.bXQ.I(1);
                return true;
            }
            return false;
        }
    };

    public static j aco() {
        if (bXP == null) {
            synchronized (j.class) {
                if (bXP == null) {
                    bXP = new j();
                }
            }
        }
        return bXP;
    }

    public void I(String str, boolean z) {
        if (this.bXN != null) {
            this.bXN.put(str, Boolean.valueOf(z));
        }
    }

    public void kb(String str) {
        if (this.bXN != null) {
            this.bXN.remove(str);
            int size = this.bXN.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aEE == 90 || this.aEE == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gA(int i) {
        this.aEE = i;
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
        if (isFullScreen() && this.bXQ != null) {
            this.bXQ.I(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.bXQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acr() {
        this.bXQ = null;
    }

    public void release() {
        synchronized (this) {
            acs();
            acu();
            this.bXN = null;
            this.bXO.clear();
            this.bXQ = null;
        }
        bXP = null;
    }

    protected void acs() {
        if (this.bXR != null) {
            com.baidu.swan.apps.v.i.b(this.bXR);
            this.bXR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void act() {
        com.baidu.swan.apps.v.f.arY().arI().a(this.bXS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acu() {
        SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
        if (this.bXS != null && arI != null) {
            arI.b(this.bXS);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.aop())) {
            this.bXO.put(aVar.aop(), aVar);
        }
    }

    public void kc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bXO.remove(str);
        }
    }

    public void kd(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.bXO != null && this.bXO.size() > 0) {
            for (String str2 : this.bXO.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.bXO.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.aos().mX(aVar.aop());
                    }
                }
            }
        }
    }
}
