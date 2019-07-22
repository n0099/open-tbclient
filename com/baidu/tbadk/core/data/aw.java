package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId bIx = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bIy = new ArrayList<>();

    public ArrayList<RecommendForumData> adE() {
        return this.bIy;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bIx;
    }
}
