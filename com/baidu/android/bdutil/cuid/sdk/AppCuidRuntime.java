package com.baidu.android.bdutil.cuid.sdk;

import com.baidu.android.bdutil.cuid.api.IAppCuidManagerImpl_Factory;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes.dex */
public class AppCuidRuntime {
    @Inject(force = false)
    public static IAppCuidManager getAppCuidManager() {
        return IAppCuidManagerImpl_Factory.get();
    }
}
