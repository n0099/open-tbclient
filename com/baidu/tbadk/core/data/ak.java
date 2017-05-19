package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ak {
    private String Wh;
    private List<Integer> Wi;

    public String qm() {
        return this.Wh;
    }

    public List<Integer> qn() {
        return this.Wi;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.Wh = lotteryRegular.regular;
        this.Wi = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.Wi.add(lotteryRegular.chance.get(i));
        }
    }
}
