package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class as {
    private String eOk;
    private List<Integer> eOl;

    public void a(LotteryRegular lotteryRegular) {
        this.eOk = lotteryRegular.regular;
        this.eOl = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.eOl.add(lotteryRegular.chance.get(i));
        }
    }
}
