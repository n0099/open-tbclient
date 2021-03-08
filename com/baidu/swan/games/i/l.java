package com.baidu.swan.games.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dNy;

    public l() {
        n.cX(n.getBasePath(), n.aWB());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tt(String str) {
        return n.tt(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tu(String str) {
        if (com.baidu.swan.apps.storage.b.tl(str) == PathType.RELATIVE) {
            return n.tt(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tv(String str) {
        String wC = n.wC(str);
        if (TextUtils.isEmpty(wC)) {
            return null;
        }
        return wC;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tw(String str) {
        return n.wT(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tx(String str) {
        return tw(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ty(String str) {
        return n.wO("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMe() {
        return n.wO("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMf() {
        return n.wN(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tk(String str) {
        return tu(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean te(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tf(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        return n.wI(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aMg() {
        if (this.dNy == null) {
            this.dNy = new m();
        }
        return this.dNy;
    }
}
