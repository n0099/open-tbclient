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
    private String bAn;
    private List<a> bAo = new ArrayList();

    public String XX() {
        return StringUtils.isNull(this.bAn) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.bAn;
    }

    public com.baidu.tieba.card.data.n XY() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.elH = XX();
        if (this.bAo != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bAo) {
                if (aVar != null) {
                    arrayList2.add(aVar.Ya());
                }
            }
            arrayList = arrayList2;
        }
        nVar.elI = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bAn = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.S(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bAo.add(aVar);
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
        private String bAp;
        private long bAq;
        private String bAr;
        private String bAs;
        private int tag;
        private long topicId;
        private int type;

        public long XZ() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bAp;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bAp = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bAq = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bAr = recomTopicList.topic_desc;
                this.bAs = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m Ya() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bAr;
            mVar.topicId = this.topicId;
            mVar.bAp = this.bAp;
            return mVar;
        }
    }
}
