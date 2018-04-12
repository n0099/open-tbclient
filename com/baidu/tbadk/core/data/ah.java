package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ah {
    private String YG;
    private String YH;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.YG = lotteryTheme.bgcolor;
            this.YH = lotteryTheme.bgimage;
        }
    }
}
