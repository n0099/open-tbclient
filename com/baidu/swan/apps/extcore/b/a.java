package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T aQi;

    public a(@NonNull T t) {
        this.aQi = t;
    }

    public File HT() {
        return this.aQi.Ic();
    }

    @NonNull
    public File V(long j) {
        return new File(HT(), String.valueOf(j));
    }
}
