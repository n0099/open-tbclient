package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aNn;
    private List<Integer> aNo;

    public void a(LotteryRegular lotteryRegular) {
        this.aNn = lotteryRegular.regular;
        this.aNo = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aNo.add(lotteryRegular.chance.get(i));
        }
    }
}
