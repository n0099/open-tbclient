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
    private String cQy;
    private List<a> cQz = new ArrayList();

    public String aBx() {
        return StringUtils.isNull(this.cQy) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.cQy;
    }

    public com.baidu.tieba.card.data.n aBy() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.fNx = aBx();
        if (this.cQz != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.cQz) {
                if (aVar != null) {
                    arrayList2.add(aVar.aBz());
                }
            }
            arrayList = arrayList2;
        }
        nVar.fNy = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.cQy = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.cQz.add(aVar);
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
        private String cQA;
        private long cQB;
        private String cQC;
        private String cQD;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.cQA;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.cQA = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.cQB = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.cQC = recomTopicList.topic_desc;
                this.cQD = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aBz() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.cQC;
            mVar.topicId = this.topicId;
            mVar.cQA = this.cQA;
            return mVar;
        }
    }
}
