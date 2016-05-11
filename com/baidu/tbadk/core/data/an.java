package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class an {
    private String Pr;
    private List<a> Ps = new ArrayList();

    public String qb() {
        return StringUtils.isNull(this.Pr) ? TbadkCoreApplication.m11getInst().getString(t.j.hot_topic_card_title) : this.Pr;
    }

    public com.baidu.tieba.card.a.p qc() {
        com.baidu.tieba.card.a.p pVar = new com.baidu.tieba.card.a.p();
        ArrayList arrayList = null;
        pVar.aSo = qb();
        if (this.Ps != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Ps) {
                if (aVar != null) {
                    arrayList2.add(aVar.qe());
                }
            }
            arrayList = arrayList2;
        }
        pVar.aSp = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Pr = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.r(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Ps.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qd() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Pt;
        private String Pu;
        private long Pv;
        private String Pw;
        private String Px;
        private int tag;
        private int type;

        public long qd() {
            return this.Pt;
        }

        public String getTopicName() {
            return this.Pu;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Pt = recomTopicList.topic_id.longValue();
                this.Pu = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Pv = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Pw = recomTopicList.topic_desc;
                this.Px = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.a.o qe() {
            com.baidu.tieba.card.a.o oVar = new com.baidu.tieba.card.a.o();
            oVar.tag = this.tag;
            oVar.desc = this.Pw;
            oVar.Pt = this.Pt;
            oVar.Pu = this.Pu;
            return oVar;
        }
    }
}
