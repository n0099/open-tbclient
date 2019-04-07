package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bzv;
    private String bzw;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bzv = lotteryTheme.bgcolor;
            this.bzw = lotteryTheme.bgimage;
        }
    }
}
