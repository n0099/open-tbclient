package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bh extends bw {
    public static final BdUniqueId dZV = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dZW = new ArrayList<>();

    public ArrayList<RecommendForumData> bdH() {
        return this.dZW;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZV;
    }
}
