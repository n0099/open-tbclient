package com.baidu.searchbox.ruka.basic;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.track.ui.TrackUI;
/* loaded from: classes2.dex */
public class RukaTrackUIUtil {
    public static final String SEPERATOR_ARROR = "->";

    public static String trackUI2StringPage(@NonNull TrackUI trackUI) {
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
        return sb.toString();
    }
}
