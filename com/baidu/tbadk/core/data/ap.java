package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ap {
    private String eBE;
    private String mBgcolor;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.mBgcolor = lotteryTheme.bgcolor;
            this.eBE = lotteryTheme.bgimage;
        }
    }
}
