package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile h bRp;
    private HashMap<String, Boolean> bRn = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.p.e.b.a> bRo = new HashMap<>();
    private int ayg = -1;
    private com.baidu.swan.apps.aq.e.b<Integer> bRq = null;
    private com.baidu.swan.apps.w.h bRr = null;
    private com.baidu.swan.apps.framework.a bRs = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.h.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && h.this.bRq != null && h.this.isFullScreen()) {
                h.this.bRq.H(1);
                return true;
            }
            return false;
        }
    };

    public static h VB() {
        if (bRp == null) {
            synchronized (h.class) {
                if (bRp == null) {
                    bRp = new h();
                }
            }
        }
        return bRp;
    }

    public void D(String str, boolean z) {
        if (this.bRn != null) {
            this.bRn.put(str, Boolean.valueOf(z));
        }
    }

    public void is(String str) {
        if (this.bRn != null) {
            this.bRn.remove(str);
            int size = this.bRn.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.ayg == 90 || this.ayg == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eB(int i) {
        this.ayg = i;
    }

    public void VC() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.apk();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void VD() {
        if (isFullScreen() && this.bRq != null) {
            this.bRq.H(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.apps.aq.e.b<Integer> bVar) {
        this.bRq = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VE() {
        this.bRq = null;
    }

    public void release() {
        synchronized (this) {
            VF();
            VH();
            this.bRn = null;
            this.bRo.clear();
            this.bRq = null;
        }
        bRp = null;
    }

    protected void VF() {
        if (this.bRr != null) {
            com.baidu.swan.apps.w.i.b(this.bRr);
            this.bRr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VG() {
        com.baidu.swan.apps.w.f.ajb().aiL().a(this.bRs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VH() {
        SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
        if (this.bRs != null && aiL != null) {
            aiL.b(this.bRs);
        }
    }

    public void a(com.baidu.swan.apps.p.e.b.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.afE())) {
            this.bRo.put(aVar.afE(), aVar);
        }
    }

    public void it(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bRo.remove(str);
        }
    }

    public void iu(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.bRo != null && this.bRo.size() > 0) {
            for (String str2 : this.bRo.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.p.e.b.a aVar = this.bRo.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.afH().kI(aVar.afE());
                    }
                }
            }
        }
    }
}
