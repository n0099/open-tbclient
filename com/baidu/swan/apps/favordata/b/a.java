package com.baidu.swan.apps.favordata.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        SwanFavorDataManager.aft().L(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
    }
}
