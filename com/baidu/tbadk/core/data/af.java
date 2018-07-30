package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String agp;
    private List<Integer> agq;

    public void a(LotteryRegular lotteryRegular) {
        this.agp = lotteryRegular.regular;
        this.agq = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.agq.add(lotteryRegular.chance.get(i));
        }
    }
}
