package com.baidu.searchbox.aperf.param.dye;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes2.dex */
public class DyeConfigManager {
    @Inject(force = false)
    public static IDyeConfig getDyeConfig() {
        return new DefaultDyeConfig();
    }
}
