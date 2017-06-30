package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class an {
    private String We;
    private String Wf;

    public String qh() {
        return this.We;
    }

    public String qi() {
        return this.Wf;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.We = lotteryTheme.bgcolor;
            this.Wf = lotteryTheme.bgimage;
        }
    }
}
