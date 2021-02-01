package com.baidu.swan.games.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes9.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dLX;

    public l() {
        n.cX(n.getBasePath(), n.aWy());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tm(String str) {
        return n.tm(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tn(String str) {
        if (com.baidu.swan.apps.storage.b.te(str) == PathType.RELATIVE) {
            return n.tm(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String to(String str) {
        String wv = n.wv(str);
        if (TextUtils.isEmpty(wv)) {
            return null;
        }
        return wv;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tp(String str) {
        return n.wM(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tq(String str) {
        return tp(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tr(String str) {
        return n.wH("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMb() {
        return n.wH("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aMc() {
        return n.wG(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String td(String str) {
        return tn(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sX(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sY(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        return n.wB(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aMd() {
        if (this.dLX == null) {
            this.dLX = new m();
        }
        return this.dLX;
    }
}
