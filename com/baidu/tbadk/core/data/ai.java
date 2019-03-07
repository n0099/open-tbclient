package com.baidu.tbadk.core.data;

import tbclient.LotteryTheme;
/* loaded from: classes.dex */
public class ai {
    private String bzq;
    private String bzr;

    public void a(LotteryTheme lotteryTheme) {
        if (lotteryTheme != null) {
            this.bzq = lotteryTheme.bgcolor;
            this.bzr = lotteryTheme.bgimage;
        }
    }
}
