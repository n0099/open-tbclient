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
    private String YE;
    private List<a> YF = new ArrayList();

    public String qP() {
        return StringUtils.isNull(this.YE) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.YE;
    }

    public com.baidu.tieba.card.data.p qQ() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bKK = qP();
        if (this.YF != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.YF) {
                if (aVar != null) {
                    arrayList2.add(aVar.qS());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bKL = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.YE = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.u.u(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.YF.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qR() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long YG;
        private String YH;
        private long YI;
        private String YJ;
        private String YK;
        private int tag;
        private int type;

        public long qR() {
            return this.YG;
        }

        public String getTopicName() {
            return this.YH;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.YG = recomTopicList.topic_id.longValue();
                this.YH = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.YI = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.YJ = recomTopicList.topic_desc;
                this.YK = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qS() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.YJ;
            oVar.YG = this.YG;
            oVar.YH = this.YH;
            return oVar;
        }
    }
}
