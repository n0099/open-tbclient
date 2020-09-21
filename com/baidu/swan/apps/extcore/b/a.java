package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T ctc;

    public a(@NonNull T t) {
        this.ctc = t;
    }

    public File amQ() {
        return this.ctc.anc();
    }

    @NonNull
    public File aX(long j) {
        return new File(amQ(), String.valueOf(j));
    }
}
