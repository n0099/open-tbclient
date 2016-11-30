package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ak {
    private String Sl;
    private String Sm;

    public String qv() {
        return this.Sl;
    }

    public String qw() {
        return this.Sm;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Sl = lotteryTheme.bgcolor;
            this.Sm = lotteryTheme.bgimage;
        }
    }
}
