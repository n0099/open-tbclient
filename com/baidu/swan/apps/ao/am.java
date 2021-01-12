package com.baidu.swan.apps.ao;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes8.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aOb() {
        return a.dNl;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean tS(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.awo(), str);
        return file.exists() && file.isDirectory();
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final am dNl = new am();
    }
}
