package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes10.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aNe() {
        return a.dDX;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean uC(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.awq(), str);
        return file.exists() && file.isDirectory();
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final am dDX = new am();
    }
}
