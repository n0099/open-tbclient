package com.baidu.searchbox.perfframe.basic;

import android.text.TextUtils;
import com.baidu.searchbox.track.ui.TrackUI;
/* loaded from: classes3.dex */
public class PerfFrameTrackUIUtil {
    public static final String SEPERATOR_ARROR = "->";

    public static String trackUI2StringPage(TrackUI trackUI) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trackUI.getActivityPage())) {
            sb.append(trackUI.getActivityPage());
            sb.append(trackUI.getActivityPageTag());
        }
        if (!TextUtils.isEmpty(trackUI.getFragmentPage())) {
            sb.append("->");
            sb.append(trackUI.getFragmentPage());
            sb.append(trackUI.getFragmentPageTag());
        }
        if (!TextUtils.isEmpty(trackUI.getPageName())) {
            sb.append("->");
            sb.append(trackUI.getPageName());
            sb.append(trackUI.getPageTag());
        }
        return sb.toString();
    }
}
