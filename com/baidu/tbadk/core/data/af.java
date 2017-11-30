package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String XA;
    private List<Integer> XB;

    public String qj() {
        return this.XA;
    }

    public List<Integer> qk() {
        return this.XB;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.XA = lotteryRegular.regular;
        this.XB = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.XB.add(lotteryRegular.chance.get(i));
        }
    }
}
