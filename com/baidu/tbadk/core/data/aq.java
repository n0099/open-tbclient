package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aq {
    private String eQJ;
    private List<Integer> eQK;

    public void a(LotteryRegular lotteryRegular) {
        this.eQJ = lotteryRegular.regular;
        this.eQK = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.eQK.add(lotteryRegular.chance.get(i));
        }
    }
}
