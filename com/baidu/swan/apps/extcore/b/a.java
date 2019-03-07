package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.extcore.model.b.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> {
    private static final boolean DEBUG = c.DEBUG;
    @NonNull
    protected T avs;

    public a(@NonNull T t) {
        this.avs = t;
    }

    public File Bl() {
        return this.avs.Bv();
    }

    @NonNull
    public File t(long j) {
        return new File(Bl(), String.valueOf(j));
    }
}
