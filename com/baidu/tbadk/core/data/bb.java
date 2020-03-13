package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes8.dex */
public class bb {
    private String cQA;
    private List<a> cQB = new ArrayList();

    public String aBz() {
        return StringUtils.isNull(this.cQA) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.cQA;
    }

    public com.baidu.tieba.card.data.n aBA() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.fNM = aBz();
        if (this.cQB != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.cQB) {
                if (aVar != null) {
                    arrayList2.add(aVar.aBB());
                }
            }
            arrayList = arrayList2;
        }
        nVar.fNN = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.cQA = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.cQB.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.getTopicId() <= 0;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private String cQC;
        private long cQD;
        private String cQE;
        private String cQF;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.cQC;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.cQC = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.cQD = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.cQE = recomTopicList.topic_desc;
                this.cQF = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aBB() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.cQE;
            mVar.topicId = this.topicId;
            mVar.cQC = this.cQC;
            return mVar;
        }
    }
}
