package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String aLW;
    private String aLX;

    public String xK() {
        return this.aLW;
    }

    public String xL() {
        return this.aLX;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aLW = lotteryTheme.bgcolor;
            this.aLX = lotteryTheme.bgimage;
        }
    }
}
