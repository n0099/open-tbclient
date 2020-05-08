package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes13.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T buM;

    protected abstract T MX() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T MW() {
        synchronized (this) {
            if (this.buM == null) {
                try {
                    this.buM = MX();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.buM;
    }
}
