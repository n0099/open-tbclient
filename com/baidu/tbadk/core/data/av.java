package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class av {
    private String aMC;
    private List<a> aMD = new ArrayList();

    public String yf() {
        return StringUtils.isNull(this.aMC) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.aMC;
    }

    public com.baidu.tieba.card.data.p yg() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.cXv = yf();
        if (this.aMD != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aMD) {
                if (aVar != null) {
                    arrayList2.add(aVar.yi());
                }
            }
            arrayList = arrayList2;
        }
        pVar.cXw = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aMC = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.D(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aMD.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.yh() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long aME;
        private String aMF;
        private long aMG;
        private String aMH;
        private String aMI;
        private int tag;
        private int type;

        public long yh() {
            return this.aME;
        }

        public String getTopicName() {
            return this.aMF;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aME = recomTopicList.topic_id.longValue();
                this.aMF = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aMG = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aMH = recomTopicList.topic_desc;
                this.aMI = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o yi() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.aMH;
            oVar.aME = this.aME;
            oVar.aMF = this.aMF;
            return oVar;
        }
    }
}
