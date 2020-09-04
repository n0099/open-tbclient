package com.baidu.searchbox.suspensionball.ioc;

import com.baidu.tieba.write.b.a.g;
import com.baidu.tieba.write.b.a.i;
import com.baidu.tieba.write.b.a.k;
/* loaded from: classes14.dex */
public class SuspensionBallRuntime {
    public static ISuspensionBallDispatcher getDispatcher() {
        return i.dGE();
    }

    public static ISuspensionBallShield getShieldImpl() {
        return k.dGF();
    }

    public static ISuspensionBallDataInit getDataInitImpl() {
        return g.dGD();
    }
}
