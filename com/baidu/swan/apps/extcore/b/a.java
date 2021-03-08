package com.baidu.swan.apps.extcore.b;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T dcF;

    public a(@NonNull T t) {
        this.dcF = t;
    }

    public File aux() {
        return this.dcF.auJ();
    }

    @NonNull
    public File cj(long j) {
        return new File(aux(), String.valueOf(j));
    }
}
