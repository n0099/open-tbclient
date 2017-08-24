package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class al {
    private String XR;
    private List<Integer> XS;

    public String qt() {
        return this.XR;
    }

    public List<Integer> qu() {
        return this.XS;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.XR = lotteryRegular.regular;
        this.XS = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.XS.add(lotteryRegular.chance.get(i));
        }
    }
}
