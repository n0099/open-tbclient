package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes25.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aPC() {
        return a.dJo;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean ve(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.ayQ(), str);
        return file.exists() && file.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private static final am dJo = new am();
    }
}
