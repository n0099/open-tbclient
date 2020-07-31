package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes8.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T bHC;

    protected abstract T QF() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T QE() {
        synchronized (this) {
            if (this.bHC == null) {
                try {
                    this.bHC = QF();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.bHC;
    }
}
