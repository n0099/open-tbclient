package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String RG;
    private List<Integer> RH;

    public String qg() {
        return this.RG;
    }

    public List<Integer> qh() {
        return this.RH;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.RG = lotteryRegular.regular;
        this.RH = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.RH.add(lotteryRegular.chance.get(i));
        }
    }
}
