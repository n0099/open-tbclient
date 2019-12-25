package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes5.dex */
public class bb {
    private String cMl;
    private List<a> cMm = new ArrayList();

    public String ayN() {
        return StringUtils.isNull(this.cMl) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.cMl;
    }

    public com.baidu.tieba.card.data.n ayO() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.fHR = ayN();
        if (this.cMm != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.cMm) {
                if (aVar != null) {
                    arrayList2.add(aVar.ayQ());
                }
            }
            arrayList = arrayList2;
        }
        nVar.fHS = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.cMl = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.cMm.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.ayP() <= 0;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private String cMn;
        private long cMo;
        private String cMp;
        private String cMq;
        private int tag;
        private long topicId;
        private int type;

        public long ayP() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.cMn;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.cMn = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.cMo = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.cMp = recomTopicList.topic_desc;
                this.cMq = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m ayQ() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.cMp;
            mVar.topicId = this.topicId;
            mVar.cMn = this.cMn;
            return mVar;
        }
    }
}
