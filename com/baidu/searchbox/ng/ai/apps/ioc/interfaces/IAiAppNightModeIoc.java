package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.res.Resources;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeChangeListener;
/* loaded from: classes2.dex */
public interface IAiAppNightModeIoc {
    void forceSyncNightModeState(boolean z);

    boolean getNightModeSwitcherState();

    Resources getSkinResources();

    void setNightMode(boolean z);

    void setNightModeSwitcherState(boolean z);

    void subscribeNightModeChangeEvent(Object obj, AiAppNightModeChangeListener aiAppNightModeChangeListener);

    void unsubscribeNightModeChangedEvent(Object obj);
}
