package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ag {
    private String asa;
    private String asb;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.asa = lotteryTheme.bgcolor;
            this.asb = lotteryTheme.bgimage;
        }
    }
}
