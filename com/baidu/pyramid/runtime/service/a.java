package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes13.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T bCp;

    protected abstract T Pk() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T Pj() {
        synchronized (this) {
            if (this.bCp == null) {
                try {
                    this.bCp = Pk();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.bCp;
    }
}
