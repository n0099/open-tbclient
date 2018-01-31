package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aLU;
    private List<Integer> aLV;

    public String xI() {
        return this.aLU;
    }

    public List<Integer> xJ() {
        return this.aLV;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.aLU = lotteryRegular.regular;
        this.aLV = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aLV.add(lotteryRegular.chance.get(i));
        }
    }
}
