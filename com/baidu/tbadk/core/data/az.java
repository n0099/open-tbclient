package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class az {
    private String XN;
    private List<a> XO = new ArrayList();

    public String qE() {
        return StringUtils.isNull(this.XN) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.XN;
    }

    public com.baidu.tieba.card.data.p qF() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bNY = qE();
        if (this.XO != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.XO) {
                if (aVar != null) {
                    arrayList2.add(aVar.qH());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bNZ = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.XN = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.t(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.XO.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qG() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long XP;
        private String XQ;
        private long XR;
        private String XS;
        private String XT;
        private int tag;
        private int type;

        public long qG() {
            return this.XP;
        }

        public String getTopicName() {
            return this.XQ;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.XP = recomTopicList.topic_id.longValue();
                this.XQ = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.XR = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.XS = recomTopicList.topic_desc;
                this.XT = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qH() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.XS;
            oVar.XP = this.XP;
            oVar.XQ = this.XQ;
            return oVar;
        }
    }
}
