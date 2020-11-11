package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aKL() {
        String ts = com.baidu.swan.apps.storage.b.ts(com.baidu.swan.apps.runtime.d.aHq().getAppId());
        if (TextUtils.isEmpty(ts)) {
            return "";
        }
        return ts;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
