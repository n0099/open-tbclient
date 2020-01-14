package com.baidu.searchbox.suspensionball.ioc;

import com.baidu.tieba.publisher.a.g;
import com.baidu.tieba.publisher.a.i;
import com.baidu.tieba.publisher.a.k;
/* loaded from: classes5.dex */
public class SuspensionBallRuntime {
    public static ISuspensionBallDispatcher getDispatcher() {
        return i.czB();
    }

    public static ISuspensionBallShield getShieldImpl() {
        return k.czC();
    }

    public static ISuspensionBallDataInit getDataInitImpl() {
        return g.czA();
    }
}
