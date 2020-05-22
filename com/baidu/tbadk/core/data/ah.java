package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String dCU;
    private List<Integer> dCV;

    public void a(LotteryRegular lotteryRegular) {
        this.dCU = lotteryRegular.regular;
        this.dCV = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.dCV.add(lotteryRegular.chance.get(i));
        }
    }
}
