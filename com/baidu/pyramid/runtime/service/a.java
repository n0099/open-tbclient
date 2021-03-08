package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T cuE;

    protected abstract T aex() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T aew() {
        synchronized (this) {
            if (this.cuE == null) {
                try {
                    this.cuE = aex();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.cuE;
    }
}
