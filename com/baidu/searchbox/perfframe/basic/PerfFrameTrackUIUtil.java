package com.baidu.searchbox.perfframe.basic;

import android.text.TextUtils;
import com.baidu.searchbox.track.ui.TrackUI;
/* loaded from: classes15.dex */
public class PerfFrameTrackUIUtil {
    public static final String SEPERATOR_ARROR = "->";

    public static String trackUI2StringPage(TrackUI trackUI) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trackUI.getActivityPage())) {
            sb.append(trackUI.getActivityPage()).append(trackUI.getActivityPageTag());
        }
        if (!TextUtils.isEmpty(trackUI.getFragmentPage())) {
            sb.append(SEPERATOR_ARROR);
            sb.append(trackUI.getFragmentPage()).append(trackUI.getFragmentPageTag());
        }
        if (!TextUtils.isEmpty(trackUI.getPageName())) {
            sb.append(SEPERATOR_ARROR);
            sb.append(trackUI.getPageName()).append(trackUI.getPageTag());
        }
        return sb.toString();
    }
}
