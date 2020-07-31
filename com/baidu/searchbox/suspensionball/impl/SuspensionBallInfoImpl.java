package com.baidu.searchbox.suspensionball.impl;

import com.baidu.searchbox.suspensionball.SuspensionBallManager;
import com.baidu.searchbox.suspensionball.anim.ioc.ISuspensionBallInfo;
/* loaded from: classes18.dex */
public class SuspensionBallInfoImpl implements ISuspensionBallInfo {
    @Override // com.baidu.searchbox.suspensionball.anim.ioc.ISuspensionBallInfo
    public int getBallCenterXCoordinate() {
        return SuspensionBallManager.getInstance().getBallCenterXCoordinate();
    }

    @Override // com.baidu.searchbox.suspensionball.anim.ioc.ISuspensionBallInfo
    public int getBallCenterYCoordinate() {
        return SuspensionBallManager.getInstance().getBallCenterYCoordinate();
    }
}
