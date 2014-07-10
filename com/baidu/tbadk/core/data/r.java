package com.baidu.tbadk.core.data;

import tbclient.FrsPage.WorldCupLottery;
/* loaded from: classes.dex */
public class r {
    String a;

    public String a() {
        return this.a;
    }

    public void a(WorldCupLottery worldCupLottery) {
        if (worldCupLottery != null) {
            this.a = worldCupLottery.url;
        }
    }
}
