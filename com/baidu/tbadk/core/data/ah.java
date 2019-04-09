package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bzu;
    private List<Integer> bzv;

    public void a(LotteryRegular lotteryRegular) {
        this.bzu = lotteryRegular.regular;
        this.bzv = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bzv.add(lotteryRegular.chance.get(i));
        }
    }
}
