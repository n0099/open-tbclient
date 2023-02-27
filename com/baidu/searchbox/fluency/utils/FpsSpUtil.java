package com.baidu.searchbox.fluency.utils;
/* loaded from: classes2.dex */
public class FpsSpUtil {
    public static final String KEY_FPS_FLOAT_VIEW_SWITCH = "key_fps_float_view_switch";

    public static boolean getFpsFloatSwitch() {
        return SharedPrefsUtil.getBoolean(KEY_FPS_FLOAT_VIEW_SWITCH, false);
    }

    public static void putFpsFloatSwitch(boolean z) {
        SharedPrefsUtil.putBoolean(KEY_FPS_FLOAT_VIEW_SWITCH, z);
    }
}
