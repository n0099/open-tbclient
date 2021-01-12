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
    public int eNa;
    private ArrayList<bl> eNb;
    public String title;

    public bm() {
        mR(9);
        this.eNb = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eKJ;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public bz bkV() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public at bkX() {
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
            this.eNb.clear();
            this.eNb.addAll(com.baidu.tbadk.core.util.x.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bl> bmD() {
        return this.eNb;
    }
}
