package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes13.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T bHd;

    protected abstract T Qq() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T Qp() {
        synchronized (this) {
            if (this.bHd == null) {
                try {
                    this.bHd = Qq();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.bHd;
    }
}
