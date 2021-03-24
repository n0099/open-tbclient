package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.b.b.e.f.a;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends a {
    static {
        SwitchManager.getInstance().registerSwitch(BdStatisticsSwitchStatic.class);
    }

    public static boolean isOn() {
        return SwitchManager.getInstance().findType("newUrlForPerf") == 1;
    }

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return "newUrlForPerf";
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
