package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aMa() {
        String sZ = com.baidu.swan.apps.storage.b.sZ(com.baidu.swan.apps.runtime.d.aIG().getAppId());
        if (TextUtils.isEmpty(sZ)) {
            return "";
        }
        return sZ;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
