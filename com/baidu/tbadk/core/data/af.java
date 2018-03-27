package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aNd;
    private List<Integer> aNe;

    public void a(LotteryRegular lotteryRegular) {
        this.aNd = lotteryRegular.regular;
        this.aNe = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aNe.add(lotteryRegular.chance.get(i));
        }
    }
}
