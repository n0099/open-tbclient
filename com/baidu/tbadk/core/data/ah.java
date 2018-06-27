package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ah {
    private String agX;
    private String agY;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.agX = lotteryTheme.bgcolor;
            this.agY = lotteryTheme.bgimage;
        }
    }
}
