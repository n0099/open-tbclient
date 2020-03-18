package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId cQJ = BdUniqueId.gen();
    private ArrayList<RecommendForumData> cQK = new ArrayList<>();

    public ArrayList<RecommendForumData> aBA() {
        return this.cQK;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cQJ;
    }
}
