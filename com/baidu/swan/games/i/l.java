package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d cYf;

    public l() {
        n.cN(n.getBasePath(), n.aNA());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rS(String str) {
        return n.rS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rT(String str) {
        if (com.baidu.swan.apps.storage.b.rK(str) == PathType.RELATIVE) {
            return n.rS(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rU(String str) {
        String va = n.va(str);
        if (TextUtils.isEmpty(va)) {
            return null;
        }
        return va;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rV(String str) {
        return n.vr(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rW(String str) {
        return rV(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rX(String str) {
        return n.vm("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aCZ() {
        return n.vm("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDa() {
        return n.vl(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rJ(String str) {
        return rT(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rD(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rE(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aa(String str, boolean z) {
        return n.vg(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aDb() {
        if (this.cYf == null) {
            this.cYf = new m();
        }
        return this.cYf;
    }
}
