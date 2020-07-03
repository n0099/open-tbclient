package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bh extends t {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String className;
    public int dKp;
    private ArrayList<bg> dKq;
    public String title;

    public bh() {
        kq(9);
        this.dKq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dIb;
    }

    @Override // com.baidu.tbadk.core.data.t, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.t, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return new ap();
    }

    public void aE(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RecommendForumInfo recommendForumInfo = list.get(i);
                bg bgVar = new bg();
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                    bgVar.a(recommendForumInfo);
                    arrayList.add(bgVar);
                }
            }
            this.dKq.clear();
            this.dKq.addAll(com.baidu.tbadk.core.util.w.trimToSize(arrayList, 15));
        }
    }

    public ArrayList<bg> aRv() {
        return this.dKq;
    }
}
