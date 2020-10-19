package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile j cmk;
    private HashMap<String, Boolean> cmi = new HashMap<>();
    private HashMap<String, com.baidu.swan.apps.inlinewidget.f.c.a> cmj = new HashMap<>();
    private int aIV = -1;
    private com.baidu.swan.apps.ap.e.b<Integer> cml = null;
    private com.baidu.swan.apps.v.h cmm = null;
    private com.baidu.swan.apps.framework.a cmn = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.k.j.1
        @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.cml != null && j.this.isFullScreen()) {
                j.this.cml.M(1);
                return true;
            }
            return false;
        }
    };

    public static j afJ() {
        if (cmk == null) {
            synchronized (j.class) {
                if (cmk == null) {
                    cmk = new j();
                }
            }
        }
        return cmk;
    }

    public void M(String str, boolean z) {
        if (this.cmi != null) {
            this.cmi.put(str, Boolean.valueOf(z));
        }
    }

    public void lh(String str) {
        if (this.cmi != null) {
            this.cmi.remove(str);
            int size = this.cmi.keySet().size();
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public boolean isFullScreen() {
        return this.aIV == 90 || this.aIV == -90;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hg(int i) {
        this.aIV = i;
    }

    public void afK() {
        if (isFullScreen()) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            com.baidu.swan.apps.res.widget.a.aCx();
            com.baidu.swan.apps.res.widget.a.setImmersive(true);
        } else if (DEBUG) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void afL() {
        if (isFullScreen() && this.cml != null) {
            this.cml.M(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        this.cml = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afM() {
        this.cml = null;
    }

    public void release() {
        synchronized (this) {
            afN();
            afP();
            this.cmi = null;
            this.cmj.clear();
            this.cml = null;
        }
        cmk = null;
    }

    protected void afN() {
        if (this.cmm != null) {
            com.baidu.swan.apps.v.i.b(this.cmm);
            this.cmm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afO() {
        com.baidu.swan.apps.v.f.avu().ave().a(this.cmn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afP() {
        SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
        if (this.cmn != null && ave != null) {
            ave.b(this.cmn);
        }
    }

    public void a(com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.arL())) {
            this.cmj.put(aVar.arL(), aVar);
        }
    }

    public void li(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cmj.remove(str);
        }
    }

    public void lj(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
            }
        } else if (this.cmj != null && this.cmj.size() > 0) {
            for (String str2 : this.cmj.keySet()) {
                if (str2.equals(str)) {
                    if (DEBUG) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    com.baidu.swan.apps.inlinewidget.f.c.a aVar = this.cmj.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.arO().od(aVar.arL());
                    }
                }
            }
        }
    }
}
