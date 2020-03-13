package com.baidu.searchbox.suspensionball.ioc;

import com.baidu.tieba.publisher.a.g;
import com.baidu.tieba.publisher.a.i;
import com.baidu.tieba.publisher.a.k;
/* loaded from: classes7.dex */
public class SuspensionBallRuntime {
    public static ISuspensionBallDispatcher getDispatcher() {
        return i.cAZ();
    }

    public static ISuspensionBallShield getShieldImpl() {
        return k.cBa();
    }

    public static ISuspensionBallDataInit getDataInitImpl() {
        return g.cAY();
    }
}
