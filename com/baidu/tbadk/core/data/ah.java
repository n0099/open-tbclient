package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ah {
    private String RM;
    private List<Integer> RO;

    public String qr() {
        return this.RM;
    }

    public List<Integer> qs() {
        return this.RO;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.RM = lotteryRegular.regular;
        this.RO = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.RO.add(lotteryRegular.chance.get(i));
        }
    }
}
