package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes9.dex */
public class e implements c {
    private d dOF;

    @Override // com.baidu.swan.apps.storage.b.c
    public String ue(String str) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl == null ? str : com.baidu.swan.apps.storage.b.c(str, aMl);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uf(String str) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aMl, aMl.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ug(String str) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cE(str, aMl.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uh(String str) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl == null ? str : com.baidu.swan.apps.storage.b.cG(str, aMl.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ui(String str) {
        String zI = com.baidu.swan.c.d.zI(str);
        return TextUtils.isEmpty(zI) ? uh(str) : uh(str) + "." + zI;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uj(String str) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl == null ? "" : com.baidu.swan.apps.storage.b.ac(aMl.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aPB() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl == null ? "" : com.baidu.swan.apps.storage.b.tU(aMl.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aPC() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl == null ? "" : com.baidu.swan.apps.storage.b.tR(aMl.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tV(String str) {
        return com.baidu.swan.apps.storage.b.tV(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tP(String str) {
        return com.baidu.swan.apps.storage.b.tP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tQ(String str) {
        return com.baidu.swan.apps.storage.b.tQ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ah(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType tW = com.baidu.swan.apps.storage.b.tW(str);
        if (z) {
            tW = a(str, tW);
        }
        return tW != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (uk(str)) {
                    return PathType.ERROR;
                }
                return pathType;
            case ERROR:
                if (str.startsWith("bdfile://code" + File.separator) || "bdfile://code".equals(str)) {
                    return PathType.RELATIVE;
                }
                return pathType;
            case BD_FILE:
                return pathType;
            default:
                return PathType.ERROR;
        }
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized d aPD() {
        if (this.dOF == null) {
            this.dOF = new f();
        }
        return this.dOF;
    }

    private boolean uk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(Constants.PATH_PARENT);
        if (indexOf != 0) {
            return indexOf > 0;
        }
        String substring = str.substring(Constants.PATH_PARENT.length());
        return !TextUtils.isEmpty(substring) && substring.contains(Constants.PATH_PARENT);
    }
}
