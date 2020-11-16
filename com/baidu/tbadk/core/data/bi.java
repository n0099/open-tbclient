package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bi extends bx {
    public static final BdUniqueId eAQ = BdUniqueId.gen();
    private ArrayList<RecommendForumData> eAR = new ArrayList<>();

    public ArrayList<RecommendForumData> bkF() {
        return this.eAR;
    }

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAQ;
    }
}
