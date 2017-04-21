package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aj {
    private String WP;
    private List<Integer> WQ;

    public String rc() {
        return this.WP;
    }

    public List<Integer> rd() {
        return this.WQ;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.WP = lotteryRegular.regular;
        this.WQ = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.WQ.add(lotteryRegular.chance.get(i));
        }
    }
}
