package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes9.dex */
public class e implements c {
    private d dLX;

    @Override // com.baidu.swan.apps.storage.b.c
    public String tm(String str) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        return aIL == null ? str : com.baidu.swan.apps.storage.b.c(str, aIL);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tn(String str) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aIL, aIL.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String to(String str) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cx(str, aIL.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tp(String str) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        return aIL == null ? str : com.baidu.swan.apps.storage.b.cz(str, aIL.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tq(String str) {
        String yP = com.baidu.swan.c.d.yP(str);
        return TextUtils.isEmpty(yP) ? tp(str) : tp(str) + "." + yP;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tr(String str) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        return aIL == null ? "" : com.baidu.swan.apps.storage.b.ac(aIL.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMb() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        return aIL == null ? "" : com.baidu.swan.apps.storage.b.tc(aIL.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMc() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        return aIL == null ? "" : com.baidu.swan.apps.storage.b.sZ(aIL.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String td(String str) {
        return com.baidu.swan.apps.storage.b.td(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sX(String str) {
        return com.baidu.swan.apps.storage.b.sX(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sY(String str) {
        return com.baidu.swan.apps.storage.b.sY(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType te = com.baidu.swan.apps.storage.b.te(str);
        if (z) {
            te = a(str, te);
        }
        return te != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (ts(str)) {
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
    public synchronized d aMd() {
        if (this.dLX == null) {
            this.dLX = new f();
        }
        return this.dLX;
    }

    private boolean ts(String str) {
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
