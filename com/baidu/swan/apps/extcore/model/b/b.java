package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.install.c;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class b implements a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File Bt() {
        return new File(c.Co(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String Bu() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String Bv() {
        return "aiapps/extcore/extension-config.json";
    }
}
