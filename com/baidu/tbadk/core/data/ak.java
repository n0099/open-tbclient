package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ak {
    private String Xd;
    private String Xe;

    public String qk() {
        return this.Xd;
    }

    public String ql() {
        return this.Xe;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Xd = lotteryTheme.bgcolor;
            this.Xe = lotteryTheme.bgimage;
        }
    }
}
