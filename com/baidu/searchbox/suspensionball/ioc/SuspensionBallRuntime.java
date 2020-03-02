package com.baidu.searchbox.suspensionball.ioc;

import com.baidu.tieba.publisher.a.g;
import com.baidu.tieba.publisher.a.i;
import com.baidu.tieba.publisher.a.k;
/* loaded from: classes7.dex */
public class SuspensionBallRuntime {
    public static ISuspensionBallDispatcher getDispatcher() {
        return i.cAY();
    }

    public static ISuspensionBallShield getShieldImpl() {
        return k.cAZ();
    }

    public static ISuspensionBallDataInit getDataInitImpl() {
        return g.cAX();
    }
}
