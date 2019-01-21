package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String asB;
    private List<Integer> asC;

    public void a(LotteryRegular lotteryRegular) {
        this.asB = lotteryRegular.regular;
        this.asC = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.asC.add(lotteryRegular.chance.get(i));
        }
    }
}
