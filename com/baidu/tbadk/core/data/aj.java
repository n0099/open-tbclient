package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aj {
    private String WO;
    private List<Integer> WP;

    public String rc() {
        return this.WO;
    }

    public List<Integer> rd() {
        return this.WP;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.WO = lotteryRegular.regular;
        this.WP = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.WP.add(lotteryRegular.chance.get(i));
        }
    }
}
