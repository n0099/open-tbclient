package com.baidu.searchbox.launch;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes3.dex */
public class SmartLaunchRuntime {
    @Inject(force = false)
    public static IDyeConfig getDyeConfig() {
        return IDyeConfig.EMPTY;
    }
}
