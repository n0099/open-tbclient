package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aj {
    private String Rn;
    private List<Integer> Ro;

    public String qn() {
        return this.Rn;
    }

    public List<Integer> qo() {
        return this.Ro;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Rn = lotteryRegular.regular;
        this.Ro = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Ro.add(lotteryRegular.chance.get(i));
        }
    }
}
