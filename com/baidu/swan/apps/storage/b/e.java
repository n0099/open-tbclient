package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class e implements c {
    private d dAJ;

    @Override // com.baidu.swan.apps.storage.b.c
    public String tF(String str) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        return aHv == null ? str : com.baidu.swan.apps.storage.b.d(str, aHv);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tG(String str) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aHv, aHv.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tH(String str) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cz(str, aHv.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tI(String str) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        return aHv == null ? str : com.baidu.swan.apps.storage.b.cB(str, aHv.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tJ(String str) {
        String zh = com.baidu.swan.c.d.zh(str);
        return TextUtils.isEmpty(zh) ? tI(str) : tI(str) + "." + zh;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tK(String str) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        return aHv == null ? "" : com.baidu.swan.apps.storage.b.W(aHv.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKM() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        return aHv == null ? "" : com.baidu.swan.apps.storage.b.tv(aHv.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKN() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        return aHv == null ? "" : com.baidu.swan.apps.storage.b.ts(aHv.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tw(String str) {
        return com.baidu.swan.apps.storage.b.tw(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tq(String str) {
        return com.baidu.swan.apps.storage.b.tq(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tr(String str) {
        return com.baidu.swan.apps.storage.b.tr(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType tx = com.baidu.swan.apps.storage.b.tx(str);
        if (z) {
            tx = a(str, tx);
        }
        return tx != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (tL(str)) {
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
    public synchronized d aKO() {
        if (this.dAJ == null) {
            this.dAJ = new f();
        }
        return this.dAJ;
    }

    private boolean tL(String str) {
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
