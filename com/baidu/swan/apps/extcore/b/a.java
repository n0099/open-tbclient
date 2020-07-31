package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cjI;

    public a(@NonNull T t) {
        this.cjI = t;
    }

    public File afa() {
        return this.cjI.afl();
    }

    @NonNull
    public File aT(long j) {
        return new File(afa(), String.valueOf(j));
    }
}
