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
    private String aNO;
    private List<a> aNP = new ArrayList();

    public String yH() {
        return StringUtils.isNull(this.aNO) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.aNO;
    }

    public com.baidu.tieba.card.data.o yI() {
        com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
        ArrayList arrayList = null;
        oVar.dav = yH();
        if (this.aNP != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aNP) {
                if (aVar != null) {
                    arrayList2.add(aVar.yK());
                }
            }
            arrayList = arrayList2;
        }
        oVar.daw = arrayList;
        return oVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aNO = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.D(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aNP.add(aVar);
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
        private long aNQ;
        private String aNR;
        private long aNS;
        private String aNT;
        private String aNU;
        private int tag;
        private int type;

        public long yJ() {
            return this.aNQ;
        }

        public String getTopicName() {
            return this.aNR;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.aNQ = recomTopicList.topic_id.longValue();
                this.aNR = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.aNS = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.aNT = recomTopicList.topic_desc;
                this.aNU = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.n yK() {
            com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
            nVar.tag = this.tag;
            nVar.desc = this.aNT;
            nVar.aNQ = this.aNQ;
            nVar.aNR = this.aNR;
            return nVar;
        }
    }
}
