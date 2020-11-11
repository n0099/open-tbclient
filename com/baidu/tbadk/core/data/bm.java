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
    private String eCH;
    private List<a> eCI = new ArrayList();

    public String blI() {
        return StringUtils.isNull(this.eCH) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eCH;
    }

    public com.baidu.tieba.card.data.o blJ() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.ibV = blI();
        if (this.eCI != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eCI) {
                if (aVar != null) {
                    arrayList2.add(aVar.blK());
                }
            }
            arrayList = arrayList2;
        }
        oVar.ibW = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eCH = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eCI.add(aVar);
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
        private String eCJ;
        private long eCK;
        private String eCL;
        private String eCM;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eCJ;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eCJ = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eCK = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eCL = recomTopicList.topic_desc;
                this.eCM = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n blK() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.eCL;
            nVar.topicId = this.topicId;
            nVar.eCJ = this.eCJ;
            return nVar;
        }
    }
}
