package com.baidu.swan.apps.ap.c;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public abstract class b<TargeT> implements c {
    final String name;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(a aVar, ClassLoader classLoader, int i, TargeT target);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull String str) {
        this.name = str;
    }
}
