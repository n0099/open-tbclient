package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bHJ;
    private String bHK;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bHJ = lotteryTheme.bgcolor;
            this.bHK = lotteryTheme.bgimage;
        }
    }
}
