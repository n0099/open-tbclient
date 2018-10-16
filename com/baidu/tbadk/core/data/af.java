package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String anK;
    private List<Integer> anL;

    public void a(LotteryRegular lotteryRegular) {
        this.anK = lotteryRegular.regular;
        this.anL = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.anL.add(lotteryRegular.chance.get(i));
        }
    }
}
