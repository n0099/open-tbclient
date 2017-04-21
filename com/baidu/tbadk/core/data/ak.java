package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ak {
    private String WR;
    private String WS;

    public String re() {
        return this.WR;
    }

    public String rf() {
        return this.WS;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.WR = lotteryTheme.bgcolor;
            this.WS = lotteryTheme.bgimage;
        }
    }
}
