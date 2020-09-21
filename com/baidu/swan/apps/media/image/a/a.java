package com.baidu.swan.apps.media.image.a;

import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public class a<T> implements b<T> {
    private Class<? extends T> clazz;

    public a(@NonNull Class<? extends T> cls) {
        this.clazz = cls;
    }

    @Override // com.baidu.swan.apps.media.image.a.b
    public T make() throws IllegalAccessException, InstantiationException {
        return this.clazz.newInstance();
    }
}
