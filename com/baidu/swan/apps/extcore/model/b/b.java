package com.baidu.swan.apps.extcore.model.b;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.r.d;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class b implements a {
    public static final String cZu = d.awo() + File.separator + "extension_core";

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File aui() {
        return new File(d.awo(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String auj() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String auk() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int aul() {
        return 0;
    }
}
