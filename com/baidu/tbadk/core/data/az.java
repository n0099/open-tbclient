package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class az {
    private String XC;
    private List<a> XD = new ArrayList();

    public String ry() {
        return StringUtils.isNull(this.XC) ? TbadkCoreApplication.m9getInst().getString(w.l.hot_topic_card_title) : this.XC;
    }

    public com.baidu.tieba.card.data.r rz() {
        com.baidu.tieba.card.data.r rVar = new com.baidu.tieba.card.data.r();
        ArrayList arrayList = null;
        rVar.bxR = ry();
        if (this.XD != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.XD) {
                if (aVar != null) {
                    arrayList2.add(aVar.rB());
                }
            }
            arrayList = arrayList2;
        }
        rVar.bxS = arrayList;
        return rVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.XC = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.p(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.XD.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.rA() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long XE;
        private String XF;
        private long XG;
        private String XH;
        private String XI;
        private int tag;
        private int type;

        public long rA() {
            return this.XE;
        }

        public String getTopicName() {
            return this.XF;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.XE = recomTopicList.topic_id.longValue();
                this.XF = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.XG = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.XH = recomTopicList.topic_desc;
                this.XI = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.q rB() {
            com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
            qVar.tag = this.tag;
            qVar.desc = this.XH;
            qVar.XE = this.XE;
            qVar.XF = this.XF;
            return qVar;
        }
    }
}
