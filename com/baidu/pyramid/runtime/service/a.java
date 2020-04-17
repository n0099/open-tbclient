package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes13.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T buH;

    protected abstract T MY() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T MX() {
        synchronized (this) {
            if (this.buH == null) {
                try {
                    this.buH = MY();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.buH;
    }
}
