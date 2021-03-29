package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes2.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    public static ServiceManager f10887b;

    /* renamed from: a  reason: collision with root package name */
    public ISAccountManager f10888a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f10887b == null) {
                f10887b = new ServiceManager();
            }
            serviceManager = f10887b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f10888a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f10888a = iSAccountManager;
    }
}
