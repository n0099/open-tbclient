package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bIh;
    private String bIi;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bIh = lotteryTheme.bgcolor;
            this.bIi = lotteryTheme.bgimage;
        }
    }
}
