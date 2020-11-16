package com.baidu.android.bdutil.cuid.sdk;

import com.baidu.android.bdutil.cuid.api.IAppCuidManagerImpl_Factory;
/* loaded from: classes19.dex */
public class AppCuidRuntime {
    public static IAppCuidManager getAppCuidManager() {
        return IAppCuidManagerImpl_Factory.get();
    }
}
