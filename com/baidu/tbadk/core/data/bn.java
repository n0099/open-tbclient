package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bn {
    private String eAY;
    private List<a> eAZ = new ArrayList();

    public String bkK() {
        return StringUtils.isNull(this.eAY) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eAY;
    }

    public com.baidu.tieba.card.data.n bkL() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.icJ = bkK();
        if (this.eAZ != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eAZ) {
                if (aVar != null) {
                    arrayList2.add(aVar.bkM());
                }
            }
            arrayList = arrayList2;
        }
        nVar.icK = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eAY = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eAZ.add(aVar);
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
        private String eBa;
        private long eBb;
        private String eBc;
        private String eBd;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eBa;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eBa = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eBb = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eBc = recomTopicList.topic_desc;
                this.eBd = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m bkM() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.eBc;
            mVar.topicId = this.topicId;
            mVar.eBa = this.eBa;
            return mVar;
        }
    }
}
