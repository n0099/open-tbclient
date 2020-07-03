package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String asO() {
        String oT = com.baidu.swan.apps.storage.b.oT(com.baidu.swan.apps.runtime.d.apI().getAppId());
        if (TextUtils.isEmpty(oT)) {
            return "";
        }
        return oT;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
