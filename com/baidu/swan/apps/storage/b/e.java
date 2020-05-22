package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class e implements c {
    private d cGT;

    @Override // com.baidu.swan.apps.storage.b.c
    public String oY(String str) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        return aoG == null ? str : com.baidu.swan.apps.storage.b.d(str, aoG);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oZ(String str) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aoG, aoG.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pa(String str) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bT(str, aoG.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pb(String str) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        return aoG == null ? str : com.baidu.swan.apps.storage.b.bV(str, aoG.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pc(String str) {
        String tY = com.baidu.swan.e.d.tY(str);
        return TextUtils.isEmpty(tY) ? pb(str) : pb(str) + "." + tY;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pd(String str) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        return aoG == null ? "" : com.baidu.swan.apps.storage.b.K(aoG.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String arI() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        return aoG == null ? "" : com.baidu.swan.apps.storage.b.oO(aoG.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String arJ() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        return aoG == null ? "" : com.baidu.swan.apps.storage.b.oL(aoG.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oP(String str) {
        return com.baidu.swan.apps.storage.b.oP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oJ(String str) {
        return com.baidu.swan.apps.storage.b.oJ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oK(String str) {
        return com.baidu.swan.apps.storage.b.oK(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean U(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType oQ = com.baidu.swan.apps.storage.b.oQ(str);
        if (z) {
            switch (oQ) {
                case RELATIVE:
                    if (pe(str)) {
                        oQ = PathType.ERROR;
                        break;
                    }
                    break;
                case ERROR:
                    if (str.startsWith("bdfile://code" + File.separator) || "bdfile://code".equals(str)) {
                        oQ = PathType.RELATIVE;
                        break;
                    }
                    break;
                case BD_FILE:
                    break;
                default:
                    oQ = PathType.ERROR;
                    break;
            }
        }
        return oQ != PathType.ERROR;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized d arK() {
        if (this.cGT == null) {
            this.cGT = new f();
        }
        return this.cGT;
    }

    private boolean pe(String str) {
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
