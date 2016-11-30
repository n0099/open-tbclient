package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class aj {
    private String Sj;
    private List<Integer> Sk;

    public String qt() {
        return this.Sj;
    }

    public List<Integer> qu() {
        return this.Sk;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Sj = lotteryRegular.regular;
        this.Sk = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Sk.add(lotteryRegular.chance.get(i));
        }
    }
}
