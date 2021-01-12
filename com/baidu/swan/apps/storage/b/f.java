package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aLH() {
        String sG = com.baidu.swan.apps.storage.b.sG(com.baidu.swan.apps.runtime.d.aIn().getAppId());
        if (TextUtils.isEmpty(sG)) {
            return "";
        }
        return sG;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
