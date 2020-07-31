package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ap;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class w implements ap {
    private w() {
    }

    public static w Ud() {
        return a.bNo;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public com.baidu.swan.d.b e(Context context, String str, boolean z) {
        return new com.baidu.swan.d.i(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void a(@NonNull String str, Set<String> set, boolean z) {
        com.baidu.swan.apps.env.d.a(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ".xml", set, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final w bNo = new w();
    }
}
