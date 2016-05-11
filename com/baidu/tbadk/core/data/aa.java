package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class aa {
    private String OJ;
    private String OL;

    public String pC() {
        return this.OJ;
    }

    public String pD() {
        return this.OL;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.OJ = lotteryTheme.bgcolor;
            this.OL = lotteryTheme.bgimage;
        }
    }
}
