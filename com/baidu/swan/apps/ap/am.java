package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes8.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aFr() {
        return a.dbr;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean sP(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.aoz(), str);
        return file.exists() && file.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final am dbr = new am();
    }
}
