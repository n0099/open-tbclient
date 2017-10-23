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
    private String XB;
    private List<a> XC = new ArrayList();

    public String qx() {
        return StringUtils.isNull(this.XB) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.XB;
    }

    public com.baidu.tieba.card.data.p qy() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bNM = qx();
        if (this.XC != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.XC) {
                if (aVar != null) {
                    arrayList2.add(aVar.qA());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bNN = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.XB = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.t(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.XC.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qz() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long XD;
        private String XE;
        private long XF;
        private String XG;
        private String XH;
        private int tag;
        private int type;

        public long qz() {
            return this.XD;
        }

        public String getTopicName() {
            return this.XE;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.XD = recomTopicList.topic_id.longValue();
                this.XE = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.XF = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.XG = recomTopicList.topic_desc;
                this.XH = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qA() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.XG;
            oVar.XD = this.XD;
            oVar.XE = this.XE;
            return oVar;
        }
    }
}
