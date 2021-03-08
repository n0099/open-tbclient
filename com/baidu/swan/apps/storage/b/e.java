package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class e implements c {
    private d dNy;

    @Override // com.baidu.swan.apps.storage.b.c
    public String tt(String str) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        return aIO == null ? str : com.baidu.swan.apps.storage.b.c(str, aIO);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tu(String str) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aIO, aIO.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tv(String str) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.cx(str, aIO.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tw(String str) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        return aIO == null ? str : com.baidu.swan.apps.storage.b.cz(str, aIO.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tx(String str) {
        String yW = com.baidu.swan.c.d.yW(str);
        return TextUtils.isEmpty(yW) ? tw(str) : tw(str) + "." + yW;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ty(String str) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        return aIO == null ? "" : com.baidu.swan.apps.storage.b.ac(aIO.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMe() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        return aIO == null ? "" : com.baidu.swan.apps.storage.b.tj(aIO.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMf() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        return aIO == null ? "" : com.baidu.swan.apps.storage.b.tg(aIO.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tk(String str) {
        return com.baidu.swan.apps.storage.b.tk(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean te(String str) {
        return com.baidu.swan.apps.storage.b.te(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tf(String str) {
        return com.baidu.swan.apps.storage.b.tf(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType tl = com.baidu.swan.apps.storage.b.tl(str);
        if (z) {
            tl = a(str, tl);
        }
        return tl != PathType.ERROR;
    }

    private PathType a(String str, PathType pathType) {
        switch (pathType) {
            case RELATIVE:
                if (tz(str)) {
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
    public synchronized d aMg() {
        if (this.dNy == null) {
            this.dNy = new f();
        }
        return this.dNy;
    }

    private boolean tz(String str) {
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
