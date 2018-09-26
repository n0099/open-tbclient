package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aiP;
    private List<Integer> aiQ;

    public void a(LotteryRegular lotteryRegular) {
        this.aiP = lotteryRegular.regular;
        this.aiQ = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aiQ.add(lotteryRegular.chance.get(i));
        }
    }
}
