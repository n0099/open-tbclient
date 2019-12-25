package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String cLj;
    private List<Integer> cLk;

    public void a(LotteryRegular lotteryRegular) {
        this.cLj = lotteryRegular.regular;
        this.cLk = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.cLk.add(lotteryRegular.chance.get(i));
        }
    }
}
