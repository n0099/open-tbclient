package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ak {
    private List<Integer> WA;
    private String Wz;

    public String qF() {
        return this.Wz;
    }

    public List<Integer> qG() {
        return this.WA;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Wz = lotteryRegular.regular;
        this.WA = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.WA.add(lotteryRegular.chance.get(i));
        }
    }
}
