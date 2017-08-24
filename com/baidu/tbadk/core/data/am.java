package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class am {
    private String XT;
    private String XU;

    public String qv() {
        return this.XT;
    }

    public String qw() {
        return this.XU;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.XT = lotteryTheme.bgcolor;
            this.XU = lotteryTheme.bgimage;
        }
    }
}
