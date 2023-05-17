package com.baidu.searchbox.skin.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes4.dex */
public class NightRuntime {
    public static DefaultNightContext sDefaultNightContext = new DefaultNightContext();

    @Inject(force = false)
    public static INightContext getNightContext() {
        return sDefaultNightContext;
    }
}
