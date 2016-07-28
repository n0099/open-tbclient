package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class au {
    private String Qa;
    private List<a> Qb = new ArrayList();

    public String pE() {
        return StringUtils.isNull(this.Qa) ? TbadkCoreApplication.m10getInst().getString(u.j.hot_topic_card_title) : this.Qa;
    }

    public com.baidu.tieba.card.a.q pF() {
        com.baidu.tieba.card.a.q qVar = new com.baidu.tieba.card.a.q();
        ArrayList arrayList = null;
        qVar.aWH = pE();
        if (this.Qb != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Qb) {
                if (aVar != null) {
                    arrayList2.add(aVar.pH());
                }
            }
            arrayList = arrayList2;
        }
        qVar.aWI = arrayList;
        return qVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Qa = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Qb.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.pG() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Qc;
        private String Qd;
        private long Qe;
        private String Qf;
        private String Qg;
        private int tag;
        private int type;

        public long pG() {
            return this.Qc;
        }

        public String getTopicName() {
            return this.Qd;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Qc = recomTopicList.topic_id.longValue();
                this.Qd = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Qe = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Qf = recomTopicList.topic_desc;
                this.Qg = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.a.p pH() {
            com.baidu.tieba.card.a.p pVar = new com.baidu.tieba.card.a.p();
            pVar.tag = this.tag;
            pVar.desc = this.Qf;
            pVar.Qc = this.Qc;
            pVar.Qd = this.Qd;
            return pVar;
        }
    }
}
