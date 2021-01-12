package com.baidu.swan.apps.extcore.b;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cYR;

    public a(@NonNull T t) {
        this.cYR = t;
    }

    public File atW() {
        return this.cYR.aui();
    }

    @NonNull
    public File cd(long j) {
        return new File(atW(), String.valueOf(j));
    }
}
