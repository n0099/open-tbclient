package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class al {
    private String Ws;
    private List<Integer> Wt;

    public String qi() {
        return this.Ws;
    }

    public List<Integer> qj() {
        return this.Wt;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Ws = lotteryRegular.regular;
        this.Wt = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Wt.add(lotteryRegular.chance.get(i));
        }
    }
}
