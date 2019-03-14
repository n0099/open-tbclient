package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bzs;
    private String bzt;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bzs = lotteryTheme.bgcolor;
            this.bzt = lotteryTheme.bgimage;
        }
    }
}
