package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class e implements c {
    private d dJT;

    @Override // com.baidu.swan.apps.storage.b.c
    public String sT(String str) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        return aIs == null ? str : com.baidu.swan.apps.storage.b.c(str, aIs);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sU(String str) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aIs, aIs.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sV(String str) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cD(str, aIs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sW(String str) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        return aIs == null ? str : com.baidu.swan.apps.storage.b.cF(str, aIs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sX(String str) {
        String yx = com.baidu.swan.c.d.yx(str);
        return TextUtils.isEmpty(yx) ? sW(str) : sW(str) + "." + yx;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sY(String str) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        return aIs == null ? "" : com.baidu.swan.apps.storage.b.ab(aIs.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aLI() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        return aIs == null ? "" : com.baidu.swan.apps.storage.b.sJ(aIs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aLJ() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        return aIs == null ? "" : com.baidu.swan.apps.storage.b.sG(aIs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sK(String str) {
        return com.baidu.swan.apps.storage.b.sK(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sE(String str) {
        return com.baidu.swan.apps.storage.b.sE(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sF(String str) {
        return com.baidu.swan.apps.storage.b.sF(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ah(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType sL = com.baidu.swan.apps.storage.b.sL(str);
        if (z) {
            sL = a(str, sL);
        }
        return sL != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (sZ(str)) {
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
    public synchronized d aLK() {
        if (this.dJT == null) {
            this.dJT = new f();
        }
        return this.dJT;
    }

    private boolean sZ(String str) {
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
