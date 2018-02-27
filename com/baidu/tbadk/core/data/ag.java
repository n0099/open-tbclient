package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String aNe;
    private String aNf;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.aNe = lotteryTheme.bgcolor;
            this.aNf = lotteryTheme.bgimage;
        }
    }
}
