package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cqV;

    public a(@NonNull T t) {
        this.cqV = t;
    }

    public File amg() {
        return this.cqV.ams();
    }

    @NonNull
    public File aW(long j) {
        return new File(amg(), String.valueOf(j));
    }
}
