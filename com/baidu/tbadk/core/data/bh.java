package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bh extends bw {
    public static final BdUniqueId ecf = BdUniqueId.gen();
    private ArrayList<RecommendForumData> ecg = new ArrayList<>();

    public ArrayList<RecommendForumData> beB() {
        return this.ecg;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ecf;
    }
}
