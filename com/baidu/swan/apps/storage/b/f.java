package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aMd() {
        String tg = com.baidu.swan.apps.storage.b.tg(com.baidu.swan.apps.runtime.d.aIJ().getAppId());
        if (TextUtils.isEmpty(tg)) {
            return "";
        }
        return tg;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
