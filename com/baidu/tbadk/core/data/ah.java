package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bHG;
    private List<Integer> bHH;

    public void a(LotteryRegular lotteryRegular) {
        this.bHG = lotteryRegular.regular;
        this.bHH = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bHH.add(lotteryRegular.chance.get(i));
        }
    }
}
