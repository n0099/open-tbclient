package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class am {
    private String Wu;
    private String Wv;

    public String qk() {
        return this.Wu;
    }

    public String ql() {
        return this.Wv;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.Wu = lotteryTheme.bgcolor;
            this.Wv = lotteryTheme.bgimage;
        }
    }
}
