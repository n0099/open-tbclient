package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bGH;
    private String bGI;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bGH = lotteryTheme.bgcolor;
            this.bGI = lotteryTheme.bgimage;
        }
    }
}
