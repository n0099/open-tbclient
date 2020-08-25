package com.baidu.swan.games.h.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class a implements com.baidu.swan.apps.extcore.model.b.a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File ams() {
        return new File(com.baidu.swan.games.l.a.aoz(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String amt() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String amu() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int amv() {
        return 1;
    }
}
