package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aCY() {
        String rF = com.baidu.swan.apps.storage.b.rF(com.baidu.swan.apps.runtime.d.azE().getAppId());
        if (TextUtils.isEmpty(rF)) {
            return "";
        }
        return rF;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
