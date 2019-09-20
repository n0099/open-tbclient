package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.install.e;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class b implements a {
    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File Di() {
        return new File(e.Ed(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String Dj() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String Dk() {
        return "aiapps/extcore/extension-config.json";
    }
}
