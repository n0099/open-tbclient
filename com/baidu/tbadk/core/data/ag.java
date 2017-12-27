package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ag {
    private String aLV;
    private List<Integer> aLW;

    public String xK() {
        return this.aLV;
    }

    public List<Integer> xL() {
        return this.aLW;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.aLV = lotteryRegular.regular;
        this.aLW = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.aLW.add(lotteryRegular.chance.get(i));
        }
    }
}
