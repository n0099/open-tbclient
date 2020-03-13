package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String cPy;
    private List<Integer> cPz;

    public void a(LotteryRegular lotteryRegular) {
        this.cPy = lotteryRegular.regular;
        this.cPz = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.cPz.add(lotteryRegular.chance.get(i));
        }
    }
}
