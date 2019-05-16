package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId bHw = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bHx = new ArrayList<>();

    public ArrayList<RecommendForumData> acC() {
        return this.bHx;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bHw;
    }
}
