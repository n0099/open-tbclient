package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ao {
    private String ebh;
    private List<Integer> ebi;

    public void a(LotteryRegular lotteryRegular) {
        this.ebh = lotteryRegular.regular;
        this.ebi = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.ebi.add(lotteryRegular.chance.get(i));
        }
    }
}
