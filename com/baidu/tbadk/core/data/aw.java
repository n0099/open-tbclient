package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId bAk = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bAl = new ArrayList<>();

    public ArrayList<RecommendForumData> XV() {
        return this.bAl;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bAk;
    }
}
