package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String RP;
    private String RQ;

    public String qt() {
        return this.RP;
    }

    public String qu() {
        return this.RQ;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.RP = lotteryTheme.bgcolor;
            this.RQ = lotteryTheme.bgimage;
        }
    }
}
