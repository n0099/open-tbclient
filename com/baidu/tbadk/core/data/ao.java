package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ao {
    private String evJ;
    private List<Integer> evK;

    public void a(LotteryRegular lotteryRegular) {
        this.evJ = lotteryRegular.regular;
        this.evK = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.evK.add(lotteryRegular.chance.get(i));
        }
    }
}
