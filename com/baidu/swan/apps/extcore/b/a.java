package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes11.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T ccV;

    public a(@NonNull T t) {
        this.ccV = t;
    }

    public File acE() {
        return this.ccV.acO();
    }

    @NonNull
    public File aQ(long j) {
        return new File(acE(), String.valueOf(j));
    }
}
