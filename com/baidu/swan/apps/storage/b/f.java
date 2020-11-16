package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aKd() {
        String tn = com.baidu.swan.apps.storage.b.tn(com.baidu.swan.apps.runtime.d.aGI().getAppId());
        if (TextUtils.isEmpty(tn)) {
            return "";
        }
        return tn;
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return 10485760L;
    }
}
