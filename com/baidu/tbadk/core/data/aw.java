package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class aw {
    private String aMG;
    private List<a> aMH = new ArrayList();

    public String yi() {
        return StringUtils.isNull(this.aMG) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.aMG;
    }

    public com.baidu.tieba.card.data.p yj() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.cST = yi();
        if (this.aMH != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aMH) {
                if (aVar != null) {
                    arrayList2.add(aVar.yl());
                }
            }
            arrayList = arrayList2;
        }
        pVar.cSU = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aMG = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.F(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aMH.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.yk() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long aMI;
        private String aMJ;
        private long aMK;
        private String aML;
        private String aMM;
        private int tag;
        private int type;

        public long yk() {
            return this.aMI;
        }

        public String getTopicName() {
            return this.aMJ;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aMI = recomTopicList.topic_id.longValue();
                this.aMJ = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aMK = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aML = recomTopicList.topic_desc;
                this.aMM = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o yl() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.aML;
            oVar.aMI = this.aMI;
            oVar.aMJ = this.aMJ;
            return oVar;
        }
    }
}
