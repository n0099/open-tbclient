package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bi extends t {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int dQB;
    private ArrayList<bh> dQC;
    public String title;

    public bi() {
        kK(9);
        this.dQC = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dOm;
    }

    @Override // com.baidu.tbadk.core.data.t, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.t, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        return new aq();
    }

    public void aL(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bh bhVar = new bh();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    bhVar.a(recommendForumInfo);
                    arrayList.add(bhVar);
                }
            }
            this.dQC.clear();
            this.dQC.addAll(com.baidu.tbadk.core.util.x.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bh> aVr() {
        return this.dQC;
    }
}
