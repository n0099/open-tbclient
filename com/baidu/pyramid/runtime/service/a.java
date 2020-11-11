package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes10.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T cjZ;

    protected abstract T adz() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T ady() {
        synchronized (this) {
            if (this.cjZ == null) {
                try {
                    this.cjZ = adz();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.cjZ;
    }
}
