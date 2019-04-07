package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T avw;

    public a(@NonNull T t) {
        this.avw = t;
    }

    public File Bj() {
        return this.avw.Bt();
    }

    @NonNull
    public File t(long j) {
        return new File(Bj(), String.valueOf(j));
    }
}
