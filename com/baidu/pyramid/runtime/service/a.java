package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes5.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T cwc;

    protected abstract T ahX() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T ahW() {
        synchronized (this) {
            if (this.cwc == null) {
                try {
                    this.cwc = ahX();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.cwc;
    }
}
