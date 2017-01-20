package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ak {
    private String Rp;
    private String Rq;

    public String qp() {
        return this.Rp;
    }

    public String qq() {
        return this.Rq;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Rp = lotteryTheme.bgcolor;
            this.Rq = lotteryTheme.bgimage;
        }
    }
}
