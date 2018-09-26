package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String aiR;
    private String aiS;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aiR = lotteryTheme.bgcolor;
            this.aiS = lotteryTheme.bgimage;
        }
    }
}
