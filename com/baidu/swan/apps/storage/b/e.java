package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class e implements c {
    private d duR;

    @Override // com.baidu.swan.apps.storage.b.c
    public String tr(String str) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        return aEV == null ? str : com.baidu.swan.apps.storage.b.d(str, aEV);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ts(String str) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aEV, aEV.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tt(String str) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cz(str, aEV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tu(String str) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        return aEV == null ? str : com.baidu.swan.apps.storage.b.cB(str, aEV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tv(String str) {
        String yT = com.baidu.swan.c.d.yT(str);
        return TextUtils.isEmpty(yT) ? tu(str) : tu(str) + "." + yT;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tw(String str) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        return aEV == null ? "" : com.baidu.swan.apps.storage.b.W(aEV.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aIm() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        return aEV == null ? "" : com.baidu.swan.apps.storage.b.th(aEV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aIn() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        return aEV == null ? "" : com.baidu.swan.apps.storage.b.te(aEV.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ti(String str) {
        return com.baidu.swan.apps.storage.b.ti(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tc(String str) {
        return com.baidu.swan.apps.storage.b.tc(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean td(String str) {
        return com.baidu.swan.apps.storage.b.td(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType tj = com.baidu.swan.apps.storage.b.tj(str);
        if (z) {
            tj = a(str, tj);
        }
        return tj != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (tx(str)) {
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
    public synchronized d aIo() {
        if (this.duR == null) {
            this.duR = new f();
        }
        return this.duR;
    }

    private boolean tx(String str) {
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
