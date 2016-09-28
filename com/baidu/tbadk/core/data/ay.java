package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ay {
    private String SQ;
    private List<a> SR = new ArrayList();

    public String qT() {
        return StringUtils.isNull(this.SQ) ? TbadkCoreApplication.m9getInst().getString(r.j.hot_topic_card_title) : this.SQ;
    }

    public com.baidu.tieba.card.data.q qU() {
        com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
        ArrayList arrayList = null;
        qVar.bcD = qT();
        if (this.SR != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.SR) {
                if (aVar != null) {
                    arrayList2.add(aVar.qW());
                }
            }
            arrayList = arrayList2;
        }
        qVar.bcE = arrayList;
        return qVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.SQ = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.SR.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qV() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long SS;
        private String ST;
        private long SU;
        private String SV;
        private String SW;
        private int tag;
        private int type;

        public long qV() {
            return this.SS;
        }

        public String getTopicName() {
            return this.ST;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.SS = recomTopicList.topic_id.longValue();
                this.ST = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.SU = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.SV = recomTopicList.topic_desc;
                this.SW = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.p qW() {
            com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
            pVar.tag = this.tag;
            pVar.desc = this.SV;
            pVar.SS = this.SS;
            pVar.ST = this.ST;
            return pVar;
        }
    }
}
