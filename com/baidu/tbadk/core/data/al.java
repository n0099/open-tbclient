package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class al {
    private String Xa;
    private List<Integer> Xb;

    public String qo() {
        return this.Xa;
    }

    public List<Integer> qp() {
        return this.Xb;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Xa = lotteryRegular.regular;
        this.Xb = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Xb.add(lotteryRegular.chance.get(i));
        }
    }
}
