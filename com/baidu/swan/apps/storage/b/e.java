package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class e implements c {
    private d cLD;

    @Override // com.baidu.swan.apps.storage.b.c
    public String pg(String str) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        return apN == null ? str : com.baidu.swan.apps.storage.b.d(str, apN);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ph(String str) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, apN, apN.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pi(String str) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bV(str, apN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pj(String str) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        return apN == null ? str : com.baidu.swan.apps.storage.b.bX(str, apN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pk(String str) {
        String ug = com.baidu.swan.e.d.ug(str);
        return TextUtils.isEmpty(ug) ? pj(str) : pj(str) + "." + ug;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pl(String str) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        return apN == null ? "" : com.baidu.swan.apps.storage.b.L(apN.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String asP() {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        return apN == null ? "" : com.baidu.swan.apps.storage.b.oW(apN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String asQ() {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        return apN == null ? "" : com.baidu.swan.apps.storage.b.oT(apN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oX(String str) {
        return com.baidu.swan.apps.storage.b.oX(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oR(String str) {
        return com.baidu.swan.apps.storage.b.oR(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oS(String str) {
        return com.baidu.swan.apps.storage.b.oS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean W(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType oY = com.baidu.swan.apps.storage.b.oY(str);
        if (z) {
            switch (oY) {
                case RELATIVE:
                    if (pm(str)) {
                        oY = PathType.ERROR;
                        break;
                    }
                    break;
                case ERROR:
                    if (str.startsWith("bdfile://code" + File.separator) || "bdfile://code".equals(str)) {
                        oY = PathType.RELATIVE;
                        break;
                    }
                    break;
                case BD_FILE:
                    break;
                default:
                    oY = PathType.ERROR;
                    break;
            }
        }
        return oY != PathType.ERROR;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized d asR() {
        if (this.cLD == null) {
            this.cLD = new f();
        }
        return this.cLD;
    }

    private boolean pm(String str) {
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
