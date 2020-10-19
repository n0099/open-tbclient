package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes10.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T bVP;

    protected abstract T Zh() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T Zg() {
        synchronized (this) {
            if (this.bVP == null) {
                try {
                    this.bVP = Zh();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.bVP;
    }
}
