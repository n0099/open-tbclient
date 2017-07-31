package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bb {
    private String YB;
    private List<a> YC = new ArrayList();

    public String qO() {
        return StringUtils.isNull(this.YB) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.YB;
    }

    public com.baidu.tieba.card.data.p qP() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bKa = qO();
        if (this.YC != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.YC) {
                if (aVar != null) {
                    arrayList2.add(aVar.qR());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bKb = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.YB = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.u.u(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.YC.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qQ() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long YD;
        private String YE;
        private long YF;
        private String YG;
        private String YH;
        private int tag;
        private int type;

        public long qQ() {
            return this.YD;
        }

        public String getTopicName() {
            return this.YE;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.YD = recomTopicList.topic_id.longValue();
                this.YE = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.YF = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.YG = recomTopicList.topic_desc;
                this.YH = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qR() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.YG;
            oVar.YD = this.YD;
            oVar.YE = this.YE;
            return oVar;
        }
    }
}
