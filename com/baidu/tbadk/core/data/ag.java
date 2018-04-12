package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ag {
    private String YE;
    private List<Integer> YF;

    public void a(LotteryRegular lotteryRegular) {
        this.YE = lotteryRegular.regular;
        this.YF = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.YF.add(lotteryRegular.chance.get(i));
        }
    }
}
