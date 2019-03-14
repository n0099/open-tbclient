package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    protected T avt;

    public a(@NonNull T t) {
        this.avt = t;
    }

    public File Bl() {
        return this.avt.Bv();
    }

    @NonNull
    public File t(long j) {
        return new File(Bl(), String.valueOf(j));
    }
}
