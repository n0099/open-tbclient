package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T cRS;

    public a(@NonNull T t) {
        this.cRS = t;
    }

    public File atp() {
        return this.cRS.atB();
    }

    @NonNull
    public File bD(long j) {
        return new File(atp(), String.valueOf(j));
    }
}
