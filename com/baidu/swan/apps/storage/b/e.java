package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class e implements c {
    private d cYf;

    @Override // com.baidu.swan.apps.storage.b.c
    public String rS(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? str : com.baidu.swan.apps.storage.b.d(str, azJ);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rT(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, azJ, azJ.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rU(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cn(str, azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rV(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? str : com.baidu.swan.apps.storage.b.cp(str, azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rW(String str) {
        String xv = com.baidu.swan.c.d.xv(str);
        return TextUtils.isEmpty(xv) ? rV(str) : rV(str) + "." + xv;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rX(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? "" : com.baidu.swan.apps.storage.b.O(azJ.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aCZ() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? "" : com.baidu.swan.apps.storage.b.rI(azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDa() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? "" : com.baidu.swan.apps.storage.b.rF(azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rJ(String str) {
        return com.baidu.swan.apps.storage.b.rJ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rD(String str) {
        return com.baidu.swan.apps.storage.b.rD(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rE(String str) {
        return com.baidu.swan.apps.storage.b.rE(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType rK = com.baidu.swan.apps.storage.b.rK(str);
        if (z) {
            rK = a(str, rK);
        }
        return rK != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (rY(str)) {
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
    public synchronized d aDb() {
        if (this.cYf == null) {
            this.cYf = new f();
        }
        return this.cYf;
    }

    private boolean rY(String str) {
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
