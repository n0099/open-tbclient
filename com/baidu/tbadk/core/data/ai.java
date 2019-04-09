package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bzw;
    private String bzx;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bzw = lotteryTheme.bgcolor;
            this.bzx = lotteryTheme.bgimage;
        }
    }
}
