package com.baidu.searchbox.widget.toucharea;

import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes14.dex */
public class ExpandTouchAreaHelper {
    public static final int UNIT_DP = 1;
    public static final int UNIT_PX = 0;

    public static void expandTouchArea(View view, View view2, int i, int i2, int i3, int i4) {
        if (view2 != null && view != null) {
            if (view.getTouchDelegate() instanceof BdTouchDelegate) {
                ((BdTouchDelegate) view.getTouchDelegate()).addExpandChild(view2, i, i2, i3, i4);
            } else {
                view.setTouchDelegate(new BdTouchDelegate(view2, i, i2, i3, i4));
            }
        }
    }

    public static void expandTouchArea(View view, View view2, int i) {
        expandTouchArea(view, view2, i, i, i, i);
    }

    public static void expandTouchArea(View view, View view2, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (i == 1) {
            i9 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i2);
            i8 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i3);
            i7 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i4);
            i6 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i5);
        } else {
            i6 = i5;
            i7 = i4;
            i8 = i3;
            i9 = i2;
        }
        expandTouchArea(view, view2, i9, i8, i7, i6);
    }
}
