package com.baidu.searchbox.ng.ai.apps.skin;

import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
/* loaded from: classes2.dex */
public final class AiAppNightModeHelper {
    private AiAppNightModeHelper() {
    }

    public static void setNightModeSwitcherState(boolean z) {
        AiAppsRuntime.getNightModeRuntime().setNightModeSwitcherState(z);
    }

    public static void forceSyncNightModeState(boolean z) {
        AiAppsRuntime.getNightModeRuntime().forceSyncNightModeState(z);
    }

    public static void setNightMode(boolean z) {
        AiAppsRuntime.getNightModeRuntime().setNightMode(z);
    }

    public static boolean getNightModeSwitcherState() {
        return AiAppsRuntime.getNightModeRuntime().getNightModeSwitcherState();
    }

    public static void subscribeNightModeChangeEvent(Object obj, AiAppNightModeChangeListener aiAppNightModeChangeListener) {
        AiAppsRuntime.getNightModeRuntime().subscribeNightModeChangeEvent(obj, aiAppNightModeChangeListener);
    }

    public static void unsubscribeNightModeChangedEvent(Object obj) {
        AiAppsRuntime.getNightModeRuntime().unsubscribeNightModeChangedEvent(obj);
    }
}
