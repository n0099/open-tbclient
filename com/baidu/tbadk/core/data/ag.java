package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String anM;
    private String anN;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.anM = lotteryTheme.bgcolor;
            this.anN = lotteryTheme.bgimage;
        }
    }
}
