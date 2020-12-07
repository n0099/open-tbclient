package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes25.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cYL;

    public a(@NonNull T t) {
        this.cYL = t;
    }

    public File awx() {
        return this.cYL.awJ();
    }

    @NonNull
    public File cc(long j) {
        return new File(awx(), String.valueOf(j));
    }
}
