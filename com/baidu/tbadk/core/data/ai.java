package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class ai {
    private String cLt;
    private List<Integer> cLu;

    public void a(LotteryRegular lotteryRegular) {
        this.cLt = lotteryRegular.regular;
        this.cLu = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.cLu.add(lotteryRegular.chance.get(i));
        }
    }
}
