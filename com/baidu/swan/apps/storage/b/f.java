package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aGr() {
        String sL = com.baidu.swan.apps.storage.b.sL(com.baidu.swan.apps.runtime.d.aCW().getAppId());
        if (TextUtils.isEmpty(sL)) {
            return "";
        }
        return sL;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
