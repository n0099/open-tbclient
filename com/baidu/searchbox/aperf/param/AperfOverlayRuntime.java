package com.baidu.searchbox.aperf.param;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.toa;
@Autowired
/* loaded from: classes3.dex */
public class AperfOverlayRuntime {
    public static final IAperfOverlayContext OVERLAY_EMPTY = new IAperfOverlayContext() { // from class: com.baidu.searchbox.aperf.param.AperfOverlayRuntime.1
        @Override // com.baidu.searchbox.aperf.param.IAperfOverlayContext
        public String getAppVersion() {
            return null;
        }
    };

    @Inject(force = false)
    public static IAperfOverlayContext getAperfOverlayContext() {
        return toa.a();
    }
}
