package com.baidu.searchbox.aperf.param;

import com.baidu.tieba.q.b;
/* loaded from: classes6.dex */
public class AperfOverlayRuntime {
    private static final IAperfOverlayContext OVERLAY_EMPTY = new IAperfOverlayContext() { // from class: com.baidu.searchbox.aperf.param.AperfOverlayRuntime.1
        @Override // com.baidu.searchbox.aperf.param.IAperfOverlayContext
        public String getAppVersion() {
            return null;
        }
    };

    public static IAperfOverlayContext getAperfOverlayContext() {
        return b.dHP();
    }
}
