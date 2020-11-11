package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cAH;
    private HashMap<String, Boolean> cAF = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cAG = new HashMap<>();
    private int aKx = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> cAI = null;
    private com.baidu.swan.apps.v.h cAJ = null;
    private com.baidu.swan.apps.framework.a cAK = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cAI != null && j.this.isFullScreen()) {
                j.this.cAI.M(1);
                return true;
            }
            return false;
        }
    };

    public static j akd() {
        if (cAH == null) {
            synchronized (j.class) {
                if (cAH == null) {
                    cAH = new j();
                }
            }
        }
        return cAH;
    }

    public void O(String str, boolean z) {
        if (this.cAF != null) {
            this.cAF.put(str, Boolean.valueOf(z));
        }
    }

    public void lP(String str) {
        if (this.cAF != null) {
            this.cAF.remove(str);
            int size = this.cAF.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aKx == 90 || this.aKx == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hB(int i) {
        this.aKx = i;
    }

    public void ake() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aGR();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void akf() {
        if (isFullScreen() && this.cAI != null) {
            this.cAI.M(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.cAI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akg() {
        this.cAI = null;
    }

    public void release() {
        synchronized (this) {
            akh();
            akj();
            this.cAF = null;
            this.cAG.clear();
            this.cAI = null;
        }
        cAH = null;
    }

    protected void akh() {
        if (this.cAJ != null) {
            com.baidu.swan.apps.v.i.b(this.cAJ);
            this.cAJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aki() {
        com.baidu.swan.apps.v.f.azO().azy().a(this.cAK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akj() {
        SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
        if (this.cAK != null && azy != null) {
            azy.b(this.cAK);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.awg())) {
            this.cAG.put(aVar.awg(), aVar);
        }
    }

    public void lQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cAG.remove(str);
        }
    }

    public void lR(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cAG != null && this.cAG.size() > 0) {
            for (String str2 : this.cAG.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cAG.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.awj().oM(aVar.awg());
                    }
                }
            }
        }
    }
}
