package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String cPL;
    private List<Integer> cPM;

    public void a(LotteryRegular lotteryRegular) {
        this.cPL = lotteryRegular.regular;
        this.cPM = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.cPM.add(lotteryRegular.chance.get(i));
        }
    }
}
