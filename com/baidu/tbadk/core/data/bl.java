package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bl extends v {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int eHT;
    private ArrayList<bk> eHU;
    public String title;

    public bl() {
        on(9);
        this.eHU = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eFE;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public by bmn() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.tbadk.core.data.a
    public at bmp() {
        return new at();
    }

    public void bm(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bk bkVar = new bk();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    bkVar.a(recommendForumInfo);
                    arrayList.add(bkVar);
                }
            }
            this.eHU.clear();
            this.eHU.addAll(com.baidu.tbadk.core.util.y.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bk> bnV() {
        return this.eHU;
    }
}
