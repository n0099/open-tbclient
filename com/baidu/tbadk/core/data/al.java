package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class al {
    private String XO;
    private List<Integer> XP;

    public String qs() {
        return this.XO;
    }

    public List<Integer> qt() {
        return this.XP;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.XO = lotteryRegular.regular;
        this.XP = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.XP.add(lotteryRegular.chance.get(i));
        }
    }
}
