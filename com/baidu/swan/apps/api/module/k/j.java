package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j bZU;
    private HashMap<String, Boolean> bZS = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> bZT = new HashMap<>();
    private int aFR = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> bZV = null;
    private com.baidu.swan.apps.v.h bZW = null;
    private com.baidu.swan.apps.framework.a bZX = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.bZV != null && j.this.isFullScreen()) {
                j.this.bZV.J(1);
                return true;
            }
            return false;
        }
    };

    public static j acX() {
        if (bZU == null) {
            synchronized (j.class) {
                if (bZU == null) {
                    bZU = new j();
                }
            }
        }
        return bZU;
    }

    public void I(String str, boolean z) {
        if (this.bZS != null) {
            this.bZS.put(str, Boolean.valueOf(z));
        }
    }

    public void kv(String str) {
        if (this.bZS != null) {
            this.bZS.remove(str);
            int size = this.bZS.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aFR == 90 || this.aFR == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gJ(int i) {
        this.aFR = i;
    }

    public void acY() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.azO();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void acZ() {
        if (isFullScreen() && this.bZV != null) {
            this.bZV.J(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.bZV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ada() {
        this.bZV = null;
    }

    public void release() {
        synchronized (this) {
            adb();
            add();
            this.bZS = null;
            this.bZT.clear();
            this.bZV = null;
        }
        bZU = null;
    }

    protected void adb() {
        if (this.bZW != null) {
            com.baidu.swan.apps.v.i.b(this.bZW);
            this.bZW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adc() {
        com.baidu.swan.apps.v.f.asJ().ast().a(this.bZX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add() {
        SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
        if (this.bZX != null && ast != null) {
            ast.b(this.bZX);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.aoZ())) {
            this.bZT.put(aVar.aoZ(), aVar);
        }
    }

    public void kw(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bZT.remove(str);
        }
    }

    public void kx(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.bZT != null && this.bZT.size() > 0) {
            for (String str2 : this.bZT.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.bZT.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.apc().nr(aVar.aoZ());
                    }
                }
            }
        }
    }
}
