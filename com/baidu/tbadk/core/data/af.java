package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes.dex */
public class af {
    private String arY;
    private List<Integer> arZ;

    public void a(LotteryRegular lotteryRegular) {
        this.arY = lotteryRegular.regular;
        this.arZ = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.arZ.add(lotteryRegular.chance.get(i));
        }
    }
}
