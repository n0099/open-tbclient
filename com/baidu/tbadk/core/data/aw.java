package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class aw {
    private String SJ;
    private List<a> SK = new ArrayList();

    public String qI() {
        return StringUtils.isNull(this.SJ) ? TbadkCoreApplication.m9getInst().getString(t.j.hot_topic_card_title) : this.SJ;
    }

    public com.baidu.tieba.card.data.q qJ() {
        com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
        ArrayList arrayList = null;
        qVar.bcj = qI();
        if (this.SK != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.SK) {
                if (aVar != null) {
                    arrayList2.add(aVar.qL());
                }
            }
            arrayList = arrayList2;
        }
        qVar.bck = arrayList;
        return qVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.SJ = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.SK.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qK() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long SL;
        private String SM;
        private long SN;
        private String SO;
        private String SP;
        private int tag;
        private int type;

        public long qK() {
            return this.SL;
        }

        public String getTopicName() {
            return this.SM;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.SL = recomTopicList.topic_id.longValue();
                this.SM = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.SN = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.SO = recomTopicList.topic_desc;
                this.SP = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.p qL() {
            com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
            pVar.tag = this.tag;
            pVar.desc = this.SO;
            pVar.SL = this.SL;
            pVar.SM = this.SM;
            return pVar;
        }
    }
}
