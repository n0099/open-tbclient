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
    private String ewP;
    private List<a> ewQ = new ArrayList();

    public String bji() {
        return StringUtils.isNull(this.ewP) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.ewP;
    }

    public com.baidu.tieba.card.data.o bjj() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.hVY = bji();
        if (this.ewQ != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.ewQ) {
                if (aVar != null) {
                    arrayList2.add(aVar.bjk());
                }
            }
            arrayList = arrayList2;
        }
        oVar.hVZ = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ewP = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.ewQ.add(aVar);
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
        private String ewR;
        private long ewS;
        private String ewT;
        private String ewU;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.ewR;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.ewR = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ewS = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ewT = recomTopicList.topic_desc;
                this.ewU = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n bjk() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.ewT;
            nVar.topicId = this.topicId;
            nVar.ewR = this.ewR;
            return nVar;
        }
    }
}
