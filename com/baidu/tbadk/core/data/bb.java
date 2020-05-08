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
    private String dpX;
    private List<a> dpY = new ArrayList();

    public String aJN() {
        return StringUtils.isNull(this.dpX) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.dpX;
    }

    public com.baidu.tieba.card.data.n aJO() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.gth = aJN();
        if (this.dpY != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.dpY) {
                if (aVar != null) {
                    arrayList2.add(aVar.aJP());
                }
            }
            arrayList = arrayList2;
        }
        nVar.gti = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.dpX = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.dpY.add(aVar);
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
        private String dpZ;
        private long dqa;
        private String dqb;
        private String dqc;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.dpZ;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.dpZ = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.dqa = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.dqb = recomTopicList.topic_desc;
                this.dqc = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aJP() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.dqb;
            mVar.topicId = this.topicId;
            mVar.dpZ = this.dpZ;
            return mVar;
        }
    }
}
