package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class az {
    private String bJe;
    private List<a> bJf = new ArrayList();

    public String adL() {
        return StringUtils.isNull(this.bJe) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.bJe;
    }

    public com.baidu.tieba.card.data.n adM() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.eIi = adL();
        if (this.bJf != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bJf) {
                if (aVar != null) {
                    arrayList2.add(aVar.adO());
                }
            }
            arrayList = arrayList2;
        }
        nVar.eIj = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bJe = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.Z(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bJf.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.adN() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bJg;
        private long bJh;
        private String bJi;
        private String bJj;
        private int tag;
        private long topicId;
        private int type;

        public long adN() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bJg;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bJg = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bJh = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bJi = recomTopicList.topic_desc;
                this.bJj = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m adO() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bJi;
            mVar.topicId = this.topicId;
            mVar.bJg = this.bJg;
            return mVar;
        }
    }
}
