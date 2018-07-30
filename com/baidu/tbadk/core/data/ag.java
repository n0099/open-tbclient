package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String agr;
    private String ags;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.agr = lotteryTheme.bgcolor;
            this.ags = lotteryTheme.bgimage;
        }
    }
}
