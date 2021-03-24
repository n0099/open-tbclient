package com.baidu.searchbox.logsystem.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.b.i0.x2.n;
@Autowired
/* loaded from: classes3.dex */
public class LokiOverlayRuntime {
    public static final ILokiOverlayContext OVERLAY_EMPTY = new ILokiOverlayContext() { // from class: com.baidu.searchbox.logsystem.util.LokiOverlayRuntime.1
        @Override // com.baidu.searchbox.logsystem.util.ILokiOverlayContext
        public String getAppVersion() {
            return null;
        }
    };

    @Inject(force = false)
    public static ILokiOverlayContext getLokiOverlayContext() {
        return n.a();
    }
}
