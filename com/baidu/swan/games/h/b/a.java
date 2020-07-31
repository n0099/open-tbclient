package com.baidu.swan.games.h.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class a implements com.baidu.swan.apps.extcore.model.b.a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File afl() {
        return new File(com.baidu.swan.games.l.a.agZ(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String afm() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String afn() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int afo() {
        return 1;
    }
}
