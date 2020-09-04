package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ao {
    private String dYX;
    private List<Integer> dYY;

    public void a(LotteryRegular lotteryRegular) {
        this.dYX = lotteryRegular.regular;
        this.dYY = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.dYY.add(lotteryRegular.chance.get(i));
        }
    }
}
