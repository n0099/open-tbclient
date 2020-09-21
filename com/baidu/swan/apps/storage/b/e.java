package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class e implements c {
    private d daf;

    @Override // com.baidu.swan.apps.storage.b.c
    public String sl(String str) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        return aAs == null ? str : com.baidu.swan.apps.storage.b.d(str, aAs);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sm(String str) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aAs, aAs.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sn(String str) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cn(str, aAs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String so(String str) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        return aAs == null ? str : com.baidu.swan.apps.storage.b.cp(str, aAs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sp(String str) {
        String xO = com.baidu.swan.c.d.xO(str);
        return TextUtils.isEmpty(xO) ? so(str) : so(str) + "." + xO;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sq(String str) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        return aAs == null ? "" : com.baidu.swan.apps.storage.b.O(aAs.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDJ() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        return aAs == null ? "" : com.baidu.swan.apps.storage.b.sb(aAs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDK() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        return aAs == null ? "" : com.baidu.swan.apps.storage.b.rY(aAs.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sc(String str) {
        return com.baidu.swan.apps.storage.b.sc(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rW(String str) {
        return com.baidu.swan.apps.storage.b.rW(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rX(String str) {
        return com.baidu.swan.apps.storage.b.rX(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType sd = com.baidu.swan.apps.storage.b.sd(str);
        if (z) {
            sd = a(str, sd);
        }
        return sd != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (ss(str)) {
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
    public synchronized d aDL() {
        if (this.daf == null) {
            this.daf = new f();
        }
        return this.daf;
    }

    private boolean ss(String str) {
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
