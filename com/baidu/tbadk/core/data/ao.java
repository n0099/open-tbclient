package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes2.dex */
public class ao {
    private String dYT;
    private List<Integer> dYU;

    public void a(LotteryRegular lotteryRegular) {
        this.dYT = lotteryRegular.regular;
        this.dYU = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.dYU.add(lotteryRegular.chance.get(i));
        }
    }
}
