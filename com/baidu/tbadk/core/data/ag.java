package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String XA;
    private String Xz;

    public String qj() {
        return this.Xz;
    }

    public String qk() {
        return this.XA;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Xz = lotteryTheme.bgcolor;
            this.XA = lotteryTheme.bgimage;
        }
    }
}
