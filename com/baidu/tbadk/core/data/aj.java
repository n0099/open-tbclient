package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aj {
    private String Xh;
    private List<Integer> Xi;

    public String qg() {
        return this.Xh;
    }

    public List<Integer> qh() {
        return this.Xi;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Xh = lotteryRegular.regular;
        this.Xi = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Xi.add(lotteryRegular.chance.get(i));
        }
    }
}
