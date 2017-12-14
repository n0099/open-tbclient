package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String Xw;
    private String Xx;

    public String qj() {
        return this.Xw;
    }

    public String qk() {
        return this.Xx;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Xw = lotteryTheme.bgcolor;
            this.Xx = lotteryTheme.bgimage;
        }
    }
}
