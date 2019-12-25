package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes11.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T mCachedInstance;

    protected abstract T createService() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T getService() {
        synchronized (this) {
            if (this.mCachedInstance == null) {
                try {
                    this.mCachedInstance = createService();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.mCachedInstance;
    }
}
