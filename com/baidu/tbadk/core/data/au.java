package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes6.dex */
public class au {
    private String aov;
    private List<a> aow = new ArrayList();

    public String xN() {
        return StringUtils.isNull(this.aov) ? TbadkCoreApplication.getInst().getString(e.j.hot_topic_card_title) : this.aov;
    }

    public com.baidu.tieba.card.data.n xO() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.cQG = xN();
        if (this.aow != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aow) {
                if (aVar != null) {
                    arrayList2.add(aVar.xQ());
                }
            }
            arrayList = arrayList2;
        }
        nVar.cQH = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aov = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.I(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aow.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.xP() <= 0;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String aoA;
        private String aoB;
        private long aox;
        private String aoy;
        private long aoz;
        private int tag;
        private int type;

        public long xP() {
            return this.aox;
        }

        public String getTopicName() {
            return this.aoy;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aox = recomTopicList.topic_id.longValue();
                this.aoy = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aoz = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aoA = recomTopicList.topic_desc;
                this.aoB = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m xQ() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.aoA;
            mVar.aox = this.aox;
            mVar.aoy = this.aoy;
            return mVar;
        }
    }
}
