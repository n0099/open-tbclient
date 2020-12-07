package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes25.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aNk() {
        String tU = com.baidu.swan.apps.storage.b.tU(com.baidu.swan.apps.runtime.d.aJQ().getAppId());
        if (TextUtils.isEmpty(tU)) {
            return "";
        }
        return tU;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
