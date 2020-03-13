package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId cQw = BdUniqueId.gen();
    private ArrayList<RecommendForumData> cQx = new ArrayList<>();

    public ArrayList<RecommendForumData> aBx() {
        return this.cQx;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cQw;
    }
}
