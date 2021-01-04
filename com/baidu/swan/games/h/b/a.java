package com.baidu.swan.games.h.b;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes9.dex */
public abstract class a implements com.baidu.swan.apps.extcore.model.b.a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File ayb() {
        return new File(com.baidu.swan.games.l.a.aAh(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String ayc() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String ayd() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int aye() {
        return 1;
    }
}
