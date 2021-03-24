package com.baidu.searchbox.afx;

import com.baidu.searchbox.afx.callback.OnReportListener;
/* loaded from: classes2.dex */
public class AlphaVideoManager {
    public static OnReportListener sOnReportListener;

    public static OnReportListener getOnReportListener() {
        return sOnReportListener;
    }

    public static void setOnReportListener(OnReportListener onReportListener) {
        sOnReportListener = onReportListener;
    }
}
