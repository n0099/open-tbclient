package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes2.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    public static ServiceManager f10471b;

    /* renamed from: a  reason: collision with root package name */
    public ISAccountManager f10472a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f10471b == null) {
                f10471b = new ServiceManager();
            }
            serviceManager = f10471b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f10472a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f10472a = iSAccountManager;
    }
}
