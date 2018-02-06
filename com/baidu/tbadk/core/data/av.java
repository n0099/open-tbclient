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
    private String aNY;
    private List<a> aNZ = new ArrayList();

    public String yH() {
        return StringUtils.isNull(this.aNY) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.aNY;
    }

    public com.baidu.tieba.card.data.o yI() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.daF = yH();
        if (this.aNZ != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aNZ) {
                if (aVar != null) {
                    arrayList2.add(aVar.yK());
                }
            }
            arrayList = arrayList2;
        }
        oVar.daG = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aNY = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.D(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aNZ.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.yJ() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long aOa;
        private String aOb;
        private long aOc;
        private String aOd;
        private String aOe;
        private int tag;
        private int type;

        public long yJ() {
            return this.aOa;
        }

        public String getTopicName() {
            return this.aOb;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aOa = recomTopicList.topic_id.longValue();
                this.aOb = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aOc = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aOd = recomTopicList.topic_desc;
                this.aOe = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n yK() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.aOd;
            nVar.aOa = this.aOa;
            nVar.aOb = this.aOb;
            return nVar;
        }
    }
}
