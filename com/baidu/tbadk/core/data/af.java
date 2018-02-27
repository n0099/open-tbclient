package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aNc;
    private List<Integer> aNd;

    public void a(LotteryRegular lotteryRegular) {
        this.aNc = lotteryRegular.regular;
        this.aNd = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aNd.add(lotteryRegular.chance.get(i));
        }
    }
}
