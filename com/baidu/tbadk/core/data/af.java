package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class af {
    private String OX;
    private String OY;

    public String pf() {
        return this.OX;
    }

    public String pg() {
        return this.OY;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.OX = lotteryTheme.bgcolor;
            this.OY = lotteryTheme.bgimage;
        }
    }
}
