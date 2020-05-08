package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String doV;
    private List<Integer> doW;

    public void a(LotteryRegular lotteryRegular) {
        this.doV = lotteryRegular.regular;
        this.doW = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.doW.add(lotteryRegular.chance.get(i));
        }
    }
}
