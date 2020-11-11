package com.baidu.swan.games.h.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a implements com.baidu.swan.apps.extcore.model.b.a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File auj() {
        return new File(com.baidu.swan.games.l.a.awq(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String auk() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String aul() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int aum() {
        return 1;
    }
}
