package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes8.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T coW;

    protected abstract T aga() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T afZ() {
        synchronized (this) {
            if (this.coW == null) {
                try {
                    this.coW = aga();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.coW;
    }
}
