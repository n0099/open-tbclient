package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bHH;
    private List<Integer> bHI;

    public void a(LotteryRegular lotteryRegular) {
        this.bHH = lotteryRegular.regular;
        this.bHI = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bHI.add(lotteryRegular.chance.get(i));
        }
    }
}
