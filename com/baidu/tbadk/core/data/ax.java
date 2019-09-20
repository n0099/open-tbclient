package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ax extends bh {
    public static final BdUniqueId bJa = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bJb = new ArrayList<>();

    public ArrayList<RecommendForumData> adJ() {
        return this.bJb;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bJa;
    }
}
