package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId bHx = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bHy = new ArrayList<>();

    public ArrayList<RecommendForumData> acC() {
        return this.bHy;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bHx;
    }
}
