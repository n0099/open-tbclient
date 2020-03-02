package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes11.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T buD;

    public a(@NonNull T t) {
        this.buD = t;
    }

    public File RN() {
        return this.buD.RX();
    }

    @NonNull
    public File af(long j) {
        return new File(RN(), String.valueOf(j));
    }
}
