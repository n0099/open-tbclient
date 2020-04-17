package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String doR;
    private List<Integer> doS;

    public void a(LotteryRegular lotteryRegular) {
        this.doR = lotteryRegular.regular;
        this.doS = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.doS.add(lotteryRegular.chance.get(i));
        }
    }
}
