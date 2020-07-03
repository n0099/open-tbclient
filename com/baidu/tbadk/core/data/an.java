package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class an {
    private String dJr;
    private String mBgcolor;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.mBgcolor = lotteryTheme.bgcolor;
            this.dJr = lotteryTheme.bgimage;
        }
    }
}
