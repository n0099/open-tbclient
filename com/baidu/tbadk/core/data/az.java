package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId dpT = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dpU = new ArrayList<>();

    public ArrayList<RecommendForumData> aJL() {
        return this.dpU;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dpT;
    }
}
