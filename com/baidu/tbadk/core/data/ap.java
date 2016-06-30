package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ap {
    private String PC;
    private List<a> PD = new ArrayList();

    public String pV() {
        return StringUtils.isNull(this.PC) ? TbadkCoreApplication.m9getInst().getString(u.j.hot_topic_card_title) : this.PC;
    }

    public com.baidu.tieba.card.a.q pW() {
        com.baidu.tieba.card.a.q qVar = new com.baidu.tieba.card.a.q();
        ArrayList arrayList = null;
        qVar.aVJ = pV();
        if (this.PD != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.PD) {
                if (aVar != null) {
                    arrayList2.add(aVar.pY());
                }
            }
            arrayList = arrayList2;
        }
        qVar.aVK = arrayList;
        return qVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.PC = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.PD.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.pX() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long PE;
        private String PF;
        private long PG;
        private String PH;
        private String PI;
        private int tag;
        private int type;

        public long pX() {
            return this.PE;
        }

        public String getTopicName() {
            return this.PF;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.PE = recomTopicList.topic_id.longValue();
                this.PF = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.PG = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.PH = recomTopicList.topic_desc;
                this.PI = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.a.p pY() {
            com.baidu.tieba.card.a.p pVar = new com.baidu.tieba.card.a.p();
            pVar.tag = this.tag;
            pVar.desc = this.PH;
            pVar.PE = this.PE;
            pVar.PF = this.PF;
            return pVar;
        }
    }
}
