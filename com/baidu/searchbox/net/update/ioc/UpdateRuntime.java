package com.baidu.searchbox.net.update.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes2.dex */
public class UpdateRuntime {
    public static DefaultUpdateContext sDefaultUpdateContext = new DefaultUpdateContext();

    @Inject(force = false)
    public static IUpdateContext getUpdateContext() {
        return sDefaultUpdateContext;
    }
}
