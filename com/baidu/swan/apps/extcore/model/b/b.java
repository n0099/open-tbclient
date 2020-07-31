package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.d;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class b implements a {
    public static final String ckn = d.agZ() + File.separator + "extension_core";

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File afl() {
        return new File(d.agZ(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String afm() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String afn() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int afo() {
        return 0;
    }
}
