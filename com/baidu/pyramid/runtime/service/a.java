package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes10.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T ceo;

    protected abstract T aba() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T aaZ() {
        synchronized (this) {
            if (this.ceo == null) {
                try {
                    this.ceo = aba();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.ceo;
    }
}
