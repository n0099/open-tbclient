package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class z {
    private String OH;
    private List<Integer> OI;

    public String pA() {
        return this.OH;
    }

    public List<Integer> pB() {
        return this.OI;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.OH = lotteryRegular.regular;
        this.OI = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.OI.add(lotteryRegular.chance.get(i));
        }
    }
}
