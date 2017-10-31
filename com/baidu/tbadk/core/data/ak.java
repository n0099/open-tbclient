package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ak {
    private String Xj;
    private String Xk;

    public String qi() {
        return this.Xj;
    }

    public String qj() {
        return this.Xk;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Xj = lotteryTheme.bgcolor;
            this.Xk = lotteryTheme.bgimage;
        }
    }
}
