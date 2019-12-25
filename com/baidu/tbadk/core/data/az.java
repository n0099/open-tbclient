package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId cMh = BdUniqueId.gen();
    private ArrayList<RecommendForumData> cMi = new ArrayList<>();

    public ArrayList<RecommendForumData> ayL() {
        return this.cMi;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cMh;
    }
}
