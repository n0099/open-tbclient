package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bl {
    private String dQG;
    private List<a> dQH = new ArrayList();

    public String aVt() {
        return StringUtils.isNull(this.dQG) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.dQG;
    }

    public com.baidu.tieba.card.data.n aVu() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.haH = aVt();
        if (this.dQH != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.dQH) {
                if (aVar != null) {
                    arrayList2.add(aVar.aVv());
                }
            }
            arrayList = arrayList2;
        }
        nVar.haI = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.dQG = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.dQH.add(aVar);
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
        private String dQI;
        private long dQJ;
        private String dQK;
        private String dQL;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.dQI;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.dQI = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.dQJ = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.dQK = recomTopicList.topic_desc;
                this.dQL = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aVv() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.dQK;
            mVar.topicId = this.topicId;
            mVar.dQI = this.dQI;
            return mVar;
        }
    }
}
