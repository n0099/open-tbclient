package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class au {
    private String ajA;
    private List<a> ajB = new ArrayList();

    public String vE() {
        return StringUtils.isNull(this.ajA) ? TbadkCoreApplication.getInst().getString(e.j.hot_topic_card_title) : this.ajA;
    }

    public com.baidu.tieba.card.data.n vF() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.cIn = vE();
        if (this.ajB != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.ajB) {
                if (aVar != null) {
                    arrayList2.add(aVar.vH());
                }
            }
            arrayList = arrayList2;
        }
        nVar.cIo = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ajA = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.y(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.ajB.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.vG() <= 0;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private long ajC;
        private String ajD;
        private long ajE;
        private String ajF;
        private String ajG;
        private int tag;
        private int type;

        public long vG() {
            return this.ajC;
        }

        public String getTopicName() {
            return this.ajD;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.ajC = recomTopicList.topic_id.longValue();
                this.ajD = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ajE = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ajF = recomTopicList.topic_desc;
                this.ajG = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m vH() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.ajF;
            mVar.ajC = this.ajC;
            mVar.ajD = this.ajD;
            return mVar;
        }
    }
}
