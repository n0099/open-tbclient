package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bGF;
    private List<Integer> bGG;

    public void a(LotteryRegular lotteryRegular) {
        this.bGF = lotteryRegular.regular;
        this.bGG = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bGG.add(lotteryRegular.chance.get(i));
        }
    }
}
