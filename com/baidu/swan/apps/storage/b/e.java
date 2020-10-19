package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class e implements c {
    private d dmp;

    @Override // com.baidu.swan.apps.storage.b.c
    public String sY(String str) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        return aDb == null ? str : com.baidu.swan.apps.storage.b.d(str, aDb);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sZ(String str) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aDb, aDb.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ta(String str) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cs(str, aDb.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tb(String str) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        return aDb == null ? str : com.baidu.swan.apps.storage.b.cu(str, aDb.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tc(String str) {
        String yA = com.baidu.swan.c.d.yA(str);
        return TextUtils.isEmpty(yA) ? tb(str) : tb(str) + "." + yA;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String td(String str) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        return aDb == null ? "" : com.baidu.swan.apps.storage.b.P(aDb.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aGs() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        return aDb == null ? "" : com.baidu.swan.apps.storage.b.sO(aDb.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aGt() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        return aDb == null ? "" : com.baidu.swan.apps.storage.b.sL(aDb.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sP(String str) {
        return com.baidu.swan.apps.storage.b.sP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sJ(String str) {
        return com.baidu.swan.apps.storage.b.sJ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sK(String str) {
        return com.baidu.swan.apps.storage.b.sK(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ae(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType sQ = com.baidu.swan.apps.storage.b.sQ(str);
        if (z) {
            sQ = a(str, sQ);
        }
        return sQ != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (te(str)) {
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
    public synchronized d aGu() {
        if (this.dmp == null) {
            this.dmp = new f();
        }
        return this.dmp;
    }

    private boolean te(String str) {
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
