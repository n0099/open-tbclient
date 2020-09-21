package com.baidu.searchbox.skin.ioc;

import com.baidu.searchbox.skin.callback.NightModeChangeListener;
/* loaded from: classes17.dex */
public class DefaultNightContext implements INightContext {
    @Override // com.baidu.searchbox.skin.ioc.INightContext
    public void setNightModeSwitcherState(boolean z) {
    }

    @Override // com.baidu.searchbox.skin.ioc.INightContext
    public boolean getNightModeSwitcherState() {
        return false;
    }

    @Override // com.baidu.searchbox.skin.ioc.INightContext
    public void forceSyncNightModeState(boolean z) {
    }

    @Override // com.baidu.searchbox.skin.ioc.INightContext
    public boolean shouldShowNightModeBubble() {
        return false;
    }

    @Override // com.baidu.searchbox.skin.ioc.INightContext
    public void subscribeNightModeChangeEvent(Object obj, NightModeChangeListener nightModeChangeListener) {
    }

    @Override // com.baidu.searchbox.skin.ioc.INightContext
    public void unsubscribeNightModeChangedEvent(Object obj) {
    }
}
