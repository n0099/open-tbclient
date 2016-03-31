package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class z {
    private String TU;
    private String TV;

    public String si() {
        return this.TU;
    }

    public String sj() {
        return this.TV;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.TU = lotteryTheme.bgcolor;
            this.TV = lotteryTheme.bgimage;
        }
    }
}
