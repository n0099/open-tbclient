package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d cLD;

    public l() {
        n.cq(n.getBasePath(), n.aBh());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pg(String str) {
        return n.pg(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ph(String str) {
        if (com.baidu.swan.apps.storage.b.oY(str) == PathType.RELATIVE) {
            return n.pg(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pi(String str) {
        String rJ = n.rJ(str);
        if (TextUtils.isEmpty(rJ)) {
            return null;
        }
        return rJ;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pj(String str) {
        return n.sb(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pk(String str) {
        return pj(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pl(String str) {
        return n.rV("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String asP() {
        return n.rV("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String asQ() {
        return n.rU(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oX(String str) {
        return ph(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oR(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oS(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean W(String str, boolean z) {
        return n.rP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d asR() {
        if (this.cLD == null) {
            this.cLD = new m();
        }
        return this.cLD;
    }
}
