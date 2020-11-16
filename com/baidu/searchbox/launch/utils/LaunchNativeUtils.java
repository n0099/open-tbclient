package com.baidu.searchbox.launch.utils;

import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes.dex */
public class LaunchNativeUtils {
    public static native long getClkTck();

    static {
        SoLoader.load(AppRuntime.getAppContext(), "launch_native");
    }
}
