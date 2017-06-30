package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bc {
    private String WP;
    private List<a> WQ = new ArrayList();

    public String qB() {
        return StringUtils.isNull(this.WP) ? TbadkCoreApplication.m9getInst().getString(w.l.hot_topic_card_title) : this.WP;
    }

    public com.baidu.tieba.card.data.p qC() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bEE = qB();
        if (this.WQ != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.WQ) {
                if (aVar != null) {
                    arrayList2.add(aVar.qE());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bEF = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.WP = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.z.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.WQ.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qD() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long WR;
        private String WS;
        private long WT;
        private String WU;
        private String WV;
        private int tag;
        private int type;

        public long qD() {
            return this.WR;
        }

        public String getTopicName() {
            return this.WS;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.WR = recomTopicList.topic_id.longValue();
                this.WS = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.WT = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.WU = recomTopicList.topic_desc;
                this.WV = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qE() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.WU;
            oVar.WR = this.WR;
            oVar.WS = this.WS;
            return oVar;
        }
    }
}
