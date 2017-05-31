package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class am {
    private String We;
    private String Wf;

    public String qk() {
        return this.We;
    }

    public String ql() {
        return this.Wf;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.We = lotteryTheme.bgcolor;
            this.Wf = lotteryTheme.bgimage;
        }
    }
}
