package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes3.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aGb() {
        return a.ddx;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean tj(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.apk(), str);
        return file.exists() && file.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final am ddx = new am();
    }
}
