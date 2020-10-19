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
    private String eos;
    private List<a> eot = new ArrayList();

    public String bhp() {
        return StringUtils.isNull(this.eos) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eos;
    }

    public com.baidu.tieba.card.data.o bhq() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.hJB = bhp();
        if (this.eot != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eot) {
                if (aVar != null) {
                    arrayList2.add(aVar.bhr());
                }
            }
            arrayList = arrayList2;
        }
        oVar.hJC = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eos = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eot.add(aVar);
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
        private String eou;
        private long eov;
        private String eow;
        private String eox;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eou;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eou = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eov = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eow = recomTopicList.topic_desc;
                this.eox = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n bhr() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.eow;
            nVar.topicId = this.topicId;
            nVar.eou = this.eou;
            return nVar;
        }
    }
}
