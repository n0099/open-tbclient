package com.baidu.swan.apps.core.b;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {
    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting ag(String str, @NonNull String str2) {
        V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
        codeCacheSetting.id = str;
        codeCacheSetting.sizeLimit = 204800;
        codeCacheSetting.maxCount = 5;
        codeCacheSetting.pathList = new ArrayList<>();
        codeCacheSetting.pathList.add(str2);
        return codeCacheSetting;
    }

    public static int i(boolean z, boolean z2) {
        if (z && z2) {
            return 3;
        }
        if (z) {
            return 1;
        }
        if (z2) {
            return 2;
        }
        return 0;
    }
}
