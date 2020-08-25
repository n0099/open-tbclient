package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class e implements c {
    private d cYb;

    @Override // com.baidu.swan.apps.storage.b.c
    public String rR(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? str : com.baidu.swan.apps.storage.b.d(str, azJ);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rS(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, azJ, azJ.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rT(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cn(str, azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rU(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? str : com.baidu.swan.apps.storage.b.cp(str, azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rV(String str) {
        String xu = com.baidu.swan.c.d.xu(str);
        return TextUtils.isEmpty(xu) ? rU(str) : rU(str) + "." + xu;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rW(String str) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? "" : com.baidu.swan.apps.storage.b.O(azJ.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aCZ() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? "" : com.baidu.swan.apps.storage.b.rH(azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDa() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? "" : com.baidu.swan.apps.storage.b.rE(azJ.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rI(String str) {
        return com.baidu.swan.apps.storage.b.rI(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rC(String str) {
        return com.baidu.swan.apps.storage.b.rC(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rD(String str) {
        return com.baidu.swan.apps.storage.b.rD(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType rJ = com.baidu.swan.apps.storage.b.rJ(str);
        if (z) {
            rJ = a(str, rJ);
        }
        return rJ != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (rX(str)) {
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
        if (this.cYb == null) {
            this.cYb = new f();
        }
        return this.cYb;
    }

    private boolean rX(String str) {
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
