package com.baidu.searchbox.skin;

import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.NightRuntime;
/* loaded from: classes12.dex */
public final class NightModeHelper {
    private NightModeHelper() {
    }

    public static void setNightModeSwitcherState(boolean z) {
        NightRuntime.getNightContext().setNightModeSwitcherState(z);
    }

    public static boolean getNightModeSwitcherState() {
        return NightRuntime.getNightContext().getNightModeSwitcherState();
    }

    public static void forceSyncNightModeState(boolean z) {
        NightRuntime.getNightContext().forceSyncNightModeState(z);
    }

    public static boolean shouldShowNightModeBubble() {
        return NightRuntime.getNightContext().shouldShowNightModeBubble();
    }

    public static void subscribeNightModeChangeEvent(Object obj, NightModeChangeListener nightModeChangeListener) {
        NightRuntime.getNightContext().subscribeNightModeChangeEvent(obj, nightModeChangeListener);
    }

    public static void unsubscribeNightModeChangedEvent(Object obj) {
        NightRuntime.getNightContext().unsubscribeNightModeChangedEvent(obj);
    }
}
