package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String aNp;
    private String aNq;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aNp = lotteryTheme.bgcolor;
            this.aNq = lotteryTheme.bgimage;
        }
    }
}
