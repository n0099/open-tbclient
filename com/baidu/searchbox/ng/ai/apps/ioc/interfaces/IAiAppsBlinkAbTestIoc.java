package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;
/* loaded from: classes2.dex */
public interface IAiAppsBlinkAbTestIoc {
    public static final int PRELOAD_DELAY_MS = 15000;

    int getPreloadABSwitch();

    boolean isDisablePreload(int i);

    boolean isEnableDelayPreload(int i);
}
