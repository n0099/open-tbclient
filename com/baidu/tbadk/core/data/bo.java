package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bo {
    private String eHY;
    private List<a> eHZ = new ArrayList();

    public String bnX() {
        return StringUtils.isNull(this.eHY) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eHY;
    }

    public com.baidu.tieba.card.data.n bnY() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.inH = bnX();
        if (this.eHZ != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eHZ) {
                if (aVar != null) {
                    arrayList2.add(aVar.bnZ());
                }
            }
            arrayList = arrayList2;
        }
        nVar.inI = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eHY = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eHZ.add(aVar);
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
        private String eIa;
        private long eIb;
        private String eIc;
        private String eId;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eIa;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eIa = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eIb = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eIc = recomTopicList.topic_desc;
                this.eId = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m bnZ() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.eIc;
            mVar.topicId = this.topicId;
            mVar.eIa = this.eIa;
            return mVar;
        }
    }
}
