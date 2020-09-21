package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aDI() {
        String rY = com.baidu.swan.apps.storage.b.rY(com.baidu.swan.apps.runtime.d.aAn().getAppId());
        if (TextUtils.isEmpty(rY)) {
            return "";
        }
        return rY;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
