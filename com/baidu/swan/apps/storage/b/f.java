package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String auP() {
        String pE = com.baidu.swan.apps.storage.b.pE(com.baidu.swan.apps.runtime.d.arr().getAppId());
        if (TextUtils.isEmpty(pE)) {
            return "";
        }
        return pE;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
