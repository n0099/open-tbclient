package com.baidu.swan.games.g.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a implements com.baidu.swan.apps.extcore.model.b.a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File PH() {
        return new File(com.baidu.swan.games.k.a.Rx(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String PI() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String PJ() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int PK() {
        return 1;
    }
}
