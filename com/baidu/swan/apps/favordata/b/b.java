package com.baidu.swan.apps.favordata.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        e aEV = e.aEV();
        if (aEV != null && !TextUtils.equals(aEV.getAppKey(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            SwanFavorDataManager.arQ().W(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
        }
    }
}
