package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public interface IWNavigatorListener {
    void onNaviExit();

    void onPageJump(int i2, Object obj);

    void onWalkNaviModeChange(int i2, WalkNaviModeSwitchListener walkNaviModeSwitchListener);
}
