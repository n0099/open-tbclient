package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bj extends by {
    public static final BdUniqueId eHP = BdUniqueId.gen();
    private ArrayList<RecommendForumData> eHQ = new ArrayList<>();

    public ArrayList<RecommendForumData> bnS() {
        return this.eHQ;
    }

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eHP;
    }
}
