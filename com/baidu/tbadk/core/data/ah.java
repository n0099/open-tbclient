package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bGG;
    private List<Integer> bGH;

    public void a(LotteryRegular lotteryRegular) {
        this.bGG = lotteryRegular.regular;
        this.bGH = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bGH.add(lotteryRegular.chance.get(i));
        }
    }
}
