package com.baidu.pyramid.runtime.service;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    private T csZ;

    protected abstract T aeu() throws ServiceNotFoundException;

    @Override // com.baidu.pyramid.runtime.service.b
    public final T aet() {
        synchronized (this) {
            if (this.csZ == null) {
                try {
                    this.csZ = aeu();
                } catch (ServiceNotFoundException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.csZ;
    }
}
