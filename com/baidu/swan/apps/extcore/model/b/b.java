package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.install.e;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class b implements a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File De() {
        return new File(e.DZ(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String Df() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String Dg() {
        return "aiapps/extcore/extension-config.json";
    }
}
