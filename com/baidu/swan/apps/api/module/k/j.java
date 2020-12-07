package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cFP;
    private HashMap<String, Boolean> cFN = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cFO = new HashMap<>();
    private int aLF = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> cFQ = null;
    private com.baidu.swan.apps.v.h cFR = null;
    private com.baidu.swan.apps.framework.a cFS = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cFQ != null && j.this.isFullScreen()) {
                j.this.cFQ.M(1);
                return true;
            }
            return false;
        }
    };

    public static j amD() {
        if (cFP == null) {
            synchronized (j.class) {
                if (cFP == null) {
                    cFP = new j();
                }
            }
        }
        return cFP;
    }

    public void P(String str, boolean z) {
        if (this.cFN != null) {
            this.cFN.put(str, Boolean.valueOf(z));
        }
    }

    public void mq(String str) {
        if (this.cFN != null) {
            this.cFN.remove(str);
            int size = this.cFN.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aLF == 90 || this.aLF == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hV(int i) {
        this.aLF = i;
    }

    public void amE() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aJr();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void amF() {
        if (isFullScreen() && this.cFQ != null) {
            this.cFQ.M(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.cFQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amG() {
        this.cFQ = null;
    }

    public void release() {
        synchronized (this) {
            amH();
            amJ();
            this.cFN = null;
            this.cFO.clear();
            this.cFQ = null;
        }
        cFP = null;
    }

    protected void amH() {
        if (this.cFR != null) {
            com.baidu.swan.apps.v.i.b(this.cFR);
            this.cFR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amI() {
        com.baidu.swan.apps.v.f.aCp().aBZ().a(this.cFS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amJ() {
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        if (this.cFS != null && aBZ != null) {
            aBZ.b(this.cFS);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.ayG())) {
            this.cFO.put(aVar.ayG(), aVar);
        }
    }

    public void mr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cFO.remove(str);
        }
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cFO != null && this.cFO.size() > 0) {
            for (String str2 : this.cFO.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cFO.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.ayJ().pn(aVar.ayG());
                    }
                }
            }
        }
    }
}
