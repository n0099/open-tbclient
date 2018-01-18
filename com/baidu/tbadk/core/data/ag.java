package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String aLT;
    private String aLU;

    public String xJ() {
        return this.aLT;
    }

    public String xK() {
        return this.aLU;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aLT = lotteryTheme.bgcolor;
            this.aLU = lotteryTheme.bgimage;
        }
    }
}
