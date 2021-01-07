package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bm extends v {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int eRL;
    private ArrayList<bl> eRM;
    public String title;

    public bm() {
        ox(9);
        this.eRM = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ePu;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public bz boP() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public at boR() {
        return new at();
    }

    public void bt(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bl blVar = new bl();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    blVar.a(recommendForumInfo);
                    arrayList.add(blVar);
                }
            }
            this.eRM.clear();
            this.eRM.addAll(com.baidu.tbadk.core.util.x.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bl> bqx() {
        return this.eRM;
    }
}
