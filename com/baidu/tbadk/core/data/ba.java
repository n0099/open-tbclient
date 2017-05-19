package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ba {
    private String WU;
    private List<a> WV = new ArrayList();

    public String qI() {
        return StringUtils.isNull(this.WU) ? TbadkCoreApplication.m9getInst().getString(w.l.hot_topic_card_title) : this.WU;
    }

    public com.baidu.tieba.card.data.p qJ() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bxP = qI();
        if (this.WV != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.WV) {
                if (aVar != null) {
                    arrayList2.add(aVar.qL());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bxQ = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.WU = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.q(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.WV.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qK() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long WW;
        private String WX;
        private long WY;
        private String WZ;
        private String Xa;
        private int tag;
        private int type;

        public long qK() {
            return this.WW;
        }

        public String getTopicName() {
            return this.WX;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.WW = recomTopicList.topic_id.longValue();
                this.WX = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.WY = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.WZ = recomTopicList.topic_desc;
                this.Xa = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qL() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.WZ;
            oVar.WW = this.WW;
            oVar.WX = this.WX;
            return oVar;
        }
    }
}
