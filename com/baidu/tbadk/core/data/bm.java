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
    private String ead;
    private List<a> eae = new ArrayList();

    public String bdM() {
        return StringUtils.isNull(this.ead) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.ead;
    }

    public com.baidu.tieba.card.data.o bdN() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.hnC = bdM();
        if (this.eae != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eae) {
                if (aVar != null) {
                    arrayList2.add(aVar.bdO());
                }
            }
            arrayList = arrayList2;
        }
        oVar.hnD = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ead = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eae.add(aVar);
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
        private String eaf;
        private long eag;
        private String eah;
        private String eai;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eaf;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eaf = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eag = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eah = recomTopicList.topic_desc;
                this.eai = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n bdO() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.eah;
            nVar.topicId = this.topicId;
            nVar.eaf = this.eaf;
            return nVar;
        }
    }
}
