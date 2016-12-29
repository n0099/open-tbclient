package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ax {
    private String SO;
    private List<a> SP = new ArrayList();

    public String qP() {
        return StringUtils.isNull(this.SO) ? TbadkCoreApplication.m9getInst().getString(r.j.hot_topic_card_title) : this.SO;
    }

    public com.baidu.tieba.card.data.q qQ() {
        com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
        ArrayList arrayList = null;
        qVar.beR = qP();
        if (this.SP != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.SP) {
                if (aVar != null) {
                    arrayList2.add(aVar.qS());
                }
            }
            arrayList = arrayList2;
        }
        qVar.beS = arrayList;
        return qVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.SO = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.SP.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qR() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long SQ;
        private String SR;
        private long SS;
        private String ST;
        private String SU;
        private int tag;
        private int type;

        public long qR() {
            return this.SQ;
        }

        public String getTopicName() {
            return this.SR;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.SQ = recomTopicList.topic_id.longValue();
                this.SR = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.SS = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ST = recomTopicList.topic_desc;
                this.SU = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.p qS() {
            com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
            pVar.tag = this.tag;
            pVar.desc = this.ST;
            pVar.SQ = this.SQ;
            pVar.SR = this.SR;
            return pVar;
        }
    }
}
