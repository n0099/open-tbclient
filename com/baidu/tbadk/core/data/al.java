package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class al {
    private String XQ;
    private List<Integer> XR;

    public String qs() {
        return this.XQ;
    }

    public List<Integer> qt() {
        return this.XR;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.XQ = lotteryRegular.regular;
        this.XR = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.XR.add(lotteryRegular.chance.get(i));
        }
    }
}
