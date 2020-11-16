package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ap {
    private String ezT;
    private List<Integer> ezU;

    public void a(LotteryRegular lotteryRegular) {
        this.ezT = lotteryRegular.regular;
        this.ezU = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.ezU.add(lotteryRegular.chance.get(i));
        }
    }
}
