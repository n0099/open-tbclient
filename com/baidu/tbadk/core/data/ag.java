package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ag {
    private String agG;
    private List<Integer> agH;

    public void a(LotteryRegular lotteryRegular) {
        this.agG = lotteryRegular.regular;
        this.agH = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.agH.add(lotteryRegular.chance.get(i));
        }
    }
}
