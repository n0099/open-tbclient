package com.baidu.swan.apps.favordata.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        e aoG = e.aoG();
        if (aoG != null && !TextUtils.equals(aoG.getAppKey(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            SwanFavorDataManager.acW().K(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
        }
    }
}
