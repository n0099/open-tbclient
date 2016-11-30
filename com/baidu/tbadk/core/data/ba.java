package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ba {
    private String Tl;
    private List<a> Tm = new ArrayList();

    public String qV() {
        return StringUtils.isNull(this.Tl) ? TbadkCoreApplication.m9getInst().getString(r.j.hot_topic_card_title) : this.Tl;
    }

    public com.baidu.tieba.card.data.q qW() {
        com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
        ArrayList arrayList = null;
        qVar.bfC = qV();
        if (this.Tm != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Tm) {
                if (aVar != null) {
                    arrayList2.add(aVar.qY());
                }
            }
            arrayList = arrayList2;
        }
        qVar.bfD = arrayList;
        return qVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Tl = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.s(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Tm.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qX() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Tn;
        private String To;
        private long Tp;
        private String Tq;
        private String Tr;
        private int tag;
        private int type;

        public long qX() {
            return this.Tn;
        }

        public String getTopicName() {
            return this.To;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Tn = recomTopicList.topic_id.longValue();
                this.To = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Tp = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Tq = recomTopicList.topic_desc;
                this.Tr = recomTopicList.topic_pic;
            }
        }

        public p qY() {
            p pVar = new p();
            pVar.tag = this.tag;
            pVar.desc = this.Tq;
            pVar.Tn = this.Tn;
            pVar.To = this.To;
            return pVar;
        }
    }
}
