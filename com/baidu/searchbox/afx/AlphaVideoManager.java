package com.baidu.searchbox.afx;

import com.baidu.searchbox.afx.callback.OnReportListener;
/* loaded from: classes5.dex */
public class AlphaVideoManager {
    private static OnReportListener sOnReportListener;

    public static OnReportListener getOnReportListener() {
        return sOnReportListener;
    }

    public static void setOnReportListener(OnReportListener onReportListener) {
        sOnReportListener = onReportListener;
    }
}
