package com.baidu.searchbox.suspensionball.ioc;

import com.baidu.tieba.write.b.a.g;
import com.baidu.tieba.write.b.a.i;
import com.baidu.tieba.write.b.a.k;
/* loaded from: classes7.dex */
public class SuspensionBallRuntime {
    public static ISuspensionBallDispatcher getDispatcher() {
        return i.dnw();
    }

    public static ISuspensionBallShield getShieldImpl() {
        return k.dnx();
    }

    public static ISuspensionBallDataInit getDataInitImpl() {
        return g.dnv();
    }
}
