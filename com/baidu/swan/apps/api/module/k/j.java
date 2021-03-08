package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cJO;
    private HashMap<String, Boolean> cJM = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cJN = new HashMap<>();
    private int aLB = -1;
    private com.baidu.swan.apps.ao.e.b<Integer> cJP = null;
    private com.baidu.swan.apps.v.h cJQ = null;
    private com.baidu.swan.apps.framework.a cJR = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cJP != null && j.this.isFullScreen()) {
                j.this.cJP.N(1);
                return true;
            }
            return false;
        }
    };

    public static j akv() {
        if (cJO == null) {
            synchronized (j.class) {
                if (cJO == null) {
                    cJO = new j();
                }
            }
        }
        return cJO;
    }

    public void O(String str, boolean z) {
        if (this.cJM != null) {
            this.cJM.put(str, Boolean.valueOf(z));
        }
    }

    public void lx(String str) {
        if (this.cJM != null) {
            this.cJM.remove(str);
            int size = this.cJM.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aLB == 90 || this.aLB == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gm(int i) {
        this.aLB = i;
    }

    public void akw() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aHN();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void akx() {
        if (isFullScreen() && this.cJP != null) {
            this.cJP.N(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        this.cJP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aky() {
        this.cJP = null;
    }

    public void release() {
        synchronized (this) {
            akz();
            akB();
            this.cJM = null;
            this.cJN.clear();
            this.cJP = null;
        }
        cJO = null;
    }

    protected void akz() {
        if (this.cJQ != null) {
            com.baidu.swan.apps.v.i.b(this.cJQ);
            this.cJQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akA() {
        com.baidu.swan.apps.v.f.aAo().azY().a(this.cJR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akB() {
        SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
        if (this.cJR != null && azY != null) {
            azY.b(this.cJR);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.awF())) {
            this.cJN.put(aVar.awF(), aVar);
        }
    }

    public void ly(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cJN.remove(str);
        }
    }

    public void lz(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cJN != null && this.cJN.size() > 0) {
            for (String str2 : this.cJN.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cJN.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.awI().ou(aVar.awF());
                    }
                }
            }
        }
    }
}
