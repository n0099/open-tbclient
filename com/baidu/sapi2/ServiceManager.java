package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes.dex */
public class ServiceManager {
    private static ServiceManager a;
    private ISAccountManager b;

    public static ServiceManager getInstance() {
        if (a == null) {
            a = new ServiceManager();
        }
        return a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.b = iSAccountManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.b;
    }
}
