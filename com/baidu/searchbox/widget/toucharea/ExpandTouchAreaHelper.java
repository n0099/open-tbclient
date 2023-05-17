package com.baidu.searchbox.widget.toucharea;

import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class ExpandTouchAreaHelper {
    public static final int DEFAULT_EXPAND_TOUCH_AREA = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 15.0f);
    public static final int UNIT_DP = 1;
    public static final int UNIT_PX = 0;

    public static void expandTouchArea(View view2, View view3) {
        int i = DEFAULT_EXPAND_TOUCH_AREA;
        expandTouchArea(view2, view3, i, i, i, i);
    }

    public static void expandTouchArea(View view2, View view3, int i) {
        expandTouchArea(view2, view3, i, i, i, i);
    }

    public static void expandTouchArea(View view2, View view3, int i, int i2, int i3, int i4) {
        if (view3 != null && view2 != null) {
            if (view2.getTouchDelegate() instanceof BdTouchDelegate) {
                ((BdTouchDelegate) view2.getTouchDelegate()).addExpandChild(view3, i, i2, i3, i4);
            } else {
                view2.setTouchDelegate(new BdTouchDelegate(view3, i, i2, i3, i4));
            }
        }
    }

    public static void expandTouchArea(View view2, View view3, int i, int i2, int i3, int i4, int i5) {
        if (i == 1) {
            i2 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i2);
            i3 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i3);
            i4 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i4);
            i5 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i5);
        }
        expandTouchArea(view2, view3, i2, i3, i4, i5);
    }
}
