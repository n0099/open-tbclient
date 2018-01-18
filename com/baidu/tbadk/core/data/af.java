package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String aLR;
    private List<Integer> aLS;

    public String xH() {
        return this.aLR;
    }

    public List<Integer> xI() {
        return this.aLS;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.aLR = lotteryRegular.regular;
        this.aLS = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aLS.add(lotteryRegular.chance.get(i));
        }
    }
}
