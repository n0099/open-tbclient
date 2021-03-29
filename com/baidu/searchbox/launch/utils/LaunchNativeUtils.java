package com.baidu.searchbox.launch.utils;

import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class LaunchNativeUtils {
    static {
        SoLoader.load(AppRuntime.getAppContext(), "launch_native");
    }

    public static native long getClkTck();
}
