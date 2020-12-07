package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.d;
import java.io.File;
/* loaded from: classes25.dex */
public abstract class b implements a {
    public static final String cZo = d.ayQ() + File.separator + "extension_core";

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File awJ() {
        return new File(d.ayQ(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String awK() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String awL() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int awM() {
        return 0;
    }
}
