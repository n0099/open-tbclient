package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class y {
    private String TS;
    private List<Integer> TT;

    public String sg() {
        return this.TS;
    }

    public List<Integer> sh() {
        return this.TT;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.TS = lotteryRegular.regular;
        this.TT = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.TT.add(lotteryRegular.chance.get(i));
        }
    }
}
