package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class am {
    private String Xc;
    private String Xd;

    public String qq() {
        return this.Xc;
    }

    public String qr() {
        return this.Xd;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Xc = lotteryTheme.bgcolor;
            this.Xd = lotteryTheme.bgimage;
        }
    }
}
