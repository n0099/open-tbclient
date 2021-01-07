package com.baidu.swan.apps.extcore.b;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes9.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T ddH;

    public a(@NonNull T t) {
        this.ddH = t;
    }

    public File axQ() {
        return this.ddH.ayc();
    }

    @NonNull
    public File cd(long j) {
        return new File(axQ(), String.valueOf(j));
    }
}
