package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes11.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T bTc;

    public a(@NonNull T t) {
        this.bTc = t;
    }

    public File ZE() {
        return this.bTc.ZO();
    }

    @NonNull
    public File aJ(long j) {
        return new File(ZE(), String.valueOf(j));
    }
}
