package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.au;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class z implements au {
    private z() {
    }

    public static z aae() {
        return a.bSM;
    }

    @Override // com.baidu.swan.apps.adaptation.a.au
    public com.baidu.swan.c.b e(Context context, String str, boolean z) {
        return new com.baidu.swan.c.i(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.au
    public void a(@NonNull String str, Set<String> set, boolean z) {
        com.baidu.swan.apps.env.d.a(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ".xml", set, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final z bSM = new z();
    }
}
