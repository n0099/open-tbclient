package com.baidu.searchbox.aideviceperformanceboxproxy.stickiness;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aideviceperformance.stickiness.IUserStickinessBusinessDataProvider;
@Autowired
/* loaded from: classes2.dex */
public class UserStickinessRuntime {
    @Inject(force = false)
    public static IUserStickinessBusinessDataProvider getDefaultHandler() {
        return new DefaultUserStickinessBusinessDataProvider();
    }
}
