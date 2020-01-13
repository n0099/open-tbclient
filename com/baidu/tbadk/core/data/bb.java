package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes6.dex */
public class bb {
    private String cMv;
    private List<a> cMw = new ArrayList();

    public String azg() {
        return StringUtils.isNull(this.cMv) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.cMv;
    }

    public com.baidu.tieba.card.data.n azh() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.fLb = azg();
        if (this.cMw != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.cMw) {
                if (aVar != null) {
                    arrayList2.add(aVar.azj());
                }
            }
            arrayList = arrayList2;
        }
        nVar.fLc = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.cMv = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.cMw.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.azi() <= 0;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String cMA;
        private String cMx;
        private long cMy;
        private String cMz;
        private int tag;
        private long topicId;
        private int type;

        public long azi() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.cMx;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.cMx = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.cMy = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.cMz = recomTopicList.topic_desc;
                this.cMA = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m azj() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.cMz;
            mVar.topicId = this.topicId;
            mVar.cMx = this.cMx;
            return mVar;
        }
    }
}
