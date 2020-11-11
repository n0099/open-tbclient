package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bj extends u {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int eCC;
    private ArrayList<bi> eCD;
    public String title;

    public bj() {
        nT(9);
        this.eCD = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAo;
    }

    @Override // com.baidu.tbadk.core.data.u, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.u, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        return new ar();
    }

    public void bj(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bi biVar = new bi();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    biVar.a(recommendForumInfo);
                    arrayList.add(biVar);
                }
            }
            this.eCD.clear();
            this.eCD.addAll(com.baidu.tbadk.core.util.y.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bi> blG() {
        return this.eCD;
    }
}
