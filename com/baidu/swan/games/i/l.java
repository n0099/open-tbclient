package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d cYb;

    public l() {
        n.cN(n.getBasePath(), n.aNA());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rR(String str) {
        return n.rR(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rS(String str) {
        if (com.baidu.swan.apps.storage.b.rJ(str) == PathType.RELATIVE) {
            return n.rR(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rT(String str) {
        String uZ = n.uZ(str);
        if (TextUtils.isEmpty(uZ)) {
            return null;
        }
        return uZ;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rU(String str) {
        return n.vq(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rV(String str) {
        return rU(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rW(String str) {
        return n.vl("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aCZ() {
        return n.vl("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDa() {
        return n.vk(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String rI(String str) {
        return rS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rC(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rD(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aa(String str, boolean z) {
        return n.vf(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aDb() {
        if (this.cYb == null) {
            this.cYb = new m();
        }
        return this.cYb;
    }
}
