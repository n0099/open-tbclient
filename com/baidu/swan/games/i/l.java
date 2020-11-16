package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes7.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dzc;

    public l() {
        n.cY(n.getBasePath(), n.aUG());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tA(String str) {
        return n.tA(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tB(String str) {
        if (com.baidu.swan.apps.storage.b.ts(str) == PathType.RELATIVE) {
            return n.tA(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tC(String str) {
        String wH = n.wH(str);
        if (TextUtils.isEmpty(wH)) {
            return null;
        }
        return wH;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tD(String str) {
        return n.wY(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tE(String str) {
        return tD(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tF(String str) {
        return n.wT("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKe() {
        return n.wT("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKf() {
        return n.wS(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tr(String str) {
        return tB(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tl(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tm(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        return n.wN(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aKg() {
        if (this.dzc == null) {
            this.dzc = new m();
        }
        return this.dzc;
    }
}
