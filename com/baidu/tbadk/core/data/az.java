package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId dpP = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dpQ = new ArrayList<>();

    public ArrayList<RecommendForumData> aJN() {
        return this.dpQ;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dpP;
    }
}
