package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String Xu;
    private List<Integer> Xv;

    public String qh() {
        return this.Xu;
    }

    public List<Integer> qi() {
        return this.Xv;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Xu = lotteryRegular.regular;
        this.Xv = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Xv.add(lotteryRegular.chance.get(i));
        }
    }
}
