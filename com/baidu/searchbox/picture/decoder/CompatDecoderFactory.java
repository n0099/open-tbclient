package com.baidu.searchbox.picture.decoder;

import android.support.annotation.NonNull;
/* loaded from: classes13.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private Class<? extends T> clazz;

    public CompatDecoderFactory(@NonNull Class<? extends T> cls) {
        this.clazz = cls;
    }

    @Override // com.baidu.searchbox.picture.decoder.DecoderFactory
    public T make() throws IllegalAccessException, InstantiationException {
        return this.clazz.newInstance();
    }
}
