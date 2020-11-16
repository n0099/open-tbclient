package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes7.dex */
public class e implements c {
    private d dzc;

    @Override // com.baidu.swan.apps.storage.b.c
    public String tA(String str) {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        return aGN == null ? str : com.baidu.swan.apps.storage.b.d(str, aGN);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tB(String str) {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aGN, aGN.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tC(String str) {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cy(str, aGN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tD(String str) {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        return aGN == null ? str : com.baidu.swan.apps.storage.b.cA(str, aGN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tE(String str) {
        String zc = com.baidu.swan.c.d.zc(str);
        return TextUtils.isEmpty(zc) ? tD(str) : tD(str) + "." + zc;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tF(String str) {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        return aGN == null ? "" : com.baidu.swan.apps.storage.b.W(aGN.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKe() {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        return aGN == null ? "" : com.baidu.swan.apps.storage.b.tq(aGN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKf() {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        return aGN == null ? "" : com.baidu.swan.apps.storage.b.tn(aGN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tr(String str) {
        return com.baidu.swan.apps.storage.b.tr(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tl(String str) {
        return com.baidu.swan.apps.storage.b.tl(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tm(String str) {
        return com.baidu.swan.apps.storage.b.tm(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType ts = com.baidu.swan.apps.storage.b.ts(str);
        if (z) {
            ts = a(str, ts);
        }
        return ts != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (tG(str)) {
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
    public synchronized d aKg() {
        if (this.dzc == null) {
            this.dzc = new f();
        }
        return this.dzc;
    }

    private boolean tG(String str) {
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
