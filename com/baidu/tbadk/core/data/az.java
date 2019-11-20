package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class az {
    private String bZU;
    private List<a> bZV = new ArrayList();

    public String ahN() {
        return StringUtils.isNull(this.bZU) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.bZU;
    }

    public com.baidu.tieba.card.data.n ahO() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.ePW = ahN();
        if (this.bZV != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bZV) {
                if (aVar != null) {
                    arrayList2.add(aVar.ahQ());
                }
            }
            arrayList = arrayList2;
        }
        nVar.ePX = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bZU = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bZV.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.ahP() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bZW;
        private long bZX;
        private String bZY;
        private String bZZ;
        private int tag;
        private long topicId;
        private int type;

        public long ahP() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bZW;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bZW = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bZX = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bZY = recomTopicList.topic_desc;
                this.bZZ = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m ahQ() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bZY;
            mVar.topicId = this.topicId;
            mVar.bZW = this.bZW;
            return mVar;
        }
    }
}
