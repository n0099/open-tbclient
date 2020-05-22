package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends bk {
    public static final BdUniqueId dDQ = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dDR = new ArrayList<>();

    public ArrayList<RecommendForumData> aPG() {
        return this.dDR;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return dDQ;
    }
}
