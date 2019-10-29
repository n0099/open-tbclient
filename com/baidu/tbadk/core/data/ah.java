package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bZQ;
    private List<Integer> bZR;

    public void a(LotteryRegular lotteryRegular) {
        this.bZQ = lotteryRegular.regular;
        this.bZR = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bZR.add(lotteryRegular.chance.get(i));
        }
    }
}
