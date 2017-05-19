package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class al {
    private String Wj;
    private String Wk;

    public String qo() {
        return this.Wj;
    }

    public String qp() {
        return this.Wk;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Wj = lotteryTheme.bgcolor;
            this.Wk = lotteryTheme.bgimage;
        }
    }
}
