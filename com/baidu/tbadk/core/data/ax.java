package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ax extends bh {
    public static final BdUniqueId bZQ = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bZR = new ArrayList<>();

    public ArrayList<RecommendForumData> ahL() {
        return this.bZR;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bZQ;
    }
}
