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
    private String dpT;
    private List<a> dpU = new ArrayList();

    public String aJP() {
        return StringUtils.isNull(this.dpT) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.dpT;
    }

    public com.baidu.tieba.card.data.n aJQ() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.gtb = aJP();
        if (this.dpU != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.dpU) {
                if (aVar != null) {
                    arrayList2.add(aVar.aJR());
                }
            }
            arrayList = arrayList2;
        }
        nVar.gtc = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.dpT = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.dpU.add(aVar);
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
        private String dpV;
        private long dpW;
        private String dpX;
        private String dpY;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.dpV;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.dpV = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.dpW = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.dpX = recomTopicList.topic_desc;
                this.dpY = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aJR() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.dpX;
            mVar.topicId = this.topicId;
            mVar.dpV = this.dpV;
            return mVar;
        }
    }
}
