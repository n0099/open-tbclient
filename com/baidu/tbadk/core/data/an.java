package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class an {
    private String dPA;
    private List<Integer> dPB;

    public void a(LotteryRegular lotteryRegular) {
        this.dPA = lotteryRegular.regular;
        this.dPB = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.dPB.add(lotteryRegular.chance.get(i));
        }
    }
}
