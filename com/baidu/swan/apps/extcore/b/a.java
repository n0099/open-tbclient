package com.baidu.swan.apps.extcore.b;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes9.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T dbd;

    public a(@NonNull T t) {
        this.dbd = t;
    }

    public File auu() {
        return this.dbd.auG();
    }

    @NonNull
    public File cj(long j) {
        return new File(auu(), String.valueOf(j));
    }
}
