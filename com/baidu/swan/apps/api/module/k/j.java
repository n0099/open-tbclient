package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cyX;
    private HashMap<String, Boolean> cyV = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cyW = new HashMap<>();
    private int aIM = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> cyY = null;
    private com.baidu.swan.apps.v.h cyZ = null;
    private com.baidu.swan.apps.framework.a cza = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cyY != null && j.this.isFullScreen()) {
                j.this.cyY.M(1);
                return true;
            }
            return false;
        }
    };

    public static j ajv() {
        if (cyX == null) {
            synchronized (j.class) {
                if (cyX == null) {
                    cyX = new j();
                }
            }
        }
        return cyX;
    }

    public void O(String str, boolean z) {
        if (this.cyV != null) {
            this.cyV.put(str, Boolean.valueOf(z));
        }
    }

    public void lJ(String str) {
        if (this.cyV != null) {
            this.cyV.remove(str);
            int size = this.cyV.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aIM == 90 || this.aIM == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hx(int i) {
        this.aIM = i;
    }

    public void ajw() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aGj();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void ajx() {
        if (isFullScreen() && this.cyY != null) {
            this.cyY.M(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.cyY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajy() {
        this.cyY = null;
    }

    public void release() {
        synchronized (this) {
            ajz();
            ajB();
            this.cyV = null;
            this.cyW.clear();
            this.cyY = null;
        }
        cyX = null;
    }

    protected void ajz() {
        if (this.cyZ != null) {
            com.baidu.swan.apps.v.i.b(this.cyZ);
            this.cyZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajA() {
        com.baidu.swan.apps.v.f.azg().ayQ().a(this.cza);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajB() {
        SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
        if (this.cza != null && ayQ != null) {
            ayQ.b(this.cza);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.avy())) {
            this.cyW.put(aVar.avy(), aVar);
        }
    }

    public void lK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cyW.remove(str);
        }
    }

    public void lL(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cyW != null && this.cyW.size() > 0) {
            for (String str2 : this.cyW.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cyW.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.avB().oG(aVar.avy());
                    }
                }
            }
        }
    }
}
