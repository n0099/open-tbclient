package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cFn;

    public a(@NonNull T t) {
        this.cFn = t;
    }

    public File apC() {
        return this.cFn.apO();
    }

    @NonNull
    public File bf(long j) {
        return new File(apC(), String.valueOf(j));
    }
}
