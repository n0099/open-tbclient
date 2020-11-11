package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cTC;

    public a(@NonNull T t) {
        this.cTC = t;
    }

    public File atX() {
        return this.cTC.auj();
    }

    @NonNull
    public File bD(long j) {
        return new File(atX(), String.valueOf(j));
    }
}
