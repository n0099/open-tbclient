package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bo extends w {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int ePm;
    private ArrayList<bn> ePn;
    public String title;

    public bo() {
        mU(9);
        this.ePn = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eMV;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.tbadk.core.data.a
    public cb bln() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.tbadk.core.data.a
    public av blp() {
        return new av();
    }

    public void bo(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bn bnVar = new bn();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    bnVar.a(recommendForumInfo);
                    arrayList.add(bnVar);
                }
            }
            this.ePn.clear();
            this.ePn.addAll(com.baidu.tbadk.core.util.y.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bn> bmW() {
        return this.ePn;
    }
}
