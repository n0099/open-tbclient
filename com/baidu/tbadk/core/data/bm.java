package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bm {
    private String ecn;
    private List<a> eco = new ArrayList();

    public String beG() {
        return StringUtils.isNull(this.ecn) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.ecn;
    }

    public com.baidu.tieba.card.data.o beH() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.huG = beG();
        if (this.eco != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eco) {
                if (aVar != null) {
                    arrayList2.add(aVar.beI());
                }
            }
            arrayList = arrayList2;
        }
        oVar.huH = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ecn = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eco.add(aVar);
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
        private String ecp;
        private long ecq;
        private String ecr;
        private String ecs;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.ecp;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.ecp = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ecq = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ecr = recomTopicList.topic_desc;
                this.ecs = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n beI() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.ecr;
            nVar.topicId = this.topicId;
            nVar.ecp = this.ecp;
            return nVar;
        }
    }
}
