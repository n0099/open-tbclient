package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ah {
    private String aLX;
    private String aLY;

    public String xM() {
        return this.aLX;
    }

    public String xN() {
        return this.aLY;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aLX = lotteryTheme.bgcolor;
            this.aLY = lotteryTheme.bgimage;
        }
    }
}
