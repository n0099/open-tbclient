package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String arH() {
        String oL = com.baidu.swan.apps.storage.b.oL(com.baidu.swan.apps.runtime.d.aoB().getAppId());
        if (TextUtils.isEmpty(oL)) {
            return "";
        }
        return oL;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
