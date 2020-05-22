package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.an;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class v implements an {
    private v() {
    }

    public static v Sx() {
        return a.bHL;
    }

    @Override // com.baidu.swan.apps.adaptation.a.an
    public com.baidu.swan.e.b e(Context context, String str, boolean z) {
        return new com.baidu.swan.e.j(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.an
    public void a(@NonNull String str, Set<String> set, boolean z) {
        com.baidu.swan.apps.env.d.a(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ".xml", set, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final v bHL = new v();
    }
}
