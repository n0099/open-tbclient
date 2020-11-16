package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bk extends v {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int eAT;
    private ArrayList<bj> eAU;
    public String title;

    public bk() {
        nP(9);
        this.eAU = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eyF;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public bx bjd() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public as bjf() {
        return new as();
    }

    public void bj(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bj bjVar = new bj();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    bjVar.a(recommendForumInfo);
                    arrayList.add(bjVar);
                }
            }
            this.eAU.clear();
            this.eAU.addAll(com.baidu.tbadk.core.util.y.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bj> bkI() {
        return this.eAU;
    }
}
