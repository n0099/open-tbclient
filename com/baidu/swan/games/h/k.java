package com.baidu.swan.games.h;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class k implements com.baidu.swan.apps.storage.b.c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String lR(String str) {
        return l.lR(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lS(String str) {
        if (com.baidu.swan.apps.storage.b.lL(str) == PathType.RELATIVE) {
            return l.lR(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lT(String str) {
        String oy = l.oy(str);
        if (TextUtils.isEmpty(oy)) {
            return null;
        }
        return oy;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lU(String str) {
        return l.oP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lV(String str) {
        return lU(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lW(String str) {
        return l.oJ("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String acZ() {
        return l.oJ("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lK(String str) {
        return lS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lF(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean az(long j) {
        return l.aV(j);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void aA(long j) {
        l.aU(j);
    }
}
