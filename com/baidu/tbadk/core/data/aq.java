package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aq {
    private String eGS;
    private List<Integer> eGT;

    public void a(LotteryRegular lotteryRegular) {
        this.eGS = lotteryRegular.regular;
        this.eGT = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.eGT.add(lotteryRegular.chance.get(i));
        }
    }
}
