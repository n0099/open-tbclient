package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aq {
    private String eLY;
    private List<Integer> eLZ;

    public void a(LotteryRegular lotteryRegular) {
        this.eLY = lotteryRegular.regular;
        this.eLZ = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.eLZ.add(lotteryRegular.chance.get(i));
        }
    }
}
