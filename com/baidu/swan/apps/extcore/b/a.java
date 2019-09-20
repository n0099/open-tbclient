package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T awT;

    public a(@NonNull T t) {
        this.awT = t;
    }

    public File CZ() {
        return this.awT.Di();
    }

    @NonNull
    public File C(long j) {
        return new File(CZ(), String.valueOf(j));
    }
}
