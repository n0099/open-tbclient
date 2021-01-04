package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aPA() {
        String tR = com.baidu.swan.apps.storage.b.tR(com.baidu.swan.apps.runtime.d.aMg().getAppId());
        if (TextUtils.isEmpty(tR)) {
            return "";
        }
        return tR;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
