package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class br {
    private String eQS;
    private List<a> eQT = new ArrayList();

    public String bna() {
        return StringUtils.isNull(this.eQS) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eQS;
    }

    public com.baidu.tieba.card.data.n bnb() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.iDd = bna();
        if (this.eQT != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eQT) {
                if (aVar != null) {
                    arrayList2.add(aVar.bnc());
                }
            }
            arrayList = arrayList2;
        }
        nVar.iDe = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eQS = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eQT.add(aVar);
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
        private String eQU;
        private long eQV;
        private String eQW;
        private String eQX;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eQU;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eQU = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eQV = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eQW = recomTopicList.topic_desc;
                this.eQX = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m bnc() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.eQW;
            mVar.topicId = this.topicId;
            mVar.eQU = this.eQU;
            return mVar;
        }
    }
}
