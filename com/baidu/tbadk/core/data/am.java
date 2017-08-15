package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class am {
    private String XS;
    private String XT;

    public String qu() {
        return this.XS;
    }

    public String qv() {
        return this.XT;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.XS = lotteryTheme.bgcolor;
            this.XT = lotteryTheme.bgimage;
        }
    }
}
