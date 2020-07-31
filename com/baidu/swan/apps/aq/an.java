package com.baidu.swan.apps.aq;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes7.dex */
public class an implements com.baidu.swan.pms.f.a {
    private an() {
    }

    public static an axi() {
        return a.cSs;
    }

    @Override // com.baidu.swan.pms.f.a
    public boolean qN(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.r.d.agZ(), str);
        return file.exists() && file.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final an cSs = new an();
    }
}
