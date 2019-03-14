package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String bzq;
    private List<Integer> bzr;

    public void a(LotteryRegular lotteryRegular) {
        this.bzq = lotteryRegular.regular;
        this.bzr = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.bzr.add(lotteryRegular.chance.get(i));
        }
    }
}
