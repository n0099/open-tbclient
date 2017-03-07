package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class al {
    private String WB;
    private String WC;

    public String qH() {
        return this.WB;
    }

    public String qI() {
        return this.WC;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.WB = lotteryTheme.bgcolor;
            this.WC = lotteryTheme.bgimage;
        }
    }
}
