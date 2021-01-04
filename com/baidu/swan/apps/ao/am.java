package com.baidu.swan.apps.ao;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes9.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aRU() {
        return a.dRX;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean vd(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.aAh(), str);
        return file.exists() && file.isDirectory();
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final am dRX = new am();
    }
}
