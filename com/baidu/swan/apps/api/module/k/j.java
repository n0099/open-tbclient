package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cFT;
    private HashMap<String, Boolean> cFR = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cFS = new HashMap<>();
    private int aHw = -1;
    private com.baidu.swan.apps.ao.e.b<Integer> cFU = null;
    private com.baidu.swan.apps.v.h cFV = null;
    private com.baidu.swan.apps.framework.a cFW = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cFU != null && j.this.isFullScreen()) {
                j.this.cFU.L(1);
                return true;
            }
            return false;
        }
    };

    public static j ajU() {
        if (cFT == null) {
            synchronized (j.class) {
                if (cFT == null) {
                    cFT = new j();
                }
            }
        }
        return cFT;
    }

    public void P(String str, boolean z) {
        if (this.cFR != null) {
            this.cFR.put(str, Boolean.valueOf(z));
        }
    }

    public void kY(String str) {
        if (this.cFR != null) {
            this.cFR.remove(str);
            int size = this.cFR.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aHw == 90 || this.aHw == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gi(int i) {
        this.aHw = i;
    }

    public void ajV() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aHr();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void ajW() {
        if (isFullScreen() && this.cFU != null) {
            this.cFU.L(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        this.cFU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajX() {
        this.cFU = null;
    }

    public void release() {
        synchronized (this) {
            ajY();
            aka();
            this.cFR = null;
            this.cFS.clear();
            this.cFU = null;
        }
        cFT = null;
    }

    protected void ajY() {
        if (this.cFV != null) {
            com.baidu.swan.apps.v.i.b(this.cFV);
            this.cFV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajZ() {
        com.baidu.swan.apps.v.f.azN().azx().a(this.cFW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aka() {
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (this.cFW != null && azx != null) {
            azx.b(this.cFW);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.awe())) {
            this.cFS.put(aVar.awe(), aVar);
        }
    }

    public void kZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cFS.remove(str);
        }
    }

    public void la(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cFS != null && this.cFS.size() > 0) {
            for (String str2 : this.cFS.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cFS.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.awh().nT(aVar.awe());
                    }
                }
            }
        }
    }
}
