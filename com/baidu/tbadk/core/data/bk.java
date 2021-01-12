package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bk extends bz {
    public static final BdUniqueId eMW = BdUniqueId.gen();
    private ArrayList<RecommendForumData> eMX = new ArrayList<>();

    public ArrayList<RecommendForumData> bmA() {
        return this.eMX;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eMW;
    }
}
