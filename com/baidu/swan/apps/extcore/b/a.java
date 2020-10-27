package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cNJ;

    public a(@NonNull T t) {
        this.cNJ = t;
    }

    public File arw() {
        return this.cNJ.arI();
    }

    @NonNull
    public File bh(long j) {
        return new File(arw(), String.valueOf(j));
    }
}
