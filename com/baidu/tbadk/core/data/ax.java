package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ax extends bh {
    public static final BdUniqueId caH = BdUniqueId.gen();
    private ArrayList<RecommendForumData> caI = new ArrayList<>();

    public ArrayList<RecommendForumData> ahN() {
        return this.caI;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return caH;
    }
}
