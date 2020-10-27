package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d duR;

    public l() {
        n.cZ(n.getBasePath(), n.aSO());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tr(String str) {
        return n.tr(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ts(String str) {
        if (com.baidu.swan.apps.storage.b.tj(str) == PathType.RELATIVE) {
            return n.tr(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tt(String str) {
        String wy = n.wy(str);
        if (TextUtils.isEmpty(wy)) {
            return null;
        }
        return wy;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tu(String str) {
        return n.wP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tv(String str) {
        return tu(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tw(String str) {
        return n.wK("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aIm() {
        return n.wK("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aIn() {
        return n.wJ(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ti(String str) {
        return ts(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tc(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean td(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        return n.wE(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aIo() {
        if (this.duR == null) {
            this.duR = new m();
        }
        return this.duR;
    }
}
