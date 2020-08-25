package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes2.dex */
public class ap {
    private String dYV;
    private String mBgcolor;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.mBgcolor = lotteryTheme.bgcolor;
            this.dYV = lotteryTheme.bgimage;
        }
    }
}
