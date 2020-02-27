package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String cPw;
    private List<Integer> cPx;

    public void a(LotteryRegular lotteryRegular) {
        this.cPw = lotteryRegular.regular;
        this.cPx = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.cPx.add(lotteryRegular.chance.get(i));
        }
    }
}
