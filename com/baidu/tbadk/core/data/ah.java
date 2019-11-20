package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bYZ;
    private List<Integer> bZa;

    public void a(LotteryRegular lotteryRegular) {
        this.bYZ = lotteryRegular.regular;
        this.bZa = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bZa.add(lotteryRegular.chance.get(i));
        }
    }
}
