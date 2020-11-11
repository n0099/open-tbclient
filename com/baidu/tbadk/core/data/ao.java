package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ao {
    private String eBC;
    private List<Integer> eBD;

    public void a(LotteryRegular lotteryRegular) {
        this.eBC = lotteryRegular.regular;
        this.eBD = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.eBD.add(lotteryRegular.chance.get(i));
        }
    }
}
