package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aox;
    private List<Integer> aoy;

    public void a(LotteryRegular lotteryRegular) {
        this.aox = lotteryRegular.regular;
        this.aoy = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aoy.add(lotteryRegular.chance.get(i));
        }
    }
}
