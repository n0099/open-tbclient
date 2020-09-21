package com.baidu.swan.facade.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.scheme.j;
import java.util.Map;
/* loaded from: classes3.dex */
interface d {
    void a(j jVar);

    @Nullable
    Map<String, Object> getV8ApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar);

    @Nullable
    Map<String, Object> getWebviewApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar);
}
