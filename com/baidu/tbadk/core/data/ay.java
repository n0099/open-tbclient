package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class ay {
    private String bAi;
    private List<a> bAj = new ArrayList();

    public String Ya() {
        return StringUtils.isNull(this.bAi) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.bAi;
    }

    public com.baidu.tieba.card.data.n Yb() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.elZ = Ya();
        if (this.bAj != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bAj) {
                if (aVar != null) {
                    arrayList2.add(aVar.Yd());
                }
            }
            arrayList = arrayList2;
        }
        nVar.ema = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bAi = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.S(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bAj.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.Yc() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bAk;
        private long bAl;
        private String bAm;
        private String bAn;
        private int tag;
        private long topicId;
        private int type;

        public long Yc() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bAk;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bAk = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bAl = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bAm = recomTopicList.topic_desc;
                this.bAn = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m Yd() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bAm;
            mVar.topicId = this.topicId;
            mVar.bAk = this.bAk;
            return mVar;
        }
    }
}
