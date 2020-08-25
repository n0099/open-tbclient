package com.baidu.swan.apps.favordata.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        SwanFavorDataManager.amA().Q(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
    }
}
