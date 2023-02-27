package com.baidu.searchbox.aperf.param.launch;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes2.dex */
public class LaunchTypeManager {
    @Inject(force = false)
    public static ILaunchType getLaunchType() {
        return new DefaultLaunchType();
    }
}
