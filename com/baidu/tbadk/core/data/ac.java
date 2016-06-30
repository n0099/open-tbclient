package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ac {
    private String OJ;
    private String OL;

    public String pw() {
        return this.OJ;
    }

    public String px() {
        return this.OL;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.OJ = lotteryTheme.bgcolor;
            this.OL = lotteryTheme.bgimage;
        }
    }
}
