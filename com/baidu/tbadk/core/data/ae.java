package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ae {
    private String OV;
    private List<Integer> OW;

    public String pd() {
        return this.OV;
    }

    public List<Integer> pe() {
        return this.OW;
    }

    public void a(LotteryRegular lotteryRegular) {
        this.OV = lotteryRegular.regular;
        this.OW = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.OW.add(lotteryRegular.chance.get(i));
        }
    }
}
