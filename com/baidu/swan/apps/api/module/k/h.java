package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile h bSg;
    private HashMap<String, Boolean> bSe = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.p.f.b.a> bSf = new HashMap<>();
    private int azt = -1;
    private com.baidu.swan.apps.aq.e.b<Integer> bSh = null;
    private com.baidu.swan.apps.v.h bSi = null;
    private com.baidu.swan.apps.framework.a bSj = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.h.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && h.this.bSh != null && h.this.isFullScreen()) {
                h.this.bSh.H(1);
                return true;
            }
            return false;
        }
    };

    public static h Wh() {
        if (bSg == null) {
            synchronized (h.class) {
                if (bSg == null) {
                    bSg = new h();
                }
            }
        }
        return bSg;
    }

    public void D(String str, boolean z) {
        if (this.bSe != null) {
            this.bSe.put(str, Boolean.valueOf(z));
        }
    }

    public void iC(String str) {
        if (this.bSe != null) {
            this.bSe.remove(str);
            int size = this.bSe.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.azt == 90 || this.azt == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eC(int i) {
        this.azt = i;
    }

    public void Wi() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aqT();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void Wj() {
        if (isFullScreen() && this.bSh != null) {
            this.bSh.H(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.aq.e.b<Integer> bVar) {
        this.bSh = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wk() {
        this.bSh = null;
    }

    public void release() {
        synchronized (this) {
            Wl();
            Wn();
            this.bSe = null;
            this.bSf.clear();
            this.bSh = null;
        }
        bSg = null;
    }

    protected void Wl() {
        if (this.bSi != null) {
            com.baidu.swan.apps.v.i.b(this.bSi);
            this.bSi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wm() {
        com.baidu.swan.apps.v.f.akr().akb().a(this.bSj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wn() {
        SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
        if (this.bSj != null && akb != null) {
            akb.b(this.bSj);
        }
    }

    public void a(com.baidu.swan.apps.p.f.b.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.agP())) {
            this.bSf.put(aVar.agP(), aVar);
        }
    }

    public void iD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bSf.remove(str);
        }
    }

    public void iE(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.bSf != null && this.bSf.size() > 0) {
            for (String str2 : this.bSf.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.p.f.b.a aVar = this.bSf.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.agS().lf(aVar.agP());
                    }
                }
            }
        }
    }
}
