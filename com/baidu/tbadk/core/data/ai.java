package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bHI;
    private String bHJ;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bHI = lotteryTheme.bgcolor;
            this.bHJ = lotteryTheme.bgimage;
        }
    }
}
