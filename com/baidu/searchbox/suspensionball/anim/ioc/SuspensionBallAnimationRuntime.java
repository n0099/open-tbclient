package com.baidu.searchbox.suspensionball.anim.ioc;

import com.baidu.searchbox.suspensionball.impl.SuspensionBallInfoImpl_Factory;
/* loaded from: classes4.dex */
public class SuspensionBallAnimationRuntime {
    public static ISuspensionBallInfo getBallInfoImpl() {
        return SuspensionBallInfoImpl_Factory.get();
    }
}
