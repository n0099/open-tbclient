package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ah {
    private String agI;
    private String agJ;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.agI = lotteryTheme.bgcolor;
            this.agJ = lotteryTheme.bgimage;
        }
    }
}
