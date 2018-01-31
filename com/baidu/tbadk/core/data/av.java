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
    private String aMF;
    private List<a> aMG = new ArrayList();

    public String yg() {
        return StringUtils.isNull(this.aMF) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.aMF;
    }

    public com.baidu.tieba.card.data.p yh() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.cXQ = yg();
        if (this.aMG != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aMG) {
                if (aVar != null) {
                    arrayList2.add(aVar.yj());
                }
            }
            arrayList = arrayList2;
        }
        pVar.cXR = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aMF = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.D(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aMG.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.yi() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long aMH;
        private String aMI;
        private long aMJ;
        private String aMK;
        private String aML;
        private int tag;
        private int type;

        public long yi() {
            return this.aMH;
        }

        public String getTopicName() {
            return this.aMI;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aMH = recomTopicList.topic_id.longValue();
                this.aMI = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aMJ = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aMK = recomTopicList.topic_desc;
                this.aML = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o yj() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.aMK;
            oVar.aMH = this.aMH;
            oVar.aMI = this.aMI;
            return oVar;
        }
    }
}
