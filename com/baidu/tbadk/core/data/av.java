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
    private String aNN;
    private List<a> aNO = new ArrayList();

    public String yH() {
        return StringUtils.isNull(this.aNN) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.aNN;
    }

    public com.baidu.tieba.card.data.o yI() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.dar = yH();
        if (this.aNO != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aNO) {
                if (aVar != null) {
                    arrayList2.add(aVar.yK());
                }
            }
            arrayList = arrayList2;
        }
        oVar.das = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aNN = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.D(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aNO.add(aVar);
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
        private long aNP;
        private String aNQ;
        private long aNR;
        private String aNS;
        private String aNT;
        private int tag;
        private int type;

        public long yJ() {
            return this.aNP;
        }

        public String getTopicName() {
            return this.aNQ;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aNP = recomTopicList.topic_id.longValue();
                this.aNQ = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aNR = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aNS = recomTopicList.topic_desc;
                this.aNT = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n yK() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.aNS;
            nVar.aNP = this.aNP;
            nVar.aNQ = this.aNQ;
            return nVar;
        }
    }
}
