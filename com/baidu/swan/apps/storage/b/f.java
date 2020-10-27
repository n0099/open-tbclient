package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aIl() {
        String te = com.baidu.swan.apps.storage.b.te(com.baidu.swan.apps.runtime.d.aEQ().getAppId());
        if (TextUtils.isEmpty(te)) {
            return "";
        }
        return te;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
