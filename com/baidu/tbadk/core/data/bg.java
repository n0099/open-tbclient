package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bg extends bv {
    public static final BdUniqueId dQy = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dQz = new ArrayList<>();

    public ArrayList<RecommendForumData> aVo() {
        return this.dQz;
    }

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dQy;
    }
}
