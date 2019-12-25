package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes9.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T bpE;

    public a(@NonNull T t) {
        this.bpE = t;
    }

    public File Pb() {
        return this.bpE.Pl();
    }

    @NonNull
    public File Y(long j) {
        return new File(Pb(), String.valueOf(j));
    }
}
