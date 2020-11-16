package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes7.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aMw() {
        return a.dCq;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean ux(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.avI(), str);
        return file.exists() && file.isDirectory();
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final am dCq = new am();
    }
}
