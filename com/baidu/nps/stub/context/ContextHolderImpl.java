package com.baidu.nps.stub.context;

import android.app.Application;
/* loaded from: classes2.dex */
public class ContextHolderImpl extends ContextHolder {
    public static Application sApplication;
    public static ContextHolderImpl sInstance = new ContextHolderImpl();

    public static synchronized Application getApplicationContext() {
        Application application;
        synchronized (ContextHolderImpl.class) {
            if (sApplication == null) {
                sApplication = getInstance().getContextInternal();
            }
            application = sApplication;
        }
        return application;
    }

    public static ContextHolderImpl getInstance() {
        return sInstance;
    }

    @Override // com.baidu.nps.stub.context.ContextHolder
    public String getPackageName() {
        return null;
    }
}
