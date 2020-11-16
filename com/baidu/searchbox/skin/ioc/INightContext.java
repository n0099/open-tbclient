package com.baidu.searchbox.skin.ioc;

import com.baidu.searchbox.skin.callback.NightModeChangeListener;
/* loaded from: classes18.dex */
public interface INightContext {
    void forceSyncNightModeState(boolean z);

    boolean getNightModeSwitcherState();

    void setNightModeSwitcherState(boolean z);

    boolean shouldShowNightModeBubble();

    void subscribeNightModeChangeEvent(Object obj, NightModeChangeListener nightModeChangeListener);

    void unsubscribeNightModeChangedEvent(Object obj);
}
