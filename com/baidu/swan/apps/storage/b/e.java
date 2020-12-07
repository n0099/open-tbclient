package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes25.dex */
public class e implements c {
    private d dGb;

    @Override // com.baidu.swan.apps.storage.b.c
    public String uh(String str) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        return aJV == null ? str : com.baidu.swan.apps.storage.b.d(str, aJV);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ui(String str) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aJV, aJV.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uj(String str) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cF(str, aJV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uk(String str) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        return aJV == null ? str : com.baidu.swan.apps.storage.b.cH(str, aJV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ul(String str) {
        String zJ = com.baidu.swan.c.d.zJ(str);
        return TextUtils.isEmpty(zJ) ? uk(str) : uk(str) + "." + zJ;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String um(String str) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        return aJV == null ? "" : com.baidu.swan.apps.storage.b.Z(aJV.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aNl() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        return aJV == null ? "" : com.baidu.swan.apps.storage.b.tX(aJV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aNm() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        return aJV == null ? "" : com.baidu.swan.apps.storage.b.tU(aJV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tY(String str) {
        return com.baidu.swan.apps.storage.b.tY(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tS(String str) {
        return com.baidu.swan.apps.storage.b.tS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tT(String str) {
        return com.baidu.swan.apps.storage.b.tT(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ah(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType tZ = com.baidu.swan.apps.storage.b.tZ(str);
        if (z) {
            tZ = a(str, tZ);
        }
        return tZ != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (un(str)) {
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
    public synchronized d aNn() {
        if (this.dGb == null) {
            this.dGb = new f();
        }
        return this.dGb;
    }

    private boolean un(String str) {
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
