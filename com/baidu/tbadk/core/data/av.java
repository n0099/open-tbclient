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
    private String Yi;
    private List<a> Yj = new ArrayList();

    public String qF() {
        return StringUtils.isNull(this.Yi) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.Yi;
    }

    public com.baidu.tieba.card.data.p qG() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.cep = qF();
        if (this.Yj != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Yj) {
                if (aVar != null) {
                    arrayList2.add(aVar.qI());
                }
            }
            arrayList = arrayList2;
        }
        pVar.ceq = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Yi = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.v(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Yj.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qH() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Yk;
        private String Yl;
        private long Ym;
        private String Yn;
        private String Yo;
        private int tag;
        private int type;

        public long qH() {
            return this.Yk;
        }

        public String getTopicName() {
            return this.Yl;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Yk = recomTopicList.topic_id.longValue();
                this.Yl = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Ym = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Yn = recomTopicList.topic_desc;
                this.Yo = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qI() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.Yn;
            oVar.Yk = this.Yk;
            oVar.Yl = this.Yl;
            return oVar;
        }
    }
}
