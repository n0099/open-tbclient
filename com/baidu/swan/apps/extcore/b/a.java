package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T bqs;

    public a(@NonNull T t) {
        this.bqs = t;
    }

    public File Px() {
        return this.bqs.PH();
    }

    @NonNull
    public File ab(long j) {
        return new File(Px(), String.valueOf(j));
    }
}
