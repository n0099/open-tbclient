package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bGI;
    private String bGJ;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bGI = lotteryTheme.bgcolor;
            this.bGJ = lotteryTheme.bgimage;
        }
    }
}
