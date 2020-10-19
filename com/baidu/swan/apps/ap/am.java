package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes10.dex */
public class am implements com.baidu.swan.pms.utils.a {
    private am() {
    }

    public static am aIK() {
        return a.dpF;
    }

    @Override // com.baidu.swan.pms.utils.a
    public boolean tV(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.arV(), str);
        return file.exists() && file.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final am dpF = new am();
    }
}
