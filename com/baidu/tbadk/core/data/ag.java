package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ag {
    private String agV;
    private List<Integer> agW;

    public void a(LotteryRegular lotteryRegular) {
        this.agV = lotteryRegular.regular;
        this.agW = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.agW.add(lotteryRegular.chance.get(i));
        }
    }
}
