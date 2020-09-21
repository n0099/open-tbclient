package com.baidu.swan.apps.favordata.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        e aAs = e.aAs();
        if (aAs != null && !TextUtils.equals(aAs.getAppKey(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            SwanFavorDataManager.ank().Q(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
        }
    }
}
