package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T bPg;

    protected abstract T Xk() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T Xj() {
        synchronized (this) {
            if (this.bPg == null) {
                try {
                    this.bPg = Xk();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.bPg;
    }
}
