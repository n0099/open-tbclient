package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String Se;
    private List<Integer> Sf;

    public String qu() {
        return this.Se;
    }

    public List<Integer> qv() {
        return this.Sf;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Se = lotteryRegular.regular;
        this.Sf = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Sf.add(lotteryRegular.chance.get(i));
        }
    }
}
