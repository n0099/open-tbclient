package com.baidu.searchbox.player.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class BdActivityUtils {
    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void requestLandscape(@Nullable Activity activity, boolean z) {
        if (activity != null) {
            if (z) {
                activity.setRequestedOrientation(8);
            } else {
                activity.setRequestedOrientation(0);
            }
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void requestPortrait(@Nullable Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
    }
}
