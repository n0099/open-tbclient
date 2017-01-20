package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ay {
    private String RY;
    private List<a> RZ = new ArrayList();

    public String qH() {
        return StringUtils.isNull(this.RY) ? TbadkCoreApplication.m9getInst().getString(r.l.hot_topic_card_title) : this.RY;
    }

    public com.baidu.tieba.card.data.r qI() {
        com.baidu.tieba.card.data.r rVar = new com.baidu.tieba.card.data.r();
        ArrayList arrayList = null;
        rVar.boM = qH();
        if (this.RZ != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.RZ) {
                if (aVar != null) {
                    arrayList2.add(aVar.qK());
                }
            }
            arrayList = arrayList2;
        }
        rVar.boN = arrayList;
        return rVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.RY = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.w.r(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.RZ.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qJ() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Sa;
        private String Sb;
        private long Sc;
        private String Sd;
        private String Se;
        private int tag;
        private int type;

        public long qJ() {
            return this.Sa;
        }

        public String getTopicName() {
            return this.Sb;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Sa = recomTopicList.topic_id.longValue();
                this.Sb = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Sc = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Sd = recomTopicList.topic_desc;
                this.Se = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.q qK() {
            com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
            qVar.tag = this.tag;
            qVar.desc = this.Sd;
            qVar.Sa = this.Sa;
            qVar.Sb = this.Sb;
            return qVar;
        }
    }
}
