package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class bh extends bw {
    public static final BdUniqueId dZR = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dZS = new ArrayList<>();

    public ArrayList<RecommendForumData> bdH() {
        return this.dZS;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZR;
    }
}
