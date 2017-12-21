package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String Xx;
    private List<Integer> Xy;

    public String qh() {
        return this.Xx;
    }

    public List<Integer> qi() {
        return this.Xy;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Xx = lotteryRegular.regular;
        this.Xy = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Xy.add(lotteryRegular.chance.get(i));
        }
    }
}
