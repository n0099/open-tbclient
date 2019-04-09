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
    private String bAo;
    private List<a> bAp = new ArrayList();

    public String XX() {
        return StringUtils.isNull(this.bAo) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.bAo;
    }

    public com.baidu.tieba.card.data.n XY() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.elI = XX();
        if (this.bAp != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bAp) {
                if (aVar != null) {
                    arrayList2.add(aVar.Ya());
                }
            }
            arrayList = arrayList2;
        }
        nVar.elJ = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bAo = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.S(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bAp.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.XZ() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bAq;
        private long bAr;
        private String bAs;
        private String bAt;
        private int tag;
        private long topicId;
        private int type;

        public long XZ() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bAq;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bAq = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bAr = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bAs = recomTopicList.topic_desc;
                this.bAt = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m Ya() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bAs;
            mVar.topicId = this.topicId;
            mVar.bAq = this.bAq;
            return mVar;
        }
    }
}
