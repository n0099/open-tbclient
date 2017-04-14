package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ak {
    private String WQ;
    private String WR;

    public String re() {
        return this.WQ;
    }

    public String rf() {
        return this.WR;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.WQ = lotteryTheme.bgcolor;
            this.WR = lotteryTheme.bgimage;
        }
    }
}
