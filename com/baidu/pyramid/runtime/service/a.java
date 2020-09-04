package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T bNg;

    protected abstract T WB() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T WA() {
        synchronized (this) {
            if (this.bNg == null) {
                try {
                    this.bNg = WB();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.bNg;
    }
}
