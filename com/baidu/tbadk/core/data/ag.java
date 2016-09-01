package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String RI;
    private String RJ;

    public String qi() {
        return this.RI;
    }

    public String qj() {
        return this.RJ;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.RI = lotteryTheme.bgcolor;
            this.RJ = lotteryTheme.bgimage;
        }
    }
}
