package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class al {
    private String Wc;
    private List<Integer> Wd;

    public String qi() {
        return this.Wc;
    }

    public List<Integer> qj() {
        return this.Wd;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Wc = lotteryRegular.regular;
        this.Wd = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Wd.add(lotteryRegular.chance.get(i));
        }
    }
}
