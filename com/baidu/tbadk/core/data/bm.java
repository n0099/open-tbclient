package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bm extends cb {
    public static final BdUniqueId eQJ = BdUniqueId.gen();
    private ArrayList<RecommendForumData> eQK = new ArrayList<>();

    public ArrayList<RecommendForumData> bmV() {
        return this.eQK;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eQJ;
    }
}
