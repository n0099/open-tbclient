package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class aj {
    private String Sg;
    private String Sh;

    public String qw() {
        return this.Sg;
    }

    public String qx() {
        return this.Sh;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Sg = lotteryTheme.bgcolor;
            this.Sh = lotteryTheme.bgimage;
        }
    }
}
