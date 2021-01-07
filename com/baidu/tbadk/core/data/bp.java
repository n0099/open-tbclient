package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bp {
    private String eRQ;
    private List<a> eRR = new ArrayList();

    public String bqz() {
        return StringUtils.isNull(this.eRQ) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eRQ;
    }

    public com.baidu.tieba.card.data.n bqA() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.iAd = bqz();
        if (this.eRR != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eRR) {
                if (aVar != null) {
                    arrayList2.add(aVar.bqB());
                }
            }
            arrayList = arrayList2;
        }
        nVar.iAe = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eRQ = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eRR.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.getTopicId() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String eRS;
        private long eRT;
        private String eRU;
        private String eRV;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eRS;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eRS = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eRT = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eRU = recomTopicList.topic_desc;
                this.eRV = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m bqB() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.eRU;
            mVar.topicId = this.topicId;
            mVar.eRS = this.eRS;
            return mVar;
        }
    }
}
