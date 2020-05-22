package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.e;
import java.io.File;
/* loaded from: classes11.dex */
public abstract class b implements a {
    public static final String cdB = e.aeI() + File.separator + "extension_core";

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File acO() {
        return new File(e.aeI(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String acP() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String acQ() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int acR() {
        return 0;
    }
}
