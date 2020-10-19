package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ao {
    private String enk;
    private List<Integer> enl;

    public void a(LotteryRegular lotteryRegular) {
        this.enk = lotteryRegular.regular;
        this.enl = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.enl.add(lotteryRegular.chance.get(i));
        }
    }
}
