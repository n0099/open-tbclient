package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cuO;
    private HashMap<String, Boolean> cuM = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cuN = new HashMap<>();
    private int aJx = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> cuP = null;
    private com.baidu.swan.apps.v.h cuQ = null;
    private com.baidu.swan.apps.framework.a cuR = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cuP != null && j.this.isFullScreen()) {
                j.this.cuP.M(1);
                return true;
            }
            return false;
        }
    };

    public static j ahD() {
        if (cuO == null) {
            synchronized (j.class) {
                if (cuO == null) {
                    cuO = new j();
                }
            }
        }
        return cuO;
    }

    public void O(String str, boolean z) {
        if (this.cuM != null) {
            this.cuM.put(str, Boolean.valueOf(z));
        }
    }

    public void lA(String str) {
        if (this.cuM != null) {
            this.cuM.remove(str);
            int size = this.cuM.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aJx == 90 || this.aJx == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hr(int i) {
        this.aJx = i;
    }

    public void ahE() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aEr();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void ahF() {
        if (isFullScreen() && this.cuP != null) {
            this.cuP.M(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.cuP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahG() {
        this.cuP = null;
    }

    public void release() {
        synchronized (this) {
            ahH();
            ahJ();
            this.cuM = null;
            this.cuN.clear();
            this.cuP = null;
        }
        cuO = null;
    }

    protected void ahH() {
        if (this.cuQ != null) {
            com.baidu.swan.apps.v.i.b(this.cuQ);
            this.cuQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahI() {
        com.baidu.swan.apps.v.f.axo().awY().a(this.cuR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahJ() {
        SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
        if (this.cuR != null && awY != null) {
            awY.b(this.cuR);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.atG())) {
            this.cuN.put(aVar.atG(), aVar);
        }
    }

    public void lB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cuN.remove(str);
        }
    }

    public void lC(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cuN != null && this.cuN.size() > 0) {
            for (String str2 : this.cuN.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cuN.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.atJ().oy(aVar.atG());
                    }
                }
            }
        }
    }
}
