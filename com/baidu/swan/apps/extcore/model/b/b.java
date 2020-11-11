package com.baidu.swan.apps.extcore.model.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.d;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class b implements a {
    public static final String cUf = d.awq() + File.separator + "extension_core";

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public File auj() {
        return new File(d.awq(), "extension_core");
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String auk() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    @NonNull
    public String aul() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // com.baidu.swan.apps.extcore.model.b.a
    public int aum() {
        return 0;
    }
}
