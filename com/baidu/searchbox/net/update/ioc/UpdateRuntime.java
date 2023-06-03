package com.baidu.searchbox.net.update.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes4.dex */
public class UpdateRuntime {
    public static DefaultUpdateContext sDefaultUpdateContext = new DefaultUpdateContext();
    public static DefaultPreloadContext sDefaultPreloadContext = new DefaultPreloadContext();

    @Inject(force = false)
    public static IPreloadContext getPreloadContext() {
        return sDefaultPreloadContext;
    }

    @Inject(force = false)
    public static IUpdateContext getUpdateContext() {
        return sDefaultUpdateContext;
    }
}
