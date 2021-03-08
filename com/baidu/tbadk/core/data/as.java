package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class as {
    private String ePL;
    private List<Integer> ePM;

    public void a(LotteryRegular lotteryRegular) {
        this.ePL = lotteryRegular.regular;
        this.ePM = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.ePM.add(lotteryRegular.chance.get(i));
        }
    }
}
