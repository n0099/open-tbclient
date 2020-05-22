package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d cGT;

    public l() {
        n.co(n.getBasePath(), n.aAb());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oY(String str) {
        return n.oY(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oZ(String str) {
        if (com.baidu.swan.apps.storage.b.oQ(str) == PathType.RELATIVE) {
            return n.oY(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pa(String str) {
        String rB = n.rB(str);
        if (TextUtils.isEmpty(rB)) {
            return null;
        }
        return rB;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pb(String str) {
        return n.rT(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pc(String str) {
        return pb(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pd(String str) {
        return n.rN("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String arI() {
        return n.rN("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String arJ() {
        return n.rM(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String oP(String str) {
        return oZ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oJ(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean oK(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean U(String str, boolean z) {
        return n.rH(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d arK() {
        if (this.cGT == null) {
            this.cGT = new m();
        }
        return this.cGT;
    }
}
