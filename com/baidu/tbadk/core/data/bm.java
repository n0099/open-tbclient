package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class bm {
    private String dZZ;
    private List<a> eaa = new ArrayList();

    public String bdM() {
        return StringUtils.isNull(this.dZZ) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.dZZ;
    }

    public com.baidu.tieba.card.data.o bdN() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.hny = bdM();
        if (this.eaa != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eaa) {
                if (aVar != null) {
                    arrayList2.add(aVar.bdO());
                }
            }
            arrayList = arrayList2;
        }
        oVar.hnz = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.dZZ = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eaa.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.getTopicId() <= 0;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String eab;
        private long eac;
        private String ead;
        private String eae;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eab;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eab = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eac = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ead = recomTopicList.topic_desc;
                this.eae = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n bdO() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.ead;
            nVar.topicId = this.topicId;
            nVar.eab = this.eab;
            return nVar;
        }
    }
}
