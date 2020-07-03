package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes11.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T chJ;

    public a(@NonNull T t) {
        this.chJ = t;
    }

    public File adK() {
        return this.chJ.adU();
    }

    @NonNull
    public File aQ(long j) {
        return new File(adK(), String.valueOf(j));
    }
}
