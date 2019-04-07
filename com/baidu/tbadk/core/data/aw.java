package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId bAj = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bAk = new ArrayList<>();

    public ArrayList<RecommendForumData> XV() {
        return this.bAk;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bAj;
    }
}
