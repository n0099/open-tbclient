package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.t.e;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class b implements a {
    public static final String bqX = e.Rx() + File.separator + "extension_core";

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File PH() {
        return new File(e.Rx(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String PI() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String PJ() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int PK() {
        return 0;
    }
}
