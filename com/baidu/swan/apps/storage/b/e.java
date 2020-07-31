package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes7.dex */
public class e implements c {
    private d cOY;

    @Override // com.baidu.swan.apps.storage.b.c
    public String pR(String str) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        return arw == null ? str : com.baidu.swan.apps.storage.b.d(str, arw);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pS(String str) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, arw, arw.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pT(String str) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bW(str, arw.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pU(String str) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        return arw == null ? str : com.baidu.swan.apps.storage.b.bY(str, arw.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pV(String str) {
        String vj = com.baidu.swan.d.d.vj(str);
        return TextUtils.isEmpty(vj) ? pU(str) : pU(str) + "." + vj;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pW(String str) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        return arw == null ? "" : com.baidu.swan.apps.storage.b.L(arw.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String auQ() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        return arw == null ? "" : com.baidu.swan.apps.storage.b.pH(arw.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String auR() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        return arw == null ? "" : com.baidu.swan.apps.storage.b.pE(arw.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pI(String str) {
        return com.baidu.swan.apps.storage.b.pI(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean pC(String str) {
        return com.baidu.swan.apps.storage.b.pC(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean pD(String str) {
        return com.baidu.swan.apps.storage.b.pD(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean V(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType pJ = com.baidu.swan.apps.storage.b.pJ(str);
        if (z) {
            switch (pJ) {
                case RELATIVE:
                    if (pX(str)) {
                        pJ = PathType.ERROR;
                        break;
                    }
                    break;
                case ERROR:
                    if (str.startsWith("bdfile://code" + File.separator) || "bdfile://code".equals(str)) {
                        pJ = PathType.RELATIVE;
                        break;
                    }
                    break;
                case BD_FILE:
                    break;
                default:
                    pJ = PathType.ERROR;
                    break;
            }
        }
        return pJ != PathType.ERROR;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized d auS() {
        if (this.cOY == null) {
            this.cOY = new f();
        }
        return this.cOY;
    }

    private boolean pX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf("../");
        if (indexOf != 0) {
            return indexOf > 0;
        }
        String substring = str.substring("../".length());
        return !TextUtils.isEmpty(substring) && substring.contains("../");
    }
}
