package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class am {
    private String XQ;
    private String XR;

    public String qu() {
        return this.XQ;
    }

    public String qv() {
        return this.XR;
    }

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.XQ = lotteryTheme.bgcolor;
            this.XR = lotteryTheme.bgimage;
        }
    }
}
