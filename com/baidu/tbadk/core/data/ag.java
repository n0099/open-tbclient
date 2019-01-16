package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String asC;
    private String asD;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.asC = lotteryTheme.bgcolor;
            this.asD = lotteryTheme.bgimage;
        }
    }
}
