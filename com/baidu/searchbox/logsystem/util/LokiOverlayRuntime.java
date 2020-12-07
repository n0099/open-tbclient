package com.baidu.searchbox.logsystem.util;

import com.baidu.tieba.r.l;
/* loaded from: classes20.dex */
public class LokiOverlayRuntime {
    private static final ILokiOverlayContext OVERLAY_EMPTY = new ILokiOverlayContext() { // from class: com.baidu.searchbox.logsystem.util.LokiOverlayRuntime.1
        @Override // com.baidu.searchbox.logsystem.util.ILokiOverlayContext
        public String getAppVersion() {
            return null;
        }
    };

    public static ILokiOverlayContext getLokiOverlayContext() {
        return l.dLT();
    }
}
