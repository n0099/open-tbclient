package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes5.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T crl;

    protected abstract T aed() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T aec() {
        synchronized (this) {
            if (this.crl == null) {
                try {
                    this.crl = aed();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.crl;
    }
}
