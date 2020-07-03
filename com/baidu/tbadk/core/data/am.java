package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class am {
    private String dJp;
    private List<Integer> dJq;

    public void a(LotteryRegular lotteryRegular) {
        this.dJp = lotteryRegular.regular;
        this.dJq = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.dJq.add(lotteryRegular.chance.get(i));
        }
    }
}
