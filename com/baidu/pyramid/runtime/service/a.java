package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes8.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T cio;

    protected abstract T acQ() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T acP() {
        synchronized (this) {
            if (this.cio == null) {
                try {
                    this.cio = acQ();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.cio;
    }
}
