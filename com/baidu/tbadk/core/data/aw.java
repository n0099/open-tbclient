package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId bAe = BdUniqueId.gen();
    private ArrayList<RecommendForumData> bAf = new ArrayList<>();

    public ArrayList<RecommendForumData> XY() {
        return this.bAf;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bAe;
    }
}
