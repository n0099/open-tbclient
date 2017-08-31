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
    private String XM;
    private List<a> XN = new ArrayList();

    public String qK() {
        return StringUtils.isNull(this.XM) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.XM;
    }

    public com.baidu.tieba.card.data.p qL() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bNC = qK();
        if (this.XN != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.XN) {
                if (aVar != null) {
                    arrayList2.add(aVar.qN());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bND = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.XM = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.u(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.XN.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qM() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long XO;
        private String XP;
        private long XQ;
        private String XR;
        private String XS;
        private int tag;
        private int type;

        public long qM() {
            return this.XO;
        }

        public String getTopicName() {
            return this.XP;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.XO = recomTopicList.topic_id.longValue();
                this.XP = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.XQ = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.XR = recomTopicList.topic_desc;
                this.XS = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qN() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.XR;
            oVar.XO = this.XO;
            oVar.XP = this.XP;
            return oVar;
        }
    }
}
