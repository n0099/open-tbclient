package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String cPx;
    private List<Integer> cPy;

    public void a(LotteryRegular lotteryRegular) {
        this.cPx = lotteryRegular.regular;
        this.cPy = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.cPy.add(lotteryRegular.chance.get(i));
        }
    }
}
