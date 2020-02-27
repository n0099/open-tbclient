package com.baidu.swan.games.h;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class k implements com.baidu.swan.apps.storage.b.c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String mg(String str) {
        return l.mg(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mh(String str) {
        if (com.baidu.swan.apps.storage.b.ma(str) == PathType.RELATIVE) {
            return l.mg(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mi(String str) {
        String oN = l.oN(str);
        if (TextUtils.isEmpty(oN)) {
            return null;
        }
        return oN;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mj(String str) {
        return l.pe(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mk(String str) {
        return mj(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ml(String str) {
        return l.oY("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String afn() {
        return l.oY("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lZ(String str) {
        return mh(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lU(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aD(long j) {
        return l.aZ(j);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void aE(long j) {
        l.aY(j);
    }
}
