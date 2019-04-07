package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bzt;
    private List<Integer> bzu;

    public void a(LotteryRegular lotteryRegular) {
        this.bzt = lotteryRegular.regular;
        this.bzu = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bzu.add(lotteryRegular.chance.get(i));
        }
    }
}
