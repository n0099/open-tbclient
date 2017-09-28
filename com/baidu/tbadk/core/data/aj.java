package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aj {
    private String Xb;
    private List<Integer> Xc;

    public String qi() {
        return this.Xb;
    }

    public List<Integer> qj() {
        return this.Xc;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Xb = lotteryRegular.regular;
        this.Xc = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Xc.add(lotteryRegular.chance.get(i));
        }
    }
}
