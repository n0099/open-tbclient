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
    private String YD;
    private List<a> YE = new ArrayList();

    public String qO() {
        return StringUtils.isNull(this.YD) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.YD;
    }

    public com.baidu.tieba.card.data.p qP() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bKJ = qO();
        if (this.YE != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.YE) {
                if (aVar != null) {
                    arrayList2.add(aVar.qR());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bKK = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.YD = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.u.u(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.YE.add(aVar);
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
        private long YF;
        private String YG;
        private long YH;
        private String YI;
        private String YJ;
        private int tag;
        private int type;

        public long qQ() {
            return this.YF;
        }

        public String getTopicName() {
            return this.YG;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.YF = recomTopicList.topic_id.longValue();
                this.YG = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.YH = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.YI = recomTopicList.topic_desc;
                this.YJ = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qR() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.YI;
            oVar.YF = this.YF;
            oVar.YG = this.YG;
            return oVar;
        }
    }
}
