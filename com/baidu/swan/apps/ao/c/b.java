package com.baidu.swan.apps.ao.c;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public abstract class b<TargeT> implements c {
    final String name;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(a aVar, ClassLoader classLoader, int i, TargeT target);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull String str) {
        this.name = str;
    }
}
