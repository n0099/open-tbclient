package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cIo;
    private HashMap<String, Boolean> cIm = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cIn = new HashMap<>();
    private int aKb = -1;
    private com.baidu.swan.apps.ao.e.b<Integer> cIp = null;
    private com.baidu.swan.apps.v.h cIq = null;
    private com.baidu.swan.apps.framework.a cIr = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cIp != null && j.this.isFullScreen()) {
                j.this.cIp.L(1);
                return true;
            }
            return false;
        }
    };

    public static j aks() {
        if (cIo == null) {
            synchronized (j.class) {
                if (cIo == null) {
                    cIo = new j();
                }
            }
        }
        return cIo;
    }

    public void O(String str, boolean z) {
        if (this.cIm != null) {
            this.cIm.put(str, Boolean.valueOf(z));
        }
    }

    public void lq(String str) {
        if (this.cIm != null) {
            this.cIm.remove(str);
            int size = this.cIm.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aKb == 90 || this.aKb == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gl(int i) {
        this.aKb = i;
    }

    public void akt() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aHK();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void aku() {
        if (isFullScreen() && this.cIp != null) {
            this.cIp.L(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        this.cIp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akv() {
        this.cIp = null;
    }

    public void release() {
        synchronized (this) {
            akw();
            aky();
            this.cIm = null;
            this.cIn.clear();
            this.cIp = null;
        }
        cIo = null;
    }

    protected void akw() {
        if (this.cIq != null) {
            com.baidu.swan.apps.v.i.b(this.cIq);
            this.cIq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akx() {
        com.baidu.swan.apps.v.f.aAl().azV().a(this.cIr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aky() {
        SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
        if (this.cIr != null && azV != null) {
            azV.b(this.cIr);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.awC())) {
            this.cIn.put(aVar.awC(), aVar);
        }
    }

    public void lr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cIn.remove(str);
        }
    }

    public void ls(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cIn != null && this.cIn.size() > 0) {
            for (String str2 : this.cIn.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cIn.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.awF().om(aVar.awC());
                    }
                }
            }
        }
    }
}
