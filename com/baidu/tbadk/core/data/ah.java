package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bIf;
    private List<Integer> bIg;

    public void a(LotteryRegular lotteryRegular) {
        this.bIf = lotteryRegular.regular;
        this.bIg = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bIg.add(lotteryRegular.chance.get(i));
        }
    }
}
