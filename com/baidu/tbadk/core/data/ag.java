package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String XC;
    private String XD;

    public String ql() {
        return this.XC;
    }

    public String qm() {
        return this.XD;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.XC = lotteryTheme.bgcolor;
            this.XD = lotteryTheme.bgimage;
        }
    }
}
