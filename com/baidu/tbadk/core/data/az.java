package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId cMr = BdUniqueId.gen();
    private ArrayList<RecommendForumData> cMs = new ArrayList<>();

    public ArrayList<RecommendForumData> aze() {
        return this.cMs;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cMr;
    }
}
