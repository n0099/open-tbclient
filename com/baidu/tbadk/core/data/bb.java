package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bb {
    private String cQN;
    private List<a> cQO = new ArrayList();

    public String aBC() {
        return StringUtils.isNull(this.cQN) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.cQN;
    }

    public com.baidu.tieba.card.data.n aBD() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.fOu = aBC();
        if (this.cQO != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.cQO) {
                if (aVar != null) {
                    arrayList2.add(aVar.aBE());
                }
            }
            arrayList = arrayList2;
        }
        nVar.fOv = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.cQN = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.cQO.add(aVar);
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
        private String cQP;
        private long cQQ;
        private String cQR;
        private String cQS;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.cQP;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.cQP = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.cQQ = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.cQR = recomTopicList.topic_desc;
                this.cQS = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aBE() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.cQR;
            mVar.topicId = this.topicId;
            mVar.cQP = this.cQP;
            return mVar;
        }
    }
}
