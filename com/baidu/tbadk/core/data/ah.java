package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bzo;
    private List<Integer> bzp;

    public void a(LotteryRegular lotteryRegular) {
        this.bzo = lotteryRegular.regular;
        this.bzp = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bzp.add(lotteryRegular.chance.get(i));
        }
    }
}
