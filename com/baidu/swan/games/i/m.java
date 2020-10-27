package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import com.baidu.mobstat.Config;
/* loaded from: classes10.dex */
public class m extends com.baidu.swan.apps.storage.b.a {
    @Override // com.baidu.swan.apps.storage.b.d
    public long getMaxSize() {
        return Config.RAVEN_LOG_LIMIT;
    }

    @Override // com.baidu.swan.apps.storage.b.a
    @NonNull
    public String aIl() {
        return n.getBasePath();
    }
}
