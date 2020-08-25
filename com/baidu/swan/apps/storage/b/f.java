package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aCY() {
        String rE = com.baidu.swan.apps.storage.b.rE(com.baidu.swan.apps.runtime.d.azE().getAppId());
        if (TextUtils.isEmpty(rE)) {
            return "";
        }
        return rE;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
