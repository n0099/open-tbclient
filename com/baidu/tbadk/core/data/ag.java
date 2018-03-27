package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String aNf;
    private String aNg;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aNf = lotteryTheme.bgcolor;
            this.aNg = lotteryTheme.bgimage;
        }
    }
}
