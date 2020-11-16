package com.baidu.swan.apps.favordata.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        e aGN = e.aGN();
        if (aGN != null && !TextUtils.equals(aGN.getAppKey(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            SwanFavorDataManager.atJ().W(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
        }
    }
}
