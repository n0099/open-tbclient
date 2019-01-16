package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String asA;
    private List<Integer> asB;

    public void a(LotteryRegular lotteryRegular) {
        this.asA = lotteryRegular.regular;
        this.asB = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.asB.add(lotteryRegular.chance.get(i));
        }
    }
}
